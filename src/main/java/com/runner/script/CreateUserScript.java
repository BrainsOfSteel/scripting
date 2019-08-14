package com.runner.script;

import Util.PostCallAndData;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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

//        borrowBook(10L, "barcode1");
        payDues(10L, 40.0, Arrays.asList(3L,4L));
    }
    static void payDues(Long userId, Double amount, List<Long> paymentIds){
        String url = "http://localhost:8080/user/payDues/"+userId+"/"+amount;
        String csPayIds = "";
        for(int i=0;i<paymentIds.size();i++){
            if(i == paymentIds.size()-1){
                csPayIds = csPayIds+paymentIds.get(i);
            }
            else{
                csPayIds = csPayIds + paymentIds.get(i)+",";
            }
        }

        url = url + "?paymentId="+csPayIds;
        PostCallAndData.makeGetCall(url);


    }

    static void borrowBook(Long userId, String barcode){
        String url = "http://localhost:8080/user/borrowBook/"+userId+"/"+barcode;
        PostCallAndData.makeGetCall(url);
    }
}
