package Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by Philip Zamayeri
 * Date: 2020-11-25
 * Time: 14:26
 * Project: SportQuiz
 * Copyright: MIT
 */

public class ClientHandler extends Thread{
    Socket clientSocket;
    DAO questionsDatabase;
    ClientHandler opponent;
    ServerSideGame game;

    ObjectOutputStream oos;

    public ClientHandler(Socket clientSocket, DAO questionsDatabase, ServerSideGame game) {
        this.clientSocket = clientSocket;
        this.questionsDatabase = questionsDatabase;
        this.game = game;

        try {
            ObjectOutputStream writer = new ObjectOutputStream(clientSocket.getOutputStream());
            oos = writer;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setOpponent(ClientHandler opponent) {
        this.opponent = opponent;
    }

    @Override
    public void run() {
        try {

            ObjectInputStream reader = new ObjectInputStream(clientSocket.getInputStream());

            game.setReady(this);

            Object input;
            while ((input = reader.readObject()) != null) {
                //this, för att kunna se vem som skickade objectet input.
                game.game(input, this);
                System.out.println("Get message " + input);

            }
        } catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public void sendMessage(Object obj){
        try{
            oos.writeObject(obj);
            oos.flush();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

