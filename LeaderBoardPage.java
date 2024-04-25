import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;

public class LeaderBoardPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel[] labels = new JLabel[11];
	String[][] metrics;
	String [][] additionScores;
	String [][] subtractionScores;
	String [][] multiplicationScores;
	String [][] divisionScores;

	private int CSVLength;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LeaderBoardPage frame = new LeaderBoardPage("");
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
	public LeaderBoardPage(String username) {
		
		try {
			
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("files/StudentInfo.csv");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String filePath = "files/StudentInfo.csv";
            Leaderboard leaderboard = new Leaderboard(filePath);

			additionScores = leaderboard.highScores(6);
			subtractionScores = leaderboard.highScores(7);
			multiplicationScores = leaderboard.highScores(8);
			divisionScores = leaderboard.highScores(9);
			CSVLength = leaderboard.getCSVLength();
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 680); // dimensions chosen
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
		panel_1.setBounds(395, 0, 5150, 652);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JButton backButton = new JButton("Back");
		backButton.setBounds(227, 573, 144, 42);
		panel_1.add(backButton);

		JLabel instructionLabel = new JLabel("LEADERBOARD");
		instructionLabel.setBounds(169, 94, 308, 33);
		panel_1.add(instructionLabel);
		instructionLabel.setFont(new Font("Lucida Grande", Font.BOLD, 30));

		JButton additionButton = new JButton("+");
		additionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				metrics = additionScores;

				for (JLabel label : labels) {
					if (label != null) {
						panel_1.remove(label);
					}
				}
				if (CSVLength > 0){
					labels[0] = new JLabel(metrics[0][0]);
					labels[0].setFont(new Font("Lucida Grande", Font.BOLD, 20));
					labels[0].setBounds(100, 248, 150, 33);
					panel_1.add(labels[0]);
					
					labels[6] = new JLabel(metrics[1][0]);
					labels[6].setFont(new Font("Lucida Grande", Font.BOLD, 20));
					labels[6].setBounds(305, 248, 150, 33);
					panel_1.add(labels[6]);
				}
				if (CSVLength > 1){
					labels[1] = new JLabel(metrics[0][1]);
					labels[1].setFont(new Font("Lucida Grande", Font.BOLD, 20));
					labels[1].setBounds(100, 293, 150, 33);
					panel_1.add(labels[1]);

					labels[7] = new JLabel(metrics[1][1]);
					labels[7].setFont(new Font("Lucida Grande", Font.BOLD, 20));
					labels[7].setBounds(305, 293, 150, 33);
					panel_1.add(labels[7]);
				}
				if (CSVLength > 2){
					labels[2] = new JLabel(metrics[0][2]);
					labels[2].setFont(new Font("Lucida Grande", Font.BOLD, 20));
					labels[2].setBounds(100, 338, 150, 33);
					panel_1.add(labels[2]);

					labels[8] = new JLabel(metrics[1][2]);
					labels[8].setFont(new Font("Lucida Grande", Font.BOLD, 20));
					labels[8].setBounds(305, 338, 150, 33);
					panel_1.add(labels[8]);
				}
				if (CSVLength > 3){
					labels[3] = new JLabel(metrics[0][3]);
					labels[3].setFont(new Font("Lucida Grande", Font.BOLD, 20));
					labels[3].setBounds(100, 383, 150, 33);
					panel_1.add(labels[3]);
					
					labels[9] = new JLabel(metrics[1][3]);
					labels[9].setFont(new Font("Lucida Grande", Font.BOLD, 20));
					labels[9].setBounds(305, 383, 150, 33);
					panel_1.add(labels[9]);
				}
				if (CSVLength > 4){	
					labels[4] = new JLabel(metrics[0][4]);
					labels[4].setFont(new Font("Lucida Grande", Font.BOLD, 20));
					labels[4].setBounds(100, 428, 150, 33);
					panel_1.add(labels[4]);

					labels[10] = new JLabel(metrics[1][4]);
					labels[10].setFont(new Font("Lucida Grande", Font.BOLD, 20));
					labels[10].setBounds(305, 428, 150, 33);
					panel_1.add(labels[10]);
				}
					panel_1.repaint();
					panel_1.revalidate();
				}
		});
		additionButton.setBounds(55, 516, 117, 29);
		panel_1.add(additionButton);

		JButton subtractionButton = new JButton("-");
		subtractionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				metrics = subtractionScores;

				for (JLabel label : labels) {
					if (label != null) {
						panel_1.remove(label);
					}
				}
				if (CSVLength > 0){
					labels[0] = new JLabel(metrics[0][0]);
					labels[0].setFont(new Font("Lucida Grande", Font.BOLD, 20));
					labels[0].setBounds(100, 248, 150, 33);
					panel_1.add(labels[0]);
					
					labels[6] = new JLabel(metrics[1][0]);
					labels[6].setFont(new Font("Lucida Grande", Font.BOLD, 20));
					labels[6].setBounds(305, 248, 150, 33);
					panel_1.add(labels[6]);
				}
				if (CSVLength > 1){
					labels[1] = new JLabel(metrics[0][1]);
					labels[1].setFont(new Font("Lucida Grande", Font.BOLD, 20));
					labels[1].setBounds(100, 293, 150, 33);
					panel_1.add(labels[1]);

					labels[7] = new JLabel(metrics[1][1]);
					labels[7].setFont(new Font("Lucida Grande", Font.BOLD, 20));
					labels[7].setBounds(305, 293, 150, 33);
					panel_1.add(labels[7]);
				}
				if (CSVLength > 2){
					labels[2] = new JLabel(metrics[0][2]);
					labels[2].setFont(new Font("Lucida Grande", Font.BOLD, 20));
					labels[2].setBounds(100, 338, 150, 33);
					panel_1.add(labels[2]);

					labels[8] = new JLabel(metrics[1][2]);
					labels[8].setFont(new Font("Lucida Grande", Font.BOLD, 20));
					labels[8].setBounds(305, 338, 150, 33);
					panel_1.add(labels[8]);
				}
				if (CSVLength > 3){
					labels[3] = new JLabel(metrics[0][3]);
					labels[3].setFont(new Font("Lucida Grande", Font.BOLD, 20));
					labels[3].setBounds(100, 383, 150, 33);
					panel_1.add(labels[3]);
					
					labels[9] = new JLabel(metrics[1][3]);
					labels[9].setFont(new Font("Lucida Grande", Font.BOLD, 20));
					labels[9].setBounds(305, 383, 150, 33);
					panel_1.add(labels[9]);
				}
				if (CSVLength > 4){	
					labels[4] = new JLabel(metrics[0][4]);
					labels[4].setFont(new Font("Lucida Grande", Font.BOLD, 20));
					labels[4].setBounds(100, 428, 150, 33);
					panel_1.add(labels[4]);

					labels[10] = new JLabel(metrics[1][4]);
					labels[10].setFont(new Font("Lucida Grande", Font.BOLD, 20));
					labels[10].setBounds(305, 428, 150, 33);
					panel_1.add(labels[10]);
				}
					panel_1.repaint();
					panel_1.revalidate();
				}
		});
		subtractionButton.setBounds(169, 516, 117, 29);
		panel_1.add(subtractionButton);

		JButton multiplicationButton = new JButton("x");
		multiplicationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				metrics = multiplicationScores;

				for (JLabel label : labels) {
					if (label != null) {
						panel_1.remove(label);
					}
				}
				if (CSVLength > 0){
					labels[0] = new JLabel(metrics[0][0]);
					labels[0].setFont(new Font("Lucida Grande", Font.BOLD, 20));
					labels[0].setBounds(100, 248, 150, 33);
					panel_1.add(labels[0]);
					
					labels[6] = new JLabel(metrics[1][0]);
					labels[6].setFont(new Font("Lucida Grande", Font.BOLD, 20));
					labels[6].setBounds(305, 248, 150, 33);
					panel_1.add(labels[6]);
				}
				if (CSVLength > 1){
					labels[1] = new JLabel(metrics[0][1]);
					labels[1].setFont(new Font("Lucida Grande", Font.BOLD, 20));
					labels[1].setBounds(100, 293, 150, 33);
					panel_1.add(labels[1]);

					labels[7] = new JLabel(metrics[1][1]);
					labels[7].setFont(new Font("Lucida Grande", Font.BOLD, 20));
					labels[7].setBounds(305, 293, 150, 33);
					panel_1.add(labels[7]);
				}
				if (CSVLength > 2){
					labels[2] = new JLabel(metrics[0][2]);
					labels[2].setFont(new Font("Lucida Grande", Font.BOLD, 20));
					labels[2].setBounds(100, 338, 150, 33);
					panel_1.add(labels[2]);

					labels[8] = new JLabel(metrics[1][2]);
					labels[8].setFont(new Font("Lucida Grande", Font.BOLD, 20));
					labels[8].setBounds(305, 338, 150, 33);
					panel_1.add(labels[8]);
				}
				if (CSVLength > 3){
					labels[3] = new JLabel(metrics[0][3]);
					labels[3].setFont(new Font("Lucida Grande", Font.BOLD, 20));
					labels[3].setBounds(100, 383, 150, 33);
					panel_1.add(labels[3]);
					
					labels[9] = new JLabel(metrics[1][3]);
					labels[9].setFont(new Font("Lucida Grande", Font.BOLD, 20));
					labels[9].setBounds(305, 383, 150, 33);
					panel_1.add(labels[9]);
				}
				if (CSVLength > 4){	
					labels[4] = new JLabel(metrics[0][4]);
					labels[4].setFont(new Font("Lucida Grande", Font.BOLD, 20));
					labels[4].setBounds(100, 428, 150, 33);
					panel_1.add(labels[4]);

					labels[10] = new JLabel(metrics[1][4]);
					labels[10].setFont(new Font("Lucida Grande", Font.BOLD, 20));
					labels[10].setBounds(305, 428, 150, 33);
					panel_1.add(labels[10]);
				}
					panel_1.repaint();
					panel_1.revalidate();
				}
		});
		multiplicationButton.setBounds(283, 516, 117, 29);
		panel_1.add(multiplicationButton);

		JButton divisionButton = new JButton("/");
		divisionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				metrics = divisionScores;

				for (JLabel label : labels) {
					if (label != null) {
						panel_1.remove(label);
					}
				}
				if (CSVLength > 0){
					labels[0] = new JLabel(metrics[0][0]);
					labels[0].setFont(new Font("Lucida Grande", Font.BOLD, 20));
					labels[0].setBounds(100, 248, 150, 33);
					panel_1.add(labels[0]);
					
					labels[6] = new JLabel(metrics[1][0]);
					labels[6].setFont(new Font("Lucida Grande", Font.BOLD, 20));
					labels[6].setBounds(305, 248, 150, 33);
					panel_1.add(labels[6]);
				}
				if (CSVLength > 1){
					labels[1] = new JLabel(metrics[0][1]);
					labels[1].setFont(new Font("Lucida Grande", Font.BOLD, 20));
					labels[1].setBounds(100, 293, 150, 33);
					panel_1.add(labels[1]);

					labels[7] = new JLabel(metrics[1][1]);
					labels[7].setFont(new Font("Lucida Grande", Font.BOLD, 20));
					labels[7].setBounds(305, 293, 150, 33);
					panel_1.add(labels[7]);
				}
				if (CSVLength > 2){
					labels[2] = new JLabel(metrics[0][2]);
					labels[2].setFont(new Font("Lucida Grande", Font.BOLD, 20));
					labels[2].setBounds(100, 338, 150, 33);
					panel_1.add(labels[2]);

					labels[8] = new JLabel(metrics[1][2]);
					labels[8].setFont(new Font("Lucida Grande", Font.BOLD, 20));
					labels[8].setBounds(305, 338, 150, 33);
					panel_1.add(labels[8]);
				}
				if (CSVLength > 3){
					labels[3] = new JLabel(metrics[0][3]);
					labels[3].setFont(new Font("Lucida Grande", Font.BOLD, 20));
					labels[3].setBounds(100, 383, 150, 33);
					panel_1.add(labels[3]);
					
					labels[9] = new JLabel(metrics[1][3]);
					labels[9].setFont(new Font("Lucida Grande", Font.BOLD, 20));
					labels[9].setBounds(305, 383, 150, 33);
					panel_1.add(labels[9]);
				}
				if (CSVLength > 4){	
					labels[4] = new JLabel(metrics[0][4]);
					labels[4].setFont(new Font("Lucida Grande", Font.BOLD, 20));
					labels[4].setBounds(100, 428, 150, 33);
					panel_1.add(labels[4]);

					labels[10] = new JLabel(metrics[1][4]);
					labels[10].setFont(new Font("Lucida Grande", Font.BOLD, 20));
					labels[10].setBounds(305, 428, 150, 33);
					panel_1.add(labels[10]);
				}
					panel_1.repaint();
					panel_1.revalidate();
				}
		});
		divisionButton.setBounds(394, 516, 117, 29);
		panel_1.add(divisionButton);

		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblName.setBounds(100, 171, 150, 33);
		panel_1.add(lblName);

		JLabel instructionLabel_1_1 = new JLabel("SCORE");
		instructionLabel_1_1.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		instructionLabel_1_1.setBounds(305, 171, 93, 33);
		panel_1.add(instructionLabel_1_1);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBackground(SystemColor.activeCaptionText);
		panel_2.setBounds(283, 171, 6, 349);
		panel_1.add(panel_2);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(6, 18, 0, 432);
		panel_2.add(separator_1);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_2_1.setBackground(SystemColor.activeCaptionText);
		panel_2_1.setBounds(83, 205, 413, 7);
		panel_1.add(panel_2_1);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(6, 18, 0, 432);
		panel_2_1.add(separator_1_1);
		
		JLabel lblNewLabel = new JLabel("Click on the different modes to see the highscores in each!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(83, 132, 428, 16);
		panel_1.add(lblNewLabel);
		
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