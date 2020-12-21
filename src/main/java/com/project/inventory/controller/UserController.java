/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.inventory.controller;

import com.project.inventory.config.TanggalAndTotalharga;
import com.project.inventory.entity.Transaksi;
import com.project.inventory.entity.User;
import com.project.inventory.service.TransaksiService;
import com.project.inventory.service.UserService;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author i am me
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user")
    public String showUser(Model model) {
        Iterable<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "user/index";
    }

    @GetMapping("/user/{id}")
    @ResponseBody
    public User getOneUser(@PathVariable("id") Integer id) {
        User u = userService.getOneUser(id);
        return u;
    }

    @PostMapping("/user/saveuser")
    public String saveKategori(
            @RequestParam("nama") String nama,
            @RequestParam("no_hp") String no_hp,
            @RequestParam("password") String password,
            @RequestParam("alamat") String alamat,
            @RequestParam("role") String role,
            RedirectAttributes atts   ,
            Model model
    ) {
        
        userService.saveUser(nama, no_hp, password, alamat, role);
        atts.addFlashAttribute("success", "success");
         model.addAttribute("success", "success");
        return "redirect:/user";
    }

    @PostMapping("/user/updateuser")
    public String updateUser(
            @RequestParam("id") Integer id,
            @RequestParam("nama") String nama,
            @RequestParam("no_hp") String no_hp,
            @RequestParam("password") String password,
            @RequestParam("alamat") String alamat,
            RedirectAttributes atts
            
    ) {
        
        userService.update(id, nama, no_hp, password, alamat);
        atts.addFlashAttribute("success", "success");
        
        return "redirect:/user";
    }

}
