package Main;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.GridLayout;

/**
 * This class implents an interactable UI to sell and purchase
 * items and athletes from the market
 * 
 * @author Tobias Paull, Daniel Bensley
 * @version 1.0, May 2023.
 *
 */
public class MarketUI {

	/**
	 * The application window frame
	 */
	private JFrame frmMarket;
	
	/**
	 * The environment to interact with
	 */
	private GameEnvironment environment;
	/**
	 * The market to interact with
	 */
	private Market marketManager;
	/**
	 * The chosen item to purchase
	 */
	private Item itemToBuy;
	/**
	 * The chosen athlete to purchase
	 */
	private Athlete athleteToBuy;
	/**
	 * Whether a purchased athlete should be put into
	 * player or reserves
	 */
	private int playOrReserve = 0;
	/**
	 * The array of purchasable athletes
	 */
	private ArrayList<Athlete> purchasableAthletes;
	/**
	 * The array of purchasable items indexes
	 */
	private ArrayList<Integer> purchasableItemsIndex;

	/**
	 * Create the application.
	 */
	public MarketUI(GameEnvironment incomingEnvironment, Market incomingMarket) {
//		Set game environment and marketManager
		environment = incomingEnvironment;
		marketManager = incomingMarket;
//		Create application frame
		initialize();
//		Show Market Window
		frmMarket.setVisible(true);
		frmMarket.setResizable(false);
	}
	
	/**
	 * Sets the athlete chosen to be bought
	 * 
	 * @param incomingAthlete		Athlete chosen to be purchased
	 */
	public void setAthleteToBuy(Athlete incomingAthlete)	{
		athleteToBuy = incomingAthlete;
	}
	
	/**
	 * Purchases the chosen athlete along with whether they
	 * are in the playing team or reserve team
	 */
	public void purchaseAthlete()	{
		marketManager.purchaseAthlete(athleteToBuy, playOrReserve);
	}
	/**
	 * Purchase the chosen item
	 */
	public void purchaseItem()	{
//		Generate temporary items to match with indexes
		for(int i = 0; i<=3; i++) {
			Item tempItem = new Item(i);
			if(itemToBuy.getName() == tempItem.getName()){
				marketManager.purchaseItem(i);
			}
		}
		
	}
	
	/**
	 * Launches the sell athletes menu
	 */
	public void launchSellMenu()	{
		environment.launchSellUI(marketManager);
		closeWindow();
	}
	
	
	/**
	 * Closes its' own window application
	 */
	public void closeWindow() {
		frmMarket.dispose();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
//		Set labels, athletes, items
		
		frmMarket = new JFrame();
		frmMarket.setTitle("Market");
		frmMarket.setBounds(100, 100, 1024, 576);
		frmMarket.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMarket.getContentPane().setLayout(null);
		
		JLabel lblNotEnoughMoney = new JLabel("");
		lblNotEnoughMoney.setHorizontalAlignment(SwingConstants.CENTER);
		lblNotEnoughMoney.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNotEnoughMoney.setBounds(807, 260, 135, 33);
		frmMarket.getContentPane().add(lblNotEnoughMoney);
		
		JLabel lblTeamFull = new JLabel("");
		lblTeamFull.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeamFull.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTeamFull.setBounds(807, 312, 135, 33);
		frmMarket.getContentPane().add(lblTeamFull);

		JPanel pnlTopBar = new TopBar(environment);
		frmMarket.getContentPane().add(pnlTopBar);
		
		JLabel lblMarket = new JLabel("Market");
		lblMarket.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarket.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblMarket.setBounds(749, 96, 249, 44);
		frmMarket.getContentPane().add(lblMarket);
		
		
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				environment.launchMainMenu();
			}
		});
		backButton.setBounds(828, 356, 89, 23);
		frmMarket.getContentPane().add(backButton);
		
		JToggleButton tglbtnTogglePlaying = new JToggleButton("Playing");
		tglbtnTogglePlaying.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(playOrReserve == 0) {
					playOrReserve = 1;
					tglbtnTogglePlaying.setText("Reserve");
				}	else	{
					tglbtnTogglePlaying.setText("Playing");
					playOrReserve = 0;
				}
			}
			
		});
		tglbtnTogglePlaying.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tglbtnTogglePlaying.setBounds(807, 228, 135, 23);
		frmMarket.getContentPane().add(tglbtnTogglePlaying);
		

		
		JPanel panel = new JPanel();
		panel.setBounds(25, 47, 700, 214);
		panel.setLayout(new GridLayout(0, 4, 0, 0));
		ButtonGroup group = new ButtonGroup();
		
		frmMarket.getContentPane().add(panel);
		
		
		
		purchasableAthletes = environment.getPurchasableAthletes();
		for(int i=0; i<=3; i++) {
			Athlete athleteForPurchase = purchasableAthletes.get(i);
			AthleteUI athlete = new AthleteUI(athleteForPurchase);
//			Display cost
			JLabel lblCost = new JLabel("$" + String.valueOf(athleteForPurchase.getPrice()));
			lblCost.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblCost.setHorizontalAlignment(SwingConstants.RIGHT);
			lblCost.setVerticalAlignment(SwingConstants.TOP);
			lblCost.setBounds(0, 0, 145, 206);
			athlete.add(lblCost);
			
//			Check if athlete already purchased
			if(environment.getPurchasedAthletes().contains(athleteForPurchase))	{
						;
					}	else	{
						JRadioButton rdbtnNewRadioButton = new JRadioButton("");
						rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.RIGHT);
						rdbtnNewRadioButton.setVerticalAlignment(SwingConstants.TOP);
						rdbtnNewRadioButton.setBounds(0, 0, 175, 206);
						rdbtnNewRadioButton.setOpaque(false);
						rdbtnNewRadioButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								athleteToBuy = athleteForPurchase;
								itemToBuy = null;
					}
				});
				group.add(rdbtnNewRadioButton);
				athlete.add(rdbtnNewRadioButton);
				

				rdbtnNewRadioButton.setSelected(true);
				athleteToBuy = athleteForPurchase;
				itemToBuy = null;
 
			}
			
			panel.add(athlete);



		

	}


		JPanel panel_1 = new JPanel();
		panel_1.setBounds(25, 262, 700, 182);
		frmMarket.getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(0, 4, 0, 0));
		
		purchasableItemsIndex = environment.getPurchasableItems();
		for(int i = 0; i <= 3; i++)	{
			Item itemForPurchase = new Item(i);
			ItemUI itemUIPurchase = new ItemUI(itemForPurchase);
			
			
			JLabel lblItemCost = new JLabel("$" + String.valueOf(itemForPurchase.getPrice()));
			lblItemCost.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblItemCost.setVerticalAlignment(SwingConstants.TOP);
			lblItemCost.setHorizontalAlignment(SwingConstants.RIGHT);
			lblItemCost.setBounds(0, 0, 145, 125);
			itemUIPurchase.add(lblItemCost);
			
			if(purchasableItemsIndex.get(i) > 0) {
				JRadioButton rdbtnItem = new JRadioButton("");
				rdbtnItem.setHorizontalAlignment(SwingConstants.RIGHT);
				rdbtnItem.setVerticalAlignment(SwingConstants.TOP);
				rdbtnItem.setBounds(0, 0, 175, 206);
				rdbtnItem.setOpaque(false);
				rdbtnItem.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						itemToBuy = itemForPurchase;
						athleteToBuy = null;
			}
		});
				
				JLabel lblCount = new JLabel(String.valueOf(environment.getPurchasableItems().get(i)));
				lblCount.setFont(new Font("Tahoma", Font.PLAIN, 19));
				lblCount.setBounds(5, 4, 46, 19);
				itemUIPurchase.add(lblCount);
				
