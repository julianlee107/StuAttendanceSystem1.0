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
		UpdateTchPwdPanel loginPanel = new UpdateTchPwdPanel(); 
		setContentPane(loginPanel); 
		//���ô���������ʾ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setVisible(true);
		setResizable(false);
	}
	
	private class UpdateTchPwdPanel extends JPanel {
		//�����½����Panel�еĿؼ�Ԫ�ء�
		JLabel topTitleLabel,oldPwdLabel,newPwdLabel,rePwdLabel;
		JTextField oldPwd,newPwd,rePwd;
		JButton okButton,backButton; 
		JPanel buttonPanel,infoPanel; 
		//��½����panel���죬�����пؼ�Ԫ��װ��������
		private class ButtonAction implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e){
				if(e.getSource().equals(okButton)){
					EventQueue.invokeLater(new Runnable(){
						public void run(){
							TchFuncPortalFrame frame = new TchFuncPortalFrame("ѧ����½���");
						}
					});
					UpdateTchPwdFrame.this.dispose();
				}else{
					EventQueue.invokeLater(new Runnable(){
						public void run(){
							TchFuncPortalFrame frame = new TchFuncPortalFrame("�̹���½���");
						}
					});
					UpdateTchPwdFrame.this.dispose();
					}
			}
		}
		
		public UpdateTchPwdPanel() { 
			//�������пؼ�����
			String t1 = "�޸�����";
			topTitleLabel = new JLabel(t1);
			String t2 = "��ǰ����";
			oldPwdLabel = new JLabel(t2);
			String t3 = "������";
			newPwdLabel = new JLabel(t3);
			String t4 = "ȷ������";
			rePwdLabel = new JLabel(t4);
			oldPwd = new JTextField();
			newPwd = new JTextField();
			rePwd = new JTextField();
			
			okButton = new JButton("ȷ���޸�");
			backButton = new JButton("�����ϼ�"); 
			buttonPanel = new JPanel();
			infoPanel = new JPanel();
			
			//����StuLoginPanel����ΪBorderLayout��
			setLayout(new BorderLayout()); 
			//�������pic��login��Ϣ�ؼ������������ 
			//������infoPanel���ֹ�����ΪFlowLayout��
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
		UpdateTchPwdFrame frame = new UpdateTchPwdFrame("��½������");
	}
}
