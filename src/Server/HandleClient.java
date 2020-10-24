package  Server;

import java.io.InputStream;
import java.util.Scanner;

public class HandleClient implements Runnable {

    private InputStream client;
    private Server server;

    public HandleClient(InputStream client, Server server) {
        this.client = client;
        this.server = server;
    }

    public void run() {
        Scanner s = new Scanner(this.client);
        while (s.hasNextLine()) {
            String payload = s.nextLine();
            server.broadcast(String.format("\nmessage :%s\nsize: %d",payload, payload.length()));
        }
        s.close();
    }
}
