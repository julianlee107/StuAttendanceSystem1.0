package com.sjsrz.views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SearchTchFrame extends JFrame {

	JFrame parentFrame;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 300;
	
	public SearchTchFrame(String title) { 
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
		Image img = new ImageIcon(this.getClass(). getResource("/images/001.jpg")).getImage(); setIconImage(img);
		//设置窗体的内容面板，该面板包含了所有的有效GUI组件信息
		SearchTchPanel loginPanel = new SearchTchPanel(); 
		setContentPane(loginPanel); 
		//设置窗口其他显示属性
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setVisible(true);
		setResizable(false);
	}
	
	private class SearchTchPanel extends JPanel {
		//定义登陆容器Panel中的控件元素。
		
		JButton backButton; 
		JPanel buttonPanel,infoPanel; 
		//登陆容器panel构造，将所有控件元素装入容器。
		private class ButtonAction implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e){
				if(e.getSource().equals(backButton)){
					EventQueue.invokeLater(new Runnable(){
						public void run(){
							StuFuncPortalFrame frame = new StuFuncPortalFrame("教工登陆入口");
						}
					});
					SearchTchFrame.this.dispose();
				}
			}
		}
		
		public SearchTchPanel() { 
			//生成所有控件对象
			
			
			backButton = new JButton("返回上级"); 
			buttonPanel = new JPanel();
			infoPanel = new JPanel();
			
			//设置StuLoginPanel布局为BorderLayout。
			setLayout(new BorderLayout()); 
			//依次添加pic、login信息控件到面板容器， 
			//并设置infoPanel布局管理器为FlowLayout。
			infoPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); 
			infoPanel.add(backButton); 
			add(infoPanel,BorderLayout.CENTER);
			
			ButtonAction buttonAction = new ButtonAction();
			backButton.addActionListener(buttonAction);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchTchFrame frame = new SearchTchFrame("登陆主窗口");
	}
}
