/*
 	RAPPEL DU CONTENU D'AGENT
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
	
	
	public void aFaim(int[][] environnement,Agent[] animaux){
		
		// a faim si energy <= 5 et s'il n'a pas déjà de goal
		if((energy<Glob.faimM)&&(goal[0]<=0)&&(goal[1]<=0)){
					
			// CHANGE ETAT
			state = 2;
			//System.out.println("jai faim");
		}
					
	}
	
	
	//MODIFIED
	public void estChasse(int xL, int yL,boolean alive){
		int tmpx,tmpy;
		

		switch(orientation){
		case 1:
			if(yL<y){
				
				state=3;
				
				tmpy=y+(y-yL);
				if(tmpy<Glob.size_y){
					goal[1]=tmpy;
				}
				else{
					goal[1]=Glob.size_y-1;
				}
				
			}
		case 2:
			if(xL<x){
				state=3;

				tmpx=x+(x-xL);
				if(tmpx<Glob.size_x){
					goal[0]=tmpx;
				}
				else{
					goal[0]=Glob.size_x-1;
				}
			}
		case 3:
			if(yL>y){
				state=3;
				System.out.println("state=3");
				tmpy=y-(yL-y);
				if(tmpy<0){
					goal[1]=tmpy;
				}
				else{
					goal[1]=0;
				}
			}
		case 4:
			if(xL>x){
				state=3;
				System.out.println("state=3");
				tmpx=x-(xL-x);
				if(tmpx<0){
					goal[0]=tmpx;
				}
				else{
					goal[0]=0;
				}
			}
		}

	}
	
	
	public void fuite(Agent[] animaux, int[][]environnement, int terrain[][]){
		
		int tab[] = this.goal;

		//if(Math.random()<0.5){
			// aller au bon X
			
			if(this.x < tab[0]){
				this.conditions(animaux,environnement,terrain, 4);
			}
			else if(this.x > tab[0]){
					this.conditions(animaux,environnement,terrain, 2);
			}
		//}
		//else{
			// aller au bon Y
			
			if(this.y < tab[1]){
					this.conditions(animaux,environnement,terrain, 3);
			}
			else if(this.y > tab[1]){
					this.conditions(animaux,environnement,terrain, 1);
			}
		//}
		
	}
	
	public void step2( int[][] environnement, int[][] terrain, Agent[] animaux){
		// Step mouton etat 2 : un mouton ayant faim
		
		//System.out.println("id : "+ this.id+ ", state : "+this.state);
		
		//si goal est (-1,-1)
		if((goal[0]<0)&&(goal[1]<0)){
		//	//System.out.println("Mouton "+ id +" a faim, cherche goal");
			if(findGoal(environnement,animaux)==0){
			//	//System.out.println("Mouton change area");
				changeArea(environnement);
			}
		}
		
		//System.out.println("Mouton  "+ id +" Goal : "+goal[0] +", "+goal[1]);
	
	
		// si energy <= 5 et il a un goal
		if((energy<Glob.faimM)&&(goal[0]>=0)&&(goal[1]>=0)){ 
				
			if(environnement[goal[0]][goal[1]]==45){
				//System.out.println("Mouton "+ id +" a faim, chasse");
				chasse(animaux,environnement,terrain);
			}
			else if((x == goal[0])&&(y == goal[1])
					&&(environnement[goal[0]][goal[1]]!=45)){
				//System.out.println("Mouton a changé d'area");
				goal[0]=-1;
				goal[1]=-1;
				findGoal(environnement,animaux);
			}
			else{
				//System.out.println("Mouton "+ id +" a faim, change d'area");
				findGoal(environnement,animaux); //il cherche en continu
				chasse(animaux,environnement,terrain);
			}

		}
		
		//si le mouton a atteint son goal et que c'est de l'herbe
		moutonMange(environnement);
		
	}
	
	public void moutonMange(int[][] environnement){
		
		//si le mouton a atteint son goal et que c'est de l'herbe
		if((this.x == this.goal[0])&&(this.y == this.goal[1])
				&&(environnement[this.x][this.y]==45)){
				
			//System.out.println("Mouton est arrivé !");
			this.goal[0]=-1;
			this.goal[1]=-1;
			environnement[this.x][this.y]=0;
			nourri();
		}
	}
	
	
public void nourri(){
	this.energy=(energy+Glob.eatEnergyM);
	if(energy>1000)energy=1000;
	this.state = 1;
}
	public void changeArea(int[][] environnement){
		int x;
		int y;
		do{
			do{
				if(Math.random()<0.5)
					x = this.x + Math.abs(10+(int)(Math.random()*10));
				else
					x = this.x - Math.abs(10+(int)(Math.random()*10));
			}while((x<0)||(x>=Glob.size_x));
			
			do{
				if(Math.random()<0.5)
					y = this.y + Math.abs(10+(int)(Math.random()*10));
				else
					y = this.y - Math.abs(10+(int)(Math.random()*10));
			}while((y<0)||(y>=Glob.size_y));
			
		//System.out.println("x="+x+" y="+y);	
		}while((environnement[x][y]==40)&&(environnement[x][y]==42)); //ATTENTION MIEUX VAUT >= et <=
		
		this.goal[0]=x;
		this.goal[1]=y;
		
	}
	
	public int findGoal(int[][] environnement, Agent[] animaux){
		
		int distanceMax = 500; //Jusqu'où il recherche ?
		
			// directions possibles: G=(-1,0) H=(0,-1) D=(1,0) B=(0,1)
			int[] dx = new int[] {-1,0,1,0};
			int[] dy = new int[] {0,-1,0,1};
			int dirIndex=0;
			
			// distance parcourue
			int distance=0;

			// nombre de pas a faire
			int stepToDo=1;

			// position courante
			int x=this.x, y=this.y;
			
			while (true) {
				
				for (int i = 0; i < 2; i++) {
					
					// déplacement du nombre de pas
					for (int j = 0; j < stepToDo; j++) {
							
						// Si c'est de l'herbe
						if((x>=0)&&(x<Glob.size_x)&&(y>=0)&&(y<Glob.size_y)&&(environnement[x][y]==45)){
							this.goal[0]=x;
							this.goal[1]=y;
							return 1;
						}
							
						distance++;
						
						if(distance>distanceMax){
							//System.out.println("pas trouvé");
							return 0; //ATTENTION BREAK OU RETURN?
						}
							
						// déplacement
						x+=dx[dirIndex];
						y+=dy[dirIndex];
						
					}
					
					// tourne à droite
					dirIndex = (dirIndex + 1) % 4;
				}
				
				// incrementer le nombre de pas a faire
				stepToDo++;
			}
	
		}
	
	
	public void chasse(Agent[] animaux, int[][]environnement, int terrain[][]){
		
		int tab[] = this.goal;
		
		if(Math.random()<0.5){
			
			// aller au bon X
			
			if(this.x < tab[0]){
				this.conditions(animaux,environnement,terrain, 4);
			}
			else if(this.x > tab[0]){
				this.conditions(animaux,environnement,terrain, 2);
			}
		
			// aller au bon Y
			
			if(this.y < tab[1]){
				this.conditions(animaux,environnement,terrain, 3);
			}
			else if(this.y > tab[1]){
				this.conditions(animaux,environnement,terrain, 1);
			}
		}
	}

	public void estSuivi(int[][]environnement, int terrain[][]){
		
	}





//END
}
