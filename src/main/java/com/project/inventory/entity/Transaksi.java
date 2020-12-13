/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.inventory.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author i am me
 */
@Entity
@Table(name = "transaksi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transaksi.findAll", query = "SELECT t FROM Transaksi t")
    , @NamedQuery(name = "Transaksi.findByIdTransaksi", query = "SELECT t FROM Transaksi t WHERE t.idTransaksi = :idTransaksi")
    , @NamedQuery(name = "Transaksi.findByJumlahOrder", query = "SELECT t FROM Transaksi t WHERE t.jumlahOrder = :jumlahOrder")
    , @NamedQuery(name = "Transaksi.findByTotalHarga", query = "SELECT t FROM Transaksi t WHERE t.totalHarga = :totalHarga")
    , @NamedQuery(name = "Transaksi.findByTanggal", query = "SELECT t FROM Transaksi t WHERE t.tanggal = :tanggal")
    , @NamedQuery(name = "Transaksi.findByCreatedAt", query = "SELECT t FROM Transaksi t WHERE t.createdAt = :createdAt")
    , @NamedQuery(name = "Transaksi.findByUpdatedAt", query = "SELECT t FROM Transaksi t WHERE t.updatedAt = :updatedAt")})
public class Transaksi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_transaksi")
    private Integer idTransaksi;
    @Column(name = "jumlah_order")
    private Integer jumlahOrder;
    @Column(name = "total_harga")
    private Integer totalHarga;
    @Column(name = "tanggal")
    @Temporal(TemporalType.DATE)
    private Date tanggal;
    @Basic(optional = false)
//    @NotNull
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
//    @NotNull
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "produk_id", referencedColumnName = "id_produk")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Produk produkId;
    @JoinColumn(name = "pelanggan_id", referencedColumnName = "id_pelanggan")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pelanggan pelangganId;

    public Transaksi() {
    }

    public Transaksi(Integer idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public Transaksi(Integer idTransaksi, Date createdAt, Date updatedAt) {
        this.idTransaksi = idTransaksi;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(Integer idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public Integer getJumlahOrder() {
        return jumlahOrder;
    }

    public void setJumlahOrder(Integer jumlahOrder) {
        this.jumlahOrder = jumlahOrder;
    }

    public Integer getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(Integer totalHarga) {
        this.totalHarga = totalHarga;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Produk getProdukId() {
        return produkId;
    }

    public void setProdukId(Produk produkId) {
        this.produkId = produkId;
    }

    public Pelanggan getPelangganId() {
        return pelangganId;
    }

    public void setPelangganId(Pelanggan pelangganId) {
        this.pelangganId = pelangganId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTransaksi != null ? idTransaksi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transaksi)) {
            return false;
        }
        Transaksi other = (Transaksi) object;
        if ((this.idTransaksi == null && other.idTransaksi != null) || (this.idTransaksi != null && !this.idTransaksi.equals(other.idTransaksi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.project.inventory.entity.Transaksi[ idTransaksi=" + idTransaksi + " ]";
    }
    
}
