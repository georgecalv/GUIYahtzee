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
        JFrame EndFrame = new JFrame("End Game");
        EndFrame.setLayout(new BorderLayout());

        JPanel imageP = new JPanel();
        imageP.setBackground(new Color(184, 184, 184));
        JLabel yahtzee = new JLabel();
        yahtzee.setIcon(new ImageIcon("images/GameOver.png"));

        // has winner label
        JPanel winner = new JPanel();
        winner.setBackground(new Color(184, 184, 184));
        // has leaderboard
        JPanel leaderboard = new JPanel();
        leaderboard.setBackground(new Color(184, 184, 184));
        leaderboard.setLayout(new BoxLayout(leaderboard, BoxLayout.PAGE_AXIS));

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
            leaderboard.add(tmp);
        }
        // play again button
        JButton newGame = new JButton("Play Again?");
        newGame.setFont(new Font("Britannic Bold", Font.BOLD, 28));
        newGame.setPreferredSize(new Dimension(400, 100));
        newGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // starts new game of yahtzee
                InitialDisplay dp = new InitialDisplay();
                EndFrame.dispose();
                dp.Display();
            }
        });
        // add panels and button
        EndFrame.add(imageP, BorderLayout.PAGE_START);
        EndFrame.add(winner, BorderLayout.CENTER);
        EndFrame.add(leaderboard, BorderLayout.CENTER);
        EndFrame.add(newGame, BorderLayout.PAGE_END);
        
        // fraem settings
        EndFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        EndFrame.setSize(1000,800);
        EndFrame.setLocationRelativeTo(null);
        EndFrame.setResizable(false);
        EndFrame.setVisible(true); 

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
