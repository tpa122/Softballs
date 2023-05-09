import java.util.ArrayList;


public class Athlete {
	
	private String name;
	private int stanima;
	private int batting;
	private int fielding;
	private int pitching;
	private boolean isInjured;
	private int chanceToQuit;
	private int price;
	
	
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
	
	public int getPrice() {
		return price;
	}	
}
