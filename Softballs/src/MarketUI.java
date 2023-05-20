import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MarketUI {

	private JFrame frmMarket;
	
	private GameEnvironment environment;
	private Market marketManager;

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
		
		AthleteUI athleteUI = new AthleteUI();
		athleteUI.setBounds(181, 139, 175, 222);
		frmMarket.getContentPane().add(athleteUI);
		
		AthleteUI athleteUI_1 = new AthleteUI();
		athleteUI_1.setBounds(415, 139, 175, 222);
		frmMarket.getContentPane().add(athleteUI_1);
		
		AthleteUI athleteUI_1_1 = new AthleteUI();
		athleteUI_1_1.setBounds(646, 139, 175, 222);
		frmMarket.getContentPane().add(athleteUI_1_1);
		
		AthleteUI athleteUI_1_1_1 = new AthleteUI();
		athleteUI_1_1_1.setBounds(880, 139, 175, 222);
		frmMarket.getContentPane().add(athleteUI_1_1_1);
		
		JButton btnPurchase = new JButton("Purchase");
		btnPurchase.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPurchase.setBounds(1119, 621, 135, 33);
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
	}
}
