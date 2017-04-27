package Strategy;

public class Item
{
	private String upcCode;
	private int price;

	public Item(final String upcCode, final int price)
	{
		this.upcCode = upcCode;
		this.price = price;
	}

	public String getUpcCode()
	{
		return upcCode;
	}

	public int getPrice()
	{
		return price;
	}
}
