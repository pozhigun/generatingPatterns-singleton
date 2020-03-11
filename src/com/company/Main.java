package com.company;

import com.company.nonThreadSingleton.NonThreadSingleton;
import com.company.threadSingleton.ThreadSingleton;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        NonThreadSingleton firstExample = NonThreadSingleton.getInstance("First");
        NonThreadSingleton secondExample = NonThreadSingleton.getInstance("Second");

        Thread firstExampleThread = new Thread(new FirstExample());
        Thread secondExampleThread = new Thread(new SecondExample());

        System.out.println("Однопоточный: " + "\n" + firstExample.value + "\n" + secondExample.value + "\n");
        System.out.println("Многопоточный: ");
        firstExampleThread.start();
        secondExampleThread.start();
    }

    static class FirstExample implements Runnable {
        @Override
        public void run() {
            ThreadSingleton firstExample = ThreadSingleton.getInstance("First");
            System.out.println(firstExample.value);
        }
    }

    static class SecondExample implements Runnable {
        @Override
        public void run() {
            ThreadSingleton secondExample = ThreadSingleton.getInstance("Second");
            System.out.println(secondExample.value);
        }
    }
}