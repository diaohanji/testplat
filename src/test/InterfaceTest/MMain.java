package com.yskj.InterfaceTest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


public class MMain {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
////		ApiTest at  = new ApiTest();
////		Tt tt = new Tt();
////		tt.apiService.listByAll();
//			// TODO Auto-generated method stub
////			at.sendSms("url","7","param");
//
//	}

    @SpringBootApplication
    @MapperScan("com.yskj.dao.ApiMapper")
    public static class Application {
        public static void main(String[] args) throws Exception {
            SpringApplication.run(Application.class, args);
        }
    }
}
