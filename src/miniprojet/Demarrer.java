package miniprojet;
import java.io.*;
import java.util.*;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Demarrer extends JFrame implements ActionListener{
		static HashMap<String,String> LoginPass = new HashMap<String,String>();
         JTextField Login = new JTextField();
         static JPasswordField PassWord = new JPasswordField();
         JButton login = new JButton("login");
         JButton inscription = new JButton("S'inscrire");
         GridBagLayout gestion = new GridBagLayout();
         static JLabel lbLogin = new JLabel("Login : ");
         JLabel lbPassWord = new JLabel("Password : ");
         JLabel lab=new JLabel(" ");
         static  String nomutilisateur;
         String[] tab={null,null};
         public Demarrer(){
                super("Login");
                this.setLayout(gestion);
                GridBagConstraints gest = new GridBagConstraints();
                gest.fill = GridBagConstraints.BOTH;
                gest.gridx = 0;
                gest.gridy = 0;
                gest.weightx = 1;
                gest.weighty = 1;
                gest.gridwidth = 1;
                gest.gridheight = 1;
                gest.insets = new Insets(0,10,2,0);
                
                gestion.setConstraints(this.lbLogin, gest);
                this.add(this.lbLogin);

                gest.insets = new Insets(5,0,2,10);
                gest.gridx = 1;
                gest.weightx = 5;
                gestion.setConstraints(this.Login, gest);
                this.add(this.Login);

                gest.insets = new Insets(0,10,2,0);
                gest.gridx =0;
                gest.gridy = 1;
                gest.weightx = 1;
                gestion.setConstraints(this.lbPassWord, gest);
                this.add(this.lbPassWord);
                

                gest.insets = new Insets(0,0,2,10);
                gest.gridx =1;
                gest.weightx = 5;
                gestion.setConstraints(this.PassWord, gest);
                this.add(this.PassWord);
                
                gest.gridx =0;
                gest.gridy = 2;
                gest.gridwidth =2;
                gest.weightx = 1;
                gest.insets = new Insets(10,50,5,50);
                this.add(this.login);
                this.login.addActionListener(this);
                gestion.setConstraints(this.login, gest);
               

                gest.gridx =0;
                gest.gridy = 3;
                gest.gridwidth =3;
                gest.weightx = 1;
                gest.insets = new Insets(5,50,5,50);
                gestion.setConstraints(this.inscription, gest);
                this.add(this.inscription);
                this.inscription.addActionListener(this);
                
                gest.insets = new Insets(5,50,10,30);
                gest.gridx =0;
                gest.gridy = 1;
                gest.weightx = 1;
                gestion.setConstraints(this.lab, gest);
                
                this.add(this.lab);
                this.setResizable(false);
                this.setSize(500, 300);
                this.setVisible(true);
               
        }
        
        public void actionPerformed(ActionEvent e){
        	JButton clic=(JButton) e.getSource();
        	
        	if(clic==inscription)
        	{ 	dispose();
                Inscription fenetre2;
				try {
				fenetre2 = new Inscription(this, "Création membre");
                fenetre2.setLocationRelativeTo(this);
                fenetre2.setVisible(true);
                } catch (IOException e1) {
					
					e1.printStackTrace();
				}}
        	
        	else if (clic==login){
        		LoginPass = new HashMap<String,String>();
        		String pass = new String(this.PassWord.getPassword());
        		String login = this.Login.getText().trim();
        		try{	
        		Scanner scanner = new Scanner(new FileReader("fichier1.txt"));
        		String mot = null;
        		while (scanner.hasNext()){
        		for(int i=0;i<2;i++){scanner.next();
        		mot = scanner.next();
        		tab[i]=mot;
          	    
          	    }
        		scanner.next();
        		scanner.next();
        		LoginPass.put(tab[0], tab[1]);
        		
        	}scanner.close();
        	nomutilisateur=Login.getText();
            if(!LoginPass.containsKey(login) && donneesValides())
             {
             JOptionPane.showMessageDialog(null," : ce membre n'existe pas", "Erreur",JOptionPane.ERROR_MESSAGE);
             return;
     } 
             if(!LoginPass.containsValue(pass) && pass.length() != 0
            		){JOptionPane.showMessageDialog(null," : mot de passe incorrect", "Erreur",
             JOptionPane.ERROR_MESSAGE);
            		return;}
             if(LoginPass.containsKey(login) && donneesValides()){
             if(LoginPass.containsValue(pass)){
             
             int g=0;
             int h=0;
            Scanner scanner1 = new Scanner(new FileReader("fichier1.txt"));
     		while (scanner1.hasNext()){scanner1.next();String s=scanner1.next();
     		if(login.length()==s.length()){
     		for(int i=0;i<login.length();i++){
     			if (login.charAt(i)==s.charAt(i)){g++;}}}
     		
     			scanner1.next();
     			
     			String mdp=scanner1.next();
     			if(pass.length()==mdp.length()){
     				for(int i=0;i<mdp.length();i++){
     			if(pass.charAt(i)==mdp.charAt(i)){h++;}}}
     			if(g==login.length() && h==pass.length()){
     				Accueil.Score=Integer.parseInt(scanner1.next());
     				break;
     			}
     			else{ h=0;g=0;scanner1.next();
 				scanner1.next();}
     				
     			}
     				
     			}
     	this.dispose(); new Utilisateur();	}
             
             
            	}
        	
        		
       	catch (IOException o){
       		System.out.println(o.toString());

       }}
        	
     }  boolean erreur(String message) {
	        JOptionPane.showMessageDialog(this, message, "Erreur",
	                JOptionPane.ERROR_MESSAGE);
	        return false;
	    }
     boolean donneesValides() {
         if (Login.getText().length() == 0)
             return erreur("Il faut saisir le login");

         String s = new String(this.PassWord.getPassword());
         if (s.length() == 0)
             return erreur("Il faut saisir le mdp");
                return true;
     }
         
           
  
 }
	
 
