package server;

import java.net.ServerSocket;
import java.io.IOException;

/**
 * @author Yoann Boyer
 */
class Listener implements Runnable {
    ServerSocket socket;

    public Listener(ServerSocket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("Waiting clients..");
                socket.accept();
            }
        } catch (IOException e) {
            System.out.println("Error handling client connection: " + e.getMessage());
        }
    }
}
