import java.util.concurrent.Semaphore;

public class Carniceria extends Thread {

    static Semaphore semaphore = new Semaphore(4);

    static Semaphore semaphore2 = new Semaphore(2);

    private boolean atendidoCarniceria = false;

    private boolean atentidoCharcuteria = false;

    public void colaCarniceria(){

        try {
            semaphore.acquire();
            System.out.println("La " + currentThread().getName() + " está siendo atendido en la carnicería");
            Thread.sleep(1000);
            System.out.println("La " + currentThread().getName() + " ha terminado en la carnicería");
            semaphore.release();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


    public void colaCharcuteria(){

        try {
            semaphore2.acquire();
            System.out.println("La " + currentThread().getName() + " está siendo atendido en la charcutería");
            Thread.sleep(1000);
            System.out.println("La " + currentThread().getName() + " ha terminado en la charcutería");
            semaphore2.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void run() {

        while (!atendidoCarniceria || !atentidoCharcuteria) {

            if (semaphore.availablePermits()>0 && !atendidoCarniceria){

                colaCarniceria();
                atendidoCarniceria = true;
            }
            if (semaphore2.availablePermits()>0 && !atentidoCharcuteria){

                colaCharcuteria();
                atentidoCharcuteria = true;

            }

            if (atentidoCharcuteria && atendidoCarniceria){

                System.out.println("El cliente " + Thread.currentThread().getName() + " ha terminado");

            }

        }


    }

}
