package com.yskj.controller;

import com.yskj.util.ResponseDataUtil;
import com.yskj.util.ResultEnums;
import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.github.pagehelper.PageInfo;
import com.yskj.util.ResponseData;
import com.yskj.domain.Api;
import com.yskj.domain.UseCase;
import com.yskj.service.ApiService;

@RestController
@RequestMapping("/")
@CrossOrigin
public class RestApiController {
    @Resource
    @Autowired
    ApiService apiService;

    @RequestMapping("/resttestJson")
    public Map jsonMap() {
        UseCase user = new UseCase();
        UseCase user2 = new UseCase();
        System.out.println("111111111111111111111111111");
        user.setCaseactual("11111");
        user.setCasedesc("22222");
        user.setCaseexpect("33333");
        user.setCaseid(11);
        user.setCasename("99999999999");
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
    /**
     * 根据页码和大小分页查询
     * @param page 当前页，默认为1
     * @param size 当前每页显示行数，默认为5
     * @return 页信息的实体
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = {"/restapiList"}, method = RequestMethod.GET)
    public List getList(Api api) {
        List<Api> list = apiService.listByAll();
        return list;
    }


    /**
     * 测试jacoco用
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = {"/restapiList1"}, method = RequestMethod.GET)
    public String testMethod1(Api api) {
        return "helloworld";
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(value = {"/restapiList2"}, method = RequestMethod.GET)
    public int addMethod(int a, int b) {
        return a+b;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = {"/testPageHelper1"}, method = RequestMethod.GET)
    public ResponseData<Api> testPageHelper1(@RequestParam(required=false,defaultValue="1") Integer pageNum, @RequestParam(required=false,defaultValue="6") Integer pageSize, @RequestParam(required=false,defaultValue="1") Integer productid){
        try {
            PageInfo<Api> queryResult = apiService.findAllUserByPageS(pageNum,pageSize,productid);
            return ResponseDataUtil.buildSuccess(queryResult);
        }catch(Exception e) {
            e.printStackTrace();
            return ResponseDataUtil.buildError(ResultEnums.ERROR.toString(),"请求失败");
        }
//        return queryResult;
    }
//    @CrossOrigin(origins = "*")
//    @RequestMapping(value = {"/testPageHelper2"}, method = RequestMethod.GET)
//    public List<Api> testPageHelper2(@RequestParam(required=false,defaultValue="1") Integer pageNum,@RequestParam(required=false,defaultValue="6") Integer pageSize){
//        List<Api> queryResult = apiService.findAllUserByPageF(pageNum,pageSize);
//        return queryResult;
//    }

    @RequestMapping(value = {"/deleteapibyid/{apiid}"},method = RequestMethod.DELETE)
    public String delete(@PathVariable("apiid") String ids) {
        String[] idss = ids.split(",");
        for (String id : idss) {
            int idint = Integer.parseInt(id);
            apiService.delete(idint);
        }

        return "0";
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value= "/addApi",method = RequestMethod.POST)
    public String add(@RequestBody Api api) {
        apiService.add(api);
        return "redirect:/testPageHelper1";
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/toEditApi",method = RequestMethod.PATCH)
    @ResponseBody
    public String toEdit(@RequestBody int apiid,Model model) {
        System.out.println(apiid);
        Api api=apiService.getById(apiid);
        model.addAttribute("api", api);
        return "api/apiEdit";
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/editApi",method = RequestMethod.PATCH)
    @ResponseBody
    public String edit(@RequestBody Api api) {
        apiService.edit(api);
        return "redirect:/apiList";
    }

    @Test
    public void test(){
//        List list = new ArrayList();
//        list.add("1");
        Class<Api> apiClass = Api.class;
        Class<? extends Class> aClass = apiClass.getClass();


    }

}
