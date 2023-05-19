import java.util.ArrayList;

public class Club {
	
	private String name;
	private boolean isPlayer = false;
	private ArrayList<Athlete> athletes = new ArrayList<Athlete>();
	private ArrayList<Athlete> reserves = new ArrayList<Athlete>();
	private ArrayList<Athlete> batters = new ArrayList<Athlete>();
	private ArrayList<Athlete> pitchers = new ArrayList<Athlete>();
	
	public Club() {
		
	}
	
	public Club(int currentWeek) {
		
	}
	
	public Club(String clubName)	{
		name = clubName;
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
}
