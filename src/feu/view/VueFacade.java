package feu.view;

import feu.controller.CtrlFeu;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;


public class VueFacade extends JFrame{
 
    private CtrlFeu ctrlFeu = CtrlFeu.getInstance();
    private GestionnaireVue gVue = GestionnaireVue.getInstance();
    private static final long serialVersionUID = 1L;
    private JDesktopPane jDP = new JDesktopPane();
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menuVues = new JMenu ("Vues");


    public VueFacade() {
	 // initialisation de fenetre principale
        this.setSize(1000, 1000);
        this.setTitle("Fenetre principale");
        this.setContentPane(jDP);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Mise en place du conteneur de sous-fenêtres
        jDP.setBackground(Color.black);
        jDP.setLayout(new GridLayout(4,4));
                
        // Construction de la barre de menu
        menuBar.add(menuVues);
        
        //localisation du feu tricolore
        JMenu menuLoc = new JMenu ("Localisation");
        JRadioButtonMenuItem rdbStras = new JRadioButtonMenuItem("Strasbourg");
        rdbStras.addActionListener(e->ctrlFeu.changerLoc(rdbStras.getLabel()));
        JRadioButtonMenuItem rdbKehl = new JRadioButtonMenuItem("Kehl");
        rdbKehl.addActionListener(e->ctrlFeu.changerLoc(rdbKehl.getLabel()));
        ButtonGroup bg = new ButtonGroup();
        bg.add(rdbStras);
        bg.add(rdbKehl);
        //La loc par defaut est strasbourg
        rdbStras.setSelected(true);
        menuLoc.add(rdbStras);
        menuLoc.add(rdbKehl);
        menuBar.add(menuLoc);
        
        //mise en place du conteneur des boutons
        JPanel pBoutons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        menuBar.add(pBoutons);
        
        //mise en place du bouton pour ajouter une nouvelle vue textuelle
        JButton bTextuelle = new JButton("Nouvelle vue textuelle");
        pBoutons.add(bTextuelle);
        bTextuelle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ajouterVueTextuelle();
                }
        });
        
        //mise en place du bouton pour ajouter une nouvelle vue graphique
        JButton bGraphique = new JButton("Nouvelle vue graphique");
        pBoutons.add(bGraphique);
        bGraphique.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ajouterVueGraphique();
            }
        });    
        this.setJMenuBar(menuBar);
        this.setVisible(true);

    }

    public void ajouterVueTextuelle() {
        VueTextuelle vt = gVue.ajoutVueTextuelle();
        //on l'ajoute à la fenetre 
        jDP.add(vt);
        vt.setVisible(true);
        majMenuVues();
    }


    private void ajouterVueGraphique() {
        VueGraphique vg = gVue.ajoutVueGraphique();
        jDP.add(vg);
        vg.setVisible(true);
        majMenuVues();
    }
    
    public void majMenuVues(){
        menuVues.removeAll();
        for(VueFeu vf:gVue.getVuesFeu()){
            JMenu vueItem = new JMenu(vf.getTitle());
            
            JMenuItem vueItemSuppr = new JMenuItem("Supprimer la vue");
            vueItem.add(vueItemSuppr);
            vueItemSuppr.addActionListener(e->suppVue(vf));
            
            JMenuItem vueItemPieton = new JMenuItem("Passer en feu pieton");
            vueItem.add(vueItemPieton);
            vueItemPieton.addActionListener(e->ajoutPieton(vf));
            
            JMenuItem vueItemTourneDroite = new JMenuItem("Passer en feu tourner à droite");
            vueItem.add(vueItemTourneDroite);
            vueItemTourneDroite.addActionListener(e->ajoutTD(vf));
            
            menuVues.add(vueItem);
        }
    }
    
    public void ajoutPieton(VueFeu vF){
        Pieton vP = gVue.changePieton(vF);
        jDP.add(vP);
        vP.setVisible(true);
        majMenuVues();
    }
    
    public void ajoutTD(VueFeu vF){
        VueFeu vTD = gVue.changeTourneDroite(vF);
        jDP.add(vTD);
        vTD.setVisible(true);
        majMenuVues();
    }

    public void suppVue(VueFeu vF){
        vF.dispose();
        ArrayList <VueFeu> arrayVues = new ArrayList<>(gVue.getVuesFeu());
        arrayVues.remove(vF);
        gVue.setVuesFeu(arrayVues);
        majMenuVues();
    }
}

