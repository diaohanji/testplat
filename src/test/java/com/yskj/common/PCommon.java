package com.yskj.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;
import com.yskj.dao.ApiMapper;
import com.yskj.domain.bug;
import net.sf.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

public class PCommon extends AbstractTestNGSpringContextTests {
    private static CookieStore cookieStore = null;
    //	static HttpClient httpClient =null;
    public static boolean flag = true;
    public static List<Error> errors = new ArrayList<Error>();
    private SqlSession session;
    HttpResponse response = null;


    private static CloseableHttpClient httpClient = null;

    @BeforeClass
    public static void setUp() {
        httpClient = HttpClients.createDefault();    //创建httpClient
    }

    @AfterClass
    public static void terDown() throws IOException {
        httpClient.close();
    }


//	 private static CloseableHttpClient httpClient;

    static {
        cookieStore = new BasicCookieStore();
        httpClient = HttpClients.custom()
                .setDefaultCookieStore(cookieStore)
                .build();
    }


    //获取url及参数拼接
    public String getUrl(String url, String param) {

        String httpUrl = url + "?" + param;
        System.out.println(httpUrl);
        return httpUrl;
    }

    //断言
    @Autowired

    public void verifyEquals(String actual, String expect, String caseActual, String functionpoint, String TestData, String message, int apiid, ApiMapper apiMapper) {
        try {

            Assert.assertEquals(actual, expect, message);
            apiMapper.updateByPrimaryKey_apirunresult_1(apiid, caseActual);
            insertBug(functionpoint, TestData, expect, actual);
            //插入bug表
        } catch (Error e) {
            apiMapper.updateByPrimaryKey_apirunresult_0(apiid, caseActual);
            insertBug(functionpoint, TestData, expect, actual);
            errors.add(e);
            flag = false;
        }
    }

    public static void setCookieStore(HttpResponse httpResponse) {
        System.out.println("----setCookieStore");
        cookieStore = new BasicCookieStore();
        // JSESSIONID  
        String setCookie = httpResponse.getFirstHeader("Set-Cookie").getValue();
        String JSESSIONID = setCookie.substring("JSESSIONID=".length(),
                setCookie.indexOf(";"));
        System.out.println("JSESSIONID:" + JSESSIONID);
        // 新建一个Cookie  
        BasicClientCookie cookie = new BasicClientCookie("JSESSIONID", JSESSIONID);
        cookie.setVersion(0);
        cookie.setDomain("lmbang.com");
        cookie.setPath("/");
        cookieStore.addCookie(cookie);
    }


