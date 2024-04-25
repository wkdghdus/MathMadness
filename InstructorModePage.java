import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JLayeredPane;

/**
 * This class represents the instructor mode page where the instructor can view the metrics of a student
 * <p>
 * The instructor can enter the student's username and view the metrics of the student
 * The metrics include the level and score of the student in each of the four operations
 * </p>
 * 
 * @version 1.0
 * @author Ben Santosh
 * @auther Hoyeon Luke Jang
 */
public class InstructorModePage extends JFrame {

    private static final long serialVersionUID = 1L;
    /** GUI (JSwings) variable for the contents in the instructor mode page*/
    private JPanel contentPane;
    /** GUI (JSwings) variable for the text field where the instructor can enter the student's username*/
    private JTextField enteredUsername;
    /** Array of metrics for the student*/
    private String[] metrics;
    /** Instructor object*/
    private Instructor instructor;
    /** GUI (JSwings) varaible for the labels for the metrics*/
    private JLabel[] labels = new JLabel[6];

    /**
     * Launch the class (instructor main page)
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InstructorModePage frame = new InstructorModePage();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * constructor for the instructor mode page
     * Create the frame and initialize the contents of the frame.
     */
    public InstructorModePage() {

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
        lblNewLabel_2.setIcon(new ImageIcon(InstructorModePage.class.getResource("/images/logo-transparent-png.png")));
        lblNewLabel_2.setBounds(64, 204, 280, 274);
        panel.add(lblNewLabel_2);

        JLayeredPane panel_1 = new JLayeredPane();
        panel_1.setBounds(395, 0, 584, 652);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JLabel enterUsername = new JLabel("Enter username:");
        enterUsername.setEnabled(true);
        enterUsername.setBounds(73, 250, 146, 27);
        panel_1.add(enterUsername);
        enterUsername.setFont(new Font("Helvetica", Font.PLAIN, 18));

        enteredUsername = new JTextField();
        enteredUsername.setBounds(221, 247, 281, 33);
        panel_1.add(enteredUsername);
        enteredUsername.setColumns(10);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LogInPage login = new LogInPage();
                login.setVisible(true);
                dispose();
            }
        });
        backButton.setBounds(325, 513, 163, 42);
        panel_1.add(backButton);
        backButton.setBackground(new Color(241, 57, 83));

        JLabel lblSearchForA = new JLabel("Search for a student by username to see metrics:");
        lblSearchForA.setFont(new Font("Helvetica", Font.PLAIN, 18));
        lblSearchForA.setBounds(93, 205, 410, 27);
        panel_1.add(lblSearchForA);

        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    instructor = new Instructor("IAmAnInstructor");
                    metrics = instructor.getStudentMetrics(enteredUsername.getText());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                // Remove dynamically added labels
                for (JLabel label : labels) {
                    if (label != null) {
                        panel_1.remove(label);
                    }
                }

                if (metrics != null) {
                	
                    int yPos = 300; // Starting y position for labels

                    // Add new dynamically added labels for metrics
                    labels[0] = new JLabel("<html><b><u><i>Displaying metrics for:</b> </u></i>" + metrics[0]);
                    labels[0].setFont(new Font("Helvetica", Font.PLAIN, 18));
                    labels[0].setBounds(73, yPos, 500, 27);
                    panel_1.add(labels[0]);

                 // Add other dynamically added labels for other metrics
                    labels[1] = new JLabel("<html><b>Addition:</b> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Level: " + metrics[2] + " - Score: " + metrics[6]);
                    labels[1].setFont(new Font("Helvetica", Font.PLAIN, 18));
                    labels[1].setBounds(73, yPos + 40, 500, 27);
                    panel_1.add(labels[1]);

                    labels[2] = new JLabel("<html><b>Subtraction:</b> &nbsp;&nbsp;&nbsp;&nbsp; Level: " + metrics[3] + " - Score: " + metrics[7]);
                    labels[2].setFont(new Font("Helvetica", Font.PLAIN, 18));
                    labels[2].setBounds(73, yPos + 80, 500, 27);
                    panel_1.add(labels[2]);

                    labels[3] = new JLabel("<html><b>Multiplication:</b> &nbsp; Level: " + metrics[4] + " - Score: " + metrics[8]);
                    labels[3].setFont(new Font("Helvetica", Font.PLAIN, 18));
                    labels[3].setBounds(73, yPos + 120, 500, 27);
                    panel_1.add(labels[3]);

                    labels[4] = new JLabel("<html><b>Division:</b> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Level: " + metrics[5] + " - Score: " + metrics[9]);
                    labels[4].setFont(new Font("Helvetica", Font.PLAIN, 18));
                    labels[4].setBounds(73, yPos + 160, 500, 27);
                    panel_1.add(labels[4]);


                    panel_1.repaint();
                    panel_1.revalidate();
                } else {
                    labels[5] = new JLabel("User not found");

                    labels[5].setFont(new Font("Helvetica", Font.PLAIN, 18));
                    labels[5].setBounds(221, 494, 281, 27);
                    panel_1.add(labels[5]);
                    panel_1.repaint();
                    panel_1.revalidate();
                }
            }
        });
        searchButton.setBackground(new Color(241, 57, 83));
        searchButton.setBounds(161, 513, 163, 42);
        panel_1.add(searchButton);

        JLabel modeLabel = new JLabel("INSTRUCTOR MODE");
        modeLabel.setBounds(138, 160, 313, 33);
        panel_1.add(modeLabel);
        modeLabel.setFont(new Font("Lucida Grande", Font.BOLD, 30));

        JLabel basketballBackground = new JLabel("");
        basketballBackground.setIcon(new ImageIcon(InstructorModePage.class.getResource("/images/output-onlinepngtools.png")));
        basketballBackground.setBounds(0, 0, 557, 652);
        panel_1.add(basketballBackground);

        JSeparator separator = new JSeparator();
        separator.setBounds(395, 0, 1, 652);
        contentPane.add(separator);
    }
}

