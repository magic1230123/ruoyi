package com.magic.ruoyiapi.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 1
 */
public class MobileUtils {
	private final static String PHONE = "^((13[0-9])|(14[0-9])|(15[^4,\\D])|16[6]|(17[0-9])|(18[0-9])|(19[8-9]))\\d{8}$";
    private final static String ALGORITHM_STR = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwx";

    /**
     * 手机号码校验
     * @param mobiles
     * @return
     */
    public static boolean isMobileNo(String mobiles) {
        if (mobiles == null){
            return false;
        }
        if (mobiles.length()!=11){
            return false;
        }
        return true;
//		Pattern p = Pattern.compile(PHONE);
//		Matcher m = p.matcher(mobiles);
//		return m.matches();
	}

    /**
     * 手机号码脱敏
     * @param phone
     * @return
     */
    public static String toumin(String phone) {
        return phone.substring(0, 3) + "****" + phone.substring(7, phone.length());
    }

    /**
     * 手机号码脱敏
     * @param mobile
     * @return
     */
    public static String showMobile(String mobile) {
        return mobile == null ? null : mobile.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
    }

    /**
     * 手机号码加密
     *
     * @param phone
     */
    public static String encrypt(String phone) {
        char[] a = phone.toCharArray();
        for (int i = 0; i < a.length; i++) {
            a[i] = (char) (a[i] ^ 'z');
        }
        String s = new String(a);
        return s;
    }

    public static void main(String[] args) {
        System.out.println(isMobileNo("15205560195"));
        System.out.println(isMobileNo("13005560195"));
        System.out.println(isMobileNo("14005560195"));
        System.out.println(isMobileNo("19905560195"));
        System.out.println(isMobileNo("19805560195"));
        System.out.println(isMobileNo("19705560195"));
//        System.out.println(encrypt("19905560195"));
//        System.out.println(encrypt(encrypt("19905560195")));
    }
}
