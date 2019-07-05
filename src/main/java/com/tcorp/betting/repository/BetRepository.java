package com.tcorp.betting.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tcorp.betting.model.Bet;
import com.tcorp.betting.model.BetsPerBetType;
import com.tcorp.betting.model.BetsPerHour;
import com.tcorp.betting.model.InvPerBetType;
import com.tcorp.betting.model.InvPerCustomerId;

@Repository
public interface BetRepository extends JpaRepository<Bet, Long> {

	@Query("SELECT new com.tcorp.betting.model.InvPerBetType(betType, sum(investmentAmt)) FROM Bet GROUP BY betType")
	List <InvPerBetType> getInvPerBetType();

	@Query("SELECT new com.tcorp.betting.model.InvPerCustomerId(sum(investmentAmt), customerId) FROM Bet GROUP BY customerId")
	List <InvPerCustomerId> getInvPerCustomerId();

	@Query("SELECT new com.tcorp.betting.model.BetsPerHour(count(*),hour(dateTime)) FROM Bet GROUP BY hour(dateTime)")
	List <BetsPerHour> getBetsPerHour();
	
	@Query("SELECT new com.tcorp.betting.model.BetsPerBetType(betType, count(*)) FROM Bet GROUP BY betType")
	List <BetsPerBetType> getBetsPerBetType();
}
