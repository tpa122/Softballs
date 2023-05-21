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
		frame = new JFrame();
		frame.setBounds(100, 100, 1024, 576);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JPanel pnlTopBar = new TopBar(environment);
		frame.getContentPane().add(pnlTopBar);

		
		JLabel lblAthletes = new JLabel("Athletes");
		lblAthletes.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblAthletes.setHorizontalAlignment(SwingConstants.CENTER);
		lblAthletes.setBounds(0, 28, 400, 40);
		frame.getContentPane().add(lblAthletes);
		
		JButton btnReserves = new JButton("Reserves");
		btnReserves.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnReserves.setBounds(400, 28, 304, 40);
		frame.getContentPane().add(btnReserves);
		
		JButton btnPositions = new JButton("Positions");
		btnPositions.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPositions.setBounds(704, 28, 304, 40);
		frame.getContentPane().add(btnPositions);
		
		txtClubName = new JTextField(environment.getClub().getName());
		txtClubName.setBounds(40, 79, 450, 40);
		frame.getContentPane().add(txtClubName);
		txtClubName.setColumns(10);
		
		JButton btnChangeClubName = new JButton("Change");
		btnChangeClubName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				environment.getClub().setName(txtClubName.getText());
			}
		});
		btnChangeClubName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnChangeClubName.setBounds(518, 91, 100, 28);
		frame.getContentPane().add(btnChangeClubName);
		
		JPanel pnlDisplayAthlete = new JPanel();
		pnlDisplayAthlete.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlDisplayAthlete.setBounds(770, 130, 198, 320);
		frame.getContentPane().add(pnlDisplayAthlete);
		pnlDisplayAthlete.setLayout(null);
		
		txtAthleteName = new JTextField();
		txtAthleteName.setHorizontalAlignment(SwingConstants.CENTER);
		txtAthleteName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAthleteName.setBounds(20, 127, 158, 24);
		pnlDisplayAthlete.add(txtAthleteName);
		txtAthleteName.setColumns(10);
		
		JButton btnChangeName = new JButton("Change");
		btnChangeName.setBounds(59, 162, 80, 23);
		pnlDisplayAthlete.add(btnChangeName);
		
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
		
		JPanel pnlItems = new JPanel();
		pnlItems.setBounds(40, 391, 480, 125);
		frame.getContentPane().add(pnlItems);
		pnlItems.setLayout(new GridLayout(1, 0, 0, 0));
		
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
			
			if (itemAmount > 0) {
				JButton btnItemCard = new JButton("");
				btnItemCard.setBounds(0, 0, 120, 125);
				btnItemCard.setOpaque(false);
				pnlItemCard.add(btnItemCard);
				btnItemCard.addActionListener(new ActionListener() {
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
		
		
		JPanel pnlAthletes = new JPanel();
		pnlAthletes.setBounds(40, 130, 720, 250);
		frame.getContentPane().add(pnlAthletes);
		pnlAthletes.setLayout(new GridLayout(2, 0, 0, 0));
		
		
		ButtonGroup btnGroupAthleteCard = new ButtonGroup();
		
		int counter = 1;
		for (Athlete currentAthlete : environment.getClub().getAthletes()) {
			counter += 1;
			AthleteSmallUI pnlAthleteCard = new AthleteSmallUI(currentAthlete);
			
			JRadioButton rdbtnAthleteCard = new JRadioButton("");
			rdbtnAthleteCard.setHorizontalAlignment(SwingConstants.RIGHT);
			rdbtnAthleteCard.setVerticalAlignment(SwingConstants.TOP);
			rdbtnAthleteCard.setBounds(0, 0, 120, 125);
			rdbtnAthleteCard.setOpaque(false);
			
			rdbtnAthleteCard.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					selectedAthlete = currentAthlete;
					selectedAthleteCard = pnlAthleteCard;
					txtAthleteName.setText(currentAthlete.getName());
					lblDisplayStaminaNum.setText(Integer.toString(currentAthlete.getCurrentStanima()) + "/" + Integer.toString(currentAthlete.getStat(0)));
					lblDisplayBattingNum.setText(Integer.toString(currentAthlete.getStat(1)));
					lblDisplayFieldingNum.setText(Integer.toString(currentAthlete.getStat(2)));
					lblDisplayPitchingNum.setText(Integer.toString(currentAthlete.getStat(3)));
					
					btnChangeName.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if (rdbtnAthleteCard.isSelected() == true) {
								currentAthlete.setName(txtAthleteName.getText());
								pnlAthleteCard.getLblAthleteName().setText(txtAthleteName.getText());
							}

						}
					});				
				}
			});
			
			btnGroupAthleteCard.add(rdbtnAthleteCard);
			pnlAthleteCard.add(rdbtnAthleteCard);
			pnlAthletes.add(pnlAthleteCard);
		}
		
		for (int i = counter; i < 13; i ++) {
			JPanel pnlFillGrid = new JPanel();
			pnlFillGrid.setLayout(null);
			pnlAthletes.add(pnlFillGrid);
		}
		
	
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
