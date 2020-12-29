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
public class EmployeeDTO {
    private String Employee_Nik;
    private String Name;
    private String Email;
    private String Gender;
    private String Hp;

    public EmployeeDTO(String Employee_Nik, String Name, String Email, String Gender, String Hp) {
        this.Employee_Nik = Employee_Nik;
        this.Name = Name;
        this.Email = Email;
        this.Gender = Gender;
        this.Hp = Hp;
    }

    public String getEmployee_Nik() {
        return Employee_Nik;
    }

    public void setEmployee_Nik(String Employee_Nik) {
        this.Employee_Nik = Employee_Nik;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getHp() {
        return Hp;
    }

    public void setHp(String Hp) {
        this.Hp = Hp;
    }
    
    
    
}
