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
    , @NamedQuery(name = "Produk.findByIdProduk", query = "SELECT p FROM Produk p WHERE p.idProduk = :idProduk")
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
    @Column(name = "id_produk")
    private Integer idProduk;
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
    @JoinColumn(name = "pemasok_id", referencedColumnName = "id_pemasok")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pemasok pemasokId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produkId", fetch = FetchType.LAZY)
    private List<Transaksi> transaksiList;

    public Produk() {
    }

    public Produk(Integer idProduk) {
        this.idProduk = idProduk;
    }

    public Produk(Integer idProduk, String nama, String gambar) {
        this.idProduk = idProduk;
        this.nama = nama;
        this.gambar = gambar;
    }

    public Integer getIdProduk() {
        return idProduk;
    }

    public void setIdProduk(Integer idProduk) {
        this.idProduk = idProduk;
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
        hash += (idProduk != null ? idProduk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produk)) {
            return false;
        }
        Produk other = (Produk) object;
        if ((this.idProduk == null && other.idProduk != null) || (this.idProduk != null && !this.idProduk.equals(other.idProduk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.project.inventory.entity.Produk[ idProduk=" + idProduk + " ]";
    }
    
}
