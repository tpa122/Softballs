import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class MatchUI {

	private JFrame frame;
	
	private GameEnvironment environment;
	private Match matchManager;
	private int iterativeNum;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MatchUI window = new MatchUI();
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
	public MatchUI(GameEnvironment incomingEnvironment, Match incomingMatch, int incomingNum) {
		environment = incomingEnvironment;
		matchManager = incomingMatch;
		iterativeNum = incomingNum;
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
		
		JLabel battingNameLabel = new JLabel(matchManager.getBatting().getName());
		battingNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 51));
		battingNameLabel.setBounds(49, 11, 570, 69);
		frame.getContentPane().add(battingNameLabel);
		
		JLabel batttingRunsLabel = new JLabel(String.valueOf(matchManager.getBatting().getRuns()));
		batttingRunsLabel.setFont(new Font("Tahoma", Font.PLAIN, 51));
		batttingRunsLabel.setBounds(973, 11, 234, 69);
		frame.getContentPane().add(batttingRunsLabel);
		
		JLabel inningsLabel = new JLabel("1st Innings");
		inningsLabel.setFont(new Font("Tahoma", Font.PLAIN, 31));
		inningsLabel.setBounds(708, 34, 183, 38);
		frame.getContentPane().add(inningsLabel);
		
		JLabel out1Label = new JLabel("(Out) " + matchManager.getOutList().get(1).getName() + ", (Pitcher) " + matchManager.getOutList().get(0).getName());
		out1Label.setBounds(60, 132, 346, 32);
		frame.getContentPane().add(out1Label);
		
		JLabel out2Label = new JLabel("(Out) " + matchManager.getOutList().get(3).getName() + ", (Pitcher) " + matchManager.getOutList().get(2).getName());
		out2Label.setBounds(60, 194, 346, 32);
		frame.getContentPane().add(out2Label);
		
		JLabel out3Label = new JLabel("(Out) " + matchManager.getOutList().get(5).getName() + ", (Pitcher) " + matchManager.getOutList().get(4).getName());
		out3Label.setBounds(60, 247, 346, 32);
		frame.getContentPane().add(out3Label);
		
		for (int i = 0; i < matchManager.getInjuryList().size(); i += 2) {
			JLabel injuryLabel = new JLabel("(Injury) " + matchManager.getInjuryList().get(i).getName() + ", (Sub) " + matchManager.getInjuryList().get(i+1).getName());
			injuryLabel.setBounds(60, 313 + i*20, 300, 50);
			frame.getContentPane().add(injuryLabel);
		}

		
		JButton proceedButton = new JButton("Proceed");
		proceedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				if (iterativeNum == 3) {
					environment.launchMainMenu();
				}
				else {
					matchManager.innings(environment.getClub(), matchManager.getOpponent(), iterativeNum + 1);
				}
			}
		});
		proceedButton.setBounds(1000, 586, 153, 50);
		frame.getContentPane().add(proceedButton);
		if (iterativeNum == 3) {
			String outcomeMessage;
			if (environment.getClub().getRuns() > matchManager.getOpponent().getRuns()) {
				outcomeMessage = "You Win";
				environment.addMoney(100);
				environment.addPoints(1000);
			}
			else if (environment.getClub().getRuns() == matchManager.getOpponent().getRuns()) {
				outcomeMessage = "Draw";
				environment.addMoney(30);
				environment.addPoints(300);
			}
			else {
				outcomeMessage = "You Lose";
			}
			JLabel outcomeLabel = new JLabel(outcomeMessage);
			outcomeLabel.setBounds(689, 327, 241, 38);
			frame.getContentPane().add(outcomeLabel);
		}
	}
}
