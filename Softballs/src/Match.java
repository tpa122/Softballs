import java.util.ArrayList;

public class Match {
//Match permanent
	private GameEnvironment environment;
	private Club opponent;
	
	private boolean lostCheck = false;
	

//Innings specific
	private Club batting;
	private Club pitching;
	
	private ArrayList<Athlete> outList = new ArrayList<Athlete>();
	private ArrayList<Athlete> injuryList = new ArrayList<Athlete>();
	private Athlete pitcher;
	private double outProb;
	
	private int outs = 0;
	private ArrayList<Object> base = new ArrayList <>();
	
	
	
	
//Constructor
	
	public Match(GameEnvironment newEnvironment, Club newOpponent) {
		environment = newEnvironment;
		opponent = newOpponent;
		for (int i = 0; i < 4; i++) {
			base.add(0);
		}
	}

	
	
//Getters
	
	public Club getOpponent() {
		return opponent;
	}
	
	
	public Club getBatting() {
		return batting;
	}
	
	public Club getPitching() {
		return pitching;
	}
	
	public ArrayList<Athlete> getOutList(){
		return outList;
	}
	
	public ArrayList<Athlete> getInjuryList(){
		return injuryList;
	}
	
	public String getTeamName(Athlete incomingAthlete) {
		if (batting.getAthletes().contains(incomingAthlete)){
			return batting.getName();
		}
		else {
			return pitching.getName();
		}
		
	}

	
//Other
	
//	public void outcome() {
//		if (environment.getClub().getRuns() > opponent.getRuns()) {
//			System.out.println("You Won");
//			environment.addMoney(200);
//		}
//		else {
//			System.out.println("You Lost");
//		}
//	}
	
//	public void injuryLost() {
//		System.out.println("Lost to injury");
//	}
	
	public boolean playerInjured(Athlete injuredPlayer, Club injuredClub, int drainAmount) {
		injuredPlayer.drainStanima(drainAmount);
		if (injuredPlayer.getIsInjured() == true) {
			injuryList.add(injuredPlayer);
			Athlete reserveSwap = injuredClub.getReserves().get(0);
			if (reserveSwap.getIsInjured() == true) {
				return true;
			}
			else {
				injuryList.add(reserveSwap);
				injuredClub.swapPlayers(injuredPlayer, reserveSwap);
			}
		}
		return false;
				
	}
	
	public void initializePitcher(Club pitchingTeam, int pitchersIndex) {
		pitcher = pitchingTeam.getPitchers().get(pitchersIndex);
		double pitch = pitcher.getStats().get(3);
		outProb = 0.1 + (pitch /100) * 0.4;	
	}
	
	public void pitchingLose() {
		if (pitching == opponent) {
			MatchInjuryUI matchInjuryWindow = new MatchInjuryUI(environment, this, false);
			environment.addMoney(100);
			environment.addPoints(1000);
		}
		else {
			MatchInjuryUI matchInjuryWindow = new MatchInjuryUI(environment, this, true);
		}
	}
	
	
	
//Innings

