package com.alonsosg.DBZAnalyzer.model;

import com.alonsosg.DBZAnalyzer.deserializers.KiDeserializer;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosTransformaciones(
    @JsonAlias("id") Integer id,
    @JsonAlias("name") String nombre,
    @JsonAlias("ki") @JsonDeserialize(using = KiDeserializer.class) Double ki
){}
