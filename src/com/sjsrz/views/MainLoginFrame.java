package com.sjsrz.views;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainLoginFrame extends JFrame {
	JFrame parentFrame;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 300;
	
	/**
	 * @param title
	 */
	public MainLoginFrame(String title) { 
		//设置窗体大小
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT); 
		//设置窗体标题
		setTitle(title); 
		//显示位置在屏幕长度和宽度的1/3处。
		Toolkit kit = Toolkit.getDefaultToolkit(); 
		Dimension screenSize = kit.getScreenSize(); 
		int screenWidthpx = screenSize.width;
		int screenHeightpx = screenSize.height; 
		setLocation(screenWidthpx / 3, screenHeightpx / 3); 
		setLocationByPlatform(false); 
		//设置窗口最小化时显示的图标，可选。
		Image img = new ImageIcon(this.getClass(). getResource("/images/001.jpg")).getImage(); 
		setIconImage(img);
		//设置窗体的内容面板，该面板包含了所有的有效GUI组件信息
		MainLoginPanel loginPanel = new MainLoginPanel(); setContentPane(loginPanel); 
		//设置窗口其他显示属性
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setVisible(true);
		setResizable(false);
	}
	
	private class MainLoginPanel extends JPanel {
		//定义登陆容器Panel中的控件元素。
		JLabel picLabel; 
		JButton stuLoginButton,tchLoginButton; 
		JPanel buttonPanel,infoPanel; 
		//登陆容器panel构造，将所有控件元素装入容器。
		private class ButtonAction implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e){
				if(e.getSource().equals(stuLoginButton)){
					EventQueue.invokeLater(new Runnable(){
						public void run(){
							StuLoginFrame frame = new StuLoginFrame("学生登陆入口");
						}
					});
					MainLoginFrame.this.dispose();
				}else{
					EventQueue.invokeLater(new Runnable(){
						public void run(){
							TchLoginFrame frame = new TchLoginFrame("教工登陆入口");
						}
					});
					MainLoginFrame.this.dispose();
				}
			}
		}
		
		public MainLoginPanel() { 
			//生成所有控件对象
			picLabel = new JLabel();
			stuLoginButton = new JButton("学生登陆");
			tchLoginButton = new JButton("教师登陆"); 
			buttonPanel = new JPanel();
			infoPanel = new JPanel();
			
			//设置StuLoginPanel布局为BorderLayout。
			setLayout(new BorderLayout()); 
			//依次添加pic、login信息控件到面板容器， 
			//并设置infoPanel布局管理器为FlowLayout。
			infoPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); 
			picLabel.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT/2); 
			ImageIcon image = new ImageIcon(this.getClass().getResource("/images/top2.jpg")); 
			image.setImage(image.getImage().getScaledInstance( picLabel.getWidth(),picLabel.getHeight(), Image.SCALE_DEFAULT)); 
			picLabel.setIcon(image);
			infoPanel.add(picLabel);
			infoPanel.add(stuLoginButton); 
			infoPanel.add(tchLoginButton); 
			add(infoPanel,BorderLayout.CENTER);
			
			ButtonAction buttonAction = new ButtonAction();
			stuLoginButton.addActionListener(buttonAction);
			tchLoginButton.addActionListener(buttonAction);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainLoginFrame frame = new MainLoginFrame("登陆主窗口");
	}

}
