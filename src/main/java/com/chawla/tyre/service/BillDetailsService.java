package com.chawla.tyre.service;

import java.io.ByteArrayInputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.chawla.tyre.entity.Bill;
import com.chawla.tyre.entity.BillDetails;
import com.chawla.tyre.entity.Customer;
import com.chawla.tyre.model.BillDetailsModel;
import com.chawla.tyre.repository.BillDetailsRepository;
import com.chawla.tyre.utility.Constants;
import com.chawla.tyre.utility.PdfGenerator;

@Service
@PropertySource("classpath:config.properties")
public class BillDetailsService {

	@Autowired
	BillDetailsRepository repo;

	@Autowired
	Environment env;

	private static DecimalFormat df2 = new DecimalFormat("#.##");

	public ByteArrayInputStream generateBill(BillDetailsModel billDetails) {

		BillDetails entity = new BillDetails();

		Customer customer = new Customer();
		customer.setName(billDetails.getCustomerName());
		customer.setAddress(billDetails.getCustomerAddress());
		customer.setPhoneNumber(
				billDetails.getPhoneNumber() != null ? Long.valueOf(billDetails.getPhoneNumber()) : null);
		customer.setVehicleNumber(billDetails.getVehicleNumber());
		customer.setGstNumber(billDetails.getGstNumber());

		entity.setCustomer(customer);

		int commaOccurance = billDetails.getBill().getDescription().split(",").length;
		String[] descArray = new String[commaOccurance];
		String[] spArray = new String[commaOccurance];
		String[] hsnArray = new String[commaOccurance];
		String[] quantityArray = new String[commaOccurance];
		String[] typeArray = new String[commaOccurance];

		if (billDetails.getBill().getDescription() != null
				&& !billDetails.getBill().getDescription().equals(Constants.EMPTY_STRING)) {
			descArray = billDetails.getBill().getDescription().split(",");
		}

		if (billDetails.getBill().getSellingPrice() != null
				&& !billDetails.getBill().getSellingPrice().equals(Constants.EMPTY_STRING)) {
			spArray = billDetails.getBill().getSellingPrice().split(",");
		}

		if (billDetails.getBill().getHsn() != null && !billDetails.getBill().getHsn().equals(Constants.EMPTY_STRING)) {
			hsnArray = billDetails.getBill().getHsn().split(",");
		}

		if (billDetails.getBill().getQuantity() != null
				&& !billDetails.getBill().getQuantity().equals(Constants.EMPTY_STRING)) {
			quantityArray = billDetails.getBill().getQuantity().split(",");
		}

		if (billDetails.getBill().getType() != null
				&& !billDetails.getBill().getType().equals(Constants.EMPTY_STRING)) {
			typeArray = billDetails.getBill().getType().split(",");
		}

		List<Bill> billList = new ArrayList<>();
		for (int i = 0; i < commaOccurance; i++) {
			Bill bill = new Bill();
			bill.setDescription(descArray[i]);
			bill.setSellingPrice(Double.parseDouble(spArray[i]));
			bill.setHsn(hsnArray[i]);
			bill.setQuantity(Integer.parseInt(quantityArray[i]));
			bill.setType(typeArray[i]);
			if (bill.getSellingPrice() > 0) {
				billList.add(bill);
			}
		}

		List<Bill> tubeAndFlapList = new ArrayList<>();
		for (Bill bill : billList) {
			bill.setSellingPrice(bill.getSellingPrice()
					- (bill.getQuantity() * (Double.valueOf(env.getProperty(Constants.TUBE_PRICE))
							+ Double.valueOf(env.getProperty(Constants.FLAP_PRICE)))));
			setTaxDetails(bill);

			// create tube and flap
			tubeAndFlapList.add(createTube(bill.getQuantity(), bill.getDescription()));
			tubeAndFlapList.add(createFlap(bill.getQuantity(), bill.getDescription()));
		}
		billList.addAll(tubeAndFlapList);
		entity.setBillList(billList);

		repo.save(entity);
		return PdfGenerator.inventoryPdfReport(entity);
	}

	private Bill createTube(int quantity, String desc) {
		Bill tube = new Bill();
		tube.setQuantity(quantity);
		tube.setSellingPrice(quantity * Double.valueOf(env.getProperty(Constants.TUBE_PRICE)));
		tube.setHsn(Constants.TUBE_HSN);
		tube.setDescription(Constants.TUBE);
		tube.setType(Constants.TUBE);
		setTaxDetails(tube);
		return tube;
	}

	private Bill createFlap(int quantity, String desc) {
		Bill flap = new Bill();
		flap.setType(Constants.FLAP);
		flap.setQuantity(quantity);
		flap.setSellingPrice(quantity * Double.valueOf(env.getProperty(Constants.FLAP_PRICE)));
		flap.setHsn(Constants.FLAP_HSN);
		flap.setDescription(desc + Constants.FLAP);
		setTaxDetails(flap);
		return flap;
	}

	private void setTaxDetails(Bill bill) {
		bill.setRate(Double.valueOf(Constants.TAX_RATE));
		double taxableValue = Double.parseDouble(df2.format((bill.getSellingPrice() * 100) / 128));
		bill.setTaxableValue(taxableValue);
		double tax = Double.parseDouble(df2.format((bill.getSellingPrice() - taxableValue) / 2));
		bill.setCgst(tax);
		bill.setSgst(tax);
	}
}
