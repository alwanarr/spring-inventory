/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.inventory.repository;

import com.project.inventory.entity.Produk;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author i am me
 */
@Repository
public interface ProdukRepository extends CrudRepository<Produk, Integer> {
    @org.springframework.data.jpa.repository.Query(value = "SELECT * FROM `produk` WHERE status_id = :status_id", nativeQuery = true)
    public Iterable<Produk> getProdukByStatusId(@Param("status_id") Integer status_id);
    
    @org.springframework.data.jpa.repository.Query(value = "SELECT * FROM `produk` WHERE status_id = 2 and stok >= 1", nativeQuery = true)
    public Iterable<Produk> findAllProduk();
    
    @org.springframework.data.jpa.repository.Query(value = "SELECT * FROM `produk` WHERE stok < 1", nativeQuery = true)
    public Iterable<Produk> findAllProdukByStok();
    
    
    @Modifying
    @org.springframework.data.jpa.repository.Query(value = "UPDATE produk SET stok = stok - :stok "
                                                            + "where id_produk = :id", nativeQuery = true)
    public Iterable<Produk> reduceProdukByStok( @Param("id") Integer id, @Param("stok") Integer stok);
}
