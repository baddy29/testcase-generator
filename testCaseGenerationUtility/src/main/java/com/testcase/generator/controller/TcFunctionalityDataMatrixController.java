package com.testcase.generator.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.testcase.generator.model.TcInputMappingMatrixDtl;
import com.testcase.generator.model.TcInputMappingMatrixHdr;
import com.testcase.generator.model.TcInputReferentialEntityDtl;
import com.testcase.generator.service.TcFunctionalityDataMatrixService;
import com.testcase.generator.service.TcInputReferentialEntityDtlService;

@Controller
public class TcFunctionalityDataMatrixController {

    @Autowired
    private TcFunctionalityDataMatrixService tcFunctionalityDataMatrixService;

    @Autowired
    private TcInputReferentialEntityDtlService tcInputReferentialEntityDtlService;

    @GetMapping(value = "/tcFunctionalityDataMatrixAdd")
    public String tcFunctionalityDataMatrixAdd(ModelMap map) {
	map.put("tcInputMappingMatrixHdr", new TcInputMappingMatrixHdr());
	Map<String, String> moduleList = new HashMap<String, String>();
	moduleList.put("COMMON", "Common");
	moduleList.put("Security(SMS)", "Security(SMS)");
	moduleList.put("Payments", "Payments");
	moduleList.put("RECEIVABLES", "Receivables");
	moduleList.put("Liquidity Mgmt", "Liquidity Mgmt");
	moduleList.put("Financial Supply Chain", "Financial Supply Chain");
	moduleList.put("Electronic Bill Payments", "Electronic Bill Payments");
	moduleList.put("Internet Banking(Digital Compass)", "Internet Banking(Digital Compass)");
	map.put("moduleCodeList", moduleList);
	Map<String, String> combinationLogicList = new HashMap<String, String>();
	combinationLogicList.put("All Possible", "All Possible");
	combinationLogicList.put("Entity Level", "Entity Level");
	combinationLogicList.put("High Probability Combination", "High Probability Combination");
	map.put("combinationLogicList", combinationLogicList);
	return "tcFunctionalityDataMatrixAdd";
    }

    @PostMapping(value = "/getFunctionalityCodeList")
    @ResponseBody
    public List<Object[]> getFunctionalityCodeList(@RequestParam("term") String functionalityCode, @RequestParam String moduleCode) {
	List<Object[]> functionalityCodeList = tcFunctionalityDataMatrixService.findByFunctionalityCodeContainingAndModuleCode(functionalityCode, moduleCode);
	return functionalityCodeList;
    }

    @PostMapping(value = "/getScenarioCodeList")
    @ResponseBody
    public List<Object[]> getScenarioCodeList(@RequestParam("term") String scenarioCode, @RequestParam("functionalityCode") String functionalityCode) {
	List<Object[]> scenarioCodeList = tcFunctionalityDataMatrixService.findByScenarioCodeContainingAndFunctionalityCode(scenarioCode, functionalityCode);
	return scenarioCodeList;
    }

    @PostMapping(value = "/getTestCaseEntityGrid")
    @ResponseBody
    public List<TcInputReferentialEntityDtl> getTestCaseEntityGrid(@ModelAttribute TcInputMappingMatrixHdr tcInputMappingMatrixHdr) {
	List<Object[]> objList = tcInputReferentialEntityDtlService.findByModuleCode(tcInputMappingMatrixHdr.getModuleCode());
	List<TcInputReferentialEntityDtl> tcInputMappingMatrixHdrList = new ArrayList<>();
	for (Object[] obj : objList) {
	    TcInputReferentialEntityDtl tcInputReferentialEntityDtl = new TcInputReferentialEntityDtl();
	    tcInputReferentialEntityDtl.setEntityCode(obj[0].toString());
	    tcInputReferentialEntityDtl.setEntityDesc(obj[1].toString());
	    tcInputReferentialEntityDtl.setEntityType(obj[2].toString());
	    tcInputMappingMatrixHdrList.add(tcInputReferentialEntityDtl);
	}
	return tcInputMappingMatrixHdrList;
    }

    @PostMapping(value = "/getTestCaseEntityGridDetails")
    @ResponseBody
    public List<TcInputReferentialEntityDtl> getTestCaseEntityGridDetails(@RequestParam String entityCode) {
	List<TcInputReferentialEntityDtl> tcInputMappingMatrixHdrList = tcInputReferentialEntityDtlService.findByEntityCode(entityCode);
	return tcInputMappingMatrixHdrList;
    }

