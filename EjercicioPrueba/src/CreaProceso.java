import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CreaProceso {

    public static void main (String [] args){

        Scanner scn = new Scanner(System.in);

        ProcessBuilder pb;

        String comando;

        System.out.println("Inserte el proceso que desea utilizar");

        comando = scn.nextLine();

        pb = new ProcessBuilder(comando);
        pb.inheritIO();

        try {
            Process p = pb.start();
        }catch (IOException er){
            er.printStackTrace();
        }

        /**
         * ProcessBuilder pb = new ProcessBuilder("java","Holamundo.java");
         *
         *         pb.directory(new File("C:\\Users\\slima\\Desktop\\Segundo\\PSP\\EjercicioPrueba\\src"));
         *
         *         System.out.println("Voy a lanzar proceso");
         *         pb.inheritIO();
         *         try {
         *             Process p = pb.start();
         *         }catch (IOException er){
         *             er.printStackTrace();
         *         }
         */

    }

}
