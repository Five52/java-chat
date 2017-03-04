package server;

import java.net.ServerSocket;
import java.io.IOException;


/**
 * @author Yoann Boyer
 */
class Connector implements Runnable {
    ServerSocket socket;

    public Connector(ServerSocket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("Waiting clients..");

                new Thread(new Connexion(this.socket.accept())).start();
            }
        } catch (IOException e) {
            System.out.println("Error on client connection: " + e.getMessage());
        }
    }
}
