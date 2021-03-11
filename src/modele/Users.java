package modele;

public class Users {
	private int idUsers ;
	public String nameUsers ;
	private String passWord;
	
	//constructeur
	public Users(int iduser, String name, String mdp){
		idUsers = iduser ;
		nameUsers = name ;
		passWord = mdp ;
	}
	//Si l'utilisateurs est créer sans mot de passe, ce sera automatiquement "defaut"
	public Users(int iduser, String name){
		idUsers = iduser ;
		nameUsers = name ;
		passWord = "default" ;
	}
	
	public int getID (){
		return this.idUsers;
	}
	
	public String getName(){
		return this.nameUsers;
	}
	public String getMDP(){
		return this.passWord;
	}
	
}
