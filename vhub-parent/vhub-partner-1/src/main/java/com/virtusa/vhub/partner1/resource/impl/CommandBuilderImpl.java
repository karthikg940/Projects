package com.virtusa.vhub.partner1.resource.impl;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import com.virtusa.vhub.partner1.entity.Command;
import com.virtusa.vhub.partner1.resource.interfac.CommandBuilder;

public class CommandBuilderImpl implements CommandBuilder {

	@Override
	public String build(String name) {
		Command command = new Command();
		command.setCommand(name);
		command.setId(1);
		command.setType("string");

		Client client = ClientBuilder.newClient();
		WebTarget target = client
				.target("http://localhost:8181/cxf/vhub/api/commandrouter");
		Entity<Command> msgEntity = Entity.xml(command);
		Response response = target.request().post(msgEntity);
		String value = response.readEntity(String.class);
		return value;
	}

}
