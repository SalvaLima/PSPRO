import java.util.logging.Level;
import java.util.logging.Logger;

public class Mesa {

    private boolean[] palillos;

    public Mesa(int numTenedores){
        this.palillos = new boolean[numTenedores];
    }


    public synchronized void cogerPalillos(int comensal){

        while(palillos[palilloIzquierda(comensal)] || palillos[palilloDerecha(comensal)]){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Mesa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        palillos[palilloIzquierda(comensal)] = true;
        palillos[palilloDerecha(comensal)] = true;
    }

    public int palilloIzquierda(int i){
        return i;
    }

    public int palilloDerecha(int i){
        if(i == 0){
            return this.palillos.length - 1;
        }else{
            return i - 1;
        }
    }


    public synchronized void soltarPalillos(int comensal){
        palillos[palilloIzquierda(comensal)] = false;
        palillos[palilloDerecha(comensal)] = false;
        notifyAll();
    }

}