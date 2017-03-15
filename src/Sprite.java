import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Sprite extends JPanel {
	
	private JFrame frame;
	
	private Image herbe;
	private Image tree;
	private Image tree2;
	private Image coin20;
	private Image bord21;
	private Image coin22;
	private Image bord23;
	private Image coin24;
	private Image bord25;
	private Image coin26;
	private Image bord27;
	private Image mouton;
	
	private int spriteLength = 16;
	private Terrain terrain;
	private Animaux animaux;

	

	
	public Sprite(Terrain terrain,Animaux animaux){
		this.terrain=terrain;
		this.animaux=animaux;
	
		try{
			herbe = ImageIO.read(new File("herbe.png"));
			tree = ImageIO.read(new File("arbre.png"));
			tree2 = ImageIO.read(new File("arbre3.png"));
			coin20 = ImageIO.read(new File("20.png"));
			bord21 = ImageIO.read(new File("21.png"));
			coin22 = ImageIO.read(new File("22.png"));
			bord23 = ImageIO.read(new File("23.png"));
			coin24 = ImageIO.read(new File("24_2.png"));
			bord25 = ImageIO.read(new File("25_2.png"));
			coin26 = ImageIO.read(new File("26_2.png"));
			bord27 = ImageIO.read(new File("27.png"));
			mouton = ImageIO.read(new File("mouton.png"));
			
		}
		catch(Exception e){
			e.printStackTrace();
			System.exit(-1);
		}
	
		frame = new JFrame("TERRAIN");
		frame.add(this);
		frame.setSize(800,500);
		frame.setVisible(true);
		

		
	}
	
	public void paint(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		Graphics2D g3 = (Graphics2D)g;
		Graphics2D g4 = (Graphics2D)g;
		
		for ( int i = 0 ; i < terrain.getWidth() ; i++ )
			for ( int j = 0 ; j < terrain.getHeight() ; j++ )
			{
				if ( terrain.getTerrain()[i][j] < 10 ){
					g2.drawImage(herbe,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
				}
				else if ( terrain.getTerrain()[i][j] == 20 ){
					g2.drawImage(coin24,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
				}
				else if ( terrain.getTerrain()[i][j] == 21 ){
					g2.drawImage(bord23,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
				}
				else if ( terrain.getTerrain()[i][j] == 22 ){
					g2.drawImage(coin22,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
				}
				else if ( terrain.getTerrain()[i][j] == 23 ){
					g2.drawImage(bord21,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
				}
				else if ( terrain.getTerrain()[i][j] == 24 ){
					g2.drawImage(coin20,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
				}
				else if ( terrain.getTerrain()[i][j] == 25 ){
					g2.drawImage(bord27,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
				}
				else if ( terrain.getTerrain()[i][j] == 26 ){
					g2.drawImage(coin26,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
				}
				else if ( terrain.getTerrain()[i][j] == 27 ){
					g2.drawImage(bord25,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
				}
				
				
				if(terrain.getEnvironnement()[i][j]==30){
					g3.drawImage(tree,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
				}
				
				else if(terrain.getEnvironnement()[i][j]==31){
					g3.drawImage(tree,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
				}
				
				if(animaux.getMatrice()[i][j]==2){
					g4.drawImage(mouton,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
				}
				
					
			}
	}


	
}






