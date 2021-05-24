package feu.view;

import java.util.ArrayList;

public class GestionnaireVue {
    
    /**
     * @attribute
     */
    private static Integer prochainIDVue = 1;
    private static GestionnaireVue instance;
    private ArrayList<VueFeu> vuesFeu = new ArrayList<>();
    
    private GestionnaireVue() {
    }
    
    public VueGraphique ajoutVueGraphique() {
        String titre = "Vue Graphique : n°";
        //on creer la nouvelle vue
        VueGraphique vg = new VueGraphique(titre,prochainIDVue);
        //on l'ajoute a notre collection de vue
        vuesFeu.add(vg);
        //on incremente le prochainID
        prochainIDVue +=1;
        return vg;
    }

    public VueTextuelle ajoutVueTextuelle() {
        String titre = "Vue texuelle : n°";
        //on creer la nouvelle vue
        VueTextuelle vt = new VueTextuelle(titre,prochainIDVue);
        //on l'ajoute a notre collection de vue
        vuesFeu.add(vt);
        //on incremente le prochainID
        prochainIDVue +=1;
        return vt;
    }


    public static GestionnaireVue getInstance() {
        if (instance == null)
            instance= new GestionnaireVue();
        return instance;
    }

    public Pieton changePieton(VueFeu vFeu){
        Pieton pF = new Pieton(vFeu);
        vuesFeu.remove(vFeu);
        vuesFeu.add(pF);
        return pF;
    }
    
    public TourneDroite changeTourneDroite(VueFeu vFeu){
        TourneDroite vTD = new TourneDroite(vFeu); 
        vuesFeu.remove(vFeu);
        vuesFeu.add(vTD);
        return vTD;
    }

    public ArrayList<VueFeu> getVuesFeu() {
        return vuesFeu;
    }

    public void setVuesFeu(ArrayList<VueFeu> vuesFeu) {
        this.vuesFeu = vuesFeu;
    }
}
