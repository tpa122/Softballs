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

	
	public int getTeamSize()	{
		return athletes.size();
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
	

//	Adding an athlete to the team from the market
	public void addAthlete(Athlete athleteToAdd)	{
//		Check if team is not full
		if(athletes.size() < 12 && athletes.size() >= 0)	{
//			If team is not full, add athlete to athletes ArrayList and to                                   ADD TO BATTERS and/or PITCHERS
//			open spot on either batters or pitchers
			athletes.add(athleteToAdd);
		}
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
