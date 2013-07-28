package lk.sachithhirantha.gamemodels;

public class Coin extends Bounty {
	private int value;

	public Coin(int x, int y, String string, int val, int ttl) {
		super(x, y, string, ttl);
		value = val;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String result = "";
		result += getX()+" and "+ getY();
		return result;
	}
}