import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class SetupUI {

	private JFrame frmSetup;
	private JTextField textFieldTeamName;
	private Setup setupManager;
	private int Difficulty = 0;
	private GameEnvironment environment;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SetupUI window = new SetupUI(this);
//					window.frmSetup.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public SetupUI(Setup incomingSetup) {
		setupManager = incomingSetup;
		environment = setupManager.environment;
		initialize();
		frmSetup.setVisible(true);
	}

	public void closeWindow()	{
		frmSetup.dispose();
	}
	public void launchTeamSelect()	{
		environment.launchTeamSelect(this, setupManager);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSetup = new JFrame();
		frmSetup.setTitle("Set Up Team");
		frmSetup.setBounds(100, 100, 1280, 720);
		frmSetup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSetup.getContentPane().setLayout(null);
		
		JLabel lblSoftballsTitle = new JLabel("");
		lblSoftballsTitle.setBounds(0, 0, 1264, 185);
		lblSoftballsTitle.setIcon(new ImageIcon(SetupUI.class.getResource("/img/Softballs_logo.png")));
		lblSoftballsTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoftballsTitle.setFont(new Font("Tahoma", Font.PLAIN, 47));
		frmSetup.getContentPane().add(lblSoftballsTitle);
		
		JLabel lblTeamName = new JLabel("Enter Team Name:");
		lblTeamName.setBounds(10, 281, 1264, 21);
		frmSetup.getContentPane().add(lblTeamName);
		lblTeamName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTeamName.setHorizontalAlignment(SwingConstants.CENTER);
		
		textFieldTeamName = new JTextField();
		textFieldTeamName.setToolTipText("3 to 15 letters");
		textFieldTeamName.setBounds(502, 313, 275, 20);
		frmSetup.getContentPane().add(textFieldTeamName);
		textFieldTeamName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Season Length:");
		lblNewLabel_2.setBounds(544, 387, 182, 26);
		frmSetup.getContentPane().add(lblNewLabel_2);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblNewLabel_3 = new JLabel("Difficulty:");
		lblNewLabel_3.setBounds(593, 461, 85, 21);
		frmSetup.getContentPane().add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JButton btnNormalDifficulty = new JButton("Normal");
		btnNormalDifficulty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Difficulty = 0;
			}
		});
		btnNormalDifficulty.setBounds(544, 506, 89, 23);
		frmSetup.getContentPane().add(btnNormalDifficulty);
		btnNormalDifficulty.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JButton btnHardDifficulty = new JButton("Hard");
		btnHardDifficulty.setBounds(649, 506, 89, 23);
		frmSetup.getContentPane().add(btnHardDifficulty);
		btnHardDifficulty.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblWeek = new JLabel("Weeks");
		lblWeek.setBounds(768, 424, 75, 26);
		frmSetup.getContentPane().add(lblWeek);
		lblWeek.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblWeekCount = new JLabel("10");
		lblWeekCount.setBounds(731, 424, 45, 26);
		frmSetup.getContentPane().add(lblWeekCount);
		lblWeekCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeekCount.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JSlider sliderWeek = new JSlider();
		sliderWeek.setMinimum(5);
		sliderWeek.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				lblWeekCount.setText(String.valueOf(sliderWeek.getValue()));
			}
		});
		sliderWeek.setValue(10);
		sliderWeek.setMaximum(15);
		sliderWeek.setBounds(538, 424, 200, 26);
		frmSetup.getContentPane().add(sliderWeek);
		
		JButton btnNewButton = new JButton("Next");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((textFieldTeamName.getText()).length() >= 3 & (textFieldTeamName.getText()).length() <=15)	{
					setupManager.setClubName(textFieldTeamName.getText());
					setupManager.chooseWeek(sliderWeek.getValue());
					setupManager.chooseDifficulty(String.valueOf(Difficulty));
					launchTeamSelect();
				}	else	{
					System.out.println("Must be between 3 and 15 characters");
					
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(593, 607, 89, 23);
		frmSetup.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Team name must be between 3 and 15 characters");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(512, 335, 246, 20);
		frmSetup.getContentPane().add(lblNewLabel);
		
		btnHardDifficulty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Difficulty = 1;
			}
		});
	}
}
