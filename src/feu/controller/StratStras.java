package feu.controller;

import feu.model.Feu;

public class StratStras implements ICyclesStrategie {
    
    public void changerCouleur(Feu feu) {
         if (feu.isActif()) {
            if (feu.getStatut() == 3) {
                feu.setStatut(1);
            } 
            //si on change la loc sur stras alors qu'on etait sur le 4e temps à kehl
            else if (feu.getStatut() == 4){
                feu.setStatut(2);
            }
            else {
                feu.setStatut(feu.getStatut() + 1);
            }
        }
    }
    
}
