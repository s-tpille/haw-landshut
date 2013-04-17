package account;

/* (C) 2013, Gudrun Schiedermeier, gschied@haw-landshut.de
 * Oracle Corporation Java 1.7.0, Linux i386 2.6.32.58
 * bach (Intel Core2 Duo CPU T9600/2793 MHz, 2 Cores, 8192 MB RAM)
 */

/**
 * Version fuer Studentenloesung
 * 
 * @author Gudrun Schiedermeier, gschied@haw-landshut.de
 * @version 2013-03-29
 */
public class Main extends Thread {
	/**
	 * @param args
	 *            Kommandozeilenargumente.
	 */
	public static void main(final String... args) throws InterruptedException {
		final Account account = new SyncedAccount();
		Thread[] threads = new Thread[] { // Ein paar Einzahler und Abheber
											// erzeugen
		new RussianLoopDepositor(account), new RussianLoopWithdrawer(account),
				new RussianLoopWithdrawer(account) };
		for (Thread thread : threads)
			// Alle starten
			thread.start();
		Thread.sleep(1000); // Eine Weile warten ...
		for (Thread thread : threads)
			// Alle unterbrechen
			thread.interrupt();
		for (Thread thread : threads)
			// Warten, bis alle fertig sind
			thread.join();
		System.out.println(account.getBalance()); // Endstand des Kontos
													// ausgeben
	}

}
