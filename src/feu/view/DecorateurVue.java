package feu.view;

import java.beans.PropertyVetoException;

public abstract class DecorateurVue extends VueFeu {
    
    private static final long serialVersionUID = 1L;
    protected VueFeu vue;
    
    public DecorateurVue(VueFeu vFeu){
        super(vFeu.getTitle(),vFeu.getId());
        vue = vFeu;
    }
    
    @Override
    public void dispose(){
        try {
            this.setClosed(true);
        } catch (PropertyVetoException e) {
            System.out.println(e);
        }
        vue.dispose();
    }
    
}
