package com.bilgeadam.bolumapp.controller;

import com.bilgeadam.bolumapp.entity.Bolum;
import com.bilgeadam.bolumapp.exception.BolumNotFound;
import com.bilgeadam.bolumapp.repository.BolumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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

}
