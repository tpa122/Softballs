package Main;
import java.util.ArrayList;

/**
 * This class holds the methods required to setup the elements in game
 * environment so the player can start the game.
 * 
 * @author Tobias Paull, Daniel Bensley
 * @Version 1.0, May 2023.
 *
 */
public class Setup {
	
	/**
	 * The game environment to interact with
	 */
	public GameEnvironment environment;
	
	/**
	 * The array of starting athletes 
	 */
	private ArrayList<Athlete> startAthletes = new ArrayList<Athlete>();
	
	/**
	 * The array of selected athletes for creating a game
	 */
	private ArrayList<Athlete> selectedAthletes = new ArrayList<Athlete>();

	
	/**
	 * The constructor for the setup class
	 * 
	 * @param incomingEnvironment	The incoming environment to interact with
	 */
	public Setup(GameEnvironment incomingEnvironment) {
//		Set game environment variable to an already created environment
		environment = incomingEnvironment;
//		Generate the starting athletes
		for (int i = 0; i < 15; i++) {
			startAthletes.add(new Athlete(environment.getCurrentWeek()));			
		}
//		Create a new club
		Club newClub = new Club();
		environment.setClub(newClub);
	}

	
	/**
	 * Returns the starting athletes generated at the
	 * start of the game
	 * 
	 * @return			The list of starting athletes
	 */
	public ArrayList<Athlete> getStartAthletes(){
		return startAthletes;
	}
	
	


	
	/**
	 * Returns the list of selected Athletes to join the player's team
	 * 
	 * @return			The list of athletes selected by the player
	 * 					to join their team
	 */
	public ArrayList<Athlete> getSelectedAthletes(){
		return selectedAthletes;
	}
	
	/**
	 * The athlete to add or remove from their selected athletes
	 * 
	 * @param checkedAthlete		Athlete to add/remove from selected athletes
	 */
	public void adjustSelected(Athlete checkedAthlete) {
//		Check if the athlete is checked
		if (selectedAthletes.contains(checkedAthlete)) {
			selectedAthletes.remove(checkedAthlete);
		}
	}
	
	/**
	 * Sets the name of the club
	 * 
	 * @param clubName				The club name to set
	 */
	public void setClubName(String clubName) {
//		Check the name is at least 3 letters long
		if (clubName.length() < 3) {
		    this.setClubName(clubName);
		}
//		Check the name is more than 15 letters long
		else if (clubName.length() > 15) {
		    this.setClubName(clubName);
		}
		else {
			environment.getClub().setName(clubName);			
		}
	}
	
	/**
	 * Sets the length of the season
	 * 
	 * @param weeklLength			The length of the season in weeks
	 */
	public void chooseWeek(int weeklLength) {
		environment.setEndWeek(weeklLength);
	}
	
	/**
	 * Sets the difficulty of the game
	 * 
	 * @param difficultyInt			The difficulty of the game
	 */
	public void chooseDifficulty(String difficultyInt) {
//		Check if normal difficulty chosen
		if (difficultyInt.equals("0")) {
			environment.addMoney(1000);
			environment.setDifficulty(0);
		}
//		Check if hard difficulty chosen
		else if (difficultyInt.equals("1")) {
			environment.addMoney(800);
			environment.setDifficulty(1);
		}
	}
	

	
	/**
	 * Launches the setup UI
	 */
	public void launchSetup() {
//		Launch the Setup window
		SetupUI setupWindow = new SetupUI(this);
	}

	
}
