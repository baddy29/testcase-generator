package com.testcase.generator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.testcase.generator.model.TcEventReferentialDtl;
import com.testcase.generator.service.TcEventReferentialDtlService;

@Controller
public class TcEventReferentialDtlController {
    
    @Autowired
    private TcEventReferentialDtlService tcEventReferentialDtlService;

    @GetMapping(value = "/tcEventReferentialDtlList")
    public String openSearchPage(ModelMap map) {
	map.put("tcEventReferentialDtl", new TcEventReferentialDtl());
	return "tcEventReferentialDtlList";
    }

    @GetMapping(value = "/getEventCodeList")
    @ResponseBody
    public List<String> getEventCodeList(@RequestParam("term") String eventCode) {
	List<String> eventCodeList = tcEventReferentialDtlService.findByEventCodeContaining(eventCode);
	return eventCodeList;
    }

}
