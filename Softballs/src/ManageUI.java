import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ManageUI {

	private JFrame frame;
	
	private GameEnvironment environment;
	private Manage manageManager;
	private Athlete selectedAthlete;
	private JTextField athleteNameField;
	private JTextField clubNameField;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ManageUI window = new ManageUI();
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
	public ManageUI(GameEnvironment incomingEnvironment, Manage incomingManage) {
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
		frame = new JFrame();
		frame.setBounds(100, 100, 810, 492);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				environment.launchMainMenu();
			}
		});
		
		JPanel athletePanel = new JPanel();
		athletePanel.setBounds(51, 100, 514, 181);
		frame.getContentPane().add(athletePanel);
		

		
		JPanel itemPanel = new JPanel();
		itemPanel.setBounds(57, 292, 508, 70);
		frame.getContentPane().add(itemPanel);
		
		JPanel infoPanel = new JPanel();
		infoPanel.setBounds(581, 65, 203, 297);
		frame.getContentPane().add(infoPanel);
		infoPanel.setLayout(null);
		
		JLabel statsLabel = new JLabel();
		statsLabel.setBounds(30, 120, 133, 129);
		infoPanel.add(statsLabel);
		

		
		
		athleteNameField = new JTextField();
		athleteNameField.setBounds(10, 89, 122, 20);
		infoPanel.add(athleteNameField);
		athleteNameField.setColumns(10);
		
		JButton changeNameButton = new JButton("Edit");
		changeNameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				selectedAthlete.setName(athleteNameField.getText());
				environment.launchManage();
			}
		});
		changeNameButton.setBounds(134, 88, 59, 23);
		infoPanel.add(changeNameButton);
		backButton.setBounds(366, 388, 89, 23);
		frame.getContentPane().add(backButton);
		
		
		ButtonGroup group = new ButtonGroup();
		
		for (Athlete currentAthlete : environment.getClub().getAthletes()) {
			JRadioButton athleteRadioButton = new JRadioButton(currentAthlete.toString());
			athleteRadioButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					selectedAthlete = currentAthlete;
					athleteNameField.setText(selectedAthlete.getName());
					statsLabel.setText(selectedAthlete.getStats().toString());
					
					//Temp solution
				}
			});
			group.add(athleteRadioButton);
			athletePanel.add(athleteRadioButton);
			athleteRadioButton.setSelected(true);
			selectedAthlete = currentAthlete;
			athleteNameField.setText(selectedAthlete.getName());
			statsLabel.setText(selectedAthlete.getStats().toString());
		}
		
		for (Item currentItem : environment.getItems()) {
			JButton itemButton = new JButton(currentItem.toString());
			itemButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					closeWindow();
					manageManager.useItem(currentItem, selectedAthlete);
					environment.launchManage();
					}
				});
			itemPanel.add(itemButton);		
		}
		
		JButton reservesButton = new JButton("Manage Reserves");
		reservesButton.setBounds(295, 11, 228, 43);
		frame.getContentPane().add(reservesButton);
		
		JButton btnPositions = new JButton("Positions");
		btnPositions.setBounds(533, 11, 228, 43);
		frame.getContentPane().add(btnPositions);
		
		JLabel manageAthleteLabel = new JLabel("Manage Athletes");
		manageAthleteLabel.setBounds(57, 11, 228, 43);
		frame.getContentPane().add(manageAthleteLabel);
		
		clubNameField = new JTextField(environment.getClub().getName());
		clubNameField.setBounds(51, 54, 330, 31);
		frame.getContentPane().add(clubNameField);
		clubNameField.setColumns(10);
		
		JButton changeClubButton = new JButton("Edit");
		changeClubButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				environment.getClub().setName(clubNameField.getText());
				environment.launchManage();
			}
		});
		changeClubButton.setBounds(403, 65, 59, 23);
		frame.getContentPane().add(changeClubButton);
			
		

	}

}
