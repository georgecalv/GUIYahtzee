import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EndGame {
    Vector<Player> playerVec;

    public EndGame(Vector<Player> playerVec) {
        this.playerVec = playerVec;
    } 
    public void end() {
        sortPlayerVec();
        JFrame Frame = new JFrame("End Game");
        JPanel winner = new JPanel();
        JPanel losers = new JPanel();
        losers.setLayout(new BoxLayout(losers, BoxLayout.PAGE_AXIS));

        JLabel win = new JLabel("Congratulations " + this.playerVec.get(0).getName() + ", You Won!");
        win.setFont(new Font("Serif", Font.PLAIN, 26));
        winner.add(win);

        JLabel tmp;
        for(int i = 0; i < this.playerVec.size(); i++) {
            tmp = new JLabel((i + 1) + ". " + this.playerVec.get(i).getName() + " Score: " + this.playerVec.get(i).getTotal());
            tmp.setFont(new Font("Serif", Font.PLAIN, 16));
            losers.add(tmp);
        }
        JButton newGame = new JButton("Play Again?");
        newGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                InitialDisplay dp = new InitialDisplay();
                Frame.dispose();
                dp.Display();
            }
        });
        Frame.add(newGame);
        Frame.add(winner);
        Frame.add(losers);
        
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setSize(1000,800);
        Frame.setLocationRelativeTo(null);
        Frame.setResizable(false);
        Frame.setVisible(true); 

    }
    // sort in descending order
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
