package com.tcorp.betting.service;

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
import com.tcorp.betting.repository.BetRepository;


public class BettingServiceImplTest {

	@Mock
	BetRepository betRepo;
	
	BettingService bettingService;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		bettingService = new BettingServiceImpl(betRepo);
	}

	@Test
	public void testFindAll() {
		List<Bet> bets = new ArrayList<>();
		bets.add(new Bet());
		
		when(betRepo.findAll()).thenReturn(bets);
		
		assertEquals(bettingService.findAll().size(), 1);
	}

	@Test
	public void testSave() {
		Bet bet = new Bet(LocalDateTime.now().plusSeconds(5), BetType.WIN, new Integer(1000), 
				new Integer(20000), new BigDecimal(100));
		bet.setId(1L);
		
		when(betRepo.save(bet)).thenReturn(bet);
		
		assertEquals(bettingService.save(bet).getId().intValue(), 1);
	}

	@Test
	public void testGetInvPerBetType() {
		List<InvPerBetType> result = new ArrayList<>();
		result.add(new InvPerBetType(BetType.WIN, new BigDecimal(10)));
		
		when(betRepo.getInvPerBetType()).thenReturn(result);
		
		assertEquals(bettingService.getInvPerBetType().size(), 1);
	}

	@Test
	public void testGetInvPerCustomer() {
		List<InvPerCustomerId> result = new ArrayList<>();
		result.add(new InvPerCustomerId(new BigDecimal(10), 2000));
		
		when(betRepo.getInvPerCustomerId()).thenReturn(result);
		
		assertEquals(bettingService.getInvPerCustomer().size(), 1);
	}

	@Test
	public void testGetBetsPerBetType() {
		List<BetsPerBetType> result = new ArrayList<>();
		result.add(new BetsPerBetType(BetType.WIN, 10l));
		
		when(betRepo.getBetsPerBetType()).thenReturn(result);
		
		assertEquals(bettingService.getBetsPerBetType().size(), 1);
	}

	@Test
	public void testGetBetsPerHour() {
		List<BetsPerHour> result = new ArrayList<>();
		result.add(new BetsPerHour(10l, 20));
		
		when(betRepo.getBetsPerHour()).thenReturn(result);
		
		assertEquals(bettingService.getBetsPerHour().size(), 1);
	}

}
