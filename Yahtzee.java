public class Yahtzee {
    // runs ands displays game of yahtzee
    private int numDie;
    private int numTurns;
    private int sideDie;
    private int numPlayers;
    private String[] playerNames;
    private Score score;
    private Die die;

    public Yahtzee(int numDie, int numTurns, int sideDie, int numPlayers, String[] playerNames) {
        this.numDie = numDie;
        this.numTurns = numTurns;
        this.sideDie = sideDie;
        this.numPlayers = numPlayers;
        this.playerNames = playerNames;

        this.score = new Score(this.numDie, this.sideDie);
        this.die = new Die(this.sideDie);

    }
    public void playGame() {

    }
}
