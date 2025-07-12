package com.alonsosg.DBZAnalyzer.principal;

import java.util.Scanner;

import com.alonsosg.DBZAnalyzer.model.DatosItems;
import com.alonsosg.DBZAnalyzer.service.ConsumoAPI;
import com.alonsosg.DBZAnalyzer.service.ConvierteDatos;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private final String URL_BASE = "https://dragonball-api.com/api/characters/";
    private ConvierteDatos conversor = new ConvierteDatos();

    public void muestraMenu(){
        // Busca los datos generales de los personajes
        System.out.println("Datos de los personajes");
        String json = consumoAPI.obtenerDatos(URL_BASE);
        DatosItems datos = conversor.obtenerDatos(json, DatosItems.class);
        System.out.println(datos);
    }    
}