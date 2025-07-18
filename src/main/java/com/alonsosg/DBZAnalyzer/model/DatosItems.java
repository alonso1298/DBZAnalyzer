package com.alonsosg.DBZAnalyzer.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosItems<T>(
    @JsonAlias("items") List<T> items

) {
}
