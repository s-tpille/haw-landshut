package account;

/* (C) 2013, Gudrun Schiedermeier, gschied@haw-landshut.de
 * Oracle Corporation Java 1.7.0, Linux i386 2.6.32.58
 * bach (Intel Core2 Duo CPU T9600/2793 MHz, 2 Cores, 8192 MB RAM)
 */
/**
 * Abheber der russischen Mafia.
 * 
 * @author Gudrun Schiedermeier, gschied@haw-landshut.de
 * @version 2013-03-29
 */
public class RussianLoopWithdrawer extends Thread {
	/** Konto, von dem abgehoben wird. */
	private final Account account;

	/**
	 * Erzeugt einen Abheber.
	 * 
	 * @param account
	 *            Konto, von dem abgehoben wird.
	 */
	public RussianLoopWithdrawer(final Account account) {
		this.account = account;
	}

	/**
	 * Versucht fortlaufend, Betraege 1, 2, 3, ..., MAX, 1, 2, 3, ... abzuheben.
	 * Greift ohne Synchronisation auf das Konto zu! Stoppt, wenn ein Interrupt
	 * eintrifft.
	 */
	@Override
	public void run() {
		int amount = 1;

		while (!isInterrupted()) {
			if (amount > Account.MAX_AMOUNT)
				amount = 1;
			// synchronized(account) {
			account.withdraw(amount);
			// }
			amount++;
		}

	}

}
