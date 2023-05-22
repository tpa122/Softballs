import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SellAthletesUI {

	private JFrame frmSellAthletes;
	private GameEnvironment environment;
	private Market marketManager;
	private Athlete athleteToSell;
	private String athleteName;
	private ArrayList<Integer> playerStats;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SellAthletesUI window = new SellAthletesUI();
//					window.frmSellAthletes.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public SellAthletesUI(GameEnvironment incomingEnvironment, Market incomingMarket) {
		environment = incomingEnvironment;
		marketManager = incomingMarket;
		initialize();
		
		frmSellAthletes.setVisible(true);
	}
	
	public void sellAthlete()	{
		marketManager.sellAthlete(athleteToSell);
		
	}
	
	public void closeWindow() {
		frmSellAthletes.dispose();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSellAthletes = new JFrame();
		frmSellAthletes.setTitle("Sell Athletes");
		frmSellAthletes.setBounds(100, 100, 1024, 576);
		frmSellAthletes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSellAthletes.getContentPane().setLayout(null);
		
		JLabel lblNoAthletesPopup = new JLabel("");
		if(environment.getClub().getAthletes().size() == 0)	{
			lblNoAthletesPopup.setText("No Athletes To Sell");
		}
		lblNoAthletesPopup.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoAthletesPopup.setFont(new Font("Tahoma", Font.PLAIN, 52));
		lblNoAthletesPopup.setBounds(109, 55, 598, 357);
		frmSellAthletes.getContentPane().add(lblNoAthletesPopup);
		

		
		JLabel lblSellTitle = new JLabel("Sell Athletes");
		lblSellTitle.setFont(new Font("Tahoma", Font.PLAIN, 41));
		lblSellTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblSellTitle.setBounds(0, 11, 1008, 45);
		frmSellAthletes.getContentPane().add(lblSellTitle);
		
		JPanel PnlAthlete = new JPanel();
		PnlAthlete.setBounds(795, 67, 203, 320);
		frmSellAthletes.getContentPane().add(PnlAthlete);
		PnlAthlete.setLayout(null);
		
		JLabel lblAthleteImg = new JLabel("");
		lblAthleteImg.setIcon(new ImageIcon(SellAthletesUI.class.getResource("/img/1367934593.png")));
		lblAthleteImg.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAthleteImg.setHorizontalAlignment(SwingConstants.CENTER);
		lblAthleteImg.setBounds(0, 11, 203, 74);
		PnlAthlete.add(lblAthleteImg);
		
		JLabel lblPlayerName = new JLabel(athleteName);
		lblPlayerName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPlayerName.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerName.setBounds(0, 96, 203, 40);
		PnlAthlete.add(lblPlayerName);
		
		JLabel lblNewLabel = new JLabel("Stamina");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(53, 147, 74, 21);
		PnlAthlete.add(lblNewLabel);
		
		JLabel lblBatting = new JLabel("Batting");
		lblBatting.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBatting.setBounds(53, 180, 74, 21);
		PnlAthlete.add(lblBatting);
		
		JLabel lblFielding = new JLabel("Fielding");
		lblFielding.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFielding.setBounds(53, 215, 74, 21);
		PnlAthlete.add(lblFielding);
		
		JLabel lblPitching = new JLabel("Pitching");
		lblPitching.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPitching.setBounds(53, 247, 74, 21);
		PnlAthlete.add(lblPitching);
		
		JLabel lblPitchingCount = new JLabel("0");
		lblPitchingCount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPitchingCount.setBounds(129, 247, 30, 21);
		PnlAthlete.add(lblPitchingCount);
		
		JLabel lblFieldingCount = new JLabel("0");
		lblFieldingCount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFieldingCount.setBounds(129, 215, 30, 21);
		PnlAthlete.add(lblFieldingCount);
		
		JLabel lblBattingCount = new JLabel("0");
		lblBattingCount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBattingCount.setBounds(129, 180, 30, 21);
		PnlAthlete.add(lblBattingCount);
		
		JLabel lblStaminaCount = new JLabel("0");
		lblStaminaCount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStaminaCount.setBounds(129, 147, 30, 21);
		PnlAthlete.add(lblStaminaCount);
		
		JButton btnNewButton = new JButton("Sell Athlete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(athleteToSell != null) {
					sellAthlete();
					environment.launchSellUI(marketManager);
					closeWindow();
				}
			}
		});
		btnNewButton.setBounds(795, 456, 203, 34);
		frmSellAthletes.getContentPane().add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JPanel panel = new JPanel();
		panel.setBounds(22, 67, 763, 320);
		
		ButtonGroup group = new ButtonGroup();
		
		for (Athlete currentAthlete : environment.getClub().getAthletes())	{
			AthleteSmallUI athlete = new AthleteSmallUI(currentAthlete);
			JRadioButton athleteRadioButton = new JRadioButton();
			athleteRadioButton.setHorizontalAlignment(SwingConstants.RIGHT);
			athleteRadioButton.setVerticalAlignment(SwingConstants.TOP);
			athleteRadioButton.setBounds(0, 0, 120, 125);
			athleteRadioButton.setOpaque(false);
			athleteRadioButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					athleteToSell = currentAthlete;
//					Update panel stats
					lblPlayerName.setText(athleteToSell.getName());
					lblStaminaCount.setText(String.valueOf(athleteToSell.getStats().get(0)));
					lblBattingCount.setText(String.valueOf(athleteToSell.getStats().get(1)));
					lblFieldingCount.setText(String.valueOf(athleteToSell.getStats().get(2)));
					lblPitchingCount.setText(String.valueOf(athleteToSell.getStats().get(3)));
				}
			});
			group.add(athleteRadioButton);
			athlete.add(athleteRadioButton);
			athleteRadioButton.setSelected(true);

			panel.add(athlete);
			athleteToSell = currentAthlete;
//			Set panel information
			lblPlayerName.setText(athleteToSell.getName());
			lblStaminaCount.setText(String.valueOf(athleteToSell.getStats().get(0)));
			lblBattingCount.setText(String.valueOf(athleteToSell.getStats().get(1)));
			lblFieldingCount.setText(String.valueOf(athleteToSell.getStats().get(2)));
			lblPitchingCount.setText(String.valueOf(athleteToSell.getStats().get(3)));
		}


		
		System.out.println("Athlete to sell: " + athleteToSell);
		
		frmSellAthletes.getContentPane().add(panel);
		panel.setLayout(new GridLayout(2, 6, 0, 0));
		
		JButton btnBackButton = new JButton("Back");
		btnBackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				environment.launchMainMenu();
			}
		});
		btnBackButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBackButton.setBounds(22, 456, 109, 30);
		frmSellAthletes.getContentPane().add(btnBackButton);
		
	}
}
