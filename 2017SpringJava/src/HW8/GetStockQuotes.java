package HW8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetStockQuotes {
	
	public static HashMap<String, Double> getStock() throws Exception {
		URL url = new URL("http://download.finance.yahoo.com/d/quotes.csv?s=MSFT,IBM,"
				+ "AAPL,GOOG,YHOO&f=sl1d1t1c1ohgv&e=.csv");
		URLConnection coon = url.openConnection();
		BufferedReader br  = new BufferedReader(new InputStreamReader(coon.getInputStream()));
		
		String regex = "[A-Z]+";
		String regex2 = "[0-9]+\\.[0-9]+";

		
		HashMap<String, Double> hm = new HashMap<String, Double>();
        String Company;
        double Price;
 		Pattern p = Pattern.compile(regex);
 		Pattern p2 = Pattern.compile(regex2);

		String line; 
		while((line = br.readLine()) != null) {
			Matcher m  = p.matcher(line);
			Matcher m2  = p2.matcher(line);
			while(m.find() && m2.find()) {
				Company = m.group();
				Price = Double.valueOf(m2.group());
				System.out.println(Company + ":" + Price);
				hm.put(Company, Price);
			}
		}
		return hm;
	}
 
	public static void main(String[] args) throws Exception {

		HashMap<String, Double> hm = getStock();
		System.out.println("-----------------");
		System.out.println("The hashmap of Stock is");
	    System.out.println(hm);
		
	}

}
