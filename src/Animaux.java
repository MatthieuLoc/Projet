//mouton =2


public class Animaux {
	
	int[][] matriceAnimaux;
	MoutonAgent[] moutons;
	int nmouton;
	int nloup;
	int width;
	int height;
	
	public Animaux(int nmouton, int nloup,int width,int height){
		this.nmouton=nmouton;
		this.nloup=nloup;
		this.width=width;
		this.height=height;
		matriceAnimaux=new int[width][height];
		moutons=new MoutonAgent[nmouton];
		
		
	}
	
	
	//parcourt le tableau jusqu'a trouver un emplacement null, y ajoute un mouton et renvoie 1, sinon renvoie 0
	public int addMouton(int x, int y){
		int i=0;
		while(moutons[i] != null && i<nmouton){
			i++;
		}
		if(i==(nmouton-1)){
			moutons[i]=new MoutonAgent(x,y);
			matriceAnimaux[x][y]=2;
			return 1;
		}
		else{
			return 0;
		}
	}
	
	
	
	
	public void addMoutonRand(){
		int x=(int)Math.random()*width+1;
		int y=(int)Math.random()*height+1;
		addMouton(x,y);
	}
	
	public void remplirMoutons(){
		int i;
		int x;
		int y;
		
		for(i=0;i<nmouton;i++){
			
			x=(int)(Math.random()*width);
			y=(int)(Math.random()*height);
			
			moutons[i]=new MoutonAgent(x,y);
			System.out.println("Mouton créé  n°"+i+ "x="+x+" y="+y);
			matriceAnimaux[x][y]=2;
			
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

					s += "O ";
				}
			}
			s += "\n";
		}
		return s;
	}
}
