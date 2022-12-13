public class Main extends Thread {

    public static boolean[] libros = new boolean[9];

    public static final Object obj = new Object();

    @Override
    public void run() {


        try {

            while (true) {

                int libro = (int) (Math.random() * 9);

                int libro2 = (int) (Math.random() * 9);


                while (libro == libro2) {

                    libro2 = (int) (Math.random() * 9);

                }

                synchronized (obj) {

                    while (libros[libro] || libros[libro2]) {

                        try {
                            obj.wait();

                        } catch (InterruptedException er) {
                            er.printStackTrace();
                        }
                    }
                    libros[libro] = true;

                    libros[libro2] = true;

                }

                System.out.println("El " + Thread.currentThread().getName() + " ha reservados los libros " + libro + " y " + libro2);

                Thread.sleep((long) (Math.random() * 2000 + 3000));

                System.out.println("El " + Thread.currentThread().getName() + " ha terminado de leer.");

                synchronized (obj) {

                    libros[libro] = false;

                    libros[libro2] = false;

                    obj.notifyAll();

                }
            }

        } catch (InterruptedException er) {
            er.printStackTrace();
        }

    }

    public static void main(String[] args) {

        for (int i = 0; i < 4; i++) {
            Main estudiante = new Main();
            estudiante.setName("Estudiante " + i);
            estudiante.start();
        }


    }
}