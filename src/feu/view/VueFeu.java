package feu.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import javax.swing.JButton;
import javax.swing.JPanel; 
import javax.swing.JInternalFrame;
import feu.controller.CtrlFeu;
import feu.utils.IObservateur;


public abstract class VueFeu extends JInternalFrame implements IObservateur {
    
    private static final long serialVersionUID = 1L;
    private JButton bOnOff = new JButton();
    private Integer id;

    public VueFeu(String titre, Integer id) { 
        // initialisation du feu
        CtrlFeu.getInstance().getFeu().ajouterObs(this);
        this.id = id;
        this.setTitle(titre+id.toString());
        this.setSize(200, 200);
        this.setLocation(30, 30);
        this.toFront();
        
        // ajout du conteneur de boutons au bas de notre vue
        JPanel pBoutons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        this.add(pBoutons, BorderLayout.SOUTH);
        pBoutons.add(bOnOff);
        this.bOnOffChangerLabel();
        bOnOff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                arreterDemarrer();
                bOnOffChangerLabel();
            }
        });
        JButton bEtat = new JButton("Changer");
        pBoutons.add(bEtat);
        bEtat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changerCouleur();
            }
        });  
    }

    private void bOnOffChangerLabel() { 
        bOnOff.setText(CtrlFeu.getInstance().getFeu().isActif() ? "Arreter" : "Demarrer");
    }

    protected abstract void setCouleur();

    private void arreterDemarrer() {
        CtrlFeu ctrlFeu = CtrlFeu.getInstance();
        if (ctrlFeu.getFeu().isActif())
            ctrlFeu.arreter();
        else
            ctrlFeu.demarrer();
    }

    //methode appelée lorsque l'on clique sur le boutton "changer" d'une vue 
    //Elle sert à changer la couleur du feu (roulement)
    private void changerCouleur() {
        CtrlFeu.getInstance().changerCouleur();
    }

    @Override
    public void miseAJour() {
        this.setCouleur();
    }
    
    //methode appelée lorsque l'on change la localisation du feu depuis notre menu
    public void changerLoc(String ville) {
        CtrlFeu ctrlFeu = CtrlFeu.getInstance();
        ctrlFeu.changerLoc(ville);
    }

    public Integer getId() {
        return id;
    }
}

