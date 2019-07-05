package com.tcorp.betting.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tcorp.betting.model.Bet;
import com.tcorp.betting.model.BetsPerBetType;
import com.tcorp.betting.model.BetsPerHour;
import com.tcorp.betting.model.InvPerBetType;
import com.tcorp.betting.model.InvPerCustomerId;
import com.tcorp.betting.repository.BetRepository;

@Service
public class BettingServiceImpl implements BettingService {
	private BetRepository betRepo;

	public BettingServiceImpl(BetRepository betRepo) {
		this.betRepo = betRepo;
	}

	@Override
	public List<Bet> findAll() {
		return betRepo.findAll();
	}

	@Override
	public Bet save(Bet bet) {
		return betRepo.save(bet);
	}

	@Override
	public List<InvPerBetType> getInvPerBetType() {
		return betRepo.getInvPerBetType();
	}

	@Override
	public List<InvPerCustomerId> getInvPerCustomer() {
		return betRepo.getInvPerCustomerId();
	}

	@Override
	public List<BetsPerBetType> getBetsPerBetType() {
		return betRepo.getBetsPerBetType();
	}

	@Override
	public List<BetsPerHour> getBetsPerHour() {
		return betRepo.getBetsPerHour();
	}
	
}
