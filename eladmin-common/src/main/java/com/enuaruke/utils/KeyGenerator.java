package com.enuaruke.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: 05
 * @date: 2022-11-22 10:35
 */
public class KeyGenerator {
    private KeyGenerator(){};
    public static String generateKeys(){
        String key = null;
        char[] keyChar = {
                'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
                '0','1','2','3','4','5','6','7','8','9'
        };
        String keyHead = RandomStringUtils.random(9, keyChar);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        String dateStr = sdf.format(date);
        String keyTail = RandomStringUtils.random(9, keyChar);
        key = keyHead+dateStr+keyTail;
        return key;
    }
}
