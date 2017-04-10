package com.virtusa.vhub.partner1.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Command {

	private int id;
	private String command;
	private String type;
	
	public Command() {
		super();
	}
	
	public Command(int id, String command, String type) {
		super();
		this.id = id;
		this.command = command;
		this.type = type;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
