import java.util.ArrayList;

public class GameEnvironment {	
//Permanent sets
	private int endWeek;
	private int difficulty;	
	//private ArrayList<Item> itemTypes = new ArrayList<Item>();
	
//Dynamic Objects
	private Club club;
	private ArrayList<Integer> items = new ArrayList<Integer>();

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
	private ArrayList<Integer> purchasableItems = new ArrayList<Integer>();
	//private ArrayList<Integer> purchasedItems = new ArrayList<Integer>();


	
	
//Constructor
	public GameEnvironment() {
		for (int i = 0; i < 4; i ++)
		items.add(0);		
	}
	
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
	
	public ArrayList<Integer> getItems(){
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
	
	public ArrayList<Integer> getPurchasableItems(){
		return purchasableItems;
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
		
	public void addItems(int itemIndex) {
		items.set(itemIndex, items.get(itemIndex) + 1);
	}
	
	public void removeItem(int itemIndex) {
		items.set(itemIndex, items.get(itemIndex) - 1);
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

		purchasableItems.add(3);
		purchasableItems.add(3);
		purchasableItems.add(3);
		purchasableItems.add(3);
		
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
		ManageAthleteUI manageWindow = new ManageAthleteUI(this, gameManage);
		//ManageUI manageWindo = new ManageUI(this, gameManage);
	}
	
	public void launchManageReserves() {
		Manage gameManage = new Manage(this);
		ManageReservesUI manageReservesWindow = new ManageReservesUI(this, gameManage);
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
		mainGame.addItems(0);
		mainGame.addItems(0);
		mainGame.addItems(3);

		mainGame.launchMainMenu();
//		mainGame.launchSetup(setUpGame);
				
	}
}
