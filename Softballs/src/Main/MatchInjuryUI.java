package Main;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

/**
 * Display when a team has lost due to to many injured players
 * 
 * @author Tobias Paull
 *
 */
public class MatchInjuryUI {

	/**
	 * Jframe Window
	 */
	private JFrame frame;
	
	/**
	 * Game Environment
	 */
	private GameEnvironment environment;
	/**
	 * Match class
	 */
	private Match matchManager;
	/**
	 * Whether the player lost or the opponent
	 */
	private boolean lose;


	/**
	 * Create the application.
	 */
	public MatchInjuryUI(GameEnvironment incomingEnvironment, Match incomingMatch, boolean incomingLose) {
		environment = incomingEnvironment;
		matchManager = incomingMatch;
		lose = incomingLose;
		initialize();
		frame.setVisible(true);
		frame.setResizable(false);
	}
	
	public void closeWindow() {
		frame.dispose();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1024, 576);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

//Import top bar panel
		JPanel pnlTopBar = new TopBar(environment);
		frame.getContentPane().add(pnlTopBar);
	
		
		
//	Create message depending on who lost
		String injuredClub;
		String outcomeMessage;
		if (lose == true) {
			injuredClub = environment.getClub().getName();
			outcomeMessage = "You Lose";
		}
		else {
			injuredClub = matchManager.getOpponent().getName();
			outcomeMessage = "You Win";
		}
		
		
		JLabel outcomeLabel = new JLabel(injuredClub + " does not have enough un-injured players to continue and therefore forfeits");
		outcomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		outcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		outcomeLabel.setBounds(134, 180, 739, 104);
		frame.getContentPane().add(outcomeLabel);
		
		JLabel outcomeMessageLabel = new JLabel(outcomeMessage);
		outcomeMessageLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		outcomeMessageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		outcomeMessageLabel.setBounds(372, 96, 264, 73);
		frame.getContentPane().add(outcomeMessageLabel);

//Button back to main menu
		JButton btnContinue = new JButton("Continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				environment.launchMainMenu();
			}
		});
		btnContinue.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnContinue.setBounds(444, 465, 120, 40);
		frame.getContentPane().add(btnContinue);
	}

}
