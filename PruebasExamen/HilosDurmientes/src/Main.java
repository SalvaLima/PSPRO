public class Main {

    public static void main(String[] args) throws InterruptedException {

        clsThread t = new clsThread();

        for (int i = 0; i < 5; i++) {

            t.setName("Hilo " + i);

            t.run();

        }

    }

}