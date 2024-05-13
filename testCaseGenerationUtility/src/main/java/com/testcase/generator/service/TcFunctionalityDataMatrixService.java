package com.testcase.generator.service;

import java.util.List;

import com.testcase.generator.model.TcInputMappingMatrixHdr;

public interface TcFunctionalityDataMatrixService {

    List<Object[]> findByFunctionalityCodeContainingAndModuleCode(String functionlaityCode,String moduleCode);

    List<Object[]> findByScenarioCodeContainingAndFunctionalityCode(String scenarioCode,String functionlaityCode);

    TcInputMappingMatrixHdr findByHdrId(Long hdrId);

    List<TcInputMappingMatrixHdr> getTestDataGeneratedList(String scenarioCode, String functionalityCode);
}
