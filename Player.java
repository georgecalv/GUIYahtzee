import java.util.*;
// import javax.swing.*;
// import java.awt.Image;

public class Player {
    // has name score and turns maybe
    private int numDie;
    private int sideDie;
    private ScoreCard card;
    private String name;
    private ArrayList<Integer> rolls;
    private Die dice;

    public Player(String name, int numDie, int sideDie) {
        this.name = name;
        this.numDie = numDie;
        this.sideDie = sideDie;
        card = new ScoreCard(numDie, sideDie);
        dice = new Die(this.sideDie);
        this.rolls = new ArrayList<Integer>();
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

}
