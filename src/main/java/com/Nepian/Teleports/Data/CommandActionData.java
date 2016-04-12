package com.Nepian.Teleports.Data;

public class CommandActionData {

	private Object object;
	
	public CommandActionData(Object object) {
		this.object = object;
	}
	
	public String asString() {
		return (String) value();
	}
	
	public Object value() {
		return object;
	}
}
