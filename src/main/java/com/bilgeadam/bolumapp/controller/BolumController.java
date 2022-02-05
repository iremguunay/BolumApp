package com.bilgeadam.bolumapp.controller;

import com.bilgeadam.bolumapp.entity.Bolum;
import com.bilgeadam.bolumapp.exception.BolumNotFound;
import com.bilgeadam.bolumapp.repository.BolumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
public class BolumController {

    @Autowired
    private BolumRepository bolumRepository;

    @GetMapping("/bolum/{id}")
    public Bolum getBolum(@PathVariable("id") long bolumNo) {

        Bolum bolum = null;
        Optional<Bolum> bolumDB = bolumRepository.findById(bolumNo);

        if(bolumDB.isPresent()) {
            bolum = bolumDB.get();
            return bolum;
        } else {
            throw new BolumNotFound(bolumNo + " nolu Bölüm bulunamadı.");
        }
    }

    @GetMapping("/bolum")
    public List<Bolum> getBolumList() {

        return bolumRepository.findAll();
    }

    @GetMapping("/bolum-ad/{id}")
    public String getBolumAd(@PathVariable("id") long no) {

        Bolum bolum = getBolum(no);
        return bolum.getAd();
    }

    @GetMapping("/bolum-sehir/{id}")
    public String getBolumWithSehirAd(@PathVariable("id") long no) {

        Bolum bolum = getBolum(no);

        String sehirAd = getSehirAd(bolum.getNo());

        return bolum.getSehirNo() + " " + sehirAd;
    }

    private String getSehirAd(long no) {

        String sehirURL = "http://localhost:8240";

        RestTemplate restTemplate = new RestTemplate();
        String sehirAd = restTemplate.getForObject(sehirURL+"/sehir-ad/"+no, String.class);

        return sehirAd;
    }

}
