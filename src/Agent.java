
public abstract class Agent {
	
	boolean alive;
	int state; //etat (poursuite /fuite/attente...)
	int orientation; //1=N, 2=0, 3=S, 4=E (sens trigo)
	int x,y;
	int energy;
	
	int last;



	public Agent(Terrain terrain,int x, int y){
		this.x=x;
		this.y=y;
		this.orientation=0;
		this.energy=50; //max energy
		this.last=0; //somme des 2 dernieres orientations
		this.alive=true;
		this.state=0; //attente
			
	}

	public void deplacementRandom(Terrain terrain){ //le deplacement random est commun aux moutons et aux loups
		
		orientation=(int) Math.random()*3+1;
		
		 switch ( orientation ) 
		 {
	    	case 1: // nord	
	    		y = ( y - 1 + terrain.getHeight() ) % terrain.getHeight();
	    		break;
	    	case 2:	// ouest
	    		x = ( x - 1 + terrain.getWidth() ) % terrain.getWidth();
				break;
	    	case 3:	// sud
	    		y = ( y + 1 + terrain.getHeight() ) % terrain.getHeight();
				break;
	    	case 4:	// est
	    		x = ( x + 1 + terrain.getWidth() ) % terrain.getWidth();
				break;
		 }
		
		
	}
	
}

