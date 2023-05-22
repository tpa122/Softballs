package Main;
import java.util.ArrayList;
import java.util.Random;

/**
 * Club that stores athletes and the positions of said athletes
 * @author Tobias Paull
 *
 */
public class Club {
//Names
	/**
	 * Possible "first names" for the club
	 */
	private static String[] firstNames = {"Golden", "Savage", "Midnight", "Diamond", "The", "Cosmic", "Atomic", "Golden"};	
	/**
	 * Possible "last names" for the club
	 */
	private static String[] lastNames = {"Eagles", "Rhinos", "Titans", "Mavericks", "Elephants", "Raptors", "Tigers", "Pistons", "Panthers"};
	
//Info and pos
	/**
	 * Name of club
	 */
	private String name;
	/**
	 * ArrayList of all athletes in the Club
	 */
	private ArrayList<Athlete> athletes = new ArrayList<Athlete>();
	/**
	 * ArrayList of all playing athletes in the club
	 */
	private ArrayList<Athlete> playing = new ArrayList<Athlete>();
	/**
	 * ArrayList of all reserve athletes in the club
	 */
	private ArrayList<Athlete> reserves = new ArrayList<Athlete>();
	/**
	 * ArrayList of all batting athletes in the club
	 */
	private ArrayList<Athlete> batters = new ArrayList<Athlete>();
	/**
	 * ArrayList of all pitching athletes in the club
	 */
	private ArrayList<Athlete> pitchers = new ArrayList<Athlete>();
	
//Stadium specific
	/**
	 * Number of runs scored (Used in match)
	 */
	private int runs = 0;

	
	
	
//Create opponent Club
	
	/**
	 * Creates a Club with athletes and a random name
	 * Changes depending on week and difficulty
	 * @param currentWeek: current week in the game
	 * @param difficulty: difficulty the player has selected
	 */
	public void opponentClub(int currentWeek, int difficulty) {	
		//Randomly create name
		Random rand  = new Random();
		name = firstNames[rand.nextInt(firstNames.length)] + " " + lastNames[rand.nextInt(lastNames.length)];
		
		//Create 10 new random athletes
		for (int i = 0; i < 10; i++) {
			//Pass through difficulty, on hard the athletes will be harder
			Athlete addAthlete = new Athlete(currentWeek, true, difficulty);
			//First 2 athletes become pitchers
			athletes.add(addAthlete);
			if (i < 2) {
				playing.add(addAthlete);
				pitchers.add(addAthlete);
			}
			//Next 5 are batters
			else if (i < 7) {
				playing.add(addAthlete);
				batters.add(addAthlete);
			}
			//Remaining are reserves
			else {
				reserves.add(addAthlete);
			}
		}
	}

	
//Getters	
	
	/**
	 * Gets name of club
	 * @return name of club
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets list of athletes in the club
	 * @return list of athletes in the club
	 */
	public ArrayList<Athlete> getAthletes(){
		return athletes;
	}
	
	/**
	 * Gets list of reserve athletes in the club
	 * @return list of reserve athletes in the club
	 */
	public ArrayList<Athlete> getReserves(){
		return reserves;
	}
	
	/**
	 * Gets list of batting athletes in the club
	 * @return list of batting athletes in the club
	 */
	public ArrayList<Athlete> getBatters(){
		return batters;
	}
	
	/**
	 * Gets list of pitching athletes in the club
	 * @return list of pitching athletes in the club
	 */
	public ArrayList<Athlete> getPitchers(){
		return pitchers;
	}
	
	/**
	 * Gets list of playing athletes in the club
	 * @return list of playing athletes in the club
	 */
	public ArrayList<Athlete> getPlaying(){
		return playing;
	}
	
	
	/**
	 * Gets number of runs scored
	 * @return number of runs scored
	 */
	public int getRuns() {
		return runs;
	}

	
	/**
	 * Gets number of athletes in the team
	 * @return number of athletes in the team
	 */
	public int getTeamSize()	{
		return athletes.size();
	}
	

//Setters and Adders
	
	/**
	 * Sets new name of club
//	 * @param newName: new name of club
	 */
	public void setName(String newName) {
		name = newName;
	}
	
	/**
	 * Sets new list of athletes 
	 * @param newAthletes: new list of athletes 
	 */
	public void setAthletes(ArrayList<Athlete> newAthletes) {
		athletes = newAthletes;
	}
	
	/**
	 * Sets new playing line up
	 * @param newPlayers: new playing line up
	 */
	public void setPlaying(ArrayList<Athlete> newPlayers) {
		playing = newPlayers;
	}
	
	/**
	 * Sets new reserves line up
	 * @param newReserves: new reserves line up
	 */
	public void setReserves(ArrayList<Athlete> newReserves) {
		reserves = newReserves;
	}
	
	/**
	 * Sets new batting athletes
	 * @param newBatters: new batting athletes
	 */
	public void setBatters(ArrayList<Athlete> newBatters) {
		batters = newBatters;
	}
	
	/**
	 * Sets new pitching athletes
	 * @param newPitchers: new pitching athletes
	 */
	public void setPitchers(ArrayList<Athlete> newPitchers) {
		pitchers = newPitchers;
	}
	
	
	/**
	 * Adds one run to clubs run count
	 */
	public void addRun() {
		runs += 1;
	}
	
	/**
	 * Resets clubs run count
	 */
	public void resetRuns() {
		runs = 0;
	}
	
	

//Others
	
	/**
	 * Swaps an athlete that is playing with one who is not
	 * The positions of the initially playing athlete are transfered to the new athlete
	 * @param playingA: Athlete that is currently playing
	 * @param newplaying: Athlete that is not currently playing
	 */
	public void swapPlayers(Athlete playingA, Athlete newplaying) {
		int playingIndex = playing.indexOf(playingA);
		
		//Set the new player on playing
		playing.set(playingIndex, newplaying);
		
		//Transfer positions
		reserves.add(playingA);
		if (reserves.contains(newplaying)) {
			reserves.remove(newplaying);
		}
		if (batters.contains(playingA)) {
			int battersIndex = batters.indexOf(playingA);
			batters.set(battersIndex, newplaying);
		}
		if (pitchers.contains(playingA)) {
			int pitchersIndex = pitchers.indexOf(playingA);
			pitchers.set(pitchersIndex, newplaying);
		}
	}
	
	/**
	 * remove player from team and all of their positions
	 * @param removing: player to be removed from team
	 */
	public void removePlayer(Athlete removing) {
		//Check if athlete is in given position of line up and remove 
		if (athletes.contains(removing)) {
			athletes.remove(removing);
		}
		if (playing.contains(removing)) {
			playing.remove(removing);			
		}
		if (batters.contains(removing)) {
			batters.remove(removing);
		}
		if (pitchers.contains(removing)) {
			pitchers.remove(removing);
		}
		if (reserves.contains(removing)) {
			reserves.remove(removing);
		}
	}
}
