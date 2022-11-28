

public class Estudiante implements Runnable {

    public static boolean [] libros = new boolean[9];
    public static final Object obj = new Object();

    public static void main(String[] args) {

        Estudiante e = new Estudiante();

        for (int i = 1; i <= 4; i++) {

            Thread hilo = new Thread(e);

            hilo.setName("Estudiante " + i);

            hilo.start();
        }
    }

    @Override
    public void run() {

        try {

            while (true) {

                int libro1 = (int) (Math.random()*9);

                int libro2 = (int) (Math.random()*9);

                while (libro2 == libro1) {

                    libro2 = (int) (Math.random()*9);

                }

                synchronized (obj) {

                    while (libros[libro1] || libros[libro2]) {

                        try {

                            obj.wait();

                        } catch (InterruptedException e) {

                            e.printStackTrace();

                        }

                    }

                    libros[libro1] = true;

                    libros[libro2] = true;
                }

                System.out.println("El " + Thread.currentThread().getName() + " ha reservados los libros " + libro1 + " y " + libro2);

                Thread.sleep((long) (Math.random() *2000+3000));

                System.out.println("El " + Thread.currentThread().getName() + " ha terminado de leer.");

                synchronized (obj) {

                    libros[libro1] = false;

                    libros[libro2] = false;

                    obj.notifyAll();
                }

                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
