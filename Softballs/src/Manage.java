
public class Manage {
	private GameEnvironment  environment;
	private Club playerClub;
	
	
	
//Constructor

	public Manage(GameEnvironment newEnvironment) {
		environment = newEnvironment;
		playerClub = environment.getClub();
	}
	

	
//Methods
	
	public void useItem(Item itemUsed, Athlete selectedAthlete) {
		environment.getItems().remove(itemUsed);
		selectedAthlete.addStats(itemUsed.getStats());
	}
	
	

}
