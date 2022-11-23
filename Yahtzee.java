import java.util.*;
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
    }
    // makes vector of player objects
    public void createPlayers() {
        for(int i = 0; i < this.numPlayers; i++) {
            playerVec.add(new Player(playerNames[i], this.numDie, this.sideDie));
        }
    }
}
