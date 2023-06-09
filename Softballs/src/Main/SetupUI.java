package Main;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

/**
 * This setup UI allows the player to set the initial conditions for their
 * game, such as their team name, difficulty and season length.
 * 
 * @author Tobias Paull, Daniel Bensley
 * @version 1.0, May 2023.
 *
 */
public class SetupUI {

	/**
	 * The application window frame.
	 */
	private JFrame frmSetup;
	
	/**
	 * The text field for the team name.
	 */
	private JTextField textFieldTeamName;
	
	/**
	 * The manager class to interact with.
	 */
	private Setup setupManager;
	
	/**
	 * The difficulty of the game.
	 */
	private int Difficulty = 0;
	
	/**
	 * The game environment to interact with.
	 */
	private GameEnvironment environment;


	/**
	 * Create the application window
	 * 
	 * @param incomingSetup			the setup class to interact with
	 */
	public SetupUI(Setup incomingSetup) {
//		Set initial values for the variables
		setupManager = incomingSetup;
		environment = setupManager.environment;
//		Initialize and display on the screen
		initialize();
		frmSetup.setVisible(true);
	}

	/**
	 * Closes itself
	 */
	public void closeWindow()	{
		frmSetup.dispose();
	}
	/**
	 * Launches the application window to select your initial team
	 */
	public void launchTeamSelect()	{
		environment.launchTeamSelect(this, setupManager);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSetup = new JFrame();
		frmSetup.setTitle("Set Up Team");
		frmSetup.setBounds(100, 100, 1024, 576);
		frmSetup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSetup.getContentPane().setLayout(null);
		frmSetup.setResizable(false);
		
		JLabel lblSoftballsTitle = new JLabel("");
		lblSoftballsTitle.setBounds(-3, 0, 1014, 191);
		lblSoftballsTitle.setIcon(new ImageIcon(SetupUI.class.getResource("/img/Softballs_logo.png")));
		lblSoftballsTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoftballsTitle.setFont(new Font("Tahoma", Font.PLAIN, 47));
		frmSetup.getContentPane().add(lblSoftballsTitle);
		
		JLabel lblTeamName = new JLabel("Enter Team Name:");
		lblTeamName.setBounds(-128, 228, 1264, 21);
		frmSetup.getContentPane().add(lblTeamName);
		lblTeamName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTeamName.setHorizontalAlignment(SwingConstants.CENTER);
		
		textFieldTeamName = new JTextField();
		textFieldTeamName.setToolTipText("3 to 15 letters");
		textFieldTeamName.setBounds(366, 260, 275, 20);
		frmSetup.getContentPane().add(textFieldTeamName);
		textFieldTeamName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Season Length:");
		lblNewLabel_2.setBounds(413, 338, 182, 26);
		frmSetup.getContentPane().add(lblNewLabel_2);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblNewLabel_3 = new JLabel("Difficulty:");
		lblNewLabel_3.setBounds(461, 412, 85, 21);
		frmSetup.getContentPane().add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JButton btnNormalDifficulty = new JButton("Normal");
		btnNormalDifficulty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Difficulty = 0;
			}
		});
		btnNormalDifficulty.setBounds(400, 444, 89, 23);
		frmSetup.getContentPane().add(btnNormalDifficulty);
		btnNormalDifficulty.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JButton btnHardDifficulty = new JButton("Hard");
		btnHardDifficulty.setBounds(501, 444, 89, 23);
		frmSetup.getContentPane().add(btnHardDifficulty);
		btnHardDifficulty.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblWeek = new JLabel("Weeks");
		lblWeek.setBounds(637, 375, 75, 26);
		frmSetup.getContentPane().add(lblWeek);
		lblWeek.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblWeekCount = new JLabel("10");
		lblWeekCount.setBounds(600, 375, 45, 26);
		frmSetup.getContentPane().add(lblWeekCount);
		lblWeekCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeekCount.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JSlider sliderWeek = new JSlider();
		sliderWeek.setMinimum(5);
		sliderWeek.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				lblWeekCount.setText(String.valueOf(sliderWeek.getValue()));
			}
		});
		sliderWeek.setValue(10);
		sliderWeek.setMaximum(15);
		sliderWeek.setBounds(404, 375, 200, 26);
		frmSetup.getContentPane().add(sliderWeek);

//Gets all the information selected and passes through to setupManager to assign to Game Environment
		JButton btnNewButton = new JButton("Next");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((textFieldTeamName.getText()).length() >= 3 & (textFieldTeamName.getText()).length() <=15)	{
					setupManager.setClubName(textFieldTeamName.getText());
					setupManager.chooseWeek(sliderWeek.getValue());
					setupManager.chooseDifficulty(String.valueOf(Difficulty));
					launchTeamSelect();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(459, 491, 89, 23);
		frmSetup.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Team name must be between 3 and 15 characters");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(381, 291, 246, 20);
		frmSetup.getContentPane().add(lblNewLabel);
		
		btnHardDifficulty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Difficulty = 1;
			}
		});
	}
}
