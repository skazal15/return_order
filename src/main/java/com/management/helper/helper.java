package com.management.helper;

import java.util.Random;
public class helper {
    
    public static String generateRandomString(String orderId){
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder randomString = new StringBuilder();

        Random random = new Random();
        for (int i=0; i<3;i++){
            int index = random.nextInt(characters.length());
            randomString.append(characters.charAt(index));
        }
        String randoms = randomString.toString()+"-"+orderId;

        return randoms;
    }
}