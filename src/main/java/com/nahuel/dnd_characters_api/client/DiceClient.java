package com.nahuel.dnd_characters_api.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "dice-client", url = "${dice.api-url}")
public interface DiceClient {

    @GetMapping
    String roll(@RequestParam("dice") String dice,
                @RequestParam("key") String key);
}