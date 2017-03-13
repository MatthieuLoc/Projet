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
	private Image coin20;
	private Image bord21;
	private Image coin22;
	private Image bord23;
	private Image coin24;
	private Image bord25;
	private Image coin26;
	private Image bord27;
	
	private int spriteLength = 32;
	
	private Terrain terrain;
	
	public Sprite(){
	
		try{
			herbe = ImageIO.read(new File("herbe.png"));
			coin20 = ImageIO.read(new File("coin20.png"));
			bord21 = ImageIO.read(new File("bord21.png"));
			coin22 = ImageIO.read(new File("coin22.png"));
			bord23 = ImageIO.read(new File("bord23.png"));
			coin24 = ImageIO.read(new File("coin24.png"));
			bord25 = ImageIO.read(new File("bord25.png"));
			coin26 = ImageIO.read(new File("coin26.png"));
			bord27 = ImageIO.read(new File("bord27.png"));
		}
		catch(Exception e){
			e.printStackTrace();
			System.exit(-1);
		}
	
		frame = new JFrame("TERRAIN");
		frame.add(this);
		frame.setSize(256,278);
		frame.setVisible(true);
		
		terrain = new Terrain(30,4);
		
		terrain.init();
		terrain.pointHaut();
		terrain.strates2();
		
	}
	
	public void paint(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		for ( int i = 0 ; i < terrain.getSize() ; i++ )
			for ( int j = 0 ; j < terrain.getSize() ; j++ )
			{
				if ( terrain.getTerrain()[i][j] < 10 ){
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
					
			}
	}

	public static void main(String[] args) {
		new Sprite();
	}
}






