import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;


/**
 * This class represents the Instructor LogIn Page
 * 
 * @version 1.0
 * @author Atmiya Patel
 */
public class InstructorLogIn extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	/** GUI (JSwings) variable for the instructor password field **/
	private JPasswordField instructorPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InstructorLogIn frame = new InstructorLogIn();
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
	public InstructorLogIn() {
		
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
		
		
		JLabel enterPassword = new JLabel("Instructor Mode Password:");
		enterPassword.setBounds(18, 288, 224, 27);
		panel_1.add(enterPassword);
		enterPassword.setFont(new Font("Helvetica", Font.PLAIN, 18));
		

		
		JLabel loginLabel = new JLabel("INSTRUCTOR MODE");
		loginLabel.setBounds(135, 146, 334, 33);
		panel_1.add(loginLabel);
		loginLabel.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		
		JLabel statusLabel = new JLabel("", JLabel.CENTER);
		statusLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		statusLabel.setBounds(74, 354, 406, 27);
		panel_1.add(statusLabel);
		statusLabel.setVisible(false);
		
		JButton loginButton = new JButton("Login");
		loginButton.setBounds(199, 393, 163, 42);
		panel_1.add(loginButton);
		loginButton.setBackground(new Color(241, 57, 83));
		
		instructorPassword = new JPasswordField();
		instructorPassword.setBounds(254, 281, 259, 33);
		panel_1.add(instructorPassword);
		
		JButton backButton = new JButton("BACK");
		backButton.setBounds(445, 22, 94, 29);
		panel_1.add(backButton);
		backButton.setBackground(UIManager.getColor("Button.select"));
		backButton.addActionListener(new ActionListener() {
			
			// When user clicks on the back button display the login page
			public void actionPerformed(ActionEvent e) {
				LogInPage loginPage = new LogInPage();
				loginPage.setVisible(true);
				dispose();
				
			}
		});
		
		JLabel basketballBackground = new JLabel("");
		basketballBackground.setIcon(new ImageIcon(LogInPage.class.getResource("/images/output-onlinepngtools.png")));
		basketballBackground.setBounds(0, 0, 557, 652);
		panel_1.add(basketballBackground);
		
		// When user clicks on the login button
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password;
				password = instructorPassword.getText();  // retrieves password from the Password Field
				
				try {
					Instructor account = new Instructor(password);  // create an object of Instructor and pass in the password as a parameter
					statusLabel.setText(account.getConfirmationMessage());
					statusLabel.setVisible(true);
					if(account.getSuccessfulLogin()) {  // if they successfully log in then display the instructor mode page and dispose 
						InstructorModePage instructor = new InstructorModePage();
						instructor.setVisible(true);
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
