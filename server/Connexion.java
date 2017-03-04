package server;

import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


/**
 * @author Yoann Boyer
 */
class Connexion implements Runnable {
    private Socket socket;
    private BufferedReader in;
    private String username;

    public Connexion(Socket socket) throws IOException {
        this.socket = socket;
        this.in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));

        connect();
    }

    public String getUsername() {
        return this.username;
    }

    /**
     * Connect the user
     * @throws IOException
     */
    private void connect() throws IOException {
        this.username = this.in.readLine();
        UserManager manager = UserManager.getInstance();
        boolean exists = manager.add(this);

        if (exists) {
            this.close();
        }
    }

    /**
     * Close the socket
     * @throws IOException
     */
    private void close() throws IOException {
        System.out.println("Terminating thread.");

        if (this.socket != null) {
            this.socket.close();
        }
        if (this.in != null) {
            this.in.close();
        }
    }

    @Override
    public void run() {

    }

    @Override
    public int hashCode() {
        return this.getUsername().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Connexion) {
            return ((Connexion) obj).getUsername().equals(this.getUsername());
        }
        return false;
    }
}
