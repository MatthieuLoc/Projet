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

	public LoupAgent(int x, int y){
	super( x, y,true);
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



}


