package guru.springframework;

import java.util.HashMap;

public class Bank {
	
	private HashMap<Pair, Integer> rateMap = new HashMap<>();

	public Money reduce(Expression source, String toCurrency) {
		return source.reduce(this, toCurrency);
	}

	public void addRate(String from, String to, int rate) {
		rateMap.put(new Pair(from, to), rate);		
	}

	public int rate(String from, String to) {
		Integer rate;
		if(from.equals(to)) {
			rate = 1;
		}
		else {
			rate = rateMap.get(new Pair(from,to));
		}
		return rate;
	}

}
