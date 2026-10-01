package com.controller;

import com.service.SummerizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class SummerizeController {
    @Autowired
    private SummerizeService summerizeService;
    @PostMapping("/summerize")
    public String summerize(@RequestBody String ticket){
        return summerizeService.summerize(ticket);
    }
    @PostMapping("/chat")
    public String chat(@RequestBody String message){
        return summerizeService.chat(message);
    }
}
