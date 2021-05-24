package feu.view;

import feu.controller.CtrlFeu;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;


public class TourneDroite extends DecorateurVue {
    
    private static final long serialVersionUID = 1L; 
    private JPanel pFeu = new JPanel(); 
    private Color color = Color.GRAY;
    private Timer timer;
    
    public TourneDroite(VueFeu vFeu){
        super(vFeu);
        this.add(pFeu, BorderLayout.CENTER);
        this.pFeu.setBackground(Color.GRAY);
        this.setTitle(vFeu.getId()+" Tourner à droite");
        timer = creerTimer();
        this.setCouleur();
    } 
    
    protected void setCouleur() {
        switch (CtrlFeu.getInstance().getFeu().getStatut()) {
                case 3: 
                        timer.start();
                        break;
                default: 
                        color = Color.GRAY;
                        timer.stop();
                        break;
                }
                pFeu.setBackground(color);

    }
    
    private Timer creerTimer(){
        ActionListener action = new ActionListener (){
            @Override
            public void actionPerformed (ActionEvent event){
             // Inversion de la couleur
                if (color == Color.ORANGE) {
                    color = Color.GRAY;
                }
                else{
                    color = Color.ORANGE; 
                }
                pFeu.setBackground(color);
            }
        };
        return new Timer(500,action);
            
    }
}
