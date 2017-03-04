package server;

import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;


/**
 * @author Yoann Boyer
 */
class Connexion implements Runnable {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private String username;

    public Connexion(Socket socket) throws IOException {
        this.socket = socket;
        this.in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        this.out = new PrintWriter(this.socket.getOutputStream());

        connect();
    }

    /**
     * Get the username
     * @return The username
     */
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
            System.out.println(this.getUsername() + " already used.");
        } else {
            System.out.println(this.getUsername() + " connected.");
        }
    }

    /**
     * Send a message to the client
     * @param message The message
     */
    public void send(Message message) {
        this.out.println(message.format());
        this.out.flush();
    }

    /**
     * Close the connexion
     * @throws IOException
     */
    private void close() throws IOException {
        System.out.println("Closing " + this.getUsername() + "'s connexion.");

        if (this.socket != null) {
            this.socket.close();
        }
        if (this.in != null) {
            this.in.close();
        }
        if (this.out != null) {
            this.out.close();
        }
    }

    @Override
    public void run() {
        UserManager manager = UserManager.getInstance();
        while (true) {
            try {
                String action = this.in.readLine();
                switch (action) {
                    case "SERV_MESSAGE":
                        String content = this.in.readLine();
                        Message message = new Message(this.username, System.currentTimeMillis(), content);
                        manager.broadcast(this, message);
                        break;
                    default:
                        System.out.println("Unknown action: " + action);
                }

            } catch (IOException e) {
                System.out.println(this.username + " Error reading incoming message: " + e.getMessage());
            }
        }
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