    @PostMapping(value = "/saveTestCaseData")
    public String saveTestCaseData(ModelMap map, TcInputMappingMatrixDtl tcInputMappingMatrixDtl) {
	try {
	    String testcaseDate = tcInputMappingMatrixDtl.getTestCaseData();
	    ObjectMapper mapper = new ObjectMapper();
	    List<TcInputMappingMatrixDtl> myObjects = mapper.readValue(testcaseDate, new TypeReference<List<TcInputMappingMatrixDtl>>() {
	    });
	    tcInputReferentialEntityDtlService.saveTestCaseData(myObjects);
	    TcInputMappingMatrixHdr tcInputMappingHdr = tcFunctionalityDataMatrixService.findByHdrId(tcInputMappingMatrixDtl.getHdrId());
	    map.put("tcInputMappingMatrixHdr", tcInputMappingHdr);
	    Map<String, String> moduleList = new HashMap<String, String>();
	    moduleList.put("COMMON", "Common");
	    moduleList.put("Security(SMS)", "Security(SMS)");
	    moduleList.put("Payments", "Payments");
	    moduleList.put("RECEIVABLES", "Receivables");
	    moduleList.put("Liquidity Mgmt", "Liquidity Mgmt");
	    moduleList.put("Financial Supply Chain", "Financial Supply Chain");
	    moduleList.put("Electronic Bill Payments", "Electronic Bill Payments");
	    moduleList.put("Internet Banking(Digital Compass)", "Internet Banking(Digital Compass)");
	    map.put("moduleCodeList", moduleList);
	    Map<String, String> combinationLogicList = new HashMap<String, String>();
	    combinationLogicList.put("All Possible", "All Possible");
	    combinationLogicList.put("Entity Level", "Entity Level");
	    combinationLogicList.put("High Probability Combination", "High Probability Combination");
	    map.put("combinationLogicList", combinationLogicList);
	} catch (JsonParseException e) {
	    e.printStackTrace();
	} catch (JsonMappingException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return "tcFunctionalityDataMatrixAdd";

    }

    @PostMapping(value = "/generateTestData")
    public void generateTestData(@RequestParam("scenarioCode") String scenarioCode, @RequestParam("functionalityCode") String functionalityCode) {
	tcInputReferentialEntityDtlService.generateTestData(scenarioCode, functionalityCode);
    }

    @GetMapping(value = "/tcFunctionalityDataMatrixList")
    public String tcFunctionalityDataMatrixList(ModelMap map) {
	map.put("tcInputMappingMatrixHdr", new TcInputMappingMatrixHdr());
	Map<String, String> moduleList = new HashMap<String, String>();
	moduleList.put("COMMON", "Common");
	moduleList.put("Security(SMS)", "Security(SMS)");
	moduleList.put("Payments", "Payments");
	moduleList.put("RECEIVABLES", "Receivables");
	moduleList.put("Liquidity Mgmt", "Liquidity Mgmt");
	moduleList.put("Financial Supply Chain", "Financial Supply Chain");
	moduleList.put("Electronic Bill Payments", "Electronic Bill Payments");
	moduleList.put("Internet Banking(Digital Compass)", "Internet Banking(Digital Compass)");
	map.put("moduleCodeList", moduleList);
	return "tcFunctionalityDataMatrixList";
    }

    @PostMapping(value = "/getTestDataGeneratedList")
    @ResponseBody
    public List<TcInputMappingMatrixHdr> getTestDataGeneratedList(@RequestParam("scenarioCode") String scenarioCode, @RequestParam("functionalityCode") String functionalityCode) {
	List<TcInputMappingMatrixHdr> tcInputMappingMatrixHdrList = tcFunctionalityDataMatrixService.getTestDataGeneratedList(scenarioCode, functionalityCode);
	for (TcInputMappingMatrixHdr tcInputMappingMatrixHdr : tcInputMappingMatrixHdrList) {
	    if (CollectionUtils.isEmpty(tcInputMappingMatrixHdr.getTcInputMappingMatrixDtl())) {
		tcInputMappingMatrixHdrList.remove(tcInputMappingMatrixHdr);
	    } else {
		if (StringUtils.equalsIgnoreCase(tcInputMappingMatrixHdr.getTcInputMappingMatrixDtl().get(0).getActiveFlag(), "Y"))
		    tcInputMappingMatrixHdr.setActiveFlag("Active");
		else
		    tcInputMappingMatrixHdr.setActiveFlag("Inactive");
	    }
	}
	return tcInputMappingMatrixHdrList;
    }

}
