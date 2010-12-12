package test;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


@SuppressWarnings("serial")
public class Imagen extends JFrame {
	public Imagen(){
		super("Tablero");
		setSize(900, 500);
		setVisible(true);
	}
	
	public void paint(Graphics g){
		ImageIcon im = new ImageIcon(System.getProperty("user.dir")+"/circustrain/data/Tablero.jpg");
		g.drawImage(im.getImage(), 40, 40, null);
		super.paint(g);
	}
	

}	