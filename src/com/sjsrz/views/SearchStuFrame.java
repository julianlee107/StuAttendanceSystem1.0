package com.sjsrz.views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SearchStuFrame extends JFrame{
	JFrame parentFrame;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 300;
	
	public SearchStuFrame(String title) { 
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
		SearchStuPanel loginPanel = new SearchStuPanel(); 
		setContentPane(loginPanel); 
		//设置窗口其他显示属性
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setVisible(true);
		setResizable(false);
	}
	
	private class SearchStuPanel extends JPanel {
		//定义登陆容器Panel中的控件元素。
		JLabel titleOLabel,titleTLabel;
		JButton searchButton,backButton,reButton;
		JTextField keyword;
		JComboBox<String> styleBox;
		JPanel buttonPanel,infoPanel; 
		//登陆容器panel构造，将所有控件元素装入容器。
		private class ButtonAction implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e){
				if(e.getSource().equals(backButton)){
					EventQueue.invokeLater(new Runnable(){
						public void run(){
							TchFuncPortalFrame frame = new TchFuncPortalFrame("学生登陆入口");
						}
					});
					SearchStuFrame.this.dispose();
				}else if(e.getSource().equals(reButton)){
					EventQueue.invokeLater(new Runnable(){
						public void run(){
							keyword.setText("");
						}
					});
				}
			}
		}
		
		public SearchStuPanel() { 
			//生成所有控件对象
			String t1 = "请选择查询方式";
			titleOLabel = new JLabel(t1);
			styleBox = new JComboBox<>();
			styleBox.addItem("按姓名查询");
			styleBox.addItem("按学号查询");
			String t2 = "请输入查询关键字";
			titleTLabel = new JLabel(t2);
			keyword = new JTextField();
			searchButton = new JButton("查询");
			reButton = new JButton("重新开始查询");
			backButton = new JButton("返回上级"); 
			buttonPanel = new JPanel();
			infoPanel = new JPanel();
			
			//设置StuLoginPanel布局为BorderLayout。
			setLayout(new BorderLayout()); 
			//依次添加pic、login信息控件到面板容器， 
			//并设置infoPanel布局管理器为FlowLayout。
			infoPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); 
			infoPanel.add(titleOLabel); 
			infoPanel.add(styleBox); 
			infoPanel.add(titleTLabel); 
			infoPanel.add(keyword); 
			infoPanel.add(searchButton); 
			infoPanel.add(reButton); 
			infoPanel.add(backButton); 
			add(infoPanel,BorderLayout.CENTER);
			
			ButtonAction buttonAction = new ButtonAction();
			backButton.addActionListener(buttonAction);
			searchButton.addActionListener(buttonAction);
			reButton.addActionListener(buttonAction);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchStuFrame frame = new SearchStuFrame("登陆主窗口");
	}
}
