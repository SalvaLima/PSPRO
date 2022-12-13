package Ejercicio2;

import static Ejercicio2.Main.*;

public class Productores extends Thread {
    String nombre;

    public Productores(String nombre) {
        this.nombre = nombre;
    }

    public void colaProcutor(){

        int dineroObtenido;

        try {
            productores.acquire();
            Thread.sleep((int)(Math.random()*190+10));
            dineroObtenido = (int)(Math.random()*21+4);
            if (dineroObtenido + dinero > 2000){
                System.out.println("No se puede , se supera el límite");
            }
            else {
                dinero += dineroObtenido;
                System.out.println("El " + nombre + " ha conseguido " + dineroObtenido + " , ahora hay " + dinero + "€");
            }

        }catch (InterruptedException er){
            System.out.println("Se ha interrumpido el hilo");
        }

    }

    @Override
    public void run() {

        while (true){


            if (dinero < 2000){

                colaProcutor();

            }
            else {

                System.out.println("Se supera el límite");
            }

        }


    }
}
