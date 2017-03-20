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
	private Image eau;
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
	private Image mouton;
	private Image loup;
	private Image moutonLoup;
	
	
	private int spriteLength = 16;
	private Terrain terrain;
	private Animaux animaux;

	
	
	public Sprite(Terrain terrain,Animaux animaux){
		this.terrain=terrain;
		this.animaux=animaux;

		
		
		try{
			herbe = ImageIO.read(new File("herbe.png"));
			herbes = ImageIO.read(new File("herbe3.png"));
			eau = ImageIO.read(new File("eau.png"));
			tree = ImageIO.read(new File("arbre.png"));
			tree2 = ImageIO.read(new File("arbre4.png"));
			treefire = ImageIO.read(new File("arbrefeu.png"));
			treeburn = ImageIO.read(new File("tronc.png"));
			repousse = ImageIO.read(new File("repousse.png"));
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
			mouton = ImageIO.read(new File("mouton.png"));
			loup = ImageIO.read(new File("loup.png"));
			moutonLoup = ImageIO.read(new File("moutonLoup.png"));
		}
		catch(Exception e){
			e.printStackTrace();
			System.exit(-1);
		}
		
		frame = new JFrame("TERRAIN");
		frame.add(this);
		
		frame.setSize((Glob.size_x*spriteLength),(Glob.size_y*spriteLength)+spriteLength);
		
		frame.setVisible(true);
		

		
	}
	
	public void paint(Graphics g){
		//System.out.println("je suis dans le paint");
		Graphics2D g2 = (Graphics2D)g;
		Graphics2D g3 = (Graphics2D)g;
		Graphics2D g4 = (Graphics2D)g;
		
		for ( int i = 0 ; i < Glob.size_x ; i++ )
			for ( int j = 0 ; j < Glob.size_y ; j++ )
			{
				if (( terrain.getTerrain()[i][j] < 10 )&&( terrain.getTerrain()[i][j]>=0 )){
					g2.drawImage(herbe,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
				}
				else if (terrain.getTerrain()[i][j]==-1 ){
					g2.drawImage(eau,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
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
				
				if(animaux.getMatrice()[i][j]==3){
					g4.drawImage(mouton,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
				}
				if(animaux.getMatrice()[i][j]==2){
					g4.drawImage(loup,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
				}
				if(animaux.getMatrice()[i][j]==5){
					g4.drawImage(moutonLoup,spriteLength*i,spriteLength*j,spriteLength,spriteLength, frame);
				}
				
			}
	}

	public void refresh(){
		frame.repaint();
	}



	
}
