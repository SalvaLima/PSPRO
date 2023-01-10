import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Main {


    public static void main(String[] args) {

        try {
            InetAddress direccion = InetAddress.getByName("www.rauwalejandro.com");
            System.out.println("Direccion Ip : " + direccion.getHostAddress());

            byte [] direccionIp = direccion.getAddress();

            System.out.println(Arrays.toString(direccionIp));

        }catch (UnknownHostException er){
            System.out.println("");
            er.printStackTrace();
        }

    }
}