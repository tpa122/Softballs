package Main;
import java.util.ArrayList;

/**
 * Item can be used to increase the stats of Ahletes
 * 
 * @author Tobias Paull
 *
 */
public class Item {
	
	/**
	 * Name of item
	 */
	private String name;
	/**
	 * amount stamina stat increases when using item
	 */
	private int stamina = 0;
	/**
	 * amount batting stat increases when using item
	 */
	private int batting = 0;
	/**
	 * amount fielding stat increases when using item
	 */
	private int fielding = 0;
	/**
	 * amount pitching stat increases when using item
	 */
	private int pitching = 0;
	/**
	 * price of item
	 */
	private int price = 10;

	

	
// Constructor
	
	/**
	 * Creates the item can be one of 4
	 * @param itemType: determines type of item
	 */
	public Item(int itemType)	{
		if (itemType == 0) {
			stamina = 10;
			name = "Treadmill";
		} else if (itemType == 1) {
			batting = 10;
			name = "Big Bat";
		} else if (itemType == 2) {
			fielding = 10;
			name = "SureField";
		} else {
			pitching = 10;
			name = "Wrist Roller";
		}
	}
	
	/**
	 * Display name and stats of item
	 */
	public String toString() {
		return getName() + getStats();
	}
	
	

// Getters
	
	/**
	 * Gets name of item
	 * @return name of item
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets list of item stats
	 * @return List of item stats
	 */
	public ArrayList<Integer> getStats() {
		ArrayList<Integer> statsList = new ArrayList<Integer>();
		statsList.add(stamina);
		statsList.add(batting);
		statsList.add(fielding);
		statsList.add(pitching);
		
		return statsList;
	}
	
	/**
	 * Gets price of item
	 * @return price of item
	 */
	public int getPrice()	{
		return price;
	}
}
