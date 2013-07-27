package lk.sachithhirantha.controller;

import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

import lk.sachithhirantha.communicator.Messenger;
import lk.sachithhirantha.gamemodels.Map;

public class MapController implements Observer {

    private Map map;

    public MapController() {
	Messenger.getInstance().addObserver(this);
	map = Map.getInstance();
    }

    @Override
    public void update(Observable o, Object arg) {
	if (o instanceof Messenger) {
	    String string = (String) arg;
	    if (string.startsWith("G:")) {
		updateMap(string);
	    } else if (string.startsWith("L:")) {
		setLifePack(string);
	    } else if (string.startsWith("C:")) {
		setCoinPile(string);
	    } else if (string.startsWith("S:")) {
		initialisePlayers(string);
	    } else if (string.startsWith("I:")) {
		initialiseMap(string);
	    } else {
		Logger.getLogger(MapController.class.getName()).log(
			Level.SEVERE, "Un Identified String: {0}", string);
	    }
	}

    }

    private void setCoinPile(String string) {
	map.setCoinPile(string);

    }

    private void initialiseMap(String string) {
	map.initialiseMap(string);

    }

    private void initialisePlayers(String string) {
	map.initialisePlayers(string);

    }

    private void setLifePack(String string) {
	map.setLifePack(string);

    }

    private void updateMap(String string) {
	map.updateMap(string);

    }

}