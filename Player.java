public class Player {
    // has name score and turns maybe
    // private int numDie;
    // private int sideDie;
    private ScoreCard card;
    private String name;

    public Player(String name, int numDie, int sideDie) {
        this.name = name;
        card = new ScoreCard(numDie, sideDie);

    }
}
