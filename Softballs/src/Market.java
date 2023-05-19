import java.util.ArrayList;

/**
 * This class generates on every new week of the players' season.
 * The player can purchase athletes and items using money stored in
 * the game environment. 
 * 
 * @author Tobias Paull, Daniel Bensley
 * @version 1.0, May 2023.
 *
 */
public class Market {

	/**
	 * The game environment to interact with
	 */
	private GameEnvironment environment;
	/**
	 * The player club to send the athletes to
	 */
	private Club playerClub;
	/**
	 * The purchasable athletes available on the market
	 */
	private ArrayList<Athlete> purchasableAthletes;

	/**
	 * The purchasable items available on the market
	 */
	private ArrayList<Item> purchasableItems;
	
	
//	On creation of market, generate items and athletes
	public Market(GameEnvironment incomingEnvironment, Club incomingClub)	{
//		Set initial values for the market
		environment = incomingEnvironment;
		playerClub = incomingClub;
		purchasableAthletes = new ArrayList<Athlete>();
		purchasableItems = new ArrayList<Item>();
//		Generate athletes
		for(int i = 0; i < 3; i ++)	{
			purchasableAthletes.add(new Athlete(environment.getCurrentWeek()));
		}

// 		Create items		
		Item item1 = new Item("Treadmill", 10, 0, 0, 0, 10);
		Item item2 = new Item("Improved Bat", 0, 10, 0, 0, 10);
		Item item3 = new Item("Improved Gloves", 0, 0, 10, 0, 10);
		Item item4 = new Item("Wrist Roller", 0, 0, 0, 10, 10);
		purchasableItems.add(item1);
		purchasableItems.add(item2);
		purchasableItems.add(item3);
		purchasableItems.add(item4);
		
	}
	
	/**
	 * The player purchases an athlete from the market
	 * 
	 * @param athleteToBuy		The athlete the player wants to purchase
	 */
	public void purchaseAthlete(Athlete athleteToBuy)	{
//		Get current player funds
		int currentFunds = environment.getMoney();
//		If the player has the funds, purchase the athlete, add to their athlete arraylist and remove
//		the athlete from market
		
//		Existing athlete becomes
		
//		Check if team full (not >= 12)
		if(playerClub.getTeamSize() < 12)	{
//			Check if the player has the funds to purchase a player
			if(currentFunds >= athleteToBuy.getPrice())	{
				currentFunds = currentFunds - athleteToBuy.getPrice();
				environment.setMoney(currentFunds);
				
//				add to team, add to reserve. When selected, call method
				playerClub.addAthlete(athleteToBuy);
			}	else	{
				System.out.println("Missing funds required to purchase");
			}
		
		}	else	{
			System.out.println("Team already full, sell a member to make room.");
		}
		

//		Remove player from market
		purchasableAthletes.remove(athleteToBuy);
		System.out.println(purchasableAthletes);
	}
	
	/**
	 * @param itemToBuy			The item the player wants to purchase
	 */
	public void purchaseItem(Item itemToBuy)	{
//		Get current player funds
		int currentFunds = environment.getMoney();
//		If the player has the funds, purchase the item, add the item to their inventory
//		and remove the item from the market
		if(currentFunds >= itemToBuy.getPrice())	{ // ADD getPrice() function
			currentFunds = currentFunds - itemToBuy.getPrice();
			environment.setMoney(currentFunds);
			
			environment.addItem(itemToBuy); // ADD LATER
			
		}	else	{
			System.out.println("Missing funds required to purchase");
		}
		purchasableItems.remove(itemToBuy);
	}
	

	/**
	 * @return						The arrayList of purchasable athletes
	 */
	public ArrayList<Athlete> getPurchasableAthletes()	{
		return purchasableAthletes;
	}
	

	/**
	 * @return						The arrayList of purchasable items
	 */
	public ArrayList<Item> getPurchasableItems()	{
		return purchasableItems;
	}

	
}
