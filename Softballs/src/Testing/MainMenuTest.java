package Testing;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;

import Main.GameEnvironment;
import Main.Athlete;
import Main.Club;
import Main.MainMenuUI;
import Main.EndScreenUI;

/**
 * Run and test that the main game finishes when end week is met
 * 
 * @author Tobias Paull
 *
 */
public class MainMenuTest {
	
	/**
	 * Testing that game finishes when end week is met
	 */
	@Test
	public void endScreenTest() {
		GameEnvironment mainGame = new GameEnvironment();
		mainGame.setClub(new Club());
		mainGame.refresh();
		
		//Create end week, and set money such that money end isn't triggered
		mainGame.setEndWeek(2);
		mainGame.addMoney(1000);
		
		//Launch MainMenu and progress week
		mainGame.launchMainMenu();
		mainGame.addCurrentWeek();
		mainGame.addCurrentWeek();
		
		//Test that game has ended
		assertEquals(mainGame.checkFinish(), true);
	}
	

}
