package com.ogulcank.fantasyApp.controller;

import com.ogulcank.fantasyApp.models.StatRequest;
import com.ogulcank.fantasyApp.service.StatService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fantasyApp/stat")
public class StatController {

    private final StatService statService;

    public StatController(StatService statService) {
        this.statService = statService;
    }

    @PostMapping
    public ResponseEntity<String> saveStats(@RequestBody List<StatRequest> list){
        list.stream().forEach(t -> {
            try {
                statService.addStat(t);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        return new ResponseEntity<>("Stats saved", HttpStatus.OK);
    }
}
