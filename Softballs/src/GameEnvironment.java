import java.util.ArrayList;

public class GameEnvironment {
	private Club club;
	private int currentWeek = 1;
	private int endWeek;
	private ArrayList<Item> items;
	private int points;
	private int money;
	private int difficulty;
	

	public Club getClub() {
		return club;
	}
	
	public void setClub(Club newClub) {
		club = newClub;
	}
	
	public int getCurrentWeek() {
		return currentWeek;
	}
	
	public void setCurrentWeek(int newWeek) {
		currentWeek = newWeek;
	}
	
	public int getEndWeek() {
		return endWeek;
	}
	
	public void setEndWeek(int newWeek) {
		endWeek = newWeek;
	}
	
	public ArrayList<Item> getItems(){
		return items;
	}
	
	public void setItems(ArrayList<Item> newItems) {
		items = newItems;
	}
	
	public int getPoints() {
		return points;
	}
	
	public void setPoints(int newPoints) {
		points = newPoints;
	}
	
	public int getMoney() {
		return money;
	}
	
	public void setMoney(int newMoney) {
		money = newMoney;
	}
	
	public void setDifficulty(int newDif) {
		difficulty = newDif;
	}
	
	public void makeMarket() {
		
	}
	
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
		Stadium stad = new Stadium(this);
	}
	
	public static void main(String[] args) {
		GameEnvironment mainGame = new GameEnvironment();
		Club playerClub = new Club();
		playerClub.opponentClub(2);
		mainGame.setClub(playerClub);
		mainGame.launchMainMenu();
				
	}
}
