package server;

import java.net.ServerSocket;
import java.io.IOException;

/**
 * @author Yoann Boyer
 */
class Server {
    private final static int PORT = 5228;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started on port " + PORT);

            new Thread(new Listener(serverSocket)).start();
        } catch (IOException e) {
            System.out.println("Can't listen on port " + PORT + ": " + e.getMessage());
        }
    }
}
