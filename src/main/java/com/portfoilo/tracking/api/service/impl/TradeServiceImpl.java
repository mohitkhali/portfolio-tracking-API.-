package com.portfoilo.tracking.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.portfoilo.tracking.api.entity.Trade;
import com.portfoilo.tracking.api.exception.ResourceNotFoundException;
import com.portfoilo.tracking.api.repository.TradeRepository;
import com.portfoilo.tracking.api.service.TradeService;


@Service
public class TradeServiceImpl implements TradeService{

	private TradeRepository tradeRepository;
	public TradeServiceImpl(TradeRepository tradeRepository) {
		super();
		this.tradeRepository = tradeRepository;
	}

	@Override
	public Trade addTrade(Trade trade) {
		return tradeRepository.save(trade);
	}

	@Override
	public List<Trade> fetchHoldings() {
		return tradeRepository.findAll();
	}

	@Override
	public Trade updateTrade(Trade trade, long id) {
//	checking trade exist or not
		Trade existingTrade= tradeRepository.findById(id).orElseThrow(
				
				()-> new ResourceNotFoundException("trade", "id", id)
				);
		
		existingTrade.setTicker(trade.getTicker());
		existingTrade.setAvg(trade.getAvg());
		existingTrade.setShares(trade.getShares());
//		saving existingTrade to update them
		tradeRepository.save(existingTrade);
		return existingTrade;
	}

	
//	removing trade method
	@Override
	public Trade removeTrade(long id) {
		
//		checking whether trade is present in database or not
tradeRepository.findById(id).orElseThrow(
				
				()-> new ResourceNotFoundException("trade", "id", id)
				);
		tradeRepository.deleteById(id);
		return null;
	}
//	fetching portfolio
	@Override
	public Trade getPortfolio(long id) {	
		return tradeRepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("trade", "id", id)
				
				);
	}

	
	
//	fetching returns from portfolio	
	@Override
	public Float getreturns() {
		int currentPrice=100;
		List<Trade> trades = tradeRepository.findAll();
		int  size=trades.size();
		Float sum= (float) 0;
		int i=0;
		while( i<size) {
			System.out.println(sum);
			sum= sum+(float) ( (currentPrice-trades.get(i).getAvg())*trades.get(i).getShares());
			System.out.println(sum);
			i++;
		}
		return sum;
	}




	

	


	
}
