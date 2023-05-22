import java.util.ArrayList;


/**
 * Player takes a bye and refreshes market, opponents and athletes stamina
 * Random events may or may not happen
 * @author Tobias Paull
 *
 */
public class Bye {
	/**
	 * Game environment
	 */
	private GameEnvironment environment;
	/**
	 * players club 
	 */
	private Club playerClub;
	/**
	 * Array list of athletes that are quitting to random event
	 */
	private ArrayList<Athlete> quitingAthletes = new ArrayList<Athlete>();
	/**
	 * Array list of athletes who's stats are increasing due to random event
	 */
	private ArrayList<Athlete> increasingAthletes = new ArrayList<Athlete>();

	
	
	

//Constructor
	
	/**
	 * sets values and creates class
	 * @param newEnvironment: the game environment
	 */
	public Bye(GameEnvironment newEnvironment) {
		environment = newEnvironment;
		playerClub = environment.getClub();
	}
	
	/**
	 * Player takes a bye and refreshes market, opponents and athletes stamina
	 * Chance for random event to occurs are calculated
	 * @param trainingAthlete: Athlete selected for special training
	 */
	public void takeBye(Athlete trainingAthlete) {
		environment.addCurrentWeek();
		//Increase Stats of selected player
		ArrayList<Integer> trainedStats = new ArrayList<Integer>();
		trainedStats.add(10);
		trainedStats.add(10);
		trainedStats.add(10);
		trainedStats.add(10);
		trainingAthlete.addStats(trainedStats);

		//Amount a players stats will increase if random event happens
		ArrayList<Integer> chanceStats = new ArrayList<Integer>();
		chanceStats.add(5);
		chanceStats.add(5);
		chanceStats.add(5);
		chanceStats.add(5);
		
		//For every player in club check if random event will occur
		for (Athlete currentAthlete : playerClub.getAthletes()) {
			var quitRoll = Math.random();
			var statRoll = Math.random();

			//Random event of increasing players stats
			if (statRoll <= currentAthlete.getChanceToIncrease()) {
				currentAthlete.addStats(chanceStats);
				increasingAthletes.add(currentAthlete);
			}
			//Random event of player leaving team
			if (quitRoll <= currentAthlete.getChanceToQuit()) {
				quitingAthletes.add(currentAthlete);
			}
		}
		//remove players from team who are leaving
		for (Athlete removingAthlete : quitingAthletes) {
			playerClub.removePlayer(removingAthlete);
		}
		
		//Chance for new player joins team only if space in reserves
		if (playerClub.getReserves().size() < 5) {
			var joinRoll = Math.random();
			if (joinRoll <= 0.1) {
				Athlete joinedAthlete = new Athlete(environment.getCurrentWeek());

				playerClub.getAthletes().add(joinedAthlete);
				playerClub.getReserves().add(joinedAthlete);
				environment.refresh();
				//Inform player that random event occured and pass through athlete
				RandomEventUI eventWindow = new RandomEventUI(environment, quitingAthletes, increasingAthletes, joinedAthlete);
				return;
			}
		}
		environment.refresh();
		//Pass through new athlete that is not in team that RandomEventUI will be able to detect and deal with appropriately
		RandomEventUI eventWindow = new RandomEventUI(environment, quitingAthletes, increasingAthletes, new Athlete(0));

		
	}	
}
