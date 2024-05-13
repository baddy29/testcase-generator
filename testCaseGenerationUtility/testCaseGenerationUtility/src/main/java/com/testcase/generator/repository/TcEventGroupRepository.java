package com.testcase.generator.repository;

import org.springframework.data.repository.CrudRepository;

import com.testcase.generator.model.TcEventGroupHdr;

public interface TcEventGroupRepository  extends CrudRepository<TcEventGroupHdr, Long>{

}
