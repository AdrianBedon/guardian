package com.avilabedonliriaramos.guardian.guardian.enums;

public enum Tolerancia {
    MENOS_10("Menos del 10%"),
    MENOS_30("Menos del 30%"),
    MAS_30("Más del 30%");

    private final String description;

    Tolerancia(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
