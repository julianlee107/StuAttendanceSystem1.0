package com.sjsrz.views;

import javax.swing.*;
import java.awt.*;

public class TchLoginFrame extends JFrame {
	JFrame parentFrame;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 300;
	JCheckBox adminCheckBox;
	
	public TchLoginFrame(String title) { 
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
		TchLoginPanel loginPanel = new TchLoginPanel(); setContentPane(loginPanel); 
		//���ô���������ʾ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setVisible(true);
		setResizable(false);
	}
		
	private class TchLoginPanel extends JPanel {
		//�����½����Panel�еĿؼ�Ԫ�ء�
		JLabel picLabel; 
		JLabel idLabel, pwdLabel; 
		JTextField stuIdTextField;
		JPasswordField pwdField; 
		JButton okButton,clearButton; 
		JPanel buttonPanel,infoPanel; 
		//��½����panel���죬�����пؼ�Ԫ��װ��������
		public TchLoginPanel() { 
			//�������пؼ�����
			picLabel = new JLabel();
			idLabel = new JLabel("�̹�ID��"); 
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
			adminCheckBox = new JCheckBox("���ǹ���Ա");
			
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
			infoPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
			infoPanel.add(adminCheckBox);
			add(infoPanel,BorderLayout.CENTER);
			
			//������Ӱ�ť�ؼ������������buttonPanel���ֹ�����Ĭ�������֣� 
			//����buttonPanel�ؼ���ΪStuLoginPanel�ĵ׶������
			buttonPanel.add(okButton); 
			buttonPanel.add(clearButton); 
			add(buttonPanel,BorderLayout.SOUTH);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TchLoginFrame frame = new TchLoginFrame("��ʦ��½����");
	}

}
