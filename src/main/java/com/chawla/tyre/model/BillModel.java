package com.chawla.tyre.model;

import lombok.Data;

@Data
public class BillModel {
	private String type;
	private String sellingPrice;
	private String hsn;
	private String quantity;
	private String description;
	private double rate;
	private double taxableValue;
	private double cgst;
	private double sgst;
	private double igst;
}
