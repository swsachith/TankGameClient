package lk.sachithhirantha.gamemodels;

public class Player extends MapObject {

	private int points,coins,health,direction;

	private boolean isOpponent,isShot;

	public Player(int x, int y, int direction, String playerName, int health,
			int points,int coins, boolean isOpponent,boolean shot) {

		super(x, y, playerName);
		this.points = points;
		this.health = health;
		this.direction = direction;
		this.isOpponent = isOpponent;
                this.isShot = shot;
                this.coins = coins;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getCoins() {
		return coins;
	}

	public void setCoins(int coins) {
		this.coins = coins;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public boolean isOpponent() {
		return isOpponent;
	}

	public void setOpponent(boolean isOpponent) {
		this.isOpponent = isOpponent;
	}

	public boolean isShot() {
		return isShot;
	}

	public void setShot(boolean isShot) {
		this.isShot = isShot;
	}
}