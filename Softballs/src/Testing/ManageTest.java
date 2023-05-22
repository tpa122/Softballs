package Testing;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import Main.Manage;
import Main.ManagePlayingUI;
import Main.ManageAthleteUI;
import Main.ManagePositionsUI;
import Main.GameEnvironment;
import Main.Athlete;
import Main.Club;
import Main.Item;


class ManageTest {

	
	@Test
	public void smallTeam() {
		GameEnvironment mainGame = new GameEnvironment();
		mainGame.setClub(new Club());
		Athlete athlete1 = new Athlete(1,1, 50, 50, 50, 50);
		Athlete athlete2 = new Athlete(2,2, 50, 50, 50, 50);
		Athlete athlete3 = new Athlete(3,3, 50, 50, 50, 50);
		
//Set Athletes
		ArrayList<Athlete> newAthletes = new ArrayList<Athlete>();
		newAthletes.add(athlete1);
		newAthletes.add(athlete2);
		newAthletes.add(athlete3);
		mainGame.getClub().setAthletes(newAthletes);
		assertEquals(newAthletes, mainGame.getClub().getAthletes());
		
		
//Set Playing
		ArrayList<Athlete> newPlaying = new ArrayList<Athlete>();
		newPlaying.add(athlete1);
		newPlaying.add(athlete2);
		mainGame.getClub().setPlaying(newPlaying);
		assertEquals(newPlaying, mainGame.getClub().getPlaying());

		
//Set Reserves
		ArrayList<Athlete> newReserves = new ArrayList<Athlete>();
		newReserves.add(athlete3);
		mainGame.getClub().setReserves(newReserves);
		assertEquals(newReserves, mainGame.getClub().getReserves());
		
		
//Set Batting
		ArrayList<Athlete> newBatting = new ArrayList<Athlete>();
		newBatting.add(athlete1);
		newBatting.add(athlete2);
		mainGame.getClub().setBatters(newBatting);
		assertEquals(newBatting, mainGame.getClub().getBatters());
		
		
//Set Pitching
		ArrayList<Athlete> newPitching = new ArrayList<Athlete>();
		newPitching.add(athlete1);
		mainGame.getClub().setPitchers(newPitching);
		assertEquals(newPitching, mainGame.getClub().getPitchers());
		
		
		ArrayList<Athlete> buttonPlaying = new ArrayList<Athlete>();
		buttonPlaying.add(athlete2);
		buttonPlaying.add(athlete3);
		
		Manage testManage = new Manage(mainGame);
		ManagePlayingUI testManageUI = new ManagePlayingUI(mainGame, testManage);
		testManageUI.getChkPlayingCard().doClick();
		testManageUI.getChkReserveCard().doClick();
		testManageUI.getBtnUpdate().doClick();

		
		assertEquals(buttonPlaying, mainGame.getClub().getPlaying());
	}
	
	@Test
	public void useItemTest() {
		GameEnvironment mainGame = new GameEnvironment();
		mainGame.addItems(3);
		mainGame.addItems(0);
		mainGame.setClub(new Club());
		Athlete athlete1 = new Athlete(1,1, 50, 50, 50, 50);

		
//Set Athletes
		ArrayList<Athlete> newAthletes = new ArrayList<Athlete>();
		newAthletes.add(athlete1);

		mainGame.getClub().setAthletes(newAthletes);
		assertEquals(newAthletes, mainGame.getClub().getAthletes());
		
		
//Set Playing
		ArrayList<Athlete> newPlaying = new ArrayList<Athlete>();
		newPlaying.add(athlete1);
		mainGame.getClub().setPlaying(newPlaying);
		assertEquals(newPlaying, mainGame.getClub().getPlaying());


		
		Manage testManage = new Manage(mainGame);
		ManageAthleteUI testManageAthleteUI = new ManageAthleteUI(mainGame, testManage);
		testManageAthleteUI.setSelected(athlete1);
		System.out.println(testManageAthleteUI.getSelectedAthlete());
		

		
		assertEquals(athlete1.getStat(3), 50);
	}
	
	
	
	@Test
	public void updatePositionTest() {
		GameEnvironment mainGame = new GameEnvironment();
		mainGame.setClub(new Club());
		Athlete athlete1 = new Athlete(1,1, 50, 50, 50, 50);

		
//Set Athletes
		ArrayList<Athlete> newAthletes = new ArrayList<Athlete>();
		newAthletes.add(athlete1);

		mainGame.getClub().setAthletes(newAthletes);
		assertEquals(newAthletes, mainGame.getClub().getAthletes());
		
		
//Set Playing
		ArrayList<Athlete> newPlaying = new ArrayList<Athlete>();
		newPlaying.add(athlete1);
		mainGame.getClub().setPlaying(newPlaying);
		assertEquals(newPlaying, mainGame.getClub().getPlaying());

		
//Set Pitching
		ArrayList<Athlete> newPitching = new ArrayList<Athlete>();
		newPitching.add(athlete1);
		mainGame.getClub().setPitchers(newPitching);
		assertEquals(newPitching, mainGame.getClub().getPitchers());


		
		Manage testManage = new Manage(mainGame);
		ManagePositionsUI testManagePositionsUI = new ManagePositionsUI(mainGame, testManage);
		testManagePositionsUI.getBtnUpdatePitchers().doClick();;

			
		assertEquals(new ArrayList<Athlete>(), mainGame.getClub().getPitchers());
	}
	
	
//	Change reserves
//	- Change positions
}
