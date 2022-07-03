package com.truist.plz.model;

public class Bar {
	private Abc abc;

	private String bar;

	public Abc getAbc() {
		return abc;
	}

	public void setAbc(Abc abc) {
		this.abc = abc;
	}

	public Bar(Abc abc, String bar) {
		super();
		this.abc = abc;
		this.bar = bar;
	}

	public String getBar() {
		return bar;
	}

	public void setBar(String bar) {
		this.bar = bar;
	}

	@Override
	public String toString() {
		return "Bar [abc=" + abc + ", bar=" + bar + "]";
	}

}
