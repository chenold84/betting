package com.tcorp.betting.service;

import java.util.List;

import com.tcorp.betting.model.Bet;
import com.tcorp.betting.model.BetsPerBetType;
import com.tcorp.betting.model.BetsPerHour;
import com.tcorp.betting.model.InvPerBetType;
import com.tcorp.betting.model.InvPerCustomerId;

public interface BettingService {
	
	public List<Bet> findAll();
	public Bet save(Bet bet);
	public List<InvPerBetType> getInvPerBetType();
	public List<InvPerCustomerId> getInvPerCustomer();
	public List<BetsPerBetType> getBetsPerBetType();
	public List<BetsPerHour> getBetsPerHour();

}