import java.util.concurrent.Semaphore;

public class Carniceria implements Runnable {


    static Semaphore semaphore = new Semaphore(4);

    static Semaphore semaphore2 = new Semaphore(2);

    private boolean atendidoCarniceria = false;

    private boolean atentidoCharcuteria = false;

    public void colaCarniceria() {

        try {
            semaphore.acquire();
            System.out.println("El cliente " + Thread.currentThread().getName() + " está siendo atendido en la cancieria");
            Thread.sleep(1000);
            System.out.println("El cliente " + Thread.currentThread().getName() + " ha terminado en la carnicería");
            semaphore.release();
        } catch (InterruptedException er) {

            er.printStackTrace();
        }

    }

    public void colaCharcuteria() {

        try {
            semaphore2.acquire();
            System.out.println("El cliente " + Thread.currentThread().getName() + " está siendo atendido en la charcuteria");
            Thread.sleep(1000);
            System.out.println("El cliente " + Thread.currentThread().getName() + " ha terminado en la charcuteria");
            semaphore2.release();

        } catch (InterruptedException er) {
            er.printStackTrace();
        }

    }

    @Override
    public void run() {

        while (!atendidoCarniceria || !atentidoCharcuteria) {

            if (semaphore.availablePermits()>0 && !atentidoCharcuteria){

                colaCarniceria();
                atendidoCarniceria = true;
            }
            if (semaphore2.availablePermits()>0 && !atendidoCarniceria){

                colaCharcuteria();
                atentidoCharcuteria = true;

            }

            if (atentidoCharcuteria && atendidoCarniceria){

                System.out.println("El cliente " + Thread.currentThread().getName() + " ha terminado");

            }

        }


    }

    public static void main(String[] args) {

        Carniceria cn = new Carniceria();

        for (int i = 0; i < 10; i++) {

            Thread hilo = new Thread(cn);

            hilo.setName("Hilo" + i);
            hilo.start();

        }

    }
}
