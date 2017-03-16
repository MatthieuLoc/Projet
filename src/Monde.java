import java.lang.*;

public class Monde {

	public static void main(String[] args) {
		int width=20;
		int height=20;
		int hauteur=0;
		int nmouton=5;
		int nloup=10;
		int i,j;
		Animaux animaux;
		
		Terrain terrain;
		terrain = new Terrain(width,height,hauteur);
		terrain.init();
		terrain.pointHaut();
		terrain.strates2();
		terrain.ajoutArbres();
		System.out.println(terrain.toString3());
		
		animaux=new Animaux(nmouton,nloup,width,height,terrain.getTerrain(), terrain.getEnvironnement());
		animaux.remplirMoutons();
		System.out.println(animaux.toString3());
		
		

		//initialisation du monde
		//creation matrice terrain, liste agents liste predateurs
		

		
		//new Sprite(terrain,animaux);
		
		for(;;){
			animaux.deplacementRandom(animaux.moutons);
			new Sprite(terrain,animaux);
			//System.out.println(animaux.toString3());
			try {
			    Thread.sleep(300);                 //1000 milliseconds is one second.
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
		}

		//boucle infinie
		
		//mise a jour vegetation puis agents
		

		
	}

}
