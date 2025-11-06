package org.emp.gl.core.launcher;

import org.emp.gl.clients.CompteARebours;
import org.emp.gl.clients.Horloge;
import org.emp.gl.time.service.impl.DummyTimeServiceImpl;
import org.emp.gl.timer.service.TimerService;

import javax.swing.*;

public class App {
    public static void main(String[] args) throws InterruptedException {
        // Création du service temps
        TimerService timer = new DummyTimeServiceImpl();

        // Lancement des horloges et du compteur texte (console)
        new Horloge("H1", timer);
        new Horloge("H2", timer);
        new CompteARebours("CR1", 5, timer);

        // Lancement de l’interface graphique BONUS
        SwingUtilities.invokeLater(() -> {
            new HorlogeGUI(); // Fenêtre graphique affichant l’heure
        });

        // Empêche la terminaison du programme
        Thread.sleep(Long.MAX_VALUE);
    }
}
