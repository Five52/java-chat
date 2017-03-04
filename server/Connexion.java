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

    public Connexion(Socket socket) throws IOException {
        this.socket = socket;
        this.in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
    }

	@Override
	public void run() {

	}
}
