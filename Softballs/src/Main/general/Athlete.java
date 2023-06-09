package Main.general;
import java.util.ArrayList;
import java.util.Random;


/**
 * The Athlete class holds the information of a given Athlete
 * Athletes have different stats that will affect how different areas of the game behave
 *
 *
 * @author Tobias Paull, Daniel Bensley
 * @version 1.0, May 2023.
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
	 * Is higher if they perform better
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

		//Randomly create a base stat and then add more depending on the current week
		int baseStat = rand.nextInt(11);
		baseStat = baseStat + 15 + currentWeek;
		baseStat = baseStat * 10;
		for (int i = 0; i <= baseStat; i ++) {
			//Randomly assign a stat to one of the 4 types
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

		//Set the current stamina to the max
		refreshStanima();
	}




	/**
	 * Constructor for the Athlete class depending on the week and difficulty
	 *
	 * @param currentWeek 	The current week in the season, determines strength of Athlete
	 * @param opponent 	Specifies that the athlete is being made for an opponent team
	 * @param difficulty	The difficulty of the game, determines the strength of the Athlete
	 */
	public Athlete(int currentWeek, boolean opponent, int difficulty) {
		Random rand  = new Random();
		name = firstNames[rand.nextInt(firstNames.length)] + " " + lastNames[rand.nextInt(lastNames.length)];

		int baseStat = rand.nextInt(11);
		baseStat = baseStat + 15 + currentWeek;
		//If the difficulty is hard then make the stats higher
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


	/**
	 * Used for making fixed Athletes in JUnit tests
	 *
	 * @param firstName: index of the Athletes first name
	 * @param lastName: index of the Athletes last name
	 * @param stam: Athletes stamina stat
	 * @param bat: Athletes batting stat
	 * @param field: Athletes fielding stat
	 * @param pitch: Athletes stamina stat
	 */
	public Athlete(int firstName, int lastName, int stam, int bat, int field, int pitch) {
		//Randomly picks first and last name
		name = firstNames[firstName] + " " + lastNames[lastName];

		//Randomly create a base stat and then add more depending on the current week
		stanima = stam;
		batting = bat;
		fielding = field;
		pitching = pitch;

		//Set the current stamina to the max
		refreshStanima();
	}




	/**
	 *Displays the name and stats of athlete when printed
	 */
	public String toString() {
		return this.getName() + this.getStats();
	}


//Getters

	/**
	 * Gets the name of the Athlet
	 * @return 	the name of the Athlete
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the current stamina of the athlete
	 * @return the current stamina of the athlete
	 */
	public int getCurrentStanima() {
		return currentStanima;
	}

	/**
	 * Gets the stats of the Athlete in an ArrayList
	 * @return the stats of the Athlete in an ArrayList
	 */
	public ArrayList<Integer> getStats() {
		ArrayList<Integer> statsList = new ArrayList<Integer>();
		statsList.add(stanima);
		statsList.add(batting);
		statsList.add(fielding);
		statsList.add(pitching);

		return statsList;
	}

	/**
	 * Gets the requested stat value
	 * @param statNum the index of the stat
	 * @return the requested stat value
	 */
	public int getStat(int statNum) {
		ArrayList<Integer> statsList = new ArrayList<Integer>();
		statsList.add(stanima);
		statsList.add(batting);
		statsList.add(fielding);
		statsList.add(pitching);

		return statsList.get(statNum);
	}



	/**
	 * Gets the price of the Athlete
	 * @return the price of the Athlete
	 */
	public int getPrice() {
		//Calculates the price of the Athlete
		int totalStats = stanima + batting + fielding + pitching;
		float floatPrice = 20 + totalStats / 4;
		return Math.round(floatPrice);
	}


	/**
	 * Gets if the athlete is injured or not
	 * @return if the athlete is injured or not
	 */
	public boolean getIsInjured() {
		return isInjured;
	}

	/**
	 * Gets the probability that the athlete quits the team when a bye is taken
	 * @return the probability that the athlete quits the team when a bye is taken
	 */
	public double getChanceToQuit() {
		return chanceToQuit;
	}

	/**
	 * Gets the probability that the athlete stats are increased when a bye is taken
	 * @return the probability that the athlete stats are increased when a bye is taken
	 */
	public double getChanceToIncrease() {
		return chanceToIncrease;
	}


//Setters and Adders

	/**
	 * Sets the new Athlete name
	 * @param new Athlete name
	 */
	public void setName(String newName) {
		name = newName;
	}

	/**
	 * Refreshed the athletes current stamina to full
	 */
	public void refreshStanima() {
		isInjured = false;
		chanceToQuit = 0;
		chanceToIncrease = 0.02;
		currentStanima = stanima;
	}

	/**
	 * Reduce the athletes current stamina by a given amount
	 * Sets athlete to injured if reaches 0
	 * @param amount that the current stamina is reduced by
	 */
	public void drainStanima(int amount) {
		currentStanima -= amount;
		//Sets athlete to injured if stamina reaches 0
		if (currentStanima <= 0) {
			currentStanima = 0;
			setIsInjured(true);
		}
	}

	/**
	 * Adds specified stats to the athlete
	 * @param list of stats and how much they should be added
	 */
	public void addStats(ArrayList<Integer> newList) {
		stanima += newList.get(0);
		batting += newList.get(1);
		fielding += newList.get(2);
		pitching += newList.get(3);

		// Set limit of 100 for each stat
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


	/**
	 * Sets the athlete to injured or not
	 * @param whether athlete is injured or not
	 */
	public void setIsInjured(boolean setInjury) {
		isInjured = setInjury;
		//Add chance to quit because was injured
		addChanceToQuit(0.02);
	}

	/**
	 * Sets chance to quit to given amount
	 * @param amount that chance to quit will be set to
	 */
	public void addChanceToQuit(double addedChance) {
		chanceToQuit = addedChance;
	}

	/**
	 * Chance to increase will be increased by a given amounts
	 * @param amount that chance to increase will be increased by
	 */
	public void addChanceToIncrease(double addedChance) {
		chanceToIncrease += addedChance;
	}


}
