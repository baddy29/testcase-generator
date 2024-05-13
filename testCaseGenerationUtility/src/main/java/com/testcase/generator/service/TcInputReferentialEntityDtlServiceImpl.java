package com.testcase.generator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testcase.generator.model.TcInputMappingMatrixDtl;
import com.testcase.generator.model.TcInputReferentialEntityDtl;
import com.testcase.generator.repository.TcInputMappingMatrixDtlRepository;
import com.testcase.generator.repository.TcInputReferentialEntityDtlRepository;

@Service
public class TcInputReferentialEntityDtlServiceImpl implements TcInputReferentialEntityDtlService{

    @Autowired
    private TcInputReferentialEntityDtlRepository tcInputReferentialEntityDtlRepository;
    
    @Autowired
    private TcInputMappingMatrixDtlRepository tcInputMappingMatrixDtlRepository;
    
    @Override
    public List<Object[]> findByModuleCode(String moduleCode) {
	return tcInputReferentialEntityDtlRepository.findByModuleCode(moduleCode);
    }

    @Override
    public List<TcInputReferentialEntityDtl> findByEntityCode(String entityCode) {
	return tcInputReferentialEntityDtlRepository.findByEntityCode(entityCode);
    }

    @Override
    public void saveTestCaseData(List<TcInputMappingMatrixDtl> myObjects) {
	tcInputMappingMatrixDtlRepository.save(myObjects);
    }

    @Override
    public void generateTestData(String scenarioCode, String functionalityCode) {
	tcInputMappingMatrixDtlRepository.generateTestData(scenarioCode,functionalityCode);
    }

}
