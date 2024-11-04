package de.htwg.logger;

import org.tinylog.Logger;

public class App {
	

	public static void main(String[] args) throws Exception {
		System.out.println("Hello GIB");
		Logger.info("Eine Info");
		Logger.debug("Debug Modus");
		Logger.warn("Eine Warnung");
	}

}
