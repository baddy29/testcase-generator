package com.testcase.generator.service;

import java.util.List;

public interface TcEventGroupService {

    List<String> findByFunctionalityCodeContaining(String functionlaityCode);

    List<String> findByScenarioCodeContaining(String scenarioCode);
}
