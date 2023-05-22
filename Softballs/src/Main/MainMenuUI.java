package Main;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Allow user to navigate to differnt area of the game
 * 
 * @author Tobias Paull
 *
 */
public class MainMenuUI {

	/**
	 * Jframe window
	 */
	private JFrame frmMainMenu;
	
	/**
	 * Game environment
	 */
	private GameEnvironment environment;


	/**
	 * Create the application.
	 */
	public MainMenuUI(GameEnvironment incomingEnvironment) {
		environment = incomingEnvironment;
		initialize();
		frmMainMenu.setVisible(true);
	}
	
	/**
	 * close the main menu window
	 */
	public void closeWindow() {
		frmMainMenu.dispose();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMainMenu = new JFrame();
		frmMainMenu.setTitle("Main Menu");
		frmMainMenu.setBounds(100, 100, 1024, 576);
		frmMainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMainMenu.getContentPane().setLayout(null);
		frmMainMenu.setResizable(false);

//Top bar containing currentWeek, points and money
		JPanel pnlTopBar = new TopBar(environment);
		frmMainMenu.getContentPane().add(pnlTopBar);
	
//Buttons to take you to the different parts of the game
		JButton btnStadium = new JButton("Stadium");
		btnStadium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				environment.launchStadium();
			}
		});
		btnStadium.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnStadium.setBounds(424, 270, 160, 33);
		frmMainMenu.getContentPane().add(btnStadium);
		
		JButton btnBye = new JButton("Bye");
		btnBye.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				environment.launchBye();
			}
		});
		btnBye.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBye.setBounds(466, 314, 76, 23);
		frmMainMenu.getContentPane().add(btnBye);
		
		JButton btnMarket = new JButton("Market");
		btnMarket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				environment.launchMarket();
			}
		});
		btnMarket.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnMarket.setBounds(424, 348, 160, 33);
		frmMainMenu.getContentPane().add(btnMarket);
		
		JButton btnManageClub = new JButton("Manage Club");
		btnManageClub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				environment.launchManage();
			}
		});
		btnManageClub.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnManageClub.setBounds(424, 392, 160, 33);
		frmMainMenu.getContentPane().add(btnManageClub);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExit.setBounds(466, 436, 76, 23);
		frmMainMenu.getContentPane().add(btnExit);

//Background and logo
		JLabel lblSoftballsLogo = new JLabel("");
		lblSoftballsLogo.setIcon(new ImageIcon(MainMenuUI.class.getResource("/img/Softballs_logo.png")));
		lblSoftballsLogo.setBounds(114, 36, 780, 185);
		frmMainMenu.getContentPane().add(lblSoftballsLogo);
		
		JLabel lblBackgroundimg = new JLabel("");
		lblBackgroundimg.setIcon(new ImageIcon(MainMenuUI.class.getResource("/img/MainMenuImg.jpg")));
		lblBackgroundimg.setBounds(0, 0, 1008, 537);
		frmMainMenu.getContentPane().add(lblBackgroundimg);
	}
}
