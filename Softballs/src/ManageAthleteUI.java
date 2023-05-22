import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class ManageAthleteUI {
	
	private GameEnvironment environment;
	private Manage manageManager;
	private Athlete selectedAthlete;
	private AthleteSmallUI selectedAthleteCard;

	private JFrame frame;
	private JTextField txtClubName;
	private JTextField txtAthleteName;
	



	/**
	 * Create the application.
	 */
	public ManageAthleteUI(GameEnvironment incomingEnvironment, Manage incomingManage) {
		environment = incomingEnvironment;
		manageManager = incomingManage;
		
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public Athlete getSelectedAthlete() {
		return selectedAthlete;
	}
	
	public AthleteSmallUI getSelectedAthleteCard() {
		return selectedAthleteCard;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		String errorClubMessage = "New Club name must be between 3 and 15 characters";
		String errorAthleteMessage = "New Athlete name must be between 3 and 12 characters";

		
		
		
//Create new window
		frame = new JFrame();
		frame.setBounds(100, 100, 1024, 576);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
//Import Top Bar
		JPanel pnlTopBar = new TopBar(environment);
		frame.getContentPane().add(pnlTopBar);

		
		
//Display 3 areas of manage	
		JLabel lblAthletes = new JLabel("Athletes");
		lblAthletes.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblAthletes.setHorizontalAlignment(SwingConstants.CENTER);
		lblAthletes.setBounds(0, 28, 400, 40);
		frame.getContentPane().add(lblAthletes);
		
		JButton btnReserves = new JButton("Line Up");
		btnReserves.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				environment.launchManagePlaying();
			}
		});
		btnReserves.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnReserves.setBounds(400, 28, 304, 40);
		frame.getContentPane().add(btnReserves);
		
		JButton btnPositions = new JButton("Positions");
		btnPositions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				environment.launchManagePositions();
			}
		});
		btnPositions.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPositions.setBounds(704, 28, 304, 40);
		frame.getContentPane().add(btnPositions);
		
	
		
//Empty J label to display error if occurs	
		JLabel lblErrorMessage = new JLabel();
		lblErrorMessage.setVerticalAlignment(SwingConstants.TOP);
		lblErrorMessage.setForeground(Color.RED);
		lblErrorMessage.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblErrorMessage.setHorizontalAlignment(SwingConstants.LEFT);
		lblErrorMessage.setBounds(530, 391, 230, 120);
		frame.getContentPane().add(lblErrorMessage);
		
		
		
//Club name and ability to change it through textfield
		txtClubName = new JTextField(environment.getClub().getName());
		txtClubName.setBounds(40, 79, 450, 40);
		frame.getContentPane().add(txtClubName);
		txtClubName.setColumns(10);
		
		JButton btnChangeClubName = new JButton("Change");
		btnChangeClubName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newName = txtClubName.getText();
				if (newName.length() >= 3 && newName.length() <= 15) {
					environment.getClub().setName(txtClubName.getText());
				}
				else {
					lblErrorMessage.setText("<html>"+ errorClubMessage +"</html>");
				}
			}
		});
		btnChangeClubName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnChangeClubName.setBounds(518, 91, 100, 28);
		frame.getContentPane().add(btnChangeClubName);
		
		
		
//Panel for the selected Athlete card to be displayed in
		JPanel pnlDisplayAthlete = new JPanel();
		pnlDisplayAthlete.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlDisplayAthlete.setBounds(770, 130, 198, 320);
		frame.getContentPane().add(pnlDisplayAthlete);
		pnlDisplayAthlete.setLayout(null);
		
//TextField that displays name so it can be changed
		txtAthleteName = new JTextField();
		txtAthleteName.setHorizontalAlignment(SwingConstants.CENTER);
		txtAthleteName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAthleteName.setBounds(20, 127, 158, 24);
		pnlDisplayAthlete.add(txtAthleteName);
		txtAthleteName.setColumns(10);
		
		JButton btnChangeName = new JButton("Change");
		btnChangeName.setBounds(59, 162, 80, 23);
		pnlDisplayAthlete.add(btnChangeName);
		
