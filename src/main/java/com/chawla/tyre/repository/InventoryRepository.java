package com.chawla.tyre.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.chawla.tyre.entity.Inventory;

public interface InventoryRepository extends CrudRepository<Inventory, Long>, JpaSpecificationExecutor<Inventory> {

}
