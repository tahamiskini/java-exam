package java_exam_new;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;


public class connexion {
    Connection conn;
    Statement st;

      public connexion(String driver ,String serveur ,String utilisateur ,String mdp ){
          try{
        Class.forName(driver);
    }
    
    catch(ClassNotFoundException e)
    {System.out.println("erreur de chargement de Driver");}
     
     
     try {
            conn= DriverManager.getConnection(serveur,utilisateur , mdp);
        } 
    catch (SQLException ex) {
           {System.out.println(ex);}
        } 
    
}
    void ajouter (String nom, String prenom){
         try {
             st=conn.createStatement();
         }
         catch(SQLException e){
             System.out.println("erreur de creation de statement");
         }
        
         
         try {
             st.executeUpdate("insert into exam (nom,prenom) values('"+nom+"','"+prenom+"')");
         }
         catch (SQLException e){System.out.println("erreur d'execution de statement");}
     }
    
     void afficher (DefaultTableModel model){
         
         try {
             model.setRowCount(0);
             st=conn.createStatement();
             ResultSet res= st.executeQuery("Select * from exam ");
             while (res.next()){
                Object ligne[]=new Object[model.getColumnCount()];
                for(int i=0;i<ligne.length;i++){
    		    ligne[i]=res.getString(i+1);
    		}
    	        model.addRow(ligne);
                        
    	    }
             
            
         }
         catch(SQLException e){
             System.out.println("erreur de creation de statement");
             
         }
   
}    
}
