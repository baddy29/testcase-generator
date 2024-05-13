package com.testcase.generator.service;

import java.util.List;

public interface TcEventReferentialDtlService {

    List<String> findByEventCodeContaining(String eventCode);

	
}
