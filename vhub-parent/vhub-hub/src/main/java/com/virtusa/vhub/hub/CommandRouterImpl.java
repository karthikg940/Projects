package com.virtusa.vhub.hub;

import java.util.logging.Logger;
//
//import org.apache.activemq.camel.component.ActiveMQComponent;
//import org.apache.camel.CamelContext;
//import org.apache.camel.ProducerTemplate;
//import org.apache.camel.builder.RouteBuilder;
//import org.apache.camel.impl.DefaultCamelContext;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

import com.virtusa.vhub.partner1.entity.Command;

public class CommandRouterImpl implements CommandRouter {

	Logger LOGGER = Logger.getLogger(CommandRouterImpl.class.getName());

	@Override
	public Command router(Command command) {

		LOGGER.info("this is entity obj" + command);
		System.out.println("this is entity obj" + command);

		CamelContext context = new DefaultCamelContext();
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
				"admin", "admin", "tcp://localhost:61616");
		context.addComponent("jms",
				JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
		try {
			context.addRoutes(new RouteBuilder() {
				public void configure() {
					from("timer:foo?period=1s")
							.setBody(
									simple("Message at ${date:now:yyyy-MM-dd HH:mm:ss}"))
							.to("jms:LLY.TRAINING.EMAIL.IN");
				}

			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			context.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			context.stop();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return command;
	}

}
