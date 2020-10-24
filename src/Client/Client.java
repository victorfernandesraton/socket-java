package Client;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

    private String host;
    private int port;

    public Client(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void executa() throws IOException {
        try(Socket Client = new Socket(this.host, this.port);
            Scanner teclado = new Scanner(System.in);
            PrintStream saida = new PrintStream(Client.getOutputStream())) {
            System.out.println("O cliente se conectou ao servidor!");

            MessageHandler r = new MessageHandler(Client.getInputStream());
            new Thread(r).start();

            while (teclado.hasNextLine()) {
                saida.println(teclado.nextLine());
            }
        }
    }
}