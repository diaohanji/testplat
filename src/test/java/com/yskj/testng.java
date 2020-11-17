package com.yskj;

import java.util.List;
import com.yskj.controller.RestApiController;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.annotations.Test;

import com.yskj.service.ApiService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class testng {
    @Autowired
    private ApiService apiService;

    @Test
    public void f() {
//        List list = apiService.listByAll();
//        System.out.println(list + "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
    }
    @Test
    private void fff() {
        RestApiController rac = new RestApiController();
        rac.addMethod(1,2);
    }
}
