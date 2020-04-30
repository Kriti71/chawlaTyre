package com.chawla.tyre.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.chawla.tyre.entity.Customer;

public interface CustomerRepository
		extends CrudRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {
	
	@Query("select c from Customer c where c.name = ?1")
	List<Customer> getCustomerByName(@Param("name") String name);	 
	
}
