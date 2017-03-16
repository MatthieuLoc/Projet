//mouton =2


public class Animaux {
	
	int[][] matriceAnimaux;
	MoutonAgent[] moutons;
	int nmouton;
	int nloup;
	int size_x;
	int size_y;
	int[][] terrain;
	int[][] environnement;
	
	
	public Animaux(int nmouton, int nloup,int size_x,int size_y,int[][] terrain, int[][] environnement){
		this.nmouton=nmouton;
		this.nloup=nloup;
		this.size_x=size_x;
		this.size_y=size_y;
		this.terrain=terrain;
		this.environnement=environnement;
		matriceAnimaux=new int[size_x][size_y];
		moutons=new MoutonAgent[nmouton];
		
		
	}
	
	
	//parcourt le tableau jusqu'a trouver un emplacement null, y ajoute un mouton et renvoie 1, sinon renvoie 0
	public int addMouton(int x, int y){
		int i=0;
		
		while(moutons[i] != null && i<nmouton){
			//System.out.println("Mouton créé  n°"+" x="+x+"y="+y+" i="+i);
			i++;
		}
		
		if(i !=(nmouton-1)){
			moutons[i]=new MoutonAgent(x,y);
			matriceAnimaux[x][y]=2;
			
			return 1;
		}
		else{
			return 0;
		}
	}
	
	
	public void deplacementRandom(Agent[] animal){
		for(int i=0;i<nmouton;i++){
			if(animal[i] != null){
			matriceAnimaux[animal[i].x][animal[i].y]=0;
			
				animal[i].deplacementRandom(size_x, size_y);
				//System.out.println("animal:"+i+" x= "+animal[i].x+ " y="+animal[i].y);
				matriceAnimaux[animal[i].x][animal[i].y]=2;
				
			}
		}
	}
	
	public void addMoutonRand(){
		int x=(int)(Math.random()*size_x);
		int y=(int)(Math.random()*size_y);
		
		while(environnement[x][y]==30 || environnement[x][y]==31){
			//System.out.println("zut");
			x=(int)(Math.random()*size_x);
			y=(int)(Math.random()*size_y);
		}
		addMouton(x,y);
	}
	
	public void remplirMoutons(){
		
		for(int i=0;i<nmouton;i++){
			
			addMoutonRand();
			
		}
	}
	
	public int[][] getMatrice(){
		return matriceAnimaux;
	}
	
	public MoutonAgent[] getMoutons(){
		return moutons;
	}
	
	public String toString3(){
		String s="";
		for(int i=0; i<size_x; i++){
			for(int j=0; j<size_y; j++){
				if(matriceAnimaux[i][j]==0){
					s += "- ";
				}
				if(matriceAnimaux[i][j]==2){

					s += "o ";
				}
			}
			s += "\n";
		}
		return s;
	}
}
