//thomas



public class Terrain{
	private int size_x;
	private int size_y;
	private int altitude;   //doit être pair
	private int f;          //facteur de marge (f*altitude)
	private int x_haut;
	private int y_haut;
	
	private int[][] terrain;
	private int[][] environnement;
	
	public Terrain(int sx, int sy, int alt){
		size_x = sx;
		size_y = sy;
		altitude = alt;
		f = 2;
		terrain = new int[size_x][size_y];
		environnement = new int[size_x][size_y];
	}
	

		public Terrain(int s, int alt){
		this(s,s,alt);
	}


	//initialiser à zéro
	public void init(){
		for(int j=0; j<size_y; j++){
			for(int i=0; i<size_x; i++){
				terrain[i][j]= 0;
				environnement[i][j]= 0;
			}
		}
	}
	
	//génération d'un point haut, à bonne distance des bordures
	public void pointHaut(){
		double p=0.001;	
		
		for(;;){
			for(int j = altitude*f; j<size_y-(altitude*f);j++){
				for(int i = altitude*f; i<size_x-(altitude*f); i++){
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
		for(int j=0; j<size_y; j++){
			for(int i=0; i<size_x; i++){
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
		for(int j=0; j<size_y; j++){
			for(int i=0; i<size_x; i++){
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
		for(int j=0; j<size_y; j++){
			for(int i=0; i<size_x; i++){
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
		
		for(int t = 0; t < altitude; t++){
			for(int j=0; j < size_y; j++){
				for(int i=0; i < size_x; i++){
					
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
						terrain[i][j]=altitude-t;
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
	
	public void ajoutArbres(){
		double probarbre = 0.3;
		
		for(int j=0; j < size_y; j++){
			for(int i=0; i < size_x; i++){
				if((terrain[i][j]<altitude-2)&&(Math.random()<probarbre)){
					
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
		return size_x;
	}
	int getSizeY(){
		return size_y;
	}
	
	
	int[][] getTerrain(){
		return terrain;
	}
	
	int[][] getEnvironnement(){
		return environnement;
	}
	
	
	
	
	
	
	
	
	

//end	
}