package com.alonsosg.DBZAnalyzer.model;

import com.alonsosg.DBZAnalyzer.deserializers.KiDeserializer;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosPersonajes(
        @JsonAlias("id") Integer id,
        @JsonAlias("name") String nombre,
        @JsonDeserialize(using = KiDeserializer.class)
        @JsonAlias("ki") Double ki,
        @JsonAlias("race") String raza,
        @JsonAlias("gender") String genero,
        @JsonAlias("description") String descripcion
) {
}
