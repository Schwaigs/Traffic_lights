package feu.view;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import feu.controller.CtrlFeu;


/**
 * @author Laurent
 *
 */
public class VueGraphique extends VueFeu {
	
    private static final long serialVersionUID = 1L;
    private JPanel pFeu = new JPanel(); 


    public VueGraphique(String titre, Integer id) {
        super(titre,id);
        this.add(this.pFeu, BorderLayout.CENTER);
        //initialise la couleur du feu
        this.setCouleur();
    }

    @Override
    protected void setCouleur() {
        Color color = Color.GRAY;
        switch (CtrlFeu.getInstance().getFeu().getStatut()) {
        case 1:
                color = Color.GREEN;
                break;
        case 2:
                color = Color.ORANGE;
                break;
        case 3:
                color = Color.RED;
                break;
        case 4: 
                color = Color.ORANGE;
                break;
        }
        this.pFeu.setBackground(color);
    }

}

