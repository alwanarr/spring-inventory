/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.inventory.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author i am me
 */
@Entity
@Table(name = "kategori")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kategori.findAll", query = "SELECT k FROM Kategori k")
    , @NamedQuery(name = "Kategori.findById", query = "SELECT k FROM Kategori k WHERE k.id = :id")
    , @NamedQuery(name = "Kategori.findByNamaKategori", query = "SELECT k FROM Kategori k WHERE k.namaKategori = :namaKategori")})
public class Kategori implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 20)
    @Column(name = "nama_kategori", length = 20)
    private String namaKategori;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kategoriId", fetch = FetchType.LAZY)
    private List<Produk> produkList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kategoriId", fetch = FetchType.LAZY)
    private List<Tipe> tipeList;

    public Kategori() {
    }

    public Kategori(Integer id) {
        this.id = id;
    }

    public Kategori(Integer id, String namaKategori) {
        this.id = id;
        this.namaKategori = namaKategori;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamaKategori() {
        return namaKategori;
    }

    public void setNamaKategori(String namaKategori) {
        this.namaKategori = namaKategori;
    }

    @XmlTransient
    public List<Produk> getProdukList() {
        return produkList;
    }

    public void setProdukList(List<Produk> produkList) {
        this.produkList = produkList;
    }

    @XmlTransient
    public List<Tipe> getTipeList() {
        return tipeList;
    }

    public void setTipeList(List<Tipe> tipeList) {
        this.tipeList = tipeList;
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
        if (!(object instanceof Kategori)) {
            return false;
        }
        Kategori other = (Kategori) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.project.inventory.entity.Kategori[ id=" + id + " ]";
    }
    
}
