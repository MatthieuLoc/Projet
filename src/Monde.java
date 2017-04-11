//import java.lang.*;

public class Monde {
	
	public static int temps=0;
	
	public static void main(String[] args) {
		

		//int i,j;
		Animaux animaux;
		Sprite sprite;
		//int [][]buffer;
		Terrain terrain;
		terrain = new Terrain();
		terrain.init();
		terrain.pointHaut();
		terrain.strates();
		terrain.mer();
		terrain.ajoutArbres();
		terrain.ajoutHerbe();
		
		animaux = new Animaux();
		
		animaux.init(terrain.getEnvironnement());

		
		//initialisation du monde
		//creation matrice terrain, liste agents liste predateurs
		

		
		sprite = new Sprite(terrain,animaux);
		
		for(;;){
			animaux.step(terrain.getEnvironnement(),terrain.getTerrain());
			terrain.refreshArbres();
			
			sprite.refresh();
			//System.out.println(animaux.toString3());
			
			try {
			    Thread.sleep(30); 
			   temps++;
			   //1000 milliseconds is one second.
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
		}

		//boucle infinie
		
		//mise a jour vegetation puis agents
		

		
	}

}