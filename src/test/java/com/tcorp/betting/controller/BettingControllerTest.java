package com.tcorp.betting.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.tcorp.betting.model.Bet;
import com.tcorp.betting.model.BetType;
import com.tcorp.betting.model.BetsPerBetType;
import com.tcorp.betting.model.BetsPerHour;
import com.tcorp.betting.model.InvPerBetType;
import com.tcorp.betting.model.InvPerCustomerId;
import com.tcorp.betting.service.BettingService;

public class BettingControllerTest {

	BettingController bettingController;
	
	@Mock
	BettingService bettingService;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		bettingController = new BettingController(bettingService);
	}

	@Test
	public void testGetBets() {
		List<Bet> bets = new ArrayList<>();
		bets.add(new Bet());
		
		when(bettingService.findAll()).thenReturn(bets);
		
		assertEquals(bettingController.getBets().size(), 1);
	}

	@Test
	public void testSave() {
		Bet bet = new Bet(LocalDateTime.now().plusSeconds(5), BetType.WIN, new Integer(1000), 
				new Integer(20000), new BigDecimal(100));
		
		when(bettingService.save(bet)).thenReturn(bet);
		
		assertEquals(bettingController.save(bet).getId().intValue(), 0);
		
	}

	@Test
	public void testGetInvPerBetType() {
		List<InvPerBetType> result = new ArrayList<>();
		result.add(new InvPerBetType(BetType.WIN, new BigDecimal(10)));
		
		when(bettingService.getInvPerBetType()).thenReturn(result);
		
		assertEquals(bettingController.getInvPerBetType().size(), 1);
	}

	@Test
	public void testGetInvPerCustomer() {
		List<InvPerCustomerId> result = new ArrayList<>();
		result.add(new InvPerCustomerId(new BigDecimal(10), 2000));
		
		when(bettingService.getInvPerCustomer()).thenReturn(result);
		
		assertEquals(bettingController.getInvPerCustomer().size(), 1);
	}

	@Test
	public void testGetBetsPerHour() {
		List<BetsPerHour> result = new ArrayList<>();
		result.add(new BetsPerHour(10l, 20));
		
		when(bettingService.getBetsPerHour()).thenReturn(result);
		
		assertEquals(bettingController.getBetsPerHour().size(), 1);
	}

	@Test
	public void testGetBetsPerBetType() {
		List<BetsPerBetType> result = new ArrayList<>();
		result.add(new BetsPerBetType(BetType.WIN, 10l));
		
		when(bettingService.getBetsPerBetType()).thenReturn(result);
		
		assertEquals(bettingController.getBetsPerBetType().size(), 1);
	}

}
