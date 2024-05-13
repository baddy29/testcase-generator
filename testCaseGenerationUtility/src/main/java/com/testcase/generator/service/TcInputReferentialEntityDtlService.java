package com.testcase.generator.service;

import java.util.List;

import com.testcase.generator.model.TcInputMappingMatrixDtl;
import com.testcase.generator.model.TcInputReferentialEntityDtl;

public interface TcInputReferentialEntityDtlService {
    
    List<Object[]> findByModuleCode(String moduleCode);
    List<TcInputReferentialEntityDtl> findByEntityCode(String entityCode);
    void saveTestCaseData(List<TcInputMappingMatrixDtl> myObjects);
    void generateTestData(String scenarioCode, String functionalityCode);
    
}
