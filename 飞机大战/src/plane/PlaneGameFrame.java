package plane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;

import javax.print.attribute.standard.DateTimeAtCompleted;

import util.GameUtil;
import util.MyFrame;

public class PlaneGameFrame extends MyFrame{

	Image bg = GameUtil.getImage("images/bg.png");
	Plane p = new Plane("images/plane.png",260,700);
	ArrayList bulletList = new ArrayList();//泛型暂时未学，暂时不加，以后学了，以后学了，强烈建议加上。
	Explode baozhang = new Explode(50,50);
	
	Date startTime;
	Date endTime;
	
	
	public void paint(Graphics g) {
		g.drawImage(bg, 0, 0, null);
		p.draw(g);
		baozhang.draw(g);
		for(int i = 0;i<bulletList.size();i++){
			Bullet b = (Bullet)bulletList.get(i);
			b.draw(g);
			
			//检测和飞机的碰撞
			boolean peng = b.getRect().intersects(p.getRect());
			if(peng) {
				p.setLive(false);
				endTime = new Date();
				int period = (int)((endTime.getTime() - startTime.getTime())/1000);
				//printInfo(g,"分数:100",50,400,100,Color.blue);
				printInfo(g,"分数:" + period + "秒",30,300,100,Color.blue);
				
				switch (period/10) {
				case 0:
				case 1:
					printInfo(g,"菜鸟！",50,200,200,Color.red);
					break;
				case 2:
					printInfo(g,"小鸟！",50,200,200,Color.red);
					break;
				case 3:
					printInfo(g,"大鸟！",50,200,200,Color.red);
					break;
				case 4:
					printInfo(g,"鸟王子！",50,200,200,Color.red);
					break;
				case 5:
					printInfo(g,"鸟人！",50,200,200,Color.red);
					break;
				default:
					break;
				}
				
				
				
			}
					
			}
			if(!p.isLive()) {

				
		}
			

	}	
	
	public void printInfo(Graphics g,String str,int size,int x,int y,Color color) {
		Color c = g.getColor();
		g.setColor(color);
		Font f = new Font("宋体",Font.BOLD,50);
		g.setFont(f);
		g.drawString(str, x, y);
		g.setColor(c);
	}
	
	
	
	
	public void update(Graphics g) {
		paint(g);
	}
	
	
	public static void main(String[] args) {
		new PlaneGameFrame().lanuchFrame();
	}
	
	public void lanuchFrame() {
		super.lanuchFrame();
		//增加键盘的监听,下面获取按键类才可以用
		addKeyListener(new KeyMonitor());
		
		//生成一堆子弹
		for(int i = 0;i<50;i++) {
			Bullet b = new Bullet();
			bulletList.add(b);
		}
		startTime = new Date();
	}
	
	//定义为内部类，可以方便的使用外部类的普通属性
	class KeyMonitor extends KeyAdapter{//用来获取按键，该类需要注册

		@Override
		public void keyPressed(KeyEvent e) {//按键按下
			System.out.println("按下：" + e.getKeyCode());
			p.addDrire(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {//按键弹起
			System.out.println("弹起：" + e.getKeyCode());
			p.minusDirection(e);
		}
		
	}
}
