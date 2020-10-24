package  Server;

import java.io.InputStream;
import java.util.Scanner;

public class HandleClient implements Runnable {

    private InputStream cliente;
    private Server servidor;

    public HandleClient(InputStream cliente, Server servidor) {
        this.cliente = cliente;
        this.servidor = servidor;
    }

    public void run() {
        // quando chegar uma msg, distribui pra todos
        Scanner s = new Scanner(this.cliente);
        while (s.hasNextLine()) {
            String payload = s.nextLine();
            servidor.broadcast(payload);
            servidor.broadcast(String.valueOf(payload.length()));
        }
        s.close();
    }
}
