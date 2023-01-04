package java_exam_new;

import javax.swing.JLabel;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
public class myForme extends JFrame{
    
    JLabel L1=new JLabel("Pilote");
    JLabel L2=new JLabel("Serveur");
    JLabel L3=new JLabel("Utilisateur");
    JLabel L4=new JLabel("Mot de passe");
    JLabel L5=new JLabel("Nom");
    JLabel L6=new JLabel("Prenom");
    JLabel Lvide = new JLabel("");
    JTextField T1 = new JTextField();
    JTextField T2= new JTextField();
    JTextField T3= new JTextField();
    JTextField T4= new JTextField();
    JTextField T5= new JTextField();
    
    JButton B1 = new JButton("Connexion");
    JButton B2 = new JButton("Ajouter");
    JButton B3 = new JButton("Supprimer");
    
    String liste []= {"com.mysql.cj.jdbc.Driver"};
    JComboBox ComBox = new JComboBox(liste);

    
    String entete[]={"Id","Nom","Prenom"};
    DefaultTableModel model= new DefaultTableModel(entete,0);
    JTable tab= new JTable(model);
    JScrollPane sp = new JScrollPane(tab);
    
    
    public myForme(){
        setTitle("Examen Java 4GL-GrC");
        setSize(1000,400);
        setLocationRelativeTo(getParent());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
       
      

       //JPanel North
       JPanel North = new JPanel(new GridLayout(5,2));
       North.add(L1);
       North.add(ComBox);
       North.add(L2);
       North.add(T1);
       North.add(L3);
       North.add(T2);
       North.add(L4);
       North.add(T3);
       North.add(Lvide);
       North.add(B1);
       TitledBorder title2 = BorderFactory.createTitledBorder("Parametres de Connexion");
       North.setBorder(title2);
       
       //JPanel center
       JPanel Center = new JPanel(new GridLayout(2,2));
       Center.add(L5);
       Center.add(T4);
       Center.add(L6);
       Center.add(T5);
       
       TitledBorder title3 = BorderFactory.createTitledBorder("Information Generales");
       Center.setBorder(title3);
        
       //JPanel south
        JPanel South = new JPanel();
        South.setLayout(new FlowLayout(FlowLayout.RIGHT));
        South.add(B2);
        South.add(B3);
        
        //JPanel Left
        JPanel Left = new JPanel(new BorderLayout());
        Left.add("North",North);
        Left.add("Center",Center);
        Left.add("South",South);
        
        JScrollPane sp = new JScrollPane(tab);
          
       JPanel Tableau = new JPanel(new FlowLayout());
       Tableau.add(sp);
       TitledBorder title4 = BorderFactory.createTitledBorder("Liste des etudiants");
       Tableau.setBorder(title4);
       
       
       //container
       Container Window=getContentPane();
       Window.setLayout(new GridLayout(1,2));
       Window.add(Left);
       Window.add(Tableau);
       
       setVisible(true);
       
      EventTp evt = new EventTp(this);
      B1.addActionListener(evt);
      B2.addActionListener(evt);
      B3.addActionListener(evt);

        
    }
     public static void main(String[] args) {
        // TODO code application logic here
        new myForme();
    }
    
    
}
