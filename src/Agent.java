
public abstract class Agent {
	
	boolean alive;
	int state; //etat (poursuite /fuite/attente...)
	int orientation; //1=N, 2=0, 3=S, 4=E (sens trigo)
	int x,y;
	int energy;
	int last;
	boolean mechant;
	int gardeRecursion=0;



	public Agent(int x, int y,boolean mechant){
		this.x=x;
		this.y=y;
		this.orientation=0;
		this.energy=Glob.maxEnergy; //max energy
		this.last=0; //somme des 2 dernieres orientations
		this.alive=true;
		this.state=0; //etat 1 en chasse 
		this.mechant=mechant;
		
	}
	

	public abstract void lowerEnergy();
	public abstract void nourri();
	
	//reset les parametres de l'annimal, mets son energie à max (commun aux deux)
	public void meurs(){
		
		state=0;
		energy=Glob.maxEnergy; //remet a max (pour etre pret pour le revival)
		alive=false;
	}
	
	//decalage lors d'escalade d'une strate
	public void climb(int[][] terrain){
		
			if(((orientation==2)&&(terrain[x][y]==23))||((orientation==4)&&(terrain[x][y]==27))){ //2 cas ou il faut "monter"
				
				if((y-1)>0){
					y--;//pas de verification sur les arbres, il n'y a pas d'arbres sur les tranches
				}
			}
			if(((orientation==2)&&(terrain[x][y]==27))||((orientation==4)&&(terrain[x][y]==23))){ //2 cas ou il faut "descendre
				
				if((y+1)<(Glob.size_y-1)){
					y++;
				}
			}
	}
	
	//place l'animal a l'endroit desire retourne 1 si il n'y a pas d'arbre à l'endroit voulu
	public int teleport(int[][] environnement,int x, int y){
		if(environnement[x][y]!=40 && environnement[x][y]!=41){
			this.x=x;
			this.y=y;
			return 1;
		}
		return 0;
	}

	//deplace l'animal d'une case selon l'orientation donnée, evite les arbres et les bordures
	public void move(int[][] environnement,int o){
		
		if(gardeRecursion>8){//cette variable permet d'arreter la récursion au bout de 6 appels (si un animal est bloqué
			o=0;
		}
		switch(o){
		
		case(1):
			if(y==0){
				move(environnement,3);
				gardeRecursion++;
			}
			else{
				if(environnement[x][y-1] !=40 && environnement[x][y-1] !=41){
					y--;
					orientation=o;
					gardeRecursion=0;
				}
				else{
					gardeRecursion++;
						move(environnement,o+1);
				}
			}
		break;
		case(2):
			if(x==0){
				gardeRecursion++;
				move(environnement,4);
				
			}
			else{
				if(environnement[x-1][y] !=40 && environnement[x-1][y] !=41){
					x--;
					orientation=o;
					gardeRecursion=0;
				}
				else{
					gardeRecursion++;
						move(environnement,o+1);	
				}
			}
		break;
		case(3):
			if(y==(Glob.size_y-1)){
				gardeRecursion++;
				move(environnement,1);
			}
			else{
				if(environnement[x][y+1] !=40 && environnement[x][y+1] !=41){
					y++;
					orientation=o;
					gardeRecursion=0;
				}
				else{
					gardeRecursion++;
						move(environnement,o+1);
				}
			}
		break;
		case(4):
			if(x==(Glob.size_x-1)){
				gardeRecursion++;
				move(environnement,2);
			}
			else{
				if(environnement[x+1][y] !=40 && environnement[x+1][y] !=41){
					x++;
					orientation=o;
					gardeRecursion=0;

				}
				else{
					gardeRecursion++;
						move(environnement,o+1);
				}
			}
		break;
		default:
		}
		
	}

	//tire une orientation aleatoire et la passe a move
	public  void moveRand(int[][]environnement){
		int o;

			o=(int)((Math.random()*4)+1);

		
		move(environnement,o);
}




}

