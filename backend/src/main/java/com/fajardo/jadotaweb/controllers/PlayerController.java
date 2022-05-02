package com.fajardo.jadotaweb.controllers;

import com.fajardo.jadotaweb.services.PlayerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/players")
public class PlayerController {
    
    PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {

        this.playerService = playerService;
    }

    @GetMapping("/{playerId}")
    public String getPlayerStats(@PathVariable String playerId){
        return playerService.getPlayerInfo(playerId);
    }
}
