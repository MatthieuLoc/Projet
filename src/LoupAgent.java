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
	
public class LoupAgent extends Agent {

	
	public LoupAgent(int x, int y){
		super( x, y,true);
	}
	
	
	//appellé par afaim, donc on suppose que energie en dessous du seuil de faim
	public void step2( int[][] environnement, int[][] terrain, Agent[] animaux){

		if((goal[0]<0)&&(goal[1]<0)){ 
			//System.out.println("Loup a faim, cherche goal");
			if(findGoal(environnement,animaux)==0){
				//System.out.println("change d'endroit de recherche");
				changeArea(environnement);
			}
		}
		//s'il a faim et a déjà un goal
		else { //goal != -1
			if(proie != -1){
				if(x==animaux[proie].x && y==animaux[proie].y){	
					loupMange(animaux);
				}
				else{
					refreshGoal(animaux,proie);
					chasse(animaux,environnement,terrain);
				}
				
			}
			else{
				if((goal[0]==x)&&(goal[1]==y)){
					goal[0]=-1;
					goal[1]=-1;
				}
				else{
					chasse(animaux,environnement,terrain);
				}
			}
		}
	}
	
	public void aFaim(int[][] environnement,Agent[] animaux){

		// a faim si energy <Glob.energy et s'il n'a pas déjà de goal
		if((energy<Glob.faimL)&&(goal[0]<=0)&&(goal[1]<=0)){
			// CHANGE ETAT
			state = 2;
			//System.out.println("jai faim "+ "state="+2);		
		}				
	}
			
	public void loupMange(Agent[] animaux){
		System.out.println("j'ai bouffé");
		// on utilise l'id de la proie    mais il peut être -1 si le loup n'a pas de proie/ non car loupMange est appellé que si le loup est sur un mouton
		// si le loup est sur la case de sa proie
			//System.out.println("proie "+proie);
			animaux[proie].meurs();
			goal[0]=-1;
			goal[1]=-1;
			nourri();

	}
	

	public void nourri(){ //ce qui concerne le loup
		energy=(energy+Glob.eatEnergyL);
		state=1;
		proie = -1;
		goal[0]=-1;
		goal[1]= -1;
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
		int distanceMax = 2000; //Jusqu'où il recherche ?
		
		// directions possibles: G=(-1,0) H=(0,-1) D=(1,0) B=(0,1)
		int[] dx = new int[] {-1,0,1,0};
		int[] dy = new int[] {0,-1,0,1};
		int dirIndex=0;
		
		// distance parcourue
		int distance=0;

		// nombre de pas a faire
		int stepToDo=1;

		// position courante
		int xCourant=this.x, yCourant=this.y;
		
		while (true) {
			
			for (int i = 0; i < 2; i++) {
				
				// déplacement du nombre de pas
				for (int j = 0; j < stepToDo; j++) {
						
						if((xCourant>=0)&&(xCourant<Glob.size_x)&&(yCourant>=0)&&(yCourant<Glob.size_y)){
							
							for(int m=0;m<Glob.nmoutons;m++){
								// Si c'est du gibier
								if((animaux[m].x == xCourant )&&(animaux[m].y == yCourant)){
									if(animaux[m].proie==-1){
									this.proie = animaux[m].id;
									this.goal[0]=xCourant;
									this.goal[1]=yCourant;
									//System.out.println("mouton en vue (1) proie:"+proie);
									animaux[m].proie=id; //ici proie est utilisé sur les moutons pour savoir si ils sont deja pourchassés
									animaux[m].estChasse(x,y);
									return 1;
									}
								}
							}
						}
					
					distance++;
					
					if(distance>distanceMax){
						//System.out.println("pas de mouton en vue (0)");
						return 0; //ATTENTION BREAK OU RETURN?
					}
						
					// déplacement
					xCourant+=dx[dirIndex];
					yCourant+=dy[dirIndex];
					
				}
				
				// tourne à droite
				dirIndex = (dirIndex + 1) % 4;
			}
			
			// incrementer le nombre de pas a faire
			stepToDo++;
		}

	}
	
	
	public void refreshGoal(Agent[] animaux,int id){
		//System.out.println("nouveaux goal fictif");
		this.goal[0]=animaux[id].x;
		this.goal[1]=animaux[id].y;
	}

	
	public void chasse(Agent[] animaux, int[][]environnement, int terrain[][]){
		System.out.println("coucou");
		//System.out.println("chasse");
		int tab[] = this.goal;
		//cas ou la chasse ne se passe pas comme prevu

		if(Math.random()<0.5){
			// aller au bon X
			
			if(this.x < tab[0]){
				this.conditions(animaux,environnement,terrain, 4);
			}
			else if(this.x > tab[0]){
					this.conditions(animaux,environnement,terrain, 2);
			}
		}
		else{
			// aller au bon Y
			
			if(this.y < tab[1]){
					this.conditions(animaux,environnement,terrain, 3);
			}
			else if(this.y > tab[1]){
					this.conditions(animaux,environnement,terrain, 1);
			}
		}
		
	}
	
}


