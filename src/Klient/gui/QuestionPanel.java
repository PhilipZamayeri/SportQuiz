package Klient.gui;

import Server.PlayersData;
import Server.Question;
import Server.Score;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by Philip Zamayeri
 * Date: 2020-11-25
 * Time: 14:26
 * Project: SportQuiz
 * Copyright: MIT
 */
public class QuestionPanel extends JPanel {
    PlayersData playersData = new PlayersData();

    Font questionFont = new Font("Tahoma", Font.BOLD, 15);
    Font alternativesFont = new Font("Tahoma", Font.PLAIN, 25);

    JLabel userLabel=new JLabel();
    JLabel scoreLabel=new JLabel();
    JLabel userLabel1=new JLabel();
    JLabel scoreLabel1=new JLabel();

    JLabel label;
    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;

    JButton lastClickedButton;

    private ObjectOutputStream oos;

    public QuestionPanel(Question newQuestion) {
        setLayout(null);
        setBackground(new Color(127, 61, 61));


        label= new JLabel(newQuestion.getQuestion(), SwingConstants.CENTER);

        b1 = new JButton(newQuestion.getAlternatives().get(0));
        b2 = new JButton(newQuestion.getAlternatives().get(1));
        b3 = new JButton(newQuestion.getAlternatives().get(2));
        b4 = new JButton(newQuestion.getAlternatives().get(3));

        b1.addActionListener(new InternalAnswerListener());
        b2.addActionListener(new InternalAnswerListener());
        b3.addActionListener(new InternalAnswerListener());
        b4.addActionListener(new InternalAnswerListener());


        b1.setBounds(30, 200, 155, 50);
        b2.setBounds(215, 200, 155, 50);
        b3.setBounds(30, 250, 155, 50);
        b4.setBounds(215, 250, 155, 50);

        label.setBounds(10, 100, 400,50);
        label.setFont(questionFont);

        b1.setFont(alternativesFont);
        b2.setFont(alternativesFont);
        b3.setFont(alternativesFont);
        b4.setFont(alternativesFont);

        add(userLabel);
        add(scoreLabel);
        add(userLabel1);
        add(scoreLabel1);

        add(label);
        add(b1);
        add(b2);
        add(b3);
        add(b4);

        userLabel.setLocation(10, 25);
        userLabel.setSize(120, 80);
        userLabel.setVisible(true);

        scoreLabel.setText("Score: ");
        scoreLabel.setLocation(10, 45);
        scoreLabel.setSize(80, 80);
        scoreLabel.setVisible(true);

        userLabel1.setLocation(250, 25);
        userLabel1.setSize(120, 80);
        userLabel1.setVisible(true);

        scoreLabel1.setText("Score: ");
        scoreLabel1.setLocation(250, 45);
        scoreLabel1.setSize(80, 80);
        scoreLabel1.setVisible(true);

    }

    public void addQuestionToPanel(Question question) {
        label.setText(question.getQuestion());
        label.revalidate();
        label.repaint();
        userLabel.setText("Player 1: " + playersData.getRandomPlayer1().getName().toUpperCase());
        userLabel.setAlignmentX(SwingConstants.WEST);
        userLabel1.setText("Player 2: " + playersData.getRandomPlayer2().getName().toUpperCase());
        userLabel1.setAlignmentX(SwingConstants.EAST);

        b1.setText(question.getAlternatives().get(0));
        b2.setText(question.getAlternatives().get(1));
        b3.setText(question.getAlternatives().get(2));
        b4.setText(question.getAlternatives().get(3));
        System.out.println(question.getQuestion());
        validate();
    }

    public void setScoreLabel(Score score){
        System.out.println(score.getYourScore() + " " + score.getOpponentScore());
        scoreLabel.setText("Score: "+ score.getYourScore());
        scoreLabel1.setText("Score: "+ score.getOpponentScore());
    }

    public void setClickedButtonColor(Color color) {
        if(lastClickedButton != null) {
            lastClickedButton.setBackground(color);
            lastClickedButton.revalidate();
            lastClickedButton.repaint();
        }
    }

    public void setObjectOutputStream(ObjectOutputStream oos) {
        this.oos = oos;
    }

    public class InternalAnswerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() instanceof JButton) {
                JButton button = (JButton)e.getSource();
                lastClickedButton = button;
                System.out.println(button.getText());
                try {
                    if(oos != null)
                        oos.writeObject(button.getText());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
    }
}
