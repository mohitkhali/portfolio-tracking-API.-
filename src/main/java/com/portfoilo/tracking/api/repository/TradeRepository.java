package com.portfoilo.tracking.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfoilo.tracking.api.entity.Trade;

public interface TradeRepository extends JpaRepository<Trade, Long>{

	Trade findByticker(String ticker);
}
