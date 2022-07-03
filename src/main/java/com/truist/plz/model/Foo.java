package com.truist.plz.model;

import java.util.List;

public class Foo {
	private List<Abc> abcList;
	private Bar bar;

	public Bar getBar() {
		return bar;
	}

	public void setBar(Bar bar) {
		this.bar = bar;
	}

	public List<Abc> getAbcList() {
		return abcList;
	}

	public void setAbcList(List<Abc> abcList) {
		this.abcList = abcList;
	}

	public Foo(List<Abc> abcList, Bar bar) {
		super();
		this.abcList = abcList;
		this.bar = bar;
	}

	@Override
	public String toString() {
		return "Foo [abcList=" + abcList + ", bar=" + bar + "]";
	}

}