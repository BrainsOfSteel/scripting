package com.runner.script;

import Util.PostCallAndData;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateUserScript {
    public static void main(String[] args) {
        String userNamePrefix = "USER_NAME_";
        String userIdPrefix = "USER_ID_";
        String emailSuffix = "@gmail.com";
        String url = "http://localhost:8080/user/createUser";
        long currentDateTime = System.currentTimeMillis()- 100 * 24 * 60 * 60* 1000L;
//        for(int i=1;i<=50;i++){
//            Date currentDate = new Date(currentDateTime);
//            DateFormat df = new SimpleDateFormat("dd-MM-yy");
//            System.out.println("Milliseconds to Date: " + df.format(currentDate));
//            String dob = df.format(currentDate);
//            currentDateTime = currentDateTime + 24 * 60 * 60* 1000L;
//            String userCreationJson = "{\n" +
//                    "\t\"name\":"+"\""+userNamePrefix+i+"\""+",\n" +
//                    "    \"userId\":"+"\""+userIdPrefix+i+"\""+",\n" +
//                    "    \"email\":"+"\""+userIdPrefix+i+emailSuffix+"\""+",\n" +
//                    "    \"dob\":"+"\""+dob+"\""+"\n" +
//                    "}";
//            PostCallAndData.makePostCall(userCreationJson, url);
//        }

        borrowBook(10L, "barcode1");

    }

    static void borrowBook(Long userId, String barcode){
        String url = "http://localhost:8080/user/borrowBook/"+userId+"/"+barcode;
        PostCallAndData.makeGetCall(url);
    }
}
