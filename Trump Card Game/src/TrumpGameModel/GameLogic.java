package TrumpGameModel;
import java.util.*;
public class GameLogic {

	private Player player1;
	private Player player2; 
	private Player player3; 
	private Player player4;
	
	private int player1Points;
	private int player2Points; 
	private int player3Points;
	private int player4Points; 
	
	private String trumpSuit;
	private int player1FirstTurn; 
	
	private Map<Player,Integer> scoreBoard;
	private List<Player> playersList;
	
	private List <Card> player1Cards; 
	private List <Card> player2Cards;
	private List <Card> player3Cards;
	private List <Card> player4Cards;
	private Player roundWinner; 
	
	private Scanner input;
	private String gameDeckSuit;
	private int gameDeckMaxPoints; 
	
	private Deck deck;
	private List <Card> gameDeck;
	
	public GameLogic(Player player1,Player player2,Player player3,Player player4,Deck deck) {

		this.playersList = new ArrayList<>();
		this.player1 = player1;
		this.player2 = player2;
		this.player3 = player3;
		this.player4 = player4;
		this.playersList.add(this.player1);
		this.playersList.add(this.player2);
		this.playersList.add(this.player3);
		this.playersList.add(this.player4);
		this.deck = deck;
		this.scoreBoard = new HashMap<>();
		this.input = new Scanner(System.in);
	}

