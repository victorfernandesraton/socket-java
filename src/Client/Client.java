package Client;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

    private String host;
    private int port;

    public Client (String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void execute() throws UnknownHostException, IOException {
        Socket client = new Socket(this.host, this.port);
        System.out.printf("\nO client se conectou ao servidor %s:%d\n", this.host, this.port);

        // Recive é responsável por ceber as mensagens em thread individual
        Recive r = new Recive(client.getInputStream());
        new Thread(r).start();

        // lê msgs do teclado e manda pro servidor
        Scanner input = new Scanner(System.in);
        PrintStream saida = new PrintStream(client.getOutputStream());
        while (input.hasNextLine()) {
            saida.println(input.nextLine());
        }

        saida.close();
        input.close();
        client.close();
    }
}