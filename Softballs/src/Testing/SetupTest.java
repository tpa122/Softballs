package Testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import Main.Setup;
import Main.SetupUI;
import Main.GameEnvironment;

class SetupTest {

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
	
	public void startingAthleteTest() {
		GameEnvironment mainGame = new GameEnvironment();
		Setup setupGame = new Setup(mainGame);
		SetupUI setupWindow = new SetupUI(setupGame);
		//doClick();

		
//		Run setup UI
	}

}
