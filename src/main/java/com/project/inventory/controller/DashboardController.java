/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.inventory.controller;

import com.project.inventory.config.TanggalAndTotalharga;
import com.project.inventory.service.PelangganService;
import com.project.inventory.service.PemasokService;
import com.project.inventory.service.ProdukService;
import com.project.inventory.service.TransaksiService;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author i am me
 */
@Controller
public class DashboardController {

    @Autowired
    ProdukService produkService;

    @Autowired
    PemasokService pemasokService;

    @Autowired
    PelangganService pelangganService;

    @Autowired
    TransaksiService transaksiService;

    @GetMapping("/dashboard")
    public String getDashboard(Model model) {
        //format rupiah
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');

        kursIndonesia.setDecimalFormatSymbols(formatRp);

        Long produkCount = produkService.getCountOfProduk();
        Long pemasokCount = pemasokService.getCountOfSupplier();
        Long pelangganCount = pelangganService.getCountOfCustomer();
        Double getProfit = transaksiService.getProfit();
        String profit = kursIndonesia.format(getProfit);

        //chart
        List<String> month = new ArrayList<>();
        List<Integer> profitChart = new ArrayList<>();
        
        List<TanggalAndTotalharga> tahunProfit = transaksiService.getProfitByYear();
        for (TanggalAndTotalharga tahunProfits : tahunProfit) {
            month.add(tahunProfits.getBulan());
            profitChart.add(tahunProfits.getLaba_Bersih());
        }

        model.addAttribute("produk", produkCount);
        model.addAttribute("pemasok", pemasokCount);
        model.addAttribute("pelanggan", pelangganCount);
        model.addAttribute("profit", profit);
        model.addAttribute("bulan", month);
        model.addAttribute("laba", profitChart);

        return "dashboard/index";
    }
}
