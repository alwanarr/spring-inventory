/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.inventory.service;

import com.project.inventory.entity.Transaksi;
import com.project.inventory.exception.ProdukReduceException;
import com.project.inventory.repository.TransaksiRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author i am me
 */

@Service
public class TransaksiService {
    @Autowired
    TransaksiRepository transaksiRepo;
    
    @Autowired
    ProdukService produkService;

//    @Transactional
//    public List<Transaksi>  saveAllTransaksi(List<Transaksi> transaksiList){ 
//        
//        List<Transaksi> response = (List<Transaksi>) transaksiRepo.saveAll(transaksiList);
//        return response;
//    }
    
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = ProdukReduceException.class)
    public List<Transaksi>  saveAllTransaksi(List<Transaksi> transaksiList) throws ProdukReduceException{ 
        
        List<Transaksi> response = (List<Transaksi>) transaksiRepo.saveAll(transaksiList);
        
        for (Transaksi transaksi : transaksiList) {
            produkService.reduceStok(transaksi.getProdukId(), transaksi.getJumlahOrder());
        }
        return response;
    }
}
