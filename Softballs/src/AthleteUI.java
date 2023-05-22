import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class AthleteUI extends JPanel {

	private String athleteName;
	private int athleteStamina;
	private int athleteBatting;
	private int athleteFielding;
	private int athletePitching;
	private SelectTeam selectTeamUI;
	private Athlete athlete;
	private MarketUI playerMarket;
	
	
	
	
	/**
	 * Create the panel.
	 */
	
	
	
	public AthleteUI(Athlete incomingAthlete) {
//		String name, int stamina, int batting, int fielding, int pitching, SelectTeam teamSelect
		athlete = incomingAthlete;
		athleteName = athlete.getName();
		athleteStamina = athlete.getStats().get(0);
		athleteBatting = athlete.getStats().get(1);;
		athleteFielding = athlete.getStats().get(2);;
		athletePitching = athlete.getStats().get(3);;
		
		
		setLayout(null);
		setBounds(100, 100, 175, 206);
		
		JLabel lblPlayerName = new JLabel(athleteName);
		lblPlayerName.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPlayerName.setBounds(10, 75, 150, 25);
		add(lblPlayerName);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setEnabled(false);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(AthleteUI.class.getResource("/img/1367934593.png")));
		lblNewLabel_1.setBounds(30, -11, 110, 100);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Stamina");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(28, 106, 60, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Batting");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(28, 131, 60, 14);
		add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Pitching");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1.setBounds(28, 181, 60, 14);
		add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Fielding");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1_1.setBounds(28, 156, 60, 14);
		add(lblNewLabel_2_1_1_1);
		
		JLabel lblStaminaCount = new JLabel(String.valueOf(athleteStamina));
		lblStaminaCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblStaminaCount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStaminaCount.setBounds(84, 106, 28, 14);
		add(lblStaminaCount);
		
		JLabel lblBattingCount = new JLabel(String.valueOf(athleteBatting));
		lblBattingCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblBattingCount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBattingCount.setBounds(84, 131, 28, 14);
		add(lblBattingCount);
		
		JLabel lblFieldingCount = new JLabel(String.valueOf(athleteFielding));
		lblFieldingCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblFieldingCount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFieldingCount.setBounds(84, 156, 28, 14);
		add(lblFieldingCount);
		
		JLabel lblPitchingCount = new JLabel(String.valueOf(athletePitching));
		lblPitchingCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblPitchingCount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPitchingCount.setBounds(84, 181, 28, 14);
		add(lblPitchingCount);
		
		
		
	}
}
