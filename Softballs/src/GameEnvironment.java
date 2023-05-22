import java.util.ArrayList;

/**
 * Game environment contains the game and implements other function
 * Keeps track of info suck as points and money etc
 * Handles request from user interface
 * 
 * @author Tobias Paull
 *
 */
public class GameEnvironment {	
//Permanent sets
	/**
	 * Season length
	 */
	private int endWeek;
	/**
	 * Selected difficulty
	 */
	private int difficulty;	
	//private ArrayList<Item> itemTypes = new ArrayList<Item>();
	
//Dynamic Objects
	/**
	 * The players club
	 */
	private Club club;
	/**
	 * Items the player owns
	 */
	private ArrayList<Integer> items = new ArrayList<Integer>();

//Dynamic Figures
	/**
	 * Number of points earned
	 */
	private int points = 0;
	/**
	 * The amount of money earned
	 */
	private int moneyGained = 0;
	/**
	 * Current amount of money
	 */
	private int money = 0;
	/**
	 * Current week in season
	 */
	private int currentWeek = 1;

//Stadium
	/**
	 * List of opponent clubs to play in stadium
	 */
	private ArrayList<Club> opponents = new ArrayList<Club>();
	/**
	 * list of opponents already vs'd
	 */
	private ArrayList<Club> played = new ArrayList<Club>();
	
//Market
	/**
	 * List of Athletes available for purchase
	 */
	private ArrayList<Athlete> purchasableAthletes = new ArrayList<Athlete>();
	/**
	 * List of Athletes purchased from this weeks market
	 */
	private ArrayList<Athlete> purchasedAthletes = new ArrayList<Athlete>();
	/**
	 * List of how many of each item is available to buy in the market
	 */
	private ArrayList<Integer> purchasableItems = new ArrayList<Integer>();


	
	
//Constructor
	/**
	 * Constructor that sets up items 
	 */
	public GameEnvironment() {
		for (int i = 0; i < 4; i ++) {
			items.add(0);		
		}
	}
	
//Getters
	
	/**
	 * Get the length of season
	 * @return the length of season
	 */
	public int getEndWeek() {
		return endWeek;
	}
	
	/**
	 * Gets the selected difficulty
	 * @return the selected difficulty
	 */
	public int getDifficulty() {
		return difficulty;
	}
	
	
	/**
	 * Gets the players club
	 * @return the players club
	 */
	public Club getClub() {
		return club;
	}
	
	/**
	 * Gets player items
	 * @return player items
	 */
	public ArrayList<Integer> getItems(){
		return items;
	}
	
	
	/**
	 * Gets points earned
//	 * @return points earned
	 */
	public int getPoints() {
		return points;
	}
	
	/**
	 * Gets current amount of money
	 * @return current amount of money
	 */
	public int getMoney() {
		return money;
	}	
	
	/**
	 * Gets total money gained
	 * @return total money gained
	 */
	public int getMoneyGained() {
		return moneyGained;
	}
	
	/**
	 * Gets the current week in the season
	 * @return the current week in the season
	 */
	public int getCurrentWeek() {
		return currentWeek;
	}
	
	
	/**
	 * Gets list of opponents
	 * @return list of opponents
	 */
	public ArrayList<Club> getOpponents(){
		return opponents;
	}
	
	/**
	 * Gets list of played opponents
	 * @return list of played opponents
	 */
	public ArrayList<Club> getPlayed(){
		return played;
	}
	
	
	/**
	 * Gets list of Athletes available for purchase in the market
	 * @return list of Athletes available for purchase in the market
	 */
	public ArrayList<Athlete> getPurchasableAthletes(){
		return purchasableAthletes;
	}
	
	/**
	 * Gets list of Athletes already purchased from this weeks market
	 * @return list of Athletes already purchased from this weeks market
	 */
	public ArrayList<Athlete> getPurchasedAthletes(){
		return purchasedAthletes;
	}
	
	/**
	 * Gets items in the market
	 * @return items in the market
	 */
	public ArrayList<Integer> getPurchasableItems(){
		return purchasableItems;
	}

	
	
	
//Setters & Adders
	
	/**
	 * Sets the length of the season
	 * @param newWeek: selected season length
	 */
	public void setEndWeek(int newWeek) {
		endWeek = newWeek;
	}
	
	/**
	 * Sets difficulty
	 * @param newDif: selected difficulty
	 */
	public void setDifficulty(int newDif) {
		difficulty = newDif;
	}
	
	
	/**
	 * Sets player club
	 * @param newClub: new club
	 */
	public void setClub(Club newClub) {
		club = newClub;
	}
		
	/**
	 * adds a specified item
	 * @param itemIndex: new item
	 */
	public void addItems(int itemIndex) {
		items.set(itemIndex, items.get(itemIndex) + 1);
	}
	
