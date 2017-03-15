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
	
	
	public MoutonAgent(int x, int y){
	super( x, y);
	mechant=false;
	}


}


