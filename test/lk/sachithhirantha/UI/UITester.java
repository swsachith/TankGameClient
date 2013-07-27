package lk.sachithhirantha.UI;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.SlickException;

public class UITester {
	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		try {
			AppGameContainer app = new AppGameContainer(new TankGameClient());
			app.setDisplayMode(1280, 720, false);
			app.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}

	}

}
