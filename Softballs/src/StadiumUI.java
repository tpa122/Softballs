import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StadiumUI {

	private JFrame frame;
	
	private GameEnvironment environment;
	private Stadium stadiumManager;
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					StadiumUI window = new StadiumUI();
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
	public StadiumUI(GameEnvironment incomingEnvironment, Stadium incomingStadium) {
		environment = incomingEnvironment;
		stadiumManager = incomingStadium;
		
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblStadium = new JLabel("Stadium");
		lblStadium.setFont(new Font("Tahoma", Font.PLAIN, 97));
		lblStadium.setHorizontalAlignment(SwingConstants.CENTER);
		lblStadium.setBounds(0, 0, 1264, 147);
		frame.getContentPane().add(lblStadium);
		
		JButton opponent1Button = new JButton(environment.getOpponents().get(0).getName());
		opponent1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				Match gameMatch = new Match(environment, environment.getOpponents().get(0));
				gameMatch.innings(environment.getClub(), gameMatch.getOpponent(), 0);		
			}
		});
		opponent1Button.setBounds(183, 320, 175, 179);
		frame.getContentPane().add(opponent1Button);
		
		JButton opponent2Button = new JButton(environment.getOpponents().get(1).getName());
		opponent2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				Match gameMatch = new Match(environment, environment.getOpponents().get(1));
				gameMatch.innings(environment.getClub(), gameMatch.getOpponent(), 0);	
			}
		});
		opponent2Button.setBounds(511, 320, 175, 179);
		frame.getContentPane().add(opponent2Button);
		
		JButton opponent3Button = new JButton(environment.getOpponents().get(2).getName());
		opponent3Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				Match gameMatch = new Match(environment, environment.getOpponents().get(2));
				gameMatch.innings(environment.getClub(), gameMatch.getOpponent(), 0);	
			}
		});
		opponent3Button.setBounds(875, 320, 175, 179);
		frame.getContentPane().add(opponent3Button);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				environment.launchMainMenu();
			}
		});
		backButton.setBounds(556, 585, 130, 43);
		frame.getContentPane().add(backButton);
	}
}
