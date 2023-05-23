package Testing;

import static org.junit.jupiter.api.Assertions.*;


import Main.Setup;
import Main.SelectTeam;
import Main.GameEnvironment;
import Main.Athlete;

import org.junit.jupiter.api.Test;


/**
 * This JUnit test will test that the selected athletes by the player 
 * through the UI will be added to their team
 * 
 * @author Daniel Bensley
 * @version 1.0, May 2023.
 *
 */
class StartingAthleteTest {

	/**
	 * Tests the selected athletes to be added to the team
	 */
	@Test
	public void selectAthleteTest() {
//		Set game environment, setup and create setup UI
		GameEnvironment mainGame = new GameEnvironment();
		Setup setupGame = new Setup(mainGame);
		SelectTeam selectTeamUI = new SelectTeam(setupGame, mainGame);
//		Select the first 10 athletes from the initial setup
		for(int i=0; i<10; i++)	{
			Athlete athleteToAdd = setupGame.getStartAthletes().get(i);
			selectTeamUI.addToTeam(athleteToAdd);
			
		}
//		Click the start season button
		selectTeamUI.getSeasonStartButton().doClick();
		assertEquals(selectTeamUI.getChosenAthletes(), mainGame.getClub().getAthletes());
		
		
	}
	
}
