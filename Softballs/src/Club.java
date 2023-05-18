import java.util.ArrayList;

public class Club {
	
	private String name;
	private boolean isPlayer = false;
	private ArrayList<Athlete> athletes = new ArrayList<Athlete>();
	private ArrayList<Athlete> reserves = new ArrayList<Athlete>();
	private ArrayList<Athlete> batters = new ArrayList<Athlete>();
	private ArrayList<Athlete> pitchers = new ArrayList<Athlete>();
	
	public Club(int currentWeek) {
		for (int i = 0; i < 12; i++) {
			athletes.add(new Athlete(currentWeek));
			this.setPitchers(athletes.subList(0, 2));
			this.setBatters(athletes.subList(2, 7));
			this.setReserves(athletes.subList(7, 12));
			
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
	
	public void setAthletes(ArrayList<Athlete> newAthletes) {
		athletes = newAthletes;
	}
	
	public void setReserves(ArrayList<Athlete> newAthletes) {
		reserves = newAthletes;
	}
	
	public void setBatters(ArrayList<Athlete> newAthletes) {
		batters = newAthletes;
	}
	
	public void setPitchers(ArrayList<Athlete> newAthletes) {
		pitchers = newAthletes;
	}	
	
	public boolean getIsPlayer() {
		return isPlayer;
	}
	
	public void setIsPlayer(boolean newIsPlayer) {
		isPlayer = newIsPlayer;		
	}
}
