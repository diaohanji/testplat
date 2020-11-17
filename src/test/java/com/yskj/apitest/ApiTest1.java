package com.yskj.apitest;

import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;

public class ApiTest1 {


    private static CloseableHttpClient httpClient = null;

    @BeforeClass
    public static void setUp() {
        httpClient = HttpClients.createDefault();    //创建httpClient
    }

    @AfterClass
    public static void terDown() throws IOException {
        httpClient.close();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    CloseableHttpResponse response;

    //期望与实际比较
    @Test
    public void userQueryWithRegTest3() {
        //执行某个请求
        response = sendHttp();
        String body;
        try {
            body = EntityUtils.toString(response.getEntity());
            response.close();
            System.out.println(body);

            ReadContext ctx = JsonPath.parse(body);
            String actualret = ctx.read("$.ret");
            String actualmsg = ctx.read("$.msg");
            String actualnickname = ctx.read("$.data.nickname");
            String actualusername = ctx.read("$.data.username");
            String actualavatar = ctx.read("$.data.skin.skinid");
            System.out.println(actualret + actualmsg + actualnickname + actualusername + actualavatar);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }    // 得到响应内容
    }

    private CloseableHttpResponse sendHttp() {
        // 创建请求
        HttpGet request = new HttpGet("http://59.38.123.3/user/member/weibologin?v=4&t=weixin&uuid=oVprQsnGM97II7jY50GFOYYB65-g&openid=olzlquHgU5-V95V-XDF596hqV0t0&nickname=%E5%88%81%E5%AF%92%E6%9E%81&localtion=&head=&vendor=vivoX20A&osver=8.1.0&client_flag=lmbang&client_ver=7.6.30&imei=866239031725945&device_id=866239031725945&channel=avivo&os=android&os_type=android&network_type=wifi&op_company=chinamobile&respond_type=1080x2034&IDFV=&IDFA=&timestamp=1545208516&sign=081b23f788640a3a46c669921d04f643");
        try {
            //执行请求
            response = httpClient.execute(request);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return response;
    }

}
