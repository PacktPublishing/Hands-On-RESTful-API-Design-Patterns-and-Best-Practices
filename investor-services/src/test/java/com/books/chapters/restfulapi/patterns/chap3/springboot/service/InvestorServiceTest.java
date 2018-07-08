package com.books.chapters.restfulapi.patterns.chap3.springboot.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import com.books.chapters.restfulapi.patterns.chap3.springboot.models.Investor;
import com.books.chapters.restfulapi.patterns.chap3.springboot.models.Stock;
import com.books.chapters.restfulapi.patterns.chap3.springboot.service.InvestorService;

import junit.framework.TestCase;

public class InvestorServiceTest extends TestCase {

	InvestorService investorService = new InvestorService();
	ArrayList<Stock> stocksLotOne = new ArrayList<>();
	ArrayList<Stock> stocksLotTwo = new ArrayList<>();

	@Override
	protected void setUp() throws Exception {
		Stock stocksSampleOne = new Stock("EXA", 200, 20);
		Stock stocksSampleTwo = new Stock("EXB", 100, 60);

		stocksLotOne.add(stocksSampleTwo);
		stocksLotOne.add(stocksSampleOne);

		Stock stocksSampleThree = new Stock("EXC", 300, 200);
		Stock stocksSampleFour = new Stock("EXD", 150, 40);

		stocksLotTwo.add(stocksSampleThree);
		stocksLotTwo.add(stocksSampleFour);
	}

	@Test
	public void testFetchAllInvestors() {
		int expectedSize = 2;
		int actualListSize = investorService.fetchAllInvestors().size();
		assertEquals(expectedSize, actualListSize);
	}

	@Test
	public void testFetchInvestorById() {
		Investor actualInvestor = investorService.fetchInvestorById("invr_1");
		Investor expectedInvestor = new Investor("INVR_1", "Investor ONE", "conservative investor", stocksLotOne);
		assertEquals(actualInvestor.getId(), expectedInvestor.getId());
		actualInvestor = investorService.fetchInvestorById("invr_2");
		expectedInvestor = new Investor("INVR_2", "Investor TWO", "Moderate Risk investor", stocksLotTwo);
		assertEquals(expectedInvestor.getId(), actualInvestor.getId());

	}

	@Test
	public void testFetcStocksByInvestorId() {
		Investor actualInvestor = investorService.fetchInvestorById("invr_1");
		Investor expectedInvestor = new Investor("INVR_1", "Investor ONE", "conservative investor", stocksLotOne);
		List<Stock> actualStocks = (actualInvestor.getStocks()).stream().sorted(Comparator.comparing(Stock::getSymbol))
				.collect(Collectors.toList());
		List<Stock> expectedStocks = (expectedInvestor.getStocks()).stream()
				.sorted(Comparator.comparing(Stock::getSymbol)).collect(Collectors.toList());
		assertEquals(expectedStocks.get(0).getSymbol(), actualStocks.get(0).getSymbol());
	}
}
