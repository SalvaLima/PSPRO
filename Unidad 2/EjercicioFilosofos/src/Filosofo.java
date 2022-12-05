public class Filosofo extends Thread {

    private Mesa mesa;
    private int filosofo;
    private int indiceFilosofo;

    public Filosofo(Mesa m, int comensal){
        this.mesa = m;
        this.filosofo = comensal;
        this.indiceFilosofo = comensal - 1;
    }

    public void run(){

        while(true){
            this.pensando();
            this.mesa.cogerPalillos(this.indiceFilosofo);
            this.comiendo();
            System.out.println("Filosofo " + filosofo +  "ha dejado de comer, ha soltado los palillos " + (this.mesa.palilloIzquierda(this.indiceFilosofo) + 1) + ", " + (this.mesa.palilloDerecha(this.indiceFilosofo) + 1) );
            this.mesa.soltarPalillos(this.indiceFilosofo);
        }

    }

    public void pensando(){

        System.out.println("Filosofo " + filosofo + " esta pensando");
        try {
            sleep((long) (Math.random() * 4000));
        } catch (InterruptedException ex) { }

    }

    public void comiendo(){
        System.out.println("Filosofo " + filosofo + " está comiendo espaguetis");
        try {
            sleep((long) (Math.random() * 4000));
        } catch (InterruptedException ex) { }
    }

}