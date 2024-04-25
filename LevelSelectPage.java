import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.JLayeredPane;
import javax.swing.border.TitledBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;

/**
 * This class represents the frame where the user gets to select the level.
 * 
 * @version 1.0
 * @author Ben Santhosh
 * @auther Atmiya Patel
 */
public class LevelSelectPage extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private String[] metrics;
    private Instructor instructor;
    private int gameMode;
    private int level;
    private String username;
    int addLevel;
    int subLevel;
    int mulLevel;
    int divLevel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LevelSelectPage frame = new LevelSelectPage("ben");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    /**
     * This method creates the level and displays the game.
     * 
     * @param gameMode The mode chosen by the user (+, -, *, /).
     * @param level The level chosen by the user.
     * @return True if it created the level.
     */
    public boolean createLevel(int gameMode, int level) {
        Game game = new Game(level, gameMode);
        Question[] questionBank = game.getQuestionBank();  
        int questionIndex = 0;  
        int lives = 3;  
        GameMain frame = new GameMain(questionBank, questionIndex, lives, gameMode, username, level);  
        frame.setVisible(true);
        dispose();

        return true;
    }
    
    /**
     * This method retrieves the user's levels and stores them into the variables.
     */
    public void setLevels() {
        String line;

        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("files/StudentInfo.csv");
            BufferedReader bf = new BufferedReader(new InputStreamReader(inputStream));
            
            while ((line = bf.readLine()) != null) {
                String[] userName = line.split(",");
        
                if((userName[0]).equals(username)) {
                    String additionLevel = userName[2];
                    String subtractionLevel = userName[3];
                    String multiplicationLevel = userName[4];
                    String divisionLevel = userName[5];
                    
                    addLevel = Integer.parseInt(additionLevel);
                    subLevel = Integer.parseInt(subtractionLevel);
                    mulLevel = Integer.parseInt(multiplicationLevel);
                    divLevel = Integer.parseInt(divisionLevel);
                }
            }
            bf.close();
        }
        catch (IOException e){ 
             System.out.println("Error reading file");
        }
    }

    /**
     * Create the frame.
     */
    public LevelSelectPage(String username) {
        
        this.username = username;

        setLevels();
        
        setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 950, 680);  
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
        lblNewLabel_2.setIcon(new ImageIcon(LevelSelectPage.class.getResource("/images/logo-transparent-png.png")));
        lblNewLabel_2.setBounds(64, 204, 280, 274);
        panel.add(lblNewLabel_2);

        
        JSeparator separator = new JSeparator();
        separator.setBounds(395, 0, 1, 652);
        contentPane.add(separator);
        
        JLayeredPane panel_1 = new JLayeredPane();
        panel_1.setBounds(395, 0, 584, 652);
        contentPane.add(panel_1);
        panel_1.setLayout(null);
        
        JButton backButton = new JButton("Back");
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
        
        JPanel panel_2_1 = new JPanel();
        panel_2_1.setLayout(null);
        panel_2_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        panel_2_1.setBackground(SystemColor.activeCaptionText);
        panel_2_1.setBounds(32, 195, 413, 7);
        panel_1.add(panel_2_1);
        
        JSeparator separator_1_1 = new JSeparator();
        separator_1_1.setBounds(6, 18, 0, 432);
        panel_2_1.add(separator_1_1);
        backButton.setBounds(226, 536, 163, 42);
        panel_1.add(backButton);
        
        JLabel modeLabel = new JLabel("LEVEL SELECT");
        modeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        modeLabel.setBounds(120, 67, 313, 33);
        panel_1.add(modeLabel);
        modeLabel.setFont(new Font("Lucida Grande", Font.BOLD, 30));
        
        JLabel addMode = new JLabel("+");
        addMode.setFont(new Font("Lucida Grande", Font.BOLD, 30));
        addMode.setBounds(69, 230, 41, 26);
        panel_1.add(addMode);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(SystemColor.activeCaptionText);
        panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panel_2.setBounds(141, 149, 7, 456);
        panel_1.add(panel_2);
        panel_2.setLayout(null);
        
        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(6, 18, 0, 432);
        panel_2.add(separator_1);
        
        JLabel subMode = new JLabel("-");
        subMode.setFont(new Font("Lucida Grande", Font.BOLD, 30));
        subMode.setBounds(69, 305, 41, 16);
        panel_1.add(subMode);
        
        JLabel multMode = new JLabel("x");
        multMode.setFont(new Font("Lucida Grande", Font.BOLD, 30));
        multMode.setBounds(69, 380, 41, 27);
        panel_1.add(multMode);
        
        JLabel divMode = new JLabel("/");
        divMode.setFont(new Font("Lucida Grande", Font.BOLD, 30));
        divMode.setBounds(69, 459, 41, 33);
        panel_1.add(divMode);
        
        JLabel modelbl = new JLabel("MODE");
        modelbl.setFont(new Font("Lucida Grande", Font.BOLD, 20));
        modelbl.setBounds(67, 164, 81, 16);
        panel_1.add(modelbl);
        
        JLabel lblLevel = new JLabel("LEVELS");
        lblLevel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
        lblLevel.setBounds(205, 164, 81, 16);
        panel_1.add(lblLevel);
        
        JButton add1 = new JButton("1");
        add1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gameMode = 0;
                level = 0;
                createLevel(gameMode, level);
            }
        });
        add1.setFont(new Font("Lucida Grande", Font.BOLD, 30));
        add1.setBounds(175, 219, 63, 50);
        panel_1.add(add1);
        
        JButton add2 = new JButton("");
        
        if (addLevel > 1) {
            add2.setText("2");
            add2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gameMode = 0;
                level = 1;
                createLevel(gameMode, level);
            }}
        );
        }
        add2.setFont(new Font("Lucida Grande", Font.BOLD, 30));
        add2.setBounds(240, 219, 63, 50);
        panel_1.add(add2);
        
        JButton add3 = new JButton("");
        
        if (addLevel > 2) {
            add3.setText("3");
        add3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gameMode = 0;
                level = 2;
                createLevel(gameMode, level);
            }
        });
        }
        add3.setFont(new Font("Lucida Grande", Font.BOLD, 30));
        add3.setBounds(305, 219, 63, 50);
        panel_1.add(add3);
        
        JButton add4 = new JButton("");
        
        if (addLevel > 3) {
            add4.setText("4");
        add4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gameMode = 0;
                level = 3;
                createLevel(gameMode, level);
            }
        });
        }
        add4.setFont(new Font("Lucida Grande", Font.BOLD, 30));
        add4.setBounds(370, 219, 63, 50);
        panel_1.add(add4);
        
        JButton sub1 = new JButton("1");
        sub1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gameMode = 1;
                level = 0;
                createLevel(gameMode, level);
            }
        });
        sub1.setFont(new Font("Lucida Grande", Font.BOLD, 30));
        sub1.setBounds(175, 293, 63, 50);
        panel_1.add(sub1);
        
        JButton sub2 = new JButton("");
        
        if (subLevel > 1) {
            sub2.setText("2");
        sub2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gameMode = 1;
                level = 1;
                createLevel(gameMode, level);
            }
        });
        }
        sub2.setFont(new Font("Lucida Grande", Font.BOLD, 30));
        sub2.setBounds(240, 293, 63, 50);
        panel_1.add(sub2);
        
        JButton sub3 = new JButton("");
        
        if (subLevel > 2) {
            sub3.setText("3");
        sub3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gameMode = 1;
                level = 2;
                createLevel(gameMode, level);
            }
        });
        }
        sub3.setFont(new Font("Lucida Grande", Font.BOLD, 30));
        sub3.setBounds(305, 293, 63, 50);
        panel_1.add(sub3);
        
        JButton sub4 = new JButton("");
        
        if (subLevel > 3) {
            sub4.setText("4");
        sub4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gameMode = 1;
                level = 3;
                createLevel(gameMode, level);
            }
        });
        }
        sub4.setFont(new Font("Lucida Grande", Font.BOLD, 30));
        sub4.setBounds(370, 293, 63, 50);
        panel_1.add(sub4);
        
        JButton mult1 = new JButton("1");
        mult1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gameMode = 2;
                level = 0;
                createLevel(gameMode, level);
            }
        });
        mult1.setFont(new Font("Lucida Grande", Font.BOLD, 30));
        mult1.setBounds(175, 369, 63, 50);
        panel_1.add(mult1);
        
        JButton mult2 = new JButton("");
        
        if (mulLevel > 1) {
            mult2.setText("2");
        mult2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gameMode = 2;
                level = 1;
                createLevel(gameMode, level);
            }
        });
        }
        mult2.setFont(new Font("Lucida Grande", Font.BOLD, 30));
        mult2.setBounds(240, 369, 63, 50);
        panel_1.add(mult2);
        
        JButton mult3 = new JButton("");
        
        if (mulLevel > 2) {
            mult3.setText("3");
        mult3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gameMode = 2;
                level = 2;
                createLevel(gameMode, level);
            }
        });
        }
        mult3.setFont(new Font("Lucida Grande", Font.BOLD, 30));
        mult3.setBounds(305, 369, 63, 50);
        panel_1.add(mult3);
        
        JButton mult4 = new JButton("");
        
        if (mulLevel > 3) {
            mult4.setText("4");
        mult4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gameMode = 2;
                level = 3;
                createLevel(gameMode, level);
            }
        });
        }
        mult4.setFont(new Font("Lucida Grande", Font.BOLD, 30));
        mult4.setBounds(370, 369, 63, 50);
        panel_1.add(mult4);
        
        JButton div1 = new JButton("1");
        div1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gameMode = 3;
                level = 0;
                createLevel(gameMode, level);
            }
        });
        div1.setFont(new Font("Lucida Grande", Font.BOLD, 30));
        div1.setBounds(175, 451, 63, 50);
        panel_1.add(div1);
        
        JButton div2 = new JButton("");
        
        if (divLevel > 1) {
            div2.setText("2");
        div2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gameMode = 3;
                level = 1;
                createLevel(gameMode, level);
            }
        });
        }
        div2.setFont(new Font("Lucida Grande", Font.BOLD, 30));
        div2.setBounds(240, 451, 63, 50);
        panel_1.add(div2);
        
        JButton div3 = new JButton("");
        
        if (divLevel > 2) {
            div3.setText("3");
        div3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gameMode = 3;
                level = 2;
                createLevel(gameMode, level);
            }
        });
        }
        div3.setFont(new Font("Lucida Grande", Font.BOLD, 30));
        div3.setBounds(305, 451, 63, 50);
        panel_1.add(div3);
        
        JButton div4 = new JButton("");

        if (divLevel > 3) {
            div4.setText("4");
        div4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gameMode = 3;
                level = 3;
                createLevel(gameMode, level);
            }
        });
        }
        div4.setFont(new Font("Lucida Grande", Font.BOLD, 30));
        div4.setBounds(370, 451, 63, 50);
        panel_1.add(div4);
        
        JLabel basketballBackground = new JLabel("");
        basketballBackground.setIcon(new ImageIcon(InstructorModePage.class.getResource("/images/output-onlinepngtools.png")));
        basketballBackground.setBounds(0, 0, 557, 652);
        panel_1.add(basketballBackground);
    }
}
