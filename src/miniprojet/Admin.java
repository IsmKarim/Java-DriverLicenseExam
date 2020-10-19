package miniprojet;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileFilter;

public class Admin extends JFrame {
	static String nombreQu;
    int score;
    public Admin(String titre) {
        super(titre);
        setPreferredSize(new Dimension(400, 400)); //il calculera l'emplacement et la taille des composants (taille optimale du composant)
        
        setJMenuBar(barreDeMenus());

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        zoneDeTexte = new JTextArea();
        zoneDeTexte.setFont(new Font("Monospaced", Font.PLAIN, 12)); //changement de font si besoin
        zoneDeTexte.setPreferredSize(new Dimension(400,400));
        setContentPane(new JScrollPane(zoneDeTexte));// Ceci permet de visualiser des composants plus grands que l'espace dans lequel ils sont visualisés
        zoneDeTexte.setText("Bonjour Admin");

      
    }

     JTextArea zoneDeTexte;
   
    boolean donneesSauvees = true;

    JMenuBar barreDeMenus() {
        JMenuBar barreDeMenus = new JMenuBar();
        JMenu menu = new JMenu("Actions");
        barreDeMenus.add(menu);

       JMenuItem item = new JMenuItem("Consultation des Scores ");//consultation des scores
        menu.add(item);
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
					menuActionsConsultationdesScores();
				} catch (IOException e) {
					
					e.printStackTrace(); //affiche l'exception et l'état de la pile d'exécution au moment de son appel
				}
            }
        });

        item = new JMenuItem("Modification Questions");
        menu.add(item);
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                menuActionsModificationQuestion();
            }
        });

        item = new JMenuItem("Historique");
        menu.add(item);
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
					HistoriqueMembre();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
            }
        });

        return barreDeMenus;
    }

    void menuActionsConsultationdesScores() throws IOException {
     
    	
            String nomchoisie = JOptionPane.showInputDialog(this,
                    "login du membre ", "consultation des scores",
                    JOptionPane.QUESTION_MESSAGE);
            
            if (nombreQu == null)
                return;
            Scanner scanner1=new Scanner(new FileReader("fichier1.txt"));int g=0;
            while (scanner1.hasNext()){scanner1.next();String s=scanner1.next();
     		if(nomchoisie.length()==s.length()){
     		for(int i=0;i<nomchoisie.length();i++){
     			if (nomchoisie.charAt(i)==s.charAt(i)){g++;}}}
     		
     			scanner1.next();
     			scanner1.next();
     			
     			if(g==nomchoisie.length()){
     				score=Integer.parseInt(scanner1.next());
     				zoneDeTexte.setText("le score de "+nomchoisie+" est : "+score);
     				break;
     			}
     			else{g=0;scanner1.next();
 				scanner1.next();}
     				
     			}
            return;
        

      
    }

    void menuActionsModificationQuestion (){
        nombreQu = null;
     
     
            nombreQu = JOptionPane.showInputDialog(this,
                    "Nombre de question ?", "Modification Question",
                    JOptionPane.QUESTION_MESSAGE);
            if (nombreQu == null)
                return;
         
      
    }

    void HistoriqueMembre() throws IOException { affichageRegistre();
      
    }

   void affichageRegistre() throws IOException {
        String s = "";
        String chaine="";
     
        BufferedReader lec=new BufferedReader(new FileReader("fichier1.txt"));
        while((s=lec.readLine())!=null){
        	chaine+=s+"\n";
        }
        zoneDeTexte.setText(chaine);
        lec.close();
    } 
}