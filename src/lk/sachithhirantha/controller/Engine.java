package lk.sachithhirantha.controller;

import java.util.Observable;
import java.util.Observer;

import lk.sachithhirantha.communicator.Messenger;

/* 
 * This class is the Game Engine of the project
 * Gets the messenger from the Messenger class and passes it to the MessageProcessor
 * */
public class Engine implements Observer{
	private Messenger messenger;
	public Engine() {
		messenger = Messenger.getInstance();
		messenger.addObserver(this);
	}
	@Override
	public void update(Observable o, Object arg) {
		//String message = (String) arg;
	}
	
	
}
