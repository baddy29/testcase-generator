package com.testcase.generator.repository;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.testcase.generator.model.TcInputMappingMatrixDtl;

public interface TcInputMappingMatrixDtlRepository extends CrudRepository<TcInputMappingMatrixDtl, Long>{

    @Procedure(name = "tc_permutational_matrix")
    String generateTestData(@Param("pi_scenario_code") String scenarioCode,@Param("pi_functionality_code") String functionalityCode);

}
