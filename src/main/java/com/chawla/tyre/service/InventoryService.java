package com.chawla.tyre.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.chawla.tyre.entity.Inventory;
import com.chawla.tyre.repository.InventoryRepository;
import com.chawla.tyre.utility.Constants;

@Service
public class InventoryService {

	@Autowired
	InventoryRepository repo;

	public Inventory save(Inventory inventory) {
		repo.save(inventory);
		if (inventory.getInventoryId() != null)
			return inventory;
		else
			return null;
	}

	public List<Inventory> findProducts(Inventory inventory) {
		return findByCriteria(inventory);
	}

	private List<Inventory> findByCriteria(Inventory inventory) {
		return repo.findAll(new Specification<Inventory>() {
			@Override
			public Predicate toPredicate(Root<Inventory> root, CriteriaQuery<?> query,
					CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList<>();
				if (inventory.getCompany() != null && !inventory.getCompany().equals(Constants.EMPTY_STRING)) {
					predicates.add(
							criteriaBuilder.and(criteriaBuilder.equal(root.get("company"), inventory.getCompany())));
				}
				if (inventory.getCommodityType() != null
						&& !inventory.getCommodityType().equals(Constants.EMPTY_STRING)) {
					predicates.add(criteriaBuilder
							.and(criteriaBuilder.equal(root.get("commodityType"), inventory.getCommodityType())));
				}
				return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		});
	}
}
