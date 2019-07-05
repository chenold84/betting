package com.tcorp.betting.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;

@Entity
public class Bet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull(message = "dateTime should be entered")
	@FutureOrPresent(message = "Date & Time should not be from past")
	private LocalDateTime dateTime;
	
	@NotNull(message = "Bet type should be entered")
	@Enumerated(value = EnumType.STRING)
	private BetType betType;
	
	@NotNull(message = "propNumber should be entered")
	private Integer propNumber;
	
	@NotNull(message = "customerId should be entered")
	private Integer customerId;
	
	@NotNull(message = "investmentAmt should be entered")
	@DecimalMax(value = "20000", message = "Investment Amount should be less than 200,000")
	private BigDecimal investmentAmt;
	
	public Bet() {}
	

	public Bet(LocalDateTime dateTime, BetType betType, Integer propNumber, Integer customerId, BigDecimal investmentAmt) {
		this.dateTime = dateTime;
		this.betType = betType;
		this.propNumber = propNumber;
		this.customerId = customerId;
		this.investmentAmt = investmentAmt;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public BetType getBetType() {
		return betType;
	}
	public void setBetType(BetType betType) {
		this.betType = betType;
	}

	public Integer getPropNumber() {
		return propNumber;
	}
	
	public void setPropNumber(Integer propNumber) {
		this.propNumber = propNumber;
	}
	
	public Integer getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	
	public BigDecimal getInvestmentAmt() {
		return investmentAmt;
	}
	
	public void setInvestmentAmt(BigDecimal investmentAmt) {
		this.investmentAmt = investmentAmt;
	}
	
}