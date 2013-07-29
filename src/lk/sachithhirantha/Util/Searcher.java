package lk.sachithhirantha.Util;

import java.beans.DesignMode;

import org.hamcrest.core.IsInstanceOf;

import lk.sachithhirantha.controller.Engine;
import lk.sachithhirantha.gamemodels.Bounty;
import lk.sachithhirantha.gamemodels.Map;
import lk.sachithhirantha.gamemodels.MapObject;
import lk.sachithhirantha.gamemodels.Obstacle;
import lk.sachithhirantha.gamemodels.Player;

// this class is the main searcher. it returns the next direction it should go to

public class Searcher {
	private static final int HEIGHT = 10, WIDTH = 10;
	private int heuristics[][];
	private MapObject[][] map;
	private Player thisPlayer;
	private Engine engine;
	
	public Searcher(){
		engine = Engine.getInstance();
		heuristics = new int[HEIGHT][WIDTH];
	}
	
	// A* searching for a given Node
	public void aStarSearcher(MapObject[][] objects, MapObject destination){		
		map = objects;		
		if(destination == null){
			destination = map[HEIGHT][WIDTH];
		}
		// initialize the heuristic array
		int thisPlayerX = thisPlayer.getX();
		int thisPlayerY = thisPlayer.getY();
		heuristics = new int[HEIGHT][WIDTH];
		thisPlayer = engine.getThisPlayer();		
		heuristics[thisPlayerY][thisPlayerX] = 0;
		heuristics[destination.getY()][destination.getX()] = -100;
		int heuristicValue = 0;
	
		
		// adding heuristicValues
		// Prioritizing paths containing bounty items
		
		for(int i = 0;i<HEIGHT;i++){
			for(int j = 0; j < WIDTH;j++){
				heuristicValue = Math.abs(destination.getX()-j)+ Math.abs(destination.getY() - i);
				if(j == thisPlayerX && i == thisPlayerY)
					continue;
				
				// avoid Obstacles
				if(map[i][j] instanceof Obstacle){
					heuristics[i][j] = 100000;
				}
				// prioritize bounty
				else if(map[i][j] instanceof Bounty){
					heuristics[i][j] = -10; 
				}else if(map[i][j] instanceof Player){
					heuristics[i][j] = -100;
				}
				else
					heuristics[i][j] = i+j+heuristicValue;
			}
		}
		
	}
	// get the surrounding minimum heuristic Value
	private int getMinSurroundHeuristic(int i, int j){
		int minHeuristic = 0;
				
		return minHeuristic;
	}
}
