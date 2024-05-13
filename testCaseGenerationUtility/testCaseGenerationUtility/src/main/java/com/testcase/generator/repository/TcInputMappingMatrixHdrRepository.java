package com.testcase.generator.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.testcase.generator.model.TcInputMappingMatrixHdr;

public interface TcInputMappingMatrixHdrRepository extends CrudRepository<TcInputMappingMatrixHdr, Long>{

    @Query("SELECT distinct t.functionalityCode FROM TcInputMappingMatrixHdr t where t.functionalityCode like :functionalityCode%") 
    List<String> findByFunctionalityCodeContaining(@Param("functionalityCode") String functionalityCode);

    @Query("SELECT distinct t.scenarioCode FROM TcInputMappingMatrixHdr t where t.scenarioCode like :scenarioCode%") 
    List<String> findByScenarioCodeContaining(@Param("scenarioCode") String scenarioCode);
}
