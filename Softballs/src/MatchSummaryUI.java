import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JButton;

/**
 * Display the final outcome of the match and the score
 * 
 * @author Tobias Paull
 *
 */
public class MatchSummaryUI {
	
	/**
	 * Game Environment
	 */
	private GameEnvironment environment;
	/**
	 * Match class for methods
	 */
	private Match matchManager;

	/**
	 * Jframe window
	 */
	private JFrame frame;


	/**
	 * Create the application.
	 */
	public MatchSummaryUI(GameEnvironment incomingEnvironment, Match incomingMatch) {
		environment = incomingEnvironment;
		matchManager = incomingMatch;
		initialize();
		frame.setVisible(true);
	}
	
	/**
	 * close window
	 */
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

//Get top bar panel
		JPanel pnlTopBar = new TopBar(environment);
		frame.getContentPane().add(pnlTopBar);
	
	
		JLabel lblMatchSum = new JLabel("MatchSummary");
		lblMatchSum.setHorizontalAlignment(SwingConstants.CENTER);
		lblMatchSum.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblMatchSum.setBounds(339, 39, 329, 50);
		frame.getContentPane().add(lblMatchSum);

		
//Panel to store score
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(140, 89, 726, 78);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblPlayerTeam = new JLabel(environment.getClub().getName() + "       " + environment.getClub().getRuns());
		lblPlayerTeam.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPlayerTeam.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPlayerTeam.setBounds(0, 0, 341, 78);
		panel_1.add(lblPlayerTeam);
		
		JLabel lblOpponentTeam = new JLabel(matchManager.getOpponent().getRuns() + "       " + matchManager.getOpponent().getName());
		lblOpponentTeam.setHorizontalAlignment(SwingConstants.LEFT);
		lblOpponentTeam.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblOpponentTeam.setBounds(384, 0, 342, 78);
		panel_1.add(lblOpponentTeam);
		
		JLabel lblDash = new JLabel("-");
		lblDash.setHorizontalAlignment(SwingConstants.CENTER);
		lblDash.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblDash.setBounds(341, 0, 43, 78);
		panel_1.add(lblDash);
		
		
//Display message depending on outcome
		String outcomeMessage;
		if (environment.getClub().getRuns() > matchManager.getOpponent().getRuns()) {
			outcomeMessage = "You Win!";
		}
		else if (environment.getClub().getRuns() == matchManager.getOpponent().getRuns()) {
			outcomeMessage = "Draw";
		}
		else {
			outcomeMessage = "You Lose";
		}
		
		JLabel lblOutcome = new JLabel(outcomeMessage);
		lblOutcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutcome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblOutcome.setBounds(362, 253, 283, 87);
		frame.getContentPane().add(lblOutcome);

		
//Button back to main menu
		JButton btnContinue = new JButton("Continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				environment.launchMainMenu();
			}
		});
		btnContinue.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnContinue.setBounds(822, 465, 120, 40);
		frame.getContentPane().add(btnContinue);

	}

}
