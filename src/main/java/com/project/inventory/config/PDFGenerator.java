/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.inventory.config;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.project.inventory.entity.Produk;
import java.awt.Font;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

/**
 *
 * @author i am me
 */
public class PDFGenerator {

    public static ByteArrayInputStream produkReport(List<Produk> products) {
        Document document = new Document(PageSize.A4, 25, 25, 25, 25);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            PdfWriter.getInstance(document, out);
            document.open();

            Paragraph title = new Paragraph("Laporan stok produk",
                    FontFactory.getFont(FontFactory.TIMES_ROMAN, 14,
                            Font.BOLD, BaseColor.BLACK));
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            float[] columnWidths = {5, 5, 5, 5, 5, 5};
            PdfPTable table = new PdfPTable(columnWidths);
            table.setWidthPercentage(100);
            table.setSpacingBefore(25);
            table.setSpacingAfter(25);

            PdfPCell c1 = new PdfPCell(new Phrase("No"));
            c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            c1.setHorizontalAlignment(Element.ALIGN_LEFT);
            c1.setPadding(5);
            c1.setNoWrap(true);
            table.addCell(c1);

            PdfPCell c2 = new PdfPCell(new Phrase("Nama Produk "));

            c2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            c2.setHorizontalAlignment(Element.ALIGN_LEFT);
            c1.setPadding(5);
            c1.setNoWrap(true);
            table.addCell(c2);

            PdfPCell c3 = new PdfPCell(new Phrase("Stok"));
            c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
            c3.setHorizontalAlignment(Element.ALIGN_LEFT);
            c1.setPadding(5);
            c1.setNoWrap(true);
            table.addCell(c3);

            PdfPCell c4 = new PdfPCell(new Phrase("Kategori"));
            c4.setVerticalAlignment(Element.ALIGN_MIDDLE);
            c4.setHorizontalAlignment(Element.ALIGN_LEFT);
            c1.setPadding(5);
            c1.setNoWrap(true);
            table.addCell(c4);

            PdfPCell c5 = new PdfPCell(new Phrase("Pemasok"));
            c5.setVerticalAlignment(Element.ALIGN_MIDDLE);
            c5.setHorizontalAlignment(Element.ALIGN_LEFT);
            c1.setPadding(5);
            c1.setNoWrap(true);
            table.addCell(c5);

            PdfPCell c6 = new PdfPCell(new Phrase("Harga"));
            c6.setVerticalAlignment(Element.ALIGN_MIDDLE);
            c6.setHorizontalAlignment(Element.ALIGN_LEFT);
            c1.setPadding(5);
            c1.setNoWrap(true);
            table.addCell(c6);
            
            
            String habis = "habis";
            Integer count = 0;
            for (Produk product : products) {
                count += 1;

                table.addCell(String.valueOf(count));
                table.addCell(product.getNama());

                if (product.getStok() == 0) {
                   table.addCell(habis);
                }else{
                    table.addCell(String.valueOf(product.getStok()));
                }
                
                table.addCell(String.valueOf(product.getKategoriId().getNamaKategori()));
                table.addCell(String.valueOf(product.getPemasokId().getNama()));
                table.addCell(String.valueOf(product.getHargaJual()));
            }

            document.add(table);

            document.close();
        } catch (DocumentException e) {
            System.out.println(e.toString());
        }
        return new ByteArrayInputStream(out.toByteArray());
    }

    public static ByteArrayInputStream transactionReport(List<TanggalAndTotalharga> reports) {
        
        Document document = new Document(PageSize.A4, 25, 25, 25, 25);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            PdfWriter.getInstance(document, out);
            document.open();
            Paragraph title = new Paragraph("Laporan Transaksi Produk",
                    FontFactory.getFont(FontFactory.TIMES_ROMAN, 14,
                            Font.BOLD, BaseColor.BLACK));
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            
            float[] columnWidths = {5, 5, 5};
            
            PdfPTable table = new PdfPTable(columnWidths);
            table.setWidthPercentage(100);
            table.setSpacingBefore(25);
            table.setSpacingAfter(25);

            PdfPCell c1 = new PdfPCell(new Phrase("No"));
            c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            c1.setHorizontalAlignment(Element.ALIGN_LEFT);
            c1.setPadding(5);
            c1.setNoWrap(true);
            table.addCell(c1);

            PdfPCell c2 = new PdfPCell(new Phrase("Bulan "));
            c2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            c2.setHorizontalAlignment(Element.ALIGN_LEFT);
            c2.setPadding(5);
            c2.setNoWrap(true);
            table.addCell(c2);
            
            
            PdfPCell c3 = new PdfPCell(new Phrase("Laba Bersih "));
            c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
            c3.setHorizontalAlignment(Element.ALIGN_LEFT);
            c3.setPadding(5);
            c3.setNoWrap(true);
            table.addCell(c3);
            
            Integer count = 0;
            String rp = "Rp.";
            for (TanggalAndTotalharga report : reports) {
                count++;
                table.addCell(String.valueOf(count));
                table.addCell(report.getBulan());
                table.addCell( String.valueOf( rp + report.getLaba_Bersih()) );
            }
            
            document.add(table);

            document.close();
            
        } catch (DocumentException e) {
            System.out.println(e.toString());
        }
        return new ByteArrayInputStream(out.toByteArray());
        
    }
}
