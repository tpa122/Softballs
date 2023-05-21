import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class ManageUI {

	private JFrame frame;
	
	private GameEnvironment environment;
	private Manage manageManager;
	private Athlete selectedAthlete;
	private JTextField athleteNameField;
	private JTextField clubNameField;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ManageUI window = new ManageUI();
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
	public ManageUI(GameEnvironment incomingEnvironment, Manage incomingManage) {
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
		
		JLabel lblBlur = new JLabel("");
		lblBlur.setBounds(0, 0, 1008, 537);
		lblBlur.setBackground(new Color(0, 0, 0, 150));
		lblBlur.setOpaque(true);
		frame.getContentPane().add(lblBlur);

//Top Bar
		
		
		
		
		

		
		JButton reservesButton = new JButton("Manage Reserves");
		reservesButton.setBounds(400, 27, 304, 43);
		frame.getContentPane().add(reservesButton);
		
		JButton btnPositions = new JButton("Positions");
		btnPositions.setBounds(702, 27, 304, 43);
		frame.getContentPane().add(btnPositions);
		
		JLabel lblManage = new JLabel("Manage");
		lblManage.setHorizontalAlignment(SwingConstants.CENTER);
		lblManage.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblManage.setBackground(new Color(255, 255, 255));
		lblManage.setForeground(new Color(255, 255, 255));
		lblManage.setBounds(0, 27, 400, 43);
		frame.getContentPane().add(lblManage);
		
		JPanel pnlTopBar = new JPanel();
		pnlTopBar.setBackground(new Color(0, 0, 0, 150));
		pnlTopBar.setBounds(0, 0, 1008, 28);
		frame.getContentPane().add(pnlTopBar);
		pnlTopBar.setLayout(null);
		
		JLabel lblWeek = new JLabel("Week: " + environment.getCurrentWeek());
		lblWeek.setForeground(new Color(255, 255, 255));
		lblWeek.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblWeek.setBounds(23, 4, 97, 20);
		pnlTopBar.add(lblWeek);
		
		JLabel lblPoints = new JLabel("Points: " + environment.getPoints());
		lblPoints.setForeground(new Color(255, 255, 255));
		lblPoints.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPoints.setBounds(468, 4, 107, 20);
		pnlTopBar.add(lblPoints);
		
		JLabel lblMoney = new JLabel("Money: " + environment.getMoney());
		lblMoney.setForeground(new Color(255, 255, 255));
		lblMoney.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMoney.setBounds(901, 4, 97, 20);
		pnlTopBar.add(lblMoney);
		
		JPanel pnlGeneralDisplay = new JPanel();
		pnlGeneralDisplay.setBackground(new Color(0, 0, 0, 150));
		pnlGeneralDisplay.setBounds(730, 81, 252, 434);
		frame.getContentPane().add(pnlGeneralDisplay);
		pnlGeneralDisplay.setLayout(null);
		
		JButton backButton = new JButton("Back");
		backButton.setBounds(86, 383, 89, 23);
		pnlGeneralDisplay.add(backButton);
		
		JPanel infoPanel = new JPanel();
		infoPanel.setBounds(22, 42, 203, 297);
		pnlGeneralDisplay.add(infoPanel);
		infoPanel.setLayout(null);
		
		JLabel statsLabel = new JLabel();
		statsLabel.setBounds(38, 120, 133, 129);
		infoPanel.add(statsLabel);
		

		
		
		athleteNameField = new JTextField();
		athleteNameField.setBounds(10, 89, 122, 20);
		infoPanel.add(athleteNameField);
		athleteNameField.setColumns(10);
		
		JButton changeNameButton = new JButton("Edit");
		changeNameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				selectedAthlete.setName(athleteNameField.getText());
				environment.launchManage();
			}
		});
		changeNameButton.setBounds(134, 86, 59, 23);
		infoPanel.add(changeNameButton);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				environment.launchMainMenu();
			}
		});
		
		JPanel pnlGeneral = new JPanel();
		pnlGeneral.setBounds(26, 81, 677, 434);
		pnlGeneral.setBackground(new Color(0, 0, 0, 150));
		frame.getContentPane().add(pnlGeneral);
		

		

		

		
		pnlGeneral.setLayout(null);
		
		JPanel athletePanel = new JPanel();
		athletePanel.setBounds(10, 84, 657, 156);
		athletePanel.setOpaque(false);
		pnlGeneral.add(athletePanel);
		
		clubNameField = new JTextField(environment.getClub().getName());
		clubNameField.setForeground(Color.WHITE);
		clubNameField.setBounds(10, 11, 330, 38);
		clubNameField.setOpaque(false);
		pnlGeneral.add(clubNameField);
		clubNameField.setColumns(10);
		
		JButton changeClubButton = new JButton("Edit");
		changeClubButton.setBounds(364, 19, 59, 23);
		pnlGeneral.add(changeClubButton);
		

		

		
		JPanel itemPanel = new JPanel();
		itemPanel.setBounds(10, 280, 629, 70);
		pnlGeneral.add(itemPanel);
		
//Background and Blur	
		JLabel lblBackgroundImg = new JLabel("");
		lblBackgroundImg.setIcon(new ImageIcon(ManageUI.class.getResource("/img/ManageImg.jpg")));
		lblBackgroundImg.setBounds(0, 0, 1008, 537);
		frame.getContentPane().add(lblBackgroundImg);
		
		changeClubButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				environment.getClub().setName(clubNameField.getText());
				environment.launchManage();
			}
		});
		
		
		ButtonGroup group = new ButtonGroup();
		
		for (Athlete currentAthlete : environment.getClub().getAthletes()) {
			JRadioButton athleteRadioButton = new JRadioButton(currentAthlete.toString());
			athleteRadioButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					selectedAthlete = currentAthlete;
					athleteNameField.setText(selectedAthlete.getName());
					statsLabel.setText(selectedAthlete.getStats().toString());
					
					//Temp solution
				}
			});
			group.add(athleteRadioButton);
			athletePanel.add(athleteRadioButton);
			athleteRadioButton.setSelected(true);
			selectedAthlete = currentAthlete;
			athleteNameField.setText(selectedAthlete.getName());
			statsLabel.setText(selectedAthlete.getStats().toString());
		}
		
		for (Item currentItem : environment.getItems()) {
			JButton itemButton = new JButton(currentItem.toString());
			itemButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					closeWindow();
					manageManager.useItem(currentItem, selectedAthlete);
					environment.launchManage();
					}
				});
			itemPanel.add(itemButton);		
		}
		

	}

}
