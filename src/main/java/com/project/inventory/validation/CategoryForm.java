/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.inventory.validation;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author i am me
 */
public class CategoryForm {
    @NotBlank(message = "not blank")
    @NotNull
    @Size(min=1)
    private String nama;

    public CategoryForm(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @Override
    public String toString() {
        return "CategoryForm{" + "nama=" + nama + '}';
    }
    
    
    
}
