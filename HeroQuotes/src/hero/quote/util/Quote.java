package hero.quote.util;

import java.util.ArrayList;
import java.util.List;

public class Quote {
	private static List<Quote> quoteList = new ArrayList<Quote>();
	private static int idCounter;
	
	private String firstName, lastName;
	private String quote;
	private final int id;
	
	/**
	 * Adds a quote to quote list
	 * 
	 * @param first -
	 * 			The first name of a hero
	 * 
	 * @param last -
	 * 			The last name of a hero
	 * 
	 * @param quote -
	 * 			THe quote of the hero
	 */
	public Quote(String first, String last, String quote) {
		firstName = first;
		lastName = last;
		this.quote = quote;
		id = idCounter++;
		
		quoteList.add(this);
	}
	
	///////////////////// Non-Static Methods \\\\\\\\\\\\\\\\\\\
	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}
	
	////////////////////// Quote-List Methods \\\\\\\\\\\\\\\\\\\\\
	public static Quote getQuote(int index) {
		Quote quote = quoteList.get(index);
		return quote;
	}
	
	public static Quote[] getAll() {
		Quote[] quotes = new Quote[quoteList.size()];
		quoteList.toArray(quotes);
		return quotes;
	}
	
	public static int getSize() {
		return (quoteList.size());
	}
}
