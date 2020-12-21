/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.inventory.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author i am me
 */
//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="id")
@Entity
@Table(name = "tipe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipe.findAll", query = "SELECT t FROM Tipe t")
    , @NamedQuery(name = "Tipe.findById", query = "SELECT t FROM Tipe t WHERE t.id = :id")
    , @NamedQuery(name = "Tipe.findByNama", query = "SELECT t FROM Tipe t WHERE t.nama = :nama")})
public class Tipe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 30)
    @NotBlank(message = "tidak boleh kosong")
    @Size(min=1)
    @Column(name = "nama", length = 30)
    private String nama;
    @JoinColumn(name = "kategori_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Kategori kategoriId;

    public Tipe() {
    }

    public Tipe(Integer id) {
        this.id = id;
    }

    public Tipe(Integer id, String nama) {
        this.id = id;
        this.nama = nama;
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
//    @JsonBackReference
    public Kategori getKategoriId() {
        return kategoriId;
    }

    public void setKategoriId(Kategori kategoriId) {
        this.kategoriId = kategoriId;
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
        if (!(object instanceof Tipe)) {
            return false;
        }
        Tipe other = (Tipe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.project.inventory.entity.Tipe[ id=" + id + " ]";
    }
    
}
