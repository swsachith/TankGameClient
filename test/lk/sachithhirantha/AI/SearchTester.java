package lk.sachithhirantha.AI;

import static org.junit.Assert.*;
import lk.sachithhirantha.AI.AiVersion1;
import lk.sachithhirantha.AI.Searcher;
import lk.sachithhirantha.controller.Engine;
import lk.sachithhirantha.gamemodels.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SearchTester {
	private AiVersion1 ai;
	private Engine engine;
	Map map;
	Searcher searcher;
	@Before
	public void setUp() throws Exception {
		engine = Engine.getInstance();
		map = map.getInstance();
		searcher = new Searcher();
		ai = new AiVersion1();
		engine = Engine.getInstance();
	}

	@After
	public void tearDown() throws Exception {
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
