package cn.ssm.utils;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class EmailSendUtil {

    private String apiUser;
    private String apiKey;


    public void send(String email,String num) throws IOException {
        final String url = "http://api.sendcloud.net/apiv2/mail/send";
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httpost = new HttpPost(url);
        List params = new ArrayList();
        // 您需要登录SendCloud创建API_USER，使用API_USER和API_KEY才可以进行邮件的发送。
        params.add(new BasicNameValuePair("apiUser", apiUser));
        params.add(new BasicNameValuePair("apiKey", apiKey));
        params.add(new BasicNameValuePair("from", "SevnCy@aa.com"));
        params.add(new BasicNameValuePair("fromName", ""));
        params.add(new BasicNameValuePair("to", email));
        params.add(new BasicNameValuePair("subject", "来自SendCloud验证邮件！"));
        params.add(new BasicNameValuePair("html","尊敬的用户您好,您当前的验证码为"+num+"请于2分钟内输入,否则超时无效"));

        httpost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
        // 请求
        HttpResponse response = httpclient.execute(httpost);
        // 处理响应
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) { // 正常返回
            // 读取xml文档
            String result = EntityUtils.toString(response.getEntity());
            System.out.println(result);
        } else {
            System.err.println("error");
        }
        httpost.releaseConnection();
    }


    public void setApiUser(String apiUser) {
        this.apiUser = apiUser;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}