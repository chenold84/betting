package com.tcorp.betting.model;

public class BetsPerHour {
	private Long noOfbets;
	private int hourOfDay;
	
	public BetsPerHour(){
		
	}
	
	public BetsPerHour(Long noOfbets, int hourOfDay) {
		this.noOfbets = noOfbets;
		this.hourOfDay = hourOfDay;
	}

	public Long getNoOfbets() {
		return noOfbets;
	}

	public void setNoOfbets(Long noOfbets) {
		this.noOfbets = noOfbets;
	}

	public int getHourOfDay() {
		return hourOfDay;
	}

	public void setHourOfDay(int hourOfDay) {
		this.hourOfDay = hourOfDay;
	}
}
