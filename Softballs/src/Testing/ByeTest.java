package Testing;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;

import Main.GameEnvironment;
import Main.Athlete;
import Main.Club;
import Main.Item;

class ByeTest {

	@Test
	public void incraseLeaveTest() {
		GameEnvironment mainGame = new GameEnvironment();
		mainGame.setClub(new Club());
		Athlete athlete1 = new Athlete(1,1, 50, 50, 50, 50);
		Athlete athlete2 = new Athlete(2,2, 50, 50, 50, 50);
		Athlete athlete3 = new Athlete(3,3, 50, 50, 50, 50);
	}

}
