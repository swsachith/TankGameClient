package lk.sachithhirantha.communicator;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SenderSocket {
	private String host;
	private int port;
	private Socket socket;
	private BufferedWriter bufferedWriter;

	public SenderSocket() {
		this.host = "127.0.0.1";
		this.port = 6000;
	}

	private void connect() {
		try {
			socket = new Socket(host, port);
		} catch (IOException ex) {
			Logger.getLogger(SenderSocket.class.getName()).log(Level.SEVERE,
					null, ex);
		}
	}

	public void sendMessage(String message) {
		try {
			if (socket == null) {
				connect();
			}
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(
					socket.getOutputStream()));
			bufferedWriter.write(message);
			bufferedWriter.close();
			socket.close();
			socket = null;

		} catch (IOException ex) {
			Logger.getLogger(SenderSocket.class.getName()).log(Level.SEVERE,
					null, ex);

		}
	}
}