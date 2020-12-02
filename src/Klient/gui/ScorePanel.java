package Klient.gui;

import Server.Score;

import javax.swing.*;
import java.awt.*;

public class ScorePanel extends JPanel {


        JLabel endScore1;
        JLabel endScore2;

        public ScorePanel() {

            endScore1 = new JLabel();
            endScore2 = new JLabel();

            setLayout(null);
            setBackground(new Color(127, 61, 61));

            endScore1.setBounds(30, 200, 155, 50);
            endScore2.setBounds(215, 200, 155, 50);

            add(endScore1);
            add(endScore2);

            setLocation(600, 90);
            setVisible(true);
            setSize(400, 500);

        }

        public void setScoreLabel(Score score){
            System.out.println(score.getYourScore() + " " + score.getOpponentScore());
            endScore1.setText("Score: "+ score.getYourScore());
            endScore2.setText("Score: "+ score.getOpponentScore());
        }

}
