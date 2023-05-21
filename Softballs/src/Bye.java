import java.util.ArrayList;


public class Bye {
	private GameEnvironment environment;
	private Club playerClub;
	private ArrayList<Athlete> quitingAthletes = new ArrayList<Athlete>();
	private ArrayList<Athlete> increasingAthletes = new ArrayList<Athlete>();

	
	
	

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
		

		for (Athlete currentAthlete : playerClub.getAthletes()) {
			var quitRoll = Math.random();
			var statRoll = Math.random();


			if (statRoll <= currentAthlete.getChanceToIncrease()) {
				currentAthlete.addStats(chanceStats);
				increasingAthletes.add(currentAthlete);
			}
			if (quitRoll <= currentAthlete.getChanceToQuit()) {
				quitingAthletes.add(currentAthlete);
			}
		}
		
		for (Athlete removingAthlete : quitingAthletes) {
			playerClub.removePlayer(removingAthlete);
		}
		
		//Chance for new player joins team
		if (playerClub.getReserves().size() < 5) {
			var joinRoll = Math.random();
			if (joinRoll <= 0.1) {
				Athlete joinedAthlete = new Athlete(environment.getCurrentWeek());

				playerClub.getAthletes().add(joinedAthlete);
				playerClub.getReserves().add(joinedAthlete);
				environment.refresh();
				RandomEventUI eventWindow = new RandomEventUI(environment, quitingAthletes, increasingAthletes, joinedAthlete);
				return;
			}
		}
		environment.refresh();
		RandomEventUI eventWindow = new RandomEventUI(environment, quitingAthletes, increasingAthletes, new Athlete(0));

		
	}	
}
