import java.util.ArrayList;

public class Club {
	
	private String name;
	private boolean isPlayer = false;
	private ArrayList<Athlete> athletes;
	private ArrayList<Athlete> reserves;
	private ArrayList<Athlete> batters;
	private ArrayList<Athlete> pitchers;
	
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
	
	public boolean getIsPlayer() {
		return isPlayer;
	}
	
	public void setIsPlayer(boolean newIsPlayer) {
		isPlayer = newIsPlayer;		
	}
}