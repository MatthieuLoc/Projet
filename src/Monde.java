
public class Monde {

	public static void main(String[] args) {
		int width=50;
		int height=30;
		int hauteur;
		int nmouton=8;
		int nloup=0;
		int i,j;
		Animaux animaux;
		
		Terrain terrain;
		terrain = new Terrain(width,height,5);
		terrain.init();
		terrain.pointHaut();
		terrain.strates2();
		terrain.ajoutArbres();
		System.out.println(terrain.toString3());
		
		animaux=new Animaux(nmouton,nloup,width,height);
		animaux.remplirMoutons();
		System.out.println(animaux.toString3());
		
		

		//initialisation du monde
		//creation matrice terrain, liste agents liste predateurs
		

		
		Sprite dessin = new Sprite(terrain,animaux);

		//boucle infinie
		
		//mise a jour vegetation puis agents
		

		
	}

}
