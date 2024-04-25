import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import java.awt.Insets;
import javax.swing.JDesktopPane;
import javax.swing.JEditorPane;

public class DebuggerMainMenu extends JFrame {

	private static String userName;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DebuggerMainMenu frame = new DebuggerMainMenu();
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
	public DebuggerMainMenu() {
		
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
		
		JTextArea textArea = new JTextArea("Team 23: \nBen Santhosh, Atmiya Manish Patel, Hoyeon Luke Jang, Minh Duc Pham, Tony Baocheng Li"
				+ "\n\nThis game was developed as part of CS2212 at Western University - Winter 2023-24 ");
		textArea.setMargin(new Insets(5, 5, 5, 5));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		textArea.setBounds(17, 533, 381, 103);
		panel.add(textArea);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(395, 0, 584, 652);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		

		
		JLabel mainMenuLabel = new JLabel("DEBUGGER MODE");
		mainMenuLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mainMenuLabel.setBounds(67, 57, 411, 33);
		panel_1.add(mainMenuLabel);
		mainMenuLabel.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		
		
		JButton loadGameButton = new JButton("Level Select");
		loadGameButton.setFont(new Font("PT Serif", Font.BOLD, 20));
		loadGameButton.setBounds(203, 220, 162, 54);
		panel_1.add(loadGameButton);
		loadGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LevelSelectPage levelSelectPage = new LevelSelectPage("Debugger");
				levelSelectPage.setVisible(true);
				dispose();
			}
		});
		
		JButton instructionsButton = new JButton("Instructions");
		instructionsButton.setFont(new Font("PT Serif", Font.BOLD, 20));
		instructionsButton.setBounds(203, 305, 162, 54);
		panel_1.add(instructionsButton);
		instructionsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InstructionPage instructionPage = new InstructionPage("Debugger");
				instructionPage.setVisible(true);
				dispose();;
				}
		});

		JButton highScoresButton = new JButton("High Scores");
		highScoresButton.setFont(new Font("PT Serif", Font.BOLD, 20));
		highScoresButton.setBounds(203, 390, 162, 54);
		panel_1.add(highScoresButton);
		highScoresButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LeaderBoardPage leaderBoardPage = new LeaderBoardPage("Debugger");
				leaderBoardPage.setVisible(true);
				dispose();
				}
		});
		
		JButton quitButton = new JButton("Quit");
		quitButton.setFont(new Font("PT Serif", Font.BOLD, 20));
		quitButton.setBounds(203, 475, 162, 54);
		panel_1.add(quitButton);
		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
		JLabel basketballBackground = new JLabel("");
		basketballBackground.setIcon(new ImageIcon(LogInPage.class.getResource("/images/output-onlinepngtools.png")));
		basketballBackground.setBounds(0, 0, 557, 652);
		panel_1.add(basketballBackground);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(395, 0, 1, 652);
		contentPane.add(separator);
	}
}
