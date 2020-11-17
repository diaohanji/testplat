package com.yskj.controller;

import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yskj.domain.UseCase;

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
@Controller
@EnableAutoConfiguration

public class indexController {
////	    @Resource
////	    @Autowired    
//	    @RequestMapping("/")
//	    public String index() {
//	        return "redirect:/index";   
//	    }
//    

    @RequestMapping("/index")
    public String list() {
//	        List<UseCase> usecase=usecaseService.listByAll();
//	        model.addAttribute("usecase", usecase);
        return "index";
    }

    @RequestMapping("/top")
    public String toAdd() {
        System.out.println("7777777");
        return "top";
    }

    @RequestMapping("/left_menu")
    public String toleft_menu() {
        System.out.println("7777777");
        return "left_menu";
    }

    @RequestMapping("/home")
    public String tohome() {
        System.out.println("7777777");
        return "home";
    }

    @RequestMapping("/footer")
    public String footer() {
        System.out.println("7777777");
        return "footer";
    }


//
////	    @RequestMapping("/toAdd")
////	    public String toAdd() {
////	    	System.out.println("7777777");
////	        return "usecase/usecaseAdd";
////	    }
////
////	    @RequestMapping("/add")
////	    public String add(UseCase usecase) {
////	        usecaseService.add(usecase);
////	        return "redirect:/list";
////	    }
////
////	    @RequestMapping("/toEdit")
////	    public String toEdit(Model model,int id) {
////	        UseCase usecase=usecaseService.getById(id);
////	        model.addAttribute("usecase", usecase);
////	        return "usecase/usecaseEdit";
////	    }
////
////	    @RequestMapping("/edit")
////	    public String edit(UseCase usecase) {
////	        usecaseService.edit(usecase);
////	        return "redirect:/list";
////	    }
////
////
////	    @RequestMapping("/delete")
////	    public String delete(int id) {
////	        usecaseService.delete(id);
////	        return "redirect:/list";
////	    }
//
//    
//    
//    
}
