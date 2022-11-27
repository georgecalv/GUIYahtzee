import java.util.*;
import javax.swing.*;
// import java.awt.Image;

public class Player {
    // has name score and turns maybe
    private int numDie;
    private int sideDie;
    private ScoreCard card;
    private String name;
    private ArrayList<Integer> rolls;
    private Die dice;
    private int GrandTotal;
    private int[] scoresUsed;
    private ArrayList<String> userPicks;
    private String[] lowerNames = {"3K", "4K", "FH", "LS", "SS", "Y", "CH"};
    private int totalHigherScores;
    

    public Player(String name, int numDie, int sideDie) {
        this.name = name;
        this.numDie = numDie;
        this.sideDie = sideDie;
        card = new ScoreCard(numDie, sideDie);
        dice = new Die(this.sideDie);
        this.rolls = new ArrayList<Integer>();
        this.scoresUsed = new int[this.sideDie + 7];
        this.GrandTotal = 0;
        this.GrandTotal = 0;
        this.userPicks = new ArrayList<String>();
        this.totalHigherScores = 0;
    }
    public Die getDie() {
        return this.dice;
    }

    /**
    Rolls all five dice and adds it to the games rolls array list
    *
    * @param none
    * @return none
    */
    public void rollDice() {
        for(int i = 0; i < this.numDie; i++) {
            this.rolls.add(this.dice.rollDie());
        }
    } 
    public ArrayList<Integer> getHand() {
        return this.rolls;
    }
    /**
    Sorts the rolls array list in increasing order then prints out the sorted list
    *
    * @param none
    * @return none
    */
    public void sortRolls() {
        int temp;
        // sorting rolls
        for(int i = 0; i < rolls.size() - 1; i++) {
            for(int j = i + 1; j < rolls.size(); j++) {
                // swap
                if(rolls.get(i) > rolls.get(j)) {
                    temp = rolls.get(i);
                    rolls.set(i,rolls.get(j));
                    rolls.set(j,temp);
                }
            }
        }
    }
    public void displayScoreCard() {
        JFrame frame = new JFrame();
        JPanel listPane = new JPanel();
        listPane.setLayout(new BoxLayout(listPane, BoxLayout.PAGE_AXIS));

        ArrayList<String> result = new ArrayList<String>(); 
        result.add("Line\t\tScore");
        result.add("=====================");
        result.add("Upper Section");
        result.add("=====================");
        for(int i = 1; i <= this.sideDie; i++) {
            result.add(i + "'s\t\t " + this.scoresUsed[i - 1]);
        }
        result.add("=====================");
        result.add("Lower Section");
        result.add("=====================");
        for(int j = this.sideDie; j < this.sideDie + 7; j++) {
            result.add(this.lowerNames[j - this.sideDie] + " \t\t" + this.scoresUsed[j]);
        }
        result.add("=====================");
        result.add("Grand Total\t " + this.GrandTotal);
        
        for(int k = 0; k < result.size(); k++) {
            listPane.add(new JLabel(result.get(k)));
        }
        frame.add(listPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200,400);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);  
    }
        /**
    getScoreCard
    *
    * @param Score object that has calulated the score for the roll of die
    * @return ArrayList<JRadioButton> the choices that a user can choose
    */
    public ArrayList<JRadioButton> getScoreCard(Score score) {
        ArrayList<JRadioButton> buttons = new ArrayList<JRadioButton>();
        JRadioButton tmp;
        int lines[] = score.getHigherScores();
        int lowerScores[] = score.getLowerScores();
        JRadioButton zero = new JRadioButton("0 line", false);
        zero.setName("0");
        buttons.add(0, zero);
        for(int i = 1; i <= this.sideDie; i++) {
            tmp = new JRadioButton("" + i + " line: " + lines[i - 1], false);
            tmp.setName("" + i);
            buttons.add(i, tmp);
        }
        for(int j = 0; j < 7; j++) {
            tmp = new JRadioButton(lowerNames[j] + ": " + lowerScores[j], false);
            tmp.setName(lowerNames[j]);
            buttons.add(this.sideDie + j, tmp);
        }
        return buttons;
    }

}
