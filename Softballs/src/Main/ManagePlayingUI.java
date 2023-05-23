package Main;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Color;

/**
 * Allows the player to change who is in reserved and who is playing.
 * 
 * @author Tobias Paull, Daniel Bensley
 * @version 1.0, May 2023.
 *
 */
public class ManagePlayingUI {
	

	/**
	 * Game environment
	 */
	private GameEnvironment environment;
	/**
	 * Manage class
	 */
	private Manage manageManager;
	/**
	 * List of new playing line up
	 */
	private ArrayList<Athlete> newPlaying = new ArrayList<Athlete>();

	/**
	 * Jframe window
	 */
	private JFrame frame;
	
	/**
	 * Update button
	 */
	private JButton btnUpdate;
	
	/**
	 * Select from playing
	 */
	private JCheckBox chkPlayingCard;
	
	/**
	 * Select from reserves
	 */
	private JCheckBox chkReserveCard;



	/**
	 * Create the application.
	 */
	public ManagePlayingUI(GameEnvironment incomingEnvironment, Manage incomingManage) {
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
	 * Gets update button
	 * @return update button
	 */
	public JButton getBtnUpdate() {
		return btnUpdate;
	}
	
	/**
	 * Gets playing checkbox
	 * @return playing checkbox
	 */
	public JCheckBox getChkPlayingCard() {
		return chkPlayingCard;
	}
	
	/**Gets reserve checkbox
	 * @return reserve checkbox
	 */
	public JCheckBox getChkReserveCard() {
		return chkReserveCard;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		String errorReserveSize = "Maximum reserve size is 5";
		String errorPlayingSize = "Maximum playing size is 7";
		
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
		JLabel lblLineUp = new JLabel("Line Up");
		lblLineUp.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblLineUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblLineUp.setBounds(304, 28, 400, 40);
		frame.getContentPane().add(lblLineUp);
		
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
		
		JButton btnPositions = new JButton("Positions");
		btnPositions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				environment.launchManagePositions();
			}
		});
		btnPositions.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPositions.setBounds(704, 28, 304, 40);
		frame.getContentPane().add(btnPositions);
		
		
//Jlabel to display errors		
		JLabel lblErrorMessage = new JLabel();
		lblErrorMessage.setVerticalAlignment(SwingConstants.TOP);
		lblErrorMessage.setHorizontalAlignment(SwingConstants.LEFT);
		lblErrorMessage.setForeground(Color.RED);
		lblErrorMessage.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblErrorMessage.setBounds(660, 341, 275, 91);
		frame.getContentPane().add(lblErrorMessage);
	
		
		
//Panel to store Playing
		JPanel pnlPlaying = new JPanel();
		pnlPlaying.setBounds(40, 143, 840, 122);
		frame.getContentPane().add(pnlPlaying);
		pnlPlaying.setLayout(new GridLayout(1, 0, 0, 0));
		

//Loop through all playing and create card
		int Pcounter = 1;
		for (Athlete currentAthlete : environment.getClub().getPlaying()) {
			Pcounter += 1;
			AthleteSmallUI pnlPlayingCard = new AthleteSmallUI(currentAthlete);
			
//Overlay checkbox on top of card
			chkPlayingCard = new JCheckBox("");
			chkPlayingCard.setHorizontalAlignment(SwingConstants.RIGHT);
			chkPlayingCard.setVerticalAlignment(SwingConstants.TOP);
			chkPlayingCard.setBounds(0, 0, 120, 125);
			chkPlayingCard.setOpaque(false);

//
			chkPlayingCard.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (newPlaying.contains(currentAthlete)) {
						newPlaying.remove(currentAthlete);
					}
					else {
						newPlaying.add(currentAthlete);
					}
				}
			});
			
			pnlPlayingCard.add(chkPlayingCard);

			pnlPlaying.add(pnlPlayingCard);
		}
				
		//Fill the remaining spots in grid with empty panels
		for (int i = Pcounter; i < 8; i ++) {
			JPanel pnlFillGrid = new JPanel();
			pnlFillGrid.setLayout(null);
			pnlPlaying.add(pnlFillGrid);
		}
		
		
		
//Panel to store Reserves
		JPanel pnlReserves = new JPanel();
		pnlReserves.setBounds(40, 341, 600, 125);
		frame.getContentPane().add(pnlReserves);
		pnlReserves.setLayout(new GridLayout(1, 0, 0, 0));
		

//Loop through all reserves and create card
		int Rcounter = 1;
		for (Athlete currentAthlete : environment.getClub().getReserves()) {
			Rcounter += 1;
			AthleteSmallUI pnlReserveCard = new AthleteSmallUI(currentAthlete);
			
//Overlay checkbox on top of card
			chkReserveCard = new JCheckBox("");
			chkReserveCard.setHorizontalAlignment(SwingConstants.RIGHT);
			chkReserveCard.setVerticalAlignment(SwingConstants.TOP);
			chkReserveCard.setBounds(0, 0, 120, 125);
			chkReserveCard.setOpaque(false);

//when checked add to newPlaying list
			chkReserveCard.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (newPlaying.contains(currentAthlete)) {
						newPlaying.remove(currentAthlete);
					}
					else {
						newPlaying.add(currentAthlete);
					}
				}
			});
			
			pnlReserveCard.add(chkReserveCard);
			pnlReserves.add(pnlReserveCard);
		}
				
		//Fill the remaining spots in grid with empty panels
		for (int i = Rcounter; i < 6; i ++) {
			JPanel pnlFillGrid = new JPanel();
			pnlFillGrid.setLayout(null);
			pnlReserves.add(pnlFillGrid);
		}
			
			

		
//Button to update players
		btnUpdate = new JButton("Update Playing");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Insure team size is right
				int totalSize= environment.getClub().getAthletes().size();
				int newReserveSize = totalSize - newPlaying.size();
				if (newReserveSize > 5) {
					lblErrorMessage.setText(errorReserveSize);
				}
				else if (newPlaying.size() > 7) {
					lblErrorMessage.setText(errorPlayingSize);
					
				}
				else {
					closeWindow();
					manageManager.setPlaying(newPlaying);
					environment.launchManagePlaying();					
				}
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdate.setBounds(777, 92, 158, 40);
		frame.getContentPane().add(btnUpdate);
		
		JLabel lblNewLabel = new JLabel("Playing:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(40, 100, 121, 34);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblReserves = new JLabel("Reserves:");
		lblReserves.setHorizontalAlignment(SwingConstants.LEFT);
		lblReserves.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblReserves.setBounds(40, 296, 121, 34);
		frame.getContentPane().add(lblReserves);

		
		

//Back to menu
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				environment.launchMainMenu();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack.setBounds(835, 440, 100, 28);
		frame.getContentPane().add(btnBack);

	}

}
