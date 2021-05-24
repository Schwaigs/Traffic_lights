package feu.model;

import feu.utils.Observable;

/**
 * @author Laurent
 *
 */
public class Feu extends Observable {
    
    /**
     * @attribute
     */
    private Boolean actif = false;

    /**
     * @attribute
     */
    private Integer statut = 0;

    public Feu() {
    }

    public String toString() {
        return this.isActif() + " - " + this.getStatut();
    }

    public boolean isActif() {
        return this.actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
        this.notifierObs();
    }

    public int getStatut() {
        return this.statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
        this.notifierObs();
    }
}
