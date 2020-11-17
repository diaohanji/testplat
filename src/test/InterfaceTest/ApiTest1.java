package com.yskj.InterfaceTest;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.yskj.domain.Api;
import com.yskj.service.ApiService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;


//@EnableAutoConfiguration
//@RunWith(SpringRunner.class)
//@SpringBootTest
@Component
//@SpringBootTest
//@RunWith(SpringJUnit4ClassRunner.class)
//@Configuration

public class ApiTest1 {

//	@Autowired
//	ApiService apiService;

//	
//	/**拼接url
//	 */
// 
//	public  String geturl() {
//		return "";
//	}


    // 注入JdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public List<Api> queryContent(Map map) {
        String sql = "select * from api";
        return jdbcTemplate.query(sql, new RowMapper<Api>() {

            public Api mapRow(ResultSet rs, int rowNum)
                    throws SQLException {
                Api api = new Api();
                api.setApiid(rs.getInt("apiid"));
                api.setApiurl(rs.getString("apiurl"));
                System.out.println(api);
                return api;
            }
        });
    }


    //
    // 帮详情接口验证
    @Test
    public String sendSms(String url, String expect, String param) {

        List<Api> api = apiService.listByAll();
        System.out.println(api + "*********************************");

        // 创建HttpClientBuilder
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        // HttpClient
        CloseableHttpClient httpclient = httpClientBuilder.build();
        String smsUrl = "http://59.38.123.2/bang-index/list?v=4&bid=8184&mvc=1&p=1&ps=25&order=4&client_flag=lmbang&client_ver=7.6.30";
        HttpPost httppost = new HttpPost(smsUrl);
        HttpPost httpget = new HttpPost(smsUrl);
        String strResult = "";

        try {
            HttpResponse response = httpclient.execute(httpget);
            String respContent = null;

            Assert.assertEquals(200, response.getStatusLine().getStatusCode());


            if (response.getStatusLine().getStatusCode() == 200) {
                /*读返回数据*/
                String returnStr = EntityUtils.toString(response.getEntity());
                JSONObject jsonObj = JSONObject.fromObject(returnStr);
                JSONObject resultobj = jsonObj.getJSONObject("data");
                JSONArray tag_list = resultobj.getJSONArray("tag_list");

                for (Object object : tag_list) {
                    JSONObject list = (JSONObject) object;
                    list.getString("tagid");
                    list.getString("tag");
                    System.out.println(list);
                    System.out.println(list.getString("tagid") + list.getString("tag"));
                }
            } else {
                String err = response.getStatusLine().getStatusCode() + "";
                strResult += "发送失败:" + err;
            }
            System.out.println(strResult + "############################");
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return strResult;
    }


}
