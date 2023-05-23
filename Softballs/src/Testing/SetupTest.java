package Testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import Main.general.GameEnvironment;
import Main.general.Setup;
import Main.gui.setup.SetupUI;

/**
 * JUnit testing of setting up a game and checking the game environment
 * is holding the player's specified game length, difficulty and club name
 * 
 * @author Tobias Paull, Daniel Bensley
 * @version 1.0, May 2023.
 *
 */
class SetupTest {

	/**
	 * Tests the players' inputed game specifications match
	 * the variables stored in the game environment
	 */
	@Test
	public void setupGameTest() {
		GameEnvironment mainGame = new GameEnvironment();
		Setup setupGame = new Setup(mainGame);
		setupGame.setClubName("Test Club");
		setupGame.chooseWeek(10);
		setupGame.chooseDifficulty("0");
		assertEquals("Test Club", mainGame.getClub().getName());
		assertEquals(10, mainGame.getEndWeek());
		assertEquals(0, mainGame.getDifficulty());
	}


}
