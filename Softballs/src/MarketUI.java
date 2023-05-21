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
	private Athlete athleteToBuy;
	private int playOrReserve = 0;

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
	
	public void setAthletesUI()	{
		
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
		frmMarket.setBounds(100, 100, 1280, 720);
		frmMarket.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMarket.getContentPane().setLayout(null);
		
		JLabel lblMarket = new JLabel("Market");
		lblMarket.setFont(new Font("Tahoma", Font.PLAIN, 64));
		lblMarket.setBounds(511, 11, 201, 166);
		frmMarket.getContentPane().add(lblMarket);
		
		JButton btnPurchase = new JButton("Purchase");
		btnPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int playerMoney = environment.getMoney();
				if(playerMoney >= athleteToBuy.getPrice())	{
					purchaseAthlete();

				}	else	{
					System.out.println("Not enough Money");
				}
			}
		});
		btnPurchase.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPurchase.setBounds(1119, 574, 135, 33);
		frmMarket.getContentPane().add(btnPurchase);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				environment.launchMainMenu();
			}
		});
		backButton.setBounds(560, 599, 89, 23);
		frmMarket.getContentPane().add(backButton);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("Playing");
		tglbtnNewToggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		tglbtnNewToggleButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tglbtnNewToggleButton.setBounds(1129, 618, 121, 23);
		frmMarket.getContentPane().add(tglbtnNewToggleButton);
		

		
		JPanel panel = new JPanel();
		panel.setBounds(203, 188, 809, 192);
		
		ButtonGroup group = new ButtonGroup();
		
		frmMarket.getContentPane().add(panel);
		ArrayList<Athlete> purchasableAthletes = environment.getPurchasableAthletes();
		for(int i=0; i<=3; i++) {
			Athlete athleteForPurchase = purchasableAthletes.get(i);
			AthleteUI athlete = new AthleteUI(this, athleteForPurchase);
//			Check if athlete already purchased
			if(environment.getPurchasedAthletes().contains(athleteForPurchase))	{
						;
					}	else	{
						JRadioButton rdbtnNewRadioButton = new JRadioButton("");
						rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.RIGHT);
						rdbtnNewRadioButton.setVerticalAlignment(SwingConstants.TOP);
						rdbtnNewRadioButton.setBounds(0, 0, 174, 230);
						rdbtnNewRadioButton.setOpaque(false);
						rdbtnNewRadioButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								athleteToBuy = athleteForPurchase;
					}
				});
				athlete.add(rdbtnNewRadioButton);
				
				group.add(rdbtnNewRadioButton);
				rdbtnNewRadioButton.setSelected(true);
				athleteToBuy = athleteForPurchase;
			}
			
			panel.add(athlete);
			
		}

		panel.setLayout(new GridLayout(0, 4, 0, 0));
	}
}
