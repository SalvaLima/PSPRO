public class clsThread extends Thread {

    @Override
    public void run() {
        super.run();

        while (true){

            System.out.println("Soy un bucle y estoy trabajando");

            try {
                Thread.sleep((int) (Math.random() * 10000 + 1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }
}
