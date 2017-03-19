/*RAPPEL DU CONTENU D'AGENT
 	boolean _alive;
	int _state; //etat (poursuite /fuite/attente...)
	int _orientation; //1=N, 2=0, 3=S, 4=E (sens trigo)
	int _x,_y;
	int _energy;
	
	int _last;
	boolean mechant;

 */

	
public class MoutonAgent extends Agent {


	
	public MoutonAgent(int x, int y){
	super( x, y,false);
	}
	
	

	

	public  void lowerEnergy(){
			this.energy=this.energy-5;
			if(this.energy<0){
				this.alive=false;
			}
	}


}


