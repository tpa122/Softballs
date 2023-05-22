package Main;
import java.util.ArrayList;


/**
 * Allows the player to change elements of club such as
 * Team name, reserved squad, positions, athlete names and use items
 * @author Tobias Paull
 *
 */
public class Manage {
	/**
	 * Game environment
	 */
	private GameEnvironment  environment;
	/**
	 * The club of the player
	 */
	private Club playerClub;
	
	
	
//Constructor

	/**
	 * sets values
	 * @param newEnvironment: the game environment
	 */
	public Manage(GameEnvironment newEnvironment) {
		environment = newEnvironment;
		playerClub = environment.getClub();
	}
	

	
//Methods
	
	/**
	 * sets the playing line up to new line up
	 * @param playersList: new Playing line up
	 */
	public void setPlayers(ArrayList<Athlete> playersList) {
		playerClub.setPlaying(playersList);
	}
	
	
	/**
	 * removes player from playing
	 * @param newReserve: playing being added to reserve
	 */
	public void setPlayerReserve(Athlete newReserve) {
		//If they are in playing them remove
		if (playerClub.getPlaying().contains(newReserve)) {
			playerClub.getPlaying().remove(newReserve);
		}
	
	}
	
	/**
	 * Updates reserve line up
	 * @param newReserves: New Reserve line up
	 */
	public void setReserves(ArrayList<Athlete> newReserves) {
		//Add all players to reserve
		for (Athlete currentReserve : newReserves) {
			setPlayerReserve(currentReserve);
		}
		
		playerClub.setReserves(newReserves);
	}
	
	
	/**
	 * Updates the playing line up to selected
	 * @param newPlaying new playing line up
	 */
	public void setPlaying(ArrayList<Athlete> newPlaying) {
		//If athlete in playing but not in new then add to reserve
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
		//If athlete is in reserve who is in new line up then remove them
		for (Athlete newPlayer : newPlaying) {
			if (playerClub.getReserves().contains(newPlayer)) {
				playerClub.getReserves().remove(newPlayer);
			}
		}
		//Set new line up
		playerClub.setPlaying(newPlaying);
	}
	
	
	
	
	/**
	 * uses an item to enhance an Athletes stats
	 * @param itemIndex: type of item being used
	 * @param selectedAthlete: Athlete selected
	 */
	public void useItem(int itemIndex, Athlete selectedAthlete) {
		Item itemUsed = new Item(itemIndex);
		environment.removeItem(itemIndex);
		selectedAthlete.addStats(itemUsed.getStats());
	}
	
	
	
	

}
