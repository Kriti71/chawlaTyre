package com.chawla.tyre.entity;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Bill {
	private double sellingPrice;
	private String hsn;
	private int quantity;
	private String description;
	private double rate;
	private double taxableValue;
	private double cgst;
	private double sgst;
	private double igst;
}
