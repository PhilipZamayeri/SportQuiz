package Server;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Philip Zamayeri
 * Date: 2020-11-25
 * Time: 14:27
 * Project: SportQuiz
 * Copyright: MIT
 */
public class ServerSideGame extends Thread{
    ClientHandler currentPlayer;
    ClientHandler player1;
    ClientHandler player2;

    List<Question> questionList = new ArrayList<>();

    int indexP1 = 0;
    int indexP2 = 0;
    int categoryIndex = 0;
    int correctAnswer = 0;

    DAO dao;
    Question question;
    Question question2;


    public ServerSideGame(DAO dao){
        this.dao = dao;
    }
     // clienthandler som parameter för att veta vilken spelare som har skickat objectet(input)
    public void game(Object input, ClientHandler player){

        //player1.sendMessage("Välj kategori");
        //player2.sendMessage("Avvakta medans player1 väljer kategori");

        if(((String)input).equals("Geografi")){
            if (categoryIndex == 0) {
                question = dao.geopgraphy.get(0);
                question2 = dao.geopgraphy.get(1);
                player1.sendMessage(question);
                player1.sendMessage(question2);
                player2.sendMessage(question);
                player2.sendMessage(question2);
            }//skickar frågan till player två också
            else if (categoryIndex == 1){
                question = dao.geopgraphy.get(2);
                question2 = dao.geopgraphy.get(3);
                player1.sendMessage(question);
                player1.sendMessage(question2);
                player2.sendMessage(question);
                player2.sendMessage(question2);
            }
            categoryIndex++;
        }
        else if(((String)input).equals("Nöje")){
            if (categoryIndex == 0) {
                question = dao.pleasure.get(0);
                question2 = dao.pleasure.get(1);
                player1.sendMessage(question);
                player1.sendMessage(question2);
                player2.sendMessage(question);
                player2.sendMessage(question2);
            }//skickar frågan till player två också
            else if (categoryIndex == 1){
                question = dao.pleasure.get(2);
                question2 = dao.pleasure.get(3);
                player1.sendMessage(question);
                player1.sendMessage(question2);
                player2.sendMessage(question);
                player2.sendMessage(question2);
            }
            categoryIndex++;
        }
        else if(((String)input).equals("Sport")){
            if (categoryIndex == 0) {
                question = dao.sport.get(0);
                question2 = dao.sport.get(1);
                player1.sendMessage(question);
                player1.sendMessage(question2);
                player2.sendMessage(question);
                player2.sendMessage(question2);
            }//skickar frågan till player två också
            else if (categoryIndex == 1){
                question = dao.sport.get(2);
                question2 = dao.sport.get(3);
                player1.sendMessage(question);
                player1.sendMessage(question2);
                player2.sendMessage(question);
                player2.sendMessage(question2);
            }
            categoryIndex++;
        }
        else if(((String)input).equals("Matematik")){
            if (categoryIndex == 0) {
                question = dao.mathematics.get(0);
                question2 = dao.mathematics.get(1);
                player1.sendMessage(question);
                player1.sendMessage(question2);
                player2.sendMessage(question);
                player2.sendMessage(question2);
            }//skickar frågan till player två också
            else if (categoryIndex == 1){
                question = dao.mathematics.get(2);
                question2 = dao.mathematics.get(3);
                player1.sendMessage(question);
                player1.sendMessage(question2);
                player2.sendMessage(question);
                player2.sendMessage(question2);
            }
            categoryIndex++;
        }
        //kollar vilken spelare som skickade svaret.
        else if (((String)input).equals(question.getAnswer())){
            if(player == player1) {
                player1.sendMessage("Svaret är korrekt! " + input);
                player1.sendMessage("Change question");
                indexP1++;
                correctAnswer++;

                if (indexP1 == 2){
                    player1.sendMessage("Change to categorypanel");
                    player1.sendMessage("" + correctAnswer);
                }
                else if (indexP1 == 4){
                    player1.sendMessage("End of game");
                    player1.sendMessage("" + correctAnswer);

                }

            } else {
                player2.sendMessage("Svaret är korrekt! " + input);
                player2.sendMessage("Change question");
                indexP2++;
                correctAnswer++;

                if (indexP2 == 2){
                    player2.sendMessage("Change to categorypanel");
                    player2.sendMessage("" + correctAnswer);
                }
                else if (indexP2 == 4){
                    player2.sendMessage("End of game");
                    player2.sendMessage("" + correctAnswer);
                }
            }
        } else {
            if(player == player1) {
                player1.sendMessage("Svaret är fel! " + input);
                player1.sendMessage("Change question");
                indexP1++;

                if (indexP1 == 2){
                    player1.sendMessage("Change to categorypanel");
                }
                else if (indexP1 == 4){
                    player1.sendMessage("End of game");
                }
            } else {
                player2.sendMessage("Svaret är fel! " + input);
                player2.sendMessage("Change question");
                indexP2++;

                if (indexP2 == 2){
                    player2.sendMessage("Change to categorypanel");
                }
                else if (indexP2 == 4){
                    player2.sendMessage("End of game");
                }

            }
        }

    }

    public void setPlayer1(ClientHandler player1) {
        this.player1 = player1;
    }

    public void setPlayer2(ClientHandler player2) {
        this.player2 = player2;
    }
// add setReady metod för att skicka första medelandet när de är redo.
    public void setReady(ClientHandler player) {
        if(player == player1) {
            player1.sendMessage("Välj kategori");
        } else {
            player2.sendMessage("Avvakta medans player1 väljer kategori");
        }
    }
}