import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class OpponentUI extends JPanel {
	
	private GameEnvironment environment;
	private String name;

	/**
	 * Create the panel.
	 */
	public OpponentUI(GameEnvironment incomingEnvironment, Club incomingClub) {
		environment = incomingEnvironment;
		name = incomingClub.getName();

		initialize();

	}
	
	public void initialize() {
		setBounds(100, 100, 230, 280);
		
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(null);
		
		JLabel lblOpponentName = new JLabel(name);
		lblOpponentName.setHorizontalAlignment(SwingConstants.CENTER);
		lblOpponentName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblOpponentName.setBounds(10, 24, 210, 60);
		add(lblOpponentName);
		
		JLabel lblMoney = new JLabel("Money");
		lblMoney.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMoney.setBounds(20, 157, 80, 20);
		add(lblMoney);
		
		JLabel lblPoints = new JLabel("Points");
		lblPoints.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPoints.setBounds(20, 209, 80, 20);
		add(lblPoints);
		
		if (environment.getDifficulty() == 0) {
			JLabel lblMoneyNum = new JLabel("120");
			lblMoneyNum.setHorizontalAlignment(SwingConstants.RIGHT);
			lblMoneyNum.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblMoneyNum.setBounds(130, 157, 80, 20);
			add(lblMoneyNum);
			
			JLabel lblPointsNum = new JLabel("1000");
			lblPointsNum.setHorizontalAlignment(SwingConstants.RIGHT);
			lblPointsNum.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblPointsNum.setBounds(130, 209, 80, 20);
			add(lblPointsNum);
		}
		else {
			JLabel lblMoneyNum = new JLabel("1500");
			lblMoneyNum.setHorizontalAlignment(SwingConstants.RIGHT);
			lblMoneyNum.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblMoneyNum.setBounds(130, 157, 80, 20);
			add(lblMoneyNum);
		}
			
		
	}

}
