import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;
public class MyPanel extends JPanel 
{
					ImageIcon ic;
					Image img;
					int w,h;
					public MyPanel(String path,int w,int h) {
						this.w=w;
						this.h=h;
						// TODO Auto-generated constructor stub
						ic=new ImageIcon(path);
						img=ic.getImage();
					}
					@Override
					protected void paintComponent(Graphics arg0) {
						// TODO Auto-generated method stub
						super.paintComponent(arg0);
						arg0.drawImage(img,0,0,w,h,null);
					}
}
