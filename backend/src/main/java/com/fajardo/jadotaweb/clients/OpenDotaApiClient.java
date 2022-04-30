package com.fajardo.jadotaweb.clients;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class OpenDotaApiClient {
    
    WebClient client;

    public OpenDotaApiClient(@Qualifier("openDotaUrl") String openDotaUrl){

        client = WebClient.create(openDotaUrl);
    }

    public String get(String api){

        var request = client.get().uri(api);

        return request.retrieve().bodyToMono(String.class).block();
    }
}
