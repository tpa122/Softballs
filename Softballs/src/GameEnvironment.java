import java.util.ArrayList;

public class GameEnvironment {	
//Permanent sets
	private int endWeek;
	private int difficulty;	
	
//Dynamic Objects
	private Club club;
	private ArrayList<Item> items;

//Dynamic Figures
	private int points = 0;
	private int money = 0;
	private int currentWeek = 1;

//Stadium
	private ArrayList<Club> opponents = new ArrayList<Club>();
	private ArrayList<Club> played = new ArrayList<Club>();

	
	
//Getters
	
	public int getEndWeek() {
		return endWeek;
	}
	
	public int getDifficulty() {
		return difficulty;
	}
	
	
	public Club getClub() {
		return club;
	}
	
	public ArrayList<Item> getItems(){
		return items;
	}
	
	
	public int getPoints() {
		return points;
	}
	
	public int getMoney() {
		return money;
	}	
	
	public int getCurrentWeek() {
		return currentWeek;
	}
	
	
	public ArrayList<Club> getOpponents(){
		return opponents;
	}
	
	public ArrayList<Club> getPlayed(){
		return played;
	}
	
	
	
//Setters & Adders
	
	public void setEndWeek(int newWeek) {
		endWeek = newWeek;
	}
	
	public void setDifficulty(int newDif) {
		difficulty = newDif;
	}
	
	
	public void setClub(Club newClub) {
		club = newClub;
	}
		
	public void setItems(ArrayList<Item> newItems) {
		items = newItems;
	}
	
	
	public void addPoints(int newPoints) {
		points = newPoints;
	}
	
	public void addMoney(int newMoney) {
		money += newMoney;
	}
	
	public void addCurrentWeek(int newWeek) {
		currentWeek += 1;
	}



//Other
	
	public void refresh() {
		//Create opponents
		for (int i = 0; i <= 3; i ++) {
			Club newClub = new Club();
			newClub.opponentClub(getCurrentWeek());
			opponents.add(newClub);		
		}
	}

	
	
	
//Launching Menus	
	
	public void launchSetup() {
		Setup setupGame = new Setup(this);
	}
	
	public void closeSetupScreen() {
		launchMainMenu();
	}
	
	public void launchMainMenu() {
		MainMenu menu = new MainMenu(this);
	}
	
	public void launchStadium() {
		Stadium gameStadium = new Stadium(this);
	}
	
	
	
	
//Startup
	
	public static void main(String[] args) {
		GameEnvironment mainGame = new GameEnvironment();
		Club playerClub = new Club();
		playerClub.opponentClub(2);
		mainGame.setClub(playerClub);
		mainGame.refresh();
		mainGame.launchMainMenu();
				
	}
}
