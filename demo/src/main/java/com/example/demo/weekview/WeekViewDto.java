package com.example.demo.weekview;

import java.util.ArrayList;
import java.util.List;

public class WeekViewDto {
	private List<WeekView> weekviews;

	public WeekViewDto() {
		this.weekviews = new ArrayList<WeekView>();
	}

	public WeekViewDto(List<WeekView> weekviews) {
		super();
		this.weekviews = weekviews;
	}

	public List<WeekView> getWeekviews() {
		return weekviews;
	}

	public void setWeekviews(List<WeekView> weekviews) {
		this.weekviews = weekviews;
	}

	public void addWeekView(WeekView weekview) {
		this.weekviews.add(weekview);
	}

}
