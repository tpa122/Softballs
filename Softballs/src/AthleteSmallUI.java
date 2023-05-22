import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class AthleteSmallUI extends JPanel{
	
	private String name;
	private String currentStamina;
	private String stamina;	
	private String batting;
	private String fielding;
	private String pitching;
	private int totalStats;
	
	private JPanel athletePanel;
	private JLabel lblAthleteName;
	private JLabel lblAthleteStaminaNum;
	private JLabel lblAthleteBattingNum;
	private JLabel lblAthleteFieldingNum;
	private JLabel lblAthletePitchingNum;
	




	/**
	 * Create the application.
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
//		totalStats = stats.get(0) + stats.get(1) + stats.get(2) + stats.get(3);
//		if (totalStats == 400) {
//			setBorder(new LineBorder(new Color(255, 200, 0)));
//		}
//		else if (totalStats >= 320){
//			setBorder(new LineBorder(new Color(255, 0, 255)));
//		} else if (totalStats >= 250) {
//			setBorder(new LineBorder(new Color(0, 0, 255)));
//		} else {
//			setBorder(new LineBorder(new Color(0, 255, 0)));
//			
//		}
		
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 120, 125);
		setLayout(null);
		
		
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
	
	public JLabel getLblAthleteName() {
		return lblAthleteName;
	}
	
	public JLabel getLblAthleteStaminaNum() {
		return lblAthleteStaminaNum;
	}
	
	public JLabel getLblAthleteBattingNum() {
		return lblAthleteBattingNum;
	}
	
	public JLabel getLblAthleteFieldingNum() {
		return lblAthleteFieldingNum;
	}
	
	public JLabel getLblAthletePitchingNum() {
		return lblAthletePitchingNum;
	}

}
