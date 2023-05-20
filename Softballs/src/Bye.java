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
		ArrayList<Integer> increasedStats = new ArrayList<Integer>();
		increasedStats.add(10);
		increasedStats.add(10);
		increasedStats.add(10);
		increasedStats.add(10);
		for (Athlete currentAthlete : playerClub.getAthletes()) {
			var quitRoll = Math.random();
			var statRoll = Math.random();

			if (currentAthlete.getChanceToQuit() <= quitRoll) {
				playerClub.removePlayer(currentAthlete);
			}
			else if (currentAthlete.getChanceToQuit() <= statRoll) {
				currentAthlete.addStats(increasedStats);
			}
		}
		
		//Chance for new player joins team
		if (playerClub.getReserves().size() < 5) {
			var joinRoll = Math.random();
			if (0.1 <= joinRoll) {
				Athlete joinedAthlete = new Athlete(environment.getCurrentWeek());
				playerClub.getAthletes().add(joinedAthlete);
				playerClub.getReserves().add(joinedAthlete);
			}
		}
		
		environment.refresh();
	}	
}
