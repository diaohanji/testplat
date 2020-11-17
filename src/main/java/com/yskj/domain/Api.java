package com.yskj.domain;

import java.util.Date;

public class Api {
    private Integer apiid;

    private String apifunctionpoint;

    private String apiurl;

    private String apiparam;

    private String apiexpect;

    private String apiactual;

    private String apiresponse;

    private String planrun;

    private String apirunresult;

    private Date apicreatetime;

    private Integer productid;

    public Integer getApiid() {
        return apiid;
    }

    public void setApiid(Integer apiid) {
        this.apiid = apiid;
    }

    public String getApifunctionpoint() {
        return apifunctionpoint;
    }

    public void setApifunctionpoint(String apifunctionpoint) {
        this.apifunctionpoint = apifunctionpoint == null ? null : apifunctionpoint.trim();
    }

    public String getApiurl() {
        return apiurl;
    }

    public void setApiurl(String apiurl) {
        this.apiurl = apiurl == null ? null : apiurl.trim();
    }

    public String getApiparam() {
        return apiparam;
    }

    public void setApiparam(String apiparam) {
        this.apiparam = apiparam == null ? null : apiparam.trim();
    }

    public String getApiexpect() {
        return apiexpect;
    }

    public void setApiexpect(String apiexpect) {
        this.apiexpect = apiexpect == null ? null : apiexpect.trim();
    }

    public String getApiactual() {
        return apiactual;
    }

    public void setApiactual(String apiactual) {
        this.apiactual = apiactual == null ? null : apiactual.trim();
    }

    public String getApiresponse() {
        return apiresponse;
    }

    public void setApiresponse(String apiresponse) {
        this.apiresponse = apiresponse == null ? null : apiresponse.trim();
    }

    public String getPlanrun() {
        return planrun;
    }

    public void setPlanrun(String planrun) {
        this.planrun = planrun == null ? null : planrun.trim();
    }

    public String getApirunresult() {
        return apirunresult;
    }

    public void setApirunresult(String apirunresult) {
        this.apirunresult = apirunresult == null ? null : apirunresult.trim();
    }

    public Date getApicreatetime() {
        return apicreatetime;
    }

    public void setApicreatetime(Date apicreatetime) {
        this.apicreatetime = apicreatetime;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }
}