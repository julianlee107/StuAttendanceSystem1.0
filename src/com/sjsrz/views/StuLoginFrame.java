package com.sjsrz.views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.sjsrz.dao.StudentEntityDAO;
import com.sjsrz.dao.impl.StudentEntityDAOImpl;


public class StuLoginFrame extends JFrame{
	JFrame parentFrame;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 300;
	
	public StuLoginFrame(String title) { 
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
		StuLoginPanel loginPanel = new StuLoginPanel(); setContentPane(loginPanel); 
		//设置窗口其他显示属性
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setVisible(true);
		setResizable(false);
	}
	
	private class StuLoginPanel extends JPanel {
		//定义登陆容器Panel中的控件元素。
		JLabel picLabel; 
		JLabel idLabel, pwdLabel; 
		JTextField stuIdTextField;
		JPasswordField pwdField; 
		JButton okButton,clearButton; 
		JPanel buttonPanel,infoPanel; 

		private class ButtonAction implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				if(e.getSource().equals(okButton)){
					if(stuIdTextField.getText().trim().equals(""))
					{
						JOptionPane.showMessageDialog(null,"学生id信息不能为空！","警告", JOptionPane.ERROR_MESSAGE);
						stuIdTextField.setText("");
					}
					else if(new String(pwdField.getPassword()).equals(""))
					{
						JOptionPane.showMessageDialog(null,"学生密码不能为空！","警告", JOptionPane.ERROR_MESSAGE);
						pwdField.setText("");
					}
					
					else 
					{
						EventQueue.invokeLater(new Runnable(){
							public void run(){
								String stuName = null;
								StudentEntityDAO stuEntity = new StudentEntityDAOImpl();
								if((stuName = stuEntity.login(Integer.parseInt(stuIdTextField.getText().trim()),new String(pwdField.getPassword())))!=null)
								{
									StuFuncPortalFrame frame = new StuFuncPortalFrame("欢迎学生"+stuName+"登陆考勤系统！");
									frame.parentFrame = StuLoginFrame.this;
									StuLoginFrame.this.setVisible(false);
								}else{
									JOptionPane.showMessageDialog(null,"请重新输入密码！","密码错误", JOptionPane.ERROR_MESSAGE);
									pwdField.setText("");
								}
							}
						});
					}
				}else{
					stuIdTextField.setText("");
					pwdField.setText("");
				}
			}
		}
	
		//登陆容器panel构造，将所有控件元素装入容器。
		public StuLoginPanel() { 
			//生成所有控件对象
			picLabel = new JLabel();
			idLabel = new JLabel("学生ID："); 
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
			add(infoPanel,BorderLayout.CENTER); 
			//依次添加按钮控件到面板容器，buttonPanel布局管理器默认流布局， 
			//并将buttonPanel控件作为StuLoginPanel的底端组件。
			buttonPanel.add(okButton); 
			buttonPanel.add(clearButton); 
			add(buttonPanel,BorderLayout.SOUTH);
			
			ButtonAction buttonAction = new ButtonAction();
			okButton.addActionListener(buttonAction);
			clearButton.addActionListener(buttonAction);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StuLoginFrame frame = new StuLoginFrame("学生登陆窗口");
	}

}
