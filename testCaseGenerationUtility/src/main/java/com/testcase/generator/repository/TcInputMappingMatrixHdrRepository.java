package com.testcase.generator.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.testcase.generator.model.TcInputMappingMatrixHdr;

public interface TcInputMappingMatrixHdrRepository extends CrudRepository<TcInputMappingMatrixHdr, Long>{

    @Query("SELECT distinct t.functionalityCode,t.functionalityDesc FROM TcInputMappingMatrixHdr t where t.moduleCode=:moduleCode and t.functionalityCode like :functionalityCode%") 
    List<Object[]> findByFunctionalityCodeContainingAndModuleCode(@Param("functionalityCode") String functionalityCode,@Param("moduleCode") String moduleCode);

    @Query("SELECT distinct t.scenarioCode,t.scenarioDesc,t.hdrId FROM TcInputMappingMatrixHdr t where t.functionalityCode =:functionalityCode and t.scenarioCode like :scenarioCode%") 
    List<Object[]> findByScenarioCodeContainingAndFunctionalityCode(@Param("scenarioCode") String scenarioCode, @Param("functionalityCode") String functionalityCode);

    @Query("SELECT t FROM TcInputMappingMatrixHdr t where t.functionalityCode =:functionalityCode and t.scenarioCode =:scenarioCode")
    List<TcInputMappingMatrixHdr> getTestDataGeneratedList(@Param("scenarioCode")String scenarioCode,@Param("functionalityCode") String functionalityCode);
}
