package Strategy;

public class CreditCardStrategy implements PaymentStrategy
{
	private String name;
	private String cardNumber;
	private String cvv;
	private String dateOfExpiry;

	public CreditCardStrategy(final String name, final String cardNumber, final String cvv, final String dateOfExpiry)
	{
		this.name = name;
		this.cardNumber = cardNumber;
		this.cvv = cvv;
		this.dateOfExpiry = dateOfExpiry;
	}

	@Override
	public void pay(final int amount)
	{
		System.out.println(amount + " paid with credit/debit card.");
	}

	public String getName()
	{
		return name;
	}

	public void setName(final String name)
	{
		this.name = name;
	}

	public String getCardNumber()
	{
		return cardNumber;
	}

	public void setCardNumber(final String cardNumber)
	{
		this.cardNumber = cardNumber;
	}

	public String getCvv()
	{
		return cvv;
	}

	public void setCvv(final String cvv)
	{
		this.cvv = cvv;
	}

	public String getDateOfExpiry()
	{
		return dateOfExpiry;
	}

	public void setDateOfExpiry(final String dateOfExpiry)
	{
		this.dateOfExpiry = dateOfExpiry;
	}
}
