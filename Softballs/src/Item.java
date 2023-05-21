import java.util.ArrayList;

public class Item {
	
	private String name;
	private int stamina;
	private int batting;
	private int fielding;
	private int pitching;
	private int price;

	

	
// Constructor
	
	public Item(String itemName, int itemStamina, int itemBatting, int itemFielding, int itemPitching, int itemPrice)	{
		name = itemName;
		stamina = itemStamina;
		batting = itemBatting;
		fielding = itemFielding;
		pitching = itemPitching;
		price = itemPrice;
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

	
	
//Setters
	
	public void setName(String newName) {
		name = newName;
	}
		
	public void setStats(ArrayList<Integer> newList) {
		stamina = newList.get(0);
		batting = newList.get(1);
		fielding = newList.get(2);
		pitching = newList.get(3);
	}
}
