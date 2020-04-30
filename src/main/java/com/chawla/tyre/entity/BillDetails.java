package com.chawla.tyre.entity;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class BillDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long billDetailsId;
	private String customerName;
	private String customerAddress;
	@ElementCollection 
	private List<Bill> billList;
}
