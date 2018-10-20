import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

@SuppressWarnings("serial")
public class Parc extends JComponent{

	public static Pigeon[] pigeons;
	public static ArrayList<Food> food;
	
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		try {
		      Image img = ImageIO.read(new File("res/background.jpg"));
		      g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		    } catch (IOException e) {
		      e.printStackTrace();
		    } 
		
				
		for(int i=0;i<pigeons.length;i++){
			try {
				if (pigeons[i].getPosX()!=-1 &&pigeons[i].getPosY()!=-1){
					Image img = ImageIO.read(new File("res/dove.jpg"));
					g.drawImage(img,pigeons[i].getPosX(),pigeons[i].getPosY(),null);
				}
			} catch (IOException ex) {
					Logger.getLogger(Parc.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
					
		
		/*if(food!=null)
					{
					for(int i=0;i<food.size();i++)
					{
						try {
						if (food.get(i).isFresh())
						{
							Image img = ImageIO.read(new File("res/freshfood.jpg"));
							g.drawImage(img,food.get(i).getPosX(),food.get(i).getPosY(),null);
						}
						else 
						{
							Image img = ImageIO.read(new File("res/rottenfood.jpg"));
							g.drawImage(img,food.get(i).getPosX(),food.get(i).getPosY(),null);
						}
					} catch (IOException ex) {
						Logger.getLogger(Parc.class.getName()).log(Level.SEVERE, null, ex);
					}
					}
					}*/
			
			}


	public static void main(String args[]) {
		
		Pigeon pigeon1=new Pigeon(50,50);
		Pigeon pigeon2=new Pigeon(0,0);
		Pigeon pigeon3=new Pigeon(100,150);
		Parc.pigeons = new Pigeon[]{pigeon1,pigeon2,pigeon3};
		ThreadAffichage threadAffichage=new ThreadAffichage();
		ThreadPigeon threadPigeon1 = new ThreadPigeon();
		ThreadPigeon threadPigeon2 = new ThreadPigeon();
		ThreadPigeon threadPigeon3 = new ThreadPigeon();

		threadAffichage.start();
		threadPigeon1.start();
		threadPigeon2.start();
		threadPigeon3.start();
		
		}
	
}
		