import com.jurik99.Bank;
import com.jurik99.TransferRunnable;

public class SyncBankTest
{
	private static final int AMOUNT_OF_ACCOUNTS = 100;
	private static final double INITIAL_BALANCE = 1000;

	public static void main(final String[] args)
	{
		final Bank bank = new Bank(AMOUNT_OF_ACCOUNTS, INITIAL_BALANCE);

		for (int i = 0; i < AMOUNT_OF_ACCOUNTS; i++)
		{
			final TransferRunnable transferRunnable = new TransferRunnable(bank, i, INITIAL_BALANCE);
			final Thread thread = new Thread(transferRunnable);
			thread.start();
		}
	}
}
