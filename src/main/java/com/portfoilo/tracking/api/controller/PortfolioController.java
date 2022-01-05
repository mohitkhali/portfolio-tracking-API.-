package com.portfoilo.tracking.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfoilo.tracking.api.entity.Trade;
import com.portfoilo.tracking.api.repository.TradeRepository;
import com.portfoilo.tracking.api.service.TradeService;

@RestController
@RequestMapping("/api/trades")
public class PortfolioController {
	@Autowired
	TradeRepository tradeRepository;
	
	private TradeService tradeService;

	public PortfolioController(TradeService tradeService) {
		super();
		this.tradeService = tradeService;
	}
	
	
//	adding trade
@PostMapping("/add")
public ResponseEntity<Trade> saveTrade(@RequestBody Trade trade){
	return new ResponseEntity<Trade>(tradeService.addTrade(trade), HttpStatus.CREATED);
}

//fetching holdings
@GetMapping
public List<Trade> FetchingHoldings(){
	return tradeService.fetchHoldings();
}

//updating trade 
//http://localhost:8085/api/trades/1 where 1 is id of trade 
@PutMapping("/update/{id}")
public ResponseEntity<Trade> updateTrade(@PathVariable("id") long id
		,@RequestBody Trade trade
		){
	
	return new ResponseEntity<Trade>(tradeService.updateTrade(trade, id), HttpStatus.OK);
}





//removing trade from Portfolio
//http://localhost:8085/api/trades/delete/1 where 1 is id of trade 

@DeleteMapping("/delete/{id}")
public ResponseEntity<String> removeTrade(
		@PathVariable("id") long id
		){
//	removing trade from database
	tradeService.removeTrade(id);
	return new ResponseEntity<String>("Trade removed ",HttpStatus.OK);
}



//fetching portfolio
//http://localhost:8085/api/trades/get/1
@GetMapping("/get/{id}")
public ResponseEntity<Trade> fetchportfolio(@PathVariable("id") long tradeid){
	
return 	new ResponseEntity<Trade>(tradeService.getPortfolio(tradeid),HttpStatus.OK);
}



//fetching returns 
//http://localhost:8085/api/trades/returns


@GetMapping("/returns")
public ResponseEntity<Float>  getreturns(){
	return new ResponseEntity<Float>(tradeService.getreturns(),HttpStatus.OK);
}



}
