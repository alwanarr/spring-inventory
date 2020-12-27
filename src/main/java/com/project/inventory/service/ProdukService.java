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
import com.project.inventory.exception.ProdukReduceException;
import com.project.inventory.repository.ProdukRepository;
import java.io.File;
import org.springframework.util.StringUtils;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
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
          if(gambar_produk.isEmpty()){
              p.setGambar(namaGambar);
          }else{
              p.setGambar(fileName);
          }
        
        p.setStatusId(new Status(1));
        
        Produk produkUpdate = produkRepo.save(p);
          
        String uploadDir = "product/" + produkUpdate.getIdProduk();
        File f = new File(uploadDir + '/' + namaGambar);
        f.delete();

        FileUploadUtil.saveFile(uploadDir, fileName, gambar_produk);
    }

    public Iterable<Produk> getProdukByStatus(Integer status_id) {
        return produkRepo.getProdukByStatusId(status_id);
    }

    public Iterable<Produk> getStockOfProduk() {
        return produkRepo.findAllProdukByStok();
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public ResponseEntity<String> reduceStok(Produk id, Integer stok) throws ProdukReduceException {

        Integer idProduk = id.getIdProduk();
//       System.out.println("id produk service" + idProduk);
//       System.out.println("stok service" + stok);

        Produk p = produkRepo.findById(idProduk).get();
        if (p == null) {
            throw new ProdukReduceException("Produk tidak ditemukan");
        } else if (p.getStok() - stok < 0) {
            throw new ProdukReduceException("Stok " + p.getNama() + " tidak Mencukupi, stok produk adalah " + p.getStok());
        }
        p.setStok(p.getStok() - stok);
        produkRepo.save(p);

        return new ResponseEntity<>("transaksi sukses", HttpStatus.OK);

    }

    public Long getCountOfProduk() {
        return produkRepo.count();
    }

    public void acceptProduct(Integer id, String status) {
        Produk p = produkRepo.findById(id).get();
        p.setStatusId(new Status(Integer.parseInt(status)));
        produkRepo.save(p);
    }

    public void rejectProduct(Integer id, String status) {
        Produk p = produkRepo.findById(id).get();
        p.setStatusId(new Status(Integer.parseInt(status)));
        produkRepo.save(p);
    }

    public void deleteById(Integer id) {
        produkRepo.deleteById(id);
    }
}
