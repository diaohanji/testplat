package com.yskj.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yskj.domain.Api;
import com.yskj.domain.UseCase;
import com.yskj.domain.bug;
import com.yskj.service.ApiService;

//
//
//import javax.annotation.Resource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//
@RestController
@RequestMapping("/")
public class Index1Controller {
    @RequestMapping("/testJson")
    public Map jsonMap() {
        UseCase user = new UseCase();
        UseCase user2 = new UseCase();
        user.setCaseactual("11111");
        user.setCasedesc("22222");
        user.setCaseexpect("33333");
        user.setCaseid(11);
        user.setCasename("343433");
        user2.setCaseactual("hehe");
        user2.setCasedesc("heiheih");
        user2.setCaseexpect("hahah");
        user2.setCaseid(12);
        user2.setCasename("ajfjd");
        List Userlist = new ArrayList();
        Userlist.add(user);
        Userlist.add(user2);
        Map map = new HashMap();
        Map map2 = new HashMap();
        map.put("userList", Userlist);
        map.put("user", user);

        map2.put("data", map);
        map2.put("ret", 0);
        map2.put("msg", "成功");
        return map2;
    }


    static Connection conn = null;
    static List apilist = null;
    static List buglist = null;
    static Map map = null;

    //获取连接
    public static Connection getConnect() {
        String URL = "jdbc:mysql://127.0.0.1:3306/testplat?useUnicode=true&amp;characterEncoding=utf-8";
        String USER = "root";
        String PASSWORD = "123456";
        //1.加载驱动程序
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //2.获得数据库链接
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return conn;
    }


    //查库
    public static List query() {
        //3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
        Statement st;
        ResultSet rs;
        apilist = new ArrayList();
        try {
            st = conn.createStatement();
            rs = st.executeQuery("select * from api");
            //4.处理数据库的返回结果(使用ResultSet类)
            while (rs.next()) {
//				             System.out.println(rs.getString("apiid")+" "
//				                           +rs.getString("apiurl"));

                Api api = new Api();
                api.setApiurl(rs.getString("apiurl"));
                api.setApiid(rs.getInt("apiid"));

                apilist.add(api);
            }


            //关闭资源
            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return apilist;
    }

    //查库
    public static List query2() {
        //3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
        Statement st;
        ResultSet rs;
        buglist = new ArrayList();
        try {
            st = conn.createStatement();
            rs = st.executeQuery("select * from bug limit 5");
            //4.处理数据库的返回结果(使用ResultSet类)
            while (rs.next()) {
                bug bug = new bug();

                bug.setTestdata(rs.getString("TestData"));

                String[] arr = {"111", "222222", "333333"};

                bug.setArr(arr);


                buglist.add(bug);
            }


            //关闭资源
            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return buglist;

    }


    //查库
    public static List queryCaseList() {
        //3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
        Statement st;
        ResultSet rs;
        buglist = new ArrayList();
        try {
            st = conn.createStatement();
            rs = st.executeQuery("select * from usecase");
            //4.处理数据库的返回结果(使用ResultSet类)
            while (rs.next()) {
                bug bug = new bug();

                bug.setTestdata(rs.getString("TestData"));

                String[] arr = {"111", "222222", "333333"};

                bug.setArr(arr);


                buglist.add(bug);
            }


            //关闭资源
            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return buglist;

    }


    @RequestMapping("/testJson2")
    public Map jsonMap2() {
        System.out.println(111);
        getConnect();

        apilist = query();
        getConnect();
        buglist = query2();

        HashMap map = new HashMap();
        HashMap map2 = new HashMap();

        map.put("apilist", apilist);
        map.put("buglist", buglist);


        map2.put("msg", "成功");
        map2.put("code", 200);
        map2.put("data", map);


        System.out.println(map);
        return map2;
    }


//    @Resource
//    @Autowired
//    ApiService apiService;
//	@RequestMapping("/jsonList1")
//	public List jsonList(String str) {
//		
////		List<Api> apiList=apiService.listByAll();
////		return apiList;
//		
//	}
//	


}
