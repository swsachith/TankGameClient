package lk.sachithhirantha.Util;

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
	private Player thisPlayer, players[];
	private Engine engine;
	private Map mainMap;
	private int direction;

	public Searcher() {
		engine = Engine.getInstance();
		heuristics = new int[HEIGHT][WIDTH];
		mainMap = Map.getInstance();
		thisPlayer = engine.getThisPlayer();
		players = engine.getPlayers();
		map = engine.getMap();
	}

	// A* searching for a given Node
	private void aStarSearch(MapObject[][] objects, MapObject destination) {
		thisPlayer = engine.getThisPlayer();
		players = engine.getPlayers();
		map = objects;
		if (destination == null) {
			destination = players[0];
		}

		// initialize the heuristic array
		thisPlayer = engine.getThisPlayer();
		int thisPlayerX = thisPlayer.getX();
		int thisPlayerY = thisPlayer.getY();
		heuristics = new int[HEIGHT][WIDTH];

		heuristics[thisPlayerX][thisPlayerY] = 0;
		heuristics[destination.getX()][destination.getY()] = -1000;
		int heuristicValue = 0;
		int distance = 1;
		System.out.println(destination.getX() + " " + destination.getY() + ") "
				+ thisPlayerX + " " + thisPlayerY);

		// adding heuristicValues
		// Prioritizing paths containing bounty items

		for (int j = 0; j < HEIGHT; j++) {
			for (int i = 0; i < WIDTH; i++) {
				heuristicValue = Math.abs(destination.getX() - i)
						+ Math.abs(destination.getY() - j);
				distance = Math.abs(thisPlayerX - i)
						+ Math.abs(thisPlayerY - j);
				if (j == thisPlayerX && i == thisPlayerY)
					continue;
				if (map[i][j] == null) {
					heuristics[i][j] = distance + heuristicValue;
				}
				// avoid Obstacles
				else if (map[i][j] instanceof Obstacle) {
					heuristics[i][j] = 100000;
				}
				// prioritize bounty
				else if (map[i][j] instanceof Bounty) {
					heuristics[i][j] = -100;
				} else if (map[i][j] instanceof Player) {
					heuristics[i][j] = -1000;
				}
				// System.out.print(heuristics[i][j] + "\t");
			}
			// System.out.println();
		}

	}

	// value iteration
	private int valueIterate(MapObject destination) {

		thisPlayer = engine.getThisPlayer();
		int thisPlayerX = thisPlayer.getX();
		int thisPlayerY = thisPlayer.getY();
		if (destination == null) {
			destination = players[0];
		}
		int destX = destination.getX();
		int destY = destination.getY();

		int n, m, p, q;
		n = (destX >= thisPlayerX) ? destX : thisPlayerX;
		m = (destX >= thisPlayerX) ? thisPlayerX : destX;
		p = (destY >= thisPlayerY) ? destY : thisPlayerY;
		q = (destY >= thisPlayerY) ? thisPlayerY : destY;

		for (int j = q; j < p; j++) {
			for (int i = m; i < n; i++) {
				if (j == thisPlayerY && i == thisPlayerX)
					heuristics[i][j] = 0;
				if (heuristics[i][j] == 100000) {
					continue;
				} else if (heuristics[i][j] == -1000)
					continue;
				else if (heuristics[i][j] == -100)
					continue;
				else
					heuristics[i][j] = getMinSurroundHeuristic(i, j) + 1;
			}

		}
		getMinSurroundHeuristic(thisPlayerX, thisPlayerY);
		return direction;
	}

	// get the surrounding minimum heuristic Value
	private int getMinSurroundHeuristic(int i, int j) {
		int minHeuristic = 100000;
		direction = 1;
		if (i != 0 && minHeuristic > heuristics[i - 1][j]) {
			minHeuristic = heuristics[i - 1][j];
			// System.out.println("dir = 3 "+minHeuristic);
			direction = 3;
		}
		if (j != 0 && minHeuristic > heuristics[i][j - 1]) {
			minHeuristic = heuristics[i][j - 1];
			// System.out.println("dir = 4 "+minHeuristic);
			direction = 4;
		}
		if (j != (HEIGHT - 1) && minHeuristic > heuristics[i][j + 1]) {
			minHeuristic = heuristics[i][j + 1];
			// System.out.println("dir = 2 "+minHeuristic);
			direction = 2;
		}
		if (i != WIDTH - 1 && minHeuristic > heuristics[i + 1][j]) {
			minHeuristic = heuristics[i + 1][j];
			// System.out.println("dir = 1 "+minHeuristic);
			direction = 1;
		}
		System.out.println(minHeuristic + "\t" + direction);
		return minHeuristic;
	}

	public int getDirection() {
		aStarSearch(engine.getMap(), null);
		valueIterate(null);
		valueIterate(null);
		// int direction = getMinSurroundHeuristic(thisPlayer.getX(),
		// thisPlayer.getY());
		return direction;
	}
}
