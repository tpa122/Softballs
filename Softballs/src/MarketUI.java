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

public class MarketUI {

	private JFrame frmMarket;
	
	private GameEnvironment environment;
	private Market marketManager;
	private Item itemToBuy;
	private Athlete athleteToBuy;
	private int playOrReserve = 0;
	private ArrayList<Athlete> purchasableAthletes;
	private ArrayList<Integer> purchasableItemsIndex;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MarketUI window = new MarketUI();
//					window.frmMarket.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public MarketUI(GameEnvironment incomingEnvironment, Market incomingMarket) {
		environment = incomingEnvironment;
		marketManager = incomingMarket;
		initialize();
		
		frmMarket.setVisible(true);
	}
	
	public void setAthleteToBuy(Athlete incomingAthlete)	{
		athleteToBuy = incomingAthlete;
	}
	
	public void purchaseAthlete()	{
		marketManager.purchaseAthlete(athleteToBuy, playOrReserve);
	}
	public void purchaseItem()	{
		for(int i = 0; i<=3; i++) {
			Item tempItem = new Item(i);
			if(itemToBuy.getName() == tempItem.getName()){
				marketManager.purchaseItem(i);
			}
		}
		
	}
	
	public void launchSellMenu()	{
		environment.launchSellUI(marketManager);
		closeWindow();
	}
	
	
//	public void isPlaying()
	
	public void closeWindow() {
		frmMarket.dispose();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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
		
		JLabel lblPlayerMoney = new JLabel("");
		lblPlayerMoney.setBounds(822, 11, 135, 14);
		frmMarket.getContentPane().add(lblPlayerMoney);
		lblPlayerMoney.setText("Money: " + String.valueOf(environment.getMoney()));
		
		JLabel lblTeamFull = new JLabel("");
		lblTeamFull.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeamFull.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTeamFull.setBounds(807, 312, 135, 33);
		frmMarket.getContentPane().add(lblTeamFull);

		
		JLabel lblMarket = new JLabel("Market");
		lblMarket.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarket.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblMarket.setBounds(0, 0, 1008, 44);
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
		panel.setBounds(25, 47, 700, 204);
		panel.setLayout(new GridLayout(0, 4, 0, 0));
		ButtonGroup group = new ButtonGroup();
		
		frmMarket.getContentPane().add(panel);
		
		
		
		purchasableAthletes = environment.getPurchasableAthletes();
		for(int i=0; i<=3; i++) {
			Athlete athleteForPurchase = purchasableAthletes.get(i);
			AthleteUI athlete = new AthleteUI(athleteForPurchase);
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
			System.out.println("Item to buy: " + itemForPurchase);
			ItemUI itemUIPurchase = new ItemUI(itemForPurchase);
			
			if(purchasableItemsIndex.get(i) > 0) {
				JRadioButton rdbtnItem = new JRadioButton("");
				rdbtnItem.setHorizontalAlignment(SwingConstants.RIGHT);
				rdbtnItem.setVerticalAlignment(SwingConstants.TOP);
				rdbtnItem.setBounds(0, 0, 175, 206);
				rdbtnItem.setOpaque(false);
				rdbtnItem.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						itemToBuy = itemForPurchase;
						System.out.println(itemToBuy);
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
		
//		System.out.println("Athlete:" + athleteToBuy);
//		System.out.println("Item: " + itemToBuy);
		
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
					System.out.println("All athletes and items purchased");
//					If item or athlete is a valid object, check which is valid
				}	else	{
//					If athleteToBuy is not valid, purchase item
					if(athleteToBuy == null)	{
						if(playerMoney >= itemToBuy.getPrice())	{
							lblNotEnoughMoney.setText("");
							purchaseItem();
							environment.launchMarket();
							closeWindow();
						}	else	{
							lblNotEnoughMoney.setText("Not enough money");
							System.out.println("Not enough Money to purchase Item");
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
							lblNotEnoughMoney.setText("Not enough money");
							System.out.println("Not enough Money");
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