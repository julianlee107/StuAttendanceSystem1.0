package com.sjsrz.views;

import javax.swing.*;
import java.awt.*;

public class TchLoginFrame extends JFrame {
	JFrame parentFrame;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 300;
	JCheckBox adminCheckBox;
	
	public TchLoginFrame(String title) { 
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
		TchLoginPanel loginPanel = new TchLoginPanel(); setContentPane(loginPanel); 
		//设置窗口其他显示属性
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setVisible(true);
		setResizable(false);
	}
		
	private class TchLoginPanel extends JPanel {
		//定义登陆容器Panel中的控件元素。
		JLabel picLabel; 
		JLabel idLabel, pwdLabel; 
		JTextField stuIdTextField;
		JPasswordField pwdField; 
		JButton okButton,clearButton; 
		JPanel buttonPanel,infoPanel; 
		//登陆容器panel构造，将所有控件元素装入容器。
		public TchLoginPanel() { 
			//生成所有控件对象
			picLabel = new JLabel();
			idLabel = new JLabel("教工ID："); 
			//构造器参数为标签显示文本
			pwdLabel = new JLabel("密码："); 
			//构造器参数为标签显示文本
			stuIdTextField = new JTextField(20); 
			pwdField = new JPasswordField(20);
			okButton = new JButton("登陆");
			//构造器参数为按钮显示文本
			clearButton = new JButton("清空信息"); 
			buttonPanel = new JPanel();
			infoPanel = new JPanel();
			adminCheckBox = new JCheckBox("我是管理员");
			
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
			infoPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); 
			infoPanel.add(idLabel);
			infoPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
			infoPanel.add(stuIdTextField); 
			infoPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); 
			infoPanel.add(pwdLabel); 
			infoPanel.setLayout(new FlowLayout(FlowLayout.RIGHT)); 
			infoPanel.add(pwdField); 
			infoPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
			infoPanel.add(adminCheckBox);
			add(infoPanel,BorderLayout.CENTER);
			
			//依次添加按钮控件到面板容器，buttonPanel布局管理器默认流布局， 
			//并将buttonPanel控件作为StuLoginPanel的底端组件。
			buttonPanel.add(okButton); 
			buttonPanel.add(clearButton); 
			add(buttonPanel,BorderLayout.SOUTH);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TchLoginFrame frame = new TchLoginFrame("教师登陆窗口");
	}

}
