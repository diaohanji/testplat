//package com.yskj.controller;
//
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import javax.annotation.Resource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//
//import com.github.pagehelper.PageHelper;
//import com.github.pagehelper.PageInfo;
//import com.yskj.domain.Api;
//import com.yskj.service.ApiService;
//
//@Controller
//@EnableAutoConfiguration
//public class ApiController {
////    @Resource
////    @Autowired
////    ApiService apiService;
////    @CrossOrigin(origins = "http://localhost:8080")
////    @RequestMapping("/apiList")
////    public String zhuandi_110(Model model, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize) {
////        //引入分页查询，使用PageHelper分页功能在查询之前传入当前页，然后多少记录
////        PageHelper.startPage(pageNum, pageSize);
////        //startPage后紧跟的这个查询就是分页查询
////        List<Api> api = apiService.listByAll();
////        //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
////        PageInfo pageInfo = new PageInfo<Api>(api, 5);
////        model.addAttribute("pageInfo", pageInfo);
////        //获得当前页
////        model.addAttribute("pageNum", pageInfo.getPageNum());
////        //获得一页显示的条数
////        model.addAttribute("pageSize", pageInfo.getPageSize());
////        //是否是第一页
////        model.addAttribute("isFirstPage", pageInfo.isIsFirstPage());
////        //获得总页数
////        model.addAttribute("totalPages", pageInfo.getPages());
////        //是否是最后一页
////        model.addAttribute("isLastPage", pageInfo.isIsLastPage());
//////	    	PageInfo<Api> apiPageInfo = new PageInfo<>(api);
//////	    	return JSON.toJSONString(appsPageInfo);
//////	        model.addAttribute("api", api);
//////	        model.addAttribute("api", apiPageInfo);
////        return "api/apiList";
//}
//
////    @RequestMapping("/api")
////    public String index() {
////        return "redirect:/apiList";
////    }
////
////    @RequestMapping("/toAddApi")
////    public String toAdd() {
////        return "api/apiAdd";
////    }
//
////    @CrossOrigin(origins = "http://localhost:8080")
////    @RequestMapping(value= "/addApi",method = RequestMethod.POST)
////    public String add(@RequestBody Api api) {
////        apiService.add(api);
////        return "redirect:/apiList";
////    }
//
////    @RequestMapping("/toEditApi")
////    public String toEdit(Model model, int id) {
////        Api api = apiService.getById(id);
////        model.addAttribute("api", api);
////        return "api/apiEdit";
////    }
//
////    @RequestMapping("/editApi")
////    public String edit(Api api) {
////        apiService.edit(api);
////        return "redirect:/apiList";
////    }
//
//
////    @RequestMapping("/deleteApi")
////    public String delete(int id) {
////        apiService.delete(id);
////        return "redirect:/apiList";
////    }
//}
