package feu.controller;

import feu.model.Feu;

/**
 * @author Laurent
 *
 */
public class CtrlFeu {

    private ICyclesStrategie strat = new StratStras();
    private Feu feu;
    private static CtrlFeu ctrlFeu;

    private CtrlFeu() {
        this.feu = new Feu();
    }

    public Feu getFeu() {
        return this.feu;
    }

    public static CtrlFeu getInstance() {
        if (ctrlFeu == null)
            ctrlFeu = new CtrlFeu();
        return ctrlFeu;
    }

    public void arreter() {
        if (this.feu.isActif()) {
            this.feu.setActif(false);
            this.feu.setStatut(0);
        }
    }

    public void demarrer() {
        if (!this.feu.isActif()) {
            this.feu.setActif(true);
            this.feu.setStatut(3);
        }
    }

    //methode appelée lorsque l'on clique sur le boutton "changer" d'une vue 
    //Elle sert a changer la couleur du feu (roulement) et celui ci se fait en foncion de la strategie actuellement en place
    public void changerCouleur() {
        strat.changerCouleur(this.feu);
    }
    
     //methode appelée lorsque l'on change la localisation du feu depuis notre menu
    public void changerLoc(String ville) {
        ICyclesStrategie strategie = ctrlFeu.strat;
        //si le radioBoutton activé est Strasbourg on prend la strategie de strasbourg
        if (ville == "Strasbourg"){
            strategie = new StratStras();
            ctrlFeu.setCycleStrat(strategie);
        }
        //sinon c'est le radioButton de Kehl qui est activé
        else{
            strategie = new StratKehl();
            ctrlFeu.setCycleStrat(strategie);
        }
    }

    public void setCycleStrat(ICyclesStrategie strat) {
        this.strat = strat;
    }
    
    public Boolean estAStras(){
        if (strat.getClass() == StratStras.class){
            return  true;
        }
        return false;
    }

}

