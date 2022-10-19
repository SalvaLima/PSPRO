import java.util.Scanner;

public class TicketJava {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int codigo = scn.nextInt();

        double precio = scn.nextDouble();

        int cantidad = scn.nextInt();

        double total = precio * cantidad;

        System.out.println(codigo + " " + precio + " " + cantidad + " " + total);

    }
}
