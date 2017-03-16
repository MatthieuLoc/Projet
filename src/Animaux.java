//mouton =2


public class Animaux {
	
	int[][] matriceAnimaux;
	MoutonAgent[] moutons;
	int nmouton;
	int nloup;
	int width;
	int height;
	int[][] terrain;
	int[][] environnement;
	
	
	public Animaux(int nmouton, int nloup,int width,int height,int[][] terrain, int[][] environnement){
		this.nmouton=nmouton;
		this.nloup=nloup;
		this.width=width;
		this.height=height;
		this.terrain=terrain;
		this.environnement=environnement;
		matriceAnimaux=new int[width][height];
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
			
				animal[i].deplacementRandom(width, height);
				//System.out.println("animal:"+i+" x= "+animal[i].x+ " y="+animal[i].y);
				matriceAnimaux[animal[i].x][animal[i].y]=2;
				
			}
		}
	}
	
	public void addMoutonRand(){
		int x=(int)(Math.random()*width);
		int y=(int)(Math.random()*height);
		
		while(environnement[x][y]==30 || environnement[x][y]==31){
			//System.out.println("zut");
			x=(int)(Math.random()*width);
			y=(int)(Math.random()*height);
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
		for(int i=0; i<width; i++){
			for(int j=0; j<height; j++){
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
