import java.util.ArrayList;
import java.util.Random;


public class Athlete {
//Names	
	private static String[] firstNames = {"James","Robert", "John", "David", "Sam", "Ben", "Oliver", "Thomas", "Daniel", "Tobias", "Joe", "Guy", "Matt", "Graham", "Steve"};
	private static String[] lastNames = {"Smith", "Anderson", "Jones", "Taylor", "Williams", "Paull", "Bensley", "Allen", "Steel", "Rogers", "Whall", "Brown"};

//Info and Stats
	private String name;
	private int currentStanima;
	private int stanima = 0;
	private int batting = 0;
	private int fielding = 0;
	private int pitching = 0;
	
	private boolean isInjured;
	private double chanceToQuit = 0;
	private double chanceToIncrease = 0.02;
	

	
	
//Constructor
	
	public Athlete(int currentWeek) {		
		Random rand  = new Random();
		name = firstNames[rand.nextInt(firstNames.length)] + " " + lastNames[rand.nextInt(lastNames.length)];
		
		int baseStat = rand.nextInt(11);
		baseStat = baseStat + 15 + currentWeek;
		baseStat = baseStat * 10;
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
		
		refreshStanima();
	}

	public String toString() {
		return this.getName() + this.getStats();
	}
	
	
//Getters	
	
	public String getName() {
		return name;
	}
	
	public int getCurrentStanima() {
		return currentStanima;
	}
	
	public ArrayList<Integer> getStats() {
		ArrayList<Integer> statsList = new ArrayList<Integer>();
		statsList.add(stanima);
		statsList.add(batting);
		statsList.add(fielding);
		statsList.add(pitching);
		
		return statsList;
	}
	
	public int getStat(int statNum) {
		ArrayList<Integer> statsList = new ArrayList<Integer>();
		statsList.add(stanima);
		statsList.add(batting);
		statsList.add(fielding);
		statsList.add(pitching);
		
		return statsList.get(statNum);
	}
	
	
	
	public int getPrice() {
		int totalStats = stanima + batting +fielding + pitching; 
		float floatPrice = 20 + totalStats / 400;
		return Math.round(floatPrice);		
	}
	
	
	public boolean getIsInjured() {
		return isInjured;
	}
	
	public double getChanceToQuit() {
		return chanceToQuit;		
	}
	
	public double getChanceToIncrease() {
		return chanceToIncrease;
	}

	
//Setters and Adders
	
	public void setName(String newName) {
		name = newName;
	}
	
	public void refreshStanima() {
		isInjured = false;
		chanceToIncrease = 0.02;
		currentStanima = stanima;
	}
	
	public void drainStanima(int amount) {
		currentStanima -= amount;
		if (currentStanima <= 0) {
			currentStanima = 0;
			setIsInjured(true);
		}
	}
		
	public void addStats(ArrayList<Integer> newList) {
		stanima += newList.get(0);
		batting += newList.get(1);
		fielding += newList.get(2);
		pitching += newList.get(3);
	}
	
	
	public void setIsInjured(boolean setInjury) {
		isInjured = setInjury;
		addChanceToQuit(0.01);
	}
	
	public void addChanceToQuit(double addedChance) {
		chanceToQuit += addedChance;
	}
	
	public void addChanceToIncrease(double addedChance) {
		chanceToQuit += addedChance;
	}
	
	
}