	public void innings(Club clubOne, Club clubTwo, int iterativeNum) {
		int inningsNum = iterativeNum / 2;
		

			batting = clubOne;
			pitching = clubTwo;

		if (lostCheck == true) {
			return;
		}
		//ComandLine information
//		if (batting == environment.getClub()) {
//			System.out.println("You are Batting");
//		}
//		else {
//			System.out.println("You are Fielding");
//		}
		
		
		outs = 0;
		outList.clear();
		injuryList.clear();
		
			

		//Pitcher initialize
		initializePitcher(pitching, inningsNum);
		
		//Getting average fielding stats
		double fielding = 0;
		for (Athlete current : pitching.getPlaying()) {
			if (current !=  pitcher) {
				fielding += current.getStats().get(2);				
			}
		}
		fielding = fielding / 6;


		
		int currentBatterIndex = 0;
		
		//Play game until three outs
		while (outs < 3) {
			//Get next batter who isn't on base
			while (base.contains(batting.getBatters().get(currentBatterIndex)) == true) {
				currentBatterIndex = (currentBatterIndex + 1) % 5;
			}
			
			//batProb is based on the batters stat vs fielding stat
			//temProb is the probability of the batter getting out
			Athlete currentBatter = batting.getBatters().get(currentBatterIndex);
			double batProb = (currentBatter.getStats().get(1) - fielding) * 0.2 / 100;
			double tempProb = outProb - batProb;
			
			
			//Roll to find out if batter is out
			var outRoll = Math.random();
			
			//Batter out
			if (outRoll <= tempProb) {
				//Add batter and pitcher to outList
				outList.add(pitcher);
				outList.add(currentBatter);
				pitcher.addChanceToIncrease(0.01);
				
				//Drain batter stanima of batter and check if injured
				lostCheck = playerInjured(currentBatter, batting, 8);
				if (lostCheck == true) {
					if (batting == opponent) {
						MatchInjuryUI matchInjuryWindow = new MatchInjuryUI(environment, this, false);
						environment.addMoney(100);
						environment.addPoints(1000);
					}
					else {
						MatchInjuryUI matchInjuryWindow = new MatchInjuryUI(environment, this, true);
					}
					return;
				}
				
				//Next batter
				currentBatterIndex = (currentBatterIndex + 1) % 5;
				outs += 1;
			}
			//Not out
			else {
				//Rol to find out how many runs
				var batRoll = Math.random();
				
				//Home run
				if (batRoll <= batProb) {
					for (int i = 0; i <=3; i++) {
						batting.addRun();
						base.set(i, 0);
					}
					currentBatter.addChanceToIncrease(0.5);

					//Drain stanima of pitcher and check if injured
					lostCheck = playerInjured(pitcher, pitching, 6);
					if (lostCheck == true) {
						pitchingLose();
						return;
					}
					initializePitcher(pitching, inningsNum);				
				}
				//3 Runs
				else if (batRoll <= 0.1 + batProb) {
					this.scoreRun(currentBatter, 4, batting);
					currentBatter.addChanceToIncrease(0.2);

					//Drain stanima of pitcher and check if injured
					lostCheck = playerInjured(pitcher, pitching, 3);
					if (lostCheck == true) {
						pitchingLose();
						return;
					}
					initializePitcher(pitching, inningsNum);		
				}
				//2 Runs
				else if (batRoll <= 0.3 + batProb) {
					this.scoreRun(currentBatter, 2, batting);
					
					//Drain stanima of pitcher and check if injured
					lostCheck = playerInjured(pitcher, pitching, 2);
					if (lostCheck == true) {
						pitchingLose();
						return;
					}
					initializePitcher(pitching, inningsNum);		
				}
				//1 Run
				else {
					this.scoreRun(currentBatter, 1, batting);
					
					//Drain stanima of pitcher and check if injured
					lostCheck = playerInjured(pitcher, pitching, 1);
					if (lostCheck == true) {
						pitchingLose();
						return;
					}
					initializePitcher(pitching, inningsNum);		
				}
			}
		}
		
		for (Athlete fielder : pitching.getPlaying()) {
			lostCheck = playerInjured(fielder, pitching, 7);
			if (lostCheck == true) {
				pitchingLose();
				return;
			}
		}
		
		
		//ComandLine
//		System.out.println(batting.getName() + ": " + batting.getRuns() + " runs");
//		for (int i = 0; i < 6; i += 2) {
//			System.out.println("(Out) " + outList.get(i + 1).getName() + ", (Pitcher) " + outList.get(i).getName());
//		}
//		for (int i = 0; i < injuryList.size(); i += 2) {
//			System.out.println("(Injury) " + injuryList.get(i).getName() + ", (Sub) " + injuryList.get(i+1).getName());
//		}
//		System.out.println();

		
		MatchUI matchWindow = new MatchUI(environment, this, iterativeNum);
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
