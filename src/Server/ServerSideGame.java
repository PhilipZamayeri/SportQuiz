package Server;


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

    int indexP1 = 0;
    int indexP2 = 0;
    int categoryIndex = 0;
    int correctAnswerPlayer1 = 0;
    int correctAnswerPlayer2=0;


    DAO dao;
    Question question;
    Question question2;

    public ServerSideGame(DAO dao){
        this.dao = dao;
    }
     // clienthandler som parameter för att veta vilken spelare som har skickat objectet(input)
    public synchronized void game(Object input, ClientHandler player){

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
        else if (((String)input).equals(question.getAnswer()) || ((String)input).equals(question2.getAnswer())){
            if(player == player1) {
                player1.sendMessage("Svaret är korrekt! " + input);
                player1.sendMessage("Change question");
                indexP1++;
                correctAnswerPlayer1++;
            } else {
                player2.sendMessage("Svaret är korrekt! " + input);
                player2.sendMessage("Change question");
                indexP2++;
                correctAnswerPlayer2++;
            }
            if (indexP1 == 2 && indexP2 == 2){
                player1.sendMessage(new Score(correctAnswerPlayer1, correctAnswerPlayer2));
                player2.sendMessage("Change to categorypanel");
                player2.sendMessage(new Score(correctAnswerPlayer2,correctAnswerPlayer1));
            }
            else if (indexP1 == 4 && indexP2 == 4){
                player1.sendMessage(new Score(correctAnswerPlayer1, correctAnswerPlayer2));
                player1.sendMessage("End of game");
                player2.sendMessage(new Score(correctAnswerPlayer2, correctAnswerPlayer1));
                player2.sendMessage("End of game");
            }
        } else {
            if(player == player1) {
                player1.sendMessage("Svaret är fel! " + input);
                player1.sendMessage("Change question");
                indexP1++;

            } else {
                player2.sendMessage("Svaret är fel! " + input);
                player2.sendMessage("Change question");
                indexP2++;
            }
            if (indexP1 == 2 && indexP2 == 2){
                player1.sendMessage(new Score(correctAnswerPlayer1, correctAnswerPlayer2));
                player2.sendMessage("Change to categorypanel");
                player2.sendMessage(new Score(correctAnswerPlayer2,correctAnswerPlayer1));
            }
            else if (indexP1 == 4 && indexP2 == 4){
                player1.sendMessage(new Score(correctAnswerPlayer1, correctAnswerPlayer2));
                player1.sendMessage("End of game");
                player2.sendMessage(new Score(correctAnswerPlayer2, correctAnswerPlayer1));
                player2.sendMessage("End of game");
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