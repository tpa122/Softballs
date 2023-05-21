import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

public class StadiumUI {

	private JFrame frame;
	
	private GameEnvironment environment;
	private Stadium stadiumManager;
	private Club selectedOpponent;
	

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
	
	public Club getSelectedOpponent() {
		return selectedOpponent;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1024, 576);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel pnlTopBar = new TopBar(environment);
		frame.getContentPane().add(pnlTopBar);
		
		
		
		ButtonGroup btnGroupOpponentCard = new ButtonGroup();

		JPanel pnlOpponent1Card = new JPanel();
		pnlOpponent1Card.setBounds(75, 137, 230, 285);
		frame.getContentPane().add(pnlOpponent1Card);
		pnlOpponent1Card.setLayout(new GridLayout(0, 1, 0, 0));
		
		OpponentUI Opponent1Card = new OpponentUI(environment, environment.getOpponents().get(0));
		
		JRadioButton rdbtnOpponent1Card = new JRadioButton("");
		rdbtnOpponent1Card.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedOpponent = environment.getOpponents().get(0);
			}
		});
		rdbtnOpponent1Card.setHorizontalAlignment(SwingConstants.RIGHT);
		rdbtnOpponent1Card.setVerticalAlignment(SwingConstants.TOP);
		rdbtnOpponent1Card.setBounds(0, 0, 230, 280);
		rdbtnOpponent1Card.setOpaque(false);
		btnGroupOpponentCard.add(rdbtnOpponent1Card);
		Opponent1Card.add(rdbtnOpponent1Card);
		
		pnlOpponent1Card.add(Opponent1Card);
		
		
		JPanel pnlOpponent2Card = new JPanel();
		pnlOpponent2Card.setBounds(389, 137, 230, 285);
		frame.getContentPane().add(pnlOpponent2Card);
		pnlOpponent2Card.setLayout(new GridLayout(0, 1, 0, 0));
		
		OpponentUI Opponent2Card = new OpponentUI(environment, environment.getOpponents().get(1));
		
		JRadioButton rdbtnOpponent2Card = new JRadioButton("");
		rdbtnOpponent2Card.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedOpponent = environment.getOpponents().get(1);

			}
		});
		rdbtnOpponent2Card.setHorizontalAlignment(SwingConstants.RIGHT);
		rdbtnOpponent2Card.setVerticalAlignment(SwingConstants.TOP);
		rdbtnOpponent2Card.setBounds(0, 0, 230, 280);
		rdbtnOpponent2Card.setOpaque(false);
		btnGroupOpponentCard.add(rdbtnOpponent2Card);
		Opponent2Card.add(rdbtnOpponent2Card);
		
		pnlOpponent2Card.add(Opponent2Card);
		
		
		JPanel pnlOpponent3Card = new JPanel();
		pnlOpponent3Card.setBounds(703, 137, 230, 285);
		frame.getContentPane().add(pnlOpponent3Card);
		pnlOpponent3Card.setLayout(new GridLayout(0, 1, 0, 0));
		
		OpponentUI Opponent3Card = new OpponentUI(environment, environment.getOpponents().get(2));
		
		JRadioButton rdbtnOpponent3Card = new JRadioButton("");
		rdbtnOpponent3Card.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedOpponent = environment.getOpponents().get(2);

			}
		});
		rdbtnOpponent3Card.setHorizontalAlignment(SwingConstants.RIGHT);
		rdbtnOpponent3Card.setVerticalAlignment(SwingConstants.TOP);
		rdbtnOpponent3Card.setBounds(0, 0, 230, 280);
		rdbtnOpponent3Card.setOpaque(false);
		btnGroupOpponentCard.add(rdbtnOpponent3Card);
		Opponent3Card.add(rdbtnOpponent3Card);
		
		pnlOpponent3Card.add(Opponent3Card);
		

		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				environment.launchMainMenu();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack.setBounds(50, 465, 100, 40);
		frame.getContentPane().add(btnBack);
		
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (environment.getOpponents().contains(getSelectedOpponent())) {
					Match gameMatch = new Match(environment, getSelectedOpponent());
					var startingRoll = Math.random();
					
					if (startingRoll <= 0.5) {
						gameMatch.innings(environment.getClub(), selectedOpponent, 0);
					}
					else {
						gameMatch.innings(selectedOpponent, environment.getClub(), 0);
					}
				}
				
			}
		});
		btnContinue.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnContinue.setBounds(838, 465, 120, 40);
		frame.getContentPane().add(btnContinue);
	}
}
