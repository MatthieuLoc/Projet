//thomas



public class Terrain{
  //doit être pair
	private int f;          //facteur de marge (f*Glob.hauteur)
	private int x_haut;
	private int y_haut;
	
	private int[][] terrain;
	private int[][] environnement;
	
	public Terrain(){

		f = 2;
		terrain = new int[Glob.size_x][Glob.size_y];
		environnement = new int[Glob.size_x][Glob.size_y];
	}
	


	//initialiser à zéro
	public void init(){
		for(int j=0; j<Glob.size_y; j++){
			for(int i=0; i<Glob.size_x; i++){
				terrain[i][j]= 0;
				environnement[i][j]= 0;
			}
		}
	}
	
	//génération d'un point haut, à bonne distance des bordures
	public void pointHaut(){
		double p=0.001;	
		
		for(;;){
			for(int j = Glob.hauteur*f; j<Glob.size_y-(Glob.hauteur*f);j++){
				for(int i = Glob.hauteur*f; i<Glob.size_x-(Glob.hauteur*f); i++){
					if (p >= Math.random()){
						
						terrain[i][j]=0;
						x_haut = i;
						y_haut = j;
						
						return;
					}
				}
			}
		}
	}
	
	//affichage des valeurs de terrain
	public String toString(){
		String s = "";
		for(int j=0; j<Glob.size_y; j++){
			for(int i=0; i<Glob.size_x; i++){
				s += terrain[i][j] + " ";
			}
			s += "\n";
		}
		
		return s;
	}
	/*
	//pour visualiser les strates
	public String toString2(){
		String s="";
		for(int j=0; j<Glob.size_y; j++){
			for(int i=0; i<Glob.size_x; i++){
				if(terrain[i][j]==0){
					s += "- ";
				}
				if(terrain[i][j]>=20){
					s += "* ";
				}
			}
			s += "\n";
		}
		return s;
	}
	*/
	//pour visualiser la répartitions des arbres
	public String toString3(){
		String s="";
		for(int j=0; j<Glob.size_y; j++){
			for(int i=0; i<Glob.size_x; i++){
				if(environnement[i][j]==0){
					s += "- ";
				}
				if(environnement[i][j]!=0){
					s += "* ";
				}
			}
			s += "\n";
		}
		return s;
	}
	
	
	public void strates(){
		int x1 = 2;
		int x2 = 2;
		int y1 = 2;
		int y2 = 2;
		
		for(int t = 0; t < Glob.hauteur; t++){
			for(int j=0; j < Glob.size_y; j++){
				for(int i=0; i < Glob.size_x; i++){
					
					// coins
					if((i==x_haut-x1)&&(j==y_haut+y2)){
						terrain[i][j]=  20;
					}
					else if((i==x_haut+x2)&&(j==y_haut+y2)){
						terrain[i][j]=  22;
					}
					else if((i==x_haut+x2)&&(j==y_haut-y1)){
						terrain[i][j]=  24;
					}
					else if((i==x_haut-x1)&&(j==y_haut-y1)){
						terrain[i][j]=  26;
					}
					
					// bordures
					else if((j==y_haut+y2)&&(i>x_haut-x1)&&(i<x_haut+x2)){
						terrain[i][j]= 21;
					}
					else if((i==x_haut+x2)&&(j>y_haut-y1)&&(j<y_haut+y2)){
						terrain[i][j]= 23;
					}
					else if((j==y_haut-y1)&&(i>x_haut-x1)&&(i<x_haut+x2)){
						terrain[i][j]= 25;
					}
					else if((i==x_haut-x1)&&(j>y_haut-y1)&&(j<y_haut+y2)){
						terrain[i][j]= 27;
					}
					
					// plateau
					else if((j>y_haut-y1)&&(j<y_haut+y2)&&(i<x_haut+x2)&&(i>x_haut-x1)&&(terrain[i][j]==0)){
						terrain[i][j]=Glob.hauteur-t;
					}
				}
			}
			
			//distance entre chaque bord du plateau par rapport à son précédent
			x1+=4+(int)(Math.random()*4);
			x2+=4+(int)(Math.random()*4);
			y1+=4+(int)(Math.random()*4);
			y2+=4+(int)(Math.random()*4);
		}
		
	}
	
	public void ajoutArbresRand(){
		double probarbre = 0.4;
		
		for(int j=0; j < Glob.size_y; j++){
			for(int i=0; i < Glob.size_x; i++){
				if((terrain[i][j]<Glob.hauteur-2)&&(Math.random()<probarbre)){
					
					//2 types d'arbres, une chance sur 2
					if(Math.random()<0.5){
						environnement[i][j]=31;
					}
					else{
						environnement[i][j]=30;
					}
					
				}
			}
		}
	}
	
	
	/* --- méthodes GET --- */
	
	int getSizeX(){
		return Glob.size_x;
	}
	int getSizeY(){
		return Glob.size_y;
	}
	
	
	int[][] getTerrain(){
		return terrain;
	}
	
	int[][] getEnvironnement(){
		return environnement;
	}
	
	
	

public void ajoutArbres(){
		int nbforets =0; //(int) ((Math.random()*4)+1);
		int etendue = 30; // -> rendre aléatoire
		int t = 0;
		
		while(t<nbforets){
			for(int j=0; j < Glob.size_y; j++){
				for(int i=0; i < Glob.size_x; i++){
					
					//génération d'UN centre de forêt
					// -> rendre mieux réparti
					if((terrain[i][j]<Glob.hauteur)&&(terrain[i][j]>=0)&&(Math.random()<0.0001)){
						if(t==nbforets){
							return;
						}
						environnement[i][j]=30;
						
						//génération d'UNE forêt
						for(int b = ((j-etendue)>=0 ? j-etendue : 0); b < ( (j+etendue)>Glob.size_y ? Glob.size_y : j+etendue ); b++){
							for(int c = ((i-etendue)>=0 ? i-etendue : 0); c < ( (i+etendue)>Glob.size_x ? Glob.size_x : i+etendue ); c++){
								
								//distance entre le point courant et le centre de la forêt
								double dist = Math.sqrt((Math.abs(i-c)*Math.abs(i-c))+(Math.abs(j-b)*Math.abs(j-b)));
								
								//plus c'est loin du centre, plus la probabilité de pousse d'un arbre est faible
								// ici la fonction est f(x)=1-0,07x
								//j'aimerais bien un truc logarithmique ou exponentiel
								if((Math.random() < 1-(0.07*dist))&&(terrain[c][b]<10)&&(terrain[c][b]>=0)){
									
									//type d'arbre (au pif, à mieux faire)
									if(Math.random()<0.2){
										environnement[c][b]=31;
									}
									else{
										environnement[c][b]=30;
									}
								}
							}
						}

						//forêt terminée
						t ++;
					}
				}
			}
		}
	}
	
	
	
	
	
	

//end	
}