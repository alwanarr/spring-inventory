/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.inventory.service;

import com.project.inventory.entity.User;
import com.project.inventory.repository.UserRepository;
import org.bouncycastle.crypto.generators.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author i am me
 */
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    
    
    public Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }
    
    public User getOneUser(Integer id){
        return userRepository.findById(id)
                .get();
    }

    public void update(Integer id, String nama, String no_hp, String password, String alamat) {
     
       User u = userRepository.findById(id).get();
       u.setAlamat(alamat);
       u.setNama(nama);
       u.setNoHp(no_hp);
       u.setAlamat(alamat);
       
       userRepository.save(u);
    }

    public void saveUser(String nama, String no_hp, String password, String alamat, String role) {
        User u = new User();
        u.setNama(nama);
        u.setNoHp(no_hp);
        u.setPassword(password);
        u.setAlamat(alamat);
        u.setRoles(role);
        userRepository.save(u);
       
    }
    
    
}
