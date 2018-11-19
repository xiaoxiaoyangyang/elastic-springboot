package com.example.createdata.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtil {
    private static Logger logger=LoggerFactory.getLogger(HttpUtil.class);

    public static String get(String url) throws IOException {
        URL ul = new URL(url);
        HttpURLConnection conn = (HttpURLConnection)ul.openConnection();
        // 设置通用的请求属性
        conn.setRequestProperty("accept", "*/*");
        conn.setRequestProperty("connection", "Keep-Alive");
        conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
        // 建立实际的连接
        conn.connect();
        int responseCode = conn.getResponseCode();
        InputStream in=null;
        if(responseCode==HttpURLConnection.HTTP_OK){
            in = conn.getInputStream();
        }
        ByteArrayOutputStream baout = new ByteArrayOutputStream();
        byte[] buff = new byte[1024];
        int len;
        while ((len = in.read(buff)) != -1) {
            baout.write(buff, 0, len);
        }
        String response = new String(baout.toByteArray());
        return response;
    }
    
    public static String put(String url) throws IOException {
        URL ur = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) ur.openConnection();
        // 设置通用的请求属性
        conn.setRequestProperty("accept", "*/*");
        conn.setRequestProperty("connection", "Keep-Alive");
        conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
        conn.setRequestMethod("PUT");
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setUseCaches(false);
        conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");//设置参数类型是json格式
        conn.connect();
        String body="{\n" +
                "  \"index\":{\n" +
                "    \"max_result_window\":10000000\n" +
                "  }\n" +
                "}";
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream(), "UTF-8"));
        writer.write(body);
        writer.close();
        int responseCode = conn.getResponseCode();
        InputStream in=null;
        if(responseCode==HttpURLConnection.HTTP_OK){
            in=conn.getInputStream();
        }
        ByteArrayOutputStream baout = new ByteArrayOutputStream();
        byte[] buff = new byte[1024];
        int len;
        while ((len = in.read(buff)) != -1) {
            baout.write(buff, 0, len);
        }
        String response = new String(baout.toByteArray());
        return response;
    }

    //post请求
    public static String delete(String deleteUrl,String body) throws IOException {
        URL url = new URL(deleteUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        // 设置通用的请求属性
        conn.setRequestProperty("accept", "*/*");
        conn.setRequestProperty("connection", "Keep-Alive");
        conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");//设置参数类型是json格式
        conn.setRequestMethod("DELETE");
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setUseCaches(false);
        conn.connect();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream(), "UTF-8"));
        writer.write(body);
        writer.close();
        int responseCode = conn.getResponseCode();
        InputStream in=null;
        if(responseCode==HttpURLConnection.HTTP_OK){
            in=conn.getInputStream();
        }
        ByteArrayOutputStream baout = new ByteArrayOutputStream();
        byte[] buff = new byte[1024];
        int len;
        while ((len = in.read(buff)) != -1) {
            baout.write(buff, 0, len);
        }
        String response = new String(baout.toByteArray());
        return response;
    }
}
