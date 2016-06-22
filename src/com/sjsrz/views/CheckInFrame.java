package com.sjsrz.views;

import javax.swing.*;

import com.sjsrz.bean.AttendanceEntity;
import com.sjsrz.dao.AttendanceEntityDAO;
import com.sjsrz.dao.impl.AttendanceEntityDAOImpl;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckInFrame extends JFrame{
	JFrame parentFrame;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 300;
	
	public CheckInFrame(String title) { 
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
		CheckInPanel loginPanel = new CheckInPanel(); 
		setContentPane(loginPanel); 
		//设置窗口其他显示属性
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setVisible(true);
		setResizable(false);
	}
	
	private class CheckInPanel extends JPanel {
		//定义登陆容器Panel中的控件元素。
		JLabel picLabel,titleQLabel,titleWLabel,titleELabel,titleRLabel,titleTLabel,titleYLabel;
		JTextField lessonName,stuName,time;
		JButton backButton,okButton;
		JComboBox<String> classBox,idBox,styleBox;
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
					CheckInFrame.this.dispose();
				}else {
					AttendanceEntity attRecord = new AttendanceEntity();
					attRecord.setClass_id();
					attRecord.setStudent_Id(Integer.parseInt(classCombo.getItemAt(classCombo.getSelectedIndex())));
					attRecord.setAttendance_status(attRecordCombo.getItemAt(attRecordCombo.getSelectedIndex()));
					attRecord.setAttendance_date(attTimeTextField.getText());
					
					AttendanceEntityDAO attEntity = new AttendanceEntityDAOImpl();
					if((attEntity.insertAttendanceEntity(attRecord))>0){
						JOptionPane.showMessageDialog(null,"考勤记录录入成功！","恭喜", JOptionPane.ERROR_MESSAGE);
					}else{
						JOptionPane.showMessageDialog(null,"无法录入考勤记录，请和管理员联系！","警告", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}
		
		public CheckInPanel() { 
			//生成所有控件对象
			String t1 = "教学班号：";
			titleQLabel = new JLabel(t1);
			classBox = new JComboBox<>();
			classBox.addItem("1301401");
			classBox.addItem("1301402");
			String t2 = "课程名称：";
			titleWLabel = new JLabel(t2);
			String t3 = "Java";
			lessonName = new JTextField(t3);
			String t4 = "学生ID：";
			titleELabel = new JLabel(t4);
			idBox = new JComboBox<>();
			idBox.addItem("1301401");
			idBox.addItem("1301402");
			String t5 = "学生姓名：";
			titleRLabel = new JLabel(t5);
			String t6 = "AXX";
			stuName = new JTextField(t6);
			String t7 = "考勤时间：";
			titleTLabel = new JLabel(t7);
			String t8 = "10：20";
			time = new JTextField(t8);
			String t9 = "考勤记录：";
			titleYLabel = new JLabel(t9);
			styleBox = new JComboBox<>();
			styleBox.addItem("正常");
			styleBox.addItem("迟到");
			
			okButton = new JButton("录入信息");
			backButton = new JButton("返回上级"); 
			buttonPanel = new JPanel();
			infoPanel = new JPanel();
			
			//设置StuLoginPanel布局为BorderLayout。
			setLayout(new BorderLayout()); 
			//依次添加pic、login信息控件到面板容器， 
			//并设置infoPanel布局管理器为FlowLayout。
			infoPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); 
			infoPanel.add(titleQLabel); 
			infoPanel.add(classBox); 
			infoPanel.add(titleWLabel); 
			infoPanel.add(lessonName); 
			infoPanel.add(titleELabel); 
			infoPanel.add(idBox); 
			infoPanel.add(titleRLabel); 
			infoPanel.add(stuName); 
			infoPanel.add(titleTLabel); 
			infoPanel.add(time); 
			infoPanel.add(titleYLabel); 
			infoPanel.add(styleBox); 
			infoPanel.add(okButton); 
			infoPanel.add(backButton); 
			add(infoPanel,BorderLayout.CENTER);
			
			ButtonAction buttonAction = new ButtonAction();
			backButton.addActionListener(buttonAction);
			okButton.addActionListener(buttonAction);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CheckInFrame frame = new CheckInFrame("登陆主窗口");
	}
}
