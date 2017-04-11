//thomas



public class Terrain{
 
	private int x_haut;
	private int y_haut;
	private int[] vent;
	
	private int[][] terrain;
	private int[][] environnement;
	
	public Terrain(){
		terrain = new int[Glob.size_x][Glob.size_y];
		environnement = new int[Glob.size_x][Glob.size_y];
		
		vent = new int[2];
		//orientation, peut valoir 0, 1, 2, 3
		vent[0] = (int)((Math.random()*4));
		//force
		vent[1] = (int)((Math.random()*10));
	}
	


	//initialiser à zéro terrain ET environnement
	public void init(){
		for(int j=0; j<Glob.size_y; j++){
			for(int i=0; i<Glob.size_x; i++){
				terrain[i][j]= 0;
				environnement[i][j]= 0;
			}
		}
	}
	
	//génération d'un point haut
		public void pointHaut(){
			x_haut = (int)((Math.random()*Glob.size_x));
			y_haut = (int)((Math.random()*Glob.size_y));
			terrain[x_haut][y_haut]=0;
			System.out.println(x_haut);
			System.out.println(y_haut);
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
		
		// m pour memoire
		int m_x1 = x1;
		int m_x2 = x2;
		int m_y1 = y1;
		int m_y2 = y2;
		
		int strate1[][] = {{26,27,27,20},{25,Glob.hauteur,Glob.hauteur,21},{25,Glob.hauteur,Glob.hauteur,21},{24,23,23,22}};
		
		for(int j=0;j<4;j++){
			for(int i=0;i<4;i++){
				//la plus haute strate peut depasser des limites de l'environnement, mais ne sera pas affichée
				if((x_haut-1+i>=0)&&(x_haut-1+i<=Glob.size_x-1)&&(y_haut-1+j>=0)&&(y_haut-1+j<=Glob.size_y-1))
					terrain[x_haut-1+i][y_haut-1+j] = strate1[i][j];
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
		
		// m pour memoire
		int m_x28 = x28;
		int m_y28 = y28;
		int m_x29 = x29;
		int m_y29 = y29;
		int m_x30 = x30;
		int m_y30 = y30;
		int m_x31 = x31;
		int m_y31 = y31;
		
		for(int h = 1; h < Glob.hauteur; h++){
			
			do{
			x28 = 2+(int)(Math.random()*5*h);
			y28 = 2+(int)(Math.random()*5*h);
			}while(!(((x28>x1)&&(y28<m_y28))||((x28>m_x28)&&(y28>m_y28))||((x28<m_x28)&&(y28>y2))));
			m_x28=x28;
			m_y28=y28;
			
			do{
			x29 = 2+(int)(Math.random()*5*h);
			y29 = 2+(int)(Math.random()*5*h);
			}while(!(((x29>x2)&&(y29<m_y29))||((x29>m_x29)&&(y29>m_y29))||((x29<m_x29)&&(y29>y2))));
			m_x29=x29;
			m_y29=y29;
			
			do{
			x30 = 2+(int)(Math.random()*5*h);
			y30 = 2+(int)(Math.random()*5*h);
			}while(!(((x30>x2)&&(y30<m_y30))||((x30>m_x30)&&(y30>m_y30))||((x30<m_x30)&&(y30>y1))));
			m_x30=x30;
			m_y30=y30;
			
			do{
			x31 = 2+(int)(Math.random()*5*h);
			y31 = 2+(int)(Math.random()*5*h);
			}while(!(((x31>x1)&&(y31<m_y31))||((x31>m_x31)&&(y31>m_y31))||((x31<m_x31)&&(y31>y1))));
			m_x31=x31;
			m_y31=y31;
			
			//extrémités de la strate
			
			//x1
			x1=Math.max(Math.max(x28, x31), m_x1)+2+(int)(Math.random()*2);
			
			//x2
			x2=Math.max(Math.max(x29, x30),m_x2)+2+(int)(Math.random()*2);
			
			//y1
			y1=Math.max(Math.max(y31, y30),m_y1)+2+(int)(Math.random()*2);
			
			//y2
			y2=Math.max(Math.max(y28, y29),m_y2)+2+(int)(Math.random()*2);
			
			m_x1 = x1;
			m_x2 = x2;
			m_y1 = y1;
			m_y2 = y2;
			
				for(int j=0; j < Glob.size_y; j++){
					for(int i=0; i < Glob.size_x; i++){
						
						// plateaux
						if((terrain[i][j]==0)&&(i>x_haut-x1)&&(i<x_haut+x2)
								&&(j>y_haut-y1)&&(j<y_haut+y2)){
							terrain[i][j]= Glob.hauteur - h;
						}
						
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
						/*
						else{
							terrain[i][j]= Glob.hauteur-h;
						}
						*/
						
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
			}
		
		System.out.println(toString());

	}
	
	public void mer(){
		
		int y_mer = (int)(Math.random()*Glob.size_y);
		System.out.println("y_mer : "+y_mer);
		int etendue = 30;
		int crt=1;
		
		//montagne à droite, mer à gauche
		if(x_haut>Glob.size_x/2){
			for(int j = (y_mer-etendue)>=0 ? y_mer-etendue : 0 ; j<Glob.size_y; j++){
				for(int i=0; i<etendue; i++){
					
					if(Math.random()<0.7){
						if(j<y_mer){
							if(Math.random()<0.5){
								crt ++;
							}
						}
						else {
							if(crt >= 0){
								if(Math.random()<0.5){
									crt --;
								}
							}
						}
					}
					
					if((terrain[i][j]==0)&&(terrain[i+1][j]==0)&&(terrain[i+2][j]==0)&&(i<=crt)){
						terrain[i][j]=-1;
					}
				}
			}
			
		}
		//si la montagne est à gauche
		else{
			for(int j = (y_mer-etendue)>=0 ? y_mer-etendue : 0 ; j<Glob.size_y; j++){
				for(int i=Glob.size_x-1; i>Glob.size_x-etendue; i--){
					System.out.println("i : "+i);
					if(Math.random()<0.7){
						if(j<y_mer){
							if(Math.random()<0.5){
								crt ++;
							}
						}
						else {
							if(crt >= 0){
								if(Math.random()<0.5){
									crt --;
								}
							}
						}
					}
				
					if((terrain[i][j]==0)&&(terrain[i-1][j]==0)&&(terrain[i-2][j]==0)&&(i>=Glob.size_x-crt)){
						terrain[i][j]=-1;
					}
				}
			}
			
		}
		System.out.println(toString());
	}
	

	public void ajoutArbres(){

		int etendue = 30; // -> rendre aléatoire
		int t = 0;
		
		while(t<Glob.nforets){
			for(int j=0; j < Glob.size_y; j++){
				for(int i=0; i < Glob.size_x; i++){
					
					//génération d'UN centre de forêt
					// -> rendre mieux réparti
					if((terrain[i][j]<Glob.hauteur)&&(terrain[i][j]>=0)&&(Math.random()<0.0001)){
						if(t==Glob.nforets){
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
										environnement[c][b]=41;
									}
									else{
										environnement[c][b]=40;
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
	
	
	public void ajoutHerbe(){
		
		int etendue = 30;
		int t = 0;
		
		while(t<Glob.nprairies){
			for(int j=0; j < Glob.size_y; j++){
				for(int i=0; i < Glob.size_x; i++){
					
					//génération d'UN centre de forêt
					if((terrain[i][j]<Glob.hauteur)&&(terrain[i][j]>=0)&&(Math.random()<0.0001)&&(terrain[i][j]<40)){
						if(t==Glob.nprairies){
							return;
						}
						//génération d'UNE forêt
						for(int b = ((j-etendue)>=0 ? j-etendue : 0); b < ( (j+etendue)>Glob.size_y ? Glob.size_y : j+etendue ); b++){
							for(int c = ((i-etendue)>=0 ? i-etendue : 0); c < ( (i+etendue)>Glob.size_x ? Glob.size_x : i+etendue ); c++){
								
								//distance entre le point courant et le centre de la forêt
								double dist = Math.sqrt((Math.abs(i-c)*Math.abs(i-c))+(Math.abs(j-b)*Math.abs(j-b)));
								
								//plus c'est loin du centre, plus la probabilité de pousse d'un arbre est faible
								if((environnement[c][b]!=40)&&(environnement[c][b]!=41)&&(environnement[c][b]!=42)&&(environnement[c][b]!=43)){
									if((Math.random() < 1-(0.07*dist))&&(terrain[c][b]<10)&&(terrain[c][b]>=0)){
										
											environnement[c][b]=45;
										
										
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
	
	public void refreshArbres(){
		int cpt;
		int [][] environnementbis = new int[Glob.size_x][Glob.size_y];
		for(int j=0; j < Glob.size_y; j++){
			for(int i=0; i < Glob.size_x; i++){
				
				cpt=0;
				
				/* FEU DE FORET */
				
				//copie
				environnementbis[i][j]=environnement[i][j];
				//départ de feu
				if(((environnement[i][j]==40)||(environnement[i][j]==41))&&(Math.random()<0.00008)){
					environnementbis[i][j]=42;
				}
				//propagation du feu de forêt : 1 chance sur 2
				if(((environnement[i][j]>=40)&&(environnement[i][j]<=41))
						&&((environnement[((i-1)<0?0:(i-1))][j]==42)||(environnement[i][((j-1)<0?0:(j-1))]==42)
						||(environnement[((i+1)<Glob.size_x?(i+1):Glob.size_x-1)][j]==42)||(environnement[i][((j+1)<Glob.size_y?(j+1):Glob.size_y-1)]==42))
						&&(Math.random()<0.5)){
					environnementbis[i][j]=42;
				}
				// devient une souche 
				if((environnement[i][j]==42)){
					environnementbis[i][j]=43;
				}
				
				/* POUSSE D'ARBRES */
				
				//nombre d'arbres voisins
				
				if(environnement[i][j]<=Glob.hauteur){
					
					if((environnement[((i-1)<0?0:(i-1))][j]>=40)&&(environnement[((i-1)<0?0:(i-1))][j]<=42))
						cpt++;
					if((environnement[i][((j-1)<0?0:(j-1))]>=40)&&(environnement[i][((j-1)<0?0:(j-1))]<=42))
						cpt++;
					if((environnement[((i+1)<Glob.size_x?(i+1):Glob.size_x-1)][j]>=40)
							&&(environnement[((i+1)<Glob.size_x?(i+1):Glob.size_x-1)][j]<=42))
						cpt++;
					if((environnement[i][((j+1)<Glob.size_y?(j+1):Glob.size_y-1)]>=40)
							&&(environnement[i][((j+1)<Glob.size_y?(j+1):Glob.size_y-1)]<=42))
						cpt++;
					
					if((cpt == 1)&&(Math.random()<0.001))
							environnementbis[i][j]=44;
					if(((cpt == 2)||(cpt == 3))&&(Math.random()<0.002))
						environnementbis[i][j]=44;
					if((cpt == 4)&&(Math.random()<0.004))
						environnementbis[i][j]=44;
				}
				
				if((environnement[i][j]==44)){
					if(Math.random()<0.005){
						if(Math.random()<0.5)
							environnementbis[i][j]=40;
						else
							environnementbis[i][j]=41;
					}
				}
			}
		}
		environnement = environnementbis;
	}
	
	public void refreshVent(){
		
		//le vent tourne
		if(Math.random()<0.05){
			if(Math.random()<0.5){
				vent[0] = (vent[0]+1)%4;
				
			}
			else{
				vent[0] = (vent[0]-1)%4;
			}
			System.out.println("orientation vent : " + vent[0]);
		}
		
		//force du vent : rafale, acalmie
		if(Math.random()<0.1){
			if(Math.random()<0.5){
				vent[1]+=(int)(Math.random()*4);
				
				//rester entre 0 et 10
				if(vent[1]>10)
					vent[1]=10;
			}
			else{
				vent[1]-=(int)(Math.random()*4);
				
				//rester entre 0 et 10
				if(vent[1]<0)
					vent[1]=0;
			}
			System.out.println("force : "+vent[1]);
			
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
	
	int[] getVent(){
		return vent;
	}
	
	

	
	
	
	

//end	
}