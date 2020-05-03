package com.chawla.tyre.utility;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Stream;

import com.chawla.tyre.entity.Bill;
import com.chawla.tyre.entity.BillDetails;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PdfGenerator {

	public static ByteArrayInputStream inventoryPdfReport(BillDetails billDetailsModel) {
		Document document = new Document();
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {

			PdfWriter.getInstance(document, out);
			document.open();

			// Add Text to PDF file ->
			Font font = FontFactory.getFont(FontFactory.COURIER, 18, BaseColor.BLACK);

			PdfPTable table1 = new PdfPTable(3);
			PdfPCell idCell1 = new PdfPCell(new Phrase("GSTIN:71638761ASKJ"));
			idCell1.setPaddingLeft(0);
			idCell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			idCell1.setBorder(0);
			table1.addCell(idCell1);

			PdfPCell idCell2 = new PdfPCell(new Phrase("CHAWLA TYRE", FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
			idCell2.setPaddingLeft(40);
			idCell2.setHorizontalAlignment(Element.ALIGN_MIDDLE);
			idCell2.setBorder(0);
			table1.addCell(idCell2);

			PdfPCell idCell3 = new PdfPCell(new Phrase(new SimpleDateFormat("dd-MM-yyyy").format(new Date())));
			idCell3.setHorizontalAlignment(Element.ALIGN_RIGHT);
			idCell3.setBorder(0);
			table1.addCell(idCell3);

			document.add(table1);

			document.add(Chunk.NEWLINE);

			Paragraph para1 = new Paragraph("23, Ram Kumar Ganguly Lane, Howrah - 711103");
			para1.setAlignment(Element.ALIGN_CENTER);
			document.add(para1);
			document.add(Chunk.NEWLINE);

			PdfPTable table2 = new PdfPTable(new float[] { 30, 70 });
			PdfPCell cell1 = new PdfPCell(new Phrase("Customer Name", FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
			cell1.setPaddingLeft(4);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table2.addCell(cell1);

			PdfPCell cell2 = new PdfPCell(new Phrase(billDetailsModel.getCustomer().getName()));
			cell2.setPaddingLeft(4);
			cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table2.addCell(cell2);
			table2.completeRow();

			PdfPCell cell3 = new PdfPCell(new Phrase("Address", FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
			cell3.setPaddingLeft(4);
			cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table2.addCell(cell3);

			PdfPCell cell4 = new PdfPCell(new Phrase(billDetailsModel.getCustomer().getAddress()));
			cell4.setPaddingLeft(4);
			cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
			table2.addCell(cell4);
			table2.completeRow();
			document.add(table2);
			document.add(Chunk.NEWLINE);

			PdfPTable table = new PdfPTable(10);
			// Add PDF Table Header ->
			Stream.of("Sr No", "Desc", "HSN", "Quantity", "Rate", "Taxable Value", "CGST", "SGST", "iGST", "TOTAL")
					.forEach(headerTitle -> {
						PdfPCell header = new PdfPCell();
						Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
						header.setBackgroundColor(BaseColor.LIGHT_GRAY);
						header.setHorizontalAlignment(Element.ALIGN_CENTER);
						header.setBorderWidth(2);
						header.setPhrase(new Phrase(headerTitle, headFont));
						table.addCell(header);
					});
			double totalSum = 0;
			int i = 1;
			for (Bill billList : billDetailsModel.getBillList()) {
				PdfPCell idCell = new PdfPCell(new Phrase(String.valueOf(i)));
				idCell.setPaddingLeft(4);
				idCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				idCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(idCell);

				PdfPCell descCell = new PdfPCell(new Phrase(billList.getDescription()));
				descCell.setPaddingLeft(4);
				descCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				descCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				table.addCell(descCell);

				PdfPCell hsnCell = new PdfPCell(new Phrase(String.valueOf(billList.getHsn())));
				hsnCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				hsnCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				hsnCell.setPaddingRight(4);
				table.addCell(hsnCell);

				PdfPCell qtyCell = new PdfPCell(new Phrase(String.valueOf(billList.getQuantity())));
				qtyCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				qtyCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				qtyCell.setPaddingRight(4);
				table.addCell(qtyCell);

				PdfPCell rateCell = new PdfPCell(new Phrase(String.valueOf(billList.getRate())));
				rateCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				rateCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				rateCell.setPaddingRight(4);
				table.addCell(rateCell);

				PdfPCell taxableValueCell = new PdfPCell(new Phrase(String.valueOf(billList.getTaxableValue())));
				taxableValueCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				taxableValueCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				taxableValueCell.setPaddingRight(4);
				table.addCell(taxableValueCell);

				PdfPCell cgstCell = new PdfPCell(new Phrase(String.valueOf(billList.getCgst())));
				cgstCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cgstCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				cgstCell.setPaddingRight(4);
				table.addCell(cgstCell);

				PdfPCell sgstCell = new PdfPCell(new Phrase(String.valueOf(billList.getSgst())));
				sgstCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				sgstCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				sgstCell.setPaddingRight(4);
				table.addCell(sgstCell);

				PdfPCell igstCell = new PdfPCell(new Phrase(String.valueOf(billList.getIgst())));
				igstCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				igstCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				igstCell.setPaddingRight(4);
				table.addCell(igstCell);

				PdfPCell totalCell = new PdfPCell(new Phrase(String.valueOf(billList.getSellingPrice())));
				totalCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				totalCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				totalCell.setPaddingRight(4);
				table.addCell(totalCell);
				totalSum += billList.getSellingPrice();

				table.completeRow();
				i++;

			}

			document.add(table);

			document.add(Chunk.NEWLINE);

			PdfPTable table3 = new PdfPTable(new float[] { 20, 80 });
			PdfPCell totalCell = new PdfPCell(new Phrase("TOTAL", FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
			totalCell.setPaddingLeft(4);
			totalCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			totalCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3.addCell(totalCell);

			PdfPCell wordsCell = new PdfPCell(new Phrase(NumberToWord.convert(totalSum)+" ("+totalSum+")"));
			wordsCell.setPaddingLeft(4);
			wordsCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			wordsCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3.addCell(wordsCell);

			document.add(table3);

			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);

			Paragraph p = new Paragraph("Signature");
			p.setAlignment(Element.ALIGN_RIGHT);
			document.add(p);

			Paragraph p1 = new Paragraph("-For Chawla Tyre");
			p1.setAlignment(Element.ALIGN_RIGHT);
			document.add(p1);

			document.close();
		} catch (DocumentException e) {
			log.error(e.toString());
		}

		return new ByteArrayInputStream(out.toByteArray());
	}
}
