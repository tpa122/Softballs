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

public class ByeUI {

	private JFrame frame;
	
	private GameEnvironment environment;
	private Bye byeManager;
	private Athlete trainingAthlete;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ByeUI window = new ByeUI();
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
		frame.setBounds(100, 100, 798, 528);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				environment.launchMainMenu();
				
			}
		});
		backButton.setBounds(326, 398, 89, 23);
		frame.getContentPane().add(backButton);
		
		JPanel athletePanel = new JPanel();
		athletePanel.setBounds(79, 47, 598, 247);
		frame.getContentPane().add(athletePanel);
		
		JButton proceedButton = new JButton("Take a bye");
		proceedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (environment.getClub().getAthletes().contains(trainingAthlete));{
					closeWindow();
					byeManager.takeBye(trainingAthlete);
					environment.launchMainMenu();
				}
			}
		});
		proceedButton.setBounds(272, 327, 179, 41);
		frame.getContentPane().add(proceedButton);
		
		JLabel infoLabel = new JLabel("Select a Athlete for special traning");
		infoLabel.setBounds(328, 22, 179, 14);
		frame.getContentPane().add(infoLabel);
		

		

		ButtonGroup group = new ButtonGroup();
		
		for (Athlete currentAthlete : environment.getClub().getAthletes()) {
			JRadioButton athleteRadioButton = new JRadioButton(currentAthlete.toString());
			athleteRadioButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					trainingAthlete = currentAthlete;
				}
			});
			group.add(athleteRadioButton);
			athletePanel.add(athleteRadioButton);
			
		}

		
		JLabel tempLabel = new JLabel("SuperTemp");
		tempLabel.setBounds(343, 91, 46, 14);
	}
}
