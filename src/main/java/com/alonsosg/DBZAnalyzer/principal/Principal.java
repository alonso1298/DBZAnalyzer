package com.alonsosg.DBZAnalyzer.principal;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.alonsosg.DBZAnalyzer.model.DatosItems;
import com.alonsosg.DBZAnalyzer.model.DatosPersonajes;
import com.alonsosg.DBZAnalyzer.model.DatosPlanetas;
import com.alonsosg.DBZAnalyzer.service.ConsumoAPI;
// import com.alonsosg.DBZAnalyzer.service.ConvierteDatos;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private final String URL_BASE = "https://dragonball-api.com/api/";
    ObjectMapper objectMapper = new ObjectMapper();
    // private ConvierteDatos conversor = new ConvierteDatos();

    public void muestraMenu() throws JsonMappingException, JsonProcessingException{
        // Busca los datos generales de los personajes
        System.out.println("Datos de los personajes");
        String json = consumoAPI.obtenerDatos(URL_BASE + "characters?limit=70");
        DatosItems<DatosPersonajes> datosPersonajes = objectMapper.readValue(json, new TypeReference<DatosItems<DatosPersonajes>>() {});
        // System.out.println(datosPersonajes);

        List<DatosPersonajes> personajes = datosPersonajes.items();

        System.out.println("\n Top 10 personajes mas fuertes");
        datosPersonajes.items().stream()
            .filter(p -> p.maxKi() > 0)
            .sorted((p1, p2) -> Double.compare(p2.maxKi(), p1.maxKi()))
            .limit(10)
            .forEach(p -> System.out.println("Nombre: " + p.nombre() + " Ki Maximo: " + p.maxKi()));

        System.out.println("\nEscribe el nombre del personaje a buscar:");
                String nombreBuscado = teclado.nextLine();

                personajes.stream()
                    .filter(p -> p.nombre().toLowerCase().contains(nombreBuscado.toLowerCase()))
                    .findFirst()
                    .ifPresentOrElse(
                        p -> {
                            System.out.println("\n Personaje encontrado:");
                            System.out.printf("\nNombre: " + p.nombre() + ", Poder maximo: " + p.maxKi() + ", Raza: " + p.raza());
                        },
                        () -> System.out.println("Personaje no encontrado.")
                    );

        System.out.println("\n Datos de los planetas");
        json = consumoAPI.obtenerDatos(URL_BASE + "planets/");
        DatosItems<DatosPlanetas> datosPlanetas = objectMapper.readValue(json, new TypeReference<DatosItems<DatosPlanetas>>() {});
        System.out.println(datosPlanetas);


        System.out.println("\nEstadísticas generales");

        // 1. Total de personajes
        System.out.println("Total de personajes: " + datosPersonajes.items().size());

        // 3. Personaje más fuerte
        datosPersonajes.items().stream()
            .filter(p -> p.maxKi() > 0)
            .max((p1, p2) -> Double.compare(p1.maxKi(), p2.maxKi()))
            .ifPresent(p -> System.out.println("Personaje más fuerte: " + p.nombre() + " con Ki " + p.maxKi()));

        // 4. Conteo por raza
        System.out.println("\nCantidad de personajes por raza:");
        datosPersonajes.items().stream()
            .filter(p -> p.raza() != null && !p.raza().isEmpty())
            .collect(Collectors.groupingBy(DatosPersonajes::raza, Collectors.counting()))
            .forEach((raza, cantidad) -> System.out.println("- " + raza + ": " + cantidad));

        // 5. Personajes con transformación
        long conTransformacion = datosPersonajes.items().stream()
            .filter(p -> p.transformaciones() != null && !p.transformaciones().isEmpty())
            .count();
        System.out.println("Personajes con transformación: " + conTransformacion);
            }    
}