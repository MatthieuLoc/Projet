
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
		this.energy=Glob.maxEnergy; //max energy
		this.last=0; //somme des 2 dernieres orientations
		this.alive=true;
		this.state=0; //etat 1 en chasse 
		this.mechant=mechant;
		
	}
	
	public void nourri(){
		this.state=0;
		this.energy=Glob.maxEnergy;
		
	}
	
	public void meurs(){
		this.state=0;
		this.energy=Glob.maxEnergy;
		this.alive=false;
	}
	
	public abstract void moveRand(int[][]environnement);
	
}