	public void start() {
		
		selectTrump();
		this.deck.populateDeck();
		this.deck.shuffleDeck(true);
		distributeCards();
		player1FirstTurn = 0;
		firstRound();
		roundAnalysis();
		System.out.println(getGameDeck());
		gameDeckSuit = "";
		
		while(!this.player1.getPlayerCards().isEmpty()) {
			this.gameDeck = new ArrayList<>();
			gameDeckMaxPoints = 0;
			List<Player> order = gameOrder();
			for (int i=0; i<order.size(); i++) {
			
				if(order.get(i).equals(this.player1)) {
					
					if(i==0) {
						player1FirstTurn = 0;
					}else {
						player1FirstTurn = 100;
					}
					System.out.println(this.player1.getPlayerCards());
					player1Points = playerUserInterface();
				}else {
					
					if(order.get(i).equals(this.player2)) {	
						
						if(i==0) {
							int middle = order.get(i).getPlayerCards().size()/2;
							gameDeckSuit = order.get(i).getPlayerCards().get(middle).getStringSuit();
						}
						player2Points = computerInterface(order.get(i).getPlayerCards());
					}else if (order.get(i).equals(this.player3)) {
						
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
			roundAnalysis();
			System.out.println(getGameDeck());
		}
		System.out.println();
		System.out.println("ScoreBoard for the game : ");
		printScoreBoard();
	}
	
	public void selectTrump() {
		
		Random rand = new Random();
		int number = rand.nextInt(4);
		Suit trumpSuit = Suit.values()[number];
		this.trumpSuit = trumpSuit.toString();
		System.out.println("Trump suit for this game is : " + this.trumpSuit);
	}
	
	public void displayPlayerCards() {
		
		System.out.println(this.player1.getPlayerCards());
		System.out.println(this.player2.getPlayerCards());
		System.out.println(this.player3.getPlayerCards());
		System.out.println(this.player4.getPlayerCards());
	}
	
	public void distributeCards() {
		
		this.player1.distributePlayerCards();
		this.player2.distributePlayerCards();
		this.player3.distributePlayerCards();
		this.player4.distributePlayerCards();
		player1Cards = this.player1.getPlayerCards();
		System.out.println(player1Cards);
		player2Cards = this.player2.getPlayerCards();
		System.out.println(player2Cards);
		player3Cards = this.player3.getPlayerCards();
		System.out.println(player3Cards);
		player4Cards = this.player4.getPlayerCards();
		System.out.println(player4Cards);
	}
	
	public void firstRound() {
		
		this.gameDeck = new ArrayList<>();
		
		player1Points = playerUserInterface();
		player2Points = computerInterface(player2Cards);
		player3Points = computerInterface(player3Cards);
		player4Points = computerInterface(player4Cards);
	}
	
	public void roundAnalysis() {
		
		roundWinner = this.player1;
		
		if((player1Points>player2Points)&&(player1Points>player3Points)&&(player1Points>player4Points)) {
			roundWinner = this.player1;
			
		}else if ((player2Points>player1Points)&&(player2Points>player3Points)&&(player2Points>player4Points)) {
			roundWinner = this.player2;
			
		}else if((player3Points>player1Points)&&(player3Points>player2Points)&&(player3Points>player4Points)) {
			roundWinner = this.player3;
			
		}else if((player4Points>player1Points)&&(player4Points>player2Points)&&(player4Points>player3Points)) {
			roundWinner = this.player4;
		}
		System.out.println("The winner of this round was :" + roundWinner);
		System.out.println("Player 1 points for this round : " + player1Points);
		System.out.println("Player 2 points for this round : " + player2Points);
		System.out.println("Player 3 points for this round : " + player3Points);
		System.out.println("Player 4 points for this round : " + player4Points);
		roundWinner.increasePoints();
		
		this.scoreBoard.put(this.player1,this.player1.getPoints());
		this.scoreBoard.put(this.player2,this.player2.getPoints());
		this.scoreBoard.put(this.player3,this.player3.getPoints());
		this.scoreBoard.put(this.player4,this.player4.getPoints());
	}
	
	public void printScoreBoard() {
		
		int maxScore = 0;
		Player winner = this.player1;
		
		for(Player player : this.scoreBoard.keySet()) {
			
			if(this.scoreBoard.get(player)>maxScore) {
				maxScore = this.scoreBoard.get(player);
				winner = player;
			}
		}
		System.out.println(this.scoreBoard);
		System.out.println("Winner for this game is : " + winner + " with " + this.scoreBoard.get(winner) + " points");
	}
	
	public List<Player> gameOrder() {
		
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
	
	public boolean throwTrumpCard(List<Card>playerCards,String suit) {
		
		for(int i=0; i<playerCards.size(); i++) {
			
			if(playerCards.get(i).getStringSuit().equals(suit)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean checkValidCard(String value,String suit) {
		
		List<Card>player1Cards = player1.getPlayerCards();
		
		for(int i=0; i<player1Cards.size(); i++) {
			
			if(player1Cards.get(i).getValue().equals(value)&&player1Cards.get(i).getStringSuit().equals(suit)) {
				
				return true;
			}
		}
		return false;
	}
	
	public boolean checkPlayerCardValid(String suit) {
		
		if(gameDeckSuit==suit||suit.equals(trumpSuit)) {
			return true;
		}else {
			return false;
		}
	}
	
	public int playerUserInterface() {
		
		boolean setSuit = false;
		System.out.println("Which card number would you like to throw? ");
		String value = this.input.nextLine();
		System.out.println("Of which suit ? ");
		String suit = this.input.nextLine();
		boolean checkCard = checkValidCard(value,suit);
		while(!checkCard) {
			
			System.out.println("Sorry throw Card again :" );
			System.out.println("Which card number would you like to throw");
			value = this.input.nextLine();
			System.out.println("Of which suit ? ");
			suit = this.input.nextLine();
			checkCard = checkValidCard(value,suit);	
			
			if(player1FirstTurn!=0&&checkPlayerCardValid(suit)) {	
				checkCard = false;
			}
		}	
		for(int i=0; i<player1Cards.size(); i++) {
			
			if(player1Cards.get(i).getValue().equals(value)&&player1Cards.get(i).getStringSuit().equals(suit)) {
				
				if(player1Cards.get(i).getStringSuit().equals(trumpSuit)&&player1FirstTurn==0) {
					System.out.println("You have thrown a trump Card");
					gameDeckMaxPoints = player1Cards.get(i).points() + 14;
					gameDeckSuit = suit;
					setSuit = true;
				}else if(player1Cards.get(i).getStringSuit().equals(trumpSuit)&&player1FirstTurn!=0) {
					System.out.println("You have thrown a trump Card");
					gameDeckMaxPoints = player1Cards.get(i).points() + 14 ;
					setSuit = true;
				}else if(!player1Cards.get(i).getStringSuit().equals(gameDeckSuit)&&!player1Cards.get(i).getStringSuit().equals(trumpSuit)&&player1FirstTurn!=0) {
					gameDeckMaxPoints = 0;
					setSuit = true;
				}else {
					gameDeckMaxPoints = player1Cards.get(i).points();
					setSuit = false;
				}
				if(!setSuit) {
					gameDeckSuit = suit;
				}
				this.gameDeck.add(player1Cards.get(i));
				System.out.println("Player 1 throws : " + player1Cards.get(i));
				player1Cards.remove(i);
				break;	
			}
		}
		return gameDeckMaxPoints;
	}
	
	public int computerInterface(List<Card>computer) {
		
		boolean cardChoosen = false;
		boolean throwCard = false; 
		
		for(int i=0; i<computer.size(); i++) {
			
			if(computer.get(i).getStringSuit().equals(gameDeckSuit)) {
				
				if(gameDeckSuit==trumpSuit) {
					
					gameDeckMaxPoints = computer.get(i).points() + 14;
				}else {
				
					gameDeckMaxPoints = computer.get(i).points();
				}
				this.gameDeck.add(computer.get(i));
				System.out.println("Computer throws "  + computer.get(i));
				computer.remove(i);
				cardChoosen = true;
				throwCard = true;
				break;	
			}
		}
		for(int a=0; a<computer.size(); a++) {
			
			if(!throwCard&&throwTrumpCard(computer,gameDeckSuit)&&computer.get(a).getStringSuit().equals(trumpSuit)) {
				gameDeckMaxPoints = computer.get(a).points() + 14;
				this.gameDeck.add(computer.get(a));
				System.out.println("Computer throws : " + computer.get(a));
				throwCard = true; 
				computer.remove(a);
				break;
			}
		}
		for(int b=0; b<computer.size(); b++) {
			
			if(!throwCard&&!computer.get(b).getStringSuit().equals(trumpSuit)&&!computer.get(b).getStringSuit().equals(gameDeckSuit)) {
				
				gameDeckMaxPoints = 0;
				this.gameDeck.add(computer.get(b));
				System.out.println("Computer throws : " + computer.get(b));
				throwCard = true;
				computer.remove(b);
				break;
			}
		}
		return gameDeckMaxPoints;
	}
	
	public List<Player> getPlayerList(){
		
		return this.playersList;
	}
	
	public List<Card> getGameDeck(){
		
		return this.gameDeck;
	}	
	
	public boolean gameDeckRestriction() {
		
		if(this.gameDeck.size()>4) {
			return false;
		}
		return true;
	}
}