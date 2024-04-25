import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;


/**
 * This class represents the save game frame
 * 
 * @version 1.0
 * @author Atmiya Patel
 */
public class SaveFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	/** variable for the lives*/
	private int lives;
	/** variable for the username/
	private String username;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaveFrame frame = new SaveFrame("", 0, 0);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the frame.
	 */
	public SaveFrame(String username, int lives, int fail) {
		
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950,680);  // dimensions chosen
		setResizable(false); 
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(170, 206, 250));
		panel.setBounds(-11, -34, 404, 686);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(LogInPage.class.getResource("/images/logo-transparent-png.png")));
		lblNewLabel_2.setBounds(64, 204, 280, 274);
		panel.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(395, 0, 584, 652);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton continueButton = new JButton("Continue");
		continueButton.setBounds(217, 516, 144, 42);
		panel_1.add(continueButton);
		
		JLabel instructionLabel = new JLabel("GAME RESULTS");
		instructionLabel.setBounds(169, 94, 243, 33);
		panel_1.add(instructionLabel);
		instructionLabel.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		
		JLabel lblNewLabel = new JLabel("", JLabel.CENTER);
		lblNewLabel.setForeground(new Color(0, 102, 204));
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 21));
		lblNewLabel.setBounds(39, 172, 497, 56);
		
		// find out if they failed or not
		if(fail == 0) {  // if false then display congrats
			lblNewLabel.setText("CONGRATS! You completed the level :)");
		}
		else {  // if true then display that they didn't complete level
			lblNewLabel.setText("Unfortunately you didn't complete the level :(");
		}
		
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Lives Remaining:");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(205, 260, 156, 42);
		panel_1.add(lblNewLabel_1);
		
		JLabel livesLabel = new JLabel(Integer.toString(lives), JLabel.CENTER);
		livesLabel.setForeground(Color.WHITE);
		livesLabel.setFont(new Font("Lucida Grande", Font.BOLD, 38));
		livesLabel.setBounds(239, 329, 71, 77);
		panel_1.add(livesLabel);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(SaveFrame.class.getResource("/images/big-heart.png")));
		lblNewLabel_3.setBounds(205, 303, 140, 140);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Your progress has been saved.");
		lblNewLabel_4.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(143, 444, 277, 33);
		panel_1.add(lblNewLabel_4);
		
		JLabel basketballBackground = new JLabel("");
		basketballBackground.setIcon(new ImageIcon(LogInPage.class.getResource("/images/output-onlinepngtools.png")));
		basketballBackground.setBounds(0, 0, 557, 652);
		panel_1.add(basketballBackground);
		
		// display the level select page when they click continue
		continueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	       		LevelSelectPage levelSelectPage = new LevelSelectPage(username);
	       		levelSelectPage.setVisible(true);
				dispose();
			}
		});
		
		JSeparator separator = new JSeparator();
		separator.setBounds(395, 0, 1, 652);
		contentPane.add(separator);
	}
}
