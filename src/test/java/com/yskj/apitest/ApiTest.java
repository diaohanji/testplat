//package com.yskj.apitest;
//
//import java.io.IOException;
//import java.io.Reader;
//import java.util.List;
//
//import org.apache.http.client.methods.HttpPost;
//import org.apache.ibatis.io.Resources;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//import org.junit.Before;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.annotation.DirtiesContext.ClassMode;
//import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
//import org.testng.annotations.Test;
//
//import com.yskj.TestPlatformApplication;
//import com.yskj.common.PCommon;
//import com.yskj.dao.ApiMapper;
//import com.yskj.domain.Api;
//import com.yskj.domain.UseCase;
//import com.yskj.service.ApiService;
//
//@SpringBootTest(classes = {TestPlatformApplication.class})
//@DirtiesContext(classMode = ClassMode.AFTER_CLASS)
//public class ApiTest extends AbstractTestNGSpringContextTests {
//    @Autowired
//    private ApiService apiService;
//    @Autowired
//    private ApiMapper apiMapper;
//    private SqlSession session;
//
//    @Test
//    public void f() {
//        List<Api> list = apiService.listByAll();
//        PCommon pc = new PCommon();
//        for (int i = 0; i < list.size(); i++) {
//            Api api = list.get(i);
//            //根据前端form拼接url
//            String allUrl = pc.getUrl(api.getApiurl(), api.getApiparam());
//            String expectResult = api.getApiexpect();
//            String actualResult = api.getApiactual();
//            String apiParam = api.getApiparam();
//            String apifunctionpoint = api.getApifunctionpoint();
//
//
//            //执行http请求，数据库需加字段   请求方式
//            //设置cookie
//            String h = pc.getJsonData(allUrl, api.getApiid(), apiMapper, expectResult, actualResult, apifunctionpoint, apiParam);
//        }
//
//
////
////	  //连库并获取数据
////	  String resources = "mybatis-config.xml";
////	  Reader reader;
////	  try {
////		  reader = Resources.getResourceAsReader(resources);
////		  SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(reader);
////		  session = sf.openSession();
////	  } catch (IOException e) {
////	  // TODO Auto-generated catch block
////		  e.printStackTrace();
////	  }
//
//
////	  List<Api> emps = session.selectList("com.yskj.dao.ApiMapper.listByAll");
////	  System.out.println(emps.size());
////	  List<UseCase> empss = session.selectList("com.yskj.dao.UseCaseMapper.listByAll");
////	  System.out.println(empss.size());
//
//
//    }
//
//
//}
//
//
//
