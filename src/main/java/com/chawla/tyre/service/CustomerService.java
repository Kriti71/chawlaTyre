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

import com.chawla.tyre.entity.Customer;
import com.chawla.tyre.repository.CustomerRepository;
import com.chawla.tyre.utility.Constants;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository repo;

	public Customer save(Customer customer) {
		repo.save(customer);
		if (customer.getCustomerId() != null)
			return customer;
		else
			return null;
	}

	public List<Customer> findCustomers(Customer customer) {
		return findByCriteria(customer);
	}

	private List<Customer> findByCriteria(Customer customerEntity) {
		return repo.findAll(new Specification<Customer>() {
			@Override
			public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList<>();
				if (customerEntity.getName() != null && !customerEntity.getName().equals(Constants.EMPTY_STRING)) {
					predicates.add(
							criteriaBuilder.and(criteriaBuilder.equal(root.get("name"), customerEntity.getName())));
				}
				if (customerEntity.getPhoneNumber() != null
						&& !customerEntity.getPhoneNumber().equals(Constants.EMPTY_STRING)) {
					predicates.add(criteriaBuilder
							.and(criteriaBuilder.equal(root.get("phoneNumber"), customerEntity.getPhoneNumber())));
				}

				if (customerEntity.getVehicleNumber() != null
						&& !customerEntity.getVehicleNumber().equals(Constants.EMPTY_STRING)) {
					predicates.add(criteriaBuilder
							.and(criteriaBuilder.equal(root.get("vehicleNumber"), customerEntity.getVehicleNumber())));
				}
				return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		});
	}
}
