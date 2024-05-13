package com.testcase.generator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testcase.generator.repository.TcInputMappingMatrixHdrRepository;

@Service
public class TcEventGroupServiceImpl implements TcEventGroupService{

    @Autowired
    private TcInputMappingMatrixHdrRepository tcInputMappingMatrixHdrRepository;
    
    @Override
    public List<String> findByFunctionalityCodeContaining(String functionalityCode) {
	return tcInputMappingMatrixHdrRepository.findByFunctionalityCodeContaining(functionalityCode);
    }

    @Override
    public List<String> findByScenarioCodeContaining(String scenarioCode) {
	return tcInputMappingMatrixHdrRepository.findByScenarioCodeContaining(scenarioCode);
    }

}
