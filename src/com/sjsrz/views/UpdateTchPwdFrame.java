package com.sjsrz.views;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateTchPwdFrame extends JFrame{
	JFrame parentFrame;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 300;
	
	public UpdateTchPwdFrame(String title) { 
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
		UpdateTchPwdPanel loginPanel = new UpdateTchPwdPanel(); 
		setContentPane(loginPanel); 
		//设置窗口其他显示属性
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setVisible(true);
		setResizable(false);
	}
	
	private class UpdateTchPwdPanel extends JPanel {
		//定义登陆容器Panel中的控件元素。
		JLabel topTitleLabel,oldPwdLabel,newPwdLabel,rePwdLabel;
		JTextField oldPwd,newPwd,rePwd;
		JButton okButton,backButton; 
		JPanel buttonPanel,infoPanel; 
		//登陆容器panel构造，将所有控件元素装入容器。
		private class ButtonAction implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e){
				if(e.getSource().equals(okButton)){
					EventQueue.invokeLater(new Runnable(){
						public void run(){
							TchFuncPortalFrame frame = new TchFuncPortalFrame("学生登陆入口");
						}
					});
					UpdateTchPwdFrame.this.dispose();
				}else{
					EventQueue.invokeLater(new Runnable(){
						public void run(){
							TchFuncPortalFrame frame = new TchFuncPortalFrame("教工登陆入口");
						}
					});
					UpdateTchPwdFrame.this.dispose();
					}
			}
		}
		
		public UpdateTchPwdPanel() { 
			//生成所有控件对象
			String t1 = "修改密码";
			topTitleLabel = new JLabel(t1);
			String t2 = "当前密码";
			oldPwdLabel = new JLabel(t2);
			String t3 = "新密码";
			newPwdLabel = new JLabel(t3);
			String t4 = "确认密码";
			rePwdLabel = new JLabel(t4);
			oldPwd = new JTextField();
			newPwd = new JTextField();
			rePwd = new JTextField();
			
			okButton = new JButton("确认修改");
			backButton = new JButton("返回上级"); 
			buttonPanel = new JPanel();
			infoPanel = new JPanel();
			
			//设置StuLoginPanel布局为BorderLayout。
			setLayout(new BorderLayout()); 
			//依次添加pic、login信息控件到面板容器， 
			//并设置infoPanel布局管理器为FlowLayout。
			infoPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); 
			infoPanel.add(topTitleLabel);
			infoPanel.add(oldPwdLabel); 
			infoPanel.add(oldPwd); 
			infoPanel.add(newPwdLabel); 
			infoPanel.add(newPwd); 
			infoPanel.add(rePwdLabel); 
			infoPanel.add(rePwd); 
			infoPanel.add(okButton); 
			infoPanel.add(backButton); 
			add(infoPanel,BorderLayout.CENTER);
			
			ButtonAction buttonAction = new ButtonAction();
			okButton.addActionListener(buttonAction);
			backButton.addActionListener(buttonAction);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UpdateTchPwdFrame frame = new UpdateTchPwdFrame("登陆主窗口");
	}
}
