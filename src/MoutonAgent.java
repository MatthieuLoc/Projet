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
	
	//constructeur
	public MoutonAgent(int x, int y){
	super( x, y,false); //constructeur de la classe agent, avec mechant==false;
	}
	
	//redonne de l'energie
	public void nourri(){
		
		state=0;//arrete de chasser fuire
		energy=(energy+Glob.eatEnergyM);
	}
	
	//diminue energie a chquae iteration
	public  void lowerEnergy(){
		
			energy=energy-Glob.itEnergyM;
			
			if(energy<0){
				meurs();
			}
		}
	}


