package ConexionTCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClienteTCP {


    public static void main(String[] args) {

        try {

            //1 Creación del socket cliente

            Socket socketCliente = new Socket(InetAddress.getLocalHost(),50000);

            //2 Abrir flujos

            System.out.println("Abriendo flujos de entrada y salida");

            InputStream is = socketCliente.getInputStream();

            OutputStream os = socketCliente.getOutputStream();

            //3 Intercambio de datos con el servidor

            System.out.println("Envia mensaje al servidor");

            os.write(15);

            System.out.println("Lectura del mensaje");

            System.out.println("Mensaje recibido por servidor " + is.read());

            //4 Cerrar los flujos de lectura y escritura

            System.out.println("Cerramos flujo");

            is.close();

            os.close();

            //5 Cerrar el socket

            socketCliente.close();

        }catch (UnknownHostException e){
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
