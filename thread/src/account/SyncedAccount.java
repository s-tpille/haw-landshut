package account;

/* (C) 2013, Gudrun Schiedermeier, gschied@haw-landshut.de
 * Oracle Corporation Java 1.7.0, Linux i386 2.6.32.58
 * bach (Intel Core2 Duo CPU T9600/2793 MHz, 2 Cores, 8192 MB RAM)
 */
/**
 * Unsynchronisiertes Konto. Macht Fehler, wenn mehrere Threads gleichzeitig
 * buchen.
 * 
 * @author Gudrun Schiedermeier, gschied@haw-landshut.de
 * @version 2013-03-29
 */
public class SyncedAccount implements Account {
	/** Kontostand. Niemals negativ. */
	private long balance;

	@Override
	public long getBalance() {
		return balance;
	}

	@Override
	synchronized public void deposit(final long amount) {
		System.out.printf("%s: depositing %d",
				Thread.currentThread().getName(), amount);
		balance += amount;
		System.out.printf(", balance %d%n", balance);
	}

	@Override
	synchronized public void withdraw(final long amount) {
		// --- Anfang kritischer Abschnit ---
		if (amount > balance) // Nichts tun, wenn zu wenig Geld auf dem Konto
								// ist
			return;

		// Diese Ausgabe ist noetig, damit der kritische Abschnitt lang genug
		// dauert!
		// Wenn sie fehlt, sind Fehler unwahrscheinlich
		System.out.printf("%s: withdrawing %d", Thread.currentThread()
				.getName(), amount);
		balance -= amount; // Abbuchen
		// --- Ende kritischer Abschnit ---
		if (balance < 0) // Sicherstellen, dass das Konto intakt ist
			throw new AssertionError("broken account: " + balance);
		System.out.printf(", balance %d%n", balance);
	}

}
