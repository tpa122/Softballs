import java.util.ArrayList;

public class Setup {
	private GameEnvironment environment;
	private ArrayList<Athlete> startAthletes = new ArrayList<Athlete>();
	
	public Setup(GameEnvironment incomingEnvironment) {
		environment = incomingEnvironment;
		for (int i = 0; i < 15; i++) {
			startAthletes.add(new Athlete(environment.getCurrentWeek()));			
		}
		Club newClub = new Club();
		environment.setClub(newClub);
	}
	
	public ArrayList<Athlete> getStartAthletes(){
		return startAthletes;
	}
	
	public void setClubName(String clubName) {
		environment.getClub().setName(clubName);
	}
	
	public void chooseWeek(int weeklLength) {
		environment.setEndWeek(weeklLength);
	}
	
	public void chooseDifficulty(int difficultyInt) {
		if (difficultyInt == 0) {
			environment.setMoney(1000);
			environment.setDifficulty(0);
		}
		else if (difficultyInt == 1) {
			environment.setMoney(800);
			environment.setDifficulty(1);
		}
		else if (difficultyInt == 2) {
			environment.setMoney(500);
			environment.setDifficulty(2);
		}
	}
	
	public void chooseAthlete(ArrayList<Athlete> selectedAthletes) {
		environment.getClub().setAthletes(selectedAthletes);
	}
	
}
