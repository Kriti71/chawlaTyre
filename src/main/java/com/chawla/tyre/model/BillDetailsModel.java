package com.chawla.tyre.model;

import lombok.Data;

@Data
public class BillDetailsModel {
	private String customerName;
	private String customerAddress;
	private BillModel bill;
}
