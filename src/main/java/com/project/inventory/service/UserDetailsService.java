/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.inventory.service;

import com.project.inventory.entity.User;
import com.project.inventory.repository.UserRepository;
import com.project.inventory.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author i am me
 */
@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService{
    @Autowired
    UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String nama) throws UsernameNotFoundException {
       User user = userRepo.getUserByNama(nama);
       
        if(user == null) throw new UsernameNotFoundException(nama);
       
       return new MyUserDetails(user);
    }
    
    
}
