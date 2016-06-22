package com.sjsrz.views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class TchFuncPortalFrame extends JFrame {
	JFrame parentFrame;
	private JPanel contentPane;
	private static final int DEFAULT_WIDTH = 500;
	private static final int DEFAULT_HEIGHT = 450;
	
	public TchFuncPortalFrame(String title) { 
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
		TchFuncPortalPanel loginPanel = new TchFuncPortalPanel(); 
		setContentPane(loginPanel); 
		//设置窗口其他显示属性
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setVisible(true);
		setResizable(false);
	}
	
	private class TchFuncPortalPanel extends JPanel {
		//定义登陆容器Panel中的控件元素。
		JLabel picLabel,idLabel,wordT; 
		JButton lookPButton,upPButton,upPwdButton,lookSButton,searchCheckButton,checkInButton,upCheckButton,searchButton; 
		JTextField lessonId;
		JTable rs;
		JPanel buttonPanel,infoPanel; 
		//登陆容器panel构造，将所有控件元素装入容器。
		private class ButtonAction implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e){
				if(e.getSource().equals(lookPButton)){
					EventQueue.invokeLater(new Runnable(){
						public void run(){
							TchPersonFrame frame = new TchPersonFrame("学生登陆入口");
						}
					});
					TchFuncPortalFrame.this.dispose();
				}else if(e.getSource().equals(upPButton)){
					EventQueue.invokeLater(new Runnable(){
						public void run(){
							UpdateTchPerFrame frame = new UpdateTchPerFrame("学生登陆入口");
						}
					});
					TchFuncPortalFrame.this.dispose();
				}else if(e.getSource().equals(upPwdButton)){
					EventQueue.invokeLater(new Runnable(){
						public void run(){
							UpdateTchPwdFrame frame = new UpdateTchPwdFrame("学生登陆入口");
						}
					});
					TchFuncPortalFrame.this.dispose();
				}else if(e.getSource().equals(lookSButton)){
					EventQueue.invokeLater(new Runnable(){
						public void run(){
							SearchStuFrame frame = new SearchStuFrame("学生登陆入口");
						}
					});
					TchFuncPortalFrame.this.dispose();
				}else if(e.getSource().equals(searchCheckButton)){
					EventQueue.invokeLater(new Runnable(){
						public void run(){
							SearchCheckFrame frame = new SearchCheckFrame("学生登陆入口");
						}
					});
					TchFuncPortalFrame.this.dispose();
				}else if(e.getSource().equals(checkInButton)){
					EventQueue.invokeLater(new Runnable(){
						public void run(){
							CheckInFrame frame = new CheckInFrame("学生登陆入口");
						}
					});
					TchFuncPortalFrame.this.dispose();
				}else if(e.getSource().equals(upCheckButton)){
					EventQueue.invokeLater(new Runnable(){
						public void run(){
							UpdateCheckFrame frame = new UpdateCheckFrame("学生登陆入口");
						}
					});
					TchFuncPortalFrame.this.dispose();
				}else if(e.getSource().equals(searchButton)){
					EventQueue.invokeLater(new Runnable(){
						public void run(){
							
						}
					});
				}
			}
		}
		
		public TchFuncPortalPanel() { 
			//生成所有控件对象
			picLabel = new JLabel();
			String t1 = "ee";
			idLabel = new JLabel(t1);
			String t2 = "请输入要查询考勤记录的课程编号:";
			wordT = new JLabel(t2);
			lookPButton = new JButton("查看个人信息");
			upPButton = new JButton("修改个人信息");
			upPwdButton = new JButton("修改个人密码");
			lookSButton = new JButton("查看学生信息");
			searchCheckButton = new JButton("查看考勤信息");
			checkInButton = new JButton("录入考勤信息");
			upCheckButton = new JButton("修改考勤信息");
			searchButton = new JButton("查找");
			lessonId = new JTextField();
			rs = new JTable();
			
			buttonPanel = new JPanel();
			infoPanel = new JPanel();
			
			//设置StuLoginPanel布局为BorderLayout。
			setLayout(new BorderLayout()); 
			//依次添加pic、login信息控件到面板容器， 
			//并设置infoPanel布局管理器为FlowLayout。
			infoPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
			picLabel.setSize(100, 100); 
			ImageIcon image = new ImageIcon(this.getClass().getResource("/images/top2.jpg")); 
			image.setImage(image.getImage().getScaledInstance( picLabel.getWidth(),picLabel.getHeight(), Image.SCALE_DEFAULT)); 
			picLabel.setIcon(image);
			picLabel.setBounds(150, 20, 100, 100);
			infoPanel.add(picLabel);
			idLabel.setBounds(150, 140, 120, 30);
			infoPanel.add(idLabel);
			lookPButton.setBounds(150, 160, 120, 30);
			infoPanel.add(lookPButton);			
			upPButton.setBounds(150, 80, 120, 30);
			infoPanel.add(upPButton);
			upPwdButton.setBounds(150, 100, 120, 30);
			infoPanel.add(upPwdButton);
			lookSButton.setBounds(150, 120, 120, 30);
			infoPanel.add(lookSButton);
			searchCheckButton.setBounds(150, 140, 120, 30);
			infoPanel.add(searchCheckButton);
			checkInButton.setBounds(150, 140, 120, 30);
			infoPanel.add(checkInButton);
			upCheckButton.setBounds(150, 140, 120, 30);
			infoPanel.add(upCheckButton);
			wordT.setBounds(150, 160, 120, 30);
			infoPanel.add(wordT);
			lessonId.setBounds(150, 180, 120, 30);
			infoPanel.add(lessonId);
			searchButton.setBounds(150, 200, 120, 30);
			infoPanel.add(searchButton);	
			rs.setBounds(150, 220, 120, 30);
			infoPanel.add(rs);
			add(infoPanel,BorderLayout.CENTER);
			
	
			
			ButtonAction buttonAction = new ButtonAction();
			lookPButton.addActionListener(buttonAction);
			upPButton.addActionListener(buttonAction);
			lookSButton.addActionListener(buttonAction);
			searchCheckButton.addActionListener(buttonAction);
			checkInButton.addActionListener(buttonAction);
			upCheckButton.addActionListener(buttonAction);
			upPwdButton.addActionListener(buttonAction);
			searchButton.addActionListener(buttonAction);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TchFuncPortalFrame frame = new TchFuncPortalFrame("学生考勤系统");
	}
}

