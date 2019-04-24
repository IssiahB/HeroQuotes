package hero.quote.xml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import hero.quote.util.Quote;

public class XmlHandler {
	
	/**
	 * Only parses the specific xml document used
	 * for this project
	 */
	public static void parseXMLDocument() {
		// Gets everything ready to build/parse a document
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		Document doc = null;
		
		try {
			// Inputs which document to parse
			builder = factory.newDocumentBuilder();
			doc = builder.parse("res/HeroQuotes.xml");
			
			// Gets all the hero elements into an array
			NodeList heroList = doc.getElementsByTagName("hero");
			Element[] heroArray = getElementsInNodeList(heroList);
			
			// Loop threw the elements of hero and get all the needed data
			for (int i = 0; i < heroArray.length; i++) {
				Element hero = heroArray[i];
				String id = hero.getAttribute("id");
				
				NodeList childrenList = hero.getChildNodes();
				Element[] childrensArray = getElementsInNodeList(childrenList);
				
				String last = "";
				String first = "";
				String quote = "";
				for (int j = 0; j < childrensArray.length; j++) {
					Element child = childrensArray[j];
					switch (child.getTagName()) {
					case "lastname": last = child.getTextContent(); break;
					case "firstname": first = child.getTextContent(); break;
					case "quote": quote = child.getTextContent(); break;
					default:
					}
				}
				// Create a quote with the data from the xml document
				new Quote(first, last, quote);
			}
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets all the elements in a <code>NodeList</code>
	 * 
	 * @param list -
	 * 			The <code>NodeList</code> to get the elements from
	 * 
	 * @return all the elements in the <code>NodeList</code> 
	 * as a element array
	 */
	private static Element[] getElementsInNodeList(NodeList list) {
		List<Element> items = new ArrayList<Element>();
		for (int i = 0; i < list.getLength(); i++) {
			// Gets a node from the list of nodes
			Node listItem = list.item(i);
			// if node is an element add it to element list
			if (listItem.getNodeType() == Node.ELEMENT_NODE) {
				items.add((Element) listItem);
			}
		}
		
		// turn element list to an array
		Element[] finalItems = new Element[items.size()];
		items.toArray(finalItems);
		return finalItems;
	}
}
