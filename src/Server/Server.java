package Server;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

    private int port;
    private List<PrintStream> clientes;

    public Server (int port) {
        this.port = port;
        this.clientes = new ArrayList<PrintStream>();
    }

    public void executa () throws IOException {
        ServerSocket servidor = new ServerSocket(this.port);
        System.out.printf("\nport %d aberta!", this.port);

        while (true) {
            // aceita um cliente
            Socket cliente = servidor.accept();
            System.out.printf("\nNova conexão com o cliente %s" ,cliente.getInetAddress().getHostAddress());

            // adiciona saida do cliente à lista
            PrintStream ps = new PrintStream(cliente.getOutputStream());
            this.clientes.add(ps);

            // cria tratador de cliente numa nova thread
            HandleClient tc =
                    new HandleClient(cliente.getInputStream(), this);
            new Thread(tc).start();
        }

    }

    public void broadcast(String msg) {
        // envia msg para todo mundo
        for (PrintStream cliente : this.clientes) {
            cliente.println(msg);
        }
    }
}