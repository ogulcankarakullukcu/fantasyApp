package com.ogulcank.fantasyApp.controller;

import com.ogulcank.fantasyApp.models.EspnPlayerRequest;
import com.ogulcank.fantasyApp.service.EspnPlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fantasyApp/player")
public class EspnPlayerController {
    private final EspnPlayerService espnPlayerService;


    public EspnPlayerController(EspnPlayerService espnPlayerService) {
        this.espnPlayerService = espnPlayerService;
    }

    @PostMapping
    public ResponseEntity<String> saveEspnPlayer(@RequestBody List<EspnPlayerRequest> list) {
        list.stream().forEach(t -> {
            espnPlayerService.saveEspnPlayer(t);
        });
        return new ResponseEntity<>("Players saved", HttpStatus.OK);
    }
}
