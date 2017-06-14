package net.aionstudios.origami.modules.stocks;

/**
 * 
 * A class holding relevant stock information.
 * @author Winter Roberts
 *
 */
public class Stock { 
	
	String symbol;
	double price;
	int volume;
	String name;
	String currency;
	double change;
	String percentChange;
	String totalValue;
	
	/**
	 * Creates a new instance of a stock.
	 * @param sym The stocks' symbol.
	 * @param price The price of a stock.
	 * @param volume The number of stocks circulated today.
	 * @param name The name of the company represented by the symbol.
	 * @param currency The trade currency of the stock.
	 * @param change The currency change from the previous calendar day's closing price.
	 * @param percentChange The percent change from the previous calendar day's closing price.
	 * @param totalValue The total value of all the stocks.
	 */
	public Stock(String sym, double price, int volume, String name, String currency, double change, String percentChange, String totalValue) {
		this.symbol = sym;
		this.price = price;
		this.volume = volume;
		this.name = name;
		this.currency = currency;
		this.change = change;
		this.percentChange = percentChange;
		this.totalValue = totalValue;
	}
	
	/**
	 * @return The stocks' symbol, ex: TSLA.
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * @return The price of a stock, ex: 375.95
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @return The number of stocks circulated today, ex: 11,807,920
	 */
	public int getVolume() {
		return volume;
	}

	/**
	 * @return The name of the company represented by the symbol, ex: Tesla, Inc.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return The stocks' exchange currency base, ex: USD
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * @return The increase from the previous calendar days' closing price, ex: +16.94
	 */
	public double getChange() {
		return change;
	}

	/**
	 * @return The percentage increase from the previous calendar days' closing price, ex: +4.72%
	 */
	public String getPercentChange() {
		return percentChange;
	}

	/**
	 * @return An estimated value of the companies worth in stock equity, ex: $61,753,447,749
	 */
	public String getTotalValue() {
		return totalValue;
	}
	
}