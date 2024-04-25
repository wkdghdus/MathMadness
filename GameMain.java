
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.awt.Font;
import javax.swing.JButton;

/**
 * This class is used for the main game frame screen.
 * 
 * @version 1.0
 * @author Atmiya Patel
 * @author Ben Santhosh
 * @author Hoyeon Luke Jang
 */
public class GameMain extends JFrame implements KeyListener {

    /** x value of the ball, initialized with its starting position */
    private int ballx = 420;
    /** y value of the ball, initialized with its starting position */
    private int bally = 500;
    /** x value of the first net */
    private final int net1X = 100;
    /** x value of the second net */
    private final int net2X = 410;
    /** x value of the third net */
    private final int net3X = 720;
    /** GUI (JSwings) variable for the images and the button */
    private JLabel basketball;
    private JLabel livesLabel;
    private JButton nextButton;
    private JLabel gifLabel;
    /** boolean value to check if the ball is moving */
    private boolean ballMoving = true;
    /** instance variable for the question */
    Question question;
    /** instance variable for the multiple choice options */
    int[] options;
    /** instance variable for the question bank */
    Question[] questionBank;
    /** instance variable for the index of the question 0 to 4*/
    int questionIndex = 0;
    /** boolean value to check if the answer is correct */
    private boolean correct;
    /** instance variable for the number of lives */
    int lives;
    
    

    /**
     * Launch the game frame.
     * 
     * @param args The command line arguments, does not matter in this case.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
//                    Game game = new Game(2, 2);
//                    Question[] questionBank = game.getQuestionBank();
//                    int questionIndex = 0;
//                    GameMain frame = new GameMain(questionBank, questionIndex);
//                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Constructor for the game
     * 
     * @param questionBank  The array of questions for the current level
     * @param questionIndex The index of the current question
     * @param lives Remaining lives
     * @param gameMode The current game mode
     * @param username The username of the player
     * @param level The current level
     */
    public GameMain(Question[] questionBank, int questionIndex, int lives, int gameMode, String username, int level) {
    	
    	this.lives = lives;
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 950, 680);
        setResizable(false);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        this.questionIndex = questionIndex;
        question = questionBank[questionIndex];
        options = question.generateOptions();
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(230, 0, 480, 646);
        contentPane.add(panel);
        panel.setLayout(null);
        panel.setOpaque(false);
        
        gifLabel = new JLabel("");
        gifLabel.setBounds(0, 94, 480, 480);
        panel.add(gifLabel);

        basketball = new JLabel("");
        basketball.setIcon(new ImageIcon(GameMain.class.getResource("/images/basketball.png")));
        basketball.setBounds(ballx, bally, 100, 100);
        contentPane.add(basketball);

        JLabel lblNewLabel_2 = new JLabel("", JLabel.CENTER);
        lblNewLabel_2.setForeground(new Color(0, 51, 204));
        lblNewLabel_2.setFont(new Font("Lucida Grande", Font.BOLD, 30));
        lblNewLabel_2.setText(String.valueOf(options[0]));
        lblNewLabel_2.setBounds(100, 70, 130, 77);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("", JLabel.CENTER);
        lblNewLabel_3.setForeground(new Color(0, 51, 204));
        lblNewLabel_3.setFont(new Font("Lucida Grande", Font.BOLD, 30));
        lblNewLabel_3.setText(String.valueOf(options[1]));
        lblNewLabel_3.setBounds(410, 70, 130, 77);
        contentPane.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("", JLabel.CENTER);
        lblNewLabel_4.setFont(new Font("Lucida Grande", Font.BOLD, 30));
        lblNewLabel_4.setForeground(new Color(0, 51, 204));
        lblNewLabel_4.setText(String.valueOf(options[2]));
        lblNewLabel_4.setBounds(720, 70, 130, 77);
        contentPane.add(lblNewLabel_4);
        
        JLabel questionLabel = new JLabel(question.getQuestion() + " = ?", JLabel.CENTER);
        questionLabel.setBackground(Color.WHITE);
        questionLabel.setForeground(Color.WHITE);
        questionLabel.setFont(new Font("Lucida Grande", Font.BOLD, 32));
        questionLabel.setBounds(357, 324, 209, 69);
        contentPane.add(questionLabel);
        
