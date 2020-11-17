package com.yskj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yskj.domain.UseCase;

@Mapper
public interface UseCaseMapper {
    int deleteByPrimaryKey(Integer caseid);

    int insert(UseCase record);

    int insertSelective(UseCase record);

    UseCase selectByPrimaryKey(Integer caseid);

    int updateByPrimaryKeySelective(UseCase record);

    int updateByPrimaryKey(UseCase record);

    List<UseCase> listByAll();


}