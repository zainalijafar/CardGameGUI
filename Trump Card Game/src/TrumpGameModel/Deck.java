package TrumpGameModel;
import java.util.*;

import javax.swing.ImageIcon;
public class Deck {

	private List<Card> deck; 
	
	public Deck() {
		this.deck = new ArrayList<>();
	}
	
	public void addCardToDeck(Card card) {
		
		this.deck.add(card);
	}
	
	public Card getCard(int i) {
		
		return this.deck.get(i);
	}
	
	public void removeCard(int i) {
		
		this.deck.remove(i);
	}
	
	public List<Card> getDeck(){
		
		return this.deck;
	}
	
	public void populateDeck() {
		
		int index = 52;
		for(int i=2; i<=14; i++) {
			for (int j=0; j<4; j++) {
				Card card = new Card(i,Suit.values()[j],new ImageIcon("pictures/" + index + ".png").getImage());
				this.deck.add(card);
				index--;
			}
		}
	}
	
	public void shuffleDeck(boolean shuffle) {
		
		if(shuffle==true) {
			
			for(int i=0; i<this.deck.size(); i++) {
				
				Random rand = new Random();
				int rando = rand.nextInt(this.deck.size());
				Collections.swap(this.deck,i,rando);
			}
		}
	}
}