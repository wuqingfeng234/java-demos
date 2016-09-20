package com.huawei.wuqf.main;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.File;
import java.io.IOException;

/**
 * Created by wuqf on 16-9-19.
 */
public class UploadFile {
    public static void main(String[] args) throws ClientProtocolException, IOException {
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost post = new HttpPost("http://192.168.1.7:8080/uploadfiles");//创建 HTTP POST 请求
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);//设置浏览器兼容模式
        File f1=new File("/home/wuqf/Documents/svn/b.txt");
        FileBody fb1 = new FileBody(f1);//把文件转换成流对象FileBody
        builder.addPart("file1", fb1);

        File f2=new File("/home/wuqf/Documents/svn/a.pdf");
        FileBody fb2 = new FileBody(f2);//把文件转换成流对象FileBody
        builder.addPart("file1", fb2);

        HttpEntity entity = builder.build();// 生成 HTTP POST 实体
        post.setEntity(entity);//设置请求参数
        HttpResponse response = httpclient.execute(post);// 发起请求 并返回请求的响应
        if (response.getStatusLine().getStatusCode() == 200) {
            System.out.println("success");
        }
        System.out.println("error");
    }
}
