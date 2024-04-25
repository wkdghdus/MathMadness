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


/**
 * This class represents the login page frame
 * 
 * @version 1.0
 * @author Atmiya Patel
 */
public class LogInPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	/** GUI (JSwings) variable for the contents in the text field for username*/
	private JTextField enteredUsername;
	/** GUI (JSwings) variable for the contents in the password field*/
	private JPasswordField enteredPassword;
	String userName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInPage frame = new LogInPage();
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
	public LogInPage() {
		
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
		
		JLabel loginLabel = new JLabel("LOGIN");
		loginLabel.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		loginLabel.setBounds(624, 146, 109, 33);
		contentPane.add(loginLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(395, 0, 584, 652);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel enterUsername = new JLabel("Enter your username: ");
		enterUsername.setBounds(21, 250, 198, 27);
		panel_1.add(enterUsername);
		enterUsername.setFont(new Font("Helvetica", Font.PLAIN, 18));
		
		enteredUsername = new JTextField();
		enteredUsername.setBounds(221, 247, 281, 33);
		panel_1.add(enteredUsername);
		enteredUsername.setColumns(10);
		
		JLabel enterPassword = new JLabel("Enter your password: ");
		enterPassword.setBounds(21, 316, 198, 27);
		panel_1.add(enterPassword);
		enterPassword.setFont(new Font("Helvetica", Font.PLAIN, 18));
		
		enteredPassword = new JPasswordField();
		enteredPassword.setBounds(221, 313, 281, 33);
		panel_1.add(enteredPassword);
		
		JLabel statusLabel = new JLabel("", JLabel.CENTER);
		statusLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		statusLabel.setBounds(74, 354, 406, 27);
		panel_1.add(statusLabel);
		statusLabel.setVisible(false);
		
		JButton loginButton = new JButton("Login");
		loginButton.setBounds(199, 393, 163, 42);
		panel_1.add(loginButton);
		
		JButton createAccountButton = new JButton("Create a new account");
		createAccountButton.setBounds(176, 448, 216, 27);
		panel_1.add(createAccountButton);
		
		// When clicked on create account button, launch the sign up page
		createAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SignUpPage signUpPage = new SignUpPage();
                signUpPage.setVisible(true);
                dispose();
            }
        });
		
		JButton debuggerButton = new JButton("Debugger Mode");
		debuggerButton.setBounds(375, 563, 144, 42);
		panel_1.add(debuggerButton);
		
		JButton instructorButton = new JButton("Instructor Mode");
		instructorButton.setBounds(375, 509, 144, 42);
		panel_1.add(instructorButton);
		
		JLabel basketballBackground = new JLabel("");
		basketballBackground.setIcon(new ImageIcon(LogInPage.class.getResource("/images/output-onlinepngtools.png")));
		basketballBackground.setBounds(0, 0, 557, 652);
		panel_1.add(basketballBackground);
		// When clicked on the instructor button, launch the instructor login page
		instructorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InstructorLogIn instructorLogin = new InstructorLogIn();
				instructorLogin.setVisible(true);
				dispose();
			}
		});
		// When clicked on the debugger button, launch the debugger page
		debuggerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DebuggerLogin debuggerLogin = new DebuggerLogin();
				debuggerLogin.setVisible(true);
				dispose();
			}
		});
		// When user clicks the login button
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username;
				String password;
				username = enteredUsername.getText(); // get the username in the text field
				password = enteredPassword.getText(); // get the password in the password field
				
				try {
					Account account = new Account(username, password);  // pass in the values to the Account object
					statusLabel.setText(account.getConfirmationMessage());  // print the confirmation message if the password/username is incorrect
					statusLabel.setVisible(true);
					if(account.getSuccessfulLogin()) {  // if the user successfully logs in then display the main menu
						userName = username;
						MainMenu mainMenu = new MainMenu(userName);
						mainMenu.setVisible(true);
						dispose();
					}
					
				}
				catch (Exception exception){
					System.out.println("Error logging in");
				}
				
			}
		});
		
		JSeparator separator = new JSeparator();
		separator.setBounds(395, 0, 1, 652);
		contentPane.add(separator);
	}
}
