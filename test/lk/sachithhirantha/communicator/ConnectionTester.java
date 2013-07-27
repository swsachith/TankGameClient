package lk.sachithhirantha.communicator;

import lk.sachithhirantha.communicator.Messenger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ConnectionTester {

	private Messenger messenger;

	@Before
	public void setUp() throws Exception {
		messenger = Messenger.getInstance();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		messenger.join();
		int i = 0;
		while (i < 5) {
			try {
				Thread.sleep(1000);
				messenger.right();
				i++;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
