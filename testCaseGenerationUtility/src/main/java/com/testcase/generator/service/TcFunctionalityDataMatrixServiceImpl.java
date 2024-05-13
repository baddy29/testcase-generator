package com.testcase.generator.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testcase.generator.model.TcInputMappingMatrixHdr;
import com.testcase.generator.repository.TcInputMappingMatrixHdrRepository;

@Service
public class TcFunctionalityDataMatrixServiceImpl implements TcFunctionalityDataMatrixService{

    @Autowired
    private TcInputMappingMatrixHdrRepository tcInputMappingMatrixHdrRepository;
    
    @Override
    public List<Object[]> findByFunctionalityCodeContainingAndModuleCode(String functionalityCode,String moduleCode) {
	return tcInputMappingMatrixHdrRepository.findByFunctionalityCodeContainingAndModuleCode(functionalityCode,moduleCode);
    }

    @Override
    public List<Object[]> findByScenarioCodeContainingAndFunctionalityCode(String scenarioCode,String functionalityCode) {
	return tcInputMappingMatrixHdrRepository.findByScenarioCodeContainingAndFunctionalityCode(scenarioCode,functionalityCode);
    }

    @Override
    public TcInputMappingMatrixHdr findByHdrId(Long hdrId) {
	return tcInputMappingMatrixHdrRepository.findOne(hdrId);
    }

    @Override
    public List<TcInputMappingMatrixHdr> getTestDataGeneratedList(String scenarioCode, String functionalityCode) {
	return tcInputMappingMatrixHdrRepository.getTestDataGeneratedList(scenarioCode,functionalityCode);
    }

}
