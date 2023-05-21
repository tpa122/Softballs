import java.util.ArrayList;

public class Item {
	
	private String name;
	private int stamina = 0;
	private int batting = 0;
	private int fielding = 0;
	private int pitching = 0;
	private int price = 10;

	

	
// Constructor
	
	public Item(int itemType)	{
		if (itemType == 0) {
			stamina = 10;
			name = "Treadmill";
		} else if (itemType == 1) {
			batting = 10;
			name = "Big Bat";
		} else if (itemType == 2) {
			fielding = 10;
			name = "Glove of Grace";
		} else {
			pitching = 10;
			name = "Wrist Roller";
		}
	}
	
	public String toString() {
		return getName() + getStats();
	}
	
	

// Getters
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Integer> getStats() {
		ArrayList<Integer> statsList = new ArrayList<Integer>();
		statsList.add(stamina);
		statsList.add(batting);
		statsList.add(fielding);
		statsList.add(pitching);
		
		return statsList;
	}
	
	public int getPrice()	{
		return price;
	}
}
