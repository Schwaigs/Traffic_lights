package feu.utils;

import java.util.ArrayList;

/**
 * @author Laurent
 *
 */
public class Observable {
    
    /**
     * @associates <{feu.utils.IObservateur}>
     */
    private ArrayList<IObservateur> mesObservateurs = new ArrayList<IObservateur>();

    public void ajouterObs(IObservateur obervateur) {
        mesObservateurs.add(obervateur);
    }

    public void supprimerObs(IObservateur observateur) {
        mesObservateurs.remove(observateur);
    }

    public void notifierObs() {
        for (IObservateur observateur : mesObservateurs) {
            observateur.miseAJour();
        }
    }
    
}
