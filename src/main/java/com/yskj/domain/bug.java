package com.yskj.domain;

import java.sql.Array;

public class bug {
    private Integer bugid;

    private String functionpoint;

    private String testdata;

    private String expectresult;

    private String actualresult;


    public String[] getArr() {
        return arr;
    }

    public void setArr(String[] arr) {
        this.arr = arr;
    }

    private String[] arr;


    public Integer getBugid() {
        return bugid;
    }

    public void setBugid(Integer bugid) {
        this.bugid = bugid;
    }

    public String getFunctionpoint() {
        return functionpoint;
    }

    public void setFunctionpoint(String functionpoint) {
        this.functionpoint = functionpoint == null ? null : functionpoint.trim();
    }

    public String getTestdata() {
        return testdata;
    }

    public void setTestdata(String testdata) {
        this.testdata = testdata == null ? null : testdata.trim();
    }

    public String getExpectresult() {
        return expectresult;
    }

    public void setExpectresult(String expectresult) {
        this.expectresult = expectresult == null ? null : expectresult.trim();
    }

    public String getActualresult() {
        return actualresult;
    }

    public void setActualresult(String actualresult) {
        this.actualresult = actualresult == null ? null : actualresult.trim();
    }
}