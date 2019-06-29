package TrumpGameModel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.*;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class DrawFrame extends JPanel {

	private List<Card>player1Cards;
	private List<Card>player2Cards;
	private List<Card>player3Cards;
	private List<Card>player4Cards;
	private Map<Player,Integer>scoreBoard;
	
 	private List<Card>gameDeck;
	
	String message = "";
	boolean gameOn;
	
	public DrawFrame() {
		gameDeck = new ArrayList<>();
	}
	
	public void setPlayer1Cards(List<Card> list) {
		
		this.player1Cards = list;
	}
	
	public void setPlayer2Cards(List<Card>player2Cards) {
		
		this.player2Cards = player2Cards;
	}
	
	public void setPlayer3Cards(List<Card>player3Cards) {
		
		this.player3Cards = player3Cards;
	}
	
	public void setPlayer4Cards(List<Card>player4Cards) {
		
		this.player4Cards = player4Cards;
	}
	
	public void setGameDeck(List<Card> gameDeck) {
		
		this.gameDeck = gameDeck;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public void setGameOn(boolean gameOn) {
		this.gameOn = gameOn;
	}
	
	public void setScoreBoard(Map<Player,Integer>scoreBoard) {
		this.scoreBoard = scoreBoard;
	}
	
	public void paintComponent(Graphics g) {
		
		g.setColor(new Color(0.0f, 0.5f, 0.0f));
		g.fillRect(0,0,this.getWidth(), this.getHeight());
		
		g.setFont(new Font("Arial", Font.BOLD, 20));
		g.setColor(new Color(1.0f, 0.0f, 0.0f));
		g.drawString(message,40,60);
		
		if(player1Cards!=null) {
			
			for(int i=0; i<player1Cards.size(); i++) {
				Image image = player1Cards.get(i).getImage();
				g.drawImage(image,(340+i*20),400,this);
			}
		}
		
		if(player2Cards!=null) {
			
			for(int i=0; i<player2Cards.size(); i++) {
				Image image = new ImageIcon("pictures/b2fv.png").getImage();
//				Image image = player2Cards.get(i).getImage();
				g.drawImage(image,750,(100+i*20),this);
			}
		}
		
		if(player3Cards!=null) {
			
			for(int i=0; i<player3Cards.size(); i++) {
				Image image = new ImageIcon("pictures/b2fv.png").getImage();
//				Image image = player3Cards.get(i).getImage();
				g.drawImage(image,(340+i*20),50,this);
			}
		}
		
		if(player4Cards!=null) {
			
			for(int i=0; i<player4Cards.size(); i++) {
				Image image = new ImageIcon("pictures/b2fv.png").getImage();
//				Image image = player4Cards.get(i).getImage();
				g.drawImage(image,150,(100+i*20),this);
			}
		}
		
		if(gameDeck!=null) {
			
			for(int i=0; i<gameDeck.size(); i++) {
				Image image = gameDeck.get(i).getImage();
				g.drawImage(image,(400+i*20),200,this);
			}
		}
		
		if(gameDeck.isEmpty()) {
			g.setColor(new Color(0.0f, 0.5f, 0.0f));
			g.fillRect(300,200,50,80);
		}
	}
}