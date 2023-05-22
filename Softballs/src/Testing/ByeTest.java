package Testing;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;

import Main.GameEnvironment;
import Main.Athlete;
import Main.Club;
import Main.Item;
import Main.Bye;
import Main.ByeUI;

class ByeTest {

	@Test
	public void incraseLeaveTest() {
		GameEnvironment mainGame = new GameEnvironment();
		mainGame.setClub(new Club());
		Athlete athlete1 = new Athlete(1,1, 50, 50, 50, 50);
		athlete1.drainStanima(100);
		athlete1.addChanceToQuit(1);
		Athlete athlete2 = new Athlete(2,2, 50, 50, 50, 50);
		athlete2.addChanceToIncrease(1);
		
		
		Bye testBye = new Bye(mainGame);
		ByeUI testByeUI = new ByeUI(mainGame, testBye);
		
	}

}
