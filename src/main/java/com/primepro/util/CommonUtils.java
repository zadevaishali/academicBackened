package com.primepro.util;


import org.mindrot.jbcrypt.BCrypt;

import java.util.Random;

public class CommonUtils {
    public static String hashPassword(String plainPassword) {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
    }

    // Method to check a password
    public static boolean checkPassword(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }
//    public  static String generateCode(String brandName) {
//        StringBuilder code = new StringBuilder();
//        // Generate 3 random letters
//        Random random = new Random();
//        for (int i = 0; i < 3; i++) {
//            code.append(brandName.charAt(i));
//        }
//        // Generate 5 random digits
//        for (int i = 0; i < 5; i++) {
//            code.append(random.nextInt(10));
//        }
//
//        return code.toString();
//    }
}