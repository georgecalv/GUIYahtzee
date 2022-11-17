public class Yahtzee {
    // runs ands displays game of yahtzee
    private int numDie;
    private int numTurns;
    private int sideDie;
    private int numPlayers;
    private String[] playerNames;

    public Yahtzee(int numDie, int numTurns, int sideDie, int numPlayers, String[] playerNames) {
        this.numDie = numDie;
        this.numTurns = numTurns;
        this.sideDie = sideDie;
        this.numPlayers = numPlayers;
        this.playerNames = playerNames;
    }
    public void playGame() {
        for(int i = 0; i < this.numPlayers; i++) {
            System.out.println(this.playerNames[i]);
        }
    }
}
