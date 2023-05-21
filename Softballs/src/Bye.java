import java.util.ArrayList;


public class Bye {
	private GameEnvironment environment;
	private Club playerClub;
	
	
	

//Constructor
	
	Bye(GameEnvironment newEnvironment) {
		environment = newEnvironment;
		playerClub = environment.getClub();
	}
	
	public void takeBye(Athlete trainingAthlete) {
		environment.addCurrentWeek();
		//Increase Stats of selected player
		ArrayList<Integer> trainedStats = new ArrayList<Integer>();
		trainedStats.add(10);
		trainedStats.add(10);
		trainedStats.add(10);
		trainedStats.add(10);
		trainingAthlete.addStats(trainedStats);

		//Chance for players to quit and increase
		ArrayList<Integer> chanceStats = new ArrayList<Integer>();
		chanceStats.add(5);
		chanceStats.add(5);
		chanceStats.add(5);
		chanceStats.add(5);
		
		ArrayList<Athlete> removeList = new ArrayList<Athlete>();

		for (Athlete currentAthlete : playerClub.getAthletes()) {
			var quitRoll = Math.random();
			var statRoll = Math.random();


			if (statRoll <= currentAthlete.getChanceToIncrease()) {
				currentAthlete.addStats(chanceStats);
			}
			if (quitRoll <= currentAthlete.getChanceToQuit()) {
				removeList.add(currentAthlete);
			}
		}
		
		for (Athlete removingAthlete : removeList) {
			playerClub.removePlayer(removingAthlete);
		}
		
		//Chance for new player joins team
		if (playerClub.getReserves().size() < 5) {
			var joinRoll = Math.random();
			if (joinRoll <= 0.1) {
				Athlete joinedAthlete = new Athlete(environment.getCurrentWeek());
				playerClub.getAthletes().add(joinedAthlete);
				playerClub.getReserves().add(joinedAthlete);
			}
		}
		
		environment.refresh();
	}	
}
