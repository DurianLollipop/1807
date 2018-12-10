package util;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author 15914
 *
 */
public class MyFrame extends Frame{
	public void lanuchFrame() {
		setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
		setLocation(100,100);
		setVisible(true);
		
		new PaintThread().start();
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}
			
		});
	}
	
	
//	private Image offScreenImage = null;//利用双缓冲技术消除闪烁
//	public void update(Graphics g) {
//		if(offScreenImage == null) {
//			offScreenImage = this.createImage(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
//			
//			Graphics goff = offScreenImage.getGraphics();
//			
//			paint(goff);
//			g.drawImage(offScreenImage, 0, 0, null);
//		}
//	}
	
	
	
	private Image iBuffer = null;//利用双缓冲技术消除闪烁
	private Graphics gBuffer;
	public void update(Graphics g) {
		if(iBuffer == null) {
			iBuffer = createImage(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
			gBuffer = iBuffer.getGraphics();
			}
			
		gBuffer.setColor(getBackground());
		gBuffer.fillRect(0, 0, Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		paint(gBuffer);
		g.drawImage(iBuffer, 0, 0, this);
	}
	
	
//	private Image iBuffer = null;//利用双缓冲技术消除闪烁
//	private Graphics gBuffer;
//	public void paint(Graphics g) {
//		if(iBuffer == null) {
//			iBuffer = createImage(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
//			iBuffer ==iBuffer
//			Graphics goff = offScreenImage.getGraphics();
//			
//			paint(goff);
//			g.drawImage(offScreenImage, 0, 0, null);
//		}
//	}
	
	/**定义一个重置窗口的线程类，是一个内部类
	 * @author 15914
	 *
	 */
	class PaintThread extends Thread{

		@Override
		public void run() {
			while(true) {
				repaint();
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
	
}
