package com.magic.ruoyiapi.contants;

/**
 * @author 林锋
 * @email 904303298@qq.com
 * @create 2018-09-19 13:10
 **/
public interface SystemConstans {
    /**
     * 默认密码
     **/
    String INIT_PASSWORD = "000000";

    /**
     * session
     **/
    interface Role {
        /**  管理员 **/
        String ADMIN = "Admin";
        /** 经理 **/
        String MANAGER = "Manager";
        /** 商务 **/
        String BUSINESS = "Business";
        /** 财务 **/
        String FINANCE = "Finance";
        /** 运营 **/
        String OPERATER = "Operater";
        /** 渠道商 **/
        String CHANNEL = "Channel";
        /**自定义**/
        String CUSTOM= "Custom";
    }

    /**
     * 短信
     * 0-通用 1-注册 2-登陆
     */
    interface Sms {

        /**手机号验证上锁时间**/
        long ONE_PHONE_LOCK_TIME = 24 * 60 * 60;
        long ONE_IP_LOCK_TIME = 24 * 60 * 60;

        /**手机号最大次数**/
        int PHONE_MAX = 5;
        /**Ip最大次数**/
        int IP_MAX = 5;

        /**最大时间间隔**/
        long INTERVAL_TIME = 60 * 1000;
        /**有效时长**/
        long VALID_TIME = 60 * 10;

        Integer COMMON = 0;
        Integer REGISTER = 1;
        Integer LOGIN = 2;
        Integer SMS_LOGIN = 3;

        /** 类型 **/
        String[] TYPE = {"Common", "Register", "Login", "SmsLogin"};

        /** 短信文案 **/
        String[] TEXT = {
                "您的验证码为XXXX，有效期10分钟。",
                "您的注册验证码为XXXX，有效期10分钟，请及时注册。",
                "您的登录验证码：XXXX，有效期10分钟，请妥善保管。",
                "您的注册登录验证码为XXXX，有效期10分钟，请及时登录。"
        };
    }

    /**
     * 产品链接转换方式
     */
    interface ProductConvertMode{

        /**
         * 重定向
         */
        String REDIRECT = "redirect";

        /**
         * 编码
         */
        String ENCODE = "encode";
    }

    /****
     * 用户行为
     */
    interface UserAction{
        String REGISTER = "Register";

        String LOGIN = "Login";
    }
}
