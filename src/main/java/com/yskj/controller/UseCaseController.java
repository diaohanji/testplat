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

@Controller
@EnableAutoConfiguration
public class UseCaseController {
    @Resource
    @Autowired
    UseCaseService usecaseService;


    @RequestMapping("/")
    public String index() {
        return "redirect:/list";
    }

    @RequestMapping("/list")
    public String list(Model model) {
        List<UseCase> usecase = usecaseService.listByAll();
        model.addAttribute("usecase", usecase);
        return "usecase/list";
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        System.out.println("7777777");
        return "usecase/usecaseAdd";
    }

    @RequestMapping("/add")
    public String add(UseCase usecase) {
        usecaseService.add(usecase);
        return "redirect:/list";
    }

    @RequestMapping("/toEdit")
    public String toEdit(Model model, int id) {
        UseCase usecase = usecaseService.getById(id);
        model.addAttribute("usecase", usecase);
        return "usecase/usecaseEdit";
    }

    @RequestMapping("/edit")
    public String edit(UseCase usecase) {
        usecaseService.edit(usecase);
        return "redirect:/list";
    }


    @RequestMapping("/delete")
    public String delete(int id) {
        usecaseService.delete(id);
        return "redirect:/list";
    }


}
