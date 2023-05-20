import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class MatchInjuryUI {

	private JFrame frame;
	
	private GameEnvironment environment;
	private Match matchManager;
	private boolean lose;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MatchInjuryUI window = new MatchInjuryUI();
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
	public MatchInjuryUI(GameEnvironment incomingEnvironment, Match incomingMatch, boolean incomingLose) {
		environment = incomingEnvironment;
		matchManager = incomingMatch;
		lose = incomingLose;
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
		frame.setBounds(100, 100, 925, 688);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton proceedButton = new JButton("Proceed");
		proceedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				environment.launchMainMenu();
			}
		});
		proceedButton.setBounds(372, 522, 159, 55);
		frame.getContentPane().add(proceedButton);
		
		
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
		outcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		outcomeLabel.setBounds(168, 147, 576, 134);
		frame.getContentPane().add(outcomeLabel);
		
		JLabel outcomeMessageLabel = new JLabel(outcomeMessage);
		outcomeMessageLabel.setBounds(412, 31, 264, 73);
		frame.getContentPane().add(outcomeMessageLabel);
	}

}
