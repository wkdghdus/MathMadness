import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.UIManager;


/**
 * This class represents the sign up page frame for the user to make a new account
 * 
 * @version 1.0
 * @author Atmiya Patel
 */
public class SignUpPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField enteredUsername;
	private JPasswordField enteredPassword;
	private JPasswordField confirmedPassword;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpPage frame = new SignUpPage();
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
	public SignUpPage() {
		
		
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950,680);
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
		
		JLabel mathMadnessLogo = new JLabel("");
		mathMadnessLogo.setIcon(new ImageIcon(SignUpPage.class.getResource("/images/logo-transparent-png.png")));
		mathMadnessLogo.setBounds(64, 204, 280, 274);
		panel.add(mathMadnessLogo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(395, 0, 584, 652);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel enterUsername = new JLabel("Enter username: ");
		enterUsername.setBounds(66, 250, 143, 27);
		panel_1.add(enterUsername);
		enterUsername.setFont(new Font("Helvetica", Font.PLAIN, 18));
		
		enteredUsername = new JTextField();
		enteredUsername.setBounds(221, 247, 281, 33);
		panel_1.add(enteredUsername);
		enteredUsername.setColumns(10);
		
		JLabel enterPassword = new JLabel("Enter password: ");
		enterPassword.setBounds(74, 316, 135, 27);
		panel_1.add(enterPassword);
		enterPassword.setFont(new Font("Helvetica", Font.PLAIN, 18));
		
		enteredPassword = new JPasswordField();
		enteredPassword.setBounds(221, 313, 281, 33);
		panel_1.add(enteredPassword);
		
		JLabel lblNewLabel = new JLabel("Passwords must be 8 characters in length, and must match.");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblNewLabel.setBounds(57, 433, 445, 16);
		panel_1.add(lblNewLabel);
		
		JLabel statusLabel = new JLabel("", JLabel.CENTER);
		statusLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		statusLabel.setBounds(16, 472, 523, 27);
		panel_1.add(statusLabel);
		statusLabel.setVisible(false);
		
		JButton createAccountButton = new JButton("Create Account");
		createAccountButton.setBounds(197, 511, 163, 42);
		panel_1.add(createAccountButton);
		createAccountButton.setBackground(new Color(241, 57, 83));
		
		JLabel signUp = new JLabel("SIGN UP\n");
		signUp.setBounds(221, 146, 143, 33);
		panel_1.add(signUp);
		signUp.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		
		confirmedPassword = new JPasswordField();
		confirmedPassword.setBounds(221, 377, 281, 33);
		panel_1.add(confirmedPassword);
		
		JLabel confirmPassword = new JLabel("Confirm Password:");
		confirmPassword.setFont(new Font("Helvetica", Font.PLAIN, 18));
		confirmPassword.setBounds(57, 385, 152, 16);
		panel_1.add(confirmPassword);
		
		JButton backButton = new JButton("BACK");
		backButton.setBounds(445, 22, 94, 29);
		panel_1.add(backButton);
		backButton.setBackground(UIManager.getColor("Button.select"));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogInPage loginPage = new LogInPage();
				loginPage.setVisible(true);
				dispose();
				
			}
		});
		
		JLabel basketballBackground = new JLabel("");
		basketballBackground.setForeground(Color.BLACK);
		basketballBackground.setFont(new Font("Helvetica", Font.PLAIN, 18));
		basketballBackground.setIcon(new ImageIcon(SignUpPage.class.getResource("/images/output-onlinepngtools.png")));
		basketballBackground.setBounds(0, 0, 557, 652);
		panel_1.add(basketballBackground);

		createAccountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String username;
				String password;
				String confirmPassword;
				
				username = enteredUsername.getText();
				password = enteredPassword.getText();
				confirmPassword = confirmedPassword.getText();
				
				
				try {
					SignUp signUp = new SignUp(username, password, confirmPassword);
					statusLabel.setText(signUp.getConfirmationMessage());
					statusLabel.setVisible(true);
					

				}
				catch (Exception except){
					System.out.println("Error occured");
				}
				
			}
		});
		
		JSeparator separator = new JSeparator();
		separator.setBounds(395, 0, 1, 652);
		contentPane.add(separator);
	}
}


