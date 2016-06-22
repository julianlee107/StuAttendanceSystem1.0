package com.sjsrz.views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class UpdateTchPerFrame extends JFrame{
	JFrame parentFrame;
	private JPanel contentPane;
	private static final int DEFAULT_WIDTH = 500;
	private static final int DEFAULT_HEIGHT = 450;
	
	public UpdateTchPerFrame(String title) { 
		//���ô����С
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT); 
		//���ô������
		setTitle(title); 
		//��ʾλ������Ļ���ȺͿ��ȵ�1/3����
		Toolkit kit = Toolkit.getDefaultToolkit(); 
		Dimension screenSize = kit.getScreenSize(); 
		int screenWidthpx = screenSize.width;
		int screenHeightpx = screenSize.height; 
		setLocation(screenWidthpx / 3, screenHeightpx / 3); 
		setLocationByPlatform(false); 
		//���ô�����С��ʱ��ʾ��ͼ�꣬��ѡ��
		Image img = new ImageIcon(this.getClass(). getResource("/images/001.jpg")).getImage(); 
		setIconImage(img);
		//���ô����������壬�������������е���ЧGUI�����Ϣ
		UpdateTchPerPanel loginPanel = new UpdateTchPerPanel(); 
		setContentPane(loginPanel); 
		//���ô���������ʾ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setVisible(true);
		setResizable(false);
	}
	
	private class UpdateTchPerPanel extends JPanel {
		//�����½����Panel�еĿؼ�Ԫ�ء�
		JLabel picLabel,idLabel,nameLabel,academicLabel,majorLabel,emailLabel,pPicLabel;
		JLabel name,id,academic,major,email;
		JTextField upEmail;
		JButton updatePButton,updateEButton,backButton; 
		JPanel buttonPanel,infoPanel; 
		//��½����panel���죬�����пؼ�Ԫ��װ��������
		private class ButtonAction implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e){
				if(e.getSource().equals(backButton)){
					EventQueue.invokeLater(new Runnable(){
						public void run(){
							StuFuncPortalFrame frame = new StuFuncPortalFrame("ѧ����½���");
						}
					});
					UpdateTchPerFrame.this.dispose();
				}else if(e.getSource().equals(updateEButton)){
					EventQueue.invokeLater(new Runnable(){
						public void run(){
							UpdateStuPerFrame frame = new UpdateStuPerFrame("�̹���½���");
						}
					});
					UpdateTchPerFrame.this.dispose();
					}
			}
		}
		
		public UpdateTchPerPanel() { 
			//�������пؼ�����
			picLabel = new JLabel();
			String t1 = "����";
			nameLabel = new JLabel(t1);
			String t2 = "����";
			name = new JLabel(t2);
			String t3 = "ѧ��";
			idLabel = new JLabel(t3);
			String t4 = "1234214";
			id = new JLabel(t4);
			String t5 = "����ѧԺ";
			academicLabel = new JLabel(t5);
			String t6 = "����";
			academic = new JLabel(t6);
			String t7 = "רҵ";
			majorLabel = new JLabel(t7);
			String t8 = "Ӣ��";
			major = new JLabel(t8);
			String t9 = "��������";
			emailLabel = new JLabel(t9);
			String t10 = "ccc@qqq.com";
			upEmail = new JTextField(t10);
			String t11 = "������Ƭ";
			pPicLabel = new JLabel(t11);
			updatePButton = new JButton("�޸ĸ�����Ƭ");
			updateEButton = new JButton("�޸ĸ�������");
			backButton = new JButton("�����ϼ��˵�");
			
			buttonPanel = new JPanel();
			infoPanel = new JPanel();
			
			//����StuLoginPanel����ΪBorderLayout��
			setLayout(new BorderLayout()); 
			//��������pic��login��Ϣ�ؼ������������ 
			//������infoPanel���ֹ�����ΪFlowLayout��
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
			infoPanel.add(upEmail);
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
		UpdateTchPerFrame frame = new UpdateTchPerFrame("ѧ������ϵͳ");
	}
}