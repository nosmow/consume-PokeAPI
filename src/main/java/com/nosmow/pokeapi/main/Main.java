package com.nosmow.pokeapi.main;

import com.nosmow.pokeapi.service.ApiConsumer;

public class Main {

    private static final String URL_BASE = "https://pokeapi.co/api/v2/";
    private final ApiConsumer apiConsumer = new ApiConsumer();

    public void viewMenu() {
        var json = apiConsumer.getData(URL_BASE);
        System.out.println(json);
    }
}
