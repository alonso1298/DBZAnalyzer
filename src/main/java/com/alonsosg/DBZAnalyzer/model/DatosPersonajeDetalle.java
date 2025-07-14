package com.alonsosg.DBZAnalyzer.model;

import com.alonsosg.DBZAnalyzer.deserializers.KiDeserializer;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosPersonajeDetalle(
    @JsonAlias("id") Integer id,
    @JsonAlias("name") String nombre,
    @JsonDeserialize(using = KiDeserializer.class)
    @JsonAlias("ki") Double ki,
    @JsonDeserialize(using = KiDeserializer.class)
    @JsonAlias("maxKi") Double maxKi,
    String race,
    String gender,
    String description,
    String image,
    String affiliation,
){}
