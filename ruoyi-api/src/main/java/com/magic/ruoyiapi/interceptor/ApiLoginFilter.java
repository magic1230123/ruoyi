package com.magic.ruoyiapi.interceptor;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;


@CrossOrigin
public class ApiLoginFilter implements HandlerInterceptor {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private RedisTemplate redisTemplate;

    private static Set<String> stringSet =  new HashSet<>();
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if("OPTIONS".equals(request.getMethod())){
            return true;
        }
        String host = getIPAddress(request);
        if (stringSet.contains(host)){
            response.sendError(403);
            return false;
        }
        String key = "ip_"+host;
        redisTemplate.opsForValue().increment(key+"_"+request.getRequestURI(),1);
        Long curnum = redisTemplate.opsForValue().increment(key,1);
        Long cursecond = redisTemplate.getExpire(key, TimeUnit.SECONDS);
        if(cursecond == -1 || cursecond> 20){
            redisTemplate.opsForValue().set(key,redisTemplate.opsForValue().get(key),20, TimeUnit.SECONDS);
        }
        if(curnum > 100){
            stringSet.add(host);
            response.sendError(403);
            return false;
        }
        logger.info("host : " + host);
        logger.info("method:{}",request.getMethod());
        logger.info(request.getRequestURI());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    //    private static final String UNKNOW = "unknow";
    public static String getIPAddress(HttpServletRequest request) {
        String ip = null;

        //X-Forwarded-For???Squid ????????????
        String ipAddresses = request.getHeader("X-Forwarded-For");

        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            //Proxy-Client-IP???apache ????????????
            ipAddresses = request.getHeader("Proxy-Client-IP");
        }

        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            //WL-Proxy-Client-IP???weblogic ????????????
            ipAddresses = request.getHeader("WL-Proxy-Client-IP");
        }

        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            //HTTP_CLIENT_IP????????????????????????
            ipAddresses = request.getHeader("HTTP_CLIENT_IP");
        }

        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            //X-Real-IP???nginx????????????
            ipAddresses = request.getHeader("X-Real-IP");
        }

        //???????????????????????????????????????????????????ip?????????????????????????????????????????????,?????????????????????????????????ip?????????????????????IP
        if (ipAddresses != null && ipAddresses.length() != 0) {
            ip = ipAddresses.split(",")[0];
        }

        //???????????????????????????????????????request.getRemoteAddr();??????
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
