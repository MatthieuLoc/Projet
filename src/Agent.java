
public abstract class Agent {
	
	boolean alive;
	int state; //etat (poursuite /fuite/attente...)
	int orientation; //1=N, 2=0, 3=S, 4=E (sens trigo)
	int x,y;
	int energy;
	int last;



	public Agent(int x, int y){
		this.x=x;
		this.y=y;
		this.orientation=0;
		this.energy=50; //max energy
		this.last=0; //somme des 2 dernieres orientations
		this.alive=true;
		this.state=0; //attente
			
	}

	public void deplacementRandom(int size_y,int size_x){ //le deplacement random est commun aux moutons et aux loups
		
		int orientation=(int)( Math.random()*4);
	
	    	if(orientation==0){ // nord	
	    		//System.out.println("N");
	    		y = ( y - 1 + size_y ) % size_y;
	    	}

	    	if(orientation==1){	// ouest
	    		//System.out.println("O");
	    		x = ( x - 1 + size_x ) % size_x;
	    	}
	    	if(orientation==2){	// sud
	    		//System.out.println("S");
	    		y = ( y + 1 + size_y ) % size_y;
	    	}
	    	if(orientation==3){	// est
	    		//System.out.println("E");
	    		x = ( x + 1 + size_x ) % size_x;
	    	}

		
		
	}
	
}

