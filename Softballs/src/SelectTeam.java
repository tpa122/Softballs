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

public class SelectTeam {

	private JFrame frame;
	private GameEnvironment environment;
	private Setup setupManager;
	private ArrayList<Athlete> chosenAthletes = new ArrayList<Athlete>();
	private ArrayList<Athlete> startingAthletes;
	private int playerSelectedCount = 0;
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SelectTeam window = new SelectTeam();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public SelectTeam(Setup setupGame, GameEnvironment incomingEnvironment) {
		setupManager = setupGame;
		environment = incomingEnvironment;
		startingAthletes = setupGame.getStartAthletes();
		initialize();
		frame.setVisible(true);
	}
	
	public void addToTeam(Athlete athleteToAdd)	{
		chosenAthletes.add(athleteToAdd);
	}
	public void addToChosenAthletes(Athlete athleteToAdd)	{
		chosenAthletes.add(athleteToAdd);
	}
	public void setPlayerCountText()	{
		playerSelectedCount = (12 - chosenAthletes.size());
		System.out.println(playerSelectedCount);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1024, 576);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(165, 46, 700, 491);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(3, 5, 0, 0));
		
		JButton btnNewButton = new JButton("Start Season");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chosenAthletes.size() == (12))	{
					environment.getClub().setAthletes(chosenAthletes);
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
		lblSelectPlayerCount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSelectPlayerCount.setBounds(625, 9, 165, 33);
		frame.getContentPane().add(lblSelectPlayerCount);
		

		for (Athlete currentAthlete : startingAthletes) {
			Athlete startingAthlete = currentAthlete;
			AthleteSmallUI athleteCard = new AthleteSmallUI(startingAthlete);
			
			JCheckBox chckbxSelectPlayer = new JCheckBox("test");
			chckbxSelectPlayer.setVerticalAlignment(SwingConstants.TOP);
			chckbxSelectPlayer.addActionListener(new ActionListener()	{
				public void actionPerformed(ActionEvent e) {
//					Check if checkbox selected
					if(chckbxSelectPlayer.isSelected())	{
//						Check if team not full
						if(chosenAthletes.size() == (12)) {
//							If full, tell the player they have selected 12 players
							lblSelectPlayerCount.setText("You have selected 12 players");
							chckbxSelectPlayer.setSelected(false);
						}	else	{
//							Else the player has not chosen enough athletes
							if(chosenAthletes.size() < 12) {
//								
								chosenAthletes.add(currentAthlete);
								setPlayerCountText();
								if(chosenAthletes.size() == 12) {
									lblSelectPlayerCount.setText("You have selected 12 players");
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
					System.out.println(chosenAthletes);
				}
			});
			chckbxSelectPlayer.setHorizontalAlignment(SwingConstants.RIGHT);
			chckbxSelectPlayer.setOpaque(false);
			
			chckbxSelectPlayer.setBounds(0, 0, 150, 206);;
			
			athleteCard.add(chckbxSelectPlayer);
			panel.add(athleteCard);
		}
		
		lblSelectPlayerCount.setText("Select 12 more players.");
		
	}
}
