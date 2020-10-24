package Client;

import java.io.InputStream;
import java.util.Scanner;

public class Recive implements Runnable {

    private InputStream servidor;

    public Recive(InputStream servidor) {
        this.servidor = servidor;
    }

    public void run() {
        // recebe msgs do servidor e imprime na tela
        Scanner s = new Scanner(this.servidor);
        while (s.hasNextLine()) {
            System.out.println(s.nextLine());
        }
    }
}