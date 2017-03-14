public class Terrain{
	private int width; 
	private int height;//pour le moment c'est un terrain carré de taille size
	private int altitude;   //doit être pair
	private int f;          //facteur de marge (f*altitude)
	private int x_haut;
	private int y_haut;
	
	private int[][] terrain;
	private int[][] environnement;

	
	public Terrain(int w,int h, int alt){
		width = w;
		height =h;
		altitude = alt;
		f = 2;
		terrain = new int[w][h];
		environnement = new int[w][h];
	}
	
	public Terrain(int s, int alt){
		this(s,s,alt);
	}
	
	public void init(){
		for(int i=0; i<width; i++){
			for(int j=0; j<height; j++){
				terrain[i][j]= 0;
				environnement[i][j]= 0;
				//terrain[i][j]= (int)(Math.random()*10);
			}
		}
	}
	
	
	
	
	public void pointHaut(){
		double p=0.001;	
		
		for(;;){
			for(int i = altitude*f; i<width-(altitude*f); i++){
				for(int j = altitude*f; j<height-(altitude*f);j++){
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
	
	public String toString(){
		String s = "";
		for(int i=0; i<width; i++){
			for(int j=0; j<height; j++){
				s += terrain[i][j] + "	";
			}
			s += "\n";
		}
		
		return s;
	}
	
	
	public String toString2(){
		String s="";
		for(int i=0; i<width; i++){
			for(int j=0; j<height; j++){
				if(terrain[i][j]==0){
					s += "- ";
				}
				if(terrain[i][j]!=0){
					s += "* ";
				}
			}
			s += "\n";
		}
		return s;
	}
	
	public String toString3(){
		String s="";
		for(int i=0; i<width; i++){
			for(int j=0; j<height; j++){
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
			for(int i=0; i < width; i++){
				for(int j=0; j < height; j++){
					//if(j==0){terrain[i][j]=altitude;}
					
					if(((i==x_haut-x1)||(i==x_haut+x2))&&(j>=y_haut-y1)&&(j<=y_haut+y2)){
						terrain[i][j] = altitude;
					}
					if(((j==y_haut-y1)||(j==y_haut+y2))&&(i>=x_haut-x1)&&(i<=x_haut+x2)){
						terrain[i][j] = altitude;
					}
				}
			}
			x1+=2;
			x2+=2;
			y1+=2;
			y2+=2;
		}
		
	}
	
	public void strates2(){
		int x1 = 2;
		int x2 = 2;
		int y1 = 2;
		int y2 = 2;
		
		for(int t = 0; t < altitude; t++){
			for(int i=0; i < width; i++){
				for(int j=0; j < height; j++){
					
					//coins
					if((i==x_haut+x2)&&(j==y_haut-y1)){
						terrain[i][j]=  20;
					}
					else if((i==x_haut+x2)&&(j==y_haut+y2)){
						terrain[i][j]=  22;
					}
					else if((i==x_haut-x1)&&(j==y_haut+y2)){
						terrain[i][j]=  24;
					}
					else if((i==x_haut-x1)&&(j==y_haut-y1)){
						terrain[i][j]=  26;
					}
					
					//bordures
					else if((i==x_haut+x2)&&(j>y_haut-y1)&&(j<y_haut+y2)){
						terrain[i][j]= 21;
					}
					else if((j==y_haut+y2)&&(i>x_haut-x1)&&(i<x_haut+x2)){
						terrain[i][j]= 23;
					}
					else if((i==x_haut-x1)&&(j>y_haut-y1)&&(j<y_haut+y2)){
						terrain[i][j]= 25;
					}
					else if((j==y_haut-y1)&&(i>x_haut-x1)&&(i<x_haut+x2)){
						terrain[i][j]= 27;
					}
					
					else if((j>y_haut-y1)&&(j<y_haut+y2)&&(i<x_haut+x2)&&(i>x_haut-x1)&&(terrain[i][j]==0)){
						terrain[i][j]=altitude-t;
					}
					
					
				}
			}
			
			x1+=2+(int)(Math.random()*9);
			x2+=2+(int)(Math.random()*2);
			y1+=2+(int)(Math.random()*5);
			y2+=2+(int)(Math.random()*5);
		}
		
	}
	
	public void ajoutArbres(){
		double probarbre = 0.4;
	
		for(int i=0; i < width; i++){
			for(int j=0; j < height; j++){
				if((terrain[i][j]<altitude-2)&&(Math.random()<probarbre)){
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
	
	
	int getWidth(){
		return width;
	}
	
	int getHeight(){
		return height;
	}
		
	int[][] getTerrain(){
		return terrain;
	}
	
	int[][] getEnvironnement(){
		return environnement;
	}
	
	
	
	
	
	
	
	
	
	
	
	

//end	
}