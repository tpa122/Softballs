import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import java.util.ArrayList;
import java.awt.GridLayout;
import javax.swing.JButton;

public class SellItemsUI {

	private JFrame frmSellItems;
	private GameEnvironment environment;
	private Market marketManager;
	private ArrayList<Item> playerItems;
	private Item itemToSell;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SellItemsUI window = new SellItemsUI();
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
	public SellItemsUI(GameEnvironment incomingEnvironment, Market incomingMarket) {
		environment = incomingEnvironment;
		marketManager = incomingMarket;
		initialize();
		frmSellItems.setVisible(true);
	}
	
	public void sellItem()	{
		for(int i = 0; i<=3; i++) {
			Item tempItem = new Item(i);
			if(itemToSell.getName() == tempItem.getName()){
				environment.addMoney(itemToSell.getPrice());
				environment.removeItem(i);
			}
		}
		
	}
	public void closeWindow()	{
		frmSellItems.dispose();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSellItems = new JFrame();
		frmSellItems.setTitle("Sell Items");
		frmSellItems.setBounds(100, 100, 1024, 576);
		frmSellItems.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSellItems.getContentPane().setLayout(null);
		
		ButtonGroup group = new ButtonGroup();
		
		JLabel lblNoItems = new JLabel("");
		lblNoItems.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNoItems.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoItems.setBounds(749, 396, 164, 20);
		frmSellItems.getContentPane().add(lblNoItems);
		
		JPanel panel = new JPanel();
		panel.setBounds(29, 153, 641, 180);
		frmSellItems.getContentPane().add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblSellItems = new JLabel("Sell Items");
		lblSellItems.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblSellItems.setHorizontalAlignment(SwingConstants.CENTER);
		lblSellItems.setBounds(0, 11, 1008, 55);
		frmSellItems.getContentPane().add(lblSellItems);
		
		JButton btnSellItem = new JButton("Sell Item");
		btnSellItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(itemToSell != null){
					sellItem();
					closeWindow();
					SellItemsUI itemSellUI = new SellItemsUI(environment, marketManager);
					System.out.println(itemToSell);
				}	else	{
					lblNoItems.setText("No items to sell");
				}
			}
		});
		btnSellItem.setBounds(749, 354, 164, 31);
		frmSellItems.getContentPane().add(btnSellItem);
		
		JPanel ItemPanel = new JPanel();
		ItemPanel.setBounds(749, 153, 164, 190);
		frmSellItems.getContentPane().add(ItemPanel);
		ItemPanel.setLayout(null);
		
		JLabel lblItemName = new JLabel("Select Item");
		lblItemName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblItemName.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemName.setBounds(0, 11, 164, 32);
		ItemPanel.add(lblItemName);
		
		JLabel lblItemStamina = new JLabel("");
		lblItemStamina.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemStamina.setBounds(0, 48, 164, 23);
		ItemPanel.add(lblItemStamina);
		
		JLabel lblItemBatting = new JLabel("");
		lblItemBatting.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemBatting.setBounds(0, 72, 164, 23);
		ItemPanel.add(lblItemBatting);
		
		JLabel lblItemFielding = new JLabel("");
		lblItemFielding.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemFielding.setBounds(0, 95, 164, 23);
		ItemPanel.add(lblItemFielding);
		
		JLabel lblItemPitching = new JLabel("");
		lblItemPitching.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemPitching.setBounds(0, 119, 164, 23);
		ItemPanel.add(lblItemPitching);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				environment.launchMarket();
				closeWindow();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(29, 491, 89, 23);
		frmSellItems.getContentPane().add(btnNewButton);
		
		
		for(int i = 0; i <= 3; i++)	{
			Item itemForSale = new Item(i);
			System.out.println("Item to sell: " + itemForSale);
			ItemUI itemUISell = new ItemUI(itemForSale);
			
			if(environment.getItems().get(i) > 0) {
				JRadioButton rdbtnItem = new JRadioButton("");
				rdbtnItem.setHorizontalAlignment(SwingConstants.RIGHT);
				rdbtnItem.setVerticalAlignment(SwingConstants.TOP);
				rdbtnItem.setBounds(0, 0, 120, 125);
				rdbtnItem.setOpaque(false);
				rdbtnItem.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						itemToSell = itemForSale;
						lblItemName.setText(itemToSell.getName());
						lblItemStamina.setText(String.valueOf("Stamina: +" + itemToSell.getStats().get(0)));
						lblItemBatting.setText(String.valueOf("Batting: +" + itemToSell.getStats().get(1)));
						lblItemFielding.setText(String.valueOf("Fielding: +" + itemToSell.getStats().get(2)));
						lblItemPitching.setText(String.valueOf("Pitching: +" + itemToSell.getStats().get(3)));
						
			}
		});
				
				JLabel lblCount = new JLabel(String.valueOf(environment.getItems().get(i)));
				lblCount.setFont(new Font("Tahoma", Font.PLAIN, 19));
				lblCount.setBounds(5, 4, 46, 19);
				itemUISell.add(lblCount);
				
//				Automatically set item for sale as last generated item
				itemToSell = itemForSale;
				
				group.add(rdbtnItem);
				rdbtnItem.setSelected(true);
				itemUISell.add(rdbtnItem);
				
				lblItemName.setText(itemToSell.getName());
				lblItemStamina.setText(String.valueOf("Stamina: +" + itemToSell.getStats().get(0)));
				lblItemBatting.setText(String.valueOf("Batting: +" + itemToSell.getStats().get(1)));
				lblItemFielding.setText(String.valueOf("Fielding: +" + itemToSell.getStats().get(2)));
				lblItemPitching.setText(String.valueOf("Pitching: +" + itemToSell.getStats().get(3)));
			}
			
			panel.add(itemUISell);
		}
		
	}

}