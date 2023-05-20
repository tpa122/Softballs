import java.util.Scanner;


public class MainMenu {
	private GameEnvironment environment;
	public Scanner myObj = new Scanner(System.in);


	
	
//Constructor
	
	public MainMenu(GameEnvironment newEnvironment) {
		environment = newEnvironment;
		//commandLine();
	}

	
// CommandLine output
	
//	public void commandLine() {
//		System.out.println();
//		System.out.println("Main Menu " + environment.getClub().getName());
//		System.out.println("Week: " + environment.getCurrentWeek() + ", Money :"+ environment.getMoney());
//		System.out.println("0: Stadium, 1: Market, 2: Club");
//		String input = myObj.nextLine();
//		if (input.equals("0")) {
//			environment.launchStadium();
//		}
//		else if (input.equals("1")) {
//			environment.launchMarket();			
//		}
//		else if (input.equals("0")) {
//			
//		}
//		else {
//			System.out.println("Invalid input");
//			input = myObj.nextLine();
//		}
//			
//		
//	}
}
