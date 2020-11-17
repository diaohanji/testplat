package com.yskj.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yskj.domain.UseCase;
import com.yskj.service.UseCaseService;

@RestController
@RequestMapping("/")
public class UseCaseController1 {
    @Resource
    @Autowired
    UseCaseService usecaseService;


    @RequestMapping("/listJson")
    public List listJson() {
        System.out.println("22222222222222222222");
        List<UseCase> usecase = usecaseService.listByAll();
        System.out.println(usecase + "^^^^^^^^^^");
//	        model.addAttribute("usecase", usecase);
        return usecase;
    }


}
