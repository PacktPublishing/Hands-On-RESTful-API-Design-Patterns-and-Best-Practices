package com.books.chapters.restfulapi.patterns.chap3.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.books.chapters.restfulapi.patterns.chap3.springboot.models.Investor;
import com.books.chapters.restfulapi.patterns.chap3.springboot.models.Stock;

@Component
public class InvestorService {

	private static List<Investor> investorsList = new ArrayList<>();

	static {
		// create some data

		Stock stocksSampleOne = new Stock("EXA", 200, 20);
		Stock stocksSampleTwo = new Stock("EXB", 100, 60);

		Stock stocksSampleThree = new Stock("EXC", 300, 200);
		Stock stocksSampleFour = new Stock("EXD", 150, 40);

		ArrayList<Stock> stocksLotOne = new ArrayList<>();
		stocksLotOne.add(stocksSampleOne);
		stocksLotOne.add(stocksSampleTwo);
		ArrayList<Stock> stocksLotTwo = new ArrayList<>();
		stocksLotTwo.add(stocksSampleThree);
		stocksLotTwo.add(stocksSampleFour);

		Investor investorOne = new Investor("INVR_1", "Investor ONE", "conservative investor", stocksLotOne);
		Investor investorTwo = new Investor("INVR_2", "Investor TWO", "Moderate Risk investor", stocksLotTwo);

		investorsList.add(investorOne);
		investorsList.add(investorTwo);
	}

	public List<Investor> fetchAllInvestors() {
		return investorsList;
	}

	public Investor fetchInvestorById(String investortId) {
		return investorsList.stream().filter(investors -> investortId.equalsIgnoreCase(investors.getId())).findAny()
				.orElse(null);

	}

	public List<Stock> fetcStocksByInvestorId(String investortId) {
		Investor investor = fetchInvestorById(investortId);
		return investor.getStocks();
	}

}