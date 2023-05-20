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

public class AthleteUI extends JPanel {

	/**
	 * Create the panel.
	 */
	public AthleteUI() {
		setLayout(null);
		
		JLabel lblPlayerName = new JLabel("Name");
		lblPlayerName.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPlayerName.setBounds(10, 87, 150, 25);
		add(lblPlayerName);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setEnabled(false);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(AthleteUI.class.getResource("/img/1367934593.png")));
		lblNewLabel_1.setBounds(30, 0, 110, 100);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Stamina");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(20, 121, 60, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Batting");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(20, 146, 60, 14);
		add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Pitching");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1.setBounds(20, 196, 60, 14);
		add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Fielding");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1_1.setBounds(20, 171, 60, 14);
		add(lblNewLabel_2_1_1_1);
		
		JLabel lblStaminaCount = new JLabel("0");
		lblStaminaCount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStaminaCount.setBounds(90, 121, 14, 14);
		add(lblStaminaCount);
		
		JLabel lblBattingCount = new JLabel("0");
		lblBattingCount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBattingCount.setBounds(90, 146, 14, 14);
		add(lblBattingCount);
		
		JLabel lblFieldingCount = new JLabel("0");
		lblFieldingCount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFieldingCount.setBounds(90, 171, 14, 14);
		add(lblFieldingCount);
		
		JLabel lblPitchingCount = new JLabel("0");
		lblPitchingCount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPitchingCount.setBounds(90, 196, 14, 14);
		add(lblPitchingCount);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("/100");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2_1.setBounds(120, 123, 40, 14);
		add(lblNewLabel_2_2_1);

	}
}
