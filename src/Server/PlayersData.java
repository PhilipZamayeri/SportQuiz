package Server;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class PlayersData {
    public final List<PlayersDAO> playerListOne= new ArrayList<>();
    public final List<PlayersDAO> playerListTwo=new ArrayList<>();
    //players list one
    PlayersDAO player1 = new PlayersDAO("John");

    //players list two
    PlayersDAO player6 = new PlayersDAO("Leo");

    public PlayersData() {
        playerListOne.add(player1);

        playerListTwo.add(player6);

    }
    public PlayersDAO getRandomPlayer1() {

        int randomPlayer = (int) (Math.random() * 1);
        return playerListOne.get(randomPlayer);
    }

    public PlayersDAO getRandomPlayer2() {

        int randomPlayer = (int) (Math.random() * 1);
        return playerListTwo.get(randomPlayer);
    }
    public static void main(String[] args) {
        PlayersData pDAO=new PlayersData();

    }
}
