/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.inventory.repository;

import com.project.inventory.entity.Transaksi;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author i am me
 */
@Repository
public interface TransaksiRepository extends CrudRepository<Transaksi, Integer>{
    
}
