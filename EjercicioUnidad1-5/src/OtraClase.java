import java.io.File;
import java.io.IOException;

public class OtraClase {

    public static void main(String[] args) {

        ProcessBuilder pb = new ProcessBuilder("java","PreguntaNombre.java");
        File d = new File("src/");
        pb.directory(d);

        pb.inheritIO();

        pb.redirectInput(new File("src\\Prueba.txt"));
        try {

            Process p = pb.start();

        }catch (IOException er){
            er.printStackTrace();
        }

    }

}
