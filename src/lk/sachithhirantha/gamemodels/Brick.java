package lk.sachithhirantha.gamemodels;

public class Brick extends Obstacle {
	private int damage;

	public Brick(int x, int y, String string, int d) {
		super(x, y, string);
		damage = d;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
}