//Display Stats
		JLabel lblDisplayStamina = new JLabel("Stamina");
		lblDisplayStamina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDisplayStamina.setBounds(20, 196, 83, 20);
		pnlDisplayAthlete.add(lblDisplayStamina);
		
		JLabel lblDisplayBatting = new JLabel("Batting");
		lblDisplayBatting.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDisplayBatting.setBounds(20, 227, 83, 20);
		pnlDisplayAthlete.add(lblDisplayBatting);
		
		JLabel lblDisplayFielding = new JLabel("Fielding");
		lblDisplayFielding.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDisplayFielding.setBounds(20, 258, 83, 20);
		pnlDisplayAthlete.add(lblDisplayFielding);
		
		JLabel lblDisplayPitching = new JLabel("Pitching");
		lblDisplayPitching.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDisplayPitching.setBounds(20, 289, 97, 20);
		pnlDisplayAthlete.add(lblDisplayPitching);
		
		JLabel lblAthleteImg = new JLabel("");
		lblAthleteImg.setIcon(new ImageIcon(ManageAthleteUI.class.getResource("/img/1367934593.png")));
		lblAthleteImg.setHorizontalAlignment(SwingConstants.CENTER);
		lblAthleteImg.setBounds(20, 11, 158, 109);
		pnlDisplayAthlete.add(lblAthleteImg);
		
		JLabel lblDisplayStaminaNum = new JLabel("");
		lblDisplayStaminaNum.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDisplayStaminaNum.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDisplayStaminaNum.setBounds(98, 196, 80, 20);
		pnlDisplayAthlete.add(lblDisplayStaminaNum);
		
		JLabel lblDisplayBattingNum = new JLabel("");
		lblDisplayBattingNum.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDisplayBattingNum.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDisplayBattingNum.setBounds(98, 227, 80, 20);
		pnlDisplayAthlete.add(lblDisplayBattingNum);
		
		JLabel lblDisplayFieldingNum = new JLabel("");
		lblDisplayFieldingNum.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDisplayFieldingNum.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDisplayFieldingNum.setBounds(98, 258, 80, 20);
		pnlDisplayAthlete.add(lblDisplayFieldingNum);
		
		JLabel lblDisplayPitchingNum = new JLabel("");
		lblDisplayPitchingNum.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDisplayPitchingNum.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDisplayPitchingNum.setBounds(98, 289, 80, 20);
		pnlDisplayAthlete.add(lblDisplayPitchingNum);
		
		
		
//Panel for item cards to be stored in
		JPanel pnlItems = new JPanel();
		pnlItems.setBounds(40, 391, 480, 125);
		frame.getContentPane().add(pnlItems);
		pnlItems.setLayout(new GridLayout(1, 0, 0, 0));
		
//Create an item card for each type of item
		for (int i = 0; i < 4; i++) {
			int index = i;
			Item currentItem = new Item(i);
			ItemUI pnlItemCard = new ItemUI(currentItem);
			int itemAmount = environment.getItems().get(i);
			
			JLabel lblItemAmount = new JLabel(Integer.toString(itemAmount));
			lblItemAmount.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblItemAmount.setHorizontalAlignment(SwingConstants.CENTER);
			lblItemAmount.setBounds(4, 4, 25, 25);
			pnlItemCard.add(lblItemAmount);

			//If the player holds at least one of those items then overlay a button overtop of the card
			if (itemAmount > 0) {
				JButton btnItemCard = new JButton("");
				btnItemCard.setBounds(0, 0, 120, 125);
				btnItemCard.setOpaque(false);
				pnlItemCard.add(btnItemCard);
				btnItemCard.addActionListener(new ActionListener() {
					//When the button is pressed add the stats to the selected athletes and update the card and display
					public void actionPerformed(ActionEvent e) {
						if (environment.getClub().getAthletes().contains(getSelectedAthlete())) {
							getSelectedAthlete().addStats(currentItem.getStats());
							getSelectedAthleteCard().getLblAthleteStaminaNum().setText(Integer.toString(getSelectedAthlete().getCurrentStanima()) + "/" + Integer.toString(getSelectedAthlete().getStat(0)));
							getSelectedAthleteCard().getLblAthleteBattingNum().setText(Integer.toString(getSelectedAthlete().getStat(1)));
							getSelectedAthleteCard().getLblAthleteFieldingNum().setText(Integer.toString(getSelectedAthlete().getStat(2)));
							getSelectedAthleteCard().getLblAthletePitchingNum().setText(Integer.toString(getSelectedAthlete().getStat(3)));
							lblDisplayStaminaNum.setText(Integer.toString(getSelectedAthlete().getCurrentStanima()) + "/" + Integer.toString(getSelectedAthlete().getStat(0)));
							lblDisplayBattingNum.setText(Integer.toString(getSelectedAthlete().getStat(1)));
							lblDisplayFieldingNum.setText(Integer.toString(getSelectedAthlete().getStat(2)));
							lblDisplayPitchingNum.setText(Integer.toString(getSelectedAthlete().getStat(3)));
							
							
							environment.removeItem(index);
							lblItemAmount.setText(Integer.toString(environment.getItems().get(index)));
							if (environment.getItems().get(index) <= 0) {
								btnItemCard.setEnabled(false);
							}
							
						}
						

						
					}
				});

			}
						
			pnlItems.add(pnlItemCard);
		}
		
		

