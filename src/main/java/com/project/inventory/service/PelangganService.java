/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.inventory.service;

import com.project.inventory.entity.Pelanggan;
import com.project.inventory.repository.CustomerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author i am me
 */
@Service
public class PelangganService {

    @Autowired
    CustomerRepository customerRepo;

    public List<Pelanggan> getPelangganByNoHp(String search) {

        return customerRepo.findPelangganByNoHp(search);
    }

    public Pelanggan saveCustomer(String nama, String no_hp, String alamat, String email) {
        Boolean isCustomerNotFound = true;
        Iterable<Pelanggan> p = customerRepo.findAll();
        Pelanggan savePelanggan = new Pelanggan();
        for (Pelanggan pelanggan : p) {
            if (pelanggan.getNoHp().equals(no_hp)) {
                isCustomerNotFound = false;
                System.out.println("Customer has found");
                return pelanggan;
            }
        }

        if (isCustomerNotFound) {

            savePelanggan.setNama(nama);
            savePelanggan.setNoHp(no_hp);
            savePelanggan.setAlamat(alamat);
            savePelanggan.setEmail(email);
            customerRepo.save(savePelanggan);
        }
        return savePelanggan;

    }
    
    
   

}
