



import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ManageReservesUI {

	private GameEnvironment environment;
	private Manage manageManager;


	private JFrame frame;

	



	/**
	 * Create the application.
	 */
	public ManageReservesUI(GameEnvironment incomingEnvironment, Manage incomingManage) {
		environment = incomingEnvironment;
		manageManager = incomingManage;
		
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
		
		JPanel pnlTopBar = new TopBar(environment);
		frame.getContentPane().add(pnlTopBar);

		
//		JPanel pnlTopBar = new JPanel();
//		pnlTopBar.setBounds(0, 0, 1008, 28);
//		frame.getContentPane().add(pnlTopBar);
//		pnlTopBar.setLayout(null);
//		
//		JLabel lblWeek = new JLabel("Week: " + environment.getCurrentWeek());
//		lblWeek.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		lblWeek.setBounds(23, 4, 100, 20);
//		pnlTopBar.add(lblWeek);
//		
//		JLabel lblPoints = new JLabel("Points: " + environment.getPoints());
//		lblPoints.setHorizontalAlignment(SwingConstants.CENTER);
//		lblPoints.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		lblPoints.setBounds(454, 4, 100, 20);
//		pnlTopBar.add(lblPoints);
//		
//		JLabel lblMoney = new JLabel("Money: " + environment.getMoney());
//		lblMoney.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		lblMoney.setBounds(885, 4, 100, 20);
//		pnlTopBar.add(lblMoney);
		
		JLabel lblReserves = new JLabel("Reserves");
		lblReserves.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblReserves.setHorizontalAlignment(SwingConstants.CENTER);
		lblReserves.setBounds(304, 28, 400, 40);
		frame.getContentPane().add(lblReserves);
		
		JButton btnAthletes = new JButton("Athletes");
		btnAthletes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAthletes.setBounds(0, 28, 304, 40);
		frame.getContentPane().add(btnAthletes);
		
		JButton btnPositions = new JButton("Positions");
		btnPositions.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPositions.setBounds(704, 28, 304, 40);
		frame.getContentPane().add(btnPositions);
	}

}
