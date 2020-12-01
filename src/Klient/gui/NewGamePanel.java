package Klient.gui;

import Klient.ClientGame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Philip Zamayeri
 * Date: 2020-11-25
 * Time: 14:26
 * Project: SportQuiz
 * Copyright: MIT
 */
public class NewGamePanel extends JPanel {
    JPanel mainPanel = new JPanel();
    JButton newSpel = new JButton("Nytt spel");

    public NewGamePanel(GameFrame gameFrame) {
        setLayout(null);
        add(mainPanel);
        setBackground(new Color(127, 61, 61));

        newSpel.setBounds(50, 150, 300, 50);

        newSpel.setBackground(new Color(127, 61, 61));

        newSpel.setOpaque(true);

        setVisible(true);
        setSize(400, 500);
        gameFrame.setLocationRelativeTo(null);

        newSpel.addActionListener(e -> {
            ClientGame clientGame = new ClientGame(gameFrame);
            Thread thread = new Thread(clientGame);
            thread.start();
        });
        add(newSpel);

    }

}
