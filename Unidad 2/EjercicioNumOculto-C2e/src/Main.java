import java.util.ArrayList;

public class Main {

    public static boolean encontrado = false;

    public static int numOculto = (int)(Math.random()*101);

    public static void main(String[] args) {

        ArrayList<NumeroOculto> listaDeHilos = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            listaDeHilos.add(new NumeroOculto());
            listaDeHilos.get(i).setName("Hilo " + i);
        }

        for (int i = 0; i < listaDeHilos.size(); i++) {
            listaDeHilos.get(i).start();
        }

    }
}