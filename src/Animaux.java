//TJRS LES MOUTONS EN PREMIER!!!!!

public class Animaux {
	
	Agent[] animaux;
	int taille;
	int[][] matrice;

	
	
	
	public Animaux(){

		taille=Glob.nmoutons+Glob.nloups;
		matrice= new int[Glob.size_x][Glob.size_y];
		animaux=new Agent[Glob.nmoutons+Glob.nloups];
	}
	
	
	public void init(int[][] environnement){
		int x,y;
		
		for(int i=0;i<taille;i++){
			
			do{
				x=(int)(Math.random()*Glob.size_x);
				y=(int)(Math.random()*Glob.size_y);
			}
			while(environnement[x][y]==30||environnement[x][y]==31);
			
			
			if(i<Glob.nmoutons){
				animaux[i]= new MoutonAgent(x,y);
			}
			else{
				animaux[i]= new LoupAgent(x,y);
			}
		}
	}
	
	
	
	public void moveRand( int[][] environnement){
		for(int i=0;i<taille;i++){
			//matrice[animaux[i].x][animaux[i].y]=0;
			animaux[i].moveRand(environnement);
			//matrice[animaux[i].x][animaux[i].y]=2;
		}
	}
	
	public void loupMange(){
		for(int l=Glob.nmoutons;l<taille;l++){
			for(int m=0;m<Glob.nmoutons;m++){
				if((animaux[l].x==animaux[m].x)&&(animaux[l].y==animaux[m].y)){
					animaux[l].nourri();
					animaux[m].meurs();
				}
			}
			
		}
	}
	
	public void step(int[][] environnement){
		this.loupMange();
		this.moveRand(environnement);
		
		
	}
	public int[][] getMatrice(){
		this.cleanMatrice();
		for(int i=0;i<taille;i++){
			if(animaux[i].alive==true){
				if(animaux[i].mechant==true){
					//matrice[animaux[i].x][animaux[i].y]=2;
					matrice[animaux[i].x][animaux[i].y]=matrice[animaux[i].x][animaux[i].y]+2;
				}
				else
					//matrice[animaux[i].x][animaux[i].y]=3;
					matrice[animaux[i].x][animaux[i].y]=matrice[animaux[i].x][animaux[i].y]+3;
			}
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