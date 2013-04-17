package account;

/* (C) 2013, Gudrun Schiedermeier, gschied@haw-landshut.de
 * Oracle Corporation Java 1.7.0, Linux i386 2.6.32.58
 * bach (Intel Core2 Duo CPU T9600/2793 MHz, 2 Cores, 8192 MB RAM)
 */
/**
 * Methoden von Account-Klassen.
 * 
 * @author Gudrun Schiedermeier, gschied@haw-landshut.de
 * @version 2013-03-29
 */
public interface Account {
	/**
	 * Maximaler Betrag, der eingezahlt oder abgehoben wird. Limit, ueber dem
	 * nichts mehr eingezahlt wird.
	 */
	int MAX_AMOUNT = 1000;

	/**
	 * Betrag einzahlen.
	 * 
	 * @param amount
	 *            Betrag, der eingezahlt wird. Nicht negativ.
	 */
	void deposit(long amount);

	/**
	 * Auskunft ueber Kontostand.
	 * 
	 * @return Kontostand. Niemals negativ.
	 */
	long getBalance();

	/**
	 * Betrag abheben..
	 * 
	 * @param amount
	 *            Betrag, der abgehoben wird. Nicht negativ. Wenn das Konto zu
	 *            wenig Geld hat, geschieht nichts.
	 */
	void withdraw(long amount);

}
