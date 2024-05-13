package com.testcase.generator.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * The persistent class for the TC_EVENT_GROUP_DTL database table.
 * 
 */
@Entity
@Table(name = "TC_EVENT_GROUP_DTL")
@NamedQuery(name = "TcEventGroupDtl.findAll", query = "SELECT t FROM TcEventGroupDtl t")
public class TcEventGroupDtl {

    @Id
    @SequenceGenerator(name = "TC_EVENT_GROUP_DTL_EVENTSGROUPDTLID_GENERATOR", sequenceName = "TC_EVENTS_GROUP_DTL_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TC_EVENT_GROUP_DTL_EVENTSGROUPDTLID_GENERATOR")
    @Column(name = "EVENTS_GROUP_DTL_ID")
    private long eventsGroupDtlId;

    @Column(name = "EVENT_REF_DTL_ID")
    private BigDecimal eventRefDtlId;

    @Column(name = "EVENTS_GROUP_EVENT_SEQ")
    private BigDecimal eventsGroupEventSeq;
    
    @Transient
    private String eventActionCode;
    
    @Transient
    private String eventCode;
    
    @Transient
    private String eventActionParameter;

    // bi-directional many-to-one association to TcEventGroupHdr
    @ManyToOne
    @JoinColumn(name = "EVENT_GROUP_ID")
    private TcEventGroupHdr tcEventGroupHdr;

    public TcEventGroupDtl() {
    }

    public long getEventsGroupDtlId() {
	return this.eventsGroupDtlId;
    }

    public void setEventsGroupDtlId(long eventsGroupDtlId) {
	this.eventsGroupDtlId = eventsGroupDtlId;
    }

    public BigDecimal getEventRefDtlId() {
	return this.eventRefDtlId;
    }

    public void setEventRefDtlId(BigDecimal eventRefDtlId) {
	this.eventRefDtlId = eventRefDtlId;
    }

    public BigDecimal getEventsGroupEventSeq() {
	return this.eventsGroupEventSeq;
    }

    public void setEventsGroupEventSeq(BigDecimal eventsGroupEventSeq) {
	this.eventsGroupEventSeq = eventsGroupEventSeq;
    }

    public TcEventGroupHdr getTcEventGroupHdr() {
	return this.tcEventGroupHdr;
    }

    public void setTcEventGroupHdr(TcEventGroupHdr tcEventGroupHdr) {
	this.tcEventGroupHdr = tcEventGroupHdr;
    }

    public String getEventActionCode() {
        return eventActionCode;
    }

    public void setEventActionCode(String eventActionCode) {
        this.eventActionCode = eventActionCode;
    }

    public String getEventActionParameter() {
        return eventActionParameter;
    }

    public void setEventActionParameter(String eventActionParameter) {
        this.eventActionParameter = eventActionParameter;
    }
    
    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }
}