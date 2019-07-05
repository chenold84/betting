package com.tcorp.betting.bootstrap;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.tcorp.betting.model.Bet;
import com.tcorp.betting.model.BetType;
import com.tcorp.betting.repository.BetRepository;

@Component
public class Bootstrap implements CommandLineRunner{

	private BetRepository betRepo;
	
	public Bootstrap(BetRepository betRepo) {
		this.betRepo = betRepo;
	}

	@Override
	public void run(String... args) throws Exception {
		List <Bet> bets = new ArrayList<Bet>();
		int i = 0;
		
		for(BetType b : BetType.values()) {
			bets.add(new Bet(LocalDateTime.now().plusSeconds(5), b, new Integer(1000 + i), 
					new Integer(20000 + i), new BigDecimal(100 + i)));
			i++;
		}
		betRepo.saveAll(bets);
	}

}
