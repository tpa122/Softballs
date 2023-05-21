import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ManageReservesUI {

	private JFrame frame;
	
	private GameEnvironment environment;
	private Manage manageManager;



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
		athletePanel.setBounds(51, 87, 710, 160);
		frame.getContentPane().add(athletePanel);
		

		
		
		athleteNameField = new JTextField();
		athleteNameField.setBounds(10, 89, 122, 20);
		athleteNameField.setColumns(10);
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
		
		JButton btnPositions = new JButton("Positions");
		btnPositions.setBounds(533, 11, 228, 43);
		frame.getContentPane().add(btnPositions);
		
		clubNameField = new JTextField(environment.getClub().getName());
		clubNameField.setBounds(51, 54, 330, 31);
		frame.getContentPane().add(clubNameField);
		clubNameField.setColumns(10);
		
		JLabel mngReservesLabel = new JLabel("Manage Reserves");
		mngReservesLabel.setBounds(295, 11, 228, 43);
		frame.getContentPane().add(mngReservesLabel);
		
		JButton mngAthletesButton = new JButton("Manage Athletes");
		mngAthletesButton.setBounds(57, 11, 228, 43);
		frame.getContentPane().add(mngAthletesButton);
			
		

	}

}
