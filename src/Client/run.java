package Client;

import java.io.IOException;
import java.net.UnknownHostException;

public class run {
    public static void main(String[] args)
            throws UnknownHostException, IOException {
        new Client("127.0.0.1", 8088).execute();
    }
}
