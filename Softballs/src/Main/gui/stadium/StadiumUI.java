package Main.gui.stadium;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import Main.general.GameEnvironment;
import Main.gui.panels.OpponentUI;
import Main.gui.panels.TopBar;
import Main.menu.Club;
import Main.menu.Match;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Color;

/**
 * This class allows the player to choose which opponent they would like to play.
 * 
 * @author Tobias Paull, Daniel Bensley
 * @version 1.0, May 2023.
 *
 */
public class StadiumUI {

	/**
	 * Jframe window.
	 */
	private JFrame frame;
	
	/**
	 * Game Environment.
	 */
	private GameEnvironment environment;
	/**
	 * Selected opponent to play.
	 */
	private Club selectedOpponent;
	
	/**
	 * Button to continue.
	 */
	private JButton btnContinue;
	


	/**
	 * Create the application.
	 */
	public StadiumUI(GameEnvironment incomingEnvironment) {
		environment = incomingEnvironment;
		
		initialize();
		frame.setVisible(true);
	}
	
	/**
	 * Close window.
	 */
	public void closeWindow() {
		frame.dispose();
	}
	
	/**
	 * Gets Selected opponent to play.
	 * @return		 Selected opponent to play.
	 */
	public Club getSelectedOpponent() {
		return selectedOpponent;
	}
	
	
	/**
	 * Used in J unit testing.
	 * @param incomingOpponent			 input from J Unit test.
	 */
	public void setSelectedOpponent(Club incomingOpponent) {
		selectedOpponent = incomingOpponent;
	}
	
	public JButton getBtnContinue() {
		return btnContinue;
	}
	
	/**
	 * determines if player is able to play.
	 * @return		 message telling player to update.
	 */
	public String canPlay() {
		if (environment.getPlayed().contains(getSelectedOpponent())) {
			return "Already Played";
		}
		else if (environment.getClub().getPlaying().size() < 7) {
			//Display GUI: Not enough players on team
			return "Not enough players on team";
		}
		else if (environment.getClub().getPitchers().size() < 2) {
			//Display GUI: Not enough pitchers
			return "Not enough pitchers on team";
		}
		else if (environment.getClub().getBatters().size() < 5) {
			//Display GUI: Not enough batters
			return "Not enough batters on team";
		}
		else {
			return "true";
		}
		
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
	
		
//Top Bar
		JPanel pnlTopBar = new TopBar(environment);
		frame.getContentPane().add(pnlTopBar);
		
		
		
//ErrorMesage box		
		JLabel lblErrorMessage = new JLabel();
		lblErrorMessage.setVerticalAlignment(SwingConstants.TOP);
		lblErrorMessage.setHorizontalAlignment(SwingConstants.LEFT);
		lblErrorMessage.setForeground(Color.RED);
		lblErrorMessage.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblErrorMessage.setBounds(458, 471, 370, 34);
		frame.getContentPane().add(lblErrorMessage);
		

		
//Create a panel for opponent cards		
		ButtonGroup btnGroupOpponentCard = new ButtonGroup();

		//Oponnent1
		JPanel pnlOpponent1Card = new JPanel();
		pnlOpponent1Card.setBounds(75, 137, 230, 285);
		frame.getContentPane().add(pnlOpponent1Card);
		pnlOpponent1Card.setLayout(new GridLayout(0, 1, 0, 0));
		
		OpponentUI Opponent1Card = new OpponentUI(environment, environment.getOpponents().get(0));
		//Add radio button on top of opponent cards
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
		
		
		//Oponnent2
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
		
		
		//Oponnent3
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
		

//Button back to main menu
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
		
		
//Continue button sends through selected opponent to Match
		btnContinue = new JButton("Continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (environment.getOpponents().contains(getSelectedOpponent())) {
					String outMessage = canPlay();
					//If player can't play output reason why
					if (outMessage != "true") {
						lblErrorMessage.setText(outMessage);						
					} 
					else {
						environment.getClub().resetRuns();
						closeWindow();
						environment.getPlayed().add(getSelectedOpponent());
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
				
			}
		});
		btnContinue.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnContinue.setBounds(838, 465, 120, 40);
		frame.getContentPane().add(btnContinue);
	}
}
