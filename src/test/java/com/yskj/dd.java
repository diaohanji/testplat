package com.yskj;

import org.testng.annotations.Test;

import com.yskj.domain.Api;
import com.yskj.service.ApiService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;


@SpringBootTest(classes = {TestPlatformApplication.class})
@DirtiesContext(classMode = ClassMode.AFTER_CLASS)
public class dd extends AbstractTestNGSpringContextTests {

    @Autowired
    private ApiService apiService;

    @Test
    public void getHealthCheckIntegrationTest() {
//        List<Api> list = apiService.listByAll();
//
//        for (int i = 0; i < list.size(); i++) {
//            Api api = list.get(i);
//            System.out.println(api.getApiactual() + "^^^^^");
//            System.out.println(api.getApiexpect() + "^^^^^");
//        }
//        System.out.println(list);
    }
}
