import java.util.ArrayList;

public class Main {


    public static int numEscondido = (int)(Math.random()*1000000+1);
    public static boolean numEncontrado = false;

    public static void main(String[] args) {


        ArrayList<NumOculto> listaNum = new ArrayList<>();



        for (int i = 0; i < 10; i++) {
            NumOculto numOculto = new NumOculto();
            numOculto.setName("Hilo " + i);
            listaNum.add(numOculto);

        }

        for (int i = 0; i < listaNum.size(); i++) {

            listaNum.get(i).start();

        }


    }
}