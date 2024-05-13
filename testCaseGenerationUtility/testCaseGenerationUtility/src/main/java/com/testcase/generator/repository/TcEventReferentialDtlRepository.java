package com.testcase.generator.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.testcase.generator.model.TcEventReferentialDtl;

public interface TcEventReferentialDtlRepository extends CrudRepository<TcEventReferentialDtl, Long> {

    @Query("SELECT distinct t.eventCode FROM TcEventReferentialDtl t where t.eventCode like %:eventCode%") 
    List<String> findByEventCodeContaining(@Param("eventCode") String eventCode);

}
