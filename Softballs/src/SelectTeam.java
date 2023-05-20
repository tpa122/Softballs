import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;

public class SelectTeam {

	private JFrame frame;
	private Setup setupManager;
	private ArrayList<Athlete> athletes = new ArrayList<Athlete>();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SelectTeam window = new SelectTeam();
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
	public SelectTeam(Setup setupGame) {
		setupManager = setupGame;
		initialize();
		frame.setVisible(true);
	}
	
	public void addToTeam(Athlete athleteToAdd)	{
		athletes.add(athleteToAdd);
	}
	public ArrayList<Athlete> getSetupTeam()	{
		return athletes;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		for(int i=1; i<=15; i++) {
			AthleteUI athlete = new AthleteUI();
			frame.getContentPane().add(athlete);
		}
		JLabel lblNewLabel = new JLabel("");
		frame.getContentPane().add(lblNewLabel);
		JLabel lblNewLabel_1 = new JLabel("");
		frame.getContentPane().add(lblNewLabel_1);
		//	Next button	
		JButton btnNewButton = new JButton("Next");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("");
		frame.getContentPane().add(lblNewLabel_2);
		JLabel lblNewLabel_3 = new JLabel("");
		frame.getContentPane().add(lblNewLabel_3);
		
		frame.getContentPane().setLayout(new GridLayout(0, 5, 0, 0));
		
	}
}
