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
	ArrayList bulletList = new ArrayList();//������ʱδѧ����ʱ���ӣ��Ժ�ѧ�ˣ��Ժ�ѧ�ˣ�ǿ�ҽ�����ϡ�
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
			
			//���ͷɻ�����ײ
			boolean peng = b.getRect().intersects(p.getRect());
			if(peng) {
				p.setLive(false);
				endTime = new Date();
				int period = (int)((endTime.getTime() - startTime.getTime())/1000);
				//printInfo(g,"����:100",50,400,100,Color.blue);
				printInfo(g,"����:" + period + "��",30,300,100,Color.blue);
				
				switch (period/10) {
				case 0:
				case 1:
					printInfo(g,"����",50,200,200,Color.red);
					break;
				case 2:
					printInfo(g,"С��",50,200,200,Color.red);
					break;
				case 3:
					printInfo(g,"����",50,200,200,Color.red);
					break;
				case 4:
					printInfo(g,"�����ӣ�",50,200,200,Color.red);
					break;
				case 5:
					printInfo(g,"���ˣ�",50,200,200,Color.red);
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
		Font f = new Font("����",Font.BOLD,50);
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
		//���Ӽ��̵ļ���,�����ȡ������ſ�����
		addKeyListener(new KeyMonitor());
		
		//����һ���ӵ�
		for(int i = 0;i<50;i++) {
			Bullet b = new Bullet();
			bulletList.add(b);
		}
		startTime = new Date();
	}
	
	//����Ϊ�ڲ��࣬���Է����ʹ���ⲿ�����ͨ����
	class KeyMonitor extends KeyAdapter{//������ȡ������������Ҫע��

		@Override
		public void keyPressed(KeyEvent e) {//��������
			System.out.println("���£�" + e.getKeyCode());
			p.addDrire(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {//��������
			System.out.println("����" + e.getKeyCode());
			p.minusDirection(e);
		}
		
	}
}
