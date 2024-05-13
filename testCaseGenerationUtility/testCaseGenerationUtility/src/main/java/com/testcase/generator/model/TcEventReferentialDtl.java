package com.testcase.generator.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the TC_EVENT_REFERENTIAL_DTLS database table.
 * 
 */
@Entity
@Table(name = "TC_EVENT_REFERENTIAL_DTLS")
@NamedQuery(name = "TcEventReferentialDtl.findAll", query = "SELECT t FROM TcEventReferentialDtl t")
public class TcEventReferentialDtl {

    @Id
    @SequenceGenerator(name = "TC_EVENT_REFERENTIAL_DTLS_EVENTREFDTLID_GENERATOR", sequenceName = "TC_EVENT_REFERENTIAL_DTLS_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TC_EVENT_REFERENTIAL_DTLS_EVENTREFDTLID_GENERATOR")
    @Column(name = "EVENT_REF_DTL_ID")
    private long eventRefDtlId;

    @Column(name = "ACTIVE_FLAG")
    private String activeFlag;

    @Column(name = "EVENT_ACTION_CODE")
    private String eventActionCode;

    @Column(name = "EVENT_ACTION_DESC")
    private String eventActionDesc;

    @Column(name = "EVENT_ACTION_INPUT_ATRIBUTES")
    private String eventActionInputAtributes;

    @Column(name = "EVENT_CODE")
    private String eventCode;

    @Column(name = "EVENT_DESC")
    private String eventDesc;

    @Column(name = "USER_ID")
    private String userId;

    public TcEventReferentialDtl() {
    }

    public long getEventRefDtlId() {
	return this.eventRefDtlId;
    }

    public void setEventRefDtlId(long eventRefDtlId) {
	this.eventRefDtlId = eventRefDtlId;
    }

    public String getActiveFlag() {
	return this.activeFlag;
    }

    public void setActiveFlag(String activeFlag) {
	this.activeFlag = activeFlag;
    }

    public String getEventActionCode() {
	return this.eventActionCode;
    }

    public void setEventActionCode(String eventActionCode) {
	this.eventActionCode = eventActionCode;
    }

    public String getEventActionDesc() {
	return this.eventActionDesc;
    }

    public void setEventActionDesc(String eventActionDesc) {
	this.eventActionDesc = eventActionDesc;
    }

    public String getEventActionInputAtributes() {
	return this.eventActionInputAtributes;
    }

    public void setEventActionInputAtributes(String eventActionInputAtributes) {
	this.eventActionInputAtributes = eventActionInputAtributes;
    }

    public String getEventCode() {
	return this.eventCode;
    }

    public void setEventCode(String eventCode) {
	this.eventCode = eventCode;
    }

    public String getEventDesc() {
	return this.eventDesc;
    }

    public void setEventDesc(String eventDesc) {
	this.eventDesc = eventDesc;
    }

    public String getUserId() {
	return this.userId;
    }

    public void setUserId(String userId) {
	this.userId = userId;
    }

}