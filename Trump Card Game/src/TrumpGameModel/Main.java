package TrumpGameModel;
import java.awt.BorderLayout;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;

public class Main {

	
	public static void main(String[]args){
		
//		Deck deck = new Deck();
//		deck.populateDeck();
		
		GameGUI gui = new GameGUI();
		gui.init();
		
/*		Deck deck = new Deck();
		
		Player player1 = new Player("Zain",deck);
		Player player2 = new Player("Safder",deck);
		Player player3 = new Player("Hamza",deck);
		Player player4 = new Player("Bilal",deck);

		GameLogic game = new GameLogic((player1),(player2),(player3),(player4),deck);
		game.start(); */
		
/*		JFrame Jframe = new JFrame();
		Jframe.setSize(100,200);
		Jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel contentPane = new JPanel(new BorderLayout());
		
		JLabel cardLabel = new JLabel(new ImageIcon(ImageIO.read(new File("AceofSpades.jpg"))));
		cardLabel.setSize(50,100);
		contentPane.add(cardLabel);
		Jframe.add(contentPane);
		Jframe.pack();
		Jframe.setVisible(true);
*/
	}
}