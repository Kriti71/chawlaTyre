package com.chawla.tyre.model;

import lombok.Data;

@Data
public class BillDetailsModel {
	private String customerName;
	private String customerAddress;
	private String vehicleNumber;
	private String phoneNumber;
	private String gstNumber;
	private BillModel bill;
}
