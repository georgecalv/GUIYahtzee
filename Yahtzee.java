import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Yahtzee {
    // runs ands displays game of yahtzee
    private int numDie;
    private int numTurns;
    private int sideDie;
    private int numPlayers;
    private String[] playerNames;
    private Vector<Player> playerVec;
    private Score score;
    private Die die;

    public Yahtzee(int numDie, int numTurns, int sideDie, int numPlayers, String[] playerNames) {
        this.numDie = numDie;
        this.numTurns = numTurns;
        this.sideDie = sideDie;
        this.numPlayers = numPlayers;
        this.playerNames = playerNames;
        this.score = new Score(this.numDie, this.sideDie);
        this.die = new Die(this.sideDie);
        this.playerVec = new Vector<Player>();
        this.createPlayers();
    }
    // runs game
    public void playGame() {
        // loop for each player until they want to end the game or all lines are gone
        // another loop for how many rolls per player

        // Frame settings
        JFrame GameFrame = new JFrame("Yahtzee");
        GameFrame.setLayout(new GridLayout(3,0));
        JPanel PlayerTurn = new JPanel(new FlowLayout());
        // JPanel DiceHand = new JPanel(new GridLayout(0, this.numDie));
        JPanel Options = new JPanel(new FlowLayout());
        JPanel DiceHand = new JPanel(new FlowLayout());

        
        ArrayList<Integer> hand;
        int i = 0;
        while(i < this.numPlayers){
            JLabel playerDisplay = new JLabel(playerNames[i] + "'s Turn");
            // playerDisplay.setFont(new Font("Serif", Font.PLAIN, 26));
            PlayerTurn.add(playerDisplay);
            // roll player dice
            playerVec.get(i).rollDice();
            // get hand
            hand = playerVec.get(i).getHand();
            // sort hand
            playerVec.get(i).sortRolls();
            // display hand
            ArrayList<JCheckBox> images = displayHand(i);
            ArrayList<JCheckBox> selection = makeSelections();
            for(int j = 0; j < images.size(); j++) {
                DiceHand.add(images.get(i));
            }
            i++;

        }

        GameFrame.add(PlayerTurn);
        GameFrame.add(DiceHand);
        // GameFrame.add(Options);

        GameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GameFrame.setSize(1000,800);
        GameFrame.setLocationRelativeTo(null);
        GameFrame.setResizable(false);
        GameFrame.setVisible(true);  

    }
    // makes vector of player objects
    public void createPlayers() {
        for(int i = 0; i < this.numPlayers; i++) {
            playerVec.add(new Player(playerNames[i], this.numDie, this.sideDie));
        }
    }
    public ArrayList<JCheckBox> displayHand(int player) {
        ArrayList<JCheckBox> images = new ArrayList<JCheckBox>();
        JCheckBox tmp;
        int roll;
        for(int i = 0; i < this.numDie; i++) {
            roll = this.playerVec.get(player).getHand().get(i);
            tmp = new JCheckBox(getImage(roll), false);
            tmp.setBackground(Color.RED);
            tmp.setOpaque(false);
            images.add(i, tmp);
        }
        return images;
    }
    public ArrayList<JCheckBox> makeSelections() {
        ArrayList<JCheckBox> selections = new ArrayList<JCheckBox>();
        for(int i = 0; i < this.numDie; i++) {
            selections.add(i, new JCheckBox("", false));
        }
        return selections;
    }
                /***
    gets the image of the die that goes with the number rolled 
    *
    * @param integer of the number rolled
    * @return ImageIcon of the number rolled
    */
    public ImageIcon getImage(int i) {
        ImageIcon image = new ImageIcon();            
        switch(i) {
            case 1:
                image = new ImageIcon("images/D6-01.png");
                break;
            case 2:
                image = new ImageIcon("images/D6-02.png");
                break;
            case 3:
                image = new ImageIcon("images/D6-03.png");
                break;
            case 4:
                image = new ImageIcon("images/D6-04.png");
                break;
            case 5:
                image = new ImageIcon("images/D6-05.png");
                break;
            case 6:
                image = new ImageIcon("images/D6-06.png");
                break;
            case 7:
                image = new ImageIcon("images/D6-07.png");
                break;
            case 8:
                image = new ImageIcon("images/D6-08.png");
                break;
            case 9:
                image = new ImageIcon("images/D6-09.png");
                break;
            case 10:
                image = new ImageIcon("images/D6-10.png");
                break;
            case 11:
                image = new ImageIcon("images/D6-11.png");
                break;
            case 12:
                image = new ImageIcon("images/D6-12.png");
                break;

        }  
        // return scaled image
        return new ImageIcon(image.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
    }

}
