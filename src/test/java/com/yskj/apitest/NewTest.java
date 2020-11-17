package com.yskj.apitest;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.yskj.TestPlatformApplication;
import com.yskj.dao.ApiMapper;
import com.yskj.domain.Api;
import com.yskj.service.ApiService;
import com.yskj.service.ApiServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


//@RunWith(SpringRunner.class)
//@SpringBootTest
//@SpringBootTest(classes = ApiServiceImpl.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Component
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class NewTest {
    @Autowired
    private ApiService apiService;
    @Autowired
    public ApiMapper apimapper;

    public static NewTest newtest;

    @PostConstruct //通过@PostConstruct实现初始化bean之前进行的操作
    public void init() {
        newtest = this;
        newtest.apiService = this.apiService;
        // 初使化时将已静态化的testService实例化
    }

//    public void setMailService(ApiService apiService) {
//
//        this.apiService = apiService;
//
//    }

    @Test
    public void test() {
//    	testUtils.itemMapper.insert(api);
//    	testUtils.itemService.queryAll();
//        newtest.apiService.listByAll();
//    	apiService.listByAll();
//    	newtest.apimapper.insert(api);
    }


//    @Test
//    public void testMybatisQuery() {
//        List list = newtest.apiService.listByAll();
//        System.out.println(list);
//    }

    // 帮详情接口验证
//    @Test
//	 public  String sendSms(String url,String expect,String param){	 
////			System.out.println("11111111111111111111111111111");
////			List<Api> api=apiService.listByAll();
////			System.out.println(api+"*********************************");
////		
//	        // 创建HttpClientBuilder
//	        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
//	        // HttpClient
//	        CloseableHttpClient httpclient = httpClientBuilder.build();
//	        String smsUrl="http://59.38.123.2/bang-index/list?v=4&bid=8184&mvc=1&p=1&ps=25&order=4&client_flag=lmbang&client_ver=7.6.30";
//	        HttpPost httppost = new HttpPost(smsUrl);
//	        HttpPost httpget = new HttpPost(smsUrl);
//	        String strResult = "";
//	 
//	        try {
//	            HttpResponse response = httpclient.execute(httpget);
//	            String respContent = null;
//	            
//	            Assert.assertEquals(200, response.getStatusLine().getStatusCode());
//	            
//	            
//	            if (response.getStatusLine().getStatusCode() == 200) {
//					/*读返回数据*/
//	            	String returnStr = EntityUtils.toString(response.getEntity());
//	            	JSONObject jsonObj = JSONObject.fromObject(returnStr);
//	            	JSONObject resultobj = jsonObj.getJSONObject("data");
//	            	JSONArray tag_list = resultobj.getJSONArray("tag_list");
//	            	
//	            	for(Object object:tag_list){
//	            	    JSONObject list = (JSONObject)object;
//	            	    list.getString("tagid");
//	            	    list.getString("tag"); 
//	            	    System.out.println(list);
//	            	    System.out.println(list.getString("tagid")+list.getString("tag"));
//	            	}
//	            } else {
//	                String err = response.getStatusLine().getStatusCode()+"";
//	                strResult += "发送失败:"+err;
//	            }
//	            System.out.println(strResult+"############################");
//	        } catch (ClientProtocolException e) {
//	            e.printStackTrace();
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        }
//	 
//	        return strResult;
//	    }
//	

//	@Autowired
//    @Test
//    public void fff() {
//    	System.out.println("11111111111111111111111111111");
////		List<Api> api=apiService.listByAll();
////		System.out.println(api+"*********************************");
//	
//        // 创建HttpClientBuilder
//        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
//        // HttpClient
//        CloseableHttpClient httpclient = httpClientBuilder.build();
//        String smsUrl="http://59.38.123.2/bang-index/list?v=4&bid=8184&mvc=1&p=1&ps=25&order=4&client_flag=lmbang&client_ver=7.6.30";
//        HttpPost httppost = new HttpPost(smsUrl);
//        HttpPost httpget = new HttpPost(smsUrl);
//        String strResult = "";
// 
//        try {
//            HttpResponse response = httpclient.execute(httpget);
//            String respContent = null;
//            
//            Assert.assertEquals(200, response.getStatusLine().getStatusCode());
//            
//            
//            if (response.getStatusLine().getStatusCode() == 200) {
//				/*读返回数据*/
//            	String returnStr = EntityUtils.toString(response.getEntity());
//            	JSONObject jsonObj = JSONObject.fromObject(returnStr);
//            	JSONObject resultobj = jsonObj.getJSONObject("data");
//            	JSONArray tag_list = resultobj.getJSONArray("tag_list");
//            	
//            	for(Object object:tag_list){
//            	    JSONObject list = (JSONObject)object;
//            	    list.getString("tagid");
//            	    list.getString("tag"); 
//            	    System.out.println(list);
//            	    System.out.println(list.getString("tagid")+list.getString("tag"));
//            	}
//            } else {
//                String err = response.getStatusLine().getStatusCode()+"";
//                strResult += "发送失败:"+err;
//            }
//            System.out.println(strResult+"############################");
//        } catch (ClientProtocolException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    


//    @Test
//    public void a() {
//    	System.out.println("********************");
//    }
//  @Test(dataProvider = "ApiMapper")
//  public void f(Integer n, String s) {
//  }

//  @DataProvider
//  public Object[][] dp() {
//    return new Object[][] {
//      new Object[] { 1, "a" },
//      new Object[] { 2, "b" },
//    };
//  }
}
