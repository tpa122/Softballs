import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

public class RandomEventUI {

	private JFrame frame;
	private GameEnvironment environment;
	private ArrayList<Athlete> quitingAthletes;
	private ArrayList<Athlete> increasingAthletes;
	private Athlete newAthlete;



	/**
	 * Create the application.
	 */
	public RandomEventUI(GameEnvironment incomingEnvironment, ArrayList<Athlete> incomingQuiting, ArrayList<Athlete> incomingIncreasing, Athlete incomingAthlete) {
		environment = incomingEnvironment;
		quitingAthletes = incomingQuiting;
		increasingAthletes = incomingIncreasing;
		newAthlete = incomingAthlete;
		
		if (quitingAthletes.size() == 0 && increasingAthletes.size() == 0 && environment.getClub().getAthletes().contains(incomingAthlete) == false) {
			environment.launchMainMenu();
		}
		else {
			initialize();
			frame.setVisible(true);
		}
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
		
		if (environment.getClub().getAthletes().contains(newAthlete)) {
			JLabel lblNewPlayer = new JLabel("<html>A new Athlete has joined your team!</html>");
			lblNewPlayer.setBounds(334, 20, 340, 24);
			frame.getContentPane().add(lblNewPlayer);
			lblNewPlayer.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewPlayer.setFont(new Font("Tahoma", Font.PLAIN, 16));
			
			JPanel pnlAthleteCardPos = new JPanel();
			pnlAthleteCardPos.setBounds(444, 50, 120, 125);
			frame.getContentPane().add(pnlAthleteCardPos);
			pnlAthleteCardPos.setLayout(new GridLayout(0, 1, 0, 0));
			
			AthleteSmallUI athleteCard = new AthleteSmallUI(newAthlete);
			pnlAthleteCardPos.add(athleteCard);
		}
			
		
		if (increasingAthletes.size() > 0) {
			JPanel pnlIncreasing = new JPanel();
			pnlIncreasing.setBounds(429, 215, 150, 125);
			frame.getContentPane().add(pnlIncreasing);
			pnlIncreasing.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			
			JLabel lblIncreasing = new JLabel("These Athletes increased their Stats!");
			lblIncreasing.setBounds(376, 185, 255, 24);
			frame.getContentPane().add(lblIncreasing);
			lblIncreasing.setHorizontalAlignment(SwingConstants.CENTER);
			lblIncreasing.setFont(new Font("Tahoma", Font.PLAIN, 16));
			
			for (Athlete currentAthlete : increasingAthletes) {
				JLabel  lblIncreasingAthlete = new JLabel(currentAthlete.getName());
				lblIncreasingAthlete.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblIncreasingAthlete.setHorizontalAlignment(SwingConstants.CENTER);
				lblIncreasingAthlete.setBounds(0, 0, 150, 22);
				pnlIncreasing.add(lblIncreasingAthlete);
				
			}
		}

		
		
		if (quitingAthletes.size() > 0) {
			JLabel lblQuitting = new JLabel("Oh no! These Athletes left your club");
			lblQuitting.setHorizontalAlignment(SwingConstants.CENTER);
			lblQuitting.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblQuitting.setBounds(334, 350, 340, 24);
			frame.getContentPane().add(lblQuitting);
			
			JPanel pnlQuitting = new JPanel();
			pnlQuitting.setBounds(429, 380, 150, 125);
			frame.getContentPane().add(pnlQuitting);
			pnlQuitting.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
					
			for (Athlete currentAthlete : quitingAthletes) {
				JLabel  lblQuittingAthlete = new JLabel(currentAthlete.getName());
				lblQuittingAthlete.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblQuittingAthlete.setHorizontalAlignment(SwingConstants.CENTER);
				lblQuittingAthlete.setBounds(0, 0, 150, 22);
				pnlQuitting.add(lblQuittingAthlete);
				
			}
		}
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				environment.launchMainMenu();
			}
		});
		btnContinue.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnContinue.setBounds(822, 465, 120, 40);
		frame.getContentPane().add(btnContinue);
	}

}
