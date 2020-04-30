package com.chawla.tyre.controller;

import java.io.ByteArrayInputStream;

import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.chawla.tyre.model.BillDetailsModel;
import com.chawla.tyre.service.BillDetailsService;

@Controller
public class BillDetailsController {
	@Autowired
	BillDetailsService service;
	
	@GetMapping("/billQuery")
	public String billQuery() {
		return "billQuery";
	}

	@PostMapping("/generatePdf")
	public ResponseEntity generateBill(BillDetailsModel billDetails) throws UserException {

		ByteArrayInputStream bis = service.generateBill(billDetails);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename=inventoryreport.pdf");

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}
}
