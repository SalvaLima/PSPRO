package Ejercicio1;

import java.util.concurrent.Semaphore;

public class Peluqueria extends Thread {

    //Semáforo estático de sillas con un máximo de 4 sillas
    private static Semaphore sillas = new Semaphore(4);

    //Semáforo estáticos de barberos con un máximo de 2 barberos
    private static Semaphore barberos = new Semaphore(2);


    /**
     * Método run
     */
    @Override
    public void run() {

        colaSillas();

    }

    /**
     * Método de colaBarberos, en el cuál cada barbero irá pelando / recortando a cada cliente si es posible. Este
     * se usará dentro de la colaSillas ,por eso el sillas release está dentro de este métpdp
     */
    public void colaBarberos(){

        try {
            barberos.acquire();
            System.out.println("El " + Thread.currentThread().getName() + " está siendo afeitado");
            Thread.sleep((int) (Math.random()*4000 +100000));
            barberos.release();
            sillas.release();
            System.out.println("El " + Thread.currentThread().getName() + " se ha marchado" );
        }catch (InterruptedException er){
            System.out.println("Se ha interrumpido");
        }

    }

    /**
     * Método cola sillas en el cuál se comprobará si se puede agregar un cliente en base a las sillas disponibles que haya,
     * si no hay sillas disponibles se interrumpe ese hilo
     */

    public void colaSillas(){

        try {
            if (sillas.availablePermits()>0){
                sillas.acquire();
                System.out.println("El " + Thread.currentThread().getName() + " se ha sentado");
                colaBarberos();
            }
            else {
                System.out.println("El " + Thread.currentThread().getName() + " no tiene asiento");
                Thread.interrupted();
            }

        }catch (InterruptedException er){
            System.out.println("Error de Interrupcion");
        }


    }


    /**
     * Función main para ejecutarel programa
     * @param args
     */

    public static void main(String[] args) {

        /**
         * Bucle que especifica el número de clientes
         */

        for (int i = 0; i < 10; i++) {

            Peluqueria peluqueria = new Peluqueria();

            peluqueria.setName("Cliente "+ i);

            peluqueria.start();

            //Hacemos que el hilo se retrase de 1 a 5 segundos en la llegada de un nuevo cliente

            try {
                Thread.sleep((int) (Math.random()*1 +1000));
            }catch (InterruptedException er) {
                System.out.println("Se ha interrumpido el hilo");
            }


        }

    }
}