	/**
	 * removes a specified item
	 * @param itemIndex: item to be removed
	 */
	public void removeItem(int itemIndex) {
		items.set(itemIndex, items.get(itemIndex) - 1);
	}
	
	
	/**
	 * adds a specified amount of points
	 * @param newPoints: amount of points
	 */
	public void addPoints(int newPoints) {
		points += newPoints;
	}
	
	/**
	 * adds a specified amount of money
	 * @param newMoney: amount of money
	 */
	public void addMoney(int newMoney) {
		if (newMoney > 0) {
			moneyGained += newMoney;
		}
		money += newMoney;
	}
	
	/**
	 * Progressed the season by one week
	 */
	public void addCurrentWeek() {
		currentWeek += 1;
	}



//Other
	
	/**
	 * refreshes the market and stadium, and the stamina of all athletes
	 */
	public void refresh() {
		opponents.clear();
		purchasableAthletes.clear();
		purchasedAthletes.clear();
		purchasableItems.clear();
		//Create opponents
		for (int i = 0; i <= 3; i ++) {
			Club newClub = new Club();
			newClub.opponentClub(getCurrentWeek(), getDifficulty());
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
	
	/**
	 * If the game has finished then launch end screen
	 * @return whether the game is finished due to insufficient funds and players
	 */
	public boolean checkFinish() {
		//Get the minimum cost to buy a new athlete from the market
		int minCost = Integer.MAX_VALUE;
		
		for (Athlete currentAthlete : purchasableAthletes) {
			if (!purchasedAthletes.contains(currentAthlete)) {
				if (currentAthlete.getPrice() <= minCost) {
					minCost = currentAthlete.getPrice();
				}
			}
		}
		
		//if season has ended 
		if (currentWeek > endWeek) {
			launchEndScreen(false);
			return true;
		}
		
		//Can't buy more athletes and can't play a match
		else if (money < minCost && club.getAthletes().size() < 7) {
			launchEndScreen(true);
			return true;
		}
		else {
			return false;
		}
	}

	
	
	
//Launching Menus	
	
	/**
	 * Launches the setup screen
	 * @param setupGame: setup class 
	 */
	public void launchSetup(Setup setupGame) {
		SetupUI setupMenu = new SetupUI(setupGame);
	}
	
	/**
	 * closes the setup screen
	 */
	public void closeSetupScreen() {
		launchMainMenu();
	}
	
	
	
	/**
	 * launches the main menu and checks if game has finished
	 */
	public void launchMainMenu() {
		boolean end = checkFinish();
		if (end == false) {
			MainMenuUI menu = new MainMenuUI(this);
		}
	}
	
	/**
	 * Launches the stadium
	 */
	public void launchStadium() {
		StadiumUI stadiumWindow = new StadiumUI(this);
	}
	
	/**
	 * Launches Bye scren
	 */
	public void launchBye() {
		Bye gameBye = new Bye(this);
		ByeUI byeWindow = new ByeUI(this, gameBye);
	}
	
	/**
	 * Launches the Manage Club screen
	 */
	public void launchManage() {
		Manage gameManage = new Manage(this);
		ManageAthleteUI manageWindow = new ManageAthleteUI(this, gameManage);
		//ManageUI manageWindo = new ManageUI(this, gameManage);
	}
	
	
	/**
	 * Launch the manage playing area of manage
	 */
	public void launchManagePlaying() {
		Manage gameManage = new Manage(this);
		ManagePlayingUI managePlayingWindow = new ManagePlayingUI(this, gameManage);
	}
	
	/**
	 * Launch the manage positions area of manage
	 */
	public void launchManagePositions() {
		Manage gameManage = new Manage(this);
		ManagePositionsUI managePositionWindow = new ManagePositionsUI(this, gameManage);
	}
	
	/**
	 * Launch the manage
	 */
	public void launchMarket() {
		Market gameMarket = new Market(this);
		MarketUI marketWindow = new MarketUI(this, gameMarket);		
	}
	
	
	/**
	 * Launch end screen
	 * @param moneyEnd: whether game ended due to insufficient money and athletes
	 */
	public void launchEndScreen(boolean moneyEnd) {
		EndScreenUI gameEnd = new EndScreenUI(this, moneyEnd);
	}
	
	/**
	 * launch the sell screen in market
	 * @param gameMarket: Market class
	 */
	public void launchSellUI(Market gameMarket)	{
		SellAthletesUI sellAthletes = new SellAthletesUI(this, gameMarket);
	}

	
	
	
	/**
	 * allows the player to choose starting athlete
	 * @param setupMenu: setupUI class
	 * @param setupGame: setup class
	 */
	public void launchTeamSelect(SetupUI setupMenu, Setup setupGame)	{
		setupMenu.closeWindow();
		SelectTeam teamSelectWindow = new SelectTeam(setupGame, this);
	}
	
	
	
//Startup
	
	/**
	 * Starts the game
	 * @param args: Null
	 */
	public static void main(String[] args) {
		GameEnvironment mainGame = new GameEnvironment();
		Setup setupGame = new Setup(mainGame);
		mainGame.launchSetup(setupGame);
	}
}
