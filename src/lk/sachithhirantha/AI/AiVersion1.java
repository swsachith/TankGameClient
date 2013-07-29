package lk.sachithhirantha.AI;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

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

		public AiVersion1() {
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
					players = mainMap.getPlayers();
					makeNextDecision();
				}
			}
		}

		private void makeNextDecision() {
			shoot();
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
		private void shoot(){
			for(int i = 0;i<players.length;i++){
				if(players[i] != null){
					System.out.println(players[i].getX() + " and "+players[i].getY()+ "\n");
				}
			}
			
		}
	}


