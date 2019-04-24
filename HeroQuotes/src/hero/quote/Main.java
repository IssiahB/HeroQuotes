package hero.quote;

import hero.quote.gfx.GraphicsHandler;
import hero.quote.xml.XmlHandler;

public class Main {
	
	public static void main(String[] args) {
		XmlHandler.parseXMLDocument();
		GraphicsHandler gfx = new GraphicsHandler("Superhero Quotes");
	}
}
