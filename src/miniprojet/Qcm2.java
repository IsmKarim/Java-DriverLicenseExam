package miniprojet;
import java.awt.Checkbox;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.*;
import java.util.*;

import javax.swing.*;
public class Qcm2 extends JFrame implements ActionListener , ItemListener {
	 Audio audi;
	String s;
	String labonnerep;
    JPanel container = new JPanel(),fieldset = new JPanel();
    JLabel label;
    Icon image1;
    ButtonGroup bgRadio = new ButtonGroup();
    JCheckBox radio1 ;JPanel contentListe = new JPanel();
    JButton valider = new JButton("Valider");
    JButton fermer = new JButton("Fermer");
    String l ;
     String indic;
     boolean b=false;
     int ordrequestion;
public Qcm2(int j)
	{
		if((Accueil.ordre)<Integer.parseInt(Admin.nombreQu)-7){
			(Accueil.ordre)++;
	
		j=Accueil.ordre;
		ordrequestion=j;String im="image"+(Accueil.rand[j]+1)+".jpg";
	 	this.setTitle("Question");image1=new ImageIcon("C:\\safe\\miniprojet\\image(2)\\"+im);
	 	JButton boutonimage=new JButton(image1);
	    this.setSize(1000,700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        fieldset.setPreferredSize(new Dimension(600, 200));
        fieldset.setLayout(new BoxLayout(fieldset, BoxLayout.Y_AXIS));
        fieldset.add(contentListe);
        
       container.add(fieldset);
       this.setContentPane(container);
       this.setVisible(true);
       JPanel groupButtons = new JPanel();
       groupButtons.add(Box.createRigidArea(new Dimension(138,0)));
       groupButtons.add(valider);
       groupButtons.add(fermer);
       fermer.addActionListener( this);
       valider.addActionListener(this);
       container.add(groupButtons);
	    this.setVisible(true);
	    add(boutonimage);
    try{
		BufferedReader br=new BufferedReader(new FileReader("Q1.txt"));
		BufferedReader br2=new BufferedReader(new FileReader("Q2.txt"));
		
		String ligne;//int k=0;
		StringTokenizer st;
		String Qu[]=new String[38];
		int d=0;
		while ((ligne=br.readLine())!=null){
		Qu[d]=ligne;d++;} 
		Accueil obj=new Accueil();obj.dispose();
		label=new JLabel(Qu[obj.rand[j]]);
		fieldset.add(label);
		contentListe.add(label);
        fieldset.add(contentListe);
		this.setVisible(true);
		    
			while ((ligne=br2.readLine())!=null && b==false) {
			st =new StringTokenizer(ligne);
			indic=st.nextToken();
			if(indic.charAt(0)!='A' && indic.charAt(0)!='D' && indic.charAt(0)!='C' && indic.charAt(0)!='B'){
			if(Integer.parseInt(indic)==obj.rand[j]){ 
			while(( ligne=br2.readLine())!=null && ligne.charAt(0)!= String.valueOf(obj.rand[j]+1).charAt(0)){ 
			radio1= new JCheckBox(ligne);
			 bgRadio.add(radio1);   JPanel groupRadio = new JPanel();
			    groupRadio.setLayout(new BoxLayout(groupRadio, BoxLayout.Y_AXIS));
			    groupRadio.add(radio1);
			  
			    fieldset.add(groupRadio);
			 radio1.addItemListener(this);
			    container.add(fieldset);
			    radio1.addActionListener(this);
			     audi = new Audio();
			    audi.start();
			   
			    
		
			String chaine = ligne+"\n";
			
			} 
			b=true;
			ordrequestion++; 
			fieldset.setBorder(BorderFactory.createTitledBorder("Question"+" "+ordrequestion));}
			}
			
			}
			
		 
			br.close();br2.close();
    }
			catch (IOException e){
		System.out.println(e.toString());
	}
}

	}




public void actionPerformed(ActionEvent e) {
	if(e.getSource()==valider)
		{
		if((Audio.time+11000)>System.currentTimeMillis())
			{try {//System.out.println((Audio.time+11000)-System.currentTimeMillis());
			Thread.sleep((Audio.time+11000)-System.currentTimeMillis());
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		}}
		if(ordrequestion==20){
			dispose();
			new Utilisateur();
			Utilisateur.zoneDeTexte.setText("Votre score est "+ Accueil.Score);
			try{BufferedReader lec=new BufferedReader(new FileReader("fichier1.txt"));
            
        	String ligne; String Chaine=" ";
        	int g=0;boolean b=true;
        	while((ligne=lec.readLine())!=null){
        		
        	StringTokenizer st = new StringTokenizer(ligne);
        	while(st.hasMoreTokens() && b){
        	s=st.nextToken();
        	l= st.nextToken();
        	s+=" "+l+" ";
        	if(l.length()==Demarrer.nomutilisateur.length()){
           	for(int i=0;i<l.length();i++){
  			if (l.charAt(i)==Demarrer.nomutilisateur.charAt(i)){g++;}}}
        	    
        	    if(g==l.length())
        	    { s+=st.nextToken()+" ";
        	    s+=st.nextToken()+" ";
        	    s+=Accueil.Score+" ";
        	    st.nextToken();
        	    s+=st.nextToken();s=s+" "; s=s+"\n";
        	    g=0;Chaine+=s;
        	   }
        	    else{st.nextToken();
        	    l=st.nextToken();
        	    st.nextToken();
        	    st.nextToken();
        	    	g=0;
        	   Chaine+=ligne+"\n";  } 
        	    }
        	}
        	
         
            lec.close();
            PrintWriter readme=new PrintWriter(new FileOutputStream("fichier1.txt"));
          //  if(g==l.length()){ readme.println(s+" ");}
            readme.println(Chaine);
            readme.close();
            
            } catch (IOException ee) {
              System.err.println("Error: " + ee.getMessage());
            } }
		else{
			Qcm2.this.dispose();
		Qcm2 Q2=new Qcm2(Accueil.ordre);
		
		}}
	
	else if(e.getSource()==fermer)
		System.exit(0);
	
}
public void itemStateChanged(ItemEvent d) {
	JCheckBox clic4=(JCheckBox) d.getSource();
	try{
	Scanner scanner = new Scanner(new FileReader("bonne.txt"));
	int incr=1; 
	while (scanner.hasNext() && Accueil.nombrealeatoire!= incr){
	
	labonnerep = scanner.next();
	incr++;
	    
	    }}
	catch(IOException e){}
	if(clic4.getText().charAt(0)==labonnerep.charAt(0)){(Accueil.Score)++;
	}
}

}