//				automatically set itemToBuy. Set athleteToBuy to null
				athleteToBuy = null;
				itemToBuy = itemForPurchase;
				
				group.add(rdbtnItem);
				rdbtnItem.setSelected(true);
				itemUIPurchase.add(rdbtnItem);
			}
			
			panel_1.add(itemUIPurchase);
		}
		
		
		JLabel lblNewLabel = new JLabel("Add player to:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(807, 202, 135, 23);
		frmMarket.getContentPane().add(lblNewLabel);
		
		JButton btnSellButton = new JButton("Sell Players");
		btnSellButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				launchSellMenu();
				
			}
		});
		btnSellButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnSellButton.setBounds(807, 467, 125, 23);
		frmMarket.getContentPane().add(btnSellButton);
		
		JButton btnPurchase = new JButton("Purchase");
		btnPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int playerMoney = environment.getMoney();
//				If buying player or item
//				Check if there are athletes/items left to purchase
				if(athleteToBuy == null && itemToBuy == null)	{
				}	else	{
//					If athleteToBuy is not valid, purchase item
					if(athleteToBuy == null)	{
						if(playerMoney >= itemToBuy.getPrice())	{
							lblNotEnoughMoney.setText("");
							purchaseItem();
							environment.launchMarket();
							closeWindow();
						}	else	{
//							If the player doesn't have enough money, display error text
							lblNotEnoughMoney.setText("Not enough money");
						}
//						Assume itemToBuy is not valid, purchase Athlete
					}	else	{
						if(playerMoney >= athleteToBuy.getPrice())	{
							if(environment.getClub().getAthletes().size() == 12)	{
								lblTeamFull.setText("Team is full");
								lblNotEnoughMoney.setText("");
							}	else	{
								lblNotEnoughMoney.setText("");
								purchaseAthlete();
								environment.launchMarket();
								closeWindow();
							}
							
						}	else	{
//							If the player doesn't have enough money, display error text
							lblNotEnoughMoney.setText("Not enough money");

						}
					}
						
				}
				
			}
		});
		btnPurchase.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPurchase.setBounds(807, 167, 135, 33);
		frmMarket.getContentPane().add(btnPurchase);
		
		JButton btnSellItems = new JButton("Sell items");
		btnSellItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SellItemsUI itemSellUI = new SellItemsUI(environment, marketManager);
				closeWindow();
			}
		});
		btnSellItems.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnSellItems.setBounds(807, 503, 125, 23);
		frmMarket.getContentPane().add(btnSellItems);


		
}
}