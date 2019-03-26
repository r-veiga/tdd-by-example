package guru.springframework;

public class Sum implements Expression {
	
	Money augmend;
	Money addmend;

	public Sum(Money augmend, Money addmend) {
		this.augmend = augmend;
		this.addmend = addmend;
	} 
	
	@Override
	public Money reduce(String toCurrency) {
		int sum = augmend.amount + addmend.amount;
		return new Money(sum, toCurrency);
	}

}
