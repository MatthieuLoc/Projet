/*RAPPEL DU CONTENU D'AGENT
 	boolean _alive;
	int _state; //etat (poursuite /fuite/attente...)
	int _orientation; //1=N, 2=0, 3=S, 4=E (sens trigo)
	int _x,_y;
	int _energy;
	
	int _last;

 */
	
public class MoutonAgent extends Agent {
	
	boolean mechant;
	public MoutonAgent( Terrain terrain,int x, int y){
	super(terrain, x, y);
	mechant=false;
	}

	public MoutonAgent(Terrain terrain){
	
	//dans le futur, il faudra ajouter les lieux de naissance (des conditions d'altitude pour que ce soit random mais a une altitude donnée)
	this(terrain,(int) Math.random()*terrain.getWidth(),(int) Math.random()*terrain.getHeight());	
	}


	void step(MoutonAgent mouton){
		if(mouton.state==0){
			mouton.deplacementRandom(terrain);
		}
	}
}
