package com.testcase.generator.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * The persistent class for the TC_INPUT_MAPPING_MATRIX_HDR database table.
 * 
 */
@Entity
@Table(name = "TC_INPUT_MAPPING_MATRIX_HDR")
@NamedQuery(name = "TcInputMappingMatrixHdr.findAll", query = "SELECT t FROM TcInputMappingMatrixHdr t")
public class TcInputMappingMatrixHdr {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "HDR_ID")
    private long hdrId;

    @Column(name = "FUNCTIONALITY_CODE")
    private String functionalityCode;

    @Column(name = "FUNCTIONALITY_DESC")
    private String functionalityDesc;

    @Column(name = "MODULE_CODE")
    private String moduleCode;

    @Column(name = "RELEASE_NO")
    private String releaseNo;

    @Column(name = "SCENARIO_CODE")
    private String scenarioCode;

    @Column(name = "SCENARIO_DESC")
    private String scenarioDesc;

    @Transient
    private String combinationLogic;
    
    @Transient
    private String testCaseData;
    
    @Transient
    private String activeFlag;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true)
    @JoinColumn(name = "HDR_ID", referencedColumnName = "HDR_ID")
    private List<TcInputMappingMatrixDtl> tcInputMappingMatrixDtl;
    
    public TcInputMappingMatrixHdr() {
    }

    public long getHdrId() {
	return this.hdrId;
    }

    public void setHdrId(long hdrId) {
	this.hdrId = hdrId;
    }

    public String getFunctionalityCode() {
	return this.functionalityCode;
    }

    public void setFunctionalityCode(String functionalityCode) {
	this.functionalityCode = functionalityCode;
    }

    public String getFunctionalityDesc() {
	return this.functionalityDesc;
    }

    public void setFunctionalityDesc(String functionalityDesc) {
	this.functionalityDesc = functionalityDesc;
    }

    public String getModuleCode() {
	return this.moduleCode;
    }

    public void setModuleCode(String moduleCode) {
	this.moduleCode = moduleCode;
    }

    public String getReleaseNo() {
	return this.releaseNo;
    }

    public void setReleaseNo(String releaseNo) {
	this.releaseNo = releaseNo;
    }

    public String getScenarioCode() {
	return this.scenarioCode;
    }

    public void setScenarioCode(String scenarioCode) {
	this.scenarioCode = scenarioCode;
    }

    public String getScenarioDesc() {
	return this.scenarioDesc;
    }

    public void setScenarioDesc(String scenarioDesc) {
	this.scenarioDesc = scenarioDesc;
    }

    public String getCombinationLogic() {
        return combinationLogic;
    }

    public void setCombinationLogic(String combinationLogic) {
        this.combinationLogic = combinationLogic;
    }

    public String getTestCaseData() {
        return testCaseData;
    }

    public void setTestCaseData(String testCaseData) {
        this.testCaseData = testCaseData;
    }

    public List<TcInputMappingMatrixDtl> getTcInputMappingMatrixDtl() {
        return tcInputMappingMatrixDtl;
    }

    public void setTcInputMappingMatrixDtl(List<TcInputMappingMatrixDtl> tcInputMappingMatrixDtl) {
        this.tcInputMappingMatrixDtl = tcInputMappingMatrixDtl;
    }

    public String getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(String activeFlag) {
        this.activeFlag = activeFlag;
    }
    
    
}