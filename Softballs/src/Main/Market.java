package Main;
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
// Game environment
	
	/**
	 * 	The game environment to interact with
	 */
	private GameEnvironment environment;
	/**
	 * The player club to send the athletes to
	 */
	private Club playerClub;


	/**
	 * Constructor for the Market class
	 * 
	 * @param incomingEnvironment		the game environment to interact with
	 */
	public Market(GameEnvironment incomingEnvironment)	{
//		Set initial values for the market
		environment = incomingEnvironment;
		playerClub = environment.getClub();

	}
	
	/**
	 * The player purchases an athlete from the market
	 * 
	 * @param athleteToBuy		The athlete the player wants to purchase
	 */
	public void purchaseAthlete(Athlete athleteToBuy, int toPlaying)	{
//		Get current player funds
		int currentFunds = environment.getMoney();
		
//		Check if team full (not >= 12)
		if(playerClub.getTeamSize() < 12)	{
//			Check if the player has the funds to purchase a player
			if(currentFunds >= athleteToBuy.getPrice())	{
//				If purchased player is going to playing
				if (toPlaying == 0) {
					playerClub.getAthletes().add(athleteToBuy);
					environment.addMoney(-athleteToBuy.getPrice());
					environment.getPurchasedAthletes().add(athleteToBuy);
// 					If playing is full then make a player go to reserve, else just add
					if (playerClub.getPlaying().size() >= 7) {
						playerClub.swapPlayers(playerClub.getPlaying().get(0), athleteToBuy);
					}
					else {
						playerClub.getPlaying().add(athleteToBuy);
					}
				}
//				If purchased player is going to reserves
				else if (toPlaying == 1) {
//					If reserves are full don't buy, else add to reserves
					if (playerClub.getReserves().size() >= 5) {
					}
					else {
						environment.getPurchasedAthletes().add(athleteToBuy);
						environment.addMoney(-athleteToBuy.getPrice());
						playerClub.getAthletes().add(athleteToBuy);
						playerClub.getReserves().add(athleteToBuy);
					}
				}		
			}	
		}	
	}
	
	/**
	 * The player purchases an item from the market
	 * 
	 * @param itemToBuy			The item the player wants to purchase
	 */
	public void purchaseItem(int itemIndex)	{
//		Set the item to buy
		Item itemToBuy = new Item(itemIndex);
//		Get player's balance
		int currentFunds = environment.getMoney();
//		Get amount remaining of specific item at Index
		int amountRemaining = environment.getPurchasableItems().get(itemIndex);

		//Check player has enough money to buy item
		if (currentFunds >= itemToBuy.getPrice()) {
//			If they have enough money, check the item has stock
			if (amountRemaining > 0) {
//				Remove money, add item to player inventory and decrease the stock
				environment.addMoney(-itemToBuy.getPrice());			
				environment.addItems(itemIndex);	
				environment.getPurchasableItems().set(itemIndex, amountRemaining - 1);
			}
		}
	}
	
	
	
	/**
	 * The player sells an athlete
	 * 
	 * @param athleteToSell		The athlete the player wants to sell 
	 */
	public void sellAthlete(Athlete athleteToSell) {
//		Remove athlete from player's club and add money
		playerClub.removePlayer(athleteToSell);
		environment.addMoney(athleteToSell.getPrice());
	}
	

}
