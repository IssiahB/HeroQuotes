package hero.quote.util;

import java.util.Random;

import hero.quote.gfx.GraphicsHandler;

public class QuoteHandling {
	
	public static void generateRandomQuote() {
		Random ran = new Random();
		Quote quote = Quote.getQuote(ran.nextInt(25));
		GraphicsHandler.displayQuote(quote);
	}
	
}
