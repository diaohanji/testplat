package com.yskj.domain;


public class UseCase {


    private Integer caseid;

    private String casename;

    private String casedesc;

    private String caseactual;

    private String caseexpect;

    public Integer getCaseid() {
        return caseid;
    }

    public void setCaseid(Integer caseid) {
        this.caseid = caseid;
    }

    public String getCasename() {
        return casename;
    }

    public void setCasename(String casename) {
        this.casename = casename == null ? null : casename.trim();
    }

    public String getCasedesc() {
        return casedesc;
    }

    public void setCasedesc(String casedesc) {
        this.casedesc = casedesc == null ? null : casedesc.trim();
    }

    public String getCaseactual() {
        return caseactual;
    }

    public void setCaseactual(String caseactual) {
        this.caseactual = caseactual == null ? null : caseactual.trim();
    }

    public String getCaseexpect() {
        return caseexpect;
    }

    public void setCaseexpect(String caseexpect) {
        this.caseexpect = caseexpect == null ? null : caseexpect.trim();
    }
}