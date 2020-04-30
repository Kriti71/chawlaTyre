package com.chawla.tyre.service;

import java.io.ByteArrayInputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chawla.tyre.entity.Bill;
import com.chawla.tyre.entity.BillDetails;
import com.chawla.tyre.model.BillDetailsModel;
import com.chawla.tyre.repository.BillDetailsRepository;
import com.chawla.tyre.utility.PdfGenerator;

@Service
public class BillDetailsService {

	@Autowired
	BillDetailsRepository repo;

	private static DecimalFormat df2 = new DecimalFormat("#.##");

	public ByteArrayInputStream generateBill(BillDetailsModel billDetails) {

		BillDetails entity = new BillDetails();
		entity.setCustomerName(billDetails.getCustomerName());
		entity.setCustomerAddress(billDetails.getCustomerAddress());

		int commaOccurance = billDetails.getBill().getDescription().split(",").length;

		String[] descArray = billDetails.getBill().getDescription().split(",");
		String[] spArray = billDetails.getBill().getSellingPrice().split(",");
		String[] hsnArray = billDetails.getBill().getHsn().split(",");
		String[] quantityArray = billDetails.getBill().getQuantity().split(",");

		List<Bill> billList = new ArrayList<>();
		for (int i = 0; i < commaOccurance; i++) {
			Bill bill = new Bill();
			bill.setDescription(descArray[i]);
			bill.setSellingPrice(Double.parseDouble(spArray[i]));
			bill.setHsn(hsnArray[i]);
			bill.setQuantity(Integer.parseInt(quantityArray[i]));
			billList.add(bill);
		}
		entity.setBillList(billList);

		for (Bill bill : billList) {
			bill.setRate(28);
			double taxableValue = Double.parseDouble(df2.format((bill.getSellingPrice() * 100) / 128));
			bill.setTaxableValue(taxableValue);
			double tax = Double.parseDouble(df2.format((bill.getSellingPrice() - taxableValue) / 2));
			bill.setCgst(tax);
			bill.setSgst(tax);
		}
		repo.save(entity);
		return PdfGenerator.inventoryPdfReport(entity);
	}
}
