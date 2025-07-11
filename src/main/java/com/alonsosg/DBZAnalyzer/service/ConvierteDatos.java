package com.alonsosg.DBZAnalyzer.service;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvierteDatos implements IConvierteDatos{
    private ObjectMapper objectMapper = new ObjectMapper();
    
    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
        try {
            return objectMapper.readValue(json, clase);
        } catch (Exception e) {
            throw new RuntimeException("Error al convertir datos JSON a objeto: " + e.getMessage(), e);
        }
    }
    
}
