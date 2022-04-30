package com.fajardo.jadotaweb.services.impl;

import com.fajardo.jadotaweb.clients.OpenDotaApiClient;
import com.fajardo.jadotaweb.services.PlayerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService {
    
    private static String BASE_API = "/players";

    private OpenDotaApiClient client;

    @Autowired
    public PlayerServiceImpl(OpenDotaApiClient client){

        this.client = client;
    }

    @Override
    public String getPlayerInfo(String playerId) {

        return this.client.get(BASE_API + "/" + playerId);
    }
}
