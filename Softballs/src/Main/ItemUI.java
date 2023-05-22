package Main;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JButton;

/**
 * Displays an item and its information in card like fashion
 * 
 * @author Tobias Paull
 *
 */
public class ItemUI extends JPanel{
	
	/**
	 * name of item
	 */
	private String name;
	/**
	 * Stamina stat of item
	 */
	private String stamina;	
	/**
	 * Batting stat of item
	 */
	private String batting;
	/**
	 * Fielding stat of item
	 */
	private String fielding;
	/**
	 * Pitching stat of item
	 */
	private String pitching;



	/**
	 * Create the card and assign info
	 */
	public ItemUI(Item incomingItem) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		name = incomingItem.getName();
		
		ArrayList<Integer> stats = incomingItem.getStats();
		stamina = Integer.toString(stats.get(0));
		batting = Integer.toString(stats.get(1));
		fielding = Integer.toString(stats.get(2));
		pitching = Integer.toString(stats.get(3));
		
		initialize();
	}

	/**
	 * Initialize the contents of the panel
	 */
	private void initialize() {
		setBounds(100, 100, 120, 125);
		setLayout(null);

//Name label
		JLabel lblItemName = new JLabel(name);
		lblItemName.setBounds(10, 15, 100, 14);
		lblItemName.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblItemName.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblItemName);

//General labels
		JLabel lblItemStamina = new JLabel("Stamina");
		lblItemStamina.setBounds(10, 37, 58, 14);
		add(lblItemStamina);
		
		JLabel lblItemBatting = new JLabel("Batting");
		lblItemBatting.setBounds(10, 59, 46, 14);
		add(lblItemBatting);
		
		JLabel lblItemFielding = new JLabel("Fielding");
		lblItemFielding.setBounds(10, 81, 46, 14);
		add(lblItemFielding);
		
		JLabel lblItemPitching = new JLabel("Pitching");
		lblItemPitching.setBounds(10, 103, 46, 14);
		add(lblItemPitching);

//Stat num labels
		JLabel lblItemStaminaNum = new JLabel("+ " + stamina);
		lblItemStaminaNum.setBounds(64, 37, 46, 14);
		lblItemStaminaNum.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblItemStaminaNum);
		
		JLabel lblItemBattingNum = new JLabel("+ " + batting);
		lblItemBattingNum.setBounds(64, 59, 46, 14);
		lblItemBattingNum.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblItemBattingNum);
		
		JLabel lblItemFieldingNum = new JLabel("+ " + fielding);
		lblItemFieldingNum.setBounds(64, 81, 46, 14);
		lblItemFieldingNum.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblItemFieldingNum);
		
		JLabel lblItemPitchingNum = new JLabel("+ " + pitching);
		lblItemPitchingNum.setBounds(64, 103, 46, 14);
		lblItemPitchingNum.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblItemPitchingNum);
	}
}
