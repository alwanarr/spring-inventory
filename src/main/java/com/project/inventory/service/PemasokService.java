/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.inventory.service;

import com.project.inventory.entity.Pemasok;
import com.project.inventory.repository.PemasokRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author i am me
 */
@Service
public class PemasokService {
    @Autowired
    PemasokRepository pemasokRepo;
    
    public void savePemasok(String nama, String no_hp, String email, String alamat){
//        pemasokRepo.save(pemasok);
        Pemasok p = new Pemasok();
        p.setNama(nama);
        p.setNoHp(no_hp);
        p.setEmail(email);
       p.setAlamat(alamat);

        pemasokRepo.save(p);
    }
    
    public Iterable<Pemasok> getAllPemasok(){
        return pemasokRepo.findAll();
    }
    
    public Pemasok getOnePemasok(Integer id){
        return pemasokRepo.findById(id).get();
    }
    
    public void deleteById(int id){
         pemasokRepo.deleteById(id);
     }
    
    public Pemasok updatePemasok(Integer id, String nama, String email, String no_hp, String alamat){
        Pemasok pemasok = pemasokRepo.findById(id).get();
        pemasok.setNama(nama);
        pemasok.setNoHp(no_hp);
        pemasok.setEmail(email);
        pemasok.setAlamat(alamat);
        pemasokRepo.save(pemasok);
      
        return pemasok;
    }
      
}
