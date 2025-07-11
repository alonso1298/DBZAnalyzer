package com.alonsosg.DBZAnalyzer.service;

public interface IConvierteDatos {
    <T> T obtenerDatos(String json, Class<T> clase);
}
