public abstract class Agent {
	
	boolean alive;
	int state; //etat (poursuite /fuite/attente...)
	int orientation; //1=N, 2=0, 3=S, 4=E (sens trigo)
	int x,y;
	int energy;
	int last;
	boolean mechant;
	int [] goal; //fixe
	int id;
	static int cpt = 0;
	int proie;
	int activite;
	
	/* METHODES SPECIFIQUES A UN DES 2 AGENTS */

	public void refreshGoal(Agent[] animaux,int id){}
	
	public void loupMange(Agent[] animaux){}
	//mouton
	public void moutonMange(int[][] environnement){}
	//MODIFIED
	public void estChasse(int x,int y){}
	public void fuite(Agent[] animaux, int[][]environnement, int terrain[][]){}
	
	
/* METHODES ABSTRACT COMMUNES AUX AGENTS */
public abstract void changeArea(int[][] environnement);
public abstract void nourri();
public abstract void chasse(Agent[] animaux,int[][] environnement, int[][] terrain);
public abstract void aFaim( int[][] environnement,Agent[] animaux);
public abstract void step2(int[][] environnement, int[][] terrain, Agent[] animaux);
public abstract int findGoal(int[][] environnement,Agent[] animaux);



	public Agent(int x, int y,boolean mechant){
		this.x=x;
		this.y=y;
		this.orientation=(int) (1+(Math.random()*4));;
		this.energy=Glob.maxEnergy; //max energy
		this.last=0; //somme des 2 dernieres orientations
		this.alive=true;
		this.state=1;
		this.mechant=mechant;
		this.goal = new int[2];
		this.activite=1;
		goal[0]=-1;
		goal[1]=-1;
		this.id = cpt;
		cpt++;
		proie=-1;
		
	}

		
	public int concateneMoiCa(){
		
		int infos;
		
		if(mechant){infos=2000;}
		else{infos=1000;}
		
		infos+=(100*orientation);
		infos+=(10*state);
		infos+=(activite);
		
		return infos;
	}
	
	
	public void vieux(){
		if (energy<0)
			meurs();
	}
	
	public void meurs(){ 
		state=0;
		energy=Glob.maxEnergy;
		alive=false;
		id=-1;
		//MODIFIED
		proie=-1;
	}
	
		//ces deux steps sont communs aux moutons et aux loups
		public void step0(int[][] environnement, Agent[] animaux){
			double x=Math.random();
			if(x<0.3){
				state=1;
			}
			else{
				if(x<0.5){
					orientation=(int) ((Math.random()*4)+1);
				}
			}

		}

		public void step1(int[][] environnement,int[][] terrain, Agent[] animaux){
				
			if(Math.random()<0.2){
				state=0;
			}	
				//System.out.println("deplacement random");
				moveRand(animaux,environnement,terrain);
				if(Math.random()>0.5){
					state=0;
				}	
		}
		
		
		
		//est utilisé dans step1 commune aux 2 animaux crée des trajectoires "realistes"
		public  void moveRand(Agent[] animaux, int[][]environnement, int[][ ] terrain){
			
			int o;
			
			if(Math.random()>0.4)
				o=orientation;
			else
				if(Math.random()<0.5)
					o= 1+((4+1+(orientation-1))%4); //1+(orientation - 1)%4;
				else
					o=  1+((4-1+(orientation-1))%4);//1+(orientation + 1)%4;
			
			
			conditions(animaux,environnement,terrain,o);
	}
	
		//condition utilise toutes les fonctions ci dessous elle essaye de traiter l'orientation désirée tout en gerant les priorités des evitements
		public void conditions(Agent[] animaux, int[][] environnement, int[][] terrain,int o){
			//System.out.println("je me deplace");
			if(climb(terrain, environnement)==1){return;}
			
			
			if(state!=2 || mechant==false){o=eviteAgent(animaux,o);}
			
		o=eviteMer(terrain,o);
		o=eviteMer(terrain,o);
					
			if(eviteArbre(environnement,o,0)==1)
				return;
			if(eviteBord(o)==1){
				return;
			}	
			oToxy(o);
			return;
		}
	
