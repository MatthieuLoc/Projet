import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Sprite extends JPanel {
	
	private JFrame frame;
	private Image eau;
	private Image herbe;
	private Image tree;
	private Image tree2;
	private Image treefire;
	private Image treeburn;
	private Image repousse;
	private Image herbes;
	
	private Image coin20;
	private Image bord21;
	private Image coin22;
	private Image bord23;
	private Image coin24;
	private Image bord25;
	private Image coin26;
	private Image bord27;
	private Image coin28;
	private Image coin29;
	private Image coin30;
	private Image coin31;
	
	//mouton repos
	private Image Agent1101;
	private Image Agent1201;
	private Image Agent1301;
	private Image Agent1401;
	//mouton mange
	private Image Agent1111;
	private Image Agent1211;
	private Image Agent1311;
	private Image Agent1411;
	//mouton chasse
	private Image Agent1121;
	private Image Agent1221;
	private Image Agent1321;
	private Image Agent1421;
	//mouton fuit
	private Image Agent1131;
	private Image Agent1231;
	private Image Agent1331;
	private Image Agent1431;
	
	
	//loup repos
	private Image Agent2101;
	private Image Agent2201;
	private Image Agent2301;
	private Image Agent2401;
	//loup mange
	private Image Agent2111;
	private Image Agent2211;
	private Image Agent2311;
	private Image Agent2411;
	//loup chasse
	private Image Agent2121;
	private Image Agent2221;
	private Image Agent2321;
	private Image Agent2421;
	

	
	private int spriteLength = 16;
	private Terrain terrain;
	private Animaux animaux;


	
	public Sprite(Terrain terrain,Animaux animaux){
		this.terrain=terrain;
		this.animaux=animaux;

		
	
		try{
			eau = ImageIO.read(new File("eau.png"));
			herbe = ImageIO.read(new File("herbe.png"));
			tree = ImageIO.read(new File("arbre.png"));
			tree2 = ImageIO.read(new File("arbre4.png"));
			treefire = ImageIO.read(new File("arbrefeu.png"));
			treeburn = ImageIO.read(new File("tronc.png"));
			repousse = ImageIO.read(new File("repousse.png"));
			herbes = ImageIO.read(new File("herbe3.png"));
			
			
			coin20 = ImageIO.read(new File("20.png"));
			bord21 = ImageIO.read(new File("21.png"));
			coin22 = ImageIO.read(new File("22.png"));
			bord23 = ImageIO.read(new File("23.png"));
			coin24 = ImageIO.read(new File("24_2.png"));
			bord25 = ImageIO.read(new File("25_2.png"));
			coin26 = ImageIO.read(new File("26_2.png"));
			bord27 = ImageIO.read(new File("27.png"));
			coin28 = ImageIO.read(new File("coin28.png"));
			coin29 = ImageIO.read(new File("coin29.png"));
			coin30 = ImageIO.read(new File("coin30.png"));
			coin31 = ImageIO.read(new File("coin31.png"));
			
			//mouton
			Agent1101 = ImageIO.read(new File("Agent1101.png"));
			Agent1201 = ImageIO.read(new File("Agent1201.png"));
			Agent1301 = ImageIO.read(new File("Agent1301.png"));
			Agent1401 = ImageIO.read(new File("Agent1401.png"));
			
			Agent1111 = ImageIO.read(new File("Agent1111.png"));
			Agent1211 = ImageIO.read(new File("Agent1211.png"));
			Agent1311 = ImageIO.read(new File("Agent1311.png"));
			Agent1411 = ImageIO.read(new File("Agent1411.png"));
			
			Agent1121 = ImageIO.read(new File("Agent1121.png"));
			Agent1221 = ImageIO.read(new File("Agent1221.png"));
			Agent1321 = ImageIO.read(new File("Agent1321.png"));
			Agent1421 = ImageIO.read(new File("Agent1421.png"));
			
			Agent1131 = ImageIO.read(new File("Agent1131.png"));
			Agent1231 = ImageIO.read(new File("Agent1231.png"));
			Agent1331 = ImageIO.read(new File("Agent1331.png"));
			Agent1431 = ImageIO.read(new File("Agent1431.png"));
			
			//loup
			Agent2101 = ImageIO.read(new File("Agent2101.png"));
			Agent2201 = ImageIO.read(new File("Agent2201.png"));
			Agent2301 = ImageIO.read(new File("Agent2301.png"));
			Agent2401 = ImageIO.read(new File("Agent2401.png"));
			
			Agent2111 = ImageIO.read(new File("Agent2111.png"));
			Agent2211 = ImageIO.read(new File("Agent2211.png"));
			Agent2311 = ImageIO.read(new File("Agent2311.png"));
			Agent2411 = ImageIO.read(new File("Agent2411.png"));
			
			Agent2121 = ImageIO.read(new File("Agent2121.png"));
			Agent2221 = ImageIO.read(new File("Agent2221.png"));
			Agent2321 = ImageIO.read(new File("Agent2321.png"));
			Agent2421 = ImageIO.read(new File("Agent2421.png"));
			
		}catch(Exception e){e.printStackTrace();System.exit(-1);}
		
		frame = new JFrame("TERRAIN");
		frame.add(this);
		
		frame.setSize(((Glob.size_x+2)*spriteLength),((Glob.size_y+1)*spriteLength));
		
		frame.setVisible(true);

	}
	
	public void paint(Graphics g){
		int agentTmp;
		Graphics2D g2 = (Graphics2D)g;
		Graphics2D g3 = (Graphics2D)g;
		Graphics2D g4 = (Graphics2D)g;
		
		for ( int i = 0 ; i < terrain.getSizeX() ; i++ ){
			for ( int j = 0 ; j < terrain.getSizeY() ; j++ )
			{
				 if ( terrain.getTerrain()[i][j] == -1 ){
					g2.drawImage(eau,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
				}
				 else if ( terrain.getTerrain()[i][j] < 10 ){
					g2.drawImage(herbe,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
				}
				
				else if ( terrain.getTerrain()[i][j] == 20 ){
					g2.drawImage(coin20,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
				}
				else if ( terrain.getTerrain()[i][j] == 21 ){
					g2.drawImage(bord21,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
				}
				else if ( terrain.getTerrain()[i][j] == 22 ){
					g2.drawImage(coin22,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
				}
				else if ( terrain.getTerrain()[i][j] == 23 ){
					g2.drawImage(bord23,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
				}
				else if ( terrain.getTerrain()[i][j] == 24 ){
					g2.drawImage(coin24,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
				}
				else if ( terrain.getTerrain()[i][j] == 25 ){
					g2.drawImage(bord25,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
				}
				else if ( terrain.getTerrain()[i][j] == 26 ){
					g2.drawImage(coin26,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
				}
				else if ( terrain.getTerrain()[i][j] == 27 ){
					g2.drawImage(bord27,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
				}
				else if ( terrain.getTerrain()[i][j] == 28 ){
					g2.drawImage(coin28,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
				}
				else if ( terrain.getTerrain()[i][j] == 29 ){
					g2.drawImage(coin29,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
				}
				else if ( terrain.getTerrain()[i][j] == 30 ){
					g2.drawImage(coin30,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
				}
				else if ( terrain.getTerrain()[i][j] == 31 ){
					g2.drawImage(coin31,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
				}
				
				
				if(terrain.getEnvironnement()[i][j]==40){
					g3.drawImage(tree,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
				}
				
				else if(terrain.getEnvironnement()[i][j]==41){
					g3.drawImage(tree2,spriteLength*i,(spriteLength*j)-spriteLength,spriteLength,spriteLength*2, frame);
				}
				else if(terrain.getEnvironnement()[i][j]==42){
					g3.drawImage(treefire,spriteLength*i,(spriteLength*j)-spriteLength,spriteLength,spriteLength+24, frame);
				}
				else if(terrain.getEnvironnement()[i][j]==43){
					g3.drawImage(treeburn,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
				}
				else if(terrain.getEnvironnement()[i][j]==44){
					g3.drawImage(repousse,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
				}
				else if(terrain.getEnvironnement()[i][j]==45){
					g3.drawImage(herbes,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
				}
				
				
				
				agentTmp=animaux.getMatrice()[i][j];
				
				
				//1000 -> c est un mouton
				if(agentTmp/1000==1){
					
					agentTmp=agentTmp%1000;
					
					//vas vers le haut
					if(agentTmp/100==1){
						
						agentTmp=agentTmp%100;
						
						//differents states
						if(agentTmp==1){
							g4.drawImage(Agent1101,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						}
						if(agentTmp==11){
							g4.drawImage(Agent1111,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						}
						if(agentTmp==21){
							g4.drawImage(Agent1121,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						}
						if(agentTmp==31){
							g4.drawImage(Agent1131,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						}
					}
						//vers la gauche
					if(agentTmp/100==2){
						agentTmp=agentTmp%100;
						//differents states
						if(agentTmp==1){
							g4.drawImage(Agent1201,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						}
						if(agentTmp==11){
							g4.drawImage(Agent1211,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						}
						if(agentTmp==21){
							g4.drawImage(Agent1221,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						}
						if(agentTmp==31){	
							g4.drawImage(Agent1231,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						}
					}
					//vers le bas
					if(agentTmp/100==3){
						agentTmp=agentTmp%100;
						//differents states
						if(agentTmp==1){
							g4.drawImage(Agent1301,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						}
						if(agentTmp==11){
							g4.drawImage(Agent1311,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						}
						if(agentTmp==21){
							g4.drawImage(Agent1321,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						}
						if(agentTmp==31){
							g4.drawImage(Agent1331,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						}
					}
					//vers la droite
					if(agentTmp/100==4){
						agentTmp=agentTmp%100;
						//differents states
							
						if(agentTmp==1){
							g4.drawImage(Agent1401,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						}
						if(agentTmp==11){
							g4.drawImage(Agent1411,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						}
						if(agentTmp==21){
							g4.drawImage(Agent1421,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						}
						if(agentTmp==31){
							g4.drawImage(Agent1431,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						}
					}		
				}
				if(agentTmp/1000==2){// 2000 -> c'est un loup
					agentTmp=agentTmp%1000;
					//vas vers le haut
					if(agentTmp/100==1){
						agentTmp=agentTmp%100;
						//differents states
						if(agentTmp==1){
							g4.drawImage(Agent2101,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						}
						if(agentTmp==11){
							g4.drawImage(Agent2111,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						}
						if(agentTmp==21){
							g4.drawImage(Agent2121,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						}
					}
						//vers la gauche
					if(agentTmp/100==2){
						agentTmp=agentTmp%100;
						//differents states
						if(agentTmp==1){
							g4.drawImage(Agent2201,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						}
						if(agentTmp==11){
							g4.drawImage(Agent2211,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						}
						if(agentTmp==21){
							g4.drawImage(Agent2221,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						}

					}
					//vers le bas
					if(agentTmp/100==3){
						agentTmp=agentTmp%100;
						//differents states
						if(agentTmp==1){
							g4.drawImage(Agent2301,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						}
						if(agentTmp==11){
							g4.drawImage(Agent2311,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						}
						if(agentTmp==21){
							g4.drawImage(Agent2321,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						}

					}
					//vers la droite
					if(agentTmp/100==4){
						agentTmp=agentTmp%100;
						//differents states
							
						if(agentTmp==1){
							g4.drawImage(Agent2401,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						}
						if(agentTmp==11){
							g4.drawImage(Agent2411,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						}
						if(agentTmp==21){
							g4.drawImage(Agent2421,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
						}

					}
				}
			}
		}
	}
		


	public void refresh(){
		frame.repaint();
	}
}




