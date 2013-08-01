package lk.sachithhirantha.gamemodels;

public class Player extends MapObject {

	private int points, coins, health, direction;

	private boolean isOpponent, isShot;

	public Player(int x, int y, int direction, String playerName, int health,
			int points, int coins, boolean isOpponent, boolean shot) {

		super(x, y, playerName);
		this.points = points;
		this.health = health;
		this.direction = direction;
		this.isOpponent = isOpponent;
		this.isShot = shot;
		this.coins = coins;
	}

	public int getOppositeDirection() {
		switch (direction) {
		case 0:
			return 2;
		case 1:
			return 3;
		case 2:
			return 0;
		default:
			return 1;
		}

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
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof Player){
			Player player = (Player) obj;
			if(this.getX() == player.getX() && this.getY() == player.getY()){
				return true;
			}
		}
		return false;
	}
}