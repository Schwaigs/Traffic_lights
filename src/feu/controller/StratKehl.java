package feu.controller;

import feu.model.Feu;

public class StratKehl implements ICyclesStrategie {
    
    public void changerCouleur(Feu feu) {
        if (feu.isActif()) {
           if (feu.getStatut() == 4) {
               feu.setStatut(1);
           } else {
               feu.setStatut(feu.getStatut() + 1);
           }
        }
    }
    
}
