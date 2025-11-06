package org.emp.gl.clients;

import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;

import java.beans.PropertyChangeEvent;

public class Horloge implements TimerChangeListener {
    private final String nom;
    private int h, m, s, ds;

    public Horloge(String nom, TimerService timer) {
        this.nom = nom;
        timer.addTimeChangeListener(this);
        h = timer.getHeures();
        m = timer.getMinutes();
        s = timer.getSecondes();
        ds = timer.getDixiemeDeSeconde();
        afficher();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String prop = evt.getPropertyName();
        if (TimerChangeListener.HEURE_PROP.equals(prop)) {
            h = (Integer) evt.getNewValue();
        } else if (TimerChangeListener.MINUTE_PROP.equals(prop)) {
            m = (Integer) evt.getNewValue();
        } else if (TimerChangeListener.SECONDE_PROP.equals(prop)) {
            s = (Integer) evt.getNewValue();
        }
        // On ne met pas à jour à chaque dixième pour éviter trop de lignes
        if (TimerChangeListener.SECONDE_PROP.equals(prop)) {
            afficher();
        }
    }

    private void afficher() {
        System.out.printf("Numéro %s : Horloge -> %02d:%02d:%02d%n", nom, h, m, s);
    }
}
