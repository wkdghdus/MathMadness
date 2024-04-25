import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;


/**
 * This class represents the confirmation page of when the user wants to start a new game
 * 
 * @version 1.0
 * @author Ben Santhosh
 */
public class NewGameConfirmationPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public NewGameConfirmationPage(String user) {
		
		
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950,680);
		setResizable(false); 
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel NewGameConfirmation = new JPanel();
		NewGameConfirmation.setBackground(new Color(170, 206, 250));
		NewGameConfirmation.setBounds(548, 136, 267, 401);
		NewGameConfirmation.setLayout(null);
		contentPane.add(NewGameConfirmation);
		NewGameConfirmation.setVisible(true);
		
		JTextArea txtConfirmation = new JTextArea();
		txtConfirmation.setLineWrap(true);
		txtConfirmation.setWrapStyleWord(true);
		txtConfirmation.setOpaque(false);
		txtConfirmation.setMargin(new Insets(10, 10, 10, 10));
		txtConfirmation.setBounds(27, 24, 234, 186);
		txtConfirmation.setEditable(false);
		txtConfirmation.setText("Are you sure you want to start a new game? \n\nStarting a new game will delete any saved progress. \n\nClick \"Continue\" to proceed or \"Back\" to return to the main menu.\n");
		NewGameConfirmation.add(txtConfirmation);
		
		
		JButton btnNewButton = new JButton("Continue");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			        try{
			    		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("files/StudentInfo.csv");
			            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			            String line = reader.readLine();
			            String[] studentInfo = line.split(",");
			            String newFile = "";

			            //find the user in the studentInfo.csv, update the information, and write to a new file
			            while(!studentInfo[0].equals(user)){
			                newFile += line + "\n";
			                line = reader.readLine();
			                studentInfo = line.split(",");
			            }
			            System.out.println(Arrays.toString(studentInfo));
			            newFile += studentInfo[0] + "," + studentInfo[1] + ",1,1,1,1,0,0,0,0\n";

			            while((line = reader.readLine()) != null){
			                newFile += line + "\n";
			            }

			            reader.close();

			            //write to file
			            try{
			                FileWriter writer = new FileWriter("files/StudentInfo.csv");
			                writer.write(newFile);
			                writer.close();
			            }
			            catch (Exception ex){
			                ex.printStackTrace();
			            }

			        }
			        catch (Exception ex){

			            ex.printStackTrace();

			        }

			    
				LevelSelectPage levelSelectPage = new LevelSelectPage(user);
				levelSelectPage = new LevelSelectPage(user);

				levelSelectPage.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(71, 240, 117, 29);
		NewGameConfirmation.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu mainMenu = new MainMenu(user);
				mainMenu.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(71, 307, 117, 29);
		NewGameConfirmation.add(btnBack);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(170, 206, 250));
		panel.setBounds(-11, -34, 404, 686);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel mathMadnessLogo = new JLabel("");
		mathMadnessLogo.setIcon(new ImageIcon(NewGameConfirmationPage.class.getResource("/images/logo-transparent-png.png")));
		mathMadnessLogo.setBounds(64, 204, 280, 274);
		panel.add(mathMadnessLogo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(395, 0, 584, 652);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel basketballBackground = new JLabel("");
		basketballBackground.setForeground(Color.BLACK);
		basketballBackground.setFont(new Font("Helvetica", Font.PLAIN, 18));
		basketballBackground.setIcon(new ImageIcon(NewGameConfirmationPage.class.getResource("/images/output-onlinepngtools.png")));
		basketballBackground.setBounds(0, 0, 557, 652);
		panel_1.add(basketballBackground);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(395, 0, 1, 652);
		contentPane.add(separator);
	}
}
