import java.util.ArrayList;
import java.util.Scanner;

public class Stadium {
	private GameEnvironment environment;
	//private ArrayList<Club> opponents = new ArrayList<Club>();
	//private ArrayList<Club> played = new ArrayList<Club>();
	public Scanner myObj = new Scanner(System.in);

	
	
	public Stadium(GameEnvironment newEnvironment) {
		environment = newEnvironment;	
		commandLine();
	}
	
//	public ArrayList<Club> getOpponents(){
//		return opponents;
//	}
	
	public void playMatch(Club selectedOp) {
		if (environment.getPlayed().contains(selectedOp)) {
			System.out.println("Already Played");
		}
		else if (environment.getClub().getAthletes().size() < 7) {
			//Display GUI: Not enough players on team
			System.out.println("Not enough players on team");
		}
		else if (environment.getClub().getPitchers().size() < 2) {
			//Display GUI: Not enough pitchers
			System.out.println("Not enough pitchers on team");
		}
		else if (environment.getClub().getBatters().size() < 5) {
			//Display GUI: Not enough batters
			System.out.println("Not enough batters on team");
		}
		else {
			environment.getPlayed().add(selectedOp);
			Match newMatch = new Match(environment, selectedOp);
		}
	}
	
	public void commandLine() {
		System.out.println("0: Main menu");
		System.out.println("Enter the number corresponding to each opponent to vs them");
		System.out.println("1: " + environment.getOpponents().get(0).getName() + ", 2: " + environment.getOpponents().get(1).getName() + ", 3: " + environment.getOpponents().get(2).getName());
		String input = myObj.nextLine();
		if (input.equals("0")) {
			
		}
		else {
			int parsedInput = Integer.parseInt(input);
			playMatch(environment.getOpponents().get(parsedInput - 1));
		}

	}

}