//Panel to store athlete cards
		JPanel pnlAthletes = new JPanel();
		pnlAthletes.setBounds(40, 130, 720, 250);
		frame.getContentPane().add(pnlAthletes);
		pnlAthletes.setLayout(new GridLayout(2, 0, 0, 0));
		
//Create a new group so only one athlete can be selected at a time
		ButtonGroup btnGroupAthleteCard = new ButtonGroup();

//Loop through all athletes and create card
		int counter = 1;
		for (Athlete currentAthlete : environment.getClub().getAthletes()) {
			counter += 1;
			AthleteSmallUI pnlAthleteCard = new AthleteSmallUI(currentAthlete);
			
//Overlay radio button on top of card
			JRadioButton rdbtnAthleteCard = new JRadioButton("");
			rdbtnAthleteCard.setHorizontalAlignment(SwingConstants.RIGHT);
			rdbtnAthleteCard.setVerticalAlignment(SwingConstants.TOP);
			rdbtnAthleteCard.setBounds(0, 0, 120, 125);
			rdbtnAthleteCard.setOpaque(false);

//When the radio button is clicked set the display information to current athletes information
			rdbtnAthleteCard.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					selectedAthlete = currentAthlete;
					selectedAthleteCard = pnlAthleteCard;
					txtAthleteName.setText(currentAthlete.getName());
					lblDisplayStaminaNum.setText(Integer.toString(currentAthlete.getCurrentStanima()) + "/" + Integer.toString(currentAthlete.getStat(0)));
					lblDisplayBattingNum.setText(Integer.toString(currentAthlete.getStat(1)));
					lblDisplayFieldingNum.setText(Integer.toString(currentAthlete.getStat(2)));
					lblDisplayPitchingNum.setText(Integer.toString(currentAthlete.getStat(3)));

//Give the change name button an event handler to change for the given athlete
					btnChangeName.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if (rdbtnAthleteCard.isSelected() == true) {
								String newAthleteName = txtAthleteName.getText();
								if (newAthleteName.length() >= 3 && newAthleteName.length() <= 12) {
									currentAthlete.setName(txtAthleteName.getText());
									pnlAthleteCard.getLblAthleteName().setText(txtAthleteName.getText());
								}
								else {
									lblErrorMessage.setText("<html>"+ errorAthleteMessage +"</html>");
								}

							}

						}
					});				
				}
			});
			
			btnGroupAthleteCard.add(rdbtnAthleteCard);
			pnlAthleteCard.add(rdbtnAthleteCard);
			pnlAthletes.add(pnlAthleteCard);
		}

//Fill the remaining spots in grid with empty panels
		for (int i = counter; i < 13; i ++) {
			JPanel pnlFillGrid = new JPanel();
			pnlFillGrid.setLayout(null);
			pnlAthletes.add(pnlFillGrid);
		}
		

		
//Back to menu
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				environment.launchMainMenu();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack.setBounds(819, 483, 100, 28);
		frame.getContentPane().add(btnBack);
		

	}

}
