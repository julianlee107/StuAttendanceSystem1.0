package com.sjsrz.views;

import javax.swing.*;

import com.sjsrz.bean.AttendanceEntity;
import com.sjsrz.bean.StudentEntity;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class StuPersonFrame extends JFrame{
	JFrame parentFrame;
	private JPanel contentPane;
	private static final int DEFAULT_WIDTH = 500;
	private static final int DEFAULT_HEIGHT = 450;
	
	public StuPersonFrame(String title) { 
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
		StuPersonPanel loginPanel = new StuPersonPanel(); 
		setContentPane(loginPanel); 
		//设置窗口其他显示属性
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setVisible(true);
		setResizable(false);
	}
	
	private class StuPersonPanel extends JPanel {
		//定义登陆容器Panel中的控件元素。
		JLabel picLabel,idLabel,nameLabel,academicLabel,majorLabel,emailLabel,pPicLabel;
		JLabel name,id,academic,major,email;
		JButton updatePButton,updateEButton,backButton; 
		JPanel buttonPanel,infoPanel; 
		//登陆容器panel构造，将所有控件元素装入容器。
		private class ButtonAction implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e){
				if(e.getSource().equals(backButton)){
					EventQueue.invokeLater(new Runnable(){
						public void run(){
							StuFuncPortalFrame frame = new StuFuncPortalFrame("学生登陆入口");
						}
					});
					StuPersonFrame.this.dispose();
				}else if(e.getSource().equals(updateEButton)){
					EventQueue.invokeLater(new Runnable(){
						public void run(){
							UpdateStuPerFrame frame = new UpdateStuPerFrame("教工登陆入口");
						}
					});
					StuPersonFrame.this.dispose();
					}
			}
		}
		
		public StuPersonPanel() { 
			//生成所有控件对象
			StudentEntity stuRecord = new StudentEntity();
			
			picLabel = new JLabel();
			String t1 = "姓名";
			nameLabel = new JLabel(t1);
			String t2 = stuRecord.getStudent_name();
			name = new JLabel(t2);
			String t3 = "学号";
			idLabel = new JLabel(t3);
			int t4 = stuRecord.getStudent_id();
			id = new JLabel(t4);
			String t5 = "所属学院";
			academicLabel = new JLabel(t5);
			String t6 = stuRecord.getStudent_college();
			academic = new JLabel(t6);
			String t7 = "专业";
			majorLabel = new JLabel(t7);
			String t8 = stuRecord.getStudent_major();
			major = new JLabel(t8);
			String t9 = "电子邮箱";
			emailLabel = new JLabel(t9);
			String t10 = stuRecord.getStudent_email();
			email = new JLabel(t10);
			String t11 = "个人照片";
			pPicLabel = new JLabel(t11);
			updatePButton = new JButton("修改个人照片");
			updateEButton = new JButton("修改个人信箱");
			backButton = new JButton("返回上级菜单");
			
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
			//picLabel.setBounds(150, 20, 100, 100);
			infoPanel.add(picLabel);
			//idLabel.setBounds(150, 140, 120, 30);
			infoPanel.add(nameLabel);
			infoPanel.add(name);
			//lookPButton.setBounds(150, 160, 120, 30);
			infoPanel.add(idLabel);	
			infoPanel.add(id);
			//upPButton.setBounds(150, 80, 120, 30);
			infoPanel.add(academicLabel);
			infoPanel.add(academic);
			//upPwdButton.setBounds(150, 100, 120, 30);
			infoPanel.add(majorLabel);
			infoPanel.add(major);
			//lookTButton.setBounds(150, 120, 120, 30);
			infoPanel.add(emailLabel);
			infoPanel.add(email);
			//lookLButton.setBounds(150, 140, 120, 30);
			infoPanel.add(pPicLabel);
			//wordT.setBounds(150, 160, 120, 30);
			infoPanel.add(updatePButton);
			//lessonId.setBounds(150, 180, 120, 30);
			infoPanel.add(updateEButton);
			//searchButton.setBounds(150, 200, 120, 30);
			infoPanel.add(backButton);	
			//rs.setBounds(150, 220, 120, 30);
			add(infoPanel,BorderLayout.CENTER);
			
			//ButtonAction buttonAction = new ButtonAction();
			ButtonAction buttonAction = new ButtonAction();
			backButton.addActionListener(buttonAction);
			updatePButton.addActionListener(buttonAction);
			updateEButton.addActionListener(buttonAction);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StuPersonFrame frame = new StuPersonFrame("学生考勤系统");
	}
	
}
