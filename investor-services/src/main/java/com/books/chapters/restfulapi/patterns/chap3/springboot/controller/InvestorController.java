package com.books.chapters.restfulapi.patterns.chap3.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.books.chapters.restfulapi.patterns.chap3.springboot.models.Investor;
import com.books.chapters.restfulapi.patterns.chap3.springboot.models.Stock;
import com.books.chapters.restfulapi.patterns.chap3.springboot.service.InvestorService;

@RestController
public class InvestorController {

	@Autowired
	private InvestorService investorService;

	@GetMapping("/investors")
	public List<Investor> fetchAllInvestors() {
		return investorService.fetchAllInvestors();
	}

	@GetMapping("/investors/{investortId}")
	public Investor fetchInvestorById(@PathVariable String investortId) {
		return investorService.fetchInvestorById(investortId);
	}

	@GetMapping("/investors/{investortId}/stocks")
	public List<Stock> fetcStocksByInvestorId(@PathVariable String investortId) {
		return investorService.fetcStocksByInvestorId(investortId);
	}
}
