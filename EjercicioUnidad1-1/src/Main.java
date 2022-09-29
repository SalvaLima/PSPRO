import java.util.Map;

public class Main {
    public static void main(String[] args) {


        ProcessBuilder pb = new ProcessBuilder(args);

        pb.inheritIO();

        Map<String,String> entorno = pb.environment();

        for (String key: entorno.keySet()) {

            System.out.println("Clave : " + key);

            System.out.println("Valor de la clave : " +  entorno.get(key));
        }
    }
}