package com.alonsosg.DBZAnalyzer.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosPlanetas(
    @JsonAlias("id") Integer id,
    @JsonAlias("nanme") String nombrePlaneta,
    @JsonAlias("isDestroyed") Double estaDestruido,
    @JsonAlias("description") String descripcion
){}
