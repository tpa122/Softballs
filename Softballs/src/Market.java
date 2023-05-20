import java.util.ArrayList;
import java.util.Scanner;


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
	private GameEnvironment environment;
	private Club playerClub;
	public Scanner myObj = new Scanner(System.in);

	/**
	 * The game environment to interact with
	 */

	/**
	 * The player club to send the athletes to
	 */
	/**
	 * The purchasable athletes available on the market
	 */

	/**
	 * The purchasable items available on the market
	 */

	
	
//	On creation of market, generate items and athletes
	public Market(GameEnvironment incomingEnvironment)	{
//		Set initial values for the market
		environment = incomingEnvironment;
		playerClub = environment.getClub();
		//commandLine();
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
						System.out.println("Reserves are full");
					}
					else {
						environment.getPurchasedAthletes().add(athleteToBuy);
						environment.addMoney(-athleteToBuy.getPrice());
						playerClub.getAthletes().add(athleteToBuy);
						playerClub.getReserves().add(athleteToBuy);
					}
				}		
			}	
			else {
				System.out.println("Missing funds required to purchase");
			}
		}	
		else {
			System.out.println("Team already full, sell a member to make room.");
		}
	}
	
	/**
	 * @param itemToBuy			The item the player wants to purchase
	 */
	public void purchaseItem(Item itemToBuy)	{
		int currentFunds = environment.getMoney();
		int itemIndex = environment.getPurchasableItems().indexOf(itemToBuy);
		int amountRemaining = environment.getPurchasedItems().get(itemIndex);

		if (currentFunds >= itemToBuy.getPrice()) {
			if (amountRemaining > 0) {
				environment.addMoney(-itemToBuy.getPrice());			
				environment.getItems().add(itemToBuy);	
				environment.getPurchasedItems().set(itemIndex, amountRemaining - 1);
			}
			else {
				System.out.println("Item sold out");
			}
		}
		else {
			System.out.println("Missing funds required to purchase");
		}
	}
	
	
	public void sellAthlete(Athlete athleteToSell) {
		playerClub.removePlayer(athleteToSell);
		environment.addMoney(athleteToSell.getPrice());
	}
	
	
	public void commandLine() {
		System.out.println("0: Main menu");
		System.out.println(environment.getPurchasableAthletes());
		String input = myObj.nextLine();
		if (input.equals("0")) {
			environment.launchMainMenu();
		}
		else {
			int parsedInput = Integer.parseInt(input);
			purchaseAthlete(environment.getPurchasableAthletes().get(parsedInput - 1), 0);
		}
		
		
	}
}
