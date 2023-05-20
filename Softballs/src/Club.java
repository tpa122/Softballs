import java.util.ArrayList;
import java.util.Random;

public class Club {
//Names
	private static String[] firstNames = {"Golden", "Savage", "Midnight", "Diamond", "The", "Cosmic", "Atomic", "Golden"};	
	private static String[] lastNames = {"Eagles", "Rhinos", "Titans", "Mavericks", "Elephants", "Raptors", "Tigers", "Pistons", "Panthers"};
	
//Info and pos
	private String name;
	private ArrayList<Athlete> athletes = new ArrayList<Athlete>();
	private ArrayList<Athlete> playing = new ArrayList<Athlete>();
	private ArrayList<Athlete> reserves = new ArrayList<Athlete>();
	private ArrayList<Athlete> batters = new ArrayList<Athlete>();
	private ArrayList<Athlete> pitchers = new ArrayList<Athlete>();
	
//Stadium specific
	private int runs = 0;

//??
	private boolean isPlayer = false;

	
	
	
//Create opponent Club
	
	public void opponentClub(int currentWeek) {		
		Random rand  = new Random();
		name = firstNames[rand.nextInt(firstNames.length)] + " " + lastNames[rand.nextInt(lastNames.length)];
		
		for (int i = 0; i < 12; i++) {
			Athlete addAthlete = new Athlete(currentWeek);
			athletes.add(addAthlete);
			if (i < 2) {
				playing.add(addAthlete);
				pitchers.add(addAthlete);
			}
			else if (i < 7) {
				playing.add(addAthlete);
				batters.add(addAthlete);
			}
			else {
				reserves.add(addAthlete);
			}
		}
	}

	
//Getters	
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Athlete> getAthletes(){
		return athletes;
	}
	
	public ArrayList<Athlete> getReserves(){
		return reserves;
	}
	
	public ArrayList<Athlete> getBatters(){
		return batters;
	}
	
	public ArrayList<Athlete> getPitchers(){
		return pitchers;
	}
	
	public ArrayList<Athlete> getPlaying(){
		return playing;
	}
	
	
	public int getRuns() {
		return runs;
	}
	
	
	public boolean getIsPlayer() {
		return isPlayer;
	}

	
	public int getTeamSize()	{
		return athletes.size();
	}
	

//Setters and Adders
	
	public void setName(String newName) {
		name = newName;
	}
	
	public void setAthletes(ArrayList<Athlete> newAthletes) {
		athletes = newAthletes;
	}
	
	
	public void addRun() {
		runs += 1;
	}
	
	public void resetRuns() {
		runs = 0;
	}
	
	
	public void setIsPlayer(boolean newIsPlayer) {
		isPlayer = newIsPlayer;		
	}
	

//Others
	
	public void swapPlayers(Athlete playingA, Athlete newplaying) {
		playing.remove(playingA);
		reserves.add(playingA);
		playing.add(newplaying);
		if (reserves.contains(newplaying)) {
			reserves.remove(newplaying);
		}
		if (batters.contains(playingA)) {
			batters.remove(playingA);
			batters.add(newplaying);
		}
		if (pitchers.contains(playingA)) {
			pitchers.remove(playingA);
			pitchers.remove(newplaying);
		}
	}
	
	public void removePlayer(Athlete removing) {
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
