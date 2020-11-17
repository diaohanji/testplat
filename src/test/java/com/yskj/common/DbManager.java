package com.yskj.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DbManager {
    static Connection conn = null;
    static List apilist = null;
    static List buglist = null;
    static Map map = null;

    public static void main(String[] args) {
        System.out.println(111);
        getConnect();

        apilist = query();
        getConnect();
        buglist = query2();

        map = new HashMap();
        map.put(apilist, apilist);
        map.put(buglist, buglist);
        System.out.println(map);

    }


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
//			             System.out.println(rs.getString("apiid")+" "
//			                           +rs.getString("apiurl"));
                apilist.add(rs.getString("apiid") + " "
                        + rs.getString("apiurl"));
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
                buglist.add(rs.getString("TestData"));
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


    public static void dataCheck(Map actual, Map expect) {

    }


}
