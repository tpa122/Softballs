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
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

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
		frame.setBounds(100, 100, 1024, 576);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
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
		
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.addActionListener(new ActionListener() {
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
		btnContinue.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnContinue.setBounds(822, 465, 120, 40);
		frame.getContentPane().add(btnContinue);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, 0, 1008, 69);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblBattingName = new JLabel(matchManager.getBatting().getName());
		lblBattingName.setBounds(25, 0, 570, 69);
		panel.add(lblBattingName);
		lblBattingName.setFont(new Font("Tahoma", Font.PLAIN, 40));
		
		JLabel batttingRunsLabel = new JLabel(String.valueOf(matchManager.getBatting().getRuns()));
		batttingRunsLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		batttingRunsLabel.setBounds(883, 0, 100, 69);
		panel.add(batttingRunsLabel);
		batttingRunsLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		
		int innings = iterativeNum / 2;
		if (innings == 0) {
			JLabel inningsLabel = new JLabel("1st Innings");
			inningsLabel.setBounds(707, 21, 143, 38);
			panel.add(inningsLabel);
			inningsLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		}
		else {
			JLabel inningsLabel = new JLabel("2nd Innings");
			inningsLabel.setBounds(707, 21, 143, 38);
			panel.add(inningsLabel);
			inningsLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		}

		
		
		
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
