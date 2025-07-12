package com.alonsosg.DBZAnalyzer.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosPersonajes(
        @JsonAlias("id") Integer id,
        @JsonAlias("name") String nombre,
        @JsonAlias("ki") Double ki,
        @JsonAlias("race") String raza,
        @JsonAlias("gender") String genero,
        @JsonAlias("description") String descripcion
) {
}
