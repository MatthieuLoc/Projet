import java.lang.*;

public class Monde {

	public static void main(String[] args) {

		int i,j;
		Animaux animaux;
		Sprite sprite;
		int [][]buffer;
		Terrain terrain;
		terrain = new Terrain();
		terrain.init();
		terrain.pointHaut();
		terrain.strates();
		terrain.ajoutArbres();
		//System.out.println(terrain.toString3());
		
		animaux=new Animaux();
		
		animaux.init(terrain.getTerrain());

		

		//initialisation du monde
		//creation matrice terrain, liste agents liste predateurs
		

		
		sprite=new Sprite(terrain,animaux);
		
		for(;;){
			animaux.step(terrain.getEnvironnement());
			
			sprite.refresh();
			//System.out.println(animaux.toString3());
			
			try {
			    Thread.sleep(10);                 //1000 milliseconds is one second.
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
		}

		//boucle infinie
		
		//mise a jour vegetation puis agents
		

		
	}

}
