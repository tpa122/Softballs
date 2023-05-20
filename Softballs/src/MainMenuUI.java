import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenuUI {

	private JFrame frmMainMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenuUI window = new MainMenuUI();
					window.frmMainMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainMenuUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMainMenu = new JFrame();
		frmMainMenu.setTitle("Main Menu");
		frmMainMenu.setBounds(100, 100, 1280, 720);
		frmMainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMainMenu.getContentPane().setLayout(null);
		
		JButton btnStadium = new JButton("Stadium");
		btnStadium.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnStadium.setBounds(552, 270, 147, 33);
		frmMainMenu.getContentPane().add(btnStadium);
		
		JButton btnBye = new JButton("Bye");
		btnBye.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBye.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBye.setBounds(588, 314, 76, 23);
		frmMainMenu.getContentPane().add(btnBye);
		
		JButton btnMarket = new JButton("Market");
		btnMarket.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnMarket.setBounds(552, 348, 147, 33);
		frmMainMenu.getContentPane().add(btnMarket);
		
		JButton btnManageClub = new JButton("Manage Club");
		btnManageClub.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnManageClub.setBounds(552, 400, 147, 33);
		frmMainMenu.getContentPane().add(btnManageClub);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnExit.setBounds(552, 450, 147, 33);
		frmMainMenu.getContentPane().add(btnExit);
		
		JLabel lblWeek = new JLabel("Week:");
		lblWeek.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblWeek.setBounds(33, 42, 55, 33);
		frmMainMenu.getContentPane().add(lblWeek);
		
		JLabel lblWeekCount = new JLabel("1");
		lblWeekCount.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblWeekCount.setBounds(94, 42, 55, 33);
		frmMainMenu.getContentPane().add(lblWeekCount);
		
		JLabel lblPoints = new JLabel("Points:");
		lblPoints.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPoints.setBounds(583, 206, 55, 33);
		frmMainMenu.getContentPane().add(lblPoints);
		
		JLabel lbPointsCount = new JLabel("0");
		lbPointsCount.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbPointsCount.setBounds(644, 206, 55, 33);
		frmMainMenu.getContentPane().add(lbPointsCount);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(MainMenuUI.class.getResource("/img/baseball.png")));
		lblNewLabel_2.setBounds(1144, 566, 110, 104);
		frmMainMenu.getContentPane().add(lblNewLabel_2);
		
		JLabel lblSoftballsLogo = new JLabel("");
		lblSoftballsLogo.setIcon(new ImageIcon(MainMenuUI.class.getResource("/img/Softballs_logo.png")));
		lblSoftballsLogo.setBounds(228, 10, 780, 185);
		frmMainMenu.getContentPane().add(lblSoftballsLogo);
		
		JLabel lblMoney = new JLabel("Money:");
		lblMoney.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblMoney.setBounds(1089, 42, 55, 33);
		frmMainMenu.getContentPane().add(lblMoney);
		
		JLabel lblMoneyCount = new JLabel("0");
		lblMoneyCount.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblMoneyCount.setBounds(1150, 42, 55, 33);
		frmMainMenu.getContentPane().add(lblMoneyCount);
	}

}
