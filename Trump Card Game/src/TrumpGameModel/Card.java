package TrumpGameModel;

import java.awt.Image;

public class Card {

	private String stringVal; 
	private Suit suit; 
	private int value;
	private Image image; 
	
	public Card(int value,Suit suit,Image image) {
		
		this.value = value;
		
		if(value==11) {
			this.stringVal = "J";
		}else if (value==12) {
			this.stringVal = "Q";
		}else if (value==13) {
			this.stringVal = "K";
		}else if (value==14) {
			this.stringVal = "A";
		}else {
			this.stringVal = Integer.toString(value);
		}
		this.suit = suit;
		this.image = image; 
	}
	
	public int points() {
		
		return this.value;
	}
	
	public String getValue() {
		
		return this.stringVal;
	}
	
	public Suit getSuit() {
		
		return this.suit;
	}
	
	public String getStringSuit() {
		
		return this.suit.toString();
	}
	
	public Image getImage() {
		
		return this.image;
	}
	
	public String toString() {
		
		return getValue() + " of " + getSuit() + "\n"; 
	}
}