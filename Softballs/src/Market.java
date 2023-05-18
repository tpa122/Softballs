import java.util.ArrayList;

public class Market {

	private GameEnvironment environment;
	private Club playerClub;
	private ArrayList<Athlete> purchasableAthletes;
	private ArrayList<Item> purchasableItems;
	
	
//	On creation of market, generate items and athletes
	public Market(GameEnvironment incomingEnvironment, Club incomingClub)	{
//		Set initial values for the market
		environment = incomingEnvironment;
		playerClub = incomingClub;
		purchasableAthletes = new ArrayList<>();
		purchasableItems = new ArrayList<>();
//		Generate athletes
		for(int i = 0; i < 3; i ++)	{
			purchasableAthletes.add(new Athlete(environment.getCurrentWeek()));
		}
//		Generate Items
		for(int i = 0; i < 3; i ++)	{
//			add item to inventory
			;
		}
	}
	
	public void purchaseAthlete(Athlete athleteToBuy)	{
//		Get current player funds
		int currentFunds = environment.getMoney();
//		If the player has the funds, purchase the athlete, add to their athlete arraylist and remove
//		the athlete from market
		if(currentFunds >= athleteToBuy.getPrice())	{
			currentFunds = currentFunds - athleteToBuy.getPrice();
			environment.setMoney(currentFunds);
			
		}	else	{
			System.out.println("Missing funds required to purchase");
		}

		
//		Remove player from market
		purchasableAthletes.remove(athleteToBuy);
	}
	
	public void purchaseItem(Item itemToBuy)	{
//		Get current player funds
		int currentFunds = environment.getMoney();
//		If the player has the funds, purchase the item, add the item to their inventory
//		and remove the item from the market
		if(currentFunds >= itemToBuy.getPrice())	{ // ADD getPrice() function
			currentFunds = currentFunds - itemToBuy.getPrice();
			environment.setMoney(currentFunds);
			
		}	else	{
			System.out.println("Missing funds required to purchase");
		}
		
	}
	
//	Returns the list of athletes for purchase
	public ArrayList<Athlete> getPurchasableAthletes()	{
		return purchasableAthletes;
	}
	
//	Returns the list of items for purchase
	public ArrayList<Item> getPurchasableItems()	{
		return purchasableItems;
	}

	
}
