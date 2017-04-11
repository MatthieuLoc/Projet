//TJRS LES MOUTONS EN PREMIER!!!!!

public class Animaux {
	
	Agent[] animaux;
	int taille;
	int[][] matrice;

	
	public Animaux(){

		taille = Glob.nagents;
		matrice = new int[Glob.size_x][Glob.size_y];
		animaux = new Agent[taille];
	}
	
	
	public void init(int[][] environnement){
		int x,y;
		
		for(int i=0;i<taille;i++){
			
			do{
				x=(int)(Math.random()*Glob.size_x);
				y=(int)(Math.random()*Glob.size_y);
			}
			while(environnement[x][y]==40||environnement[x][y]==41);
			
			
			if(i<Glob.nmoutons){
				animaux[i]= new MoutonAgent(x,y);
			}
			else{
				animaux[i]= new LoupAgent(x,y);
			}
		}
	}
	

	
	public void step(int[][] environnement, int[][] terrain){
		
		// on parcourt moutons
		for(int m=0;m<Glob.nmoutons;m++){
			
			if(animaux[m].alive){
				
				switch(animaux[m].state){
				
					// attente
					case 0 :
						animaux[m].step0(environnement,animaux);
						animaux[m].aFaim(environnement,animaux);
						break;
					
					// balade random
					case 1 :
						animaux[m].step1(environnement, terrain, animaux);
						animaux[m].aFaim(environnement,animaux);
						break;
					
					// est en chasse
					case 2 :
						animaux[m].step2(environnement, terrain, animaux);
						break;
					
					// fuite
					case 3 : 
						System.out.println("je rentre en etat de fuite");
						animaux[m].fuite(animaux,environnement,terrain);
						animaux[m].aFaim(environnement,animaux);
						break;
					
					// reproduction
					case 4 :
						
						
						break;
						
					default :
						
						break;
					
				}
				animaux[m].energy -= Glob.itEnergyM;
				
				animaux[m].vieux();

			}
			
			// dans tous les cas ?
			//animaux[m].stepM(m,environnement, terrain, animaux);
		}
		
		
		//on parcourt loup
		for(int l=Glob.nmoutons;l<taille;l++){
			
			if(animaux[l].alive){
				switch(animaux[l].state){
					
					// attente
					case 0 :
						animaux[l].step0(environnement,animaux);
						animaux[l].aFaim(environnement,animaux);
						break;
					
					// balade random
					case 1 :
						//System.out.println("deplacement random");
						animaux[l].step1(environnement, terrain, animaux);
						animaux[l].aFaim(environnement,animaux);
						break;
					
					// est en chasse
					case 2 :
						animaux[l].step2(environnement, terrain, animaux);
						break;
					
					// fuite
					case 3 : 
						animaux[l].aFaim(environnement,animaux);
						break;
					
					// reproduction
					case 4 :
						animaux[l].aFaim(environnement,animaux);
						break;
						
					default :
						break;
				}
			}
			animaux[l].energy -= Glob.itEnergyL;
			
			animaux[l].vieux();
			
			//animaux[l].stepL(l,environnement, terrain, animaux);
		}
	}
	//infos 1000=type agent 100=orientation 10=state 1=temporalité du step #activite
	public int[][] getMatrice(){

		this.cleanMatrice();
		for(int i=0;i<taille;i++){
			
			if(animaux[i].alive==true){matrice[animaux[i].x][animaux[i].y]=animaux[i].concateneMoiCa();}
			}

		return matrice;
	}
	
	public void cleanMatrice(){
		for(int j= 0;j<Glob.size_y;j++){
			for(int i=0;i<Glob.size_x;i++){
				matrice[i][j]=0;
			}
		}
	}
}
