package com.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorThread {
    public static void section1() {
        Runnable hello = () -> {
            for (int i = 1; i <= 1000; i++)
                System.out.println("Hello " + i);
        };

        Runnable goodbye = () -> {
            for (int i = 1; i <= 1000; i++)
                System.out.println("Goodbye " + i);
        };

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(hello);
        executorService.execute(goodbye);
    }

    public static volatile boolean done = false;
    public static void section2() {
        Runnable hello = () -> {
            for (int i = 1; i <= 1000; i++)
                System.out.println("Hello " + i);

            done = true;
        };

        Runnable goodbye = () -> {
            int i = 1;
            while (!done) i++;
            System.out.println("Goodbye " + i);
        };

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(hello);
        executorService.execute(goodbye);
    }

    public static volatile int counter = 0;
    public static void section3() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 1; i <= 100; i++) {
            int taskId = i;
            Runnable task = () -> {
                for (int k = 1; k <= 1000; k++) {
                    counter++;
                }

                System.out.println(taskId + " : " + counter);
            };

            executorService.execute(task);
        }
    }

    public static void section5() {
        Runnable hello = () -> {
            try {
                Thread.sleep(1000);
                for (int i = 1; i <= 10; i++)
                    System.out.println("Hello " + i);

            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        };

        Runnable goodbye = () -> {
            for (int i = 1; i <= 10; i++)
                System.out.println("Goodbye " + i);
        };

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(hello);
        executorService.execute(goodbye);
    }

    public static void main(String[] args) {
//        section1();

//        section2();

//        section3();

        section5();
    }
}
