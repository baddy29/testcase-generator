package com.testcase.generator.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * The persistent class for the TC_INPUT_REFERENTIAL_ENTITY_DTLS database table.
 * 
 */
@Entity
@Table(name="TC_INPUT_REFERENTIAL_ENTITY_DTLS")
@NamedQuery(name="TcInputReferentialEntityDtl.findAll", query="SELECT t FROM TcInputReferentialEntityDtl t")
public class TcInputReferentialEntityDtl  {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="REF_DTL_ID")
	private long refDtlId;

	@Column(name="ACTIVE_FLAG")
	private String activeFlag;

	@Column(name="ATTRIBUTE_POSSIBLE_VALUE_CODE")
	private String attributePossibleValueCode;

	@Column(name="ATTRIBUTE_POSSIBLE_VALUE_DESC")
	private String attributePossibleValueDesc;

	@Column(name="ATTRIBUTE_POSSIBLE_VALUE_SEQ")
	private BigDecimal attributePossibleValueSeq;

	@Column(name="ATTRIBUTE_SEQ")
	private BigDecimal attributeSeq;

	@Column(name="ATTRIBUTE_UNIQUE_VALUE_FLAG")
	private String attributeUniqueValueFlag;

	@Column(name="DEFAULT_VALUE")
	private String defaultValue;

	@Column(name="DEFAULT_VALUE_FLAG")
	private String defaultValueFlag;

	@Column(name="ENTITY_ATTRIBUTE_CODE")
	private String entityAttributeCode;

	@Column(name="ENTITY_ATTRIBUTE_DESC")
	private String entityAttributeDesc;

	@Column(name="ENTITY_CODE")
	private String entityCode;

	@Column(name="ENTITY_DESC")
	private String entityDesc;

	@Column(name="ENTITY_TYPE")
	private String entityType;

	@Column(name="MODULE_CODE")
	private String moduleCode;

	@Column(name="REQUIRED_FIELD")
	private String requiredField;

	@Column(name="USER_ID")
	private String userId;
	
	@Transient
	private Long combinationalGroupingNo;

	public TcInputReferentialEntityDtl() {
	}

	public long getRefDtlId() {
		return this.refDtlId;
	}

	public void setRefDtlId(long refDtlId) {
		this.refDtlId = refDtlId;
	}

	public String getActiveFlag() {
		return this.activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	public String getAttributePossibleValueCode() {
		return this.attributePossibleValueCode;
	}

	public void setAttributePossibleValueCode(String attributePossibleValueCode) {
		this.attributePossibleValueCode = attributePossibleValueCode;
	}

	public String getAttributePossibleValueDesc() {
		return this.attributePossibleValueDesc;
	}

	public void setAttributePossibleValueDesc(String attributePossibleValueDesc) {
		this.attributePossibleValueDesc = attributePossibleValueDesc;
	}

	public BigDecimal getAttributePossibleValueSeq() {
		return this.attributePossibleValueSeq;
	}

	public void setAttributePossibleValueSeq(BigDecimal attributePossibleValueSeq) {
		this.attributePossibleValueSeq = attributePossibleValueSeq;
	}

	public BigDecimal getAttributeSeq() {
		return this.attributeSeq;
	}

	public void setAttributeSeq(BigDecimal attributeSeq) {
		this.attributeSeq = attributeSeq;
	}

	public String getAttributeUniqueValueFlag() {
		return this.attributeUniqueValueFlag;
	}

	public void setAttributeUniqueValueFlag(String attributeUniqueValueFlag) {
		this.attributeUniqueValueFlag = attributeUniqueValueFlag;
	}

	public String getDefaultValue() {
		return this.defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getDefaultValueFlag() {
		return this.defaultValueFlag;
	}

	public void setDefaultValueFlag(String defaultValueFlag) {
		this.defaultValueFlag = defaultValueFlag;
	}

	public String getEntityAttributeCode() {
		return this.entityAttributeCode;
	}

	public void setEntityAttributeCode(String entityAttributeCode) {
		this.entityAttributeCode = entityAttributeCode;
	}

	public String getEntityAttributeDesc() {
		return this.entityAttributeDesc;
	}

	public void setEntityAttributeDesc(String entityAttributeDesc) {
		this.entityAttributeDesc = entityAttributeDesc;
	}

	public String getEntityCode() {
		return this.entityCode;
	}

	public void setEntityCode(String entityCode) {
		this.entityCode = entityCode;
	}

	public String getEntityDesc() {
		return this.entityDesc;
	}

	public void setEntityDesc(String entityDesc) {
		this.entityDesc = entityDesc;
	}

	public String getEntityType() {
		return this.entityType;
	}

	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

	public String getModuleCode() {
		return this.moduleCode;
	}

	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode;
	}

	public String getRequiredField() {
		return this.requiredField;
	}

	public void setRequiredField(String requiredField) {
		this.requiredField = requiredField;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Long getCombinationalGroupingNo() {
	    return combinationalGroupingNo;
	}

	public void setCombinationalGroupingNo(Long combinationalGroupingNo) {
	    this.combinationalGroupingNo = combinationalGroupingNo;
	}

	
}