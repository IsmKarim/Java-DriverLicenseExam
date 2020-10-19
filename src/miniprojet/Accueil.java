package miniprojet;
import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
public class Accueil extends JFrame implements ActionListener{
		static int rand[];
		static int ordre=-1;
		static int Score =0;
		static int nombrealeatoire ;
		static int cas;
	 	JButton Button1;
	    JButton Button2;
	    JButton Button3;
	    JButton Button4;
	    JLabel Label1;
	    
	     
	    
   Accueil() {
        Label1 = new JLabel();
        Button1  = new JButton();
        Button2 = new JButton();
        Button3 = new JButton();
        Button4 = new JButton();
        
        

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//pour controler la fermeture de la fenetre
        getContentPane().setLayout(null); //absolute positioning

        Label1.setIcon(new ImageIcon(("permis.jpg"))); // inserer une image dans Jlabel avec setIcon
        getContentPane().add(Label1); // " Positionner des boutons"
        Label1.setBounds(0, 0, 800, 460);// specifier la taille du label (la photo)

        Button1.setText("Démarrer");
        getContentPane().add(Button1);
        Button1.setBounds(130, 300, 110, 70); // SET BOUNDS /: method not only specifies the size of the frame, but the location of the upper left corner

        Button2.setText("Tester");
        getContentPane().add(Button2);
        Button2.setBounds(290, 312, 73, 60);

        Button3.setText("Apropos");
        getContentPane().add(Button3);
        Button3.setBounds(430, 313, 73, 60);

        Button4.setText("Quitter");
        getContentPane().add(Button4);
        Button4.setBounds(570, 303, 110, 70);
        
        Button1.addActionListener(this); //Interagir avec son bouton
        Button3.addActionListener(this); // We would like to handle the button-click event, so we add an action listener to the button
        Button2.addActionListener(this);
        Button4.addActionListener(this);
        
       
        this.setTitle("Acceuil");
        this.setVisible(true);
        
     
    }

  
    public static void main(String args[]) { 
    	
        try {// Pour changer le look
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) { //Nimbus is a polished cross-platform look and feel introduced in the Java SE 6 Update 10 (6u10) release
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        // générer des nombres aleatoires 
		boolean bo=false;
		if(Admin.nombreQu==null){ 
		  Admin.nombreQu="27";}
		rand=new int[Integer.parseInt(Admin.nombreQu)];
		nombrealeatoire=(int)((Math.random()*Integer.parseInt(Admin.nombreQu))); //convertir ce nombre en un entier avec un cast
        //on peut tiré des nombres par hasard compris entre 1 et 28 (avec la fonction random)
		rand[0]=nombrealeatoire;
		for(int d1=0;d1<Integer.parseInt(Admin.nombreQu);d1++)
		{
			nombrealeatoire=(int)(Math.random()*Integer.parseInt(Admin.nombreQu));
			for(int c=0;c<d1 && bo== false;c++)
			{
			if(rand[c]==nombrealeatoire)
					{d1--; bo=true;
						}
			else
			rand[d1]=nombrealeatoire;
				}
			bo=false;
				}
         new Accueil().setSize(810, 490);
       
        }
    public void actionPerformed(ActionEvent e) // solve the problem is that an actionPerformed message is sent to all action listeners that are registered on the relevant component.
	{JButton clic=(JButton)e.getSource(); //pour connaître le nom de l'instance qui a généré l'événement
	
		 
	if(clic==Button1){ dispose(); //fermeture de la fenetre
		 new Demarrer();}
		
	else if(clic==Button4)
	{
		 new Quitter().setTitle("Quitter");
	}
	else if(clic==Button3)
	{cas=1; dispose();
	new Quitter();
	}
	else if(clic==Button2){
		new Utilisateur(); 
		Demarrer.nomutilisateur="test";
		ordre=14;
		new Qcm2(ordre);
		
	}
	} 
     
   
    
}
