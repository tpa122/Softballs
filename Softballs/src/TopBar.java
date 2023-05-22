import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TopBar extends JPanel {
	
	private GameEnvironment environment;

	/**
	 * Create the panel.
	 */
	public TopBar(GameEnvironment incomingEnvironment) {
		environment = incomingEnvironment;
		
		initialize();
	}

	private void initialize() {
		
		setBounds(0, 0, 1008, 28);
		setLayout(null);
	
	JLabel lblWeek = new JLabel("Week: " + environment.getCurrentWeek());
	lblWeek.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblWeek.setBounds(23, 4, 100, 20);
	add(lblWeek);
	
	JLabel lblPoints = new JLabel("Points: " + environment.getPoints());
	lblPoints.setHorizontalAlignment(SwingConstants.CENTER);
	lblPoints.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblPoints.setBounds(439, 4, 130, 20);
	add(lblPoints);
	
	JLabel lblMoney = new JLabel("Money: " + environment.getMoney());
	lblMoney.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblMoney.setBounds(885, 4, 123, 20);
	add(lblMoney);
}
}
