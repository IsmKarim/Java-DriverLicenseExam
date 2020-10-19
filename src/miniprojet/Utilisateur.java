package miniprojet;
import javax.swing.*;

import org.omg.CORBA.portable.ValueOutputStream;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
public class Utilisateur extends JFrame implements ActionListener {
	JButton bouton1 =new JButton("Commencer"); 
	JButton bouton2 =new JButton("Quitter");
	JButton bouton3 =new JButton("votre Score");
	int compteur=0;
	JPanel p2= new JPanel();
	static JTextArea zoneDeTexte;
Utilisateur(){
	try{
		if(Demarrer.nomutilisateur==null ){
	Demarrer.nomutilisateur=Inscription.champNom.getText();
}	
else{
	
if(Demarrer.nomutilisateur.length()==5 && Demarrer.PassWord.getPassword().length==5){
	for(int i=0;i<Demarrer.nomutilisateur.length();i++){
		if(Demarrer.nomutilisateur.charAt(i)=="Admin".charAt(i) && new String(//login et mot de passe de l'admin
    			Demarrer.PassWord.getPassword()).charAt(i)=="info5".charAt(i)){compteur++;}; }
}} 

		
	GridBagLayout gridBagLayout = new GridBagLayout(); 
	gridBagLayout.columnWidths = new int[]{484, 0};
	gridBagLayout.rowHeights = new int[]{212, 50, 0};
	gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
	gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
	getContentPane().setLayout(gridBagLayout);
    
    
    zoneDeTexte = new JTextArea();
    GridBagConstraints gbc_zoneDeTexte = new GridBagConstraints();
    gbc_zoneDeTexte.insets = new Insets(0, 0, 5, 0);
    gbc_zoneDeTexte.gridx = 0;
    gbc_zoneDeTexte.gridy = 0;
    getContentPane().add(zoneDeTexte, gbc_zoneDeTexte);
    zoneDeTexte.setFont(new Font("Monospaced", Font.PLAIN, 12));
    zoneDeTexte.setPreferredSize(new Dimension(400, 400));
    zoneDeTexte.setText("Bonjour"+" "+Demarrer.nomutilisateur);
    p2.setForeground(Color.GRAY);
    GridBagConstraints gbc_p2 = new GridBagConstraints();
    gbc_p2.anchor = GridBagConstraints.NORTH;
    gbc_p2.fill = GridBagConstraints.HORIZONTAL;
    gbc_p2.gridx = 0;
    gbc_p2.gridy = 1;
    getContentPane().add(p2, gbc_p2);
    p2.add(bouton1);
    p2.add(bouton2);
    bouton2.addActionListener(this);
    p2.add(bouton3);
    
    bouton1.addActionListener(this);
   
    bouton3.addActionListener(this);
	
	this.setSize(500,300);
	
	this.setBackground(Color.lightGray);
	this.setVisible(true);
		if(compteur==5){ 
			setVisible(false);
		JFrame cadre = new Admin("Admin");
        cadre.setLocationRelativeTo(null);
        cadre.setVisible(true);
        cadre.setSize(402, 402);}}
catch(NullPointerException e){}
 }


public void actionPerformed(ActionEvent e) {
	JButton clic=(JButton)e.getSource();
	if(clic==bouton1){
		new Qcm2(Accueil.ordre);
}
	else if(clic==bouton2){
	  new Quitter();
	 this.dispose();
		
	}
	else if(clic==bouton3){
		zoneDeTexte.setText("Votre score est "+ Accueil.Score);
	}
}}