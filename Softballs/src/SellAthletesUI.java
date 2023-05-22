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

public class SellAthletesUI {

	private JFrame frmSellAthletes;
	private GameEnvironment environment;
	private Market marketManager;
	private Athlete athleteToSell;
	private String athleteName;

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
	
	public void setAthletePanelStats()	{
		athleteName = athleteToSell.getName();
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
		
		JLabel lblPitching_1 = new JLabel("0");
		lblPitching_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPitching_1.setBounds(129, 247, 30, 21);
		PnlAthlete.add(lblPitching_1);
		
		JLabel lblFielding_1 = new JLabel("0");
		lblFielding_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFielding_1.setBounds(129, 215, 30, 21);
		PnlAthlete.add(lblFielding_1);
		
		JLabel lblBatting_1 = new JLabel("0");
		lblBatting_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBatting_1.setBounds(129, 180, 30, 21);
		PnlAthlete.add(lblBatting_1);
		
		JLabel lblNewLabel_1 = new JLabel("0");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(129, 147, 30, 21);
		PnlAthlete.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Sell Athlete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sellAthlete();
				environment.launchSellUI(marketManager);
				closeWindow();
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
					setAthletePanelStats();
				}
			});
			group.add(athleteRadioButton);
			athlete.add(athleteRadioButton);
			athleteRadioButton.setSelected(true);

			panel.add(athlete);
			athleteToSell = currentAthlete;
			
		}
		
		setAthletePanelStats();
		
		System.out.println("Athlete to sell: " + athleteToSell);
		
		frmSellAthletes.getContentPane().add(panel);
		panel.setLayout(new GridLayout(2, 6, 0, 0));
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				environment.launchMainMenu();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.setBounds(22, 456, 109, 30);
		frmSellAthletes.getContentPane().add(btnNewButton_1);
		
	}
}
