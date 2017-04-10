package com.virtusa.vhub.consumer1;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class CommandMessageListener implements MessageListener {

	@Override
	public void onMessage(Message message) {
		try {
			TextMessage msg = (TextMessage) message;
			System.out.println("after in to receive()");
			System.out.println("message is" + msg.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
