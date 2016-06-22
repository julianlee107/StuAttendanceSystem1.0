package com.sjsrz.views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class test extends JFrame{
	JFrame parentFrame;
	private JPanel contentPane;
	private static final int DEFAULT_WIDTH = 500;
	private static final int DEFAULT_HEIGHT = 450;
	
	public test(String title) { 
		Toolkit kit = Toolkit.getDefaultToolkit(); 
		Dimension screenSize = kit.getScreenSize(); 
		int screenWidthpx = screenSize.width;
		int screenHeightpx = screenSize.height; 
		setBounds(screenWidthpx / 3, screenHeightpx / 3, DEFAULT_WIDTH, DEFAULT_HEIGHT);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//设置窗体标题
		setTitle(title); 
		//设置窗口最小化时显示的图标，可选。
		//Image img = new ImageIcon(this.getClass(). getResource("/images/001.jpg")).getImage(); 
		//setIconImage(img);
		//设置窗体的内容面板，该面板包含了所有的有效GUI组件信息
		testPanel loginPanel = new testPanel(); 
		//setContentPane(loginPanel); 
		//设置窗口其他显示属性
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setVisible(true);
		setResizable(false);
	}

	private class testPanel extends JPanel{
		//定义登陆容器Panel中的控件元素。
		JLabel picLabel,idLabel,wordT; 
		JButton lookPButton,upPButton,upPwdButton,lookTButton,lookLButton,searchButton; 
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
							StuPersonFrame frame = new StuPersonFrame("学生登陆入口");
						}
					});
					test.this.dispose();
				}else if(e.getSource().equals(upPwdButton)){
					EventQueue.invokeLater(new Runnable(){
						public void run(){
							UpdateStuPwdFrame frame = new UpdateStuPwdFrame("教工登陆入口");
						}
					});
					test.this.dispose();
					}else if(e.getSource().equals(upPButton)){
					EventQueue.invokeLater(new Runnable(){
						public void run(){
							UpdateStuPerFrame frame = new UpdateStuPerFrame("教工登陆入口");
						}
					});
					test.this.dispose();
					}else if(e.getSource().equals(lookTButton)){
						EventQueue.invokeLater(new Runnable(){
							public void run(){
								SearchTchFrame frame = new SearchTchFrame("教工登陆入口");
							}
						});
						test.this.dispose();
						}else if(e.getSource().equals(lookLButton)){
							EventQueue.invokeLater(new Runnable(){
								public void run(){
									SearchLessonFrame frame = new SearchLessonFrame("教工登陆入口");
								}
							});
							test.this.dispose();
							}else if(e.getSource().equals(searchButton)){
								EventQueue.invokeLater(new Runnable(){
									public void run(){
										
									}
								});
								}
			}
		}
		
		public testPanel() { 
			//生成所有控件对象
			picLabel = new JLabel();
			String t1 = "ee";
			idLabel = new JLabel(t1);
			String t2 = "请输入要查询考勤记录的课程编号:";
			wordT = new JLabel(t2);
			lookPButton = new JButton("查看个人信息");
			upPButton = new JButton("修改个人信息");
			upPwdButton = new JButton("修改个人密码");
			lookTButton = new JButton("查看教师信息");
			lookLButton = new JButton("查看课程信息");
			searchButton = new JButton("查找");
			lessonId = new JTextField();
			rs = new JTable();
			
			
			idLabel.setBounds(20, 140, 120, 30);
			contentPane.add(idLabel);
			lookPButton.setBounds(20, 180, 100, 20);
			contentPane.add(lookPButton);			
			upPButton.setBounds(20, 210, 100, 20);
			contentPane.add(upPButton);
			upPwdButton.setBounds(20, 240, 100, 20);
			contentPane.add(upPwdButton);
			lookTButton.setBounds(20, 270, 100, 20);
			contentPane.add(lookTButton);
			lookLButton.setBounds(20, 300, 100, 20);
			contentPane.add(lookLButton);
			wordT.setBounds(150, 20, 100, 20);
			contentPane.add(wordT);
			lessonId.setBounds(150, 50, 100, 20);
			contentPane.add(lessonId);
			searchButton.setBounds(270, 50, 100, 20);
			contentPane.add(searchButton);	
			rs.setBounds(150, 80, 100, 20);
			contentPane.add(rs);
			
			ButtonAction buttonAction = new ButtonAction();
			lookPButton.addActionListener(buttonAction);
			upPButton.addActionListener(buttonAction);
			lookTButton.addActionListener(buttonAction);
			lookLButton.addActionListener(buttonAction);
			upPwdButton.addActionListener(buttonAction);
			searchButton.addActionListener(buttonAction);
		}
	}
		
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test frame = new test("学生考勤系统");
	}

}
