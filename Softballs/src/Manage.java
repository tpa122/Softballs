import java.util.ArrayList;


public class Manage {
	private GameEnvironment  environment;
	private Club playerClub;
	
	
	
//Constructor

	public Manage(GameEnvironment newEnvironment) {
		environment = newEnvironment;
		playerClub = environment.getClub();
	}
	

	
//Methods
	
	public void setPlayers(ArrayList<Athlete> playersList) {
		playerClub.setPlaying(playersList);
	}
	
	
	
	
	
	public void useItem(Item itemUsed, Athlete selectedAthlete) {
		environment.getItems().remove(itemUsed);
		selectedAthlete.addStats(itemUsed.getStats());
	}
	
	
	
	

}
