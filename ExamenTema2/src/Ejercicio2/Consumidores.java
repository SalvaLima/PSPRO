package Ejercicio2;

import static Ejercicio2.Main.*;

public class Consumidores extends Thread {

    String nombre;

    public Consumidores(String nombre) {
        this.nombre = nombre;
    }

    public void colaConsumidor(){

        int dineroObtenido;

        try {
            consumidores.acquire();
            Thread.sleep((int)(Math.random()*280+20));
            dineroObtenido = (int)(Math.random()*40+10);

            if (dinero - dineroObtenido < 0){
                System.out.println("No se puede quedar en negativo");
            }
            else {
                dinero -= dineroObtenido;
                System.out.println("El " + nombre + " ha recogido " + dineroObtenido + " , ahora hay " + dinero + "€");
            }


        }catch (InterruptedException er){
            System.out.println("Se ha interrumpido el hilo");
        }

    }

    @Override
    public void run() {


            if (dinero < 2000){

                colaConsumidor();

            }

            else {

                System.out.println("No hay dinero");

            }


    }
}
