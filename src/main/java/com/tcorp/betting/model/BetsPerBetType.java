package com.tcorp.betting.model;

public class BetsPerBetType {
	
	private BetType betType;
	private Long noOfBets;
	
	public BetsPerBetType() {
		
	}
	
	public BetsPerBetType(BetType betType, Long noOfBets) {
		this.betType = betType;
		this.noOfBets = noOfBets;
	}
	
	public BetType getBetType() {
		return betType;
	}
	public void setBetType(BetType betType) {
		this.betType = betType;
	}
	public Long getNoOfBets() {
		return noOfBets;
	}
	public void setNoOfBets(Long noOfBets) {
		this.noOfBets = noOfBets;
	}
}
