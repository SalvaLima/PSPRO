public class NumeroOculto extends Thread{

    public int num = 0;

    public void run(){


        try {
            Thread.sleep(2000);
        }catch (InterruptedException er){
            er.printStackTrace();
        }


        while (!Main.encontrado){

            try {

                num = (int)(Math.random()*101);

                if (encontrarNumero(num) == -1){

                    currentThread().interrupt();

                    System.out.println("Se ha encontrado por otro proceso");

                }

            }catch (Exception er){
                er.printStackTrace();
            }

        }
    }

    synchronized public static int encontrarNumero(int num){

        int numEncontrado = 0;

        if(num == Main.numOculto && !Main.encontrado){

            numEncontrado = 1;

            Main.encontrado = true;

            System.out.println("El "+ currentThread().getName() + " ha encontrado el número oculto.");

        }else if(Main.encontrado){

            numEncontrado = -1;
        }

        return numEncontrado;
    }

}
