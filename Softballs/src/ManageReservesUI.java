



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
import javax.swing.JCheckBox;

public class ManageReservesUI {

	private GameEnvironment environment;
	private Manage manageManager;


	private JFrame frame;

	



	/**
	 * Create the application.
	 */
	public ManageReservesUI(GameEnvironment incomingEnvironment, Manage incomingManage) {
		environment = incomingEnvironment;
		manageManager = incomingManage;
		
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
//Make window
		frame = new JFrame();
		frame.setBounds(100, 100, 1024, 576);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		

//Import Top bar
		JPanel pnlTopBar = new TopBar(environment);
		frame.getContentPane().add(pnlTopBar);



//Display 3 areas of manage
		JLabel lblReserves = new JLabel("Reserves");
		lblReserves.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblReserves.setHorizontalAlignment(SwingConstants.CENTER);
		lblReserves.setBounds(304, 28, 400, 40);
		frame.getContentPane().add(lblReserves);
		
		JButton btnAthletes = new JButton("Athletes");
		btnAthletes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAthletes.setBounds(0, 28, 304, 40);
		frame.getContentPane().add(btnAthletes);
		
		JButton btnPositions = new JButton("Positions");
		btnPositions.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPositions.setBounds(704, 28, 304, 40);
		frame.getContentPane().add(btnPositions);
		
		
//Panel to store Reserves
		JPanel pnlReserves = new JPanel();
		pnlReserves.setBounds(40, 391, 854, 127);
		frame.getContentPane().add(pnlReserves);
		pnlReserves.setLayout(new GridLayout(1, 0, 0, 0));
		

//Loop through all athletes and create card
		int Rcounter = 1;
		for (Athlete currentAthlete : environment.getClub().getReserves()) {
			Rcounter += 1;
			AthleteSmallUI pnlReserveCard = new AthleteSmallUI(currentAthlete);
			
////Overlay radio button on top of card
//			JCheckBox chkReserveCard = new JCheckBox("");
//			chkReserveCard.setHorizontalAlignment(SwingConstants.RIGHT);
//			chkReserveCard.setVerticalAlignment(SwingConstants.TOP);
//			chkReserveCard.setBounds(0, 0, 120, 125);
//			chkReserveCard.setOpaque(false);
//
////When the radio button is clicked set the display information to current athletes information
//			chkReserveCard.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {			
//				}
//			});
			
			//pnlReserveCard.add(chkReserveCard);
			pnlReserves.add(pnlReserveCard);
		}
				
		//Fill the remaining spots in grid with empty panels
		for (int i = Rcounter; i < 8; i ++) {
			JPanel pnlFillGrid = new JPanel();
			pnlFillGrid.setLayout(null);
			pnlReserves.add(pnlFillGrid);
		}


		
		
//Panel to store athlete cards
		JPanel pnlAthletes = new JPanel();
		pnlAthletes.setBounds(40, 130, 732, 254);
		frame.getContentPane().add(pnlAthletes);
		GridLayout athleteGrid = new GridLayout(2, 0, 0, 0);
		athleteGrid.setHgap(1);
		athleteGrid.setVgap(1);
		pnlAthletes.setLayout(athleteGrid);
		

//Loop through all athletes and create card
		int counter = 1;
		for (Athlete currentAthlete : environment.getClub().getAthletes()) {
			counter += 1;
			AthleteSmallUI pnlAthleteCard = new AthleteSmallUI(currentAthlete);
			
//Overlay radio button on top of card
			JCheckBox chkAthleteCard = new JCheckBox("");
			chkAthleteCard.setHorizontalAlignment(SwingConstants.RIGHT);
			chkAthleteCard.setVerticalAlignment(SwingConstants.TOP);
			chkAthleteCard.setBounds(0, 0, 120, 125);
			chkAthleteCard.setOpaque(false);

//When the radio button is clicked set the display information to current athletes information
			chkAthleteCard.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {			
				}
			});
			
			pnlAthleteCard.add(chkAthleteCard);
			pnlAthletes.add(pnlAthleteCard);
		}

//Fill the remaining spots in grid with empty panels
		for (int i = counter; i < 13; i ++) {
			JPanel pnlFillGrid = new JPanel();
			pnlFillGrid.setLayout(null);
			pnlAthletes.add(pnlFillGrid);
		}

	}
}
