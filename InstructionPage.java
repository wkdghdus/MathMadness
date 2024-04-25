import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import java.awt.Insets;
/**
 * This class represents the instruction tab where the user can view the instructions of the game
 * 
 * @version 1.0
 * @author Ben Santosh
 * @auther Hoyeon Luke Jang
 */
public class InstructionPage extends JFrame {

	private static final long serialVersionUID = 1L;
	/** GUI (JSwings) variable for the contents in the instruction page*/
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InstructionPage frame = new InstructionPage("");
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
	public InstructionPage(String username) {
		
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
		
		JButton backButton = new JButton("Back");
		backButton.setBounds(217, 516, 144, 42);
		panel_1.add(backButton);
		
		JLabel instructionLabel = new JLabel("INSTRUCTIONS");
		instructionLabel.setBounds(169, 94, 231, 33);
		panel_1.add(instructionLabel);
		instructionLabel.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		
		JTextArea textArea = new JTextArea("Welcome to Math Madness! Your objective is to score as many points as possible by shooting the basketball into the correct net. "
				+ "Each level has a math problem, and you must solve the problem correctly to score points. There are three nets you can shoot the basketball into, however, "
				+ "only one of those nets has the correct answer shown above it. Solve the problem correctly or you will lose a life! If you lose all 3 of your lives, you will lose the level. "
				+ "Each level has 5 questions, of which you must get atleast 3 correct to pass. Passing a level unlocks the next level which will be harder than the previous one! "
				+ "Every level you complete will give you 100 points. There are 4 different modes you can play: Addition, Subtraction, Multiplication, and Division. Good luck! \n\n"
				+ "Controls:"
				+ "\n"
				+ "\n"
				+ "- Use the arrow keys to move the basketball's shot left and right.\n\n"
				+ "- Press the spacebar to shoot the basketball.\n");
		textArea.setMargin(new Insets(10, 10, 10, 10));
		textArea.setWrapStyleWord(true);
		textArea.setBounds(74, 157, 423, 347);
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		panel_1.add(textArea);
		
		JLabel basketballBackground = new JLabel("");
		basketballBackground.setIcon(new ImageIcon(LogInPage.class.getResource("/images/output-onlinepngtools.png")));
		basketballBackground.setBounds(0, 0, 557, 652);
		panel_1.add(basketballBackground);
		
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (username.equals("Debugger")) {
					DebuggerMainMenu debug = new DebuggerMainMenu();
					debug.setVisible(true);
					dispose();
				}
				else {
				MainMenu mainMenu = new MainMenu(username);
				mainMenu.setVisible(true);
				dispose();
				}
			}
		});
		
		JSeparator separator = new JSeparator();
		separator.setBounds(395, 0, 1, 652);
		contentPane.add(separator);
	}
}
