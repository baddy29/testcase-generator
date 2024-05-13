package com.testcase.generator.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.testcase.generator.model.TcInputReferentialEntityDtl;

public interface TcInputReferentialEntityDtlRepository extends CrudRepository<TcInputReferentialEntityDtl, Long>{

    @Query("select distinct t.entityCode,t.entityDesc,t.entityType FROM TcInputReferentialEntityDtl t where t.moduleCode=:moduleCode")
    List<Object[]> findByModuleCode(@Param("moduleCode") String moduleCode);

    List<TcInputReferentialEntityDtl> findByEntityCode(@Param("entityCode") String entityCode);
}
