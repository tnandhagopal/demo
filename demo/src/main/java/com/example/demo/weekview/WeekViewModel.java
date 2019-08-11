package com.example.demo.weekview;

import java.util.ArrayList;
import java.util.List;

public class WeekViewModel {

	private List<WeekView> weekviewList;

	private WeekViewTableCols weekViewTableCols;

	private String currentWeek;

	public WeekViewModel() {
		this.weekviewList = new ArrayList<WeekView>();
		this.weekViewTableCols = new WeekViewTableCols();
		this.currentWeek = new String();
	}

	public String getCurrentWeek() {
		return currentWeek;
	}

	public void setCurrentWeek(String currentWeek) {
		this.currentWeek = currentWeek;
	}

	public List<WeekView> getWeekviewList() {
		return weekviewList;
	}

	public void setWeekviewList(List<WeekView> weekviewList) {
		this.weekviewList = weekviewList;
	}

	public WeekViewTableCols getWeekViewTableCols() {
		return weekViewTableCols;
	}

	public void setWeekViewTableCols(WeekViewTableCols weekViewTableCols) {
		this.weekViewTableCols = weekViewTableCols;
	}

}
