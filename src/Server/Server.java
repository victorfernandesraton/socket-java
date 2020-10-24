package Server;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

    private int port;
    private List<Socket> clientes;

    public Server(int port) {
        this.port = port;
        this.clientes = new ArrayList<>();
    }

    public void executa() throws IOException  {
        try(ServerSocket Server = new ServerSocket(this.port)){
            System.out.printf("port %s  aberta!\n", this.port);

            do {
                Socket cliente = Server.accept();
                System.out.println("Nova conexão com o cliente " +
                        cliente.getInetAddress().getHostAddress());

                this.clientes.add(cliente);


                MessageHandler tc = new MessageHandler(cliente, this);
                new Thread(tc).start();
            } while (true);
        }
    }

    public void broadcast(Socket clienteQueEnviou, String msg) {
        for (Socket cliente : this.clientes) {
            if(!cliente.equals(clienteQueEnviou)){
                try {
                    PrintStream ps = new PrintStream(cliente.getOutputStream());
                    ps.println(msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}