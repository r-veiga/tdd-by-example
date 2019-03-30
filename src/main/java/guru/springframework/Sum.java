package guru.springframework;

public class Sum implements Expression {
	
	Expression sumando1;
	Expression sumando2;

	public Sum(Expression sumando1, Expression sumando2) {
		this.sumando1 = sumando1;
		this.sumando2 = sumando2;
	} 
	
	@Override
	public Money reduce(Bank bank, String toCurrency) {
		int totalAmount = sumando1.reduce(bank, toCurrency).amount + sumando2.reduce(bank, toCurrency).amount; 
		return new Money(totalAmount, toCurrency);
	}

	@Override
	public Expression plus(Expression sumando2) {
		return new Sum(this, sumando2);
	}
	
	@Override
	public Expression times(int multiplier) {
		return new Sum( sumando1.times(multiplier), sumando2.times(multiplier));
	}
}
