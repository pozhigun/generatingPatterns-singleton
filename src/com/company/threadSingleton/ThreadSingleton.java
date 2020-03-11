package com.company.threadSingleton;

public final class ThreadSingleton {
    private static volatile ThreadSingleton instance;
    public String value;

    private ThreadSingleton(String value) {
        this.value = value;
    }

    public static ThreadSingleton getInstance(String value) {
        ThreadSingleton result = instance;
        if (result != null) return result;

        synchronized (ThreadSingleton.class) {
            if (instance == null) instance = new ThreadSingleton(value);
            return instance;
        }
    }
}