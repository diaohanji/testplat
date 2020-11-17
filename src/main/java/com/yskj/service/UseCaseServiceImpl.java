package com.yskj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yskj.dao.UseCaseMapper;
import com.yskj.domain.UseCase;

@Service
public class UseCaseServiceImpl implements UseCaseService {

    @Autowired
    private UseCaseMapper usecaseMapper;

    @Override
    public void add(UseCase usecase) {
        System.out.println("888888888888888888");
        usecaseMapper.insert(usecase);
    }

    @Override
    public void edit(UseCase usecase) {
//	    	   int caseid =usecase.getCaseid();
//	           String caseid1 = String.valueOf(caseid);
//	           if(caseid1 == null){//新建
////	               id=counter.incrementAndGet();
//	        	   usecase.setCaseid(caseid);
//	        	   usecaseMapper.insert(usecase);
//	           }
        usecaseMapper.updateByPrimaryKey(usecase);
    }

    @Override
    public void delete(int id) {
        usecaseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public UseCase getById(int id) {
        return usecaseMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<UseCase> listByAll() {
        System.out.println("11111111111111111111");
        return usecaseMapper.listByAll();
    }


}
