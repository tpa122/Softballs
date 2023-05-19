import java.util.ArrayList;
import java.util.Random;

public class Club {
	
	private static String[] firstNames = {"Golden", "Savage", "Midnight", "Diamond", "The", "Cosmic", "Atomic", "Golden"};	
	private static String[] lastNames = {"Eagles", "Rhinos", "Titans", "Mavericks", "Elephants", "Raptors", "Tigers", "Pistons", "Panthers"};
	private String name;
	private boolean isPlayer = false;
	private ArrayList<Athlete> athletes = new ArrayList<Athlete>();
	private ArrayList<Athlete> reserves = new ArrayList<Athlete>();
	private ArrayList<Athlete> batters = new ArrayList<Athlete>();
	private ArrayList<Athlete> pitchers = new ArrayList<Athlete>();
	private int runs = 0;
	
	
	public void opponentClub(int currentWeek) {		
		Random rand  = new Random();
		name = firstNames[rand.nextInt(firstNames.length)] + " " + lastNames[rand.nextInt(lastNames.length)];
		
		for (int i = 0; i < 12; i++) {
			Athlete addAthlete = new Athlete(currentWeek);
			athletes.add(addAthlete);
			if (i < 2) {
				pitchers.add(addAthlete);
			}
			else if (i < 7) {
				batters.add(addAthlete);
			}
			else {
				reserves.add(addAthlete);
			}
		}
	}
	
	
	public String getName() {
		return name;
	}
	
	
	public void setName(String newName) {
		name = newName;
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
	
	public void setAthletes(ArrayList<Athlete> newAthletes) {
		athletes = newAthletes;
	}
	
	public boolean getIsPlayer() {
		return isPlayer;
	}
	
	public void setIsPlayer(boolean newIsPlayer) {
		isPlayer = newIsPlayer;		
	}
	
	public void addRun() {
		runs += 1;
	}
	
	public int getRuns() {
		return runs;
	}
}
