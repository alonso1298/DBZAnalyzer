package com.alonsosg.DBZAnalyzer.principal;

// import java.util.Scanner;

import com.alonsosg.DBZAnalyzer.model.DatosItems;
import com.alonsosg.DBZAnalyzer.model.DatosPersonajes;
import com.alonsosg.DBZAnalyzer.service.ConsumoAPI;
// import com.alonsosg.DBZAnalyzer.service.ConvierteDatos;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Principal {
    // private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private final String URL_BASE = "https://dragonball-api.com/api/characters/";
    ObjectMapper objectMapper = new ObjectMapper();
    // private ConvierteDatos conversor = new ConvierteDatos();

    public void muestraMenu() throws JsonMappingException, JsonProcessingException{
        // Busca los datos generales de los personajes
        System.out.println("Datos de los personajes");
        String json = consumoAPI.obtenerDatos(URL_BASE);
        DatosItems<DatosPersonajes> datosPersonajes = objectMapper.readValue(json, new TypeReference<DatosItems<DatosPersonajes>>() {});
        System.out.println(datosPersonajes);
    }    
}