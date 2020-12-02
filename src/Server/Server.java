package Server;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Created by Philip Zamayeri
 * Date: 2020-11-25
 * Time: 14:27
 * Project: SportQuiz
 * Copyright: MIT
 */
public class Server {
    DAO questions = new DAO();

    public Server() throws IOException {
        int portnr = 57777;
        ServerSocket socket = new ServerSocket(portnr);

        try {
            while (true) {
                ServerSideGame game = new ServerSideGame(questions);
                ClientHandler player1
                        = new ClientHandler(socket.accept(), questions, game);
                ClientHandler player2
                        = new ClientHandler(socket.accept(), questions, game);


                player1.setOpponent(player2);
                player2.setOpponent(player1);
                game.currentPlayer = player1;
                game.setPlayer1(player1);
                game.setPlayer2(player2);
                player1.start();
                player2.start();
            }
        } finally {
            socket.close();
        }
    }


    public static void main(String[] args) throws IOException {
        Server server = new Server();
    }
}

