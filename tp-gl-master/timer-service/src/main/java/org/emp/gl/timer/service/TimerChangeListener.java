package org.emp.gl.timer.service;

import java.beans.PropertyChangeListener;

/**
 * Listener pour les changements du timer.
 * Hérite de PropertyChangeListener comme demandé.
 */
public interface TimerChangeListener extends PropertyChangeListener {
    String HEURE_PROP = "heure";
    String MINUTE_PROP = "minute";
    String SECONDE_PROP = "seconde";
    String DIXIEME_DE_SECONDE_PROP = "dixieme";
}
