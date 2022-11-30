/**
* This program is the MAkePALyers object that creates players for the game
* CPSC 224-01, Fall 2022
* lil' Yahtzee
* No sources to cite.
* 
* @author George Calvert, Henry Stone, David Giacobbi
* @version v1.0 11/29/22
*/
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;
import java.awt.*;


public class MakePlayers {
    // asks for player names and creates each object along with their scorecards
    // starts game of yahtzee
    private int numDie;
    private int numTurns;
    private int sideDie;
    private int numPlayers;
    /*
    Constructor for MakePlayers
    * @param number dice, number turns, side of each die and then the number of players
    * @return initializes all variables needed
    */
    public MakePlayers(int numDie, int numTurns, int sideDie, int numPlayers) {
        this.numDie = numDie;
        this.numTurns = numTurns;
        this.sideDie = sideDie;
        this.numPlayers = numPlayers;
    }
    /**
    Creates players for the game
    *
    * @param nothing
    * @return Creates a GUI fo rthe user to interact and enter player names
    */
    public void getPlayers() {

        JFrame PlayerFrame = new JFrame("Players");
        PlayerFrame.setLayout(new BorderLayout());

        JPanel textP = new JPanel();
        textP.setLayout(new BoxLayout(textP, BoxLayout.PAGE_AXIS));

        JPanel buttonP = new JPanel();

        // Dynamically create text boxes to enter player names in
        Vector<JTextField> textBoxes = new Vector<JTextField>();
        for(int i = 0; i < this.numPlayers; i++) {

            JPanel newPlayer = new JPanel();
            
            textBoxes.add(new JTextField());

            textBoxes.get(i).setEditable(true);
            textBoxes.get(i).setFont(new Font("Cooper Black", Font.PLAIN, 30));
            textBoxes.get(i).setColumns(30);

            newPlayer.add(new JLabel("Player " + (i + 1)));
            newPlayer.add(textBoxes.get(i));
            textP.add(newPlayer);
        }

        // button to start playing
        JButton play = new JButton("Play Game");
        play.setPreferredSize(new Dimension(600, 100));

        play.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Play Game button Clicked");
                String[] playerNames = new String[numPlayers];
                // getting names added
                for(int j = 0; j < numPlayers; j++) {
                    playerNames[j] = textBoxes.get(j).getText();
                }
                // close frame
                PlayerFrame.dispose();
                Yahtzee game = new Yahtzee(numDie, sideDie, numPlayers, playerNames);
                game.playGame();
            }
        });
        // add button
        buttonP.add(play);

        // labels
        JPanel titleP = new JPanel();
        JLabel enterPlayerNames = new JLabel("Enter Your Player Names:");
        enterPlayerNames.setFont(new Font("Title", Font.BOLD, 56));
        titleP.add(enterPlayerNames);

        // add panels
        PlayerFrame.add(titleP, BorderLayout.PAGE_START);
        PlayerFrame.add(textP, BorderLayout.CENTER);
        PlayerFrame.add(buttonP, BorderLayout.PAGE_END);

        // frame settings
        PlayerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PlayerFrame.setSize(1200,800);
        PlayerFrame.setLocationRelativeTo(null);
        PlayerFrame.setResizable(false);
        PlayerFrame.setVisible(true);  
    }
}