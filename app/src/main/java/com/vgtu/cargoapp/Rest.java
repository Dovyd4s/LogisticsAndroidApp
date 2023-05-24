package com.vgtu.cargoapp;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Rest {
    private static BufferedWriter bufferedWriter;
    private static OutputStream outputStream;

//    public static String sendGet(String urlGet) throws IOException {
//        URL url = new URL(urlGet);
//        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
//        httpURLConnection.setRequestMethod("GET");
//        httpURLConnection.setRequestProperty("Content-type", "application/json; charset=UTF-8");
//        int code = httpURLConnection.getResponseCode();
//        System.out.println("GET CODE ReceiVEd: " + code);
//
//        if(code == HttpURLConnection.HTTP_OK){
//            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
//            String line;
//            StringBuilder response = new StringBuilder();
//
//            if ((line=in.readLine()) != null){
//                response.append(line);
//            }
//            in.close();
//            return response.toString();
//        }else {
//            return "Get no good";
//        }
//    }

    public static String sendRequestWithBody(String requestUrl, String bodyParameters, String type) throws IOException {
        URL url = new URL(requestUrl);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod(type);
        httpURLConnection.setRequestProperty("Content-type", "application/json; charset=UTF-8");

        httpURLConnection.setReadTimeout(20000);
        httpURLConnection.setConnectTimeout(20000);
        httpURLConnection.setRequestProperty("Accept", "application/json");

        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);

        outputStream = httpURLConnection.getOutputStream();
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
        bufferedWriter.write(bodyParameters);
        bufferedWriter.close();
        outputStream.close();
        int code = httpURLConnection.getResponseCode();

        if (code == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            in.close();
            return response.toString();
        } else {
            return "Error";
        }
    }
    public static String sendRequest(String requestUrl, String type) throws  IOException {
        URL url = new URL(requestUrl);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod(type);
        httpURLConnection.setRequestProperty("Content-type", "application/json; charset=UTF-8");
        int code = httpURLConnection.getResponseCode();

        if (code == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            in.close();
            return response.toString();
        } else {
            return "Error";
        }
    }
    public static String sendPost(String urlPost, String postDataParameters)throws IOException{
        URL url = new URL(urlPost);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setReadTimeout(20000);
        httpURLConnection.setConnectTimeout(20000);
        httpURLConnection.setRequestProperty("Content-type", "application/json; charset=UTF-8");
        httpURLConnection.setRequestProperty("Accept", "application/json");
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        System.out.println(postDataParameters);
        outputStream = httpURLConnection.getOutputStream();
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
        bufferedWriter.write(postDataParameters);
        bufferedWriter.close();
        outputStream.close();

        int code = httpURLConnection.getResponseCode();
        System.out.println(code);

        if(code == httpURLConnection.HTTP_OK){
            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String line;
            StringBuffer response = new StringBuffer();

            if ((line=in.readLine()) != null){
                response.append(line);
            }
            in.close();
            return response.toString();
        }else{
            return "POST No Good";
        }

    }
}
