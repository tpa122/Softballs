import java.util.ArrayList;

public class Match {
	
	private Club opponent;
	private GameEnvironment environment;
	private int outs = 0;
	private ArrayList<Object> base = new ArrayList <>();	
	
	public Match(GameEnvironment newEnvironment, Club newOpponent) {
		environment = newEnvironment;
		opponent = newOpponent;
		for (int i = 0; i < 4; i++) {
			base.add(0);
		}
		
		this.innings(environment.getClub(), opponent, 0);
		this.innings(opponent, environment.getClub(), 0);
		this.innings(environment.getClub(), opponent, 1);
		this.innings(opponent, environment.getClub(), 1);
		//environment.getClub().addRun();
		System.out.println(environment.getClub().getName() + ": " + environment.getClub().getRuns());
		System.out.println(opponent.getName() + ": " + opponent.getRuns());
		outcome();
		environment.launchMainMenu();
	}
	
	public void outcome() {
		if (environment.getClub().getRuns() > opponent.getRuns()) {
			System.out.println("You Won");
			environment.addMoney(200);
		}
		else {
			System.out.println("You Lost");
		}
	}
	
	public ArrayList<Athlete> innings(Club pitching, Club batting, int half) {
		if (batting == environment.getClub()) {
			//Call GUI batting sprite
			System.out.println("You are Batting");
		}
		else {
			//Call GUI fielding sprite
			System.out.println("You are Fielding");
		}
		
		
		//System.out.println(base);
		ArrayList<Athlete> outList = new ArrayList<Athlete>();
		ArrayList<Athlete> injuryList = new ArrayList<Athlete>();

		
		Athlete pitcher = pitching.getPitchers().get(half);		
		outList.add(pitcher);
		double pitch = pitcher.getStats().get(3);
		double outProb = 0.1 + (pitch /100) * 0.4;	
		
		double fielding = 0;
		for (Athlete current : pitching.getAthletes()) {
			if (!pitching.getReserves().contains(current) && current !=  pitcher) {
				fielding += current.getStats().get(2);				
			}
		}
		fielding = fielding / 6;
		//System.out.println("Batters :" + batting.getBatters());
		//System.out.println("fielding: " + fielding);
		//System.out.println("outProp: " + outProb);
		//System.out.println();


		int current = 0;
		while (outs < 3) {
			while (base.contains(batting.getBatters().get(current)) == true) {
				current = (current + 1) % 5;
			}
			Athlete currentBatter = batting.getBatters().get(current);
			double batProb = (currentBatter.getStats().get(1) - fielding) * 0.2 / 100;
			double tempProb = outProb - batProb;
			
			//System.out.println("CurrentBatter :" + currentBatter);
			//System.out.println("tempProb :" + tempProb);

			var outRoll = Math.random();
			//System.out.println("roll :" + outRoll);

			if (outRoll <= tempProb) {
				outList.add(currentBatter);
				current = (current + 1) % 5;
				outs += 1;
			}
			else {
				var batRoll = Math.random();
				//System.out.println("BatProb :" + batProb);
				//System.out.println("batRoll :" + batRoll);

				
				if (batRoll <= batProb) {
					//System.out.println("HomeRun");
					for (int i = 0; i <=3; i++) {
						batting.addRun();
						base.set(i, 0);
					}
				}
				else if (batRoll <= 0.1 + batProb) {
					//System.out.println("3 Runs");
					this.scoreRun(currentBatter, 3, batting);					
				}
				else if (batRoll <= 0.3 + batProb) {
					//System.out.println("2 Runs");
					this.scoreRun(currentBatter, 2, batting);
				}
				else {
					//System.out.println("1 Runs");
					this.scoreRun(currentBatter, 1, batting);
				}
			}
			//System.out.println();
		}
		outs = 0;
		System.out.println(batting.getName() + ": " + batting.getRuns() + " runs");
		for (int i = 1; i < 4; i++) {
			System.out.println("(Out) " + outList.get(i).getName() + ", (Pitcher) " + outList.get(0).getName());
		}
		System.out.println();
		
		return outList;
	}
	
	
	public void scoreRun(Athlete runScorer, int runs, Club batting) {
		int startIndex = 3 - runs;
		
		for (int i = startIndex + 1; i <= 3; i++) {
			if (base.get(i) instanceof Athlete) {
				batting.addRun();
			}
		}
		
		for (int i = startIndex; i >= 0; i--) {
			base.set(i + runs, base.get(i));
			
		}
		for (int a = 0; a < runs; a++) {
			base.set(a, 0);
		}
		base.set(runs - 1, runScorer);
		
	}
}
