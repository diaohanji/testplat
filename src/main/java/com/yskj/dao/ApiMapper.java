package com.yskj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yskj.domain.Api;
import com.yskj.domain.UseCase;

@Mapper
public interface ApiMapper {

    int deleteByPrimaryKey(Integer apiid);

    int insert(Api record);

    int insertSelective(Api record);

    Api selectByPrimaryKey(Integer apiid);

    int updateByPrimaryKeySelective(Api record);

    int updateByPrimaryKey(Api record);

    int updateByPrimaryKey_apirunresult_0(Integer apiid, String apiactual);

    int updateByPrimaryKey_apirunresult_1(Integer apiid, String apiactual);

    List<Api> listByAll();

    //查询所有
    List<Api> queryUserInfo(Integer productid);


}