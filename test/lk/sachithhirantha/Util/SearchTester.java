package lk.sachithhirantha.Util;

import static org.junit.Assert.*;
import lk.sachithhirantha.controller.Engine;
import lk.sachithhirantha.gamemodels.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SearchTester {
	Engine engine;
	Map map;
	Searcher searcher;
	@Before
	public void setUp() throws Exception {
		engine = Engine.getInstance();
		map = map.getInstance();
		searcher = new Searcher();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
	}

}
