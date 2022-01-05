package com.portfoilo.tracking.api.service;

import java.util.List;

import com.portfoilo.tracking.api.entity.Trade;

public interface TradeService {

	Trade addTrade(Trade trade);
	List<Trade> fetchHoldings();
	Trade updateTrade(Trade trade,long id);
	Trade removeTrade(long id);
	Trade getPortfolio(long id);
	Float getreturns();
}
