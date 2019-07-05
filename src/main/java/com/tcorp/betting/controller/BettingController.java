package com.tcorp.betting.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcorp.betting.model.Bet;
import com.tcorp.betting.model.BetsPerBetType;
import com.tcorp.betting.model.BetsPerHour;
import com.tcorp.betting.model.InvPerBetType;
import com.tcorp.betting.model.InvPerCustomerId;
import com.tcorp.betting.service.BettingService;

@RestController
@RequestMapping("/api")
public class BettingController {
	
	private BettingService bettingService;
	
	@Autowired
	public BettingController(BettingService bettingService) {
		this.bettingService = bettingService;
	}


	@GetMapping("/bets")
	public List<Bet> getBets(){
		return bettingService.findAll();
	}
	
	@PostMapping("/bets")
	public Bet save(@Valid @RequestBody Bet bet) {
		bet.setId(0L);
		return bettingService.save(bet);
	}
	
	@GetMapping("/report/investment/type")
	public List<InvPerBetType> getInvPerBetType(){
		return bettingService.getInvPerBetType();
	}
	
	@GetMapping("/report/investment/customer")
	public List<InvPerCustomerId> getInvPerCustomer(){
		return bettingService.getInvPerCustomer();
	}
	
	@GetMapping("/report/bets/hourly")
	public List<BetsPerHour> getBetsPerHour(){
		return bettingService.getBetsPerHour();
	}
	
	@GetMapping("/report/bets/type")
	public List<BetsPerBetType> getBetsPerBetType(){
		return bettingService.getBetsPerBetType();
	}
}