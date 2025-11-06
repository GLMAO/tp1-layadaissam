package org.emp.gl.clients;

import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;

import java.beans.PropertyChangeEvent;

public class CompteARebours implements TimerChangeListener {
    private final String nom;
    private int valeur;
    private final TimerService timer;
    private boolean actif = true;

    public CompteARebours(String nom, int debut, TimerService timer) {
        this.nom = nom;
        this.valeur = Math.max(0, debut);
        this.timer = timer;
        timer.addTimeChangeListener(this);
        afficher();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (!actif) return;
        if (!TimerChangeListener.SECONDE_PROP.equals(evt.getPropertyName())) return;

        valeur--;
        if (valeur <= 0) {
            valeur = 0;
            actif = false;
            timer.removeTimeChangeListener(this);
        }
        afficher();
    }

    private void afficher() {
        System.out.printf("Compteur %s : %02d%n", nom, valeur);
    }
}
