package org.emp.gl.timer.service;

/**
 * Abstraction du service de temps.
 */
public interface TimerService extends TimeChangeProvider {

    int getMinutes();

    int getHeures();

    int getSecondes();

    int getDixiemeDeSeconde();
}
