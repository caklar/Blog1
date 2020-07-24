package com.blog.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @program: Blog1
 * @description: double-sha256加密
 * @author: BIG_TRUCK li zonglin
 * @create: 2020-07-22 09:21
 **/

public class EncryptService {

    /**
    * @description: 验证加密，双sha256，正确返回true
    * @author: BIG_TRUCK li zonglin
    **/
    public boolean double_SHA256(String str){

        String res = "af465230f73363847a2ce9ca6035d4a6e9049180f212a8aedf3fc72d7c9ff75c";

        if(res.equals(SHA(SHA(str, "SHA-256"), "SHA-256"))){
            return true;
        }

        return false;
    }

    private String SHA(final String str, final String strType){

        String strres = null;

        if(str != null && str.length() > 0 ){

            try{

                MessageDigest messageDigest = MessageDigest.getInstance(strType);

                messageDigest.update(str.getBytes());

                byte bytebuff[] = messageDigest.digest();

                StringBuffer strhex = new StringBuffer();

                for(int i=0; i<bytebuff.length; i++){

                    String hex = Integer.toHexString(0xff & bytebuff[i]);

                    if(hex.length() == 1){
                        strhex.append('0');
                    }
                    strhex.append(hex);
                }

                strres = strhex.toString();


            } catch (NoSuchAlgorithmException e) {

                e.printStackTrace();

            }

        }

        return strres;
    }

}
