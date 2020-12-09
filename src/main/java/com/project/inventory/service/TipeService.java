/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.inventory.service;

import com.project.inventory.entity.Kategori;
import com.project.inventory.entity.Tipe;
import com.project.inventory.repository.KategoriRepository;
import com.project.inventory.repository.TipeRepository;
import groovy.lang.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author i am me
 */
@Service
public class TipeService {
    @Autowired
    TipeRepository tipeRepo;
    
    
    
    public Iterable<Tipe> getAllTipe(){
        return tipeRepo.findAll();
    }
    
    public void saveTipe(String nama, Integer id){
        Tipe t = new Tipe();
        t.setNama(nama);
        t.setKategoriId(new Kategori(id));
        
        tipeRepo.save(t);
    }
    
    public Tipe getOneTipe(Integer id){
        return tipeRepo.findById(id).get();
    }
    
    public void deleteTipeCategory(Integer id){
        tipeRepo.deleteById(id);
    }
    
    public Tipe updateTipeCategory(Integer id, String nama, Integer Category){
        Tipe t = tipeRepo.findById(id).get();
        t.setNama(nama);
        t.setKategoriId(new Kategori(Category));
        tipeRepo.save(t);
        return t;
    }
}
