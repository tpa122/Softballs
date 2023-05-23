package Testing;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;



import Main.Market;
import Main.GameEnvironment;
import Main.MarketUI;
import Main.Athlete;
import Main.SellAthletesUI;


/**
 * This JUnit test will test the selling of Athlete and items, checking
 * that they have been removed from the player inventory.
 * 
 * @author Tobias Paull, Daniel Bensley
 * @version 1.0, May 2023.
 *
 */
class MarketTest {
	GameEnvironment mainGame = new GameEnvironment();
	Market mainMarket = new Market(mainGame);
	MarketUI testMarketUI = new MarketUI(mainGame, mainMarket);
	SellAthletesUI sellAthletes = new SellAthletesUI(mainGame, mainMarket);
	
	
	
	/**
	 * launches the sell Athlete UI and sells an athlete in the
	 * 3rd position in the player team
	 */
//	@Test
//	void launchSellAthletes() {
//		System.out.println("Start launchSellAthletes");
//		ArrayList<Athlete> tempAthletes = new ArrayList<Athlete>();
//		for(int i = 0; i<10; i++) {
//			tempAthletes.add(new Athlete(1));
//		}
//		System.out.println(tempAthletes);
//		mainGame.getClub().setAthletes(tempAthletes);
//		Athlete athleteToSell = tempAthletes.get(3);
//		sellAthletes.setAthleteToSell(athleteToSell);
//		sellAthletes.getSellAthleteButton().doClick();
//		tempAthletes.remove(3);
//		assertEquals(mainGame.getClub().getAthletes(), tempAthletes);
//		
//
//	}
	

	/**
	 * Launches the sell Items UI and sells an item
	 */
	@Test
	void launchSellItems()	{
		
	}

}
