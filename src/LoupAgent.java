/*RAPPEL DU CONTENU D'AGENT
 	boolean _alive;
	int _state; //etat (poursuite /fuite/attente...)
	int _orientation; //1=N, 2=0, 3=S, 4=E (sens trigo)
	int _x,_y;
	int _energy;
	
	int _last;
	boolean mechant;

 */
	
public class LoupAgent extends Agent {

	private int essai=0;
	public LoupAgent(int x, int y){
	super( x, y,true);
	}
	
	

	/*RAPPEL DU CONTENU D'AGENT
 	boolean _alive;
	int _state; //etat (poursuite /fuite/attente...)
	int _orientation; //1=N, 2=0, 3=S, 4=E (sens trigo)
	int _x,_y;
	int _energy;
	
	int _last;
	boolean mechant;

 */
	
	public void move(int[][] environnement,int o){
		switch(o){
		
		case(1):
			if(environnement[x][y-1] !=30 && environnement[x][y-1] !=31){
				y--;
				orientation=o;
				essai=0;
			}
			else{
				if(essai<=4){
					essai++;
					move(environnement,o+1);
				}
				
			}
		break;
		case(2):
			if(environnement[x-1][y] !=30 && environnement[x][y-1] !=31){
				x--;
				orientation=o;
				essai=0;
			}
			else{
				if(essai<=4){
					essai++;
					move(environnement,o+1);
				}
				
			}
		break;
		case(3):
			if(environnement[x][y+1] !=30 && environnement[x][y-1] !=31){
				y++;
				orientation=o;
				essai=0;
			}
			else{
				if(essai<=4){
					essai++;
					move(environnement,o+1);
				}
			}
		break;
		case(4):
			if(environnement[x+1][y] !=30 && environnement[x][y-1] !=31){
				x++;
				orientation=o;
				essai=0;
			}
			else{
				if(essai<=4){
					essai++;
					move(environnement,o+1);
				}
			}
		break;
		}
		
	}
	
	
	
	public  void moveRand(int[][]environnement){
			int o;
			do{
				o=(int)(Math.random()*4)+1;
			}
			while(o ==((orientation+2)%5));
			move(environnement,o);
	}



}


