import java.util.ArrayList;

public class Stadium {
	private GameEnvironment environment;
	private ArrayList<Club> opponents = new ArrayList<Club>();
	
	
	public Stadium(GameEnvironment newEnvironment) {
		environment = newEnvironment;
		for (int i = 0; i <= 3; i ++) {
			opponents.add(new Club(environment.getCurrentWeek()));
			
		}
		
	}

}
