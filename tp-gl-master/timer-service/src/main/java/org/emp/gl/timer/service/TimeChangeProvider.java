package org.emp.gl.timer.service;

/**
 * Fournisseur de changements temporels.
 */
public interface TimeChangeProvider {

    void addTimeChangeListener(TimerChangeListener pl);

    void removeTimeChangeListener(TimerChangeListener pl);
}
