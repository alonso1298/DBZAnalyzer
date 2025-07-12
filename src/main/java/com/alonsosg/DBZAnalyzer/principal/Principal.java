package com.alonsosg.DBZAnalyzer.principal;

import java.util.Scanner;

import com.alonsosg.DBZAnalyzer.service.ConsumoAPI;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private final String URL_BASE = "https://dragonball-api.com/api/characters/";
}