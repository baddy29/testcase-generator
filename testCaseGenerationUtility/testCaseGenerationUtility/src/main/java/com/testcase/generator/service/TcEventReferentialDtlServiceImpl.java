package com.testcase.generator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testcase.generator.repository.TcEventReferentialDtlRepository;

@Service
public class TcEventReferentialDtlServiceImpl implements TcEventReferentialDtlService {
    
    @Autowired
    private TcEventReferentialDtlRepository tcEventReferentialDtlRepository;

    @Override
    public List<String> findByEventCodeContaining(String eventCode) {
	return tcEventReferentialDtlRepository.findByEventCodeContaining(eventCode);
    }
	

	

}
