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
		StuLoginPanel loginPanel = new StuLoginPanel(); setContentPane(loginPanel); 
		//���ô���������ʾ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setVisible(true);
		setResizable(false);
	}
	
	private class StuLoginPanel extends JPanel {
		//�����½����Panel�еĿؼ�Ԫ�ء�
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
						JOptionPane.showMessageDialog(null,"ѧ��id��Ϣ����Ϊ�գ�","����", JOptionPane.ERROR_MESSAGE);
						stuIdTextField.setText("");
					}
					else if(new String(pwdField.getPassword()).equals(""))
					{
						JOptionPane.showMessageDialog(null,"ѧ�����벻��Ϊ�գ�","����", JOptionPane.ERROR_MESSAGE);
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
									StuFuncPortalFrame frame = new StuFuncPortalFrame("��ӭѧ��"+stuName+"��½����ϵͳ��");
									frame.parentFrame = StuLoginFrame.this;
									StuLoginFrame.this.setVisible(false);
								}else{
									JOptionPane.showMessageDialog(null,"�������������룡","�������", JOptionPane.ERROR_MESSAGE);
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
	
		//��½����panel���죬�����пؼ�Ԫ��װ��������
		public StuLoginPanel() { 
			//�������пؼ�����
			picLabel = new JLabel();
			idLabel = new JLabel("ѧ��ID��"); 
			//����������Ϊ��ǩ��ʾ�ı�
			pwdLabel = new JLabel("���룺"); 
			//����������Ϊ��ǩ��ʾ�ı�
			stuIdTextField = new JTextField(20); 
			pwdField = new JPasswordField(20);
			okButton = new JButton("��½");
			//����������Ϊ��ť��ʾ�ı�
			clearButton = new JButton("�����Ϣ"); 
			buttonPanel = new JPanel();
			infoPanel = new JPanel();
			
			//����StuLoginPanel����ΪBorderLayout��
			setLayout(new BorderLayout()); 
			//�������pic��login��Ϣ�ؼ������������ 
			//������infoPanel���ֹ�����ΪFlowLayout��
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
			//������Ӱ�ť�ؼ������������buttonPanel���ֹ�����Ĭ�������֣� 
			//����buttonPanel�ؼ���ΪStuLoginPanel�ĵ׶������
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
		StuLoginFrame frame = new StuLoginFrame("ѧ����½����");
	}

}
