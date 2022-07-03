package com.truist.plz.model;

public class Abc {

	private String name;

	private String ID;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Abc(String name, String iD) {
		super();
		this.name = name;
		ID = iD;
	}

	@Override
	public String toString() {
		return "Abc [name=" + name + ", ID=" + ID + "]";
	}

}