    public String getJsonData(String allUrl, int apiid, ApiMapper apiMapper, String expectResult, String actualResult, String functionpoint, String testData) {
        String[] str = expectResult.split(";");
        String[] strkeyvalue = null;
        String expectkeyvalue0 = "";
        String expectkeyvalue1 = "";
        String expectkeyvalue2 = "";
        String expectkeyvalue3 = "";
        String expectkeyvalue4 = "";
        for (int i = 0; i < str.length; i++) {
            if (str[i] != "") {
                strkeyvalue = str[i].split("=");
                System.out.println(strkeyvalue);

                response = getResponse(allUrl, apiid, apiMapper, expectResult, actualResult, functionpoint, testData);

                System.out.println(response);

                if (response.getStatusLine().getStatusCode() == 200) {
                    /*读返回数据*/
                    String returnStr;
                    try {
                        returnStr = EntityUtils.toString(response.getEntity());
                        JSONObject jsonObj = JSONObject.fromObject(returnStr);
                        if (jsonObj.has(strkeyvalue[0])) {
                            System.out.println(strkeyvalue[0]);
                        }
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }

//				
//				if(strkeyvalue[0]) {
//					
//				}		
            }
        }
        return null;
    }


    //get请求
    public HttpResponse getResponse(String allUrl, int apiid, ApiMapper apiMapper, String expectResult, String actualResult, String functionpoint, String testData) {
        HttpPost httpget = new HttpPost(allUrl);
        //获取cookie
//        httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
        // 创建HttpClientBuilder
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        // HttpClient
        CloseableHttpClient httpclient = httpClientBuilder.build();
        Map<String, Object> map = new HashMap<String, Object>();

        String strResult = "";
        try {
            HttpGet httpget1 = new HttpGet("http://59.38.123.3/user/member/weibologin?v=4&t=weixin&uuid=oVprQsnGM97II7jY50GFOYYB65-g&openid=olzlquHgU5-V95V-XDF596hqV0t0&nickname=%E5%88%81%E5%AF%92%E6%9E%81&localtion=&head=&vendor=vivoX20A&osver=8.1.0&client_flag=lmbang&client_ver=7.6.30&imei=866239031725945&device_id=866239031725945&channel=avivo&os=android&os_type=android&network_type=wifi&op_company=chinamobile&respond_type=1080x2034&IDFV=&IDFA=&timestamp=1545208516&sign=081b23f788640a3a46c669921d04f643");
            response = httpclient.execute(httpget1);
            setCookieStore(response, "59.38.123.3");
            response = httpclient.execute(httpget);
            if (response.getStatusLine().getStatusCode() == 200) {
                /*读返回数据*/
                String returnStr = EntityUtils.toString(response.getEntity());
                JSONObject jsonObj = JSONObject.fromObject(returnStr);
//            	String retActual  = "ret="+jsonObj.getString("ret");
//            	String msgActual  = "msg="+jsonObj.getString("msg");
//            	String caseActual = retActual+","+msgActual; 
//            	verifyEquals(retActual,retExpect,caseActual,functionpoint,testData,"帮详情列表-验证ret",apiid,apiMapper);
//            	verifyEquals(msgActual,msgExpect,caseActual,functionpoint,testData,"帮详情列表-验证msg",apiid,apiMapper);
//            	String hh = String.valueOf(jsonObj);
//            	JSONObject resultobj = jsonObj.getJSONObject("data");
            }
//	        else {
//                String err = response.getStatusLine().getStatusCode()+"";
//                strResult += "发送失败:"+err;
//            }
//	        
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;

    }

    /**
     * 使用JsonPath提取json响应数据中的数据
     * 需要的jar包：json-path-2.2.0.jar
     */
    @Test
    public void userQueryWithRegTest3() throws ClientProtocolException, IOException {
        HttpGet request = new HttpGet("http://59.38.123.3/user/member/weibologin?v=4&t=weixin&uuid=oVprQsnGM97II7jY50GFOYYB65-g&openid=olzlquHgU5-V95V-XDF596hqV0t0&nickname=%E5%88%81%E5%AF%92%E6%9E%81&localtion=&head=&vendor=vivoX20A&osver=8.1.0&client_flag=lmbang&client_ver=7.6.30&imei=866239031725945&device_id=866239031725945&channel=avivo&os=android&os_type=android&network_type=wifi&op_company=chinamobile&respond_type=1080x2034&IDFV=&IDFA=&timestamp=1545208516&sign=081b23f788640a3a46c669921d04f643"); // 创建请求
        CloseableHttpResponse response = httpClient.execute(request);    // 执行某个请求
        String body = EntityUtils.toString(response.getEntity());    // 得到响应内容
        response.close();
        System.out.println(body);

        ReadContext ctx = JsonPath.parse(body);
        String mobile = ctx.read("$.data.mobile");
        String nickname = ctx.read("$.data.nickname");
        int status = ctx.read("$.data.status");
        String avatar = ctx.read("$.data.avatar");
        System.out.println(mobile + "\t" + nickname + "\t" + status + "\t" + avatar);
    }


    public static void setCookieStore(HttpResponse httpResponse, String host) {
        cookieStore = new BasicCookieStore();
        // JSESSIONID
        if (null == httpResponse.getFirstHeader("Set-Cookie")) {
            cookieStore = null;
        } else {
            String setCookie = httpResponse.getFirstHeader("Set-Cookie").getValue();
            String JSESSIONID = setCookie.substring("JSESSIONID=".length(), setCookie.indexOf(";"));
            // 新建一个Cookie
            BasicClientCookie cookie = new BasicClientCookie("JSESSIONID", JSESSIONID);
            cookie.setVersion(0);
            cookie.setDomain(host);
            cookie.setPath("/");
            cookieStore.addCookie(cookie);
        }
    }


    public Integer insertBug(String functionpoint, String TestData, String ExpectResult, String ActualResult) {
        bug bug = new bug();
        bug.setFunctionpoint(functionpoint);
        bug.setTestdata(TestData);
        bug.setExpectresult(ExpectResult);
        bug.setActualresult(ActualResult);
        session = dataBase();
        int in = session.insert("com.yskj.dao.bugMapper.insert", bug);
        session.commit();
        return in;
    }


    public SqlSession dataBase() {
        //连库并获取数据
        String resources = "mybatis-config.xml";
        Reader reader;
        try {
            reader = Resources.getResourceAsReader(resources);
            SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(reader);
            session = sf.openSession();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return session;

    }

//	  List<Api> emps = session.selectList("com.yskj.dao.ApiMapper.listByAll");
//	  System.out.println(emps.size());
//	  List<UseCase> empss = session.selectList("com.yskj.dao.UseCaseMapper.listByAll");
//	  System.out.println(empss.size());

//	 static CookieStore cookieStore = null;

    //url转map
    public Map StringtoMap(String url) {
        url = "IDFA=&IDFV=&channel=qq11&client_flag=lmbang&client_ver=7.1.01&device_id=863064010236166&imei=863064010236166&lat=37.007533&long=114.575812&market=qq11&mvc=1&network_type=wifi&op_company=chinamobile&os=android&osver=4.4.2&t_skey=4505ec83a28064c0333799a4aa14c225&timestamp=1550707922&v=4&vendor=HUAWEIMLAAL10&sign=3cc15bfe074a7df8b30499c2d16c506d";
        Map map = new HashMap();
        String[] str = url.split("&");
//		System.out.println(str);
        for (String str1 : str) {
//			System.out.println(str1);
            String[] str2 = str1.split("=");
            System.out.println(str2[0]);
//			System.out.println(str2[1]);

//			if("".equals(str2[1])) {
//				System.out.println(111);
//			}
//			System.out.println(str2[0]);
//			map.put(str2[0], str2[1]);

        }


        System.out.println(map);
        return map;

    }


//	 /**
//		 * post请求(用于key-value格式的参数)
//		 * @param url
//		 * @param params
//		 * @return
//		 */
//		public static String doPost(String url){
//			
//			url ="http://open.lmbang.com/bang-main/dlist?IDFA=&IDFV=&channel=qq11&client_flag=lmbang&client_ver=7.1.01&device_id=863064010236166&from=manual&imei=863064010236166&lat=37.007533&long=114.575812&market=qq11&mvc=1&network_type=wifi&op_company=chinamobile&os=android&osver=4.4.2&page=1&t_skey=6474b3d5b1c54d58808a228a999b9ab6&timestamp=1550730872&v=4&vendor=HUAWEIMLAAL10&sign=c262b4ec34516451d6e28a2472731b12";
//			BufferedReader in = null;  
//	        try {  
//	            // 定义HttpClient  
//	            HttpClient client = new DefaultHttpClient();  
//	            // 实例化HTTP方法  
//	            HttpPost request = new HttpPost();  
//	            request.setURI(new URI(url));
//	            HttpResponse response = client.execute(request);  
////	            int code = response.getStatusLine().getStatusCode();
////	            if(code == 200){	//请求成功
////	            	in = new BufferedReader(new InputStreamReader(response.getEntity()  
////	                        .getContent(),"utf-8"));
////	                StringBuffer sb = new StringBuffer("");  
////	                String line = "";  
////	                String NL = System.getProperty("line.separator");  
////	                while ((line = in.readLine()) != null) {  
////	                    sb.append(line + NL);  
////	                }
//	        }catch(Exception e) {
//	        	e.printStackTrace();
//	        }
//			return url;
//		}


}
