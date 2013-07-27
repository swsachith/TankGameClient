package lk.sachithhirantha.gamemodels;

public class MapObject {

	private int x, y;
	private String name;

	public MapObject(int x, int y, String string) {
		this.x = x;
		this.y = y;
		this.name = string;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}