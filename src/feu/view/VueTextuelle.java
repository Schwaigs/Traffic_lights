package feu.view;

import java.awt.BorderLayout;
import javax.swing.JLabel; 
import javax.swing.SwingConstants;
import feu.controller.CtrlFeu;

public class VueTextuelle extends VueFeu {

    private static final long serialVersionUID = 1L;
    private JLabel lblFeu = new JLabel(); 


    public VueTextuelle(String titre, Integer id) {
        super(titre, id);
        //formate la fenetre pour un affichage textuel
        this.add(this.lblFeu,BorderLayout.CENTER);
        lblFeu.setHorizontalAlignment(SwingConstants.CENTER);
        //initialise la couleur du feu
        this.setCouleur();
    }

    @Override
    protected void setCouleur() {
        String label = "indefini";
        switch (CtrlFeu.getInstance().getFeu().getStatut()) {
        case 1:
                label = "vert";
                break;
        case 2:
                label = "orange";
                break;
        case 3:
                label = "rouge";
                break;
        case 4:
                label = "orange";
                break;
        }
        this.lblFeu.setText(label);
    }

}
