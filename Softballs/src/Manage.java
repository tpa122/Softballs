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
	
	
	public void setPlayerReserve(Athlete newReserve) {
		if (playerClub.getPlaying().contains(newReserve)) {
			playerClub.getPlaying().remove(newReserve);
		}
	
	}
	
	public void setReserves(ArrayList<Athlete> newReserves) {
		for (Athlete currentReserve : newReserves) {
			setPlayerReserve(currentReserve);
		}
		
		playerClub.setReserves(newReserves);
	}
	
	
	public void setPlaying(ArrayList<Athlete> newPlaying) {
		for (Athlete currentPlayer : playerClub.getPlaying()) {
			if (!newPlaying.contains(currentPlayer)) {
				if (playerClub.getBatters().contains(currentPlayer)) {
					playerClub.getBatters().remove(currentPlayer);
				}
				if (playerClub.getPitchers().contains(currentPlayer)) {
					playerClub.getPitchers().remove(currentPlayer);
				}
				playerClub.getReserves().add(currentPlayer);
			}
			
		}
		for (Athlete newPlayer : newPlaying) {
			if (playerClub.getReserves().contains(newPlayer)) {
				playerClub.getReserves().remove(newPlayer);
			}
		}
		
		playerClub.setPlaying(newPlaying);
	}
	
	
	
	
	public void useItem(int itemIndex, Athlete selectedAthlete) {
		Item itemUsed = new Item(itemIndex);
		environment.removeItem(itemIndex);
		selectedAthlete.addStats(itemUsed.getStats());
	}
	
	
	
	

}
