public class Bucle extends Thread {


    private String Nombre;

    public Bucle (){


    }

    public Bucle (String nombre){

        this.Nombre = nombre;


    }

    public void run(){

        while (true){

            int numAleatorio = (int) (Math.random()*10000+1);

            System.out.println("Soy el bucle " + Nombre + " y estoy trabajando");
            try {
                Thread.sleep(numAleatorio);
                System.out.println(numAleatorio);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
