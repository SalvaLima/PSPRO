import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        File directorio = new File("src");

        ProcessBuilder pb = new ProcessBuilder("java","ProcesoLento.java");

        pb.directory(directorio);

        pb.inheritIO();

        try {

            Process p = pb.start();

            while (p.isAlive()){
                System.out.println("El proceso sigue vivo");
                Thread.sleep(3000);
            }

        }catch (IOException er){
            er.printStackTrace();
        }catch (InterruptedException er){
            er.printStackTrace();
        }

    }


}