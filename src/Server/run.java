package Server;

import java.io.IOException;

public class run {
    public static void main(String[] args) throws IOException {
        new Server(8080).executa();
    }
}
