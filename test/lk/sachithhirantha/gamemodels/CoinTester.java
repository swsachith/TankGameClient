package lk.sachithhirantha.gamemodels;
import static org.junit.Assert.*;
import lk.sachithhirantha.controller.Engine;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class CoinTester {
	Engine engine;
	@Before
	public void setUp() throws Exception {
		engine = Engine.getInstance();
	}

	@After
	public void tearDown(){
		
	}

	@Test
	public void test() {
		engine.join();
		try {
			Thread.sleep(200000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
