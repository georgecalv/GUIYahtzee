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
    private ArrayList<Integer> hand;
    private Score score;
    private Die die;
    private int player;
    // private JFrame GameFrame;
    // private JPanel PlayerTurn;
    // private JPanel Select;
    // private JPanel Options;
    // private JPanel DiceHand;

    public Yahtzee(int numDie, int numTurns, int sideDie, int numPlayers, String[] playerNames) {
        this.numDie = numDie;
        this.numTurns = numTurns;
        this.sideDie = sideDie;
        this.numPlayers = numPlayers;
        this.playerNames = playerNames;
        this.score = new Score(this.numDie, this.sideDie);
        this.die = new Die(this.sideDie);
        this.playerVec = new Vector<Player>();
        this.player = 0;
        this.createPlayers();
        // this.GameFrame = new JFrame("Yahtzee");
        // this.GameFrame.setLayout(new GridLayout(4,0));
        // this.PlayerTurn = new JPanel(new FlowLayout());
        // this.Select = new JPanel(new FlowLayout());
        // this.Options = new JPanel(new FlowLayout());
        // this.DiceHand = new JPanel(new FlowLayout());
    }
    // runs game
    public void playGame() {
        // loop for each player until they want to end the game or all lines are gone
        // another loop for how many rolls per player

        // Frame settings
        JFrame GameFrame = new JFrame("Yahtzee");
        GameFrame.setLayout(new GridLayout(4,0));
        JPanel PlayerTurn = new JPanel(new FlowLayout());
        // JPanel DiceHand = new JPanel(new GridLayout(0, this.numDie));
        JPanel Select = new JPanel(new FlowLayout());
        JPanel Options = new JPanel(new FlowLayout());
        JPanel DiceHand = new JPanel(new FlowLayout());

        
        JLabel playerDisplay = new JLabel(playerNames[player] + "'s Turn");
        playerDisplay.setFont(new Font("Serif", Font.PLAIN, 26));
        PlayerTurn.add(playerDisplay);
        // roll player dice
        playerVec.get(player).rollDice();
        this.hand = playerVec.get(player).getHand();
        ArrayList<JCheckBox> images = displayHand(this.hand);
        ArrayList<JCheckBox> selection = makeSelections();
        for(int i = 0; i < images.size(); i++) {
            DiceHand.add(images.get(i));
            Select.add(selection.get(i));
        }
        // add buttons for re roll and display score card
        JButton reRoll = new JButton("Reroll");
        reRoll.addActionListener(new ActionListener() {
            int turn = 0;
            public void actionPerformed(ActionEvent e) {
                System.out.println("Reroll button clicked");
                if(turn <= 1) {
                    for(int j = 0; j < numDie; j++) {
                        if(!selection.get(j).isSelected()) {
                            hand.set(j, playerVec.get(player).getDie().rollDie());
                            images.get(j).setIcon(getImage(hand.get(j)));
                        }
                    }
                    turn += 1;
                    DiceHand.revalidate();
                    DiceHand.repaint();
                }
                // turn ended
                else {
                    playerVec.get(player).sortRolls();
                    // score.checkRolls(hand);
                    // ArrayList<JRadioButton> choices = playerVec.get(player).getScoreCard(score);
                    System.out.println("end turn");
                    if(player == numPlayers - 1) {
                        player = 0;
                    }
                    else {
                        player++;
                    }
                    hand.clear();
                    images.clear();
                    selection.clear();
                    GameFrame.dispose();
                    playGame();

                }
            }
        });
        JButton dispScoreCard = new JButton("Display Score Card");
        dispScoreCard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Display Score card clicked");
                playerVec.get(player).displayScoreCard();
            }
        });
        Options.add(reRoll);
        Options.add(dispScoreCard);

        GameFrame.add(PlayerTurn);
        GameFrame.add(DiceHand);
        GameFrame.add(Select);
        GameFrame.add(Options);


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
    public ArrayList<JCheckBox> displayHand(ArrayList<Integer> hand) {
        ArrayList<JCheckBox> images = new ArrayList<JCheckBox>();
        for(int i = 0; i < hand.size(); i++) {
            images.add(i, new JCheckBox(getImage(hand.get(i))));
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
