package com.yskj.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yskj.dao.ApiMapper;
import com.yskj.domain.Api;

@Service
public class ApiServiceImpl implements ApiService {

    @Autowired
    private ApiMapper apiMapper;

    @Override
    public void add(Api api) {
        System.out.println("888888888888888888");
        apiMapper.insert(api);
    }

    @Override
    public void edit(Api Api) {
//	    	   int caseid =Api.getCaseid();
//	           String caseid1 = String.valueOf(caseid);
//	           if(caseid1 == null){//新建
////	               id=counter.incrementAndGet();
//	        	   Api.setCaseid(caseid);
//	        	   apiMapper.insert(Api);
//	           }
        apiMapper.updateByPrimaryKey(Api);
    }

    @Override
    public void delete(int id) {
        apiMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Api getById(int id) {
        return apiMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Api> listByAll() {

        List<Api> list = apiMapper.listByAll();
        return list;
    }


    @Override
    public List<Api> queryUserInfo(int productid) {

        return apiMapper.queryUserInfo(productid);
    }

//    @Override
//    public List<Api> findAllUserByPageF(int pageNum, int pageSize) {
//        // TODO Auto-generated method stub
//        PageHelper.startPage(pageNum, pageSize);
//        List<Api> lists = apiMapper.queryUserInfo();
//        return lists;
//    }

    @Override
    public PageInfo<Api> findAllUserByPageS(int pageNum, int pageSize,int productid) {
        // TODO Auto-generated method stub
        PageHelper.startPage(pageNum, pageSize);

        // 自定义的mapper文件

        List<Api> lists = apiMapper.queryUserInfo(productid);
        PageInfo<Api> pageInfo = new PageInfo<Api>(lists);
        return pageInfo;

    }



}
