package com.enuaruke.mercury.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author: 05
 * @date: 2022-10-02 18:12
 */
@Configuration
public class MercuryConfig{
    public static String AESkey;

    public String getAESkey() {
        return AESkey;
    }

    @Value("${mercury.aes.key: Enu}")
    public void setAESkey(String AESkey) {
        MercuryConfig.AESkey = AESkey;
    }
}
