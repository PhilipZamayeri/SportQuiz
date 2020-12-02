package Server;

import java.io.Serializable;

public class Score implements Serializable {
    int yourScore;
    int opponentScore;

    public Score(int yourScore, int opponentScore) {
        this.yourScore = yourScore;
        this.opponentScore = opponentScore;
    }

    public int getYourScore() {
        return yourScore;
    }

    public int getOpponentScore() {
        return opponentScore;
    }
}
