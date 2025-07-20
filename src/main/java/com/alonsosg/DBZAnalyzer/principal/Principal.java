package com.alonsosg.DBZAnalyzer.principal;

// import java.util.Scanner;

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
    // private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private final String URL_BASE = "https://dragonball-api.com/api/";
    ObjectMapper objectMapper = new ObjectMapper();
    // private ConvierteDatos conversor = new ConvierteDatos();

    public void muestraMenu() throws JsonMappingException, JsonProcessingException{
        // Busca los datos generales de los personajes
        System.out.println("Datos de los personajes");
        String json = consumoAPI.obtenerDatos(URL_BASE + "characters/");
        DatosItems<DatosPersonajes> datosPersonajes = objectMapper.readValue(json, new TypeReference<DatosItems<DatosPersonajes>>() {});
        System.out.println(datosPersonajes);

        System.out.println("\n Top 10 personajes mas fuertes");
        datosPersonajes.items().stream()
            .filter(p -> p.maxKi() > 0)
            .sorted((p1, p2) -> Double.compare(p2.maxKi(), p1.maxKi()))
            .limit(10)
            .forEach(p -> System.out.println("Nombre: " + p.nombre() + " Ki Maximo: " + p.maxKi()));

        System.out.println("\n Datos de los planetas");
        json = consumoAPI.obtenerDatos(URL_BASE + "planets/");
        DatosItems<DatosPlanetas> datosPlanetas = objectMapper.readValue(json, new TypeReference<DatosItems<DatosPlanetas>>() {});
        System.out.println(datosPlanetas);
    }    
}