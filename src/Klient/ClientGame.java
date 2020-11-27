package Klient;

import Klient.gui.GameFrame;
import Server.Question;

import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Philip Zamayeri
 * Date: 2020-11-25
 * Time: 14:25
 * Project: SportQuiz
 * Copyright: MIT
 */
public class ClientGame implements Runnable {
    int index = 0;
    List<Object> questionList;


    GameFrame gameFrame;

    public ClientGame (GameFrame gameFrame) {

        this.gameFrame = gameFrame;

        questionList = new ArrayList<>();
    }

    @Override
    public void run() {
        InetAddress iadr = null;
        try {
            iadr = InetAddress.getLocalHost();

            int portnr= 57777;

            Socket socketToServer = new Socket(iadr,portnr);
            System.out.println("Connected to server.");
            ObjectOutputStream oos = new ObjectOutputStream(socketToServer.getOutputStream());
            ObjectInputStream ooi = new ObjectInputStream(socketToServer.getInputStream());

            gameFrame.setObjectOutputStream(oos);

            Object incomingObject;

            while((incomingObject = ooi.readObject())!=null) {
                System.out.println("Server: " + incomingObject);
                //Kollar om incomingObject är en Question
                if(incomingObject instanceof Question) {
                    questionList.add(incomingObject);
                    gameFrame.getQuestionPanel().setClickedButtonColor(Color.YELLOW);
                    gameFrame.getQuestionPanel().addQuestionToPanel((Question)questionList.get(0));
                    gameFrame.changeToQuestionPanel();
                } else if(incomingObject instanceof String) {
                    String resultat = (String) incomingObject;
                    if(resultat.contains("Välj kategori")){
                        gameFrame.changeToCatagoriesPanel();
                    }
                    else if(resultat.contains("End of game")) {
                        //Ändra färg
                        socketToServer.close();
                        gameFrame.setObjectOutputStream(null);
                        gameFrame.changeToNewGamePanel();
                        break;
                    }
                    else if(resultat.contains("korrekt")) {
                        //Ändra färg
                        gameFrame.getQuestionPanel().setClickedButtonColor(Color.GREEN);
                        gameFrame.getQuestionPanel().setOpaque(true);
                        //Thread.sleep(1000);
                    }
                    else if (resultat.equalsIgnoreCase("Change question")){
                        gameFrame.getQuestionPanel().addQuestionToPanel((Question) questionList.get(1));
                        gameFrame.changeToQuestionPanel();
                        //Thread.sleep(1000);

                    }
                    else if (resultat.equalsIgnoreCase("Change to categorypanel")){
                        gameFrame.changeToCatagoriesPanel();
                        //Thread.sleep(1000);
                    }
                    else {
                        //Ändra färg
                        gameFrame.getQuestionPanel().setClickedButtonColor(Color.RED);
                        gameFrame.getQuestionPanel().setOpaque(true);
                        //Thread.sleep(1000);
                    }
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}