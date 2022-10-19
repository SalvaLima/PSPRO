import java.util.Arrays;
import java.io.IOException;

public class LanzaProceso {

    public static void main(String[] args){

        if (args.length <= 0){

            System.out.println("Debe indicarse comando a ejecutar");

            System.exit(1);
        }

        Runtime r = Runtime.getRuntime();


        try {
            Process p = r.exec(args);


            int cod = p.waitFor();


            System.out.println("La ejecución de " +  Arrays.toString(args) + " devuelve " + cod );

            r.exit(69);

        }catch (IOException er){
            er.printStackTrace();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
