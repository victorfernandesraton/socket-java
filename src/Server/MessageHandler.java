package Server;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

class MessageHandler implements Runnable {

    private Socket cliente;
    private Server servidor;

    public MessageHandler(Socket cliente, Server servidor) {
        this.cliente = cliente;
        this.servidor = servidor;
    }

    public void run() {
        try (Scanner s = new Scanner(this.cliente.getInputStream())) {
            while (s.hasNextLine()) {
                servidor.broadcast(this.cliente, s.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}