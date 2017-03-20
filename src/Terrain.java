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
		int x1 = 0;
		int x2 = 0;
		int y1 = 0;
		int y2 = 0;
		
		int strate1[][] = {{26,27,27,20},{25,Glob.hauteur,Glob.hauteur,21},{25,Glob.hauteur,Glob.hauteur,21},{24,23,23,22}};
		
		for(int j=0;j<4;j++){
			for(int i=0;i<4;i++){
				terrain[x_haut+i][y_haut+j] = strate1[i][j];
			}
		}
		
		int x28 = 2;
		int y28 = 2;
		int x29 = 2;
		int y29 = 2;
		int x30 = 2;
		int y30 = 2;
		int x31 = 2;
		int y31 = 2;
		
		for(int t = 0; t < 4; t++){
			
			x28 += 2;//+(int)(Math.random()*2);
			y28 += 2;//+(int)(Math.random()*2);
			x29 += 2;//+(int)(Math.random()*2);
			y29 += 2;//+(int)(Math.random()*2);
			x30 += 2;//+(int)(Math.random()*2);
			y30 += 2;//+(int)(Math.random()*2);
			x31 += 2;//+(int)(Math.random()*2);
			y31 += 2;//+(int)(Math.random()*2);
			
			//extrémités de la strate
			x1=Math.max(x28, x31)+2;//(int)(Math.random()*4);
			x2=Math.max(x29, x30)+2;//(int)(Math.random()*4);
			y1=Math.max(y31, y30)+2;//(int)(Math.random()*4);
			y2=Math.max(y28, y29)+2;//(int)(Math.random()*4);
			
			for(int j=0; j < Glob.size_y; j++){
				for(int i=0; i < Glob.size_x; i++){
					
					// bordures
					if(((j==y_haut+y2)&&(i>x_haut-x28)&&(i<x_haut+x29))
						||((j==y_haut+y28)&&(i>x_haut-x1)&&(i<x_haut-x28))
						||((j==y_haut+y29)&&(i>x_haut+x29)&&(i<x_haut+x2))){
						terrain[i][j]= 21;
					}
					else if(((i==x_haut+x2)&&(j>y_haut-y30)&&(j<y_haut+y29))
							||((i==x_haut+x30)&&(j>y_haut-y1)&&(j<y_haut-y30))
							||((i==x_haut+x29)&&(j>y_haut+y29)&&(j<y_haut+y2))){
						terrain[i][j]= 23;
					}
					else if(((j==y_haut-y1)&&(i>x_haut-x31)&&(i<x_haut+x30))
							||((j==y_haut-y31)&&(i>x_haut-x1)&&(i<x_haut-x31))
							||((j==y_haut-y30)&&(i>x_haut+x30)&&(i<x_haut+x2))){
						terrain[i][j]= 25;
					}
					else if(((i==x_haut-x1)&&(j>y_haut-y31)&&(j<y_haut+y28))
							||((i==x_haut-x31)&&(j>y_haut-y1)&&(j<y_haut-y31))
							||((i==x_haut-x28)&&(j>y_haut+y28)&&(j<y_haut+y2))){
						terrain[i][j]= 27;
					}
					
					//coins 
					if((i==x_haut)&&(j==y_haut)){
						//coins rentrants
						if(((i-x28)>=0)&&((j+y28)<Glob.size_y)){
							terrain[i-x28][j+y28]=28;
						}
						if(((i+x29)<Glob.size_x)&&((j+y29)<Glob.size_y)){
							terrain[i+x29][j+y29]=29;
						}
						if(((i+x30)<Glob.size_x)&&((j-y30)>=0)){
							terrain[i+x30][j-y30]=30;
						}
						if(((i-x31)>=0)&&((j-y31)>=0)){
							terrain[i-x31][j-y31]=31;
						}
						//coins 20
						if(((i-x1)>=0)&&((j+y28)<Glob.size_y)){
							terrain[i-x1][j+y28]=20;
						}
						if(((i-x28)>=0)&&((j+y2)<Glob.size_y)){
							terrain[i-x28][j+y2]=20;
						}
						//coins 22
						if(((i+x2)<Glob.size_x)&&((j+y29)<Glob.size_y)){
							terrain[i+x2][j+y29]=22;
						}
						if(((i+x29)<Glob.size_x)&&((j+y2)<Glob.size_y)){
							terrain[i+x29][j+y2]=22;
						}
						//coins 24
						if(((i+x2)<Glob.size_x)&&((j-y30)>=0)){
							terrain[i+x2][j-y30]=24;
						}
						if(((i+x30)<Glob.size_x)&&((j-y1)>=0)){
							terrain[i+x30][j-y1]=24;
						}
						//coins 26
						if(((i-x1)>=0)&&((j-y31)>=0)){
							terrain[i-x1][j-y31]=26;
						}
						if(((i-x31)>=0)&&((j-y1)>=0)){
							terrain[i-x31][j-y1]=26;
						}
					}
					
					
					
				}
			}
			
			//distance entre chaque bord du plateau par rapport à son précédent
			x1+=2+(int)(Math.random()*5);
			x2+=2+(int)(Math.random()*5);
			y1+=2+(int)(Math.random()*5);
			y2+=2+(int)(Math.random()*5);
		}
		
}
	
	/*
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
	
	*/
	

	/*
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
	*/

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
	
	

	public void refreshArbres(){
		int [][] environnementbis = new int[Glob.size_x][Glob.size_y];
		for(int j=0; j < Glob.size_y; j++){
			for(int i=0; i < Glob.size_x; i++){
				//copie
				environnementbis[i][j]=environnement[i][j];
				//départ de feu
				if(((environnement[i][j]==40)||(environnement[i][j]==41))&&(Math.random()<0.00008)){
					environnementbis[i][j]=42;
				}
				if(((environnement[i][j]==40)||(environnement[i][j]==41))
						&&((environnement[((i-1)<0?0:(i-1))][j]==42)||(environnement[i][((j-1)<0?0:(j-1))]==42)
						||(environnement[((i+1)<Glob.size_x?(i+1):Glob.size_x-1)][j]==42)||(environnement[i][((j+1)<Glob.size_y?(j+1):Glob.size_y-1)]==42))
						&&(Math.random()<0.5)){
					environnementbis[i][j]=42;
				}
				if((environnement[i][j]==42)){
					environnementbis[i][j]=43;
				}
				if((environnement[i][j]==43)){
					if(Math.random()<0.005)
						environnementbis[i][j]=44;
				}
			}
		}
		environnement = environnementbis;
	}

	public void ajoutArbres(){

		int etendue = 30;
		int t = 0;
		int nbforets = 6;
		
		while(t<nbforets){
			for(int j=0; j < Glob.size_y; j++){
				for(int i=0; i < Glob.size_x; i++){
					
					//génération d'UN centre de forêt
					if((terrain[i][j]<Glob.hauteur)&&(terrain[i][j]>=0)&&(Math.random()<0.0001)){
						if(t==nbforets){
							return;
						}
						//génération d'UNE forêt
						for(int b = ((j-etendue)>=0 ? j-etendue : 0); b < ( (j+etendue)>Glob.size_y ? Glob.size_y : j+etendue ); b++){
							for(int c = ((i-etendue)>=0 ? i-etendue : 0); c < ( (i+etendue)>Glob.size_x ? Glob.size_x : i+etendue ); c++){
								
								//distance entre le point courant et le centre de la forêt
								double dist = Math.sqrt((Math.abs(i-c)*Math.abs(i-c))+(Math.abs(j-b)*Math.abs(j-b)));
								
								//plus c'est loin du centre, plus la probabilité de pousse d'un arbre est faible
								if((Math.random() < 1-(0.07*dist))&&(terrain[c][b]<10)&&(terrain[c][b]>=0)){
									
									//type d'arbre
									if(Math.random()<0.2){
										environnement[c][b]=41;
									}
									else{
										environnement[c][b]=40;
									}
								}
							}
						}
						
						t ++;
					}
				}
			}
		}
	}
	
	
	
	

//end	
}