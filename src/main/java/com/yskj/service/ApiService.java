package com.yskj.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import com.yskj.domain.Api;


@Service
public interface ApiService {
    //新增
    void add(Api api);

    //编辑
    void edit(Api api);

    //删除
    void delete(int id);

    //获取单个
    Api getById(int id);

    //获取所有
    List<Api> listByAll();

    //查询所有
    List<Api> queryUserInfo(int productid);


    //分页查询
//    List<Api> findAllUserByPageF(int pageNum,int pageSize);

    PageInfo<Api> findAllUserByPageS(int pageNum, int pageSize,int productid);




}      