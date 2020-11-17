package com.yskj.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yskj.domain.UseCase;

@Service
public interface UseCaseService {
    //新增
    void add(UseCase usecase);

    //编辑
    void edit(UseCase usecase);

    //删除
    void delete(int id);

    //获取单个
    UseCase getById(int id);

    //获取所有
    List<UseCase> listByAll();
}      