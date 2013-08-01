package lk.sachithhirantha.AI;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import lk.sachithhirantha.Util.Searcher;
import lk.sachithhirantha.controller.Engine;
import lk.sachithhirantha.gamemodels.Bounty;
import lk.sachithhirantha.gamemodels.Map;
import lk.sachithhirantha.gamemodels.MapObject;
import lk.sachithhirantha.gamemodels.Player;

// This is the AI version 1

public class AiVersion1 implements Observer {
	private Engine engine;
	private MapObject[][] map;
	private List<Bounty> bountyMap;
	private Player thisPlayer, players[];
	private Map mainMap;
	private Searcher searcher;

	public AiVersion1() {
		engine = Engine.getInstance();
		mainMap = Map.getInstance();
		engine.addObserver(this);
		searcher = new Searcher();

	}

	public void update(Observable o, Object arg) {
		if (o instanceof Engine) {
			if (((String) arg).equals("GLOBAL_UPDATE")) {
				map = Engine.getInstance().getMap();
				
				bountyMap = mainMap.getBountyMap();
				thisPlayer = Engine.getInstance().getThisPlayer();
				players = mainMap.getPlayers();
				makeNextDecision();
				//makeMove();
			}
		}
	}

	private void makeMove() {
		int direction = searcher.getDirection();
		switch (direction) {
		case 1:
			engine.moveRight();
			break;
		case 2:
			engine.moveDown();
			break;
		case 3:
			engine.moveLeft();
			break;
		default:
			engine.moveUp();
		}

	}

	private void makeNextDecision() {
		for (int i = 0; i < players.length; i++) {
			System.out.println("inside for loop");
			if(players[i] != null && (players[i].getX() != thisPlayer.getX() || players[i].getY() != thisPlayer.getY())){
				if(players[i].getX() == thisPlayer.getX()){
					engine.shoot();
					System.out.println("HEREEEEEEEEEEEEEE");
					return;
				}else if(players[i].getY() == thisPlayer.getY()){
					engine.shoot();					
					return;
				}
			}
		}		
		makeMove();
	}

	private void shoot() {
		for (int i = 0; i < players.length; i++) {
			if (players[i] != null) {
				System.out.println(players[i].getX() + " and "
						+ players[i].getY() + "\n");
			}
		}

	}
}
