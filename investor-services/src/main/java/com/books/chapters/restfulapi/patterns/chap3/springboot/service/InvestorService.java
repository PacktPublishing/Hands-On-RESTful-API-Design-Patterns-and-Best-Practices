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

	public Investor fetchInvestorById(String investorId) {
		return investorsList.stream().filter(investors -> investorId.equalsIgnoreCase(investors.getId())).findAny()
				.orElse(null);

	}

	public List<Stock> fetchStocksByInvestorId(String investorId) {
		Investor investor = fetchInvestorById(investorId);
		return investor.getStocks();
	}

	public Stock fetchSingleStockByInvestorIdAndStockSymbol(String investorId, String symbol) {
		Investor investor = fetchInvestorById(investorId);
		return investor.getStocks().stream().filter(stock -> symbol.equalsIgnoreCase(stock.getSymbol())).findAny()
				.orElse(null);
	}

	public Stock addNewStockToTheInvestorPortfolio(String investorId, Stock newStock) {
		if (fetchInvestorById(investorId) != null && isUnique(investorId, newStock)
				&& isNewStockInsertSucess(investorId, newStock)) {
			return fetchSingleStockByInvestorIdAndStockSymbol(investorId, newStock.getSymbol());
		}
		return null;
	}

	private boolean isNewStockInsertSucess(String investorId, Stock newStock) {
		return fetchInvestorById(investorId).getStocks().add(newStock);
	}

	private boolean isUnique(String investorId, Stock newStock) {
		return fetchSingleStockByInvestorIdAndStockSymbol(investorId, newStock.getSymbol()) == null;
	}

	public boolean deleteStockFromTheInvestorPortfolio(String investorId, String stockTobeDeletedSymbol) {
		boolean deletedStatus = false;
		Stock stockTobeDeleted = fetchSingleStockByInvestorIdAndStockSymbol(investorId, stockTobeDeletedSymbol);
		if (stockTobeDeleted != null) {
			Investor investor = fetchInvestorById(investorId);
			deletedStatus = investor.getStocks().remove(stockTobeDeleted);
		}
		return deletedStatus;
	}

	public Stock updateAStockByInvestorIdAndStock(String investorId, Stock stockTobeUpdated) {
		Investor investor = fetchInvestorById(investorId);
		if (investor == null) {
			return null;
		}
		Stock currentStock = fetchSingleStockByInvestorIdAndStockSymbol(investorId, stockTobeUpdated.getSymbol());
		if (currentStock == null) {
			return null;
		}
		currentStock.setNumberOfSharesHeld(stockTobeUpdated.getNumberOfSharesHeld());
		currentStock.setTickerPrice(stockTobeUpdated.getTickerPrice());
		return currentStock;
	}
	
	// slight variance of updateAStockByInvestorIdAndStock for PATCH method
	// please note that spring boot provides annotations based validations for JSON, however this
	// method is not using those annotations for keeping the scope simple for patching examples
	public Stock updateAStockByInvestorIdAndStock(String investorId, String symbol, Stock stockTobeUpdated) {
		Investor investor = fetchInvestorById(investorId);
		if (investor == null) {
			return null;
		}
		Stock currentStock = fetchSingleStockByInvestorIdAndStockSymbol(investorId, symbol);
		if (currentStock == null) {
			return null;
		}
		if(stockTobeUpdated.getNumberOfSharesHeld() > 0 ){
			currentStock.setNumberOfSharesHeld(stockTobeUpdated.getNumberOfSharesHeld());
		}
		if(stockTobeUpdated.getTickerPrice() > 0 ){
			currentStock.setTickerPrice(stockTobeUpdated.getTickerPrice());
		}
		return currentStock;
	}

}