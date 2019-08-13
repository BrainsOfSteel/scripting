package com.runner.script;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

public class Scripts1 {
    public static void main(String[] args) throws Exception {
        String bookPrefix = "Book";
        String bookTypePrefix = "BookType";
        String authorPrefix = "Author";
        String barcodePrefix = "barcode";
        int barcodeCount=1;
        for(int i=0;i<=20;i++){
            createBookAndAuthors(bookPrefix+i, bookTypePrefix+i, authorPrefix + i);
            for(int j=0;j<20;j++){
                createBookAndInventory(bookPrefix+i, bookTypePrefix+i, barcodePrefix+barcodeCount);
                barcodeCount++;
            }
        }
    }

    private static void createBookAndInventory(String bookTitle, String bookType, String barcode) throws Exception{
        String jsonInputString = "{\n" +
                "\t\"bookType\":"+ "\""+bookType +"\"" +",\n" +
                "    \"bookTitle\":"+ "\""+ bookTitle + "\""+",\n" +
                "    \"barcode\":"+ "\""+ barcode+"\"" +"\n" +
                "}";

        StringEntity entity = new StringEntity(jsonInputString,
                ContentType.APPLICATION_JSON);

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost request = new HttpPost("http://localhost:8080/admin/addBookInventory");
        request.setEntity(entity);

        HttpResponse response = httpClient.execute(request);
        System.out.println(response.getStatusLine().getStatusCode());

    }

    private static void createBookAndAuthors(String bookTitle, String bookType, String author) throws Exception {
        String jsonInputString = "{\n" +
                "\t\"bookTitle\":"+"\""+bookTitle+"\"" + ",\n" +
                "    \"authorName\":"+ "\""+ author+"\""+ ",\n" +
                "    \"bookType\":" + "\""+bookType+"\"" +"\n" +
                "}";

        System.out.println(jsonInputString);
        StringEntity entity = new StringEntity(jsonInputString,
                ContentType.APPLICATION_JSON);

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost request = new HttpPost("http://localhost:8080/admin/addBookAndAuthor");
        request.setEntity(entity);

        HttpResponse response = httpClient.execute(request);
        System.out.println(response.getStatusLine().getStatusCode());
    }
}
