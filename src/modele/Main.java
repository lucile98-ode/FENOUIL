package modele;

public class Main {
	
	public static void main(String[] args) {
		
		String chaineCaractere = "Ceci est un test avec plus de lettre";	
		
		System.out.println(chaineCaractere);
		
		Users hacene = new Users(1,"Hacene");
		
		System.out.println(hacene.getID());
		System.out.println(hacene.getName());
		System.out.println(hacene.getMDP());
		
	
	}
	
	
	
}
