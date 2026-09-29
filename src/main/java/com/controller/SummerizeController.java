package com.controller;

import com.service.SummerizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SummerizeController {
    @Autowired
    private SummerizeService summerizeService;
    @PostMapping("/summerize")
    public String summerize(@RequestBody String ticket){
        return summerizeService.summerize(ticket);
    }
}
