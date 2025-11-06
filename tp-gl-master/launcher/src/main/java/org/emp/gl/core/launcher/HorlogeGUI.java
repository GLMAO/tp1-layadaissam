package org.emp.gl.core.launcher;

import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

public class HorlogeGUI extends JFrame {

    private JLabel labelHeure;

    public HorlogeGUI() {
        setTitle("Horloge Graphique");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Création du texte
        labelHeure = new JLabel();
        labelHeure.setFont(new Font("Consolas", Font.BOLD, 36));
        labelHeure.setHorizontalAlignment(SwingConstants.CENTER);

        add(labelHeure);
        setVisible(true);

        // Timer pour mettre à jour chaque seconde
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                LocalTime heureActuelle = LocalTime.now();
                String heureStr = heureActuelle.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
                SwingUtilities.invokeLater(() -> labelHeure.setText(heureStr));
            }
        }, 0, 1000);
    }
}
