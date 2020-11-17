package com.yskj.dao;

import java.util.List;

import com.yskj.domain.Api;
import com.yskj.domain.bug;

public interface bugMapper {


    int deleteByPrimaryKey(Integer bugid);

    int insert(bug record);

    int insertSelective(bug record);

    bug selectByPrimaryKey(Integer bugid);

    int updateByPrimaryKeySelective(bug record);

    int updateByPrimaryKey(bug record);

    List<Api> listByAll();

}