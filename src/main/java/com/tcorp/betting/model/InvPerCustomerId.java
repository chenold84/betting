package com.tcorp.betting.model;

import java.math.BigDecimal;

public class InvPerCustomerId {
	private BigDecimal investment;
	private Integer customerId;
	
	public InvPerCustomerId() {
		
	}
	
	public InvPerCustomerId(BigDecimal investment, Integer customerId) {
		this.investment = investment;
		this.customerId = customerId;
	}
	
	public BigDecimal getInvestment() {
		return investment;
	}
	public void setInvestment(BigDecimal investment) {
		this.investment = investment;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

}
