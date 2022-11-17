import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        ProcessBuilder pb = new ProcessBuilder("java","TicketJava.java");
        File ruta = new File("src/");
        pb.directory(ruta);


        pb.inheritIO();


        pb.redirectOutput(ProcessBuilder.Redirect.appendTo(new File("src/diablo.txt")));

        try {

            Process p = pb.start();

        }catch (IOException er){
            er.printStackTrace();
        }

    }
}