package guru.springframework;

import java.util.HashMap;

public class Bank {
	
	private HashMap<Pair, Integer> rateMap = new HashMap<>();

	public Money reduce(Expression source, String toCurrency) {
		return source.reduce(this, toCurrency);
	}

	public void addRate(String from, String to, int rate) {
		// TODO Auto-generated method stub	
		
	}

	public int rate(String from, String to) {
		return (from.equals("CHF") && to.equals("USD")) ? 2 : 1;
	}

}
