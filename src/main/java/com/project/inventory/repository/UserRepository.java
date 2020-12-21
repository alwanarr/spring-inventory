/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.inventory.repository;

import com.project.inventory.entity.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author i am me
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
    @Query(value = "SELECT u FROM user u WHERE u.nama = :nama")
    public User getUserByNama(@Param("nama") String nama);
}
