package Client;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args)
            throws UnknownHostException, IOException {
        // dispara client
        new Client("127.0.0.1", 12345).execute();
    }

    private String host;
    private int port;

    public Client (String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void execute() throws UnknownHostException, IOException {
        Socket client = new Socket(this.host, this.port);
        System.out.println("O client se conectou ao servidor!");

        // thread para receber mensagens do servidor
        Recive r = new Recive(client.getInputStream());
        new Thread(r).start();

        // lê msgs do teclado e manda pro servidor
        Scanner teclado = new Scanner(System.in);
        PrintStream saida = new PrintStream(client.getOutputStream());
        while (teclado.hasNextLine()) {
            saida.println(teclado.nextLine());
        }

        saida.close();
        teclado.close();
        client.close();
    }
}