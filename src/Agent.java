
public abstract class Agent {
	
	boolean alive;
	int state; //etat (poursuite /fuite/attente...)
	int orientation; //1=N, 2=0, 3=S, 4=E (sens trigo)
	int x,y;
	int energy;
	int last;
	boolean mechant;



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
	
	public void nourri(){
		this.state=0;
		this.energy=Glob.maxEnergy;
		
	}
	
	public void meurs(){
		this.state=0;
		this.energy=Glob.maxEnergy;
		this.alive=false;
		System.out.println("mort");
	}
	
	public void climb(int[][] environnement,int[][] terrain){

			//System.out.println(terrain[x][y]);
			if(((orientation==2)&&(terrain[x][y]==23))||((orientation==4)&&(terrain[x][y]==27))){
				if((y-1)>0){
					teleport(environnement,x,(y-1));
				}
			}
			if(((orientation==2)&&(terrain[x][y]==27))||((orientation==4)&&(terrain[x][y]==23))){
				if((y+1)<(Glob.size_y-1)){
					teleport(environnement,x,(y+1));
				}
			}
	}
	
	public int teleport(int[][] environnement,int x, int y){
		if(environnement[x][y]!=30 && environnement[x][y]!=31){
			this.x=x;
			this.y=y;
			return 1;
		}
		return 0;
	}

	public void move(int[][] environnement,int o){
		//System.out.println("essai "+essai);
		switch(o){
		
		case(1):
			if(y==0){
				move(environnement,3);
			}
			else{
				if(environnement[x][y-1] !=30 && environnement[x][y-1] !=31){

					
					y--;
					orientation=o;

				}
				else{
						move(environnement,o+1);
					
				}
			}
		break;
		case(2):
			if(x==0){
				move(environnement,4);
			}
			else{
				if(environnement[x-1][y] !=30 && environnement[x-1][y] !=31){
					x--;
					orientation=o;

				}
				else{
						move(environnement,o+1);

					
				}
			}
		break;
		case(3):
			if(y==(Glob.size_y-1)){
				move(environnement,1);
			}
			else{
				if(environnement[x][y+1] !=30 && environnement[x][y+1] !=31){
					y++;
					orientation=o;

				}
				else{

						move(environnement,o+1);
				}
			}
		break;
		case(4):
			if(x==(Glob.size_x-1)){
				move(environnement,2);
			}
			else{
				if(environnement[x+1][y] !=30 && environnement[x+1][y] !=31){
					x++;
					orientation=o;

				}
				else{

						move(environnement,o+1);
				}
			}
		break;
		}
		
	}
	
	public  void moveRand(int[][]environnement){
		int o;
		o=(int)((Math.random()*4)+1);
		move(environnement,o);
}


	public abstract void lowerEnergy();

}

