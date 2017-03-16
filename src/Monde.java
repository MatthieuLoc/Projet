import java.lang.*;

public class Monde {

	public static void main(String[] args) {
		int size_x=78;
		int size_y=48;
		int hauteur=7;
		int nmouton=2;
		int nloup=10;
		int i,j;
		Animaux animaux;
		Sprite sprite;
		
		Terrain terrain;
		terrain = new Terrain(size_x,size_y,hauteur);
		terrain.init();
		terrain.pointHaut();
		terrain.strates();
		terrain.ajoutArbres();
		System.out.println(terrain.toString3());
		
		animaux=new Animaux(nmouton,nloup,size_x,size_y,terrain.getTerrain(), terrain.getEnvironnement());
		animaux.remplirMoutons();
		System.out.println(animaux.toString3());
		
		

		//initialisation du monde
		//creation matrice terrain, liste agents liste predateurs
		

		
		sprite=new Sprite(terrain,animaux,size_x,size_y);
		
		for(;;){
			animaux.deplacementRandom(animaux.moutons);
			
			sprite.refresh();
			//System.out.println(animaux.toString3());
			try {
			    Thread.sleep(200);                 //1000 milliseconds is one second.
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
		}

		//boucle infinie
		
		//mise a jour vegetation puis agents
		

		
	}

}
