package TrumpGameModel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class GameGUI {

	private ArrayList<Card> gameDeck; 
	
	private JFrame Jframe;
	private DrawFrame drawPanel;
	private Deck deck;
	
	private boolean player1FirstTurn;
	
	private int gameDeckMaxPoints;
	private Card card;
	private String gameDeckSuit;
	private String trumpString;
	
	private Player player1;
	private Player player2;
	private Player player3;
	private Player player4;
	
	private int player1Points;
	private int player2Points; 
	private int player3Points;
	private int player4Points; 
	
	
	private Player roundWinner;
	
	
	private Map<Player,Integer> scoreBoard;
	
	private List<Player> playerList;
	
	private List<Player> order;
	
	private JButton jbutton;
	private JButton jbutton2;
	private JButton jbutton3;
	private JButton jbutton4;
	private JButton jbutton5;
	private JButton jbutton6;
	private JButton jbutton7;
	private JButton jbutton8;
	private JButton jbutton9;
	private JButton jbutton10;
	private JButton jbutton11;
	private JButton jbutton12;
	private JButton jbutton13;
	
	private JLabel JtextfieldScoreboardTitle;
	private JLabel JtextfieldScoreBoard;
	private JLabel JtextfieldScoreBoard1; 
	private JLabel JtextfieldScoreBoard2; 
	private JLabel JtextfieldScoreBoard3; 
	
	private JLabel JtextfieldPlayer1Name; 
	private JLabel JtextfieldPlayer2Name; 
	private JLabel JtextfieldPlayer3Name; 
	private JLabel JtextfieldPlayer4Name;
	
	private JLabel JtextfieldFinalDisplay;
	
	private int buttonPress = 0;
	
	private String message = "";
	private boolean gameOn;
	
	public GameGUI() {
		this.playerList = new ArrayList<>();
		this.scoreBoard = new HashMap<>();
		this.JtextfieldScoreBoard = new JLabel();
		this.JtextfieldScoreBoard1 = new JLabel();
		this.JtextfieldScoreBoard2 = new JLabel();
		this.JtextfieldScoreBoard3 = new JLabel();
		this.JtextfieldScoreboardTitle = new JLabel();
		this.JtextfieldPlayer1Name = new JLabel();
		this.JtextfieldPlayer2Name = new JLabel();
		this.JtextfieldPlayer3Name = new JLabel();
		this.JtextfieldPlayer4Name = new JLabel();
		this.order = new ArrayList<>();
		this.player1FirstTurn = false;
		this.JtextfieldFinalDisplay = new JLabel();
	}
	
	public void init() {
		
		this.Jframe = new JFrame("Trump Card Game");
		this.Jframe.setDefaultCloseOperation(this.Jframe.EXIT_ON_CLOSE);
		this.Jframe.setResizable(true);
		
		this.drawPanel = new DrawFrame();
		drawPanel.setBounds(0,0,1000,800);
		drawPanel.setLayout(null);
		
		Jframe.getContentPane().add(drawPanel);
		Jframe.setSize(1000,800);
		Jframe.setVisible(true);
		
		jbutton = new JButton("0");
		jbutton.setBounds(340,485,10,10);
		drawPanel.add(jbutton);
		
		jbutton2 = new JButton("1");
		jbutton2.setBounds(360,485,10,10);
		drawPanel.add(jbutton2);
		
		jbutton3 = new JButton("2");
		jbutton3.setBounds(380,485,10,10);
		drawPanel.add(jbutton3);
		
		jbutton4 = new JButton("3");
		jbutton4.setBounds(400,485,10,10);
		drawPanel.add(jbutton4);
		
		jbutton5 = new JButton("4");
		jbutton5.setBounds(420,485,10,10);
		drawPanel.add(jbutton5);
		
		jbutton6 = new JButton("5");
		jbutton6.setBounds(440,485,10,10);
		drawPanel.add(jbutton6);
		
		jbutton7 = new JButton("6");
		jbutton7.setBounds(460,485,10,10);
		drawPanel.add(jbutton7);
		
		jbutton8 = new JButton("7");
		jbutton8.setBounds(480,485,10,10);
		drawPanel.add(jbutton8);
		
		jbutton9 = new JButton("8");
		jbutton9.setBounds(500,485,10,10);
		drawPanel.add(jbutton9);
		
		jbutton10 = new JButton("9");
		jbutton10.setBounds(520,485,10,10);
		drawPanel.add(jbutton10);
		
		jbutton11 = new JButton("10");
		jbutton11.setBounds(540,485,10,10);
		drawPanel.add(jbutton11);
		
		jbutton12 = new JButton("11");
		jbutton12.setBounds(560,485,10,10);
		drawPanel.add(jbutton12);
		
		jbutton13 = new JButton("12");
		jbutton13.setBounds(580,485,10,10);
		drawPanel.add(jbutton13);
		
		JButton nextRound = new JButton("Next Round");
		nextRound.setBounds(10,600,100,35);
		drawPanel.add(nextRound);
		
		JButton newGame = new JButton("New Game");
		newGame.setBounds(10,550,100,35);
		drawPanel.add(newGame);
		
		newGame.addActionListener(new newGameListener());
		nextRound.addActionListener(new nextRoundListener());
		jbutton.addActionListener(new button1Listener());
		jbutton2.addActionListener(new button1Listener());
		jbutton3.addActionListener(new button1Listener());
		jbutton4.addActionListener(new button1Listener());
		jbutton5.addActionListener(new button1Listener());
		jbutton6.addActionListener(new button1Listener());
		jbutton7.addActionListener(new button1Listener());
		jbutton8.addActionListener(new button1Listener());
		jbutton9.addActionListener(new button1Listener());
		jbutton10.addActionListener(new button1Listener());
		jbutton11.addActionListener(new button1Listener());
		jbutton12.addActionListener(new button1Listener());
		jbutton13.addActionListener(new button1Listener());
		
	}
	
	public void firstRound() {
		
		player1Points = firstPlayerRound();
		player2Points = computerInterface(player2.getPlayerCards());
		player3Points = computerInterface(player3.getPlayerCards());
		player4Points = computerInterface(player4.getPlayerCards());
	}
	
	public void roundAnalysis() {
		
		roundWinner = player1;
		
		if((player1Points>player2Points)&&(player1Points>player3Points)&&(player1Points>player4Points)) {
			roundWinner = player1;
			
		}else if ((player2Points>player1Points)&&(player2Points>player3Points)&&(player2Points>player4Points)) {
			roundWinner = player2;
			
		}else if((player3Points>player1Points)&&(player3Points>player2Points)&&(player3Points>player4Points)) {
			roundWinner = player3;
			
		}else if((player4Points>player1Points)&&(player4Points>player2Points)&&(player4Points>player3Points)) {
			roundWinner = player4;
		}
		System.out.println("The winner of this round was :" + roundWinner);
		System.out.println("Player 1 points for this round : " + player1Points);
		System.out.println("Player 2 points for this round : " + player2Points);
		System.out.println("Player 3 points for this round : " + player3Points);
		System.out.println("Player 4 points for this round : " + player4Points);

		roundWinner.increasePoints();
		
		System.out.println(player1.getName() + " Game Points : " + player1.getPoints());
		System.out.println(player2.getName() + " Game Points : " + player2.getPoints());
		scoreBoard.put(player1,player1.getPoints());
		scoreBoard.put(player2,player2.getPoints());
		scoreBoard.put(player3,player3.getPoints());
		scoreBoard.put(player4,player4.getPoints());
	}
	
	public void printScoreBoard() {
		
		JtextfieldScoreboardTitle.setText("Game ScoreBoard : ");
		JtextfieldScoreBoard.setFont(new Font("Arial", Font.BOLD, 20));
		JtextfieldScoreBoard.setBounds(20,550,50,50);
		drawPanel.add(JtextfieldScoreboardTitle);
		
		JtextfieldScoreBoard.setText(player1.getName() + " : " + player1.getPoints());
		JtextfieldScoreBoard.setFont(new Font("Arial", Font.BOLD, 20));
		JtextfieldScoreBoard.setBounds(600,550,200,200);
		drawPanel.add(JtextfieldScoreBoard);
		
		JtextfieldScoreBoard1.setText(player2.getName() + " : " + player2.getPoints());
		JtextfieldScoreBoard1.setFont(new Font("Arial", Font.BOLD, 20));
		JtextfieldScoreBoard1.setBounds(300,550,200,200);
		drawPanel.add(JtextfieldScoreBoard1);
		
		JtextfieldScoreBoard2.setText(player3.getName() + " : " + player3.getPoints());
		JtextfieldScoreBoard2.setFont(new Font("Arial", Font.BOLD, 20));
		JtextfieldScoreBoard2.setBounds(400,550,200,200);
		drawPanel.add(JtextfieldScoreBoard2);
		
		JtextfieldScoreBoard3.setText(player4.getName() + " : " + player4.getPoints());
		JtextfieldScoreBoard3.setFont(new Font("Arial", Font.BOLD, 20));
		JtextfieldScoreBoard3.setBounds(500,550,200,200);
		drawPanel.add(JtextfieldScoreBoard3);
		
		
	}
	
	public List<Player> gameOrder(){
		
		List<Player> playerList = getPlayerList();
		
		int index = 0;
		for(int i=0; i<playerList.size(); i++) {
			
			if(roundWinner.getName()==playerList.get(i).getName()) {
				index = i;
			}
		}
		if(index==0) {
			return playerList;
		}else if (index==1) {
			Player temp = playerList.get(0);
			playerList.remove(0);
			playerList.add(temp);
			return playerList;
		}else if (index==2) {
			Player temp = playerList.get(0);
			playerList.remove(0);
			playerList.add(temp);
			Player temp1 = playerList.get(0);
			playerList.remove(0);
			playerList.add(temp1);
			return playerList;
		}else {
			Player temp = playerList.get(0);
			playerList.remove(0);
			playerList.add(temp);
			Player temp1 = playerList.get(0);
			playerList.remove(0);
			playerList.add(temp1);
			Player temp2 = playerList.get(0);
			playerList.remove(0);
			playerList.add(temp2);
			return playerList;
		}
	}
	
	public int firstPlayerRound() {
		
		if(card.getStringSuit().equals(trumpString)&&buttonPress==1) {
			gameDeckMaxPoints = card.points() + 14;
			gameDeckSuit = card.getStringSuit();
			
		}else if(card.getStringSuit().equals(trumpString)&&buttonPress!=1) {
			gameDeckMaxPoints = card.points() + 14;
			
		}else if(card.getStringSuit().equals(gameDeckSuit)) {
			gameDeckMaxPoints = card.points();
		}
		return gameDeckMaxPoints;
	}
	
	public int computerInterface(List<Card>computer) {
		
		boolean cardChoosen = false;
		boolean throwCard = false;
		
		for(int i=0; i<computer.size(); i++) {
			
			if(computer.get(i).getStringSuit().equals(gameDeckSuit)) {
				
				if(gameDeckSuit == trumpString) {
					gameDeckMaxPoints = computer.get(i).points() + 14;
				}else {
					gameDeckMaxPoints = computer.get(i).points();
				}
				gameDeck.add(computer.get(i));
				computer.remove(i);
				Jframe.repaint();
				cardChoosen = true;
				throwCard = true;
				break;
			}
		}
		
		for(int a=0; a<computer.size(); a++) {
			
			if(!throwCard&&throwTrumpCard(computer,gameDeckSuit)&&computer.get(a).getStringSuit().equals(trumpString)) {
				gameDeckMaxPoints = computer.get(a).points() + 14;
				gameDeck.add(computer.get(a));
				System.out.println("Computer throws : " + computer.get(a));
				throwCard = true; 
				computer.remove(a);
				break;
			}
		}
		
		for(int b=0; b<computer.size(); b++) {
			
			if(!throwCard&&!computer.get(b).getStringSuit().equals(trumpString)&&!computer.get(b).getStringSuit().equals(gameDeckSuit)) {
				
				gameDeckMaxPoints = 0;
				gameDeck.add(computer.get(b));
				System.out.println("Computer throws : " + computer.get(b));
				throwCard = true;
				computer.remove(b);
				break;
			}
		}
		return gameDeckMaxPoints;
	}
	
	public boolean throwTrumpCard(List<Card>playerCards,String suit) {
		
		for(int i=0; i<playerCards.size(); i++) {
			
			if(playerCards.get(i).getStringSuit().equals(suit)) {
				return false;
			}
		}
		return true;
	}

	public List<Player> getPlayerList(){
		return playerList;
	}

	class nextRoundListener implements ActionListener{
		
		public void actionPerformed(ActionEvent ae) {
			
			gameDeck = new ArrayList<>();
			drawPanel.setGameDeck(gameDeck);
			drawPanel.repaint();
			gameDeckSuit = null;

			order = gameOrder();
			
			for(int i=0; i<order.size(); i++) {
				
				if(order.get(i).equals(player1)) {
					
					if(i==0) {
						player1FirstTurn = true;
					}else {
						player1FirstTurn = false;
					}
					return;
				}else {
					if(order.get(i).equals(player2)) {
						
						if(i==0) {						
							int middle = order.get(i).getPlayerCards().size()/2;
							gameDeckSuit = order.get(i).getPlayerCards().get(middle).getStringSuit();
						}
						player2Points = computerInterface(order.get(i).getPlayerCards()); 
					}else if(order.get(i).equals(player3)) {
						
						if(i==0) {
							int middle = order.get(i).getPlayerCards().size()/2;
							gameDeckSuit = order.get(i).getPlayerCards().get(middle).getStringSuit();
						}
						player3Points = computerInterface(order.get(i).getPlayerCards());
					}else {
						
						if(i==0) {
							int middle = order.get(i).getPlayerCards().size()/2;
							gameDeckSuit = order.get(i).getPlayerCards().get(middle).getStringSuit();
						}
						player4Points = computerInterface(order.get(i).getPlayerCards());
					}
				}
			}
		}
	}
	
	class button1Listener implements ActionListener{
		
		public void actionPerformed(ActionEvent ae) {
			
			String command = ae.getActionCommand();
			card = player1.getPlayerCards().get(0);
			buttonPress++;
			gameDeckMaxPoints = 0;
			
			if(command.equals("0")) {
				card = player1.getPlayerCards().remove(0);
				gameDeck.add(card);
				Jframe.repaint();
			}else if (command.equals("1")) {
				card = player1.getPlayerCards().remove(1);
				gameDeck.add(card);
				Jframe.repaint();
			}else if (command.equals("2")) {
				card = player1.getPlayerCards().remove(2);
				gameDeck.add(card);
				Jframe.repaint();
			}else if (command.equals("3")) {
				card = player1.getPlayerCards().remove(3);
				gameDeck.add(card);
				Jframe.repaint();
			}else if (command.equals("4")) {
				card = player1.getPlayerCards().remove(4);
				gameDeck.add(card);
				Jframe.repaint();
			}else if (command.equals("5")) {
				card = player1.getPlayerCards().remove(5);
				gameDeck.add(card);
				Jframe.repaint();
			}else if (command.equals("6")) {
				card = player1.getPlayerCards().remove(6);
				gameDeck.add(card);
				Jframe.repaint();
			}else if (command.equals("7")) {
				card = player1.getPlayerCards().remove(7);
				gameDeck.add(card);
				Jframe.repaint();
			}else if (command.equals("8")) {
				card = player1.getPlayerCards().remove(8);
				gameDeck.add(card);
				Jframe.repaint();
			}else if (command.equals("9")) {
				card = player1.getPlayerCards().remove(9);
				gameDeck.add(card);
				Jframe.repaint();
			}else if (command.equals("10")) {
				card = player1.getPlayerCards().remove(10);
				gameDeck.add(card);
				Jframe.repaint();
			}else if (command.equals("11")) {
				card = player1.getPlayerCards().remove(11);
				gameDeck.add(card);
				Jframe.repaint();
			}else if (command.equals("12")) {
				card = player1.getPlayerCards().remove(12);
				gameDeck.add(card);
				Jframe.repaint();
			}else if (command.equals("13")) {
				card = player1.getPlayerCards().remove(13);
				gameDeck.add(card);
				Jframe.repaint();
			}
			
			if(buttonPress!=1&&!player1FirstTurn&&!card.getStringSuit().equals(gameDeckSuit)) {
				
				for(int i=0; i<player1.getPlayerCards().size(); i++) {
					
					if(player1.getPlayerCards().get(i).getStringSuit().equals(gameDeckSuit)) {
						drawPanel.setMessage("You are a big cheater ..................................");
						drawPanel.setBounds(300,300,100,100);
						drawPanel.repaint();
						Runtime.getRuntime().exit(0);
						break;
					}
				}
			}
			
			if(buttonPress==1) {
				jbutton13.setVisible(false);
				gameDeckSuit = card.getStringSuit();
				firstRound();
				roundAnalysis();
				message = message + "\n" + "The winner of this round was : " + roundWinner;
				printScoreBoard();
				
			}else {
				if(player1FirstTurn) {
					gameDeckSuit = card.getStringSuit();
				}
				
				player1Points = firstPlayerRound();
				
				List<Player> remainingPlayers = checkRemainingPlayers();
				
				for(int i=0; i<remainingPlayers.size(); i++) {
					
					if(remainingPlayers.get(i).equals(player2)) {
						if(roundWinner==player2) {
							int middle = remainingPlayers.get(i).getPlayerCards().size()/2;
							gameDeckSuit = remainingPlayers.get(i).getPlayerCards().get(middle).getStringSuit();
						}
						player2Points = computerInterface(remainingPlayers.get(i).getPlayerCards());
					}else if(remainingPlayers.get(i).equals(player3)) {
						
						if(roundWinner==player3) {
							int middle = remainingPlayers.get(i).getPlayerCards().size()/2;
							gameDeckSuit = remainingPlayers.get(i).getPlayerCards().get(middle).getStringSuit();
						}
						player3Points = computerInterface(remainingPlayers.get(i).getPlayerCards());
					}else {	
						if(roundWinner==player4) {
							int middle = remainingPlayers.get(i).getPlayerCards().size()/2;
							gameDeckSuit = remainingPlayers.get(i).getPlayerCards().get(middle).getStringSuit();
						}
						player4Points = computerInterface(remainingPlayers.get(i).getPlayerCards());
					}
				}
				
				if (buttonPress == 2) {
					jbutton13.setVisible(false);
					jbutton12.setVisible(false);
				}else if (buttonPress == 3) {
					jbutton13.setVisible(false);
					jbutton12.setVisible(false);
					jbutton11.setVisible(false);
				}else if (buttonPress == 4) {
					jbutton13.setVisible(false);
					jbutton12.setVisible(false);
					jbutton11.setVisible(false);
					jbutton10.setVisible(false);
				}else if (buttonPress == 5) {
					jbutton13.setVisible(false);
					jbutton12.setVisible(false);
					jbutton11.setVisible(false);
					jbutton10.setVisible(false);
					jbutton9.setVisible(false);
				}else if (buttonPress == 6) {
					jbutton13.setVisible(false);
					jbutton12.setVisible(false);
					jbutton11.setVisible(false);
					jbutton10.setVisible(false);
					jbutton9.setVisible(false);
					jbutton8.setVisible(false);
				}else if (buttonPress == 7) {
					jbutton13.setVisible(false);
					jbutton12.setVisible(false);
					jbutton11.setVisible(false);
					jbutton10.setVisible(false);
					jbutton9.setVisible(false);
					jbutton8.setVisible(false);
					jbutton7.setVisible(false);
				}else if (buttonPress == 8) {
					jbutton13.setVisible(false);
					jbutton12.setVisible(false);
					jbutton11.setVisible(false);
					jbutton10.setVisible(false);
					jbutton9.setVisible(false);
					jbutton8.setVisible(false);
					jbutton7.setVisible(false);
					jbutton6.setVisible(false);
				}else if (buttonPress == 9) {
					jbutton13.setVisible(false);
					jbutton12.setVisible(false);
					jbutton11.setVisible(false);
					jbutton10.setVisible(false);
					jbutton9.setVisible(false);
					jbutton8.setVisible(false);
					jbutton7.setVisible(false);
					jbutton6.setVisible(false);
					jbutton5.setVisible(false);
				}else if (buttonPress == 10) {
					jbutton13.setVisible(false);
					jbutton12.setVisible(false);
					jbutton11.setVisible(false);
					jbutton10.setVisible(false);
					jbutton9.setVisible(false);
					jbutton8.setVisible(false);
					jbutton7.setVisible(false);
					jbutton6.setVisible(false);
					jbutton5.setVisible(false);
					jbutton4.setVisible(false);
				}else if (buttonPress == 11) {
					jbutton13.setVisible(false);
					jbutton12.setVisible(false);
					jbutton11.setVisible(false);
					jbutton10.setVisible(false);
					jbutton9.setVisible(false);
					jbutton8.setVisible(false);
					jbutton7.setVisible(false);
					jbutton6.setVisible(false);
					jbutton5.setVisible(false);
					jbutton4.setVisible(false);
					jbutton3.setVisible(false);
				}else if (buttonPress == 12) {
					jbutton13.setVisible(false);
					jbutton12.setVisible(false);
					jbutton11.setVisible(false);
					jbutton10.setVisible(false);
					jbutton9.setVisible(false);
					jbutton8.setVisible(false);
					jbutton7.setVisible(false);
					jbutton6.setVisible(false);
					jbutton5.setVisible(false);
					jbutton4.setVisible(false);
					jbutton3.setVisible(false);
					jbutton2.setVisible(false);
				}else if (buttonPress == 13) {
					jbutton13.setVisible(false);
					jbutton12.setVisible(false);
					jbutton11.setVisible(false);
					jbutton10.setVisible(false);
					jbutton9.setVisible(false);
					jbutton8.setVisible(false);
					jbutton7.setVisible(false);
					jbutton6.setVisible(false);
					jbutton5.setVisible(false);
					jbutton4.setVisible(false);
					jbutton3.setVisible(false);
					jbutton2.setVisible(false);
					jbutton.setVisible(false);
				}
				//Add rest of the code here...........................................
				//Add checkRemainingPlayers here......................................
				//Add playerRestrictions here.
				roundAnalysis();
				printScoreBoard();
			}
			
			if(player1.getPlayerCards().isEmpty()) {
				
				int max = 0;
				Player winner = player1;
				
				for(Player p : scoreBoard.keySet()) {
					
					if(scoreBoard.get(p)>max) {
						max = scoreBoard.get(p);
						winner = p;
					}
				}
				String winnerName = winner.getName();
				JtextfieldFinalDisplay.setText(winnerName + " has won the game ");
				JtextfieldFinalDisplay.setBounds(350,200,300,300);
				JtextfieldFinalDisplay.setFont(new Font("Arial", Font.BOLD, 20));
				drawPanel.add(JtextfieldFinalDisplay);
			}
		}
	}
	
	private List<Player> checkRemainingPlayers() {
		
		List<Player> playerRemainingList = new ArrayList<>();
		List<Player> gameOrder = gameOrder();
		
		if(gameOrder.get(0).equals(player1)) {
			playerRemainingList.add(player2);
			playerRemainingList.add(player3);
			playerRemainingList.add(player4);
		}else if(gameOrder.get(0).equals(player3)) {
			playerRemainingList.add(player2);
		}else if(gameOrder.get(0).equals(player4)) {
			playerRemainingList.add(player2);
			playerRemainingList.add(player3);
		}
		return playerRemainingList;
	}
	
	private void addPlayers() {
		
		this.playerList.add(player1);
		this.playerList.add(player2);
		this.playerList.add(player3);
		this.playerList.add(player4);
	}

	private void setupNewGame() {
		
		deck = new Deck();
		deck.populateDeck();
		deck.shuffleDeck(true);
		gameDeck = new ArrayList<>();
		
		player1 = new Player("Zain",deck);
		player2 = new Player("Safder",deck);
		player3 = new Player("Hamza",deck);
		player4 = new Player("Bilal",deck);
		
		message = "";
		gameOn = true;
	}
	
	private void selectTrump() {
		
		Random rand = new Random();
		int rando = rand.nextInt(4);
		Suit trump = Suit.values()[rando];
		this.trumpString = trump.toString();
		message = message + "Trump Suit : " + trumpString;
	}
	
	public void introducePlayers() {
		
		JtextfieldPlayer1Name.setText("Zain");
		JtextfieldPlayer1Name.setFont(new Font("Arial", Font.BOLD, 20));
		JtextfieldPlayer1Name.setBounds(440,500,50,50);
		drawPanel.add(JtextfieldPlayer1Name);
		
		JtextfieldPlayer2Name.setText("Safder");
		JtextfieldPlayer2Name.setFont(new Font("Arial", Font.BOLD, 20));
		JtextfieldPlayer2Name.setBounds(840,200,200,200);
		drawPanel.add(JtextfieldPlayer2Name);
		
		JtextfieldPlayer3Name.setText("Hamza");
		JtextfieldPlayer3Name.setFont(new Font("Arial", Font.BOLD, 20));
		JtextfieldPlayer3Name.setBounds(440,70,200,200);
		drawPanel.add(JtextfieldPlayer3Name);
		
		JtextfieldPlayer4Name.setText("Bilal");
		JtextfieldPlayer4Name.setFont(new Font("Arial", Font.BOLD, 20));
		JtextfieldPlayer4Name.setBounds(45,200,200,200);
		drawPanel.add(JtextfieldPlayer4Name);
		
	}

	class newGameListener implements ActionListener{
		
		public void actionPerformed(ActionEvent ae) {
			
			if(!gameOn) {
				
				setupNewGame();
				selectTrump();
				addPlayers();
				introducePlayers();
				printScoreBoard();
				
				player1.distributePlayerCards();
				player2.distributePlayerCards();
				player3.distributePlayerCards();
				player4.distributePlayerCards();
				
				drawPanel.setPlayer1Cards(player1.getPlayerCards());
				drawPanel.setPlayer2Cards(player2.getPlayerCards());
				drawPanel.setPlayer3Cards(player3.getPlayerCards());
				drawPanel.setPlayer4Cards(player4.getPlayerCards());
				drawPanel.setGameDeck(gameDeck);
				
				drawPanel.setMessage(message);
				drawPanel.setGameOn(gameOn);
				Jframe.repaint();
			}
		}
	}
}