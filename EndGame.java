/**
* This program is the EndGame Object that displays the ending leaderboard and who won
* CPSC 224-01, Fall 2022
* lil' Yahtzee
* No sources to cite.
* 
* @author George Calvert, Henry Stone, David Giacobbi
* @version v1.0 11/29/22
*/
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EndGame {
    Vector<Player> playerVec;

    /*
    Constructor for endGAme
    * @return initializes all variables needed
    */
    public EndGame(Vector<Player> playerVec) {
        this.playerVec = playerVec;
    } 

    /**
    Displays the end game frame
    *
    * @param nothing
    * @return Displays leaderboard and the winner
    */
    public void end() {
        // sort so the winner is at the beginning of the array
        sortPlayerVec();
        // Frames and panels
        JFrame Frame = new JFrame("End Game");
        Frame.setLayout(new BoxLayout(Frame.getContentPane(), BoxLayout.PAGE_AXIS));
        // has winner label
        JPanel winner = new JPanel();
        winner.setBackground(new Color(184, 184, 184));
        // has leaderboard
        JPanel losers = new JPanel();
        losers.setBackground(new Color(184, 184, 184));
        losers.setLayout(new BoxLayout(losers, BoxLayout.PAGE_AXIS));

        // label for winner
        JLabel win = new JLabel("Congratulations " + this.playerVec.get(0).getName() + ", You Won!");
        win.setFont(new Font("Copperplate", Font.PLAIN, 28));
        win.setForeground(Color.red);
        winner.add(win);

        // create leaderboard 
        JLabel tmp;
        for(int i = 0; i < this.playerVec.size(); i++) {
            tmp = new JLabel((i + 1) + ". " + this.playerVec.get(i).getName() + " Score: " + this.playerVec.get(i).getTotal());
            tmp.setFont(new Font("Copperplate", Font.PLAIN, 26));
            tmp.setForeground(Color.white);
            losers.add(tmp);
        }
        // play again button
        JButton newGame = new JButton("Play Again?");
        newGame.setFont(new Font("Britannic Bold", Font.BOLD, 28));
        newGame.setPreferredSize(new Dimension(400, 100));
        newGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // starts new game of yahtzee
                InitialDisplay dp = new InitialDisplay();
                Frame.dispose();
                dp.Display();
            }
        });
        // add panels and button
        Frame.add(winner);
        Frame.add(losers);
        Frame.add(newGame);
        
        // fraem settings
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setSize(1000,800);
        Frame.setLocationRelativeTo(null);
        Frame.setResizable(false);
        Frame.setVisible(true); 

    }
    /**
    Sort Vector in descending order so the winner is at index 0
    *
    * @param nothing
    * @return sorted vector
    */
    private void sortPlayerVec() {
        for(int i = 0; i < this.playerVec.size(); i++) {
            for(int k = i + 1; k < this.playerVec.size(); k++) {
                if(this.playerVec.get(i).getTotal() < this.playerVec.get(k).getTotal()) {
                    Player tmp = this.playerVec.get(i);
                    this.playerVec.set(i, this.playerVec.get(k));
                    this.playerVec.set(k, tmp);
                }
            }
        }
    }

}
