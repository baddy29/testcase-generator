package com.testcase.generator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.testcase.generator.model.TcEventGroupHdr;
import com.testcase.generator.service.TcEventGroupService;

@Controller
public class TcEventGroupController {
    
    @Autowired
    private TcEventGroupService tcEventGroupService;
    
    private JSONPObject responseJsonEventGroupDetail;

    @GetMapping(value = "/tcEventGroupAdd")
    public String tcEventGroupAdd(ModelMap map) {
	map.put("tcEventGroupHdr", new TcEventGroupHdr());
	map.put("responseJsonEventGroupDetail", responseJsonEventGroupDetail);
	return "tcEventGroupAdd";
    }
    
    @GetMapping(value = "/getFunctionalityCodeList")
    @ResponseBody
    public List<String> getFunctionalityCodeList(@RequestParam("term") String functionalityCode) {
	List<String> functionalityCodeList = tcEventGroupService.findByFunctionalityCodeContaining(functionalityCode);
	return functionalityCodeList;
    }
    
    @GetMapping(value = "/getScenarioCodeList")
    @ResponseBody
    public List<String> getScenarioCodeList(@RequestParam("term") String scenarioCode) {
	List<String> scenarioCodeList = tcEventGroupService.findByScenarioCodeContaining(scenarioCode);
	return scenarioCodeList;
    }

    public JSONPObject getResponseJsonEventGroupDetail() {
	return responseJsonEventGroupDetail;
    }

    public void setResponseJsonEventGroupDetail(JSONPObject responseJsonEventGroupDetail) {
	this.responseJsonEventGroupDetail = responseJsonEventGroupDetail;
    }
}
