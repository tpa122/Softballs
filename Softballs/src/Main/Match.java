package Main;
import java.util.ArrayList;

/**
 * The players team vs an opponent in softball
 * Determines the outcome of said match
 * 
 * @author Tobias Paull
 *
 */
public class Match {
//Match permanent
	/**
	 * The game environment
	 */
	private GameEnvironment environment;
	/**
	 * Opponent Team
	 */
	private Club opponent;
	
	/**
	 * Whether a team has lost due to injury
	 */
	private boolean lostCheck = false;
	

//Innings specific
	/**
	 * Current batting team
	 */
	private Club batting;
	/**
	 * Current Pitching team
	 */
	private Club pitching;
	
	/**
	 * List of batters who have been out and by who in each innings
	 */
	private ArrayList<Athlete> outList = new ArrayList<Athlete>();
	/**
	 * List of injured Athletes for each innings
	 */
	private ArrayList<Athlete> injuryList = new ArrayList<Athlete>();
	/**
	 * Current pitcher
	 */
	private Athlete pitcher;
	/**
	 * Probability of a Batter getting out
	 */
	private double outProb;
	
	/**
	 * Number of outs
	 */
	private int outs = 0;
	/**
	 * who if any is on each base
	 */
	private ArrayList<Object> base = new ArrayList <>();
	
	
	
	
//Constructor
	
	/**
	 * Creates match and makes base
	 * @param newEnvironment game environment
	 * @param newOpponent Opponent team
	 */
	public Match(GameEnvironment newEnvironment, Club newOpponent) {
		environment = newEnvironment;
		opponent = newOpponent;
		//Creates an base with no athletes on it
		for (int i = 0; i < 4; i++) {
			base.add(0);
		}
	}

	
	
//Getters
	
	/**
	 * Gets the opponent
	 * @return The opponent
	 */
	public Club getOpponent() {
		return opponent;
	}
	
	
	/**
	 * Gets the batting team
	 * @return the batting team
	 */
	public Club getBatting() {
		return batting;
	}
	
	/**
	 * Gets the 
	 * @return the pitching team
	 */
	public Club getPitching() {
		return pitching;
	}
	
	/**
	 * Gets list of who got out and by who
	 * @return list of who got out and by who
	 */
	public ArrayList<Athlete> getOutList(){
		return outList;
	}
	
	/**
	 * list of injured players
	 * @return list of injured players
	 */
	public ArrayList<Athlete> getInjuryList(){
		return injuryList;
	}
	
	/**
	 * gets the team which the Athlete is on
	 * @param incomingAthlete A athlete on one of the teams
	 * @return the team which the Athlete is on
	 */
	public String getTeamName(Athlete incomingAthlete) {
		if (batting.getAthletes().contains(incomingAthlete)){
			return batting.getName();
		}
		else {
			return pitching.getName();
		}
		
	}

	
//Other

	
	/**
	 * Drains player of stamina and swaps with reserve if they become injured
	 * @param injuredPlayer: Player getting their stamina drained
	 * @param injuredClub: The club associated with that player
	 * @param drainAmount: The amount the players stamina is drained by
	 * @return Whether the team has lost due to injured players
	 */
	public boolean playerInjured(Athlete injuredPlayer, Club injuredClub, int drainAmount) {
		injuredPlayer.drainStanima(drainAmount);
		//If player becomes injured then swap with reserve
		if (injuredPlayer.getIsInjured() == true) {
			injuryList.add(injuredPlayer);
			Athlete reserveSwap = injuredClub.getReserves().get(0);
			//If there are no un-injured players on the team then return that true
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
	
	/**
	 * Sets the pitcher to an athlete
	 * @param pitchingTeam: Team that is pitching
	 * @param pitchersIndex: index of new pitcher
	 */
	public void initializePitcher(Club pitchingTeam, int pitchersIndex) {
		//Calculates probality that the pitcher will cause a batter to be out
		pitcher = pitchingTeam.getPitchers().get(pitchersIndex);
		double pitch = pitcher.getStats().get(3);
		outProb = 0.1 + (pitch /100) * 0.4;	
	}
	
	/**
	 * Pitching team lost due to injury so display match summary
	 */
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

	/**
	 * 
	 * Plays an innings of baseball
	 * 
	 * @param clubOne: Batting club
	 * @param clubTwo: Pitching club
	 * @param iterativeNum: How far through the match is
	 */
	public void innings(Club clubOne, Club clubTwo, int iterativeNum) {
		int inningsNum = iterativeNum / 2;
		

			batting = clubOne;
			pitching = clubTwo;
			
		//If the team has lost	
		if (lostCheck == true) {
			return;
		}

		
		//Reset the innings specific info
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
				//If team has lost and check if it is player or not
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
					//If team has lost
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
		
		//Drain stamina for all fielders
		for (Athlete fielder : pitching.getPlaying()) {
			lostCheck = playerInjured(fielder, pitching, 7);
			if (lostCheck == true) {
				pitchingLose();
				return;
			}
		}
		
		//Launch UI for innings
		MatchUI matchWindow = new MatchUI(environment, this, iterativeNum);
	}
	


	/**
	 * Add runs to team score and move players on base
	 * @param runScorer: Batter 
	 * @param runs: Amount of runs scored
	 * @param batting: Team who is batting
	 */
	public void scoreRun(Athlete runScorer, int runs, Club batting) {
		//how many times should add runs
		
		int startIndex = 3 - runs;
		
		for (int i = startIndex + 1; i <= 3; i++) {
			if (base.get(i) instanceof Athlete) {
				batting.addRun();
			}
		}
		//Move players in base
		for (int i = startIndex; i >= 0; i--) {
			base.set(i + runs, base.get(i));
			
		}
		//Set bases to empty if multiple runs are scored
		for (int a = 0; a < runs; a++) {
			base.set(a, 0);
		}
		base.set(runs - 1, runScorer);
		
	}
}
