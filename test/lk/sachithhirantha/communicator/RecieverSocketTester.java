package lk.sachithhirantha.communicator;

import lk.sachithhirantha.communicator.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RecieverSocketTester {
	RecieverSocket reciever;
	SenderSocket sender;
	@Before
	public void setUp() throws Exception {
		reciever = new RecieverSocket();
		sender = new SenderSocket();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {		
		Thread recieverThread = new Thread(new RecieverSocket());
		recieverThread.start();
		sender.sendMessage("#JOIN");
	}

}
