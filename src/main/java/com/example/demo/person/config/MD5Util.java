package com.example.demo.person.config;

import java.nio.charset.Charset;
import java.security.MessageDigest;

/**
 * Created by huangmy on 2018/7/6
 */
public class MD5Util {

    public synchronized static String encryptMD5(String password) throws Exception {
        Charset utf8 = Charset.forName("UTF-8");
        StringBuilder builder = new StringBuilder();
        try {

            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(password.getBytes(utf8));
            byte[] bytes = md5.digest();
            for (int i = 0; i < bytes.length; i++) {
                String hex = Integer.toHexString(0xff & bytes[i]);
                if (hex.length() == 1)
                    builder.append('0');
                builder.append(hex);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        return builder.toString();
    }
}
