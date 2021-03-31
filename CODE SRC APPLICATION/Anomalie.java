
public class Anomalie {
	
	String typeAnomalie ;
	int numCommandeAssociee ;
	DateNaissance date ;
	boolean courrierEnvoyer = false ;
	
	public String[] typeAno = new String[] {"Erreur sur le montant", "Probleme sur le moyen de paiement" };

	
	public Anomalie(String typeAnomalie, int numCommandeAssociee, DateNaissance date) {
		this.typeAnomalie = typeAnomalie ;
		this.numCommandeAssociee = numCommandeAssociee;
		this.date = date ;
		
	}
	
	//getter
	public String getTypeAnomalie() {
		return this.typeAnomalie;
	}
	public int getNumCommandeAssociee() {
		return this.numCommandeAssociee;
	}
	public DateNaissance getDateCreaAnomalie() {
		return this.date;
	}
	public boolean getCourrierEnvoyer() {
		return this.courrierEnvoyer;
	}
	
	//setters
	public void setTypeAnomalie(String t) {
		typeAnomalie = t ;
	}
	public void setNumCommandeAssociee(int i) {
		numCommandeAssociee = i;
	}
	public void setDateCreaAnomalie(DateNaissance d) {
		date = d ;
	}
	public void setCourrierVrai() {
		this.courrierEnvoyer = true ;
	}
	public void setCourrierFaux() {
		this.courrierEnvoyer = false ;
	}
}
