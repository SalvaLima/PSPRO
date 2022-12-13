public class Main {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {

            Carniceria carniceria = new Carniceria();

            carniceria.setName("Carniceria "+ i);

            carniceria.start();

        }

    }
}