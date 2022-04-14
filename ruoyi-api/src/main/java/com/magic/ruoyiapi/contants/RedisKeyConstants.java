package com.magic.ruoyiapi.contants;

/**
 * Redis表常量
 *
 * @author 林锋
 * @email 904303298@qq.com
 * @create 2018-03-06 11:04
 **/
public interface RedisKeyConstants {

    /**session**/
    interface Session{
        /**后台用户**/
        String BACKEND_USER_INFO = "BACKEND_USER_SESSION_INFO";
        /**客户端用户**/
        String CLIENT_USER_INFO = "CLIENT_USER_SESSION_INFO";
        /**渠道后台用户**/
        String CHANNEL_USER_INFO = "CHANNEL_USER_SESSION_INFO";
    }

    /**Sms**/
    interface Sms{
        /**phone**/
        String PHONE_PREFIX = "Phone";

        /**IP**/
        String IP_PREFIX = "Ip";

    }

    /**
     * 白名单
     */
    interface WhiteList{
        /**短信验证**/
        String SMS_WHITE_LIST = "SMS_WHITE_LIST";
    }

    interface SysName{
        /**系统名称**/
        String SYS_NAME = "SYSTEM_NAME";
    }

}
