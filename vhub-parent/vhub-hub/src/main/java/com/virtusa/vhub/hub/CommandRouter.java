package com.virtusa.vhub.hub;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.virtusa.vhub.partner1.entity.Command;

@Path("api")
public interface CommandRouter {
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	@Path("/commandrouter")
	public Command router(Command command);
}
