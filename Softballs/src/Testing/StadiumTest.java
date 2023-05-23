package Testing;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;

import Main.general.Athlete;
import Main.general.GameEnvironment;
import Main.general.Item;
import Main.gui.stadium.MatchUI;
import Main.gui.stadium.StadiumUI;
import Main.menu.Club;
import Main.menu.Match;


/**
 * This class tests that a match can be played and that it can be finished and won.
 * 
 * @author Tobias Paull, Daniel Bensley
 * @version 1.0, May 2023.
 *
 */
class StadiumTest {
	

	/**
	 * Runs a match from the stadium UI
	 */
	@Test
	public void runMatchTest() {
		GameEnvironment mainGame = new GameEnvironment();
		mainGame.setClub(new Club());
		mainGame.refresh();
		
		//Create god team for player
		for (int i = 0; i < 8; i++) {
			Athlete addAthlete = new Athlete(i ,i , 100, 100, 100, 100);
			mainGame.getClub().getAthletes().add(addAthlete);
			if (i < 2) {
				mainGame.getClub().getPlaying().add(addAthlete);
				mainGame.getClub().getPitchers().add(addAthlete);
			}
			//Next 5 are batters
			else if (i < 7) {
				mainGame.getClub().getPlaying().add(addAthlete);
				mainGame.getClub().getBatters().add(addAthlete);
			}
			//Remaining are reserves
			else {
				mainGame.getClub().getReserves().add(addAthlete);
			}
		}
		
		//Launch stadium UI and select opponent 1 to vs in match
		StadiumUI testStadium = new StadiumUI(mainGame);
		testStadium.setSelectedOpponent(mainGame.getOpponents().get(0));
		testStadium.getBtnContinue().doClick();
		
		//Check that opponent 1 has been added to played
		assertEquals(mainGame.getPlayed().contains(mainGame.getOpponents().get(0)), true);
	}
	
	
	/**
	 * This method tests to see that the a match will finish when the end criteria is met
	 */
	@Test
	public void matchSummaryTest() {
		GameEnvironment mainGame = new GameEnvironment();
		mainGame.setClub(new Club());
		mainGame.refresh();
		
		
		for (int i = 0; i < 8; i++) {
			Athlete addAthlete = new Athlete(i ,i , 100, 100, 100, 100);
			mainGame.getClub().getAthletes().add(addAthlete);
			if (i < 2) {
				mainGame.getClub().getPlaying().add(addAthlete);
				mainGame.getClub().getPitchers().add(addAthlete);
			}
			//Next 5 are batters
			else if (i < 7) {
				mainGame.getClub().getPlaying().add(addAthlete);
				mainGame.getClub().getBatters().add(addAthlete);
			}
			//Remaining are reserves
			else {
				mainGame.getClub().getReserves().add(addAthlete);
			}
		}
		//Set the players runs greater than the opponents
		mainGame.getClub().addRun();
		
		//Create a new match in its final stage
		Match testMatch = new Match(mainGame, mainGame.getOpponents().get(0));
		testMatch.innings(mainGame.getClub(), mainGame.getOpponents().get(0), 3);
		MatchUI testMatchUI = new MatchUI(mainGame, testMatch, 3);
		//Click continue in the UI
		testMatchUI.getBtnContinue().doClick();		
		
		//Coverage shows that matchSummary was opened
	}


}
