package com.testcase.generator.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.SequenceGenerator;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * The persistent class for the TC_INPUT_MAPPING_MATRIX_DTL database table.
 * 
 */
@Entity
@Table(name="TC_INPUT_MAPPING_MATRIX_DTL")
@NamedQuery(name="TcInputMappingMatrixDtl.findAll", query="SELECT t FROM TcInputMappingMatrixDtl t")
@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(name = "tc_permutational_matrix", 
                procedureName = "tc_permutational_matrix",
                parameters = {
                   @StoredProcedureParameter(mode = ParameterMode.IN, name = "pi_functionality_code", type = String.class),
                   @StoredProcedureParameter(mode = ParameterMode.IN, name = "pi_scenario_code", type = String.class),
                   @StoredProcedureParameter(mode = ParameterMode.OUT, name = "po_err_desc", type = String.class)
                })
})
public class TcInputMappingMatrixDtl  {

	@Id
	@SequenceGenerator(name="TC_INPUT_MAPPING_MATRIX_DTL_DTLID_GENERATOR", sequenceName="TC_INPUT_MAPPING_MATRIX_DTL_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TC_INPUT_MAPPING_MATRIX_DTL_DTLID_GENERATOR")
	@Column(name="DTL_ID")
	private long dtlId;

	@Column(name="ACTIVE_FLAG")
	private String activeFlag;

	@Column(name="COMBINATIONAL_SEQUENCE")
	private Long combinationalGroupingNo;

	@Column(name="ENTITY_ATTRIBUTE_SEQUENCE")
	private Long entitySequence;

	@Column(name="HDR_ID")
	private Long hdrId;

	@Column(name="MAP_VALUE_WITH_TESTCASEID")
	private String mapValueWithTestcaseid;

	@Column(name="REF_DTL_ID")
	private Long refDtlId;
	
	@Transient
	private String testCaseData;

	public TcInputMappingMatrixDtl() {
	}

	public long getDtlId() {
		return this.dtlId;
	}

	public void setDtlId(long dtlId) {
		this.dtlId = dtlId;
	}

	public String getActiveFlag() {
		return this.activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	public String getMapValueWithTestcaseid() {
		return this.mapValueWithTestcaseid;
	}

	public void setMapValueWithTestcaseid(String mapValueWithTestcaseid) {
		this.mapValueWithTestcaseid = mapValueWithTestcaseid;
	}

	public Long getCombinationalGroupingNo() {
	    return combinationalGroupingNo;
	}

	public void setCombinationalGroupingNo(Long combinationalGroupingNo) {
	    this.combinationalGroupingNo = combinationalGroupingNo;
	}

	public Long getEntitySequence() {
	    return entitySequence;
	}

	public void setEntitySequence(Long entitySequence) {
	    this.entitySequence = entitySequence;
	}

	public Long getHdrId() {
	    return hdrId;
	}

	public void setHdrId(Long hdrId) {
	    this.hdrId = hdrId;
	}

	public Long getRefDtlId() {
	    return refDtlId;
	}

	public void setRefDtlId(Long refDtlId) {
	    this.refDtlId = refDtlId;
	}

	public String getTestCaseData() {
	    return testCaseData;
	}

	public void setTestCaseData(String testCaseData) {
	    this.testCaseData = testCaseData;
	}
	
	

}