package lk.sachithhirantha.communicator;

import java.util.Observable;
import java.util.Observer;


public class MessageReciever extends Observable implements Observer {

    private RecieverSocket socket;

    public MessageReciever() {
        socket = new RecieverSocket();
        socket.addObserver(this);
        Thread thread = new Thread(socket);
        thread.start();
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof RecieverSocket) {
            setChanged();
            notifyObservers((String) arg);
        }

    }
}