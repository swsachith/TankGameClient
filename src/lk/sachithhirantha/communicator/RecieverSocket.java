package lk.sachithhirantha.communicator;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RecieverSocket extends Observable implements Runnable {

	private ServerSocket serverSocket;
	private Socket socket;
	private byte[] buffer;
	private int port;

	public RecieverSocket() {
		port = 7000;
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException ex) {
			Logger.getLogger(RecieverSocket.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		buffer = new byte[10000];
	}

	@Override
	public void run() {
		listen();
	}

	private void listen() {
		while (true) {
			try {
				socket = serverSocket.accept();
				InputStream inputStream = socket.getInputStream();
				inputStream.read(buffer);
				//System.out.println(new String(buffer));
				String message = (new String(buffer)).split("#")[0];

				setChanged();
				notifyObservers(message);				
			} catch (IOException ex) {
				Logger.getLogger(RecieverSocket.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
	}
}
