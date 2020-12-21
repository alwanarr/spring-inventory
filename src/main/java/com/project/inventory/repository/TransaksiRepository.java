/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.inventory.repository;

import com.itextpdf.text.Document;
import com.project.inventory.config.TanggalAndTotalharga;
import com.project.inventory.entity.Transaksi;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author i am me
 */
@Repository
public interface TransaksiRepository extends CrudRepository<Transaksi, Integer> {

    public static final String REPORT_TRANSACTIONS = "SELECT MONTHNAME(tanggal) AS BULAN,  \n"
            + "	SUM(t.total_harga  -  (p.harga_awal * t.jumlah_order))  AS  LABA_BERSIH\n"
            + "FROM transaksi t \n"
            + "INNER JOIN produk p ON t.produk_id = p.id_produk\n"
            + "	where year(tanggal)= year(NOW())\n"
            + "    GROUP BY MONTH(tanggal)";

    public static final String PROFIT = "SELECT  \n"
            + "	SUM(t.total_harga  -  (p.harga_awal * t.jumlah_order))  AS  LABA_BERSIH\n"
            + "FROM transaksi t \n"
            + "INNER JOIN produk p ON t.produk_id = p.id_produk\n"
            + "	where MONTH(tanggal)= MONTH(NOW())\n"
            + "    GROUP BY MONTH(tanggal)";


    @Query(value = REPORT_TRANSACTIONS, nativeQuery = true)
    public List<TanggalAndTotalharga> reportTransaksi();

    @Query(value = PROFIT, nativeQuery = true)
    public Double profit();
    
//    @Query(value = GET_PROFIT_BY_YEAR, nativeQuery = true)
//    public List<TanggalAndTotalharga> getProfitByTahun(@Param("tahun") String tahun);
}
