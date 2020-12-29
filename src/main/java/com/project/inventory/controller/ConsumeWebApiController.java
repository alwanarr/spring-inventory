/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.inventory.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author i am me
 */
@Controller
public class ConsumeWebApiController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/consumeapi")
    public String consumeApi(Model model) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "sakura eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzYWt1cmEiLCJpYXQiOjE1ODAxOTYxMzJ9.zYvu8-qr48lmTx7_3tZMmVmIBuGPVXmgHbFOwSdTAdYZO9FFQWa7rUeKodtfOMkzfnnjVQSl6f_t54_qvlo7cA");
        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<String> response = new RestTemplate()
                .exchange("http://116.254.101.228:8080/APISAKURAJWT/masterEmployee/gabriel.timur@mii.co.id",
                        HttpMethod.GET, request, String.class);
        String json = response.getBody();
        System.out.println(json);
        model.addAttribute("datas", response);
        return "test/consumeapi";
    }

    @GetMapping("/restapi")
    public String getRestApi(Model model) {
        JSONObject jObj = null;
        List employees = new ArrayList<>();
  
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .header("Authorization", "sakura eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzYWt1cmEiLCJpYXQiOjE1ODAxOTYxMzJ9.zYvu8-qr48lmTx7_3tZMmVmIBuGPVXmgHbFOwSdTAdYZO9FFQWa7rUeKodtfOMkzfnnjVQSl6f_t54_qvlo7cA")
                    .url("http://116.254.101.228:8080/APISAKURAJWT/masterEmployee/gabriel.timur@mii.co.id")
                    .build();
            Response response = client.newCall(request).execute();
            
            JSONObject jsonobj = new JSONObject(response.body().string());
            
            JSONArray data = jsonobj.getJSONArray("data");
            
            
            for (int i = 0; i < data.length(); i++) {
                jObj = data.getJSONObject(i);
            }
            Iterator<String> keys = jObj.keys();
            
            while (keys.hasNext()) {
                String key = keys.next();
                System.out.println(key + " " + jObj.get(key));
                employees.add(jObj.get(key));
                
            }
        } catch (Exception e) {
            System.out.println("Erorr is = " + e);
        }
        
//        Map data = new HashMap();
//        data.put("nama",  jObj.getString("Name"));
//        data.put("email",  jObj.getString("Email"));
//        data.put("alamat",  jObj.getString("Address Street"));
//        data.put("tanggal lahir",  jObj.getString("Date of Birth"));
//        data.put("jabatan",  jObj.getString("Position"));
//        
//        model.addAttribute("datas", data);
//        model.addAttribute("employees", employees);
        model.addAttribute("employees", jObj.toString());
       

        return "test/restapi";
    }
}
