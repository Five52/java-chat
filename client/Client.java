package client;

import java.net.Socket;
import java.net.UnknownHostException;
import java.io.IOException;

class Client {
    private final static int PORT = 5228;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", PORT);

        } catch (UnknownHostException e) {
            System.err.println("Unable to connect to the host.");
        } catch (IOException e) {
            System.out.println("No listening server on port " + PORT);
        }
    }
}
