
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

	public void deplacementRandom(int height,int width){ //le deplacement random est commun aux moutons et aux loups
		
		int k=(int)( Math.random()*4);
	
	    	if(k==0){ // nord	
	    		//System.out.println("N"+k);
	    		y = ( y - 1 + height ) % height;
	    	}

	    	if(k==1){	// ouest
	    		//System.out.println("O"+k);
	    		x = ( x - 1 + width ) % width;
	    	}
	    	if(k==2){	// sud
	    		//System.out.println("S"+k);
	    		y = ( y + 1 + height ) % height;
	    	}
	    	if(k==3){	// est
	    		//System.out.println("E"+k);
	    		x = ( x + 1 + width ) % width;
	    	}

		
		
	}
	
}

