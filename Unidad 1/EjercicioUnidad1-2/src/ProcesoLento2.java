import java.io.*;

public class ProcesoLento2 {

    public static void main(String[] args) {

        Runtime r = Runtime.getRuntime();

        String [] comando = {"java","src\\ProcesoLento.java"};

        try {
            Process p = r.exec(comando);
            InputStream is = p.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            BufferedWriter bw = new BufferedWriter(new FileWriter("src\\sus.txt"));

            String aux = br.readLine();

            while (aux != null){

                bw.write(aux);
                bw.newLine();
                aux = br.readLine();
            }
            bw.close();
            br.close();
            isr.close();
            is.close();

        }catch (IOException er){
            er.printStackTrace();
        }
    }

}
