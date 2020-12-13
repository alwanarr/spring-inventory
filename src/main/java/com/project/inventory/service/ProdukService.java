/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.inventory.service;

import com.project.inventory.config.FileUploadUtil;
import com.project.inventory.entity.Kategori;
import com.project.inventory.entity.Pemasok;
import com.project.inventory.entity.Produk;
import com.project.inventory.entity.Status;
import com.project.inventory.repository.ProdukRepository;
import java.io.File;
import org.springframework.util.StringUtils;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author i am me
 */
@Service
public class ProdukService {

    @Autowired
    ProdukRepository produkRepo;

    public Iterable<Produk> getAllProduk() {
        return produkRepo.findAllProduk();
    }

    public void saveProduk(String nama, Integer harga_jual,
            Integer harga_awal,
            Integer stok,
            Integer kategori,
            Integer pemasok,
            MultipartFile multipartFile
    ) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        Produk p = new Produk();
        p.setNama(nama);
        p.setHargaAwal(harga_awal);
        p.setHargaJual(harga_jual);
        p.setStok(stok);
        p.setKategoriId(new Kategori(kategori));
        p.setPemasokId(new Pemasok(pemasok));
        p.setGambar(fileName);
        p.setStatusId(new Status(1));

        Produk produkBaru = produkRepo.save(p);

        String uploadDir = "product/" + produkBaru.getIdProduk();
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);

    }

    public Produk getOne(Integer id) {
        return produkRepo.findById(id).get();
    }

    public void updateProduk(Integer id, String nama, Integer harga_jual,
            Integer harga_awal, Integer stok, Integer kategori,
            Integer pemasok, MultipartFile gambar_produk) throws IOException {
        
        
        String fileName = StringUtils.cleanPath(gambar_produk.getOriginalFilename());
        Produk p = this.getOne(id);
        String namaGambar = p.getGambar();
        p.setNama(nama);
        p.setHargaAwal(harga_awal);
        p.setHargaJual(harga_jual);
        p.setStok(stok);
        p.setKategoriId(new Kategori(kategori));
        p.setPemasokId(new Pemasok(pemasok));
        p.setGambar(fileName);
        p.setStatusId(new Status(1));

        Produk produkUpdate = produkRepo.save(p);

        String uploadDir = "product/" + produkUpdate.getIdProduk();
        File f = new File(uploadDir + '/' + namaGambar);
        f.delete();
        
        FileUploadUtil.saveFile(uploadDir, fileName, gambar_produk);
    }
    
   public Iterable<Produk> getRejectedProduk(){
       return produkRepo.getProdukByStatusId();
   }
   
   public Iterable<Produk> getStockOfProduk(){
       return produkRepo.findAllProdukByStok();
   }
}
