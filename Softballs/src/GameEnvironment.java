import java.util.ArrayList;

public class GameEnvironment {	
//Permanent sets
	private int endWeek;
	private int difficulty;	
	
//Dynamic Objects
	private Club club;
	private ArrayList<Item> items = new ArrayList<Item>();

//Dynamic Figures
	private int points = 0;
	private int money = 10000;
	private int currentWeek = 1;

//Stadium
	private ArrayList<Club> opponents = new ArrayList<Club>();
	private ArrayList<Club> played = new ArrayList<Club>();
	
//Market
	private ArrayList<Athlete> purchasableAthletes = new ArrayList<Athlete>();
	private ArrayList<Athlete> purchasedAthletes = new ArrayList<Athlete>();
	private ArrayList<Item> purchasableItems = new ArrayList<Item>();
	private ArrayList<Integer> purchasedItems = new ArrayList<Integer>();


	
	
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
	
	
	public ArrayList<Athlete> getPurchasableAthletes(){
		return purchasableAthletes;
	}
	
	public ArrayList<Athlete> getPurchasedAthletes(){
		return purchasedAthletes;
	}
	
	public ArrayList<Item> getPurchasableItems(){
		return purchasableItems;
	}
	
	public ArrayList<Integer> getPurchasedItems(){
		return purchasedItems;
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
		points += newPoints;
	}
	
	public void addMoney(int newMoney) {
		money += newMoney;
	}
	
	public void addCurrentWeek() {
		currentWeek += 1;
	}



//Other
	
	public void refresh() {
		opponents.clear();
		purchasableAthletes.clear();
		purchasedAthletes.clear();
		purchasableItems.clear();
		purchasedItems.clear();
		//Create opponents
		for (int i = 0; i <= 3; i ++) {
			Club newClub = new Club();
			newClub.opponentClub(getCurrentWeek());
			opponents.add(newClub);		
		}
		
		//Create market arrays
		for(int i = 0; i < 4; i ++)	{
			purchasableAthletes.add(new Athlete(currentWeek));
		}
		Item item1 = new Item("Treadmill", 10, 0, 0, 0, 10);
		Item item2 = new Item("Improved Bat", 0, 10, 0, 0, 10);
		Item item3 = new Item("Improved Gloves", 0, 0, 10, 0, 10);
		Item item4 = new Item("Wrist Roller", 0, 0, 0, 10, 10);
		purchasableItems.add(item1);
		purchasableItems.add(item2);
		purchasableItems.add(item3);
		purchasableItems.add(item4);
		items.add(item1);
		purchasedItems.add(3);
		purchasedItems.add(3);
		purchasedItems.add(3);
		purchasedItems.add(3);
		
		for (Athlete currentAthlete : club.getAthletes()) {
			currentAthlete.refreshStanima();
		}
	}

	
	
	
//Launching Menus	
	
	public void launchSetup(Setup setUpGame) {
		SetupUI setupMenu = new SetupUI(setUpGame);
	}
	
	public void closeSetupScreen() {
		launchMainMenu();
	}
	
	
	
	public void launchMainMenu() {
		MainMenuUI menu = new MainMenuUI(this);
	}
	
	public void launchStadium() {
		Stadium gameStadium = new Stadium(this);
		StadiumUI stadiumWindow = new StadiumUI(this, gameStadium);
	}
	
	public void launchBye() {
		Bye gameBye = new Bye(this);
		ByeUI byeWindow = new ByeUI(this, gameBye);
	}
	
	public void launchManage() {
		Manage gameManage = new Manage(this);
		ManageUI manageWindow = new ManageUI(this, gameManage);
	}
	
	public void launchMarket() {
		Market gameMarket = new Market(this);
		MarketUI marketWindow = new MarketUI(this, gameMarket);		
	}
	
	
	
	
	
	
	

	
		

	public void launchTeamSelect(SetupUI setupMenu, Setup setupGame)	{
		setupMenu.closeWindow();
		SelectTeam teamSelectWindow = new SelectTeam(setupGame);
	}
	
	
	
//Startup
	
	public static void main(String[] args) {
		GameEnvironment mainGame = new GameEnvironment();
//		Setup setUpGame = new Setup(mainGame);
		Club playerClub = new Club();
		playerClub.opponentClub(2);
		mainGame.setClub(playerClub);
		mainGame.refresh();
		System.out.println(mainGame.getPurchasableAthletes());
		mainGame.launchMainMenu();
//		mainGame.launchSetup(setUpGame);
				
	}
}
