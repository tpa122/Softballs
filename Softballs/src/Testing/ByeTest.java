package Testing;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;

import Main.gui.bye.ByeUI;
import Main.menu.Bye;
import Main.menu.Club;
import Main.general.Athlete;
import Main.general.GameEnvironment;

/**
 * This class runs a and tests to see that random events can occur
 * and that the game season is progressed.
 * 
 * @author Tobias Paull, Daniel Bensley
 * @version 1.0, May 2023.
 *
 */
class ByeTest {

	/**
	 * Create team and take a bye
	 * Random events are guaranteed to happen
	 */
	@Test
	public void incraseLeaveTest() {
		GameEnvironment mainGame = new GameEnvironment();
		mainGame.setClub(new Club());
		
		//Create athlete 1 with a 100% chance to quit
		ArrayList<Athlete> newAthletes = new ArrayList<Athlete>();
		Athlete athlete1 = new Athlete(1,1, 50, 50, 50, 50);
		athlete1.drainStanima(100);
		athlete1.addChanceToQuit(1);
		newAthletes.add(athlete1);
		
		//Create Athlete 2 with a 100% chance for stats to increase
		Athlete athlete2 = new Athlete(2,2, 50, 50, 50, 50);
		athlete2.addChanceToIncrease(1);
		newAthletes.add(athlete2);
		mainGame.getClub().setAthletes(newAthletes);
		
		
		//Generate take a bye
		Bye testBye = new Bye(mainGame);
		ByeUI testByeUI = new ByeUI(mainGame, testBye);
		testByeUI.setTrainingAthlete(athlete2);
		//Click the continue button on take a bye
		testByeUI.getBtnBye().doClick();
		
		//Confirm that player has left team and that week has progressed from 1
		assertEquals(mainGame.getClub().getAthletes().size(), 1);
		assertEquals(2, mainGame.getCurrentWeek());
	}

}
