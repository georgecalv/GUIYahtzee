import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class MakePlayers {
    // asks for player names and creates each object along with their scorecards
    // starts game of yahtzee
    private int numDie;
    private int numTurns;
    private int sideDie;
    private int numPlayers;

    public MakePlayers(int numDie, int numTurns, int sideDie, int numPlayers) {
        this.numDie = numDie;
        this.numTurns = numTurns;
        this.sideDie = sideDie;
        this.numPlayers = numPlayers;
    }
    public void getPlayers() {
        JFrame PlayerFrame = new JFrame("Players");
        PlayerFrame.setLayout(new FlowLayout());
        JPanel buttonP = new JPanel();

        // making scroll bar
        Vector<String> columnNames = new Vector<String>(Arrays.asList("Player Name"));
        Vector<Vector<String>> content = new Vector<Vector<String>>();
        for(int i = 0; i < this.numPlayers; i++) {
            content.add(new Vector<String>(Arrays.asList("Enter Name Here")));
        }
        JTable table = new JTable(content, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        // button to start playing
        JButton play = new JButton("Play Game");
        play.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Play Game button Clicked");
                String[] playerNames = new String[numPlayers];
                // getting names added
                for(int j = 0; j < numPlayers; j++) {
                    playerNames[j] = content.get(j).get(0);
                }
                PlayerFrame.dispose();
                Yahtzee game = new Yahtzee(numDie, numTurns, sideDie, numPlayers, playerNames);
                game.playGame();
            }
        });
        buttonP.add(play);
        PlayerFrame.add(scrollPane);
        PlayerFrame.add(buttonP);
        PlayerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PlayerFrame.setSize(500,200);
        PlayerFrame.setLocationRelativeTo(null);
        PlayerFrame.setResizable(false);
        PlayerFrame.setVisible(true);  
    }

}
