package Client;

import java.io.InputStream;
import java.util.Scanner;

class MessageHandler implements Runnable {

    private InputStream servidor;

    public MessageHandler(InputStream servidor) {
        this.servidor = servidor;
    }

    public void run() {
        try(Scanner s = new Scanner(this.servidor)){
            while (s.hasNextLine()) {
                System.out.println(s.nextLine());
            }
        }
    }
}