import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ProcessBuilder pb1 = new ProcessBuilder("java","clase1.java");
        ProcessBuilder pb2 = new ProcessBuilder("java","clase2.java");
        ProcessBuilder pb3 = new ProcessBuilder("java","clase3.java");

        pb1.directory(new File("C:\\Users\\slima\\Desktop\\Segundo\\PSP\\EjercicioUnidad1-7\\src"));
        pb2.directory(new File("C:\\Users\\slima\\Desktop\\Segundo\\PSP\\EjercicioUnidad1-7\\src"));
        pb3.directory(new File("C:\\Users\\slima\\Desktop\\Segundo\\PSP\\EjercicioUnidad1-7\\src"));

        List<ProcessBuilder> lbp = new ArrayList<>();
        lbp.add(pb1);
        lbp.add(pb2);
        lbp.add(pb3);

        pb1.redirectError(ProcessBuilder.Redirect.INHERIT);
        pb2.redirectError(ProcessBuilder.Redirect.INHERIT);
        pb3.redirectError(ProcessBuilder.Redirect.INHERIT);

        pb3.redirectOutput(new File("nosecaca.txt"));

        try {
            List<Process> lProcess = ProcessBuilder.startPipeline(lbp);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}