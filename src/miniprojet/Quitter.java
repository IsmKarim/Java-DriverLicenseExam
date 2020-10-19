package miniprojet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Quitter extends Frame implements ActionListener{Button fermer ;
Quitter(){
	FlowLayout fl =new FlowLayout(FlowLayout.CENTER,50,630);
	setLayout(fl);
	fermer= new Button("fermer");
	add(fermer);
	fermer.addActionListener(this);
	setSize(800,700);
	setBackground(Color.lightGray);
	setVisible(true);
}
	public void paint(Graphics g)
	{	Font ft=new Font("Dialoginput",Font.BOLD,40);
	    g.setFont(ft);
	    g.setColor(Color.black);
	    if(Accueil.cas==0){
		g.drawString("Merci !", 400, 400);}
	    else
	    	
	    {g.drawString("c'est une application java ", 100, 100);
	    g.drawString("Qcm permis de conduire ", 100, 300);}
	    	
				
				}
	public void actionPerformed(ActionEvent e) {
		
		Button cl=(Button)e.getSource();
		if(cl==fermer)
			System.exit(0);
	}
		

}
