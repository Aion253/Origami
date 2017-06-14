package net.aionstudios.origami.modules.stocks;

public class Stock { 
	
	String symbol;
	double price;
	int volume;
	String name;
	String currency;
	double change;
	String percentChange;
	String totalValue;
	
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

	public String getSymbol() {
		return symbol;
	}

	public double getPrice() {
		return price;
	}

	public int getVolume() {
		return volume;
	}

	public String getName() {
		return name;
	}

	public String getCurrency() {
		return currency;
	}

	public double getChange() {
		return change;
	}

	public String getPercentChange() {
		return percentChange;
	}

	public String getTotalValue() {
		return totalValue;
	}
	
}