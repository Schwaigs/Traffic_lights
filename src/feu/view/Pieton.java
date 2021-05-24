package feu.view;

import feu.controller.CtrlFeu;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;

public class Pieton extends DecorateurVue {
    
    private static final long serialVersionUID = 1L;
    private JPanel pFeu = new JPanel(); 
    
    public Pieton(VueFeu vFeu){
        super(vFeu);
        this.add(pFeu, BorderLayout.CENTER);
        this.setTitle(vFeu.getId()+" Pieton");
        this.setCouleur();
    }
    
    protected void setCouleur() {
        Color color = Color.GRAY;
        if (CtrlFeu.getInstance().estAStras()){
            switch (CtrlFeu.getInstance().getFeu().getStatut()) {
		case 1:
			color = Color.RED;
			break;
		case 2:
			color = Color.RED;
			break;
		case 3:
			color = Color.GREEN;
			break;
                case 4: 
                        color = Color.RED;
                        break;
		}
		this.pFeu.setBackground(color);
        }
        else{
            color = Color.GRAY;
            this.pFeu.setBackground(color);
        }
    }

}
