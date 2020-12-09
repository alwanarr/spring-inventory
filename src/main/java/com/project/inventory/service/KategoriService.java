/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.inventory.service;

import com.project.inventory.entity.Kategori;
import com.project.inventory.repository.KategoriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author i am me
 */
@Service
public class KategoriService {
    @Autowired
    KategoriRepository kategoriRepo;
    
    
    public Iterable<Kategori> getAllKategori(){        
        return kategoriRepo.findAll();
    }
    
    public void save(String nama){
        Kategori k = new Kategori();
        k.setNamaKategori(nama);
        kategoriRepo.save(k);
    }
    
    public Kategori getOneCategory(Integer id) {
    
        return kategoriRepo.findById(id).get();
    }
    
    public Kategori updateCategory(Integer id, String nama){
    
        Kategori k =kategoriRepo.findById(id).get();
        k.setNamaKategori(nama);
        kategoriRepo.save(k);
        return k;
    }
    
    public void deletCategory(Integer id ){
          kategoriRepo.deleteById(id);
    }
    
}
