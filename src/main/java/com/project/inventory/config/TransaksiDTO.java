/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.inventory.config;

/**
 *
 * @author i am me
 */
public class TransaksiDTO {
//    private Integer jumlah_order;
    private Integer total_harga;
    private String tanggal;
//    private Integer produk_id;
    
 
    public TransaksiDTO( Integer total_harga, String tanggal) {
        
        this.total_harga = total_harga;
        this.tanggal = tanggal;
    
    }

    public Integer getTotal_harga() {
        return total_harga;
    }

    public String getTanggal() {
        return tanggal;
    }
    
    
    
    
    
    
}
