import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ByeUI {

	private JFrame frame;
	
	private GameEnvironment environment;
	private Bye byeManager;
	private Athlete trainingAthlete;



	/**
	 * Create the application.
	 */
	public ByeUI(GameEnvironment incomingEnvironment, Bye incomingBye) {
		environment = incomingEnvironment;
		byeManager = incomingBye;
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
		frame = new JFrame();
		frame.setBounds(100, 100, 1024, 576);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel pnlTopBar = new TopBar(environment);
		frame.getContentPane().add(pnlTopBar);
		
		JLabel infoLabel = new JLabel("Select a Athlete for special traning");
		infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		infoLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		infoLabel.setBounds(354, 72, 300, 60);
		frame.getContentPane().add(infoLabel);
		
		JPanel pnlAthletes = new JPanel();
		pnlAthletes.setBounds(144, 143, 720, 250);
		frame.getContentPane().add(pnlAthletes);
		pnlAthletes.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel pnlButtons = new JPanel();
		pnlButtons.setBounds(304, 414, 400, 53);
		frame.getContentPane().add(pnlButtons);
		pnlButtons.setLayout(null);

		
		JButton btnBye = new JButton("Take a Bye");
		btnBye.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBye.setBounds(235, 6, 135, 40);
		pnlButtons.add(btnBye);
		btnBye.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (environment.getClub().getAthletes().contains(trainingAthlete)) {
					closeWindow();
					byeManager.takeBye(trainingAthlete);
					//environment.launchMainMenu();
				}
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				environment.launchMainMenu();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack.setBounds(65, 12, 100, 28);
		pnlButtons.add(btnBack);

		
		ButtonGroup btnGroupAthleteCard = new ButtonGroup();
		
		int counter = 1;
		for (Athlete currentAthlete : environment.getClub().getAthletes()) {
			counter += 1;
			AthleteSmallUI pnlAthleteCard = new AthleteSmallUI(currentAthlete);
			
			JRadioButton rdbtnAthleteCard = new JRadioButton("");
			rdbtnAthleteCard.setHorizontalAlignment(SwingConstants.RIGHT);
			rdbtnAthleteCard.setVerticalAlignment(SwingConstants.TOP);
			rdbtnAthleteCard.setBounds(0, 0, 120, 125);
			rdbtnAthleteCard.setOpaque(false);
			
			rdbtnAthleteCard.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					trainingAthlete = currentAthlete;			
				}
			});
			
			btnGroupAthleteCard.add(rdbtnAthleteCard);
			pnlAthleteCard.add(rdbtnAthleteCard);
			pnlAthletes.add(pnlAthleteCard);
		}
		
		for (int i = counter; i < 13; i ++) {
			JPanel pnlFillGrid = new JPanel();
			pnlFillGrid.setLayout(null);
			pnlAthletes.add(pnlFillGrid);
		}
	}
}
