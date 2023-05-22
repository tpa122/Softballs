import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Display end screen
 * Player can see their score and has the option to quit or play again
 * @author Tobias Paull
 *
 */
public class EndScreenUI {
	
	/**
	 * Game environment
	 */
	private GameEnvironment environment;
	/**
	 * If the game was ended due to insufficient funds and players
	 */
	private boolean moneyEnd;

	/**
	 * Window
	 */
	private JFrame frame;



	/**
	 * Create the application and assign variables
	 */
	public EndScreenUI(GameEnvironment incomingEnvironment, boolean endType) {
		environment = incomingEnvironment;
		moneyEnd = endType;
		
		initialize();
		frame.setVisible(true);
	}
	
	/**
	 * Close the window 
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
		
		JLabel lblGameOver = new JLabel("GAME OVER");
		lblGameOver.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameOver.setFont(new Font("Impact", Font.PLAIN, 83));
		lblGameOver.setBounds(239, 70, 529, 116);
		frame.getContentPane().add(lblGameOver);
		
		
//Game info
		JLabel lblPoints = new JLabel("Points " + Integer.toString(environment.getPoints()));
		lblPoints.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoints.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPoints.setBounds(314, 177, 380, 40);
		frame.getContentPane().add(lblPoints);
		
		JLabel lblMoney = new JLabel("Money Gained " + Integer.toString(environment.getMoneyGained()));
		lblMoney.setHorizontalAlignment(SwingConstants.CENTER);
		lblMoney.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMoney.setBounds(314, 228, 380, 40);
		frame.getContentPane().add(lblMoney);
		
		JLabel lblSeasonLength = new JLabel("Season length " + Integer.toString(environment.getEndWeek()));
		lblSeasonLength.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeasonLength.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSeasonLength.setBounds(314, 282, 380, 40);
		frame.getContentPane().add(lblSeasonLength);
		
		
//Panel to store buttons
		JPanel pnlButtonHolder = new JPanel();
		pnlButtonHolder.setBounds(382, 411, 243, 54);
		frame.getContentPane().add(pnlButtonHolder);
		pnlButtonHolder.setLayout(null);
		
		//Restarts game at setup if button is clicked
		JButton btnYes = new JButton("Yes");
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameEnvironment newGame = new GameEnvironment();
				Setup setUpGame = new Setup(newGame);
				newGame.launchSetup(setUpGame);
			}
		});
		btnYes.setBounds(143, 7, 100, 40);
		pnlButtonHolder.add(btnYes);
		btnYes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		//Quits game if button is clicked
		JButton btnNo = new JButton("No");
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
			}
		});
		btnNo.setBounds(0, 7, 100, 40);
		pnlButtonHolder.add(btnNo);
		btnNo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblPlayAgain = new JLabel("Play Again?");
		lblPlayAgain.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblPlayAgain.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayAgain.setBounds(410, 352, 188, 40);
		frame.getContentPane().add(lblPlayAgain);

		
		//If the game was ended due to insufficient funds and players, then inform the player why
		if (moneyEnd == true) {
			JLabel lblMoneyEnd = new JLabel("You did not have enough money or players to continue");
			lblMoneyEnd.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblMoneyEnd.setHorizontalAlignment(SwingConstants.CENTER);
			lblMoneyEnd.setBounds(291, 79, 426, 33);
			frame.getContentPane().add(lblMoneyEnd);
		}
	}

}
