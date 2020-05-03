package com.chawla.tyre.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class BillDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long billDetailsId;
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "customerId")
    private Customer customer;
	@ElementCollection 
	private List<Bill> billList;
}
