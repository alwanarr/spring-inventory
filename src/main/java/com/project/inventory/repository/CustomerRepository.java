/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.inventory.repository;

import com.project.inventory.entity.Pelanggan;
import java.util.List;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author i am me
 */
@Repository
public interface CustomerRepository extends CrudRepository<Pelanggan, Integer>{
    
    @org.springframework.data.jpa.repository.Query(value = "SELECT * FROM `pelanggan` WHERE no_hp LIKE %:search%", nativeQuery = true)
    public List<Pelanggan> findPelangganByNoHp(@Param("search") String search);
}
