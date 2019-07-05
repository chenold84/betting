package com.tcorp.betting.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tcorp.betting.bootstrap.Bootstrap;
import com.tcorp.betting.model.Bet;
import com.tcorp.betting.model.BetType;
import com.tcorp.betting.repository.BetRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BettingServiceIT {
	
	@Autowired
	BetRepository betRepo;
	
	BettingService bettingService;

	@Before
	public void setUp() throws Exception {
		Bootstrap bootstrap = new Bootstrap(betRepo);
		bootstrap.run();
		
		bettingService = new BettingServiceImpl(betRepo);
	}

	@Test
	public void testFindAll() {
		assertEquals(bettingService.findAll().size(), 5);
	}

	@Test
	public void testSave() {
		Bet newBet = new Bet(LocalDateTime.now().plusSeconds(5), BetType.WIN, new Integer(1000), 
				new Integer(20000), new BigDecimal(100));
		Bet result = bettingService.save(newBet);
		
		assertTrue("ID returned is not 6", result.getId().longValue() == 6l);
	}

	@Test
	public void testGetInvPerBetType() {
		assertTrue("Investment per bet type is empty!", bettingService.getInvPerBetType().size() > 0);
	}

	@Test
	public void testGetInvPerCustomer() {
		assertTrue("Investment per customer is empty!", bettingService.getInvPerBetType().size() > 0);
	}

	@Test
	public void testGetBetsPerBetType() {
		assertTrue("Bets per bet type is empty!", bettingService.getBetsPerBetType().size() > 0);
	}

	@Test
	public void testGetBetsPerHour() {
		assertTrue("Bets per hour of the day is empty!", bettingService.getBetsPerHour().size() > 0);
	}
}
