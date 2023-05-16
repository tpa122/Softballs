import java.util.ArrayList;
import java.util.Random;


public class Athlete {
		
	private static String[] firstNames = {"James","Robert", "John", "David", "Sam", "Ben", "Oliver", "Thomas", "Daniel", "Tobias", "Joe"};
	private static String[] lastNames = {"Smith", "Anderson", "Jones", "Taylor", "Williams", "Paull", "Bensley", "Allen"};
	private String name;
	private int stanima = 0;
	private int batting = 0;
	private int fielding = 0;
	private int pitching = 0;
	private boolean isInjured;
	private int chanceToQuit = 0;
	private int price;
	
	public Athlete(int currentWeek) {		
		Random rand  = new Random();
		name = firstNames[rand.nextInt(firstNames.length)] + " " + lastNames[rand.nextInt(lastNames.length)];
		
		int baseStat = rand.nextInt(11);
		baseStat = baseStat + 15 + currentWeek;
		baseStat = baseStat * 400 / 40;
		for (int i = 0; i <= baseStat; i ++) {
			int type = rand.nextInt(4);
			if (type == 0 && stanima < 100) {
				stanima ++;
			}
			if (type == 1 && batting< 100) {
				batting ++;
			}
			if (type == 2 && fielding< 100) {
				fielding ++;
			}
			if (type == 3 && pitching< 100) {
				pitching ++;
			}			
		}
		//price = this.calcprice();
	}
	
	public String toString() {
		return this.getName() + this.getStats();
	}
		
	public String getName() {
		return name;
	}
	
	public void setName(String newName) {
		name = newName;
	}
	
	public ArrayList<Integer> getStats() {
		ArrayList<Integer> statsList = new ArrayList<Integer>();
		statsList.add(stanima);
		statsList.add(batting);
		statsList.add(fielding);
		statsList.add(pitching);
		
		return statsList;
	}
	
	public void setStats(ArrayList<Integer> newList) {
		stanima = newList.get(0);
		batting = newList.get(1);
		fielding = newList.get(2);
		pitching = newList.get(3);
		//this.calcprice();
	}
	
	public boolean getIsInjured() {
		return isInjured;
	}
	
	public void setIsInjured(boolean setInjury) {
		isInjured = setInjury;
	}
	
	public int getChanceToQuit() {
		return chanceToQuit;		
	}
	
	public void setChanceToQuit(int newChance) {
		chanceToQuit = newChance;
	}
	
	//public int getPrice() {
		//return price;
	//}	
}
