/*RAPPEL DU CONTENU D'AGENT
 	boolean _alive;
	int _state; //etat (poursuite /fuite/attente...)
	int _orientation; //1=N, 2=0, 3=S, 4=E (sens trigo)
	int _x,_y;
	int _energy;
	
	int _last;
	boolean mechant;

 */
	
public class LoupAgent extends Agent {

	//constructeur
	public LoupAgent(int x, int y){
	super( x, y,true); //constructeur de la classe mere Agent avec mechant==true
	}
	
	//fatigue des loups
	public  void lowerEnergy(){
		
		energy=energy-Glob.itEnergyL; // a chaque iteration, l'energie diminue
		
		if(energy<0){
			meurs();
		}
	}
	
	//augmente energy des loups
	public void nourri(){
		
		state=0;//se "calme" arrete de fuire chasser
		energy=(energy+Glob.eatEnergyL);
	}
}


