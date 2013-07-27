package lk.sachithhirantha.gamemodels;

public class DeadPlayer extends Player {

	public DeadPlayer(Player player) {
		super(player.getX(), player.getY(), player.getDirection(), player
				.getName(), player.getHealth(), player.getPoints(), player
				.getCoins(), player.isOpponent(), player.isShot());
	}

}