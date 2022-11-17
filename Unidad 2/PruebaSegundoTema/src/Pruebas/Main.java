package Pruebas;

public class Main {
    public static void main(String[] args) {

        Thread t = Thread.currentThread();
        System.out.println(t.getName());
        System.out.println(t.getState());
        System.out.println(t.getId());
        System.out.println(t.isDaemon());
        System.out.println(t.getPriority());

        System.out.println("Prioridades");
        System.out.println("Prioridad máxima : " + Thread.MAX_PRIORITY);
        System.out.println("Prioridad minima : " + Thread.MIN_PRIORITY);
        System.out.println("Prioridad default : " + Thread.NORM_PRIORITY);
    }
}