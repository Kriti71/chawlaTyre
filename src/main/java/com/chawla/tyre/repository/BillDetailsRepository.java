package com.chawla.tyre.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.chawla.tyre.entity.BillDetails;

public interface BillDetailsRepository
		extends CrudRepository<BillDetails, Long>, JpaSpecificationExecutor<BillDetails> {

}
