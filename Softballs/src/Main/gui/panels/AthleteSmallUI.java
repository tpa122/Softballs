package Main.gui.panels;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Main.general.Athlete;

import java.awt.Color;

/**
 * Creates a JPanel or the athletes to be displayed in a small card
 * Used when not enough room for big card
 * 
 * @author Tobias Paull, Daniel Bensley
 *
 */
public class AthleteSmallUI extends JPanel{
	
	/**
	 * Name of Athlete
	 */
	private String name;
	/**
	 * Current stamina of Athlete
	 */
	private String currentStamina;
	/**
	 * Max stamina of Athlete
	 */
	private String stamina;	
	/**
	 * Batting stat of Athlete
	 */
	private String batting;
	/**
	 * Fielding stat of Athlete
	 */
	private String fielding;
	/**
	 * Pitching stat of Athlete
	 */
	private String pitching;
	

//Stored in a way such that methods in UIs can get them without having to refresh the page
	/**
	 * Label for athlete name
	 */
	private JLabel lblAthleteName;
	/**
	 * Label for stamina stat
	 */
	private JLabel lblAthleteStaminaNum;
	/**
	 * Label for batting stat
	 */
	private JLabel lblAthleteBattingNum;
	/**
	 * Label for fielding stat
	 */
	private JLabel lblAthleteFieldingNum;
	/**
	 * label for pitching stat
	 */
	private JLabel lblAthletePitchingNum;
	




	/**
	 * Gets info then creates label
	 */
	public AthleteSmallUI(Athlete incomingAthlete) {
		name = incomingAthlete.getName();
		currentStamina = Integer.toString(incomingAthlete.getCurrentStanima());
		
		ArrayList<Integer> stats = incomingAthlete.getStats();
		stamina = Integer.toString(stats.get(0));
		batting = Integer.toString(stats.get(1));
		fielding = Integer.toString(stats.get(2));
		pitching = Integer.toString(stats.get(3));
		setBorder(new LineBorder(new Color(0, 0, 0)));
		
		
		initialize();
	}

	/**
	 * Initialize the contents of the card
	 */
	private void initialize() {
		//Size of card
		setBounds(100, 100, 120, 125);
		setLayout(null);

		
//Displays info of athlete
		lblAthleteName = new JLabel(name);
		lblAthleteName.setBounds(10, 15, 100, 14);
		lblAthleteName.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAthleteName.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblAthleteName);
		
		JLabel lblAthleteStamina = new JLabel("Stamina");
		lblAthleteStamina.setBounds(10, 37, 58, 14);
		add(lblAthleteStamina);
		
		JLabel lblAthleteBatting = new JLabel("Batting");
		lblAthleteBatting.setBounds(10, 59, 46, 14);
		add(lblAthleteBatting);
		
		JLabel lblAthleteFielding = new JLabel("Fielding");
		lblAthleteFielding.setBounds(10, 81, 46, 14);
		add(lblAthleteFielding);
		
		JLabel lblAthletePitching = new JLabel("Pitching");
		lblAthletePitching.setBounds(10, 103, 46, 14);
		add(lblAthletePitching);

		
//Numerical stats of athlete
		lblAthleteStaminaNum = new JLabel(currentStamina + "/" + stamina);
		lblAthleteStaminaNum.setBounds(64, 37, 46, 14);
		lblAthleteStaminaNum.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblAthleteStaminaNum);
		
		lblAthleteBattingNum = new JLabel(batting);
		lblAthleteBattingNum.setBounds(64, 59, 46, 14);
		lblAthleteBattingNum.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblAthleteBattingNum);
		
		lblAthleteFieldingNum = new JLabel(fielding);
		lblAthleteFieldingNum.setBounds(64, 81, 46, 14);
		lblAthleteFieldingNum.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblAthleteFieldingNum);
		
		lblAthletePitchingNum = new JLabel(pitching);
		lblAthletePitchingNum.setBounds(64, 103, 46, 14);
		lblAthletePitchingNum.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblAthletePitchingNum);	
	

	}
	
	/**
	 * Gets name of athlete
	 * @return name of athlete
	 */
	public JLabel getLblAthleteName() {
		return lblAthleteName;
	}
	
	/**
	 * Gets athlete stamina stat
	 * @return athlete stamina stat
	 */
	public JLabel getLblAthleteStaminaNum() {
		return lblAthleteStaminaNum;
	}
	
	/**
	 * Gets athlete stamina stat
//	 * @return athlete batting stat
	 */
	public JLabel getLblAthleteBattingNum() {
		return lblAthleteBattingNum;
	}
	
	/**
	 * Gets athlete fielding stat
	 * @return athlete fielding stat
	 */
	public JLabel getLblAthleteFieldingNum() {
		return lblAthleteFieldingNum;
	}
	
	/**
	 * Gets athlete fielding stat
//	 * @return athlete pitching stat
	 */
	public JLabel getLblAthletePitchingNum() {
		return lblAthletePitchingNum;
	}

}
