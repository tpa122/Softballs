import java.util.ArrayList;
import java.util.Scanner;

public class Setup {
	public GameEnvironment environment;
	private ArrayList<Athlete> startAthletes = new ArrayList<Athlete>();
	private ArrayList<Athlete> selectedAthletes = new ArrayList<Athlete>();
	public Scanner myObj = new Scanner(System.in);

	
	public Setup(GameEnvironment incomingEnvironment) {
		environment = incomingEnvironment;
		for (int i = 0; i < 15; i++) {
			startAthletes.add(new Athlete(environment.getCurrentWeek()));			
		}
		Club newClub = new Club();
		environment.setClub(newClub);
//		this.commandLine();
	}

	
	public ArrayList<Athlete> getStartAthletes(){
		return startAthletes;
	}
	
	
	public void displayStartAthletes() {
		for (int i = 0; i < 15; i++) {
			System.out.println(i + ": " + startAthletes.get(i));
		}
	}
	
	public ArrayList<Athlete> getSelectedAthletes(){
		return selectedAthletes;
	}
	
	public void adjustSelected(Athlete checkedAthlete) {
		if (selectedAthletes.contains(checkedAthlete)) {
			selectedAthletes.remove(checkedAthlete);
		}
		else if (selectedAthletes.size() >= 12) {
			System.out.println("Maximum amount selected");
		}
		else {
			selectedAthletes.add(checkedAthlete);
		}
    	System.out.println(this.getSelectedAthletes());
	}
	
	public void setClubName(String clubName) {
		if (clubName.length() < 3) {
			//GUI not long enough
			//Command line
			System.out.println("Not long enough");
		    String teamName = myObj.nextLine();
		    this.setClubName(teamName);
		}
		else if (clubName.length() > 15) {
			//GUI to short
			//Command line
			System.out.println("Too short");
		    String teamName = myObj.nextLine();
		    this.setClubName(teamName);
		}
		else {
			environment.getClub().setName(clubName);			
		}
//		System.out.println("Team name:" + clubName);
	}
	
	public void chooseWeek(int weeklLength) {
		environment.setEndWeek(weeklLength);
	}
	
	public void chooseDifficulty(String difficultyInt) {
		if (difficultyInt.equals("0")) {
			environment.addMoney(1000);
			environment.setDifficulty(0);
		}
		else if (difficultyInt.equals("1")) {
			environment.addMoney(800);
			environment.setDifficulty(1);
		}
		else {
			//Command line
			System.out.println("Invalid");
		    System.out.println("Selected difficulty: 0 Normal, 1 Hard");
		    String inputDiff= myObj.nextLine();
		    this.chooseDifficulty(inputDiff);  
		}
	}
	
	public void chooseAthlete() {
		if (selectedAthletes.size() < 7) {
			//GUI display not enough selected
			System.out.println("Not enough selected");
		    String inputAthletes;
		    inputAthletes = myObj.nextLine();
		    do {
		    	try {		    		
			    int parsedInput = Integer.parseInt(inputAthletes);
		    	this.adjustSelected(startAthletes.get(parsedInput));
			    inputAthletes = myObj.nextLine();
		    	} catch (NumberFormatException e) {
		    		System.out.println("Invalid input");
		    		inputAthletes = myObj.nextLine();
		    	}
		    }
		    while (!inputAthletes.equals("Y"));
		    
		    this.chooseAthlete();
		}
		else {
			environment.getClub().setAthletes(selectedAthletes);
		}
	}
	
	
//	public void commandLine() {
//	    System.out.println("Enter Team Name");
//	    
//	    String teamName = myObj.nextLine();
//	    this.setClubName(teamName);
//	    System.out.println(environment.getClub().getName());
//	    
//	    System.out.println("Selected difficulty: 0 Normal, 1 Hard");
//	    String inputDiff= myObj.nextLine();
//	    this.chooseDifficulty(inputDiff);
//	    
//	    System.out.println("Enter the number corresponding to each athlete to add or remove them from your team");
//	    System.out.println("Type Y to confirm selection");
//	    this.displayStartAthletes();
//	    String inputAthletes;
//	    inputAthletes = myObj.nextLine();
//	    do {
//	    	try {		    		
//	    		int parsedInput = Integer.parseInt(inputAthletes);
//	    		this.adjustSelected(startAthletes.get(parsedInput));
//	    		inputAthletes = myObj.nextLine();
//	    	} catch (NumberFormatException e) {
//	    		System.out.println("Invalid input");
//	    		inputAthletes = myObj.nextLine();
//	    	}
//	    }
//	    while (!inputAthletes.equals("Y"));
//	    
//	    this.chooseAthlete();
//	    environment.closeSetupScreen();
//	}
	
	public void launchSetup() {
		SetupUI setupWindow = new SetupUI(this);
	}
	
	public static void main(String[] args) {
//		GameEnvironment mainGame = new GameEnvironment();
//		mainGame.launchSetup();
	}
	
}
