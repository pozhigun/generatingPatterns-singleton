package com.company.nonThreadSingleton;

public final class NonThreadSingleton {
    private static NonThreadSingleton instance;
    public String value;

    private NonThreadSingleton(String value) {
        this.value = value;
    }

    public static NonThreadSingleton getInstance(String value) {
        if (instance == null) {
            instance = new NonThreadSingleton(value);
        }

        return instance;
    }
}