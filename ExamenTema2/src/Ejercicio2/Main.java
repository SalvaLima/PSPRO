package Ejercicio2;

import java.util.concurrent.Semaphore;

public class Main {

    public static int dinero = 0;

    public static Semaphore consumidores = new Semaphore(2);

    public static Semaphore productores = new Semaphore(2);


    public static void main(String[] args) {

        Productores p1;
        Productores p2;
        Consumidores c1;
        Consumidores c2;

        while (true){

            p1 = new Productores("Productor1");

            p2 = new Productores("Productor2");

            c1 = new Consumidores("Consumidor1");

            c2 = new Consumidores("Consumidor2");

            p1.start();

            p2.start();

            c1.start();

            c2.start();

        }

    }
}
