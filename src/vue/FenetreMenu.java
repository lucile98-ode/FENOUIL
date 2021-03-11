package vue;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import controleur.Controle;


public class FenetreMenu extends JFrame {
	

	public String testID ;
	public String testMDP ;
	private JLabel nomApp = new JLabel("FENOUIL : Connexion ");
	
	private JLabel lblID = new JLabel(" Identifiant:");
	private JLabel lblMDP = new JLabel("Mot de passe :");
	private JTextField txtID = new JTextField();
	private JTextField txtMDP = new JTextField();
	
	private JButton btnQuitter  = new JButton("Quitter");
	private JButton btnValider  = new JButton("Valider");
	
	public FenetreMenu(){
		setTitle("FENOUIL : MENU CONNEXION");
		setSize(600,300);
		setLocation(new Point(400,200));
		setLayout(null);    
		setResizable(false);

		initComponent();    
    	initEvent();    
	}

	private void initComponent(){

		
		nomApp.setBounds(200,10,200,10);
		
		
		//label et txtfield des deux champs de connexion
		lblID.setBounds(100,50,100,25);
		lblMDP.setBounds(100,100,100,25);
		txtID.setBounds(180,50,100,25);
		txtMDP.setBounds(180,100,100,25);
		
		btnValider.setBounds(300,100, 80,25);
		btnQuitter.setBounds(300,150, 80,25);


		add(nomApp);
		add(btnQuitter);
		add(btnValider);
		
		add(lblID);
		add(lblMDP);
		add(txtID);
    	add(txtMDP);
	}

  private void initEvent(){

    this.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e){
       System.exit(1);
      }
    });
    
    btnQuitter.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          btnQuitterClick(e);
        }
      });

    btnValider.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	btnValiderClick(e);
        }
      });
    
  }
  
  private void btnQuitterClick(ActionEvent evt){
	    System.exit(0);
	  }
 
  private void btnValiderClick(ActionEvent evt){
	  	testID = txtID.getText();
	  	testMDP = txtMDP.getText();
	  	System.out.println(testID);
	  	System.out.println(testMDP);
	  	
	  	//ca marche : Controle.controleMotdePasse(testID,testMDP);
	  	if (Controle.controleMDP(testID, testMDP) == true){
	  		FenetrePrincipale FenetrePrincipale = new FenetrePrincipale();
	  		FenetrePrincipale.setVisible(true);
	  	}
	    //Voir si c'est possible de fermer la premiere fenetre
	    //FenetreMenu.setVisible(true);
	    //System.exit(0);

	  }

}