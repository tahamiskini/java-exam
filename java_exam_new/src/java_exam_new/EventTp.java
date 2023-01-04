package java_exam_new;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventTp implements ActionListener  {
    myForme  mf;
    connexion  cx;
    
    public EventTp(myForme  mf){
        this.mf =mf;
    }
    
     @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mf.B1){
            String driver = mf.ComBox.getSelectedItem().toString();
            String utilisateur = mf.T1.getText();
            String serveur = mf.T2.getText();
            String mdp = mf.T3.getText();
            cx = new connexion(driver,utilisateur,serveur,mdp);
            cx.afficher(mf.model);
            
        }
    
        else if ( e.getSource() == mf.B2){
            String nom = mf.T4.getText();
            String prenom = mf.T5.getText();
            cx.ajouter(nom, prenom);
            mf.model.addRow(new Object[]{mf.model.getColumnCount()+1,nom,prenom});
    			

        }
        else if ( e.getSource() == mf.B3){
            mf.T1.setText("");
            mf.T2.setText("");
            mf.T3.setText("");
            mf.T4.setText("");
            mf.T5.setText("");
        }
    }

}
