import java.io.*;

public class OtraClase2 {

    public static void main(String[] args) {

        Runtime r = Runtime.getRuntime();

        String [] comando = {"java","src\\PreguntaNombre.java"};

        try {
            Process p = r.exec(comando);

            BufferedReader br = new BufferedReader(new FileReader("src\\Prueba.txt"));

            OutputStream os = p.getOutputStream();

            OutputStreamWriter osw = new OutputStreamWriter(os);

            BufferedWriter bw = new BufferedWriter(osw);

            InputStream is = p.getInputStream();

            InputStreamReader isr = new InputStreamReader(is);

            BufferedReader br2 = new BufferedReader(isr);


            String aux = br.readLine();

            while (aux != null){

                bw.write(aux);
                bw.newLine();
                aux = br.readLine();

            }

            bw.close();
            System.out.println(br2.readLine());


        }catch (IOException er){
            er.printStackTrace();
        }


    }

}
