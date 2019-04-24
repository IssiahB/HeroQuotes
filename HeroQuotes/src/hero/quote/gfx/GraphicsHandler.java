package hero.quote.gfx;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import hero.quote.util.Quote;
import hero.quote.util.QuoteHandling;

public class GraphicsHandler {
	
	private JFrame frame;
	private JPanel panel;
	public static Dimension screenSize = new Dimension(700, 500);
	
	private static JLabel superHeroName;
	private static JTextArea quoteArea;
	private JButton getQuoteButton;
	
	public GraphicsHandler(String title) {
		frame = new JFrame(title);
		panel = new JPanel(null);
		panel.setBackground(ProjectColors.PrimaryColor);
		panel.setPreferredSize(screenSize);
		panel.setMaximumSize(screenSize);
		panel.setMinimumSize(screenSize);
		addComponents();
		
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	private void addComponents() {
		getQuoteButton = new JButton("Get Quote");
		getQuoteButton.setBackground(ProjectColors.FinalColor);
		getQuoteButton.setForeground(Color.WHITE);
		getQuoteButton.setBounds((screenSize.width/2) - 50, (screenSize.height - 100), 100, 40);
		getQuoteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				QuoteHandling.generateRandomQuote();
			}
		});
		
		quoteArea = new JTextArea("\"No Quote Here\"");
		quoteArea.setEditable(false);
		quoteArea.setLineWrap(true);
		quoteArea.setWrapStyleWord(true);
		quoteArea.setFont(new Font("Arial Black", 2, 20));
		quoteArea.setBackground(ProjectColors.SecondaryColor);
		quoteArea.setForeground(ProjectColors.FinalColor);
		quoteArea.setBounds((screenSize.width/2) - 200, (screenSize.height/2) - 100, 400, 200);
		quoteArea.setBorder(BorderFactory.createLineBorder(ProjectColors.FinalColor));
		
		superHeroName = new JLabel("Not A Superhero Name");
		superHeroName.setFont(new Font(null, 2, 20));
		superHeroName.setBounds(100, 100, 500, 50);
		superHeroName.setForeground(ProjectColors.FinalColor);
		
		panel.add(superHeroName);
		panel.add(quoteArea);
		panel.add(getQuoteButton);
	}
	
	public static void displayQuote(Quote quote) {
		quoteArea.setText(quote.getQuote());
		superHeroName.setText(quote.getFirstName()+" "+quote.getLastName());
	}
	
}
