package Main;
import java.util.ArrayList;



import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JCheckBox;
import java.awt.Color;

/**
 * Allows the user to change the positions of players in the club
 * 
 * @author Tobias Paull
 *
 */
public class ManagePositionsUI {

	/**
	 * Game environment 
	 */
	private GameEnvironment environment;
	/**
	 * Manage class 
	 */
	private Manage manageManager;
	/**
	 * List of athletes to go to selected position 
	 */
	private ArrayList<Athlete> newPosition = new ArrayList<Athlete>();


	/**
	 * Jframe window
	 */
	private JFrame frame;

	



	/**
	 * Create the application.
	 */
	public ManagePositionsUI(GameEnvironment incomingEnvironment, Manage incomingManage) {
		environment = incomingEnvironment;
		manageManager = incomingManage;
		
		initialize();
		frame.setVisible(true);
	}
	
	/**
	 * Close window 
	 */
	public void closeWindow() {
		frame.dispose();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
//Error messages
		String errorBatterSize = "Maximum number of Batters is 5";
		String errorPitcherSize = "Maximum number of Pitchers is 2";
		
//Make window
		frame = new JFrame();
		frame.setBounds(100, 100, 1024, 576);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		

//Import Top bar
		JPanel pnlTopBar = new TopBar(environment);
		frame.getContentPane().add(pnlTopBar);



//Display 3 areas of manage
		JLabel lblPositions = new JLabel("Positions");
		lblPositions.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPositions.setHorizontalAlignment(SwingConstants.CENTER);
		lblPositions.setBounds(608, 28, 400, 40);
		frame.getContentPane().add(lblPositions);
		
		JButton btnAthletes = new JButton("Athletes");
		btnAthletes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				environment.launchManage();
			}
		});
		btnAthletes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAthletes.setBounds(0, 28, 304, 40);
		frame.getContentPane().add(btnAthletes);
		
		JButton btnLineUp = new JButton("Line Up");
		btnLineUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				environment.launchManagePlaying();
			}
		});
		btnLineUp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLineUp.setBounds(304, 28, 304, 40);
		frame.getContentPane().add(btnLineUp);
		
		
		
		JLabel lblErrorMessage = new JLabel();
		lblErrorMessage.setVerticalAlignment(SwingConstants.TOP);
		lblErrorMessage.setHorizontalAlignment(SwingConstants.LEFT);
		lblErrorMessage.setForeground(Color.RED);
		lblErrorMessage.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblErrorMessage.setBounds(266, 98, 342, 34);
		frame.getContentPane().add(lblErrorMessage);
	
		
		
//Panel to store Playing
		JPanel pnlPlaying = new JPanel();
		pnlPlaying.setBounds(40, 143, 840, 125);
		frame.getContentPane().add(pnlPlaying);
		pnlPlaying.setLayout(new GridLayout(1, 0, 0, 0));
		

//Loop through all playing and create card
		int Pcounter = 1;
		for (Athlete currentAthlete : environment.getClub().getPlaying()) {
			Pcounter += 1;
			AthleteSmallUI pnlPlayingCard = new AthleteSmallUI(currentAthlete);
			
//Overlay checkbox on top of card
			JCheckBox chkPlayingCard = new JCheckBox("");
			chkPlayingCard.setHorizontalAlignment(SwingConstants.RIGHT);
			chkPlayingCard.setVerticalAlignment(SwingConstants.TOP);
			chkPlayingCard.setBounds(0, 0, 120, 125);
			chkPlayingCard.setOpaque(false);

//if player is selected then add to newPosition list
			chkPlayingCard.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (newPosition.contains(currentAthlete)) {
						newPosition.remove(currentAthlete);
					}
					else {
						newPosition.add(currentAthlete);
					}
				}
			});
			
			pnlPlayingCard.add(chkPlayingCard);
			if (environment.getClub().getBatters().contains(currentAthlete) && environment.getClub().getPitchers().contains(currentAthlete)) {
				pnlPlayingCard.setBorder(new LineBorder(new Color(255, 255, 0)));
			}
			else if (environment.getClub().getBatters().contains(currentAthlete)) {
				pnlPlayingCard.setBorder(new LineBorder(new Color(0, 0, 255)));
			}
			else if (environment.getClub().getPitchers().contains(currentAthlete)) {
				pnlPlayingCard.setBorder(new LineBorder(new Color(0, 255, 0)));
			}

			pnlPlaying.add(pnlPlayingCard);
		}
				
		//Fill the remaining spots in grid with empty panels
		for (int i = Pcounter; i < 8; i ++) {
			JPanel pnlFillGrid = new JPanel();
			pnlFillGrid.setLayout(null);
			pnlPlaying.add(pnlFillGrid);
		}
		
		
		
		
