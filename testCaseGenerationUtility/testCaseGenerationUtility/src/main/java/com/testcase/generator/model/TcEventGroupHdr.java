package com.testcase.generator.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * The persistent class for the TC_EVENT_GROUP_HDR database table.
 * 
 */
@Entity
@Table(name = "TC_EVENT_GROUP_HDR")
@NamedQuery(name = "TcEventGroupHdr.findAll", query = "SELECT t FROM TcEventGroupHdr t")
public class TcEventGroupHdr {

    @Id
    @SequenceGenerator(name = "TC_EVENT_GROUP_HDR_EVENTSGROUPID_GENERATOR", sequenceName = "TC_EVENTS_GROUP_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TC_EVENT_GROUP_HDR_EVENTSGROUPID_GENERATOR")
    @Column(name = "EVENTS_GROUP_ID")
    private long eventsGroupId;

    @Column(name = "EVENTS_GROUP_CODE")
    private String eventsGroupCode;

    @Column(name = "EVENTS_GROUP_DESC")
    private String eventsGroupDesc;

    @Column(name = "HDR_ID")
    private BigDecimal hdrId;

    // bi-directional many-to-one association to TcEventGroupDtl
    @OneToMany(mappedBy = "tcEventGroupHdr", cascade = { CascadeType.ALL })
    private List<TcEventGroupDtl> tcEventGroupDtls;

    @Transient
    private String functionalityCode;

    @Transient
    private String functionalityDesc;

    @Transient
    private String scenarioCode;

    @Transient
    private String scenarioDesc;

    public TcEventGroupHdr() {
    }

    public long getEventsGroupId() {
	return this.eventsGroupId;
    }

    public void setEventsGroupId(long eventsGroupId) {
	this.eventsGroupId = eventsGroupId;
    }

    public String getEventsGroupCode() {
	return this.eventsGroupCode;
    }

    public void setEventsGroupCode(String eventsGroupCode) {
	this.eventsGroupCode = eventsGroupCode;
    }

    public String getEventsGroupDesc() {
	return this.eventsGroupDesc;
    }

    public void setEventsGroupDesc(String eventsGroupDesc) {
	this.eventsGroupDesc = eventsGroupDesc;
    }

    public BigDecimal getHdrId() {
	return this.hdrId;
    }

    public void setHdrId(BigDecimal hdrId) {
	this.hdrId = hdrId;
    }

    public List<TcEventGroupDtl> getTcEventGroupDtls() {
	return this.tcEventGroupDtls;
    }

    public void setTcEventGroupDtls(List<TcEventGroupDtl> tcEventGroupDtls) {
	this.tcEventGroupDtls = tcEventGroupDtls;
    }

    public String getFunctionalityCode() {
	return functionalityCode;
    }

    public void setFunctionalityCode(String functionalityCode) {
	this.functionalityCode = functionalityCode;
    }

    public String getFunctionalityDesc() {
	return functionalityDesc;
    }

    public void setFunctionalityDesc(String functionalityDesc) {
	this.functionalityDesc = functionalityDesc;
    }

    public String getScenarioCode() {
	return scenarioCode;
    }

    public void setScenarioCode(String scenarioCode) {
	this.scenarioCode = scenarioCode;
    }

    public String getScenarioDesc() {
	return scenarioDesc;
    }

    public void setScenarioDesc(String scenarioDesc) {
	this.scenarioDesc = scenarioDesc;
    }

    public TcEventGroupDtl addTcEventGroupDtl(TcEventGroupDtl tcEventGroupDtl) {
	getTcEventGroupDtls().add(tcEventGroupDtl);
	tcEventGroupDtl.setTcEventGroupHdr(this);
	return tcEventGroupDtl;
    }

    public TcEventGroupDtl removeTcEventGroupDtl(TcEventGroupDtl tcEventGroupDtl) {
	getTcEventGroupDtls().remove(tcEventGroupDtl);
	tcEventGroupDtl.setTcEventGroupHdr(null);
	return tcEventGroupDtl;
    }

}