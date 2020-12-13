/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.inventory.service;

import com.project.inventory.entity.Transaksi;
import com.project.inventory.repository.TransaksiRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author i am me
 */

@Service
public class TransaksiService {
    @Autowired
    TransaksiRepository transaksiRepo;
//    public Transaksi saveTransaction(Integer jumlah_order, Integer total_harga, 
//            Integer produk_id, String tanggal, Integer pelanggan_id){
//        
//        
//        
//        return null;
//    }
    
    @Transactional
    public List<Transaksi>  saveAllTransaksi(List<Transaksi> transaksiList){
        
        List<Transaksi> response = (List<Transaksi>) transaksiRepo.saveAll(transaksiList);
        return response;
    }
}
