package com.chawla.tyre.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Inventory {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long inventoryId;
	private String company;
	private String model;
	private String hsn;
	private String commodityType;
	private String number;
}
