package com.coder520.common.utils;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by zrkj on 2017/7/29.
 */
public class SecurityUtils {

    public static String encrptyPassword(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64Encoder = new BASE64Encoder();
        String result = base64Encoder.encode(md5.digest(password.getBytes("utf-8")));

        return result;
    }

    public static boolean checkPassword(String inputPwd, String dbPwd) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String result = encrptyPassword(inputPwd);
        if (result.equals(dbPwd)){
            return true;
        }else {
            return false;
        }
    }

}
