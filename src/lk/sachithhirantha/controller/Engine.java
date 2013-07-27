package lk.sachithhirantha.controller;

import java.util.Observable;
import java.util.Observer;

import lk.sachithhirantha.communicator.Messenger;
import lk.sachithhirantha.gamemodels.Map;
import lk.sachithhirantha.gamemodels.MapObject;
import lk.sachithhirantha.gamemodels.Player;

/* 
 * This class is the Game Engine of the project
 * Gets the messenger from the Messenger class and passes it to the MessageProcessor
 * */
public class Engine extends Observable implements Observer {
	// the size of the grid
	public static final int NO_ROWS = 10, NO_COLUMNS = 10;

	public static Engine engine = null;
	private Messenger messenger;
	private MapController mapController;
	private Map map;

	private Engine() {
		this.messenger = Messenger.getInstance();
		this.mapController = new MapController();
		this.map = Map.getInstance();
		map.addObserver(this);
	}

	public static Engine getInstance() {
		if (Engine.engine == null) {
			Engine.engine = new Engine();
		}
		return Engine.engine;
	}

	public void join() {
		messenger.join();
	}

	public void moveUp() {
		messenger.up();
	}

	public void moveDown() {
		messenger.down();
	}

	public void moveLeft() {
		messenger.left();
	}

	public void moveRight() {
		messenger.right();
	}

	public void shoot() {
		messenger.shoot();
	}

	public MapObject[][] getMap() {
		return map.getMap();
	}

	public Player[] getPlayers() {
		return map.getPlayers();
	}

	public Player getThisPlayer() {
		return map.thisPlayer();
	}

	public void update(Observable o, Object arg) {
		if (o instanceof Map) {
			setChanged();
			notifyObservers(arg);
		}
	}

}
