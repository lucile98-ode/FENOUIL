package controleur;

import vue.FenetrePrincipale;

public class Controle {
	
	public static boolean controleMDP(String nom, String mdp){
		if (nom.equals("hacene") && (mdp.equals("default")) )
			return true;
		else
			return false;
	}
	/*
	public static void controleMotdePasse(String nom, String mdp){
		System.out.println(nom);
		System.out.println(mdp);
		if ((nom.equals("hacene")) && (mdp.equals("default"))){
			FenetrePrincipale FenetrePrincipale = new FenetrePrincipale();
			FenetrePrincipale.setVisible(true);
		}
		else 
			System.out.println("boucleElse");
			//FenetrePrincipale FenetrePrincipale = new FenetrePrincipale();
			//FenetrePrincipale.setVisible(true);
	}	
	*/
}
