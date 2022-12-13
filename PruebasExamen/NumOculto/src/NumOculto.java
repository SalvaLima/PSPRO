public class NumOculto extends Thread {


    public int num = 0;


    @Override
    public void run() {

        while (!Main.numEncontrado){

            num = (int)(Math.random()*1000000+1);

            if(PropuestaNumero(num) == -1){

                currentThread().interrupt();

                System.out.println("Se ha encontrado por otro hilo");

            }
        }

    }

    synchronized public static int PropuestaNumero(int num){

        int numObtenido = 0;

        if (Main.numEscondido ==  num && !Main.numEncontrado){

            numObtenido = 1;

            Main.numEncontrado = true;

            System.out.println("El " + currentThread().getName() + " ha adivinado el número oculto");

        } else if (Main.numEncontrado) {

            numObtenido = -1;
        }

        return numObtenido;

    }


}
