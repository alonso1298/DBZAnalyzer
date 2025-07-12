package com.alonsosg.DBZAnalyzer.deserializers;

import java.io.IOException;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class KiDeserializer extends JsonDeserializer<Double>{

    @Override
    public Double deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        String rawKi = p.getText();

        if (rawKi == null || rawKi.isBlank()) return 0.0;

        rawKi = rawKi.replace(",", "").trim();

        double multiplicador = 1;

        if (rawKi.toLowerCase().contains("million")) {
            multiplicador = 1_000_000;
            rawKi = rawKi.replaceAll("[^\\d.]", "");
        } else if (rawKi.toLowerCase().contains("billion")) {
            multiplicador = 1_000_000_000;
            rawKi = rawKi.replaceAll("[^\\d.]", "");
        } else if (rawKi.toLowerCase().contains("trillion")) {
            multiplicador = 1_000_000_000_000L;
            rawKi = rawKi.replaceAll("[^\\d.]", "");
        } else if (rawKi.toLowerCase().contains("septillion")) {
            multiplicador = 1e24;
            rawKi = rawKi.replaceAll("[^\\d.]", "");
        } else {
            rawKi = rawKi.replaceAll("[^\\d.]", "");
        }

        try {
            return Double.parseDouble(rawKi) * multiplicador;
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
}
