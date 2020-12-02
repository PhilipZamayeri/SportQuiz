package Klient.gui;

import Server.Question;

import javax.swing.*;
import java.awt.*;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 * Created by Philip Zamayeri
 * Date: 2020-11-25
 * Time: 14:26
 * Project: SportQuiz
 * Copyright: MIT
 */
public class GameFrame extends JFrame {

    private QuestionPanel questionPanel;
    private NewGamePanel newGamePanel;
    private JPanel mainPanel = new JPanel(new BorderLayout());
    private CategoriePanel categoriePanel;
    private ScorePanel scorePanel;




    public GameFrame() {
        super("Quiz");
        questionPanel = new QuestionPanel(new Question("Q1", "Rätt", List.of("Fel", "Rätt", "Misstag", "Fel igen")));
        newGamePanel = new NewGamePanel(this);
        categoriePanel= new CategoriePanel();
        scorePanel = new ScorePanel();
        add(mainPanel);
        mainPanel.add(newGamePanel);
        scorePanel= new ScorePanel();


        mainPanel.setBackground(new Color(127, 61, 61));
        newGamePanel.setBackground(new Color(127, 61, 61));
        mainPanel.setSize(400,500);
        setLocation(600, 90);
        setVisible(true);
        setSize(400, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    public QuestionPanel getQuestionPanel() {
        return questionPanel;
    }

    public ScorePanel getScorePanel() {
        return scorePanel;
    }

    public void  changeToScorePanel(){
        System.out.println("Changing to scorepanel");
        mainPanel.removeAll();
        mainPanel.add(scorePanel);
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    public void changeToQuestionPanel() {
        System.out.println("Changing to QuestionPanel");
        mainPanel.removeAll();
        mainPanel.add(questionPanel);
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    public void changeToNewGamePanel() {
        System.out.println("Changing to NewGamePanel");
        mainPanel.removeAll();
        mainPanel.add(newGamePanel);
        mainPanel.revalidate();
        mainPanel.repaint();
    }
    public void changeToCatagoriesPanel(){
        System.out.println("Hi I am here CatagoriesPanel yeee....");
        mainPanel.removeAll();
        mainPanel.add(categoriePanel);
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    public void setObjectOutputStream(ObjectOutputStream oos) {
        questionPanel.setObjectOutputStream(oos);
        categoriePanel.setObjectOutputStream(oos);
    }

    public ScorePanel endGame() {
        System.out.println("Slut resultat:");
        mainPanel.removeAll();
        mainPanel.add(scorePanel);
        mainPanel.revalidate();
        mainPanel.repaint();
        return scorePanel;
    }
}
