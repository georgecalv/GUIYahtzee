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
        System.out.println("numdie = " + this.numDie + " numTurns = " + this.numTurns + " sideDie = " + this.sideDie + " numPLayers = " + this.numPlayers);
    }

}