		public int eviteBord(int o){
			//System.out.println("bord x="+x+" y="+y);
			if((x>=Glob.size_x-1)&&(o==4)){
				//System.out.println("youpi evite bord droit");
				x--;
				orientation=2;

				return 1;
			}
			else if((x<=0)&&(o==2)){
				//System.out.println("youpi evite bord gauche");
				x++;
				orientation=4;

				return 1;
			}
			else if((y<=0)&&(o==1)){
				//System.out.println("youpi evite bord haut");
				y++;
				orientation=3;
				return 1;
			}
			else if((y>=Glob.size_y-1)&&(o==3)){
				//System.out.println("youpi evite bord bas");
				y--;
				orientation=1;
				return 1;
			}
			else{
				return 0;
			}
		}
	
public void oToxy(int o){
			System.out.println("normal"+" x="+x+" y="+y);
			switch(o){
			case 0:
				orientation=(int)(( Math.random()*4)+1);
			case 1:
				y--;
				orientation=o;
				break;
			case 2:
				x--;
				orientation=o;
				break;
			case 3:
				y++;
				orientation=o;
				break;
			case 4:
				x++;
				orientation=o;
				break;
			default:
			}
		}
	
		public int eviteAgent(Agent[] animaux,int o){
			System.out.println("agent"+" x="+x+" y="+y);

			for(int i=0;i<Glob.nagents;i++){
				switch(o){
				
				case(1):
					if(y-2>=0){
						if((animaux[i].x==x)&&((animaux[i].y==y-1)||(animaux[i].y==y-2))){
							if(Math.random()>0.5){
								return 2;
							}
							else{
								return 4;
							}
						}
						else if(x+1<Glob.size_x)
							if((animaux[i].x==x-1)&&(animaux[i].y==y-1)){return 4;}
							else if (x-1>=0)
								if((animaux[i].x==x+1)&&(animaux[i].y==y-1)){return 2;}
					}
						break;
					
				case(2):
					if(x-2>=0){
						if((animaux[i].y==y)&&((animaux[i].x==x-1)||(animaux[i].x==x-2))){
							if(Math.random()>0.5){
								return 1;
							}
							else{
								return 3;
							}
						}
						else if((y+1)<Glob.size_y)
							if((animaux[i].y==y-1)&&(animaux[i].x==x-1)){return 3;}
						else if ((y-1)>=0)
							if ((animaux[i].y==y+1)&&(animaux[i].x==x-1)){return 1;}
				}
					break;			
					
				case(3):
					if(y+2<Glob.size_y){
						if((animaux[i].x==x)&&((animaux[i].y==y+1)||(animaux[i].y==y+2))){
							if(Math.random()>0.5){
								return 2;
							}
							else{
								return 4;
							}
						}
						else if(x+1<Glob.size_x)
							if ((animaux[i].x==x-1)&&(animaux[i].y==y+1)){return 4;}
						else if(x-1>=0)
							if ((animaux[i].x==x+1)&&(animaux[i].y==y+1)){return 2;}	
				}
					break;
					
				case(4):
					
					if(x+2<Glob.size_x){
						if((animaux[i].y==y)&&((animaux[i].x==x+1)||(animaux[i].x==x+2))){
							if(Math.random()>0.5){
								return 1;
							}
							else{
								return 3;
							}
						}
						else if (y+1 <Glob.size_y)
							if ((animaux[i].y==y-1)&&(animaux[i].x==x+1)){return 3;}
						else if(y-1>=0)
							if ((animaux[i].y==y+1)&&(animaux[i].x==x+1)){return 1;}
				}
					break;
				default:
					return o;
				}
				
			}
			return o;
		}
		public int eviteMer(int[][] environnement, int o){
			
			System.out.println("mer"+" x="+x+" y="+y);

		
			switch(o){
			
				case 1 :
					
					if(y-1>0){
						//si la case au dessus est un arbre
						if(environnement[x][y-1]==-1){
							if(Math.random()>0.5)
								return 2;
							return 3;
						}
					}
				
					break;
					
				case 2 :
					if(x-1>0){
						if(environnement[x-1][y]==-1){
							if(Math.random()>0.5)
								return 3;
							return 4;
						}
					}
					
				break;
				
				case 3 :
					
					if(y+1<Glob.size_y){
						if(environnement[x][y+1]==-1){
							if(Math.random()>0.5)
								return 4;
							return 2;
						}	

					}
				
				break;
				
				case 4 :
					if(x+1<Glob.size_x){
						if(environnement[x+1][y]==-1){
							if(orientation%2==1) 
								if(Math.random()>0.5)
									return 1;
								return 3;
						}	

					}
					
				break;

			}
			
			return o;
		}
				public int eviteArbre(int[][] environnement, int o, int essai){
			
			System.out.println("arbre"+" x="+x+" y="+y);
			if(essai>5) {
				orientation = (int) ((Math.random()*4)+1);
				return 1;
			}
		
			switch(o){
			
				case 1 :
					
					if(y-1>0){
						//si la case au dessus est un arbre
						if((environnement[x][y-1]>=40)&&(environnement[x][y-1]<=42)){
							//si son orientation courante est droite ou gauche : il doit continuer dans ce sens
							if(orientation%2==0)
								return eviteArbre(environnement,orientation,essai+1);
							//sinon on essaie une autre direction
							else 
								return eviteArbre(environnement, (int) ((Math.random()*4)+1), essai+1);
						}
						//sinon, il y va
						else{
							y--;
							orientation=1;
							return 1;
						}
					}
				
					break;
					
				case 2 :
					if(x-1>0){
						if((environnement[x-1][y]>=40)&&(environnement[x-1][y]<=42)){
							if(orientation%2==1) 
								return eviteArbre(environnement,orientation,essai+1);
							else 
								return eviteArbre(environnement, (int) ((Math.random()*4)+1), essai+1);
						}	
						else{
							x--;
							orientation=2;
							return 1;
						}
					}
					
				break;
				
				case 3 :
					
					if(y+1<Glob.size_y){
						if((environnement[x][y+1]>=40)&&(environnement[x][y+1]<=42)){
							if(orientation%2==0) 
								return eviteArbre(environnement,orientation,essai+1);
							else 
								return eviteArbre(environnement, (int) ((Math.random()*4)+1), essai+1);
						}	
						else{
							y++;
							orientation=3;
							return 1;
						}
					}
				
				break;
				
				case 4 :
					if(x+1<Glob.size_x){
						if((environnement[x+1][y]>=40)&&(environnement[x+1][y]<=42)){
							if(orientation%2==1) 
								return eviteArbre(environnement,orientation,essai+1);
							else 
								return eviteArbre(environnement, (int) ((Math.random()*4)+1), essai+1);
						}	
						else{
							x++;
							orientation=4;
							return 1;
						}
					}
					
				break;

			}
			
			return 0;

		}
		/*
	public int eviteBord(int o){
			System.out.println("bord"+" x="+x+" y="+y);
			if((x==Glob.size_x-1)&&(o==4)){
				//System.out.println("youpi evite bord droit");
				if(Math.random()>0.5)
					return 1;
				return 3;
			}
			else if((x==0)&&(o==2)){
			
				//System.out.println("youpi evite bord gauche");
				if(Math.random()>0.5)
					return 1;
				return 3;
			}
			else if((y==0)&&(o==1)){
			
				//System.out.println("youpi evite bord haut");
				if(Math.random()>0.5)
					return 2;
				return 4;
			}
			else if((y==Glob.size_y-1)&&(o==3)){
			
				//System.out.println("youpi evite bord bas");
				if(Math.random()>0.5)
					return 2;
				return 4;
			}
			else{
				return o;
			}
		}
 */
		public int climb(int[][] terrain, int[][] environnement){
			System.out.println("strate"+"x="+x+" y="+y);
			if(((orientation==2)&&(terrain[x][y]==23))||((orientation==4)&&(terrain[x][y]==27))){ //2 cas ou il faut "monter"
				
				if((y-1)>0 && environnement[x][y-1]==0){
					y--;//pas de verification sur les arbres, il n'y a pas d'arbres sur les tranches
					return 1;
				}
			}
			if(((orientation==2)&&(terrain[x][y]==27))||((orientation==4)&&(terrain[x][y]==23))){ //2 cas ou il faut "descendre
				
				if((y+1)<(Glob.size_y-1) && environnement[x][y+1]==0){
					y++;
					return 1;
				}
			}
			return 0;
	}

		public int teleport(int[][] environnement,int x, int y){
			if(environnement[x][y]!=30 && environnement[x][y]!=31){
				this.x=x;
				this.y=y;
				return 1;
			}
			return 0;
		}

}
