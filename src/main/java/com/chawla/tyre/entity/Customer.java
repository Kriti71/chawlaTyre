package com.chawla.tyre.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long customerId;
	private String name;
	private Long phoneNumber;
	private String vehicleNumber;
	private String address;
	private String bank;
	private String gstNumber;
}