        livesLabel = new JLabel(String.valueOf(lives), JLabel.CENTER);
        livesLabel.setFont(new Font("Lucida Grande", Font.BOLD, 25));
        livesLabel.setForeground(new Color(255, 255, 255));
        livesLabel.setBounds(23, 565, 61, 43);
        contentPane.add(livesLabel);
        
        nextButton = new JButton("NEXT");
        nextButton.setBounds(799, 596, 145, 50);
        contentPane.add(nextButton);
        nextButton.setVisible(false);
        
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        		int currentLives = lives;
        		
            	if(!correct) {
            		currentLives--;
            	}
            	
            	if(questionIndex == 4 && currentLives > 0) {
            		nextButton.setVisible(false);
            		Levels levels = new Levels(gameMode, username);
            		int[] levelsUnlocked = levels.getLevelsUnlocked();
            		if(levelsUnlocked[gameMode] < 5 && levelsUnlocked[gameMode]==level+1) {
            			levels.setLevelsUnlocked(gameMode, level+1);
            		}
            		
            		SaveFrame saveFrame = new SaveFrame(username, currentLives, 0);
            		saveFrame.setVisible(true);
            		dispose();

            	}
            	
            	else if(questionIndex <= 5 && currentLives > 0) {
            		if(correct) {
                        GameMain gameMain = new GameMain(questionBank, questionIndex + 1, lives, gameMode, username, level);
                        gameMain.setVisible(true);
                        dispose();
            		}
            		else {
                        GameMain gameMain = new GameMain(questionBank, questionIndex + 1, lives-1, gameMode, username, level);
                        gameMain.setVisible(true);
                        dispose();
            		}

            	}
            	else if(currentLives == 0){
            		SaveFrame saveFrame = new SaveFrame(username, 0, 1);
            		saveFrame.setVisible(true);
            		dispose();
                    //check
            		
            	}
            	

            }
        });
        

        
        JLabel heartIcon = new JLabel("");
        heartIcon.setIcon(new ImageIcon(GameMain.class.getResource("/images/heart.png")));
        heartIcon.setBounds(6, 545, 90, 90);
        contentPane.add(heartIcon);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(GameMain.class.getResource("/images/gameBackground.png")));
        lblNewLabel.setBounds(0, -34, 950, 680);
        contentPane.add(lblNewLabel);

        // Add key listener to the frame
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    @Override
    /**
     * Method to respond to key press events
     * move left and write for the arrow keys
     * shoots for the spacebar key
     */
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_LEFT && ballMoving) {
            if (ballx > net1X + 50) { // Ensure ball is not at left net
                ballx -= 310; // Move left
            }        
            } 
        else if (keyCode == KeyEvent.VK_RIGHT && ballMoving) {
                if (ballx < net3X - 50) { // Ensure ball is not at right net
                    ballx += 310; // Move right
                }
            } else if (keyCode == KeyEvent.VK_SPACE) {
            	ballMoving = false;
            	int xAxis = ballx;
            	int position = 0;
            	if(xAxis == 110) {
            		position = 0;
            	}
            	else if(xAxis == 420) {
            		position = 1;
            	}
            	else if(xAxis == 730) {
            		position = 2;
            	}
            	
                if (options[position] == question.getAnswer()) {
                    gifLabel.setIcon(new ImageIcon(GameMain.class.getResource("/images/correct.gif")));
                    correct = true;
                    basketball.setVisible(false);
                    nextButton.setVisible(true);
                    
                } else {
                    gifLabel.setIcon(new ImageIcon(GameMain.class.getResource("/images/incorrect.gif")));
                    correct = false;
                    basketball.setVisible(false);
                    nextButton.setVisible(true);
            		livesLabel.setText(String.valueOf(lives-1));
                }
            	
            	
            }
            else if (keyCode == KeyEvent.VK_ENTER && nextButton.isVisible()) {
                nextButton.doClick(); 
            }
            
            basketball.setLocation(ballx, bally);

            
            
        }

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    }