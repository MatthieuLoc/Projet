
public abstract class Agent {
	
	boolean alive;
	int state; //etat (poursuite /fuite/attente...)
	int orientation; //1=N, 2=0, 3=S, 4=E (sens trigo)
	int x,y;
	int energy;
	int last;
	boolean mechant;



	public Agent(int x, int y,boolean mechant){
		this.x=x;
		this.y=y;
		this.orientation=0;
		this.energy=50; //max energy
		this.last=0; //somme des 2 dernieres orientations
		this.alive=true;
		this.state=0; 
		this.mechant=mechant;
		
	}
	

	
	public abstract void moveRand(int[][]environnement);
	
}

