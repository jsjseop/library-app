package com.group.libraryapp.dto.calculator.response;

public class DayOfTheWeekResponse {

	private String dayOfTheWeek;

	public DayOfTheWeekResponse(String dayOfTheWeek) {
		this.dayOfTheWeek = dayOfTheWeek.substring(0, 3);
	}

	public String getDayOfTheWeek() {
		return dayOfTheWeek;
	}
}
