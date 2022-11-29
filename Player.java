import java.util.*;
import javax.swing.*;
// import java.awt.Image;

public class Player {
    // has name score and turns maybe
    private int numDie;
    private int sideDie;
    // private ScoreCard card;
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
        // card = new ScoreCard(numDie, sideDie);
        dice = new Die(this.sideDie);
        this.rolls = new ArrayList<Integer>();
        this.scoresUsed = new int[this.sideDie + 7];
        this.GrandTotal = 0;
        this.GrandTotal = 0;
        this.userPicks = new ArrayList<String>();
        this.totalHigherScores = 0;
    }
    public int getTotalHigherScores() {
        return this.totalHigherScores;
    }
    // public ScoreCard getScoreCard() {
    //     return this.card;
    // }
    public String getName() {
        return this.name;
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
    public JPanel displayScoreCard() {
        // JFrame frame = new JFrame();
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
        // frame.add(listPane);
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setSize(200,400);
        // frame.setLocationRelativeTo(null);
        // frame.setResizable(false);
        // frame.setVisible(true);  
        return listPane;
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
        /**
    takes in string of response to what socre the user wants and adds it to their score
    *
    * @param String of the response and then the score object containg the scores calc for their roll
    * @return score added to users scores
    */
    public void addScore(String response, Score score) {
        int lines[] = score.getHigherScores();
        int lowerScores[] = score.getLowerScores();
        // integer which means it is higher scorecard
        if(this.testInt(response)) {
            if(Integer.parseInt(response) == 0) {
                this.userPicks.add("0");
            }
            // add line
            else {
                scoresUsed[Integer.parseInt(response) - 1] += lines[Integer.parseInt(response) - 1];
                this.GrandTotal += lines[Integer.parseInt(response) - 1];
                this.totalHigherScores += lines[Integer.parseInt(response) - 1];
                this.userPicks.add(response);
            }
        }
        // lower score card
        else {
            int total = 0;
            switch(response.toUpperCase()) {
                case "3K":
                    scoresUsed[this.sideDie] += lowerScores[0];
                    total = lowerScores[0];
                    this.userPicks.add("3K");
                    break;
                case "4K":
                    scoresUsed[this.sideDie + 1] += lowerScores[1];
                    total = lowerScores[1];
                    this.userPicks.add("4K");
                    break;
                case "FH":
                    scoresUsed[this.sideDie + 2] += lowerScores[2];
                    total = lowerScores[2];
                    this.userPicks.add("FH");
                    break;
                case "LS":
                    scoresUsed[this.sideDie + 3] += lowerScores[3];
                    total = lowerScores[3];
                    this.userPicks.add("LS");
                    break;
                case "SS":
                    scoresUsed[this.sideDie + 4] += lowerScores[4];
                    total = lowerScores[4];
                    this.userPicks.add("SS");
                    break;
                case "Y":
                    scoresUsed[this.sideDie + 5] += lowerScores[5];
                    total = lowerScores[5];
                    this.userPicks.add("Y");
                    break;
                case "CH":
                    scoresUsed[this.sideDie + 6] += lowerScores[6];
                    total = lowerScores[6];
                    this.userPicks.add("CH");
                    break;
            }
            this.GrandTotal += total;
        }
    }
        /**
    checks if a string is an integer
    *
    * @param string of tthe potential number
    * @return bool of whether it is a number or not
    */
    private boolean testInt(String s) {
        try {
            int intValue = Integer.parseInt(s);
            return true;
        } 
        catch (NumberFormatException e) {
            e.getStackTrace();
            return false;
        }
    }
    /**
    checks if the response has been used
    *
    * @param String of response
    * @return checks if user inpurt was already used true if used
    */
    public boolean checkUsed(String response) {
        if(this.userPicks.contains(response)) {
            return true;
        }
        return false;
    }
    /**
    getter for ScoresUsed
    *
    * @param nothing
    * @return array of ints of what was used
    */
    public int[] getScoresUsed() {
        return this.scoresUsed;
    }
    /**
    getter for what the user has used
    *
    * @param nothing
    * @return Arraylist of String with the user inputs accepted that the user has used
    */
    public ArrayList<String> getUserPicks() {
        return this.userPicks;
    }
    /**
    getter for Total
    *
    * @param nothing
    * @return integer of the total score
    */
    public int getTotal() {
        return this.GrandTotal;
    }
    /**
    getter for sideDie
    *
    * @param nothing
    * @return intger of the number of sides per die 
    */
    public int getSideDie() {
        return this.sideDie;
    }
    /**
    newGame
    *
    * @param nothing
    * @return resets variables for a new game of yahtzee
    */
    public void newGame() {
        this.GrandTotal = 0;
        this.userPicks.clear();
        for(int i = 0; i < this.sideDie + 7; i++) {
            this.scoresUsed[i] = 0;
        }
    }
    public boolean checkFullScoreCard() {
        // OMFG CONSTANT TIME HOLY FUCK SHIT BALLS 
        if(this.userPicks.size() == this.sideDie + 8) {
            return true;
        }
        return false;
    }


}
