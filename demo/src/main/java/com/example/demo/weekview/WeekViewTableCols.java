package com.example.demo.weekview;

public class WeekViewTableCols {

	private WeekViewContext mon;
	private WeekViewContext tus;
	private WeekViewContext wed;
	private WeekViewContext thu;
	private WeekViewContext fri;
	private WeekViewContext sat;
	private WeekViewContext sun;

	private WeekViewContext total;

	public WeekViewTableCols() {
		super();
		this.mon = new WeekViewContext();
		this.tus = new WeekViewContext();
		this.wed = new WeekViewContext();
		this.thu = new WeekViewContext();
		this.fri = new WeekViewContext();
		this.sat = new WeekViewContext();
		this.sun = new WeekViewContext();
		this.total = new WeekViewContext();
	}

	public WeekViewContext getMon() {
		return mon;
	}

	public void setMon(WeekViewContext mon) {
		this.mon = mon;
	}

	public WeekViewContext getTus() {
		return tus;
	}

	public void setTus(WeekViewContext tus) {
		this.tus = tus;
	}

	public WeekViewContext getWed() {
		return wed;
	}

	public void setWed(WeekViewContext wed) {
		this.wed = wed;
	}

	public WeekViewContext getThu() {
		return thu;
	}

	public void setThu(WeekViewContext thu) {
		this.thu = thu;
	}

	public WeekViewContext getFri() {
		return fri;
	}

	public void setFri(WeekViewContext fri) {
		this.fri = fri;
	}

	public WeekViewContext getSat() {
		return sat;
	}

	public void setSat(WeekViewContext sat) {
		this.sat = sat;
	}

	public WeekViewContext getSun() {
		return sun;
	}

	public void setSun(WeekViewContext sun) {
		this.sun = sun;
	}

	public WeekViewContext getTotal() {
		return total;
	}

	public void setTotal(WeekViewContext total) {
		this.total = total;
	}

}
