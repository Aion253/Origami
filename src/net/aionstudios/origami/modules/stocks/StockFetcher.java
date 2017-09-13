package net.aionstudios.origami.modules.stocks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 
 * A class for fetching stock information.
 * @author Winter Roberts
 *
 */
public class StockFetcher {  
	
	/**
	* Returns a Stock Object that contains info about a specified stock.
	* @param symbol the company's stock symbol
	* @return a stock object containing info about the company's stock
	 * @throws IOException 
	 * @see Stock
	*/
	public static Stock getStock(String symbol) throws IOException {  
		String sym = symbol.toUpperCase();
		double price = 0.0;
		int volume = 0;
		double change = 0.0;
		String currency = "";
		String totalValue = "";
		String name = "";
		String percentChange = "";
			// Retrieve CSV File
			URL yahoo = new URL("https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.quotes%20where%20symbol%20in%20(%22"+symbol+"%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys&callback=");
			URLConnection connection = yahoo.openConnection();
			InputStreamReader is = new InputStreamReader(connection.getInputStream());
			BufferedReader br = new BufferedReader(is);  
			
			// Parse CSV Into Array
			String line = br.readLine();
			try {
				JSONObject obj = new JSONObject(line);
				JSONObject quote;
				quote = obj.getJSONObject("query").getJSONObject("results").getJSONObject("quote");
			
				if(!quote.isNull("Bid")) {
					// Handle Our Data
					price = parseDouble(quote.getString("Bid"));
					volume = (int) parseDouble(quote.getString("Volume"));
					change = parseDouble(quote.getString("Change"));
					currency = quote.getString("Currency");
					totalValue = quote.getString("MarketCapitalization");
					name = quote.getString("Name");
					percentChange = quote.getString("PercentChange");
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return new Stock(sym, price, volume, name, currency, change, percentChange, totalValue);
		
	}
	
	private static double parseDouble(String s) {
		return Double.parseDouble(s);
	}
	
}
