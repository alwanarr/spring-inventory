/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.inventory.service;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.project.inventory.entity.Produk;
import com.project.inventory.repository.ProdukRepository;
import java.awt.Font;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author i am me
 */
@Service
public class LaporanService {
    @Autowired
    ProdukRepository produkRepo;
//    ResponseEntity<Resource> 
    public Document generateReportOfProduct(ByteArrayOutputStream os) throws DocumentException {
        List<Produk> products = (List<Produk>) produkRepo.findAll();
        
        
        
        Document document = new Document(PageSize.A4, 25, 25, 25, 25);
        
        
        PdfWriter.getInstance(document, os);
        
        document.open();
        
        Paragraph title = new Paragraph("Laporan produk bulan ini", 
                        FontFactory.getFont(FontFactory.TIMES_ROMAN, 14,
                                Font.BOLD,  new BaseColor(0, 255, 255) ));
        document.add(title);
        
        PdfPTable table = new PdfPTable(6);
        
        table.setSpacingBefore(25);
        table.setSpacingAfter(25);
        
        PdfPCell c1 = new PdfPCell(new Phrase("No"));
        table.addCell(c1);
        
        PdfPCell c2 = new PdfPCell(new Phrase("Nama Produk "));
        table.addCell(c2);
        
        PdfPCell c3 = new PdfPCell(new Phrase("Stok"));
        table.addCell(c3);
        
        PdfPCell c4 = new PdfPCell(new Phrase("Kategori"));
        table.addCell(c4);
        
        PdfPCell c5 = new PdfPCell(new Phrase("Pemasok"));
        table.addCell(c5);
        
        PdfPCell c6 = new PdfPCell(new Phrase("Harga"));
        table.addCell(c6);
        
        for (Produk product : products) {
            table.addCell("1");
            table.addCell(product.getNama());
            table.addCell( String.valueOf(product.getStok()) );
            table.addCell( String.valueOf(product.getKategoriId().getNamaKategori()) );
            table.addCell( String.valueOf(product.getPemasokId().getNama()) );
            table.addCell( String.valueOf(product.getHargaJual() ) );
        }
        
        document.add(table);
        
        document.close();
        
        return document;
        
    }
}
