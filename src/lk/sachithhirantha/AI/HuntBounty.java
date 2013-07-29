package lk.sachithhirantha.AI;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import lk.sachithhirantha.controller.Engine;
import lk.sachithhirantha.gamemodels.Bounty;
import lk.sachithhirantha.gamemodels.Map;
import lk.sachithhirantha.gamemodels.MapObject;
import lk.sachithhirantha.gamemodels.Player;

// this is used to hunt Bounty

public class HuntBounty implements Observer {
	private Engine engine;
	private MapObject[][] map;
	private List<Bounty> bountyMap;
	private Player thisPlayer;
	private Map mainMap;

	public HuntBounty() {
		engine = Engine.getInstance();
		mainMap = Map.getInstance();
		engine.addObserver(this);
	}

	public void update(Observable o, Object arg) {
		if (o instanceof Engine) {
			if (((String) arg).equals("GLOBAL_UPDATE")) {
				map = Engine.getInstance().getMap();
				bountyMap = mainMap.getBountyMap();
				thisPlayer = Engine.getInstance().getThisPlayer();
				makeNextDecision();
			}
		}
	}

	private void makeNextDecision() {
		if (!bountyMap.isEmpty()) {
			for (Bounty bounty : bountyMap) {
				if (bounty.getTimeToLive() != 0)
					bounty.setTimeToLive(bounty.getTimeToLive() - 1000);
				else {
					bountyMap.remove(bounty);
				}
			}

			Bounty bounty = bountyMap.get(0);
			if (bounty.getX() > thisPlayer.getX()) {
				engine.moveRight();
			} else if (bounty.getX() < thisPlayer.getX()) {
				engine.moveLeft();
			} else if (bounty.getY() >= thisPlayer.getY()) {
				engine.moveDown();
			} else {
				engine.moveUp();
			}
		}
	}
}
