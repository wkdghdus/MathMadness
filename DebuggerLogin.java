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
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

/**
 * This class represents the debugger login page where the debugger can login to the debugger mode
 * 
 * @version 1.0
 * @author Ben Santosh
 * @auther Hoyeon Luke Jang
 */
public class DebuggerLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	/** GUI (JSwings) variable for the contents in the debugger login page*/
	private JPanel contentPane;
	/** GUI (JSwings) variable for the password field where the debugger can enter the password*/
	private JPasswordField debuggerPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DebuggerLogin frame = new DebuggerLogin();
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
	public DebuggerLogin() {
		
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
		
		
		JLabel enterPassword = new JLabel("Debugger Mode Password:");
		enterPassword.setBounds(18, 288, 224, 27);
		panel_1.add(enterPassword);
		enterPassword.setFont(new Font("Helvetica", Font.PLAIN, 18));
		

		
		JLabel loginLabel = new JLabel("DEBUGGER MODE");
		loginLabel.setBounds(151, 146, 278, 33);
		panel_1.add(loginLabel);
		loginLabel.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		
		JLabel statusLabel = new JLabel("Incorrect password. Try again.", JLabel.CENTER);
		statusLabel.setForeground(Color.RED);
		statusLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		statusLabel.setBounds(70, 361, 406, 27);
		panel_1.add(statusLabel);
		statusLabel.setVisible(false);
		
		JButton loginButton = new JButton("Login");
		loginButton.setBounds(199, 393, 163, 42);
		panel_1.add(loginButton);
		loginButton.setBackground(new Color(241, 57, 83));
		
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
		
		debuggerPassword = new JPasswordField();
		debuggerPassword.setBounds(254, 281, 259, 33);
		panel_1.add(debuggerPassword);
		
		JLabel basketballBackground = new JLabel("");
		basketballBackground.setIcon(new ImageIcon(LogInPage.class.getResource("/images/output-onlinepngtools.png")));
		basketballBackground.setBounds(0, 0, 557, 652);
		panel_1.add(basketballBackground);
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password;
				password = debuggerPassword.getText();
				if (password.equals("IAmADebugger")) {
					DebuggerMainMenu debug = new DebuggerMainMenu();
					debug.setVisible(true);
					dispose();
				}
				else {

					statusLabel.setVisible(true);
					
				}
				
			}
		});
		
		JSeparator separator = new JSeparator();
		separator.setBounds(395, 0, 1, 652);
		contentPane.add(separator);
	}
}
