package com.fmunoz.mutantesAPI.controllers;

import com.fmunoz.mutantesAPI.dtos.StatsDto;
import com.fmunoz.mutantesAPI.services.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/stats")
public class StatsController {

    @Autowired
    private StatsService statsService;

    @GetMapping("")
    public StatsDto getStats(){
        return statsService.getStats();
    }
}
