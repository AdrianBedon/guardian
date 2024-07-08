package com.avilabedonliriaramos.guardian.guardian.enums;

public enum Valor {
    UNO(1),
    DOS(2),
    TRES(3);

    private final int value;

    Valor(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
