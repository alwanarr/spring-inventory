/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.inventory.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author i am me
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
    , @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id")
    , @NamedQuery(name = "User.findByNama", query = "SELECT u FROM User u WHERE u.nama = :nama")
    , @NamedQuery(name = "User.findByNoHp", query = "SELECT u FROM User u WHERE u.noHp = :noHp")
    , @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password")
    , @NamedQuery(name = "User.findByActive", query = "SELECT u FROM User u WHERE u.active = :active")
    , @NamedQuery(name = "User.findByRoles", query = "SELECT u FROM User u WHERE u.roles = :roles")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 60)
    @Column(name = "nama", length = 60)
    private String nama;
    @Basic(optional = false)
//    @NotNull
    @Lob
//    @Size(min = 1, max = 65535)
    @Column(name = "alamat", length = 65535)
    private String alamat;
    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 18)
    @Column(name = "no_hp", length = 18)
    private String noHp;
    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 255)
    @Column(name = "password", length = 255)
    private String password;
    @Basic(optional = false)
//    @NotNull
    @Column(name = "active")
    private short active;
    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 25)
    @Column(name = "roles", length = 25)
    private String roles;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, String nama, String alamat, String noHp, String password, short active, String roles) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.noHp = noHp;
        this.password = password;
        this.active = active;
        this.roles = roles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public short getActive() {
        return active;
    }

    public void setActive(short active) {
        this.active = active;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.project.inventory.entity.User[ id=" + id + " ]";
    }
    
}
