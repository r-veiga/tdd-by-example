package guru.springframework;

public class Money implements Expression {

	protected int amount; 
	protected String currency;
	
	public Money(int amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}

	public static Money dollar(int amount) {
		return new Money(amount, "USD");
	}
	
	public static Money franc(int amount) {
		return new Money(amount, "CHF");
	}
	
	public Money times(int multiplier) {
		return new Money(amount * multiplier, currency);
	}
	
	public Expression plus(Money addend) {
		return new Sum(this, addend);
	}

	@Override
	public Money reduce(Bank bank, String toCurrency) {
		int rate = (currency.equals("CHF") && toCurrency.equals("USD")) ? 2 : 1;
		return new Money(this.amount/rate, toCurrency);
	}	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		Money other = (Money) obj;
		if (amount != other.amount || !currency.equals(other.currency))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Money [amount=" + amount + ", currency=" + currency + "]";
	}

}
