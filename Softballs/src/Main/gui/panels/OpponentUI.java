package Main.gui.panels;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Main.general.GameEnvironment;
import Main.menu.Club;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

/**
 * Display opponents in card like form.
 * 
 * @author Tobias Paull, Daniel Bensley
 * @version 1.0, May 2023.
 */
public class OpponentUI extends JPanel {
	
	/**
	 * Game Environment
	 */
	private GameEnvironment environment;
	/**
	 * Name of club
	 */
	private String name;

	/**
	 * Gets info then create the panel.
	 */
	public OpponentUI(GameEnvironment incomingEnvironment, Club incomingClub) {
		environment = incomingEnvironment;
		name = incomingClub.getName();

		initialize();

	}
	
	/**
	 * Initialize the contents of the panel
	 */
	public void initialize() {
		setBounds(100, 100, 230, 280);
		
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(null);

//Display general info
		JLabel lblOpponentName = new JLabel(name);
		lblOpponentName.setHorizontalAlignment(SwingConstants.CENTER);
		lblOpponentName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblOpponentName.setBounds(10, 24, 210, 60);
		add(lblOpponentName);
		
		JLabel lblMoney = new JLabel("Money");
		lblMoney.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMoney.setBounds(20, 157, 80, 20);
		add(lblMoney);
		
		JLabel lblPoints = new JLabel("Points");
		lblPoints.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPoints.setBounds(20, 209, 80, 20);
		add(lblPoints);

		
//Depending on difficulty display different rewards
		if (environment.getDifficulty() == 0) {
			JLabel lblMoneyNum = new JLabel("100");
			lblMoneyNum.setHorizontalAlignment(SwingConstants.RIGHT);
			lblMoneyNum.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblMoneyNum.setBounds(130, 157, 80, 20);
			add(lblMoneyNum);
			
			JLabel lblPointsNum = new JLabel("1000");
			lblPointsNum.setHorizontalAlignment(SwingConstants.RIGHT);
			lblPointsNum.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblPointsNum.setBounds(130, 209, 80, 20);
			add(lblPointsNum);
		}
		else {
			JLabel lblMoneyNum = new JLabel("70");
			lblMoneyNum.setHorizontalAlignment(SwingConstants.RIGHT);
			lblMoneyNum.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblMoneyNum.setBounds(130, 157, 80, 20);
			add(lblMoneyNum);
			
			JLabel lblPointsNum = new JLabel("1500");
			lblPointsNum.setHorizontalAlignment(SwingConstants.RIGHT);
			lblPointsNum.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblPointsNum.setBounds(130, 209, 80, 20);
			add(lblPointsNum);
		}				
	}
}
