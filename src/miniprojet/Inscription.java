package miniprojet;
import java.util.*;
import java.io.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import java.awt.Dimension;

import javax.swing.JPasswordField;

import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;

import javax.swing.JProgressBar;

public class Inscription extends JDialog {String s = "";

    public Inscription(JFrame cadre, String titre) throws IOException {
        super(cadre, titre, true);
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\utilisateur\\Pictures\\a1c.jpg"));
        setTitle("Inscription");
        setPreferredSize(new Dimension(500, 400));
        setSize(new Dimension(9, 4));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setContentPane(panneauDeContenu());
        pack();
    }

static JTextField champNom, champPrenom;
     JRadioButton boutonHomme, boutonFemme;
     boolean bonneFin = false;
     static JPasswordField passwordField;
  

    public JPanel panneauDeContenu() throws IOException {
        JPanel panneau = new JPanel();
        panneau.setLayout(new BorderLayout());
        JPanel grandCentre = new JPanel();
        grandCentre.setSize(new Dimension(9, 7));
        JPanel grandSud = new JPanel();
        panneau.add(grandCentre, BorderLayout.CENTER);
        panneau.add(grandSud, BorderLayout.SOUTH);

        grandCentre.setLayout(new BorderLayout());
        JPanel petitNord = new JPanel();
        petitNord.setPreferredSize(new Dimension(250, 250));
        JPanel petitCentre = new JPanel();
        JPanel petitSud = new JPanel();
        grandCentre.add(petitNord, BorderLayout.NORTH);
        grandCentre.add(petitCentre, BorderLayout.CENTER);
        grandCentre.add(petitSud, BorderLayout.SOUTH);

        petitNord.setLayout(new GridLayout(0, 1));
        petitNord.add(new JLabel("Nom"));
        champNom = new JTextField();
        champNom.setPreferredSize(new Dimension(20, 20));
        petitNord.add(champNom);
        petitNord.add(new JLabel("Prénom"));
        champPrenom = new JTextField();
        champPrenom.setPreferredSize(new Dimension(20, 20));
        petitNord.add(champPrenom);
        petitNord.add(new JLabel("Password"));
        
        passwordField = new JPasswordField();
        petitNord.add(passwordField);
        passwordField.setPreferredSize(new Dimension(10, 20));

        petitCentre.setLayout(new BorderLayout());

        petitSud.setLayout(new FlowLayout());
        petitSud.add(new JLabel("Sexe"));
        ButtonGroup groupe = new ButtonGroup(); 
        boutonHomme = new JRadioButton("Homme");
        groupe.add(boutonHomme);
        petitSud.add(boutonHomme);
        boutonHomme.setSelected(true);
        boutonFemme = new JRadioButton("Femme");
        groupe.add(boutonFemme);
        petitSud.add(boutonFemme);

        grandSud.setLayout(new FlowLayout());
        JButton bouton1 = new JButton("inscription");
        Scanner scanner = new Scanner(new FileReader("fichier1.txt"));
    	String[] tab=new String[2];
    	while (scanner.hasNext()){
    	
		for(int i=0;i<2;i++){scanner.next();
    	String mot = scanner.next(); 
    	tab[i]=mot;
    	    
    	    }
    	scanner.next();
    	scanner.next();
    	Demarrer.LoginPass.put(tab[0], tab[1]);
    	}
        bouton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	
                actionBoutonAccepter();//new Utilisateur();
            }
        });
        grandSud.add(bouton1);
        JButton bouton2 = new JButton("Annuler");
        bouton2.setPreferredSize(new Dimension(81, 32));
        bouton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                actionBoutonAnnuler();
            }
        });
        grandSud.add(bouton2);
        bouton1.setPreferredSize(new Dimension(81, 32));
      
        if (true) {
            panneau.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
            grandCentre.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createBevelBorder(BevelBorder.LOWERED),
                    BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        }

        return panneau;
    }

    boolean erreur(String message) {
        JOptionPane.showMessageDialog(this, message, "Erreur",
                JOptionPane.ERROR_MESSAGE);
        return false;
    }
    

    boolean donneesValides() {
    	if (Demarrer.LoginPass.containsKey(champNom.getText())) {
            return erreur( " login est déjà utilisé ");
    	}
        if (champNom.getText().length() == 0)
            return erreur("Il faut saisir le nom");

        if (champPrenom.getText().length() == 0)
            return erreur("Il faut saisir le prénom");

        String s = new String(passwordField.getPassword());
        if (s.length() == 0)
            return erreur("Il faut saisir le mdp");
             
        return true;
    }

  void actionBoutonAccepter() {
        
	  if (donneesValides()) {
		  try { 
              
      		
          	s += champPrenom.getText() + " " + champNom.getText()
                      + (boutonHomme.isSelected() ? " (homme)" : " (femme)") + " "
                      + new String(passwordField.getPassword()) + " "
                      + Accueil.Score+ " "
                      + "------------------------------------------------\n"+" ";
          	
          	BufferedReader lec=new BufferedReader(new FileReader("fichier1.txt"));
             
          	String ligne; String Chaine=" ";
          	
          	while((ligne=lec.readLine())!=null){
          		Chaine+=ligne+"\n";
          		
          	}
            
              lec.close();
              PrintWriter readme=new PrintWriter(new FileOutputStream("fichier1.txt"));
              readme.println(s);
              readme.println(Chaine);
              readme.close();
              
              } catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
              } 
     	
          dispose();
	new Utilisateur();}
            
            
        
    }

     void actionBoutonAnnuler() {
        dispose();
    }

    
}