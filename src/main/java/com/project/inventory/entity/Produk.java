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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "produk")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produk.findAll", query = "SELECT p FROM Produk p")
    , @NamedQuery(name = "Produk.findById", query = "SELECT p FROM Produk p WHERE p.id = :id")
    , @NamedQuery(name = "Produk.findByNama", query = "SELECT p FROM Produk p WHERE p.nama = :nama")
    , @NamedQuery(name = "Produk.findByHargaJual", query = "SELECT p FROM Produk p WHERE p.hargaJual = :hargaJual")
    , @NamedQuery(name = "Produk.findByHargaAwal", query = "SELECT p FROM Produk p WHERE p.hargaAwal = :hargaAwal")
    , @NamedQuery(name = "Produk.findByStok", query = "SELECT p FROM Produk p WHERE p.stok = :stok")
    , @NamedQuery(name = "Produk.findByGambar", query = "SELECT p FROM Produk p WHERE p.gambar = :gambar")})
public class Produk implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 30)
    @Column(name = "nama", length = 30)
    private String nama;
    @Column(name = "harga_jual")
    private Integer hargaJual;
    @Column(name = "harga_awal")
    private Integer hargaAwal;
    @Column(name = "stok")
    private Integer stok;
    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 255)
    @Column(name = "gambar", length = 255)
    private String gambar;
    @JoinColumn(name = "kategori_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Kategori kategoriId;
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Status statusId;
    @JoinColumn(name = "pemasok_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pemasok pemasokId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produkId", fetch = FetchType.LAZY)
    private List<Transaksi> transaksiList;

    public Produk() {
    }

    public Produk(Integer id) {
        this.id = id;
    }

    public Produk(Integer id, String nama, String gambar) {
        this.id = id;
        this.nama = nama;
        this.gambar = gambar;
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

    public Integer getHargaJual() {
        return hargaJual;
    }

    public void setHargaJual(Integer hargaJual) {
        this.hargaJual = hargaJual;
    }

    public Integer getHargaAwal() {
        return hargaAwal;
    }

    public void setHargaAwal(Integer hargaAwal) {
        this.hargaAwal = hargaAwal;
    }

    public Integer getStok() {
        return stok;
    }

    public void setStok(Integer stok) {
        this.stok = stok;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public Kategori getKategoriId() {
        return kategoriId;
    }

    public void setKategoriId(Kategori kategoriId) {
        this.kategoriId = kategoriId;
    }

    public Status getStatusId() {
        return statusId;
    }

    public void setStatusId(Status statusId) {
        this.statusId = statusId;
    }

    public Pemasok getPemasokId() {
        return pemasokId;
    }

    public void setPemasokId(Pemasok pemasokId) {
        this.pemasokId = pemasokId;
    }

    @XmlTransient
    public List<Transaksi> getTransaksiList() {
        return transaksiList;
    }

    public void setTransaksiList(List<Transaksi> transaksiList) {
        this.transaksiList = transaksiList;
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
        if (!(object instanceof Produk)) {
            return false;
        }
        Produk other = (Produk) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.project.inventory.entity.Produk[ id=" + id + " ]";
    }
    
}