//Panel to store Batters
		JPanel pnlBatters = new JPanel();
		pnlBatters.setBounds(40, 341, 600, 125);
		frame.getContentPane().add(pnlBatters);
		pnlBatters.setLayout(new GridLayout(1, 0, 0, 0));
		

//Loop through all Pichers and create card
		int batterCounter = 1;
		for (Athlete currentAthlete : environment.getClub().getBatters()) {
			batterCounter += 1;
			AthleteSmallUI pnlBatterCard = new AthleteSmallUI(currentAthlete);
			pnlBatterCard.setBorder(new LineBorder(new Color(0, 0, 255)));
			pnlBatters.add(pnlBatterCard);
		}
				
		//Fill the remaining spots in grid with empty panels
		for (int i = batterCounter; i < 6; i ++) {
			JPanel pnlFillGrid = new JPanel();
			pnlFillGrid.setLayout(null);
			pnlBatters.add(pnlFillGrid);
		}		
		
		
		
		
		
//Panel to store Pitchers
		JPanel pnlPichers = new JPanel();
		pnlPichers.setBounds(691, 341, 240, 125);
		frame.getContentPane().add(pnlPichers);
		pnlPichers.setLayout(new GridLayout(1, 0, 0, 0));
		

//Loop through all Pichers and create card
		int pitcherCounter = 1;
		for (Athlete currentAthlete : environment.getClub().getPitchers()) {
			pitcherCounter += 1;
			AthleteSmallUI pnlPitcherCard = new AthleteSmallUI(currentAthlete);
			pnlPitcherCard.setBorder(new LineBorder(new Color(0, 255, 0)));

			pnlPichers.add(pnlPitcherCard);
		}
				
		//Fill the remaining spots in grid with empty panels
		for (int i = pitcherCounter; i < 3; i ++) {
			JPanel pnlFillGrid = new JPanel();
			pnlFillGrid.setLayout(null);
			pnlPichers.add(pnlFillGrid);
		}
			
			

		
//Button to update players postion
		JButton btnUpdatePitchers = new JButton("Update Pitchers");
		btnUpdatePitchers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Ensure team size is correct
				if (newPosition.size() < 3) {
					environment.getClub().setPitchers(newPosition);
					closeWindow();
					environment.launchManagePositions();
				}
				else {
					lblErrorMessage.setText(errorPitcherSize);					
				}
			}
		});
		btnUpdatePitchers.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdatePitchers.setBounds(772, 92, 159, 40);
		frame.getContentPane().add(btnUpdatePitchers);
		
		
		JButton btnUpdateBatters = new JButton("Update Batters");
		btnUpdateBatters.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (newPosition.size() < 6) {
					environment.getClub().setBatters(newPosition);
					closeWindow();
					environment.launchManagePositions();
				}
				else {
					lblErrorMessage.setText(errorBatterSize);				
				}
			}
		});
		btnUpdateBatters.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdateBatters.setBounds(623, 92, 139, 40);
		frame.getContentPane().add(btnUpdateBatters);
		
		
		JLabel lblNewLabel = new JLabel("Playing:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(40, 100, 121, 34);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblBatters = new JLabel("Batters:");
		lblBatters.setHorizontalAlignment(SwingConstants.LEFT);
		lblBatters.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBatters.setBounds(40, 296, 121, 34);
		frame.getContentPane().add(lblBatters);

		
		

//Back to menu
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				environment.launchMainMenu();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack.setBounds(831, 484, 100, 28);
		frame.getContentPane().add(btnBack);
		
		JLabel lblPitchers = new JLabel("Pitchers:");
		lblPitchers.setHorizontalAlignment(SwingConstants.LEFT);
		lblPitchers.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPitchers.setBounds(691, 296, 121, 34);
		frame.getContentPane().add(lblPitchers);
	}
}
