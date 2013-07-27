package lk.sachithhirantha.communicator;

import java.util.Observable;
import java.util.Observer;

import lk.sachithhirantha.communicator.Messenger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MessengerTester implements Observer {
	Messenger messenger;
	@Before
	public void setUp() throws Exception {
		messenger = Messenger.getInstance();				
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws InterruptedException {
		messenger.join();
		messenger.addObserver(this);
		Thread.sleep(30000);
		
	}
	@Override
	public void update(Observable o, Object arg) {
		System.out.println((String) arg);
	}
}
