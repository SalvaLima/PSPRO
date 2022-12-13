import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class GestorHojas extends Thread {

	private static List<String> lista = new ArrayList<String>();

	@Override
	public void run() {

		sincronizar();

	}

	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {

			new GestorHojas().start();
		}

	}

	synchronized public static void sincronizar(){

		CopyOnWriteArrayList<String> copyOnWrite = new CopyOnWriteArrayList<>();


		for (int i = 0; i < 10; i++) {

			copyOnWrite.add(new String("Texto" + i));

		}

		for (String string : copyOnWrite) {

			System.out.println(string);

		}

	}

}
