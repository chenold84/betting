package com.tcorp.betting.model;

import java.math.BigDecimal;

public class InvPerBetType {
	
	private BigDecimal investmentAmt;
	private BetType betType;
	
	public InvPerBetType() {
		
	}
	
	public InvPerBetType(BetType betType, BigDecimal investmentAmt) {
		this.investmentAmt = investmentAmt;
		this.betType = betType;
	}
	
	public BigDecimal getInvestmentAmt() {
		return investmentAmt;
	}
	public void setInvestmentAmt(BigDecimal investmentAmt) {
		this.investmentAmt = investmentAmt;
	}
	public BetType getBetType() {
		return betType;
	}
	public void setBetType(BetType betType) {
		this.betType = betType;
	}
}
