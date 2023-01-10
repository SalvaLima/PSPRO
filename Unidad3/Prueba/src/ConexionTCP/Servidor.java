package ConexionTCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) {

        ServerSocket server;

        try {

            //1 Creación del socket servidor

            System.out.println("Abriendo conexion");

            server = new ServerSocket(5000);

            //2 Espera y acepta conexiones

            System.out.println("Aceptando conexión");

            Socket socketCliente = server.accept();

            //3 Flujos de entrada y salida

            System.out.println("Abriendo flujos de entrada y salida");

            InputStream is = socketCliente.getInputStream();

            OutputStream os = socketCliente.getOutputStream();

            os.write(7);

            //4 Intercambiar datos con el cliente

            System.out.println("Leo el mensaje del cliente");

            System.out.println("Mensake " + is.read());

            System.out.println("Envio mensaje al cliente");

            //5 Cerrar flujos de lecutra y escritura

            is.close();

            os.close();

            //6 Cerramos los sockets

            socketCliente.close();

            server.close();

        }catch (IOException er){

            System.out.println("Error");
            er.printStackTrace();
        }

    }

}
