package com.nosmow.pokeapi.main;

import com.nosmow.pokeapi.model.Data;
import com.nosmow.pokeapi.model.Pokemon;
import com.nosmow.pokeapi.service.ApiConsumer;
import com.nosmow.pokeapi.service.DataConvert;

import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private final Scanner scanner = new Scanner(System.in);
    private static final String URL_BASE = "https://pokeapi.co/api/v2/";
    private final ApiConsumer apiConsumer = new ApiConsumer();
    private final DataConvert convert = new DataConvert();

    public void viewMenu() {

        System.out.println("Bienvenido a la PokeAPI\n");

        System.out.println("Selecciona una opción del menu");
        System.out.println("_____________Menu____________");
        System.out.println("| 1. Ver todos los Pokémon  |");
        System.out.println("| 2. Buscar un Pokémon      |");
        System.out.println("_____________________________");

        System.out.print("Opción: ");
        var option = scanner.nextInt();

        //var json = apiConsumer.getData(URL_BASE + "pokemon?offset=0&limit=1302");

        if (option == 1) {
            var json = apiConsumer.getData(URL_BASE + "pokemon?limit=2000");
            var data = convert.getData(json, Data.class);

            var result = data.results().stream()
                    .sorted(Comparator.comparing(Pokemon::name))
                    .map(p -> p.name().toUpperCase())
                    .collect(Collectors.joining(", "));

            System.out.println("\n" + data.results().size() + " Pokémon encontrados: \n");
            System.out.println(result);

        } else if (option == 2) {

            System.out.print("Pokemon name: ");
            String name = scanner.next();

            var json = apiConsumer.getData(URL_BASE + "pokemon/" + name);
            var data = convert.getData(json, Pokemon.class);

            System.out.println("\nPokemon: " + data.name().toUpperCase());

            System.out.print("Type: ");
            data.types().forEach(t -> {
                System.out.print(t.type().name());
                if (data.types().indexOf(t) != data.types().size() - 1) {
                    System.out.print(", ");
                }
            });

            System.out.print("\nAbilities: ");
            data.abilities().forEach(a -> {
                System.out.print(a.ability().name());
                if (data.abilities().indexOf(a) != data.abilities().size() - 1) {
                    System.out.print(", ");
                }
            });
            //System.out.println(data);

        }

    }
}
