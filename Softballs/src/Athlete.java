import java.util.ArrayList;
import java.util.Random;


/**
 * The Athlete class holds the information of a given Athlete
 * Athletes have different stats that will affect how different areas of the game behave
 * 
 * 
 * @author Tobias Paull
 *
 */
public class Athlete {
//Names	
	/**
	 * List of possible first names when generating new athlete
	 */
	private static String[] firstNames = {"James","Robert", "John", "David", "Sam", "Ben", "Oliver", "Thomas", "Daniel", "Tobias", "Joe", "Guy", "Matt", "Graham", "Steve"};
	/**
	 * List of possible last names when generating new athlete
	 */
	private static String[] lastNames = {"Smith", "Anderson", "Jones", "Taylor", "Williams", "Paull", "Bensley", "Allen", "Steel", "Rogers", "Whall", "Brown"};

//Info and Stats	
	/**
	 * Name of the Athlete
	 */
	private String name;
	/**
	 * The currentStamina of the Athlete
	 */
	private int currentStanima;
	/**
	 * The maximum stamina of the Athlete
	 */
	private int stanima = 0;
	/**
	 * The batting stat of the Athlete
	 */
	private int batting = 0;
	/**
	 * The fielding stat of the Athlete
	 */
	private int fielding = 0;
	/**
	 * The pitching stat of the Athlete
	 */
	private int pitching = 0;

	/**
	 * Information on whether the Athlete is injured or not 
	 */
	private boolean isInjured;
	/**
	 * The probability that the Athlete will quit when a bye is taken
	 */
	private double chanceToQuit = 0;
	/**
	 * The probability that the Athletes stats will increase when a bye is taken
	 */
	private double chanceToIncrease = 0.02;
	

	
	
//Constructor
	/**
	 * Generates Athlete with random stats and Name
	 * @param currentWeek	The current week in the season, determines strength of Athlete
	 */
	public Athlete(int currentWeek) {
		//Randomly picks first and last name
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
	
	public Athlete(int currentWeek, boolean opponent, int difficulty) {		
		Random rand  = new Random();
		name = firstNames[rand.nextInt(firstNames.length)] + " " + lastNames[rand.nextInt(lastNames.length)];
		
		int baseStat = rand.nextInt(11);
		baseStat = baseStat + 15 + currentWeek;
		if (opponent == true) {
			if (difficulty == 0) {
				baseStat = baseStat * 8;
			}
			else {
				baseStat = baseStat * 10;
			}
		}
		else {
			baseStat = baseStat * 10;
		}
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
		float floatPrice = 20 + totalStats / 4;
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
		chanceToQuit = 0;
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
		if (stanima > 100) {
			stanima = 100;
		}
		if (batting > 100) {
			batting = 100;
		}
		if (fielding > 100) {
			fielding = 100;
		}
		if (pitching > 100) {
			pitching = 100;
		}
	}
	
	
	public void setIsInjured(boolean setInjury) {
		isInjured = setInjury;
		addChanceToQuit(0.03);
	}
	
	public void addChanceToQuit(double addedChance) {
		chanceToQuit = addedChance;
	}
	
	public void addChanceToIncrease(double addedChance) {
		chanceToIncrease += addedChance;
	}
	
	
}
