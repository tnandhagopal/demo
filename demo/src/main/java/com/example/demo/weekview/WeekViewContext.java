package com.example.demo.weekview;

public class WeekViewContext {

	private String head;
	private Integer foot;
	
	public WeekViewContext() {
		this.head = new String();
		this.foot = 0;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public Integer getFoot() {
		return foot;
	}

	public void setFoot(Integer foot) {
		this.foot = foot;
	}

}
