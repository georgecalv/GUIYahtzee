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
    private Die die;

    public Yahtzee(int numDie, int numTurns, int sideDie, int numPlayers, String[] playerNames) {

        this.numDie = numDie;
        this.numTurns = numTurns;
        this.sideDie = sideDie;
        this.numPlayers = numPlayers;
        this.playerNames = playerNames;

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
        JPanel DiceHand = new JPanel(new FlowLayout());
        JPanel Options = new JPanel(new FlowLayout());

        
        
        int turn = 0;
        JLabel playerDisplay = new JLabel(playerNames[turn]);
        PlayerTurn.add(playerDisplay);
        JButton nextPlayer = new JButton("Next Player");
        nextPlayer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int player = turn;
                System.out.println("Button clicked");
                if(player < numPlayers) {
                    playerDisplay.setText(playerNames[player]);
                    player += 1;
                    // turn = player;
                    PlayerTurn.repaint();
                    PlayerTurn.revalidate();
                }
            }
        });
        PlayerTurn.add(nextPlayer);
        GameFrame.add(PlayerTurn);
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
}
