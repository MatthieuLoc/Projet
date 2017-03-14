
public class Monde {

	public static void main(String[] args) {
		int width=30;
		int height=50;
		int hauteur;
		int nmouton=8;
		int nloup;
		int i,j;
		Terrain terrain;
		MoutonAgent[] moutons=new MoutonAgent[nmouton];
		
		terrain = new Terrain(80,50,9);
		
		terrain.init();
		terrain.pointHaut();
		terrain.strates2();
		terrain.ajoutArbres();
		System.out.println(terrain.toString3());
		
		for(i=0;i<nmouton;i++){
			moutons[i]=new MoutonAgent((int) Math.random()*width,(int) Math.random()*height);
		}

		//initialisation du monde
		//creation matrice terrain, liste agents liste predateurs
		

		
		Sprite dessin = new Sprite(terrain);

		//boucle infinie
		
		//mise a jour vegetation puis agents
		

		
	}

}
