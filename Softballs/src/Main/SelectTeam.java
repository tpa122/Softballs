package Main;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Font;

/**
 * @author Tobias Paull, Daniel Bensley
 * @version 1.0,  May 2023.
 *
 */
public class SelectTeam {

	/**
	 * The application window frame
	 */
	private JFrame frame;
	
	/**
	 * The game environment to interact with
	 */
	private GameEnvironment environment;
	
	/**
	 * The setup class to interact with
	 */
	private Setup setupManager;
	
	/**
	 * An array of the player's chosen athletes
	 */
	private ArrayList<Athlete> chosenAthletes = new ArrayList<Athlete>();
	
	/**
	 * A copy of the starting athletes from the setup class
	 */
	private ArrayList<Athlete> startingAthletes;
	
	/**
	 * A counter for the number of athletes' selected
	 */
	private int playerSelectedCount = 0;
	
	private Club playerClub;
	

	/**
	 * Create the application.
	 */
	public SelectTeam(Setup setupGame, GameEnvironment incomingEnvironment) {
		setupManager = setupGame;
		environment = incomingEnvironment;
		startingAthletes = setupGame.getStartAthletes();
		initialize();
		frame.setVisible(true);
		playerClub = environment.getClub();
	}
	
	public void addToTeam(Athlete athleteToAdd)	{
		chosenAthletes.add(athleteToAdd);
	}
	public void addToChosenAthletes(Athlete athleteToAdd)	{
		chosenAthletes.add(athleteToAdd);
	}
	public void setPlayerCountText()	{
		playerSelectedCount = (10 - chosenAthletes.size());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1024, 576);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBounds(165, 46, 600, 375);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(3, 5, 0, 0));
		
		JButton btnNewButton = new JButton("Start Season");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chosenAthletes.size() == (10))	{
					environment.getClub().setAthletes(chosenAthletes);
					for (int i = 0; i < 10; i ++) {
						Athlete currentAthlete = chosenAthletes.get(i);
						if (i < 2) {
							playerClub.getPlaying().add(currentAthlete);
							playerClub.getPitchers().add(currentAthlete);
						}
						else if (i < 7) {
							playerClub.getPlaying().add(currentAthlete);
							playerClub.getBatters().add(currentAthlete);
						}
						else {
							playerClub.getReserves().add(currentAthlete);
						}
						
					}
					
					frame.dispose();
					environment.refresh();
					environment.launchMainMenu();
				}
			}
		});
		btnNewButton.setBounds(853, 11, 145, 33);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Select Starting Players");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setBounds(-114, 11, 697, 24);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblSelectPlayerCount = new JLabel("Select " + String.valueOf(playerSelectedCount) + " more players.");
		lblSelectPlayerCount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSelectPlayerCount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSelectPlayerCount.setBounds(372, 9, 398, 33);
		frame.getContentPane().add(lblSelectPlayerCount);
		

		for (Athlete currentAthlete : startingAthletes) {
			Athlete startingAthlete = currentAthlete;
			AthleteSmallUI athleteCard = new AthleteSmallUI(startingAthlete);
			
			JCheckBox chckbxSelectPlayer = new JCheckBox("");
			chckbxSelectPlayer.setHorizontalAlignment(SwingConstants.RIGHT);
			chckbxSelectPlayer.setVerticalAlignment(SwingConstants.TOP);
			chckbxSelectPlayer.setBounds(0,0,120,125);
			chckbxSelectPlayer.setOpaque(false);
			athleteCard.add(chckbxSelectPlayer);
			
			
			chckbxSelectPlayer.addActionListener(new ActionListener()	{
				public void actionPerformed(ActionEvent e) {
//					Check if checkbox selected
					if(chckbxSelectPlayer.isSelected())	{
//						Check if team not full
						if(chosenAthletes.size() == (10)) {
//							If full, tell the player they have selected 10 players
							lblSelectPlayerCount.setText("You have selected 10 players");
							chckbxSelectPlayer.setSelected(false);
						}	else	{
//							Else the player has not chosen enough athletes
							if(chosenAthletes.size() < 10) {
//								
								chosenAthletes.add(currentAthlete);
								setPlayerCountText();
								if(chosenAthletes.size() == 10) {
									lblSelectPlayerCount.setText("You have selected 10 players");
								}else	{
									lblSelectPlayerCount.setText("Select " + String.valueOf(playerSelectedCount) + " more players.");
								}
								
							}	else	{
								chckbxSelectPlayer.setSelected(false);
							}
						}
					}	else	{
						chosenAthletes.remove(currentAthlete);
						setPlayerCountText();
						lblSelectPlayerCount.setText("Select " + String.valueOf(playerSelectedCount) + " more players.");
					}
				}
			});
			
			
			panel.add(athleteCard);
		}
		
		lblSelectPlayerCount.setText("Select 10 more players.");
		
	}
}
