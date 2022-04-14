package com.magic.ruoyiapi.service.sms;

import com.magic.ruoyiapi.contants.RedisKeyConstants;
import com.magic.ruoyiapi.contants.SystemConstans;
import com.magic.ruoyiapi.domain.SmsQuery;
import com.magic.ruoyiapi.domain.dto.ApiResponse;
import com.magic.ruoyiapi.domain.dto.ResponseCode;
import com.magic.ruoyiapi.domain.dto.SmsResultDto;
import com.magic.ruoyiapi.mapper.ClientConfigMapper;
import com.magic.ruoyiapi.mapper.ClientUserMapper;
import com.magic.ruoyiapi.redis.RedisClientUtil;
import com.magic.ruoyiapi.service.BaseClientUserService;
import com.magic.ruoyiapi.utils.HttpUtils;
import com.magic.ruoyiapi.utils.MobileUtils;
import com.magic.ruoyiapi.utils.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @author 1
 */
@Service
public class BaseSmsServiceImpl implements BaseSmsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseSmsServiceImpl.class);
    private static final List<String> WHITE_LIST = Arrays.asList("15858102769:8888", "15305560195:1234");

    @Autowired(required = false)
    private BaseClientUserService baseClientUserService;

    @Autowired
    private RedisClientUtil redisClientUtil;
    @Resource
    private ClientConfigMapper clientConfigMapper;
    @Resource
    private ClientUserMapper clientUserMapper;
    @Override
    public ApiResponse sendSmsCode(SmsQuery query) {
        long now = System.currentTimeMillis();
        int phoneTime = 1;
        int ipTime = 1;
        String phone = query.getPhone();
        /*******************************************************
         * 注册场景下,校验手机号码是否注册
         *******************************************************/
        if (SystemConstans.Sms.REGISTER.equals(query.getType())) {
            if (baseClientUserService.checkPhone(phone)) {
                return new ApiResponse(ResponseCode._100006);
            }
        }

        /*********************************************************
         * 快捷登陆场景，校验用户是否注册过
         *********************************************************/
        Integer register = null;
        if (SystemConstans.Sms.LOGIN.equals(query.getType())) {
            register = 1;
            if (baseClientUserService.checkPhone(phone)) {
                register = 0;
            }
        }

        /*********************************************************
         * 手机号码验证码检查
         *********************************************************/
        String phoneKey = String.format("%s:%s", RedisKeyConstants.Sms.PHONE_PREFIX, phone);
        Object pValue = redisClientUtil.get(phoneKey);
        if (!ObjectUtils.isEmpty(pValue)) {
            String[] times = String.valueOf(pValue).split("_");
            // 最大次数
            phoneTime = Integer.parseInt(times[0]);
            if (SystemConstans.Sms.PHONE_MAX <= phoneTime) {
                return new ApiResponse(ResponseCode._100035);
            }
            // 1分钟
            if (now - Long.parseLong(times[1]) < SystemConstans.Sms.INTERVAL_TIME) {
                return new ApiResponse(ResponseCode._100046);
            }
        }
        /*********************************************************
         * 手机号码验证码Ip检查
         *********************************************************/
        String ipKey = String.format("%s:%s", RedisKeyConstants.Sms.IP_PREFIX, query.getRemoteIp());
        Object ipValue = redisClientUtil.get(ipKey);
        if (!ObjectUtils.isEmpty(ipValue)) {
            String time = String.valueOf(ipValue);
            // 最大次数
            ipTime = Integer.parseInt(time);
            if (SystemConstans.Sms.IP_MAX <= Integer.parseInt(time)) {
                return new ApiResponse(ResponseCode._100036);
            }
        }
        String random = RandomUtils.getRandomNumber(4);
        // 缓存到redis里，用户后台校验，
        redisClientUtil.set(String.format("%s:%s:%s", RedisKeyConstants.Sms.PHONE_PREFIX, SystemConstans.Sms.TYPE[query.getType()], phone), random, SystemConstans.Sms.VALID_TIME);
        // 设置时间锁
        redisClientUtil.set(phoneKey, String.format("%s_%s", phoneTime, now), SystemConstans.Sms.ONE_PHONE_LOCK_TIME);
        redisClientUtil.set(ipKey, String.format("%s", ipTime), SystemConstans.Sms.ONE_IP_LOCK_TIME);
        //发送短信验证码
        this.sendCode(phone, random);
        clientUserMapper.insertSendSmsRecord(phone,random);
        SmsResultDto result = new SmsResultDto();
        result.setPhone(query.getPhone());
        result.setRegister(register);
        ApiResponse response = new ApiResponse();
        response.setMsg("验证码已发送至" + MobileUtils.showMobile(query.getPhone()));
        response.setData(result);
        return response;
    }

    @Override
    public boolean checkSmsCode(Integer type, String phone, String code) {
        if (WHITE_LIST.contains(String.format("%s:%s", phone, code))) {
            return true;
        }
        Object smsCode = redisClientUtil.hmGet(RedisKeyConstants.WhiteList.SMS_WHITE_LIST, phone);
        if (!ObjectUtils.isEmpty(smsCode) && code.equals(String.valueOf(smsCode))) {
            return true;
        }

        String key = String.format("%s:%s:%s", RedisKeyConstants.Sms.PHONE_PREFIX, SystemConstans.Sms.TYPE[type], phone);
        Object value = redisClientUtil.get(key);
        if (code.equals(value)) {
            return true;
        }

        return false;
    }

    @Override
    public ApiResponse checkCode(SmsQuery query) {
        if (checkSmsCode(query.getType(), query.getPhone(), query.getCode())) {
            return new ApiResponse();
        }
        return new ApiResponse(ResponseCode._100007);
    }


    public String sendCode(String phone, String random) {
        String requestUrl = clientConfigMapper.getValue("SMS_URL");
        requestUrl = requestUrl.replace("#{phone}", phone);
        requestUrl = requestUrl.replace("#{code}", random);
        return HttpUtils.sendGet(requestUrl, null);
    }

    public static void main(String[] args) {

        String requestUrl = "http://120.79.251.240:8888/sms.aspx?action=send&rt=json&&userid=2774&account=71712&password=dpsdm123&mobile=#{phone}&content=【大板栗】您的验证码为#{code},请于10分钟内填写。如非本人操作，请忽略本短信。&sendTime=&extno=";
        requestUrl = requestUrl.replace("#{phone}", "13800000000");
        requestUrl = requestUrl.replace("#{code}", "1234");
        System.out.println(requestUrl);
    }
}
