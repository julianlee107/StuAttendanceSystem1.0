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
		//���ô����С
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT); 
		//���ô������
		setTitle(title); 
		//��ʾλ������Ļ���ȺͿ�ȵ�1/3����
		Toolkit kit = Toolkit.getDefaultToolkit(); 
		Dimension screenSize = kit.getScreenSize(); 
		int screenWidthpx = screenSize.width;
		int screenHeightpx = screenSize.height; 
		setLocation(screenWidthpx / 3, screenHeightpx / 3); 
		setLocationByPlatform(false); 
		//���ô�����С��ʱ��ʾ��ͼ�꣬��ѡ��
		Image img = new ImageIcon(this.getClass(). getResource("/images/001.jpg")).getImage(); setIconImage(img);
		//���ô����������壬�������������е���ЧGUI�����Ϣ
		CheckInPanel loginPanel = new CheckInPanel(); 
		setContentPane(loginPanel); 
		//���ô���������ʾ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setVisible(true);
		setResizable(false);
	}
	
	private class CheckInPanel extends JPanel {
		//�����½����Panel�еĿؼ�Ԫ�ء�
		JLabel picLabel,titleQLabel,titleWLabel,titleELabel,titleRLabel,titleTLabel,titleYLabel;
		JTextField lessonName,stuName,time;
		JButton backButton,okButton;
		JComboBox<String> classBox,idBox,styleBox;
		JPanel buttonPanel,infoPanel; 
		//��½����panel���죬�����пؼ�Ԫ��װ��������
		private class ButtonAction implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e){
				if(e.getSource().equals(backButton)){
					EventQueue.invokeLater(new Runnable(){
						public void run(){
							TchFuncPortalFrame frame = new TchFuncPortalFrame("ѧ����½���");
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
						JOptionPane.showMessageDialog(null,"���ڼ�¼¼��ɹ���","��ϲ", JOptionPane.ERROR_MESSAGE);
					}else{
						JOptionPane.showMessageDialog(null,"�޷�¼�뿼�ڼ�¼����͹���Ա��ϵ��","����", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}
		
		public CheckInPanel() { 
			//�������пؼ�����
			String t1 = "��ѧ��ţ�";
			titleQLabel = new JLabel(t1);
			classBox = new JComboBox<>();
			classBox.addItem("1301401");
			classBox.addItem("1301402");
			String t2 = "�γ����ƣ�";
			titleWLabel = new JLabel(t2);
			String t3 = "Java";
			lessonName = new JTextField(t3);
			String t4 = "ѧ��ID��";
			titleELabel = new JLabel(t4);
			idBox = new JComboBox<>();
			idBox.addItem("1301401");
			idBox.addItem("1301402");
			String t5 = "ѧ��������";
			titleRLabel = new JLabel(t5);
			String t6 = "AXX";
			stuName = new JTextField(t6);
			String t7 = "����ʱ�䣺";
			titleTLabel = new JLabel(t7);
			String t8 = "10��20";
			time = new JTextField(t8);
			String t9 = "���ڼ�¼��";
			titleYLabel = new JLabel(t9);
			styleBox = new JComboBox<>();
			styleBox.addItem("����");
			styleBox.addItem("�ٵ�");
			
			okButton = new JButton("¼����Ϣ");
			backButton = new JButton("�����ϼ�"); 
			buttonPanel = new JPanel();
			infoPanel = new JPanel();
			
			//����StuLoginPanel����ΪBorderLayout��
			setLayout(new BorderLayout()); 
			//�������pic��login��Ϣ�ؼ������������ 
			//������infoPanel���ֹ�����ΪFlowLayout��
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
		CheckInFrame frame = new CheckInFrame("��½������");
	}
}
