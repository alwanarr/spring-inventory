/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.inventory.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
import javax.persistence.Lob;
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
@Table(name = "pemasok")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pemasok.findAll", query = "SELECT p FROM Pemasok p")
    , @NamedQuery(name = "Pemasok.findByIdPemasok", query = "SELECT p FROM Pemasok p WHERE p.idPemasok = :idPemasok")
    , @NamedQuery(name = "Pemasok.findByNama", query = "SELECT p FROM Pemasok p WHERE p.nama = :nama")
    , @NamedQuery(name = "Pemasok.findByNoHp", query = "SELECT p FROM Pemasok p WHERE p.noHp = :noHp")
    , @NamedQuery(name = "Pemasok.findByEmail", query = "SELECT p FROM Pemasok p WHERE p.email = :email")})
public class Pemasok implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pemasok")
    private Integer idPemasok;
    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 70)
    @Column(name = "nama", length = 70)
    private String nama;
    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 15)
    @Column(name = "no_hp", length = 15)
    private String noHp;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 40)
    @Column(name = "email", length = 40)
    private String email;
    @Basic(optional = false)
//    @NotNull
    @Lob
//    @Size(min = 1, max = 65535)
    @Column(name = "alamat", length = 65535)
    private String alamat;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pemasokId", fetch = FetchType.LAZY)
    private List<Produk> produkList;

    public Pemasok() {
    }

    public Pemasok(Integer idPemasok) {
        this.idPemasok = idPemasok;
    }

    public Pemasok(Integer idPemasok, String nama, String noHp, String email, String alamat) {
        this.idPemasok = idPemasok;
        this.nama = nama;
        this.noHp = noHp;
        this.email = email;
        this.alamat = alamat;
    }

    public Integer getIdPemasok() {
        return idPemasok;
    }

    public void setIdPemasok(Integer idPemasok) {
        this.idPemasok = idPemasok;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    @XmlTransient
    @JsonManagedReference
    public List<Produk> getProdukList() {
        return produkList;
    }

    public void setProdukList(List<Produk> produkList) {
        this.produkList = produkList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPemasok != null ? idPemasok.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pemasok)) {
            return false;
        }
        Pemasok other = (Pemasok) object;
        if ((this.idPemasok == null && other.idPemasok != null) || (this.idPemasok != null && !this.idPemasok.equals(other.idPemasok))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.project.inventory.entity.Pemasok[ idPemasok=" + idPemasok + " ]";
    }
    
}